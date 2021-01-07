package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dominio.Actividad;
import javax.swing.border.EtchedBorder;

public class PanelActividadRenderer extends JPanel {
	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblMonitor;
	private JLabel lblPrecio;
	private JLabel lblHorario;
	private JLabel lblArea;
	private Actividad actividad;

	/**
	 * Create the panel.
	 */
	public PanelActividadRenderer(Actividad actividad) {
		this.actividad = actividad;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), MessagesPanelActividadRenderer.getString("PanelActividadRenderer.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64))); //$NON-NLS-1$
		setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setIcon(actividad.getFotoActividad());
		lblFoto.setBounds(10, 10, 131, 186);
		add(lblFoto);

		lblNombre = new JLabel(actividad.getNombre());
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setToolTipText(MessagesPanelActividadRenderer.getString("PanelActividadRenderer.lblNombre.toolTipText")); //$NON-NLS-1$
		lblNombre.setBounds(177, 29, 263, 29);
		add(lblNombre);

		lblMonitor = new JLabel("" + actividad.getMonitor());
		lblMonitor.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMonitor.setBounds(177, 67, 208, 28);
		add(lblMonitor);

		lblPrecio = new JLabel(actividad.getPrecio().toString() + " €");
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrecio.setBounds(177, 95, 114, 28);
		add(lblPrecio);

		lblHorario = new JLabel(actividad.getHorario());
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblHorario.setBounds(177, 129, 145, 28);
		add(lblHorario);

		lblArea = new JLabel(actividad.getArea());
		switch (lblArea.getText()) {
		case "Escorpión":
			lblArea.setForeground(new Color(229, 190, 1));
			break;
		case "Ciervo":
			lblArea.setForeground(new Color(45, 87, 44));
			break;
		case "Salmón":
			lblArea.setForeground(new Color(59, 131, 189));
			break;
		case "Águila":
			lblArea.setForeground(new Color(194, 155, 97));
			break;
		}
		lblArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblArea.setBounds(177, 164, 145, 21);
		add(lblArea);

	}

	public JLabel getLblAvatar() {
		return lblFoto;
	}

	public void setLblAvatar(JLabel lblAvatar) {
		this.lblFoto = lblAvatar;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblEdad() {
		return lblMonitor;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblMonitor = lblEdad;
	}

	public JLabel getLblCorreo() {
		return lblPrecio;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblPrecio = lblCorreo;
	}

	public JLabel getLblTelefono() {
		return lblHorario;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblHorario = lblTelefono;
	}

	public JLabel getLblDisponibilidad() {
		return lblArea;
	}

	public void setLblDisponibilidad(JLabel lblDisponibilidad) {
		this.lblArea = lblDisponibilidad;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
}
