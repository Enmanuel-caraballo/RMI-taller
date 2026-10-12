package com.enmanuel.imc.aplicacion.mapper;
import com.enmanuel.imc.aplicacion.dto.*;
import com.enmanuel.imc.dominio.modelos.*;
import com.enmanuel.imc.dominio.vo.*;
import com.enmanuel.imc.remoto.RespuestaPresupuesto;
public final class ClienteMapper {
    public DatosPresupuesto toDomain(CalcularPresupuestoCommand comando) { return new DatosPresupuesto(new Ingresos(comando.ingresos()), new Egresos(comando.egresos())); }
    public ResultadoPresupuesto toDomain(RespuestaPresupuesto respuesta) { return new ResultadoPresupuesto(respuesta.exitosa(), respuesta.saldo(), respuesta.saldoFormateado(), respuesta.clasificacion(), respuesta.recomendacion(), respuesta.mensaje()); }
}
