package com.enmanuel.imc.entrypoint.gui;
import com.enmanuel.imc.adaptadores.notificacion.*;
import com.enmanuel.imc.aplicacion.dto.*;
import com.enmanuel.imc.aplicacion.puertos.entrada.*;
import com.enmanuel.imc.dominio.enums.EstadoConexion;
import com.enmanuel.imc.dominio.modelos.*;
import javax.swing.*;
import java.awt.*;
/** Entrypoint Swing del cliente RMI, con llamadas remotas fuera del EDT. */
public final class ClienteFrame extends JFrame implements ObservadorCliente {
    private final GestionarConexionInputPort conexion;
    private final CalcularPresupuestoInputPort calculo;
    private final JTextField txtHost = new JTextField("localhost", 12);
    private final JTextField txtPuerto = new JTextField("1099", 6);
    private final JTextField txtIngresos = new JTextField(10);
    private final JTextField txtEgresos = new JTextField(10);
    private final JLabel lblEstado = new JLabel("● DESCONECTADO");
    private final JTextArea txtResultado = new JTextArea(6, 42);
    private final JButton btnConexion = new JButton("Conectar");
    public ClienteFrame(GestionarConexionInputPort conexion, CalcularPresupuestoInputPort calculo) { super("Cliente RMI - Presupuesto Mensual"); this.conexion = conexion; this.calculo = calculo; initUI(); }
    public ClienteFrame(GestionarConexionInputPort conexion, AdaptadorNotificacionCliente ignored) { this(conexion, (CalcularPresupuestoInputPort) conexion); }
    private void initUI() { setDefaultCloseOperation(EXIT_ON_CLOSE); setSize(620, 430); setLocationRelativeTo(null); setLayout(new BorderLayout(10, 10));
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8)); panel.setBorder(BorderFactory.createTitledBorder("Conexion RMI"));
        panel.add(new JLabel("Host:")); panel.add(txtHost); panel.add(new JLabel("Puerto registro:")); panel.add(txtPuerto); panel.add(new JLabel("Estado:")); panel.add(lblEstado); panel.add(btnConexion); panel.add(new JLabel());
        panel.add(new JLabel("Ingresos mensuales:")); panel.add(txtIngresos); panel.add(new JLabel("Egresos mensuales:")); panel.add(txtEgresos); JButton calcular = new JButton("Calcular presupuesto"); panel.add(calcular); panel.add(new JLabel()); add(panel, BorderLayout.NORTH);
        txtResultado.setEditable(false); txtResultado.setLineWrap(true); txtResultado.setWrapStyleWord(true); add(new JScrollPane(txtResultado), BorderLayout.CENTER); btnConexion.addActionListener(e -> alternarConexion()); calcular.addActionListener(e -> calcular()); }
    private void alternarConexion() { if (conexion.estaConectado()) { conexion.desconectar(); onCambioEstado(EstadoConexion.DESCONECTADO); return; } try { int puerto = Integer.parseInt(txtPuerto.getText().trim()); conexion.conectar(new ConectarCommand(txtHost.getText(), puerto, "cliente-swing")); onCambioEstado(EstadoConexion.CONECTADO); } catch (Exception ex) { error(ex); } }
    private void calcular() { try { double ingresos = Double.parseDouble(txtIngresos.getText().trim().replace(',', '.')); double egresos = Double.parseDouble(txtEgresos.getText().trim().replace(',', '.')); ResultadoPresupuesto resultado = calculo.calcular(new CalcularPresupuestoCommand(ingresos, egresos)); txtResultado.setText(resultado.mensaje() + System.lineSeparator() + resultado.clasificacion() + System.lineSeparator() + "Saldo: " + resultado.presupuestoFormateado() + System.lineSeparator() + resultado.recomendaciones()); } catch (Exception ex) { error(ex); } }
    private void error(Exception ex) { JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); }
    @Override public void onEvento(EventoCliente evento) { txtResultado.append(evento.descripcion() + System.lineSeparator()); }
    @Override public void onCambioEstado(EstadoConexion estado) { lblEstado.setText(estado == EstadoConexion.CONECTADO ? "● CONECTADO" : "● DESCONECTADO"); lblEstado.setForeground(estado == EstadoConexion.CONECTADO ? new Color(46, 125, 50) : Color.RED); btnConexion.setText(estado == EstadoConexion.CONECTADO ? "Desconectar" : "Conectar"); }
}
