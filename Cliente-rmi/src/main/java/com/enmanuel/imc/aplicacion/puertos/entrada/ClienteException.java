package com.enmanuel.imc.aplicacion.puertos.entrada;
public class ClienteException extends Exception { public ClienteException(String mensaje, Throwable causa) { super(mensaje, causa); } public ClienteException(String mensaje) { super(mensaje); } }
