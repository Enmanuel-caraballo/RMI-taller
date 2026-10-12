package com.enmanuel.imc.remoto;
import java.rmi.Remote;
import java.rmi.RemoteException;
/** Contrato remoto compartido entre cliente y servidor. */
public interface PresupuestoRemote extends Remote {
    String conectar(String cliente) throws RemoteException;
    RespuestaPresupuesto calcular(double ingresos, double egresos) throws RemoteException;
    String desconectar(String cliente) throws RemoteException;
}
