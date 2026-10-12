package com.enmanuel.imc.adaptadores.rmi;
import com.enmanuel.imc.dominio.puertos.salida.ControladorServidorRedPort;
public final class AdaptadorControlServidorRmi implements ControladorServidorRedPort {
    private RmiServer servidor;
    @Override public synchronized void iniciar(int puerto) throws Exception { if (isActivo()) return; servidor = new RmiServer(puerto); servidor.iniciar(); }
    @Override public synchronized void detener() { if (servidor != null) servidor.detener(); servidor = null; }
    @Override public synchronized boolean isActivo() { return servidor != null && servidor.isActivo(); }
    @Override public synchronized int getPuertoActual() { return servidor == null ? 0 : servidor.getPuerto(); }
}
