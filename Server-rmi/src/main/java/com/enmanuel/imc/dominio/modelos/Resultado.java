package com.enmanuel.imc.dominio.modelos;
import com.enmanuel.imc.dominio.enums.ClasificacionPresupuesto;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/** Resultado inmutable del cálculo del saldo mensual. */
public final class Resultado {
    private final double presupuesto;
    private final ClasificacionPresupuesto clasificacion;
    public Resultado(double presupuesto, ClasificacionPresupuesto clasificacion) { this.presupuesto = presupuesto; this.clasificacion = clasificacion; }
    public double getPresupuesto() { return presupuesto; }
    public ClasificacionPresupuesto getClasificacionPresupuesto() { return clasificacion; }
    public String getClasificacion() { return clasificacion.getClasificacion(); }
    public String getRecomendaciones() { return clasificacion.getRecomendacion(); }
    public String getPresupuestoFormateado() { return new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US)).format(presupuesto); }
}
