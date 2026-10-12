package com.enmanuel.imc.dominio.puertos.salida;
import com.enmanuel.imc.remoto.RespuestaPresupuesto;
public interface ClienteRmiPort { String conectar(String host, int puerto, String cliente) throws Exception; RespuestaPresupuesto calcular(double ingresos, double egresos) throws Exception; String desconectar(String cliente) throws Exception; }
