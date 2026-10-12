package com.enmanuel.imc.aplicacion.mapper;
import com.enmanuel.imc.aplicacion.dto.*;
import com.enmanuel.imc.dominio.modelos.*;
import com.enmanuel.imc.dominio.vo.*;
public final class CalculoMapper {
    public Calculo toDomain(CalcularPresupuestoCommand comando) { return toDomain(comando.ingresos(), comando.egresos()); }
    public Calculo toDomain(double ingresos, double egresos) { return new Calculo(new Ingresos(ingresos), new Egresos(egresos)); }
    public ResultadoPresupuestoDto toDto(Resultado resultado) { return new ResultadoPresupuestoDto(resultado.getPresupuesto(), resultado.getPresupuestoFormateado(), resultado.getClasificacion(), resultado.getRecomendaciones()); }
}
