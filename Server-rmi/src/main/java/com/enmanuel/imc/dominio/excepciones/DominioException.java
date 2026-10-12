package com.enmanuel.imc.dominio.excepciones;
/** Excepción base de las validaciones del dominio. */
public class DominioException extends RuntimeException {
    public DominioException(String mensaje) { super(mensaje); }
}
