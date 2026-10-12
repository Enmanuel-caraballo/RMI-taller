package com.enmanuel.imc.aplicacion.servicios;
import com.enmanuel.imc.aplicacion.dto.*;
import com.enmanuel.imc.aplicacion.mapper.ClienteMapper;
import com.enmanuel.imc.aplicacion.puertos.entrada.*;
import com.enmanuel.imc.dominio.modelos.ResultadoPresupuesto;
import com.enmanuel.imc.dominio.puertos.salida.ClienteRmiPort;
public final class ClientePresupuestoService implements GestionarConexionInputPort, CalcularPresupuestoInputPort {
    private final ClienteRmiPort clienteRmi;
    private final ClienteMapper mapper;
    private String nombre;
    public ClientePresupuestoService(ClienteRmiPort clienteRmi, ClienteMapper mapper) { this.clienteRmi = clienteRmi; this.mapper = mapper; }
    @Override public void conectar(ConectarCommand comando) throws ClienteException { try { nombre = comando.cliente(); clienteRmi.conectar(comando.host(), comando.puerto(), nombre); } catch (Exception excepcion) { throw new ClienteException("No se pudo conectar con el servidor RMI.", excepcion); } }
    @Override public void desconectar() { try { if (estaConectado()) clienteRmi.desconectar(nombre); } catch (Exception ignored) { } nombre = null; }
    @Override public boolean estaConectado() { return nombre != null; }
    @Override public ResultadoPresupuesto calcular(CalcularPresupuestoCommand comando) throws ClienteException { if (!estaConectado()) throw new ClienteException("El cliente no esta conectado."); try { var datos = mapper.toDomain(comando); return mapper.toDomain(clienteRmi.calcular(datos.ingresos().valor(), datos.egresos().valor())); } catch (Exception excepcion) { throw new ClienteException("No se pudo obtener la respuesta RMI.", excepcion); } }
}
