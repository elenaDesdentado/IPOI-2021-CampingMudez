package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dominio.Monitor;
import javax.swing.border.EtchedBorder;

public class PanelMonitorRenderer extends JPanel {
	private JLabel lblAvatar;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JLabel lblDisponibilidad;
	private Monitor monitor;

	/**
	 * Create the panel.
	 */
	public PanelMonitorRenderer(Monitor monitor) {
		this.monitor = monitor;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del monitor", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		setLayout(null);

		lblAvatar = new JLabel("");
		lblAvatar.setIcon(new ImageIcon(PanelMonitorRenderer.class.getResource(monitor.getAvatar())));
		lblAvatar.setBounds(10, 10, 131, 186);
		add(lblAvatar);

		lblNombre = new JLabel(monitor.getNombre() + ' ' + monitor.getApellidos());
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNombre.setToolTipText("Nombre del monitor");
		lblNombre.setBounds(177, 29, 145, 29);
		add(lblNombre);

		lblEdad = new JLabel("" + monitor.getEdad());
		lblEdad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEdad.setBounds(177, 68, 49, 28);
		add(lblEdad);

		lblCorreo = new JLabel(monitor.getCorreo());
		lblCorreo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCorreo.setBounds(177, 106, 370, 28);
		add(lblCorreo);

		lblTelefono = new JLabel(monitor.getMovil());
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTelefono.setBounds(177, 144, 145, 28);
		add(lblTelefono);

		lblDisponibilidad = new JLabel(monitor.getDisponibilidad());
		switch (lblDisponibilidad.getText()) {
		case "Disponible":
			lblDisponibilidad.setForeground(Color.green);
			break;
		case "Baja laboral":
			lblDisponibilidad.setForeground(Color.red);
			break;
		case "Vacaciones":
			lblDisponibilidad.setForeground(Color.orange);
			break;
		}
		lblDisponibilidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDisponibilidad.setBounds(177, 182, 145, 21);
		add(lblDisponibilidad);

	}

	public JLabel getLblAvatar() {
		return lblAvatar;
	}

	public void setLblAvatar(JLabel lblAvatar) {
		this.lblAvatar = lblAvatar;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public JLabel getLblDisponibilidad() {
		return lblDisponibilidad;
	}

	public void setLblDisponibilidad(JLabel lblDisponibilidad) {
		this.lblDisponibilidad = lblDisponibilidad;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	
}
