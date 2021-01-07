package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dominio.Alojamiento;
import dominio.Parcela;

public class PanelAlojamientoRenderer extends JPanel {

	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblDisponibilidad;
	private JLabel lblTamanio;
	private JLabel lblArea;
	public Alojamiento alojamiento;
	private JLabel lblValoracion;
	private JLabel lblClientes;
	
	private Color escorpion = new Color(229, 190, 1);
	private Color salmon = new Color(59, 131, 189);
	private Color ciervo = new Color(45, 87, 44);
	private Color aguila = new Color(194, 155, 97);
	

	/**
	 * Create the panel.
	 */
	public PanelAlojamientoRenderer(Alojamiento alojamiento) {

		this.alojamiento = alojamiento;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), MessagesPanelAlojamientoRenderer.getString("PanelAlojamientoRenderer.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64))); //$NON-NLS-1$
		setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setIcon(alojamiento.getFoto());
		lblFoto.setBounds(10, 10, 131, 186);
		add(lblFoto);

		lblNombre = new JLabel(alojamiento.getNombre());
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setToolTipText(MessagesPanelAlojamientoRenderer.getString("PanelAlojamientoRenderer.lblNombre.toolTipText")); //$NON-NLS-1$
		lblNombre.setBounds(177, 21, 263, 29);
		add(lblNombre);

		lblTipo = new JLabel((alojamiento instanceof Parcela) ? "Parcela" : "Cabaña");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTipo.setBounds(177, 49, 208, 28);
		add(lblTipo);

		lblDisponibilidad = new JLabel(alojamiento.getDisponibilidad());
		lblDisponibilidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDisponibilidad.setBounds(177, 77, 114, 28);
		add(lblDisponibilidad);
		switch(lblDisponibilidad.getText()) {
			
		}

		lblTamanio = new JLabel(); 
		lblTamanio.setText("<html>" + alojamiento.getTamanio() + "m<sup>2</sup></html>");
		lblTamanio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTamanio.setBounds(177, 103, 145, 28);
		add(lblTamanio);

		lblArea = new JLabel(alojamiento.getArea());
		switch (lblArea.getText()) {
		case "Escorpión":
			lblArea.setForeground(escorpion);
			break;
		case "Ciervo":
			lblArea.setForeground(ciervo);
			break;
		case "Salmón":
			lblArea.setForeground(salmon);
			break;
		case "Águila":
			lblArea.setForeground(aguila);
			break;
		}
		lblArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblArea.setBounds(177, 142, 145, 21);
		add(lblArea);

		lblValoracion = new JLabel();
		ImageIcon image = new ImageIcon(
				PanelAlojamientoRenderer.class.getResource("./estrellas" + alojamiento.getValoracion() + ".PNG"));
		Image imagenEscalada1 = image.getImage().getScaledInstance(128, 20, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(imagenEscalada1);
		lblValoracion.setIcon(image);
		lblValoracion.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblValoracion.setBounds(177, 174, 208, 21);
		add(lblValoracion);

		lblClientes = new JLabel(MessagesPanelAlojamientoRenderer.getString("PanelAlojamientoRenderer.lblClientes.text")); //$NON-NLS-1$
		lblClientes.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblClientes.setBounds(10, 175, 164, 21);
		add(lblClientes);

	}
	
	public Alojamiento getAlojamiento() {
		return this.alojamiento;
	}
}
