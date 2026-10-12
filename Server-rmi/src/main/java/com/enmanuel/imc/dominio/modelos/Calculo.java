package com.enmanuel.imc.dominio.modelos;
import com.enmanuel.imc.dominio.enums.ClasificacionPresupuesto;
import com.enmanuel.imc.dominio.vo.Egresos;
import com.enmanuel.imc.dominio.vo.Ingresos;
import java.util.Objects;
/** Entidad del dominio: calcula y clasifica ingresos menos egresos. */
public final class Calculo {
    private final Ingresos ingresos;
    private final Egresos egresos;
    public Calculo(Ingresos ingresos, Egresos egresos) { this.ingresos = Objects.requireNonNull(ingresos); this.egresos = Objects.requireNonNull(egresos); }
    public Resultado calcular() { double saldo = ingresos.valor() - egresos.valor(); return new Resultado(saldo, ClasificacionPresupuesto.deSaldo(saldo)); }
    public Ingresos getIngresos() { return ingresos; }
    public Egresos getEgresos() { return egresos; }
}
