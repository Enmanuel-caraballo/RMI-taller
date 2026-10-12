package com.enmanuel.imc.entrypoint.gui;
import com.enmanuel.imc.adaptadores.notificacion.ObservadorServidor;
import com.enmanuel.imc.aplicacion.excepciones.ServidorRedException;
import com.enmanuel.imc.aplicacion.puertos.entrada.GestionarServidorInputPort;
import com.enmanuel.imc.dominio.enums.EstadoServidor;
import com.enmanuel.imc.dominio.modelos.EventoServidor;
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
/** Entrypoint Swing del servidor RMI, siguiendo la ventana del proyecto UDP. */
public final class ServidorFrame extends JFrame implements ObservadorServidor {
    private final GestionarServidorInputPort gestionarServidorPort;
    private final JTextField txtPuerto = new JTextField("1099", 8);
    private final JLabel lblEstado = new JLabel("● DETENIDO");
    private final JTextArea txtLogs = new JTextArea();
    private final JButton btnIniciarDetener = new JButton("Iniciar Servicio");
    public ServidorFrame(GestionarServidorInputPort gestionarServidorPort) {
        super("Servidor RMI - Presupuesto Mensual (Arquitectura Hexagonal)"); this.gestionarServidorPort = gestionarServidorPort; initUI();
    }
    private void initUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); setSize(760, 520); setLocationRelativeTo(null); setLayout(new BorderLayout(10, 10));
        JPanel config = new JPanel(new GridBagLayout()); config.setBorder(BorderFactory.createTitledBorder("Configuracion del Registro RMI"));
        GridBagConstraints c = new GridBagConstraints(); c.insets = new Insets(8, 8, 8, 8); c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; c.gridy = 0; config.add(new JLabel("Puerto del registro:"), c); c.gridx = 1; config.add(txtPuerto, c);
        c.gridx = 0; c.gridy = 1; config.add(new JLabel("Estado actual:"), c); c.gridx = 1; lblEstado.setForeground(Color.RED); config.add(lblEstado, c);
        c.gridx = 2; c.gridy = 0; c.gridheight = 2; btnIniciarDetener.addActionListener(e -> alternarServicio()); config.add(btnIniciarDetener, c);
        add(config, BorderLayout.NORTH); txtLogs.setEditable(false); txtLogs.setFont(new Font("Monospaced", Font.PLAIN, 12)); add(new JScrollPane(txtLogs), BorderLayout.CENTER);
        append("Aplicacion lista. Presione 'Iniciar Servicio' para activar RMI.");
    }
    private void alternarServicio() { if (gestionarServidorPort.estaCorriendo()) gestionarServidorPort.detenerServidor(); else iniciarServicio(); }
    private void iniciarServicio() { try { int puerto = Integer.parseInt(txtPuerto.getText().trim()); if (puerto < 1024 || puerto > 65535) throw new NumberFormatException(); gestionarServidorPort.iniciarServidor(puerto); } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "El puerto debe estar entre 1024 y 65535.", "Puerto invalido", JOptionPane.WARNING_MESSAGE); } catch (ServidorRedException ex) { JOptionPane.showMessageDialog(this, ex.getMessage(), "Error RMI", JOptionPane.ERROR_MESSAGE); } }
    private void append(String mensaje) { txtLogs.append(mensaje + System.lineSeparator()); }
    @Override public void onEvento(EventoServidor evento) { append(evento.fechaHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ": [" + evento.categoria() + "] " + evento.descripcion()); }
    @Override public void onCambioEstado(EstadoServidor estado, int puerto) { if (estado == EstadoServidor.EN_LINEA) { lblEstado.setText("● EN LINEA"); lblEstado.setForeground(new Color(46, 125, 50)); btnIniciarDetener.setText("Detener Servicio"); txtPuerto.setEnabled(false); } else { lblEstado.setText("● DETENIDO"); lblEstado.setForeground(Color.RED); btnIniciarDetener.setText("Iniciar Servicio"); txtPuerto.setEnabled(true); } }
}
