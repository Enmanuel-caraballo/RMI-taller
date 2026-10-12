package com.enmanuel.imc.remoto;
import java.io.Serializable;
/** DTO serializable que transporta la respuesta del servidor RMI. */
public record RespuestaPresupuesto(
        boolean exitosa, double saldo, String saldoFormateado, String clasificacion, String recomendacion,
        String mensaje) implements Serializable {
    private static final long serialVersionUID = 1L;
    public static RespuestaPresupuesto exitosa(double saldo, String saldoFormateado, String clasificacion, String recomendacion) {
        return new RespuestaPresupuesto(true, saldo, saldoFormateado, clasificacion, recomendacion, "Calculo realizado correctamente.");
    }
    public static RespuestaPresupuesto error(String mensaje) {
        return new RespuestaPresupuesto(false, 0, "0.00", "", "", mensaje);
    }
}
