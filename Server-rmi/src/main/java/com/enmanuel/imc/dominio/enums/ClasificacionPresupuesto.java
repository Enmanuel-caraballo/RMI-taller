package com.enmanuel.imc.dominio.enums;
/** Clasificación del presupuesto mensual según el saldo disponible. */
public enum ClasificacionPresupuesto {
    SUPERAVIT("Superavit: tus finanzas son sanas", "Tus ingresos superan a tus gastos, considera ahorrar o invertir el excedente."),
    PRESUPUESTO_EQUILIBRADO("Presupuesto equilibrado: tus finanzas presentan estabilidad", "Cuidado, no tienes margen de dinero libre para imprevistos."),
    DEFICIT_PRESUPUESTARIO("Deficit presupuestario: tus gastos son mayores a tus ingresos", "Estas gastando dinero que no tienes, reduce los gastos no esenciales.");
    private final String clasificacion;
    private final String recomendacion;
    ClasificacionPresupuesto(String clasificacion, String recomendacion) { this.clasificacion = clasificacion; this.recomendacion = recomendacion; }
    public String getClasificacion() { return clasificacion; }
    public String getRecomendacion() { return recomendacion; }
    public static ClasificacionPresupuesto deSaldo(double saldo) { return saldo > 0 ? SUPERAVIT : saldo == 0 ? PRESUPUESTO_EQUILIBRADO : DEFICIT_PRESUPUESTARIO; }
}
