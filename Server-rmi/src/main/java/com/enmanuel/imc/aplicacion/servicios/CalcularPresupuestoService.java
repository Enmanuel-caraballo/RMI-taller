package com.enmanuel.imc.aplicacion.servicios;
import com.enmanuel.imc.aplicacion.dto.*;
import com.enmanuel.imc.aplicacion.mapper.CalculoMapper;
import com.enmanuel.imc.aplicacion.puertos.entrada.CalcularPresupuestoInputPort;
public final class CalcularPresupuestoService implements CalcularPresupuestoInputPort {
    private final CalculoMapper calculoMapper;
    public CalcularPresupuestoService(CalculoMapper calculoMapper) { this.calculoMapper = calculoMapper; }
    @Override public ResultadoPresupuestoDto calcular(CalcularPresupuestoCommand comando) { return calculoMapper.toDto(calculoMapper.toDomain(comando).calcular()); }
}
