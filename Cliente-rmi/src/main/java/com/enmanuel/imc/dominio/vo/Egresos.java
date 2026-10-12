package com.enmanuel.imc.dominio.vo;
import com.enmanuel.imc.dominio.excepciones.EgresosIncorrectosException;
public record Egresos(double valor) { public Egresos { if (!Double.isFinite(valor) || valor < 0) throw new EgresosIncorrectosException("Egresos incorrectos: no pueden ser negativos"); } }
