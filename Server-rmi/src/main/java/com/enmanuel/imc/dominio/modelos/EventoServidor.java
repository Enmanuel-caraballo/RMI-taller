package com.enmanuel.imc.dominio.modelos;
import java.time.LocalDateTime;
public record EventoServidor(LocalDateTime fechaHora, String categoria, String endpoint, String descripcion) {
    public EventoServidor(String categoria, String endpoint, String descripcion) { this(LocalDateTime.now(), categoria, endpoint, descripcion); }
}
