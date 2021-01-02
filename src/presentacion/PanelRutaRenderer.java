package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dominio.Parcela;
import dominio.Ruta;

public class PanelRutaRenderer extends JPanel {

	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblDisponibilidad;
	private JLabel lblTamanio;
	private JLabel lblArea;
	public Ruta ruta;
	private JLabel lblValoracion;
	private JLabel lblClientes;
	
	private Color escorpion = new Color(229, 190, 1);
	private Color salmon = new Color(59, 131, 189);
	private Color ciervo = new Color(45, 87, 44);
	private Color aguila = new Color(194, 155, 97);
	

	/**
	 * Create the panel.
	 */
	public PanelRutaRenderer(Ruta ruta) {

		this.ruta = ruta;
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Informaci\u00F3n del ruta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setIcon(ruta.getFoto());
		lblFoto.setBounds(10, 10, 131, 186);
		add(lblFoto);

		lblNombre = new JLabel(ruta.getNombre());
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setToolTipText("Nombre del ruta");
		lblNombre.setBounds(177, 21, 263, 29);
		add(lblNombre);

		lblClientes = new JLabel("Valoración de los clientes:");
		lblClientes.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblClientes.setBounds(10, 175, 164, 21);
		add(lblClientes);

	}
	
	public Ruta getruta() {
		return this.ruta;
	}
}
