package com.enmanuel.imc.dominio.vo;
import com.enmanuel.imc.dominio.excepciones.IngresosIncorrectoException;
/** Value Object inmutable para los ingresos mensuales. */
public record Ingresos(double valor) {
    public Ingresos { if (!Double.isFinite(valor) || valor <= 0) throw new IngresosIncorrectoException("Ingresos incorrectos: deben ser mayores que 0"); }
}
