package com.enmanuel.imc.adaptadores.notificacion;
import com.enmanuel.imc.dominio.enums.EstadoServidor;
import com.enmanuel.imc.dominio.modelos.EventoServidor;
public interface ObservadorServidor { void onEvento(EventoServidor evento); void onCambioEstado(EstadoServidor estado, int puerto); }
