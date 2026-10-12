package com.enmanuel.imc.dominio.vo;
import com.enmanuel.imc.dominio.excepciones.DestinoIncorrectoException;
public record DestinoServidor(String host, int puerto) {
    public DestinoServidor { if (host == null || host.isBlank()) throw new DestinoIncorrectoException("El host del servidor es obligatorio."); if (puerto < 1 || puerto > 65535) throw new DestinoIncorrectoException("El puerto debe estar entre 1 y 65535."); host = host.trim(); }
}
