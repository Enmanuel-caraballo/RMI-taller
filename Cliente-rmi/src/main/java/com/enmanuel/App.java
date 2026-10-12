package com.enmanuel;
import com.enmanuel.imc.adaptadores.rmi.AdaptadorClienteRmi;
import com.enmanuel.imc.aplicacion.mapper.ClienteMapper;
import com.enmanuel.imc.aplicacion.puertos.entrada.CalcularPresupuestoInputPort;
import com.enmanuel.imc.aplicacion.puertos.entrada.GestionarConexionInputPort;
import com.enmanuel.imc.aplicacion.servicios.ClientePresupuestoService;
import com.enmanuel.imc.entrypoint.gui.ClienteFrame;
public final class App { private App() { } public static void main(String[] args) { var servicio = new ClientePresupuestoService(new AdaptadorClienteRmi(), new ClienteMapper()); javax.swing.SwingUtilities.invokeLater(() -> new ClienteFrame((GestionarConexionInputPort) servicio, (CalcularPresupuestoInputPort) servicio).setVisible(true)); } }
