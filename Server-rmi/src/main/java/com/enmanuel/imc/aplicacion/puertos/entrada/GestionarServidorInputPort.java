package com.enmanuel.imc.aplicacion.puertos.entrada;
import com.enmanuel.imc.aplicacion.excepciones.ServidorRedException;
public interface GestionarServidorInputPort { void iniciarServidor(int puerto) throws ServidorRedException; void detenerServidor(); boolean estaCorriendo(); int getPuertoActual(); }
