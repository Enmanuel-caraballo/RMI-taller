package com.enmanuel;
import com.enmanuel.imc.adaptadores.notificacion.AdaptadorNotificacionEvento;
import com.enmanuel.imc.adaptadores.rmi.AdaptadorControlServidorRmi;
import com.enmanuel.imc.aplicacion.servicios.GestionarServidorService;
import com.enmanuel.imc.entrypoint.gui.ServidorFrame;
public final class App { private App() { } public static void main(String[] args) { var notificador = new AdaptadorNotificacionEvento(); var servicio = new GestionarServidorService(new AdaptadorControlServidorRmi(), notificador); javax.swing.SwingUtilities.invokeLater(() -> { var ventana = new ServidorFrame(servicio); notificador.registrarObservador(ventana); ventana.setVisible(true); }); } }
