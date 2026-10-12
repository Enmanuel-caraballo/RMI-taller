package com.enmanuel.imc.dominio.vo;
import com.enmanuel.imc.dominio.excepciones.EgresosIncorrectosException;
/** Value Object inmutable para los egresos mensuales. */
public record Egresos(double valor) {
    public Egresos { if (!Double.isFinite(valor) || valor < 0) throw new EgresosIncorrectosException("Egresos incorrectos: no pueden ser negativos"); }
}
