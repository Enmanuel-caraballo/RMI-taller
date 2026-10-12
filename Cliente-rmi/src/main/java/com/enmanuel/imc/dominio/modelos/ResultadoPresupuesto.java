package com.enmanuel.imc.dominio.modelos;
public record ResultadoPresupuesto(boolean exitosa, double presupuesto, String presupuestoFormateado, String clasificacion, String recomendaciones, String mensaje) { }
