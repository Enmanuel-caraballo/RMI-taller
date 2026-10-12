package com.enmanuel.imc.aplicacion.puertos.entrada;
import com.enmanuel.imc.aplicacion.dto.ConectarCommand;
public interface GestionarConexionInputPort { void conectar(ConectarCommand comando) throws ClienteException; void desconectar(); boolean estaConectado(); }
