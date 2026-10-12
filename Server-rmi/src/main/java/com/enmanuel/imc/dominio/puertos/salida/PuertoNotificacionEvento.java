package com.enmanuel.imc.dominio.puertos.salida;
import com.enmanuel.imc.dominio.enums.EstadoServidor;
import com.enmanuel.imc.dominio.modelos.EventoServidor;
public interface PuertoNotificacionEvento { void notificarEvento(EventoServidor evento); void notificarCambioEstado(EstadoServidor estado, int puerto); }
