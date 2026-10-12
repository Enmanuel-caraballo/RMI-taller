package com.enmanuel.imc.aplicacion.puertos.entrada;
import com.enmanuel.imc.aplicacion.dto.CalcularPresupuestoCommand;
import com.enmanuel.imc.dominio.modelos.ResultadoPresupuesto;
public interface CalcularPresupuestoInputPort { ResultadoPresupuesto calcular(CalcularPresupuestoCommand comando) throws ClienteException; }
