package com.enmanuel.imc.adaptadores.rmi;
import com.enmanuel.imc.aplicacion.dto.CalcularPresupuestoCommand;
import com.enmanuel.imc.aplicacion.mapper.CalculoMapper;
import com.enmanuel.imc.aplicacion.servicios.CalcularPresupuestoService;
import com.enmanuel.imc.remoto.PresupuestoRemote;
import com.enmanuel.imc.remoto.RespuestaPresupuesto;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/** Registro RMI y objeto remoto del servidor. */
public final class RmiServer implements AutoCloseable {
    public static final String NOMBRE_SERVICIO = "PresupuestoService";
    private final int puerto;
    private Registry registro;
    private PresupuestoRemoteImpl remoto;
    public RmiServer(int puerto) { this.puerto = puerto; }
    public synchronized void iniciar() throws RemoteException {
        if (isActivo()) return;
        registro = LocateRegistry.createRegistry(puerto);
        remoto = new PresupuestoRemoteImpl();
        try { registro.bind(NOMBRE_SERVICIO, remoto); }
        catch (AlreadyBoundException excepcion) { throw new RemoteException("El servicio RMI ya esta registrado.", excepcion); }
    }
    public synchronized void detener() {
        if (registro == null) return;
        try { registro.unbind(NOMBRE_SERVICIO); } catch (Exception ignored) { }
        try { if (remoto != null) UnicastRemoteObject.unexportObject(remoto, true); UnicastRemoteObject.unexportObject(registro, true); } catch (Exception ignored) { }
        remoto = null; registro = null;
    }
    public boolean isActivo() { return registro != null && remoto != null; }
    public int getPuerto() { return puerto; }
    @Override public void close() { detener(); }
    private static final class PresupuestoRemoteImpl extends UnicastRemoteObject implements PresupuestoRemote {
        private final CalcularPresupuestoService servicio = new CalcularPresupuestoService(new CalculoMapper());
        private PresupuestoRemoteImpl() throws RemoteException { super(); }
        @Override public String conectar(String cliente) { return "Servidor RMI listo para recibir calculos de presupuesto."; }
        @Override public RespuestaPresupuesto calcular(double ingresos, double egresos) {
            try {
                var dto = servicio.calcular(new CalcularPresupuestoCommand(ingresos, egresos));
                return RespuestaPresupuesto.exitosa(dto.presupuesto(), dto.presupuestoFormateado(), dto.clasificacion(), dto.recomendaciones());
            } catch (RuntimeException excepcion) { return RespuestaPresupuesto.error(excepcion.getMessage()); }
        }
        @Override public String desconectar(String cliente) { return "Sesion finalizada."; }
    }
}
