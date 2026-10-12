package com.enmanuel.imc.dominio.puertos.salida;
import com.enmanuel.imc.dominio.enums.EstadoConexion;
import com.enmanuel.imc.dominio.modelos.EventoCliente;
public interface PuertoNotificacionCliente { void notificarEvento(EventoCliente evento); void notificarCambioEstado(EstadoConexion estado); }
