package com.enmanuel.imc.adaptadores.rmi;
import com.enmanuel.imc.dominio.puertos.salida.ClienteRmiPort;
import com.enmanuel.imc.remoto.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public final class AdaptadorClienteRmi implements ClienteRmiPort {
    private PresupuestoRemote remoto;
    @Override public synchronized String conectar(String host, int puerto, String cliente) throws Exception { Registry registro = LocateRegistry.getRegistry(host, puerto); remoto = (PresupuestoRemote) registro.lookup("PresupuestoService"); return remoto.conectar(cliente); }
    @Override public synchronized RespuestaPresupuesto calcular(double ingresos, double egresos) throws Exception { if (remoto == null) throw new IllegalStateException("El cliente no esta conectado."); return remoto.calcular(ingresos, egresos); }
    @Override public synchronized String desconectar(String cliente) throws Exception { if (remoto == null) return "Ya estaba desconectado."; try { return remoto.desconectar(cliente); } finally { remoto = null; } }
}
