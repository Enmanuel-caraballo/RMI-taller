package com.enmanuel.imc.dominio.puertos.salida;
public interface ControladorServidorRedPort { void iniciar(int puerto) throws Exception; void detener(); boolean isActivo(); int getPuertoActual(); }
