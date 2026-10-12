package com.enmanuel.imc.adaptadores.notificacion;
import com.enmanuel.imc.dominio.enums.EstadoConexion;
import com.enmanuel.imc.dominio.modelos.EventoCliente;
public interface ObservadorCliente { void onEvento(EventoCliente evento); void onCambioEstado(EstadoConexion estado); }
