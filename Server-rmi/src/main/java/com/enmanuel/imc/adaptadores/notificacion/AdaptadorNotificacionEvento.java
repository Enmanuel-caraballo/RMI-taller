package com.enmanuel.imc.adaptadores.notificacion;
import com.enmanuel.imc.dominio.enums.EstadoServidor;
import com.enmanuel.imc.dominio.modelos.EventoServidor;
import com.enmanuel.imc.dominio.puertos.salida.PuertoNotificacionEvento;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
public final class AdaptadorNotificacionEvento implements PuertoNotificacionEvento {
    private final List<ObservadorServidor> observadores = new CopyOnWriteArrayList<>();
    public void registrarObservador(ObservadorServidor observador) { if (observador != null && !observadores.contains(observador)) observadores.add(observador); }
    @Override public void notificarEvento(EventoServidor evento) { observadores.forEach(observador -> observador.onEvento(evento)); }
    @Override public void notificarCambioEstado(EstadoServidor estado, int puerto) { observadores.forEach(observador -> observador.onCambioEstado(estado, puerto)); }
}
