package com.enmanuel.imc.dominio.modelos;
import java.time.LocalDateTime;
public record EventoCliente(LocalDateTime fechaHora, String categoria, String descripcion) { public EventoCliente(String categoria, String descripcion) { this(LocalDateTime.now(), categoria, descripcion); } }
