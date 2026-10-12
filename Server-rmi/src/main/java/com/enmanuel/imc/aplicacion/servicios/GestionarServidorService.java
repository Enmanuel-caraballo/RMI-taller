package com.enmanuel.imc.aplicacion.servicios;
import com.enmanuel.imc.aplicacion.excepciones.ServidorRedException;
import com.enmanuel.imc.aplicacion.puertos.entrada.GestionarServidorInputPort;
import com.enmanuel.imc.dominio.enums.EstadoServidor;
import com.enmanuel.imc.dominio.modelos.EventoServidor;
import com.enmanuel.imc.dominio.puertos.salida.ControladorServidorRedPort;
import com.enmanuel.imc.dominio.puertos.salida.PuertoNotificacionEvento;
public final class GestionarServidorService implements GestionarServidorInputPort {
    private final ControladorServidorRedPort controlador;
    private final PuertoNotificacionEvento notificador;
    public GestionarServidorService(ControladorServidorRedPort controlador, PuertoNotificacionEvento notificador) { this.controlador = controlador; this.notificador = notificador; }
    @Override public void iniciarServidor(int puerto) throws ServidorRedException { try { controlador.iniciar(puerto); notificador.notificarCambioEstado(EstadoServidor.EN_LINEA, puerto); notificador.notificarEvento(new EventoServidor("SERVICIO", "LOCAL:" + puerto, "Servidor RMI iniciado en el puerto " + puerto + ".")); } catch (Exception excepcion) { throw new ServidorRedException("No se pudo abrir el servidor RMI.", excepcion); } }
    @Override public void detenerServidor() { controlador.detener(); notificador.notificarCambioEstado(EstadoServidor.DETENIDO, 0); notificador.notificarEvento(new EventoServidor("SERVICIO", "LOCAL", "Servidor RMI detenido por el usuario.")); }
    @Override public boolean estaCorriendo() { return controlador.isActivo(); }
    @Override public int getPuertoActual() { return controlador.getPuertoActual(); }
}
