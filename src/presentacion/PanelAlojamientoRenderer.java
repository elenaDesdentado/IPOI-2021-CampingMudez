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
	private Alojamiento Alojamiento;
	private JLabel lblValoracion;
	private JLabel lblClientes;

	/**
	 * Create the panel.
	 */
	public PanelAlojamientoRenderer(Alojamiento alojamiento) {

		this.Alojamiento = Alojamiento;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del Alojamiento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setIcon(alojamiento.getFoto());
		lblFoto.setBounds(10, 10, 131, 186);
		add(lblFoto);

		lblNombre = new JLabel(alojamiento.getNombre());
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setToolTipText("Nombre del Alojamiento");
		lblNombre.setBounds(177, 29, 263, 29);
		add(lblNombre);

		lblTipo = new JLabel((alojamiento instanceof Parcela) ? "Pacerla" : "Bungalow");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTipo.setBounds(177, 67, 208, 28);
		add(lblTipo);

		lblDisponibilidad = new JLabel(alojamiento.getDisponibilidad());
		lblDisponibilidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDisponibilidad.setBounds(177, 95, 114, 28);
		add(lblDisponibilidad);

		lblTamanio = new JLabel(alojamiento.getTamanio() + "m<sup>2</sup>");
		lblTamanio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTamanio.setBounds(177, 129, 145, 28);
		add(lblTamanio);

		lblArea = new JLabel(alojamiento.getArea());
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
		lblArea.setBounds(177, 175, 145, 21);
		add(lblArea);

		lblValoracion = new JLabel();
		lblValoracion.setIcon(new ImageIcon(
				PanelAlojamientoRenderer.class.getResource("./estrellas" + alojamiento.getValoracion() + ".PNG")));
		lblValoracion.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblValoracion.setBounds(194, 225, 145, 21);
		add(lblValoracion);

		lblClientes = new JLabel("Valoración de los clientes:");
		lblClientes.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblClientes.setBounds(10, 225, 164, 21);
		add(lblClientes);

	}
}
