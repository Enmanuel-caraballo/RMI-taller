package com.enmanuel.imc.dominio.modelos;
import com.enmanuel.imc.dominio.vo.Egresos;
import com.enmanuel.imc.dominio.vo.Ingresos;
public record DatosPresupuesto(Ingresos ingresos, Egresos egresos) { }
