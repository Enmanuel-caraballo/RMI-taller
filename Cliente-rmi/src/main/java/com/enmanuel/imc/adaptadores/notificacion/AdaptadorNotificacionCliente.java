package com.enmanuel.imc.adaptadores.notificacion;
import com.enmanuel.imc.dominio.enums.EstadoConexion;
import com.enmanuel.imc.dominio.modelos.EventoCliente;
import com.enmanuel.imc.dominio.puertos.salida.PuertoNotificacionCliente;
public final class AdaptadorNotificacionCliente implements PuertoNotificacionCliente {
    private ObservadorCliente observador;
    public void registrarObservador(ObservadorCliente observador) { this.observador = observador; }
    @Override public void notificarEvento(EventoCliente evento) { if (observador != null) observador.onEvento(evento); }
    @Override public void notificarCambioEstado(EstadoConexion estado) { if (observador != null) observador.onCambioEstado(estado); }
}
