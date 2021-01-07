package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dominio.Monitor;
import dominio.Parcela;
import dominio.Ruta;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelRutaRenderer extends JPanel {

	private JLabel lblFoto;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblDisponibilidad;
	private JLabel lblTamanio;
	private JLabel lblArea;
	public Ruta ruta;
	private JLabel lblValoracion;

	private Color escorpion = new Color(229, 190, 1);
	private Color salmon = new Color(59, 131, 189);
	private Color ciervo = new Color(45, 87, 44);
	private Color aguila = new Color(194, 155, 97);
	private JLabel lblDia;
	private JLabel lblHorario;
	private JLabel lblMonitores;
	private JLabel lblEncuentro;
	private JLabel lblDificultad;

	/**
	 * Create the panel.
	 */
	public PanelRutaRenderer(Ruta ruta) {

		this.ruta = ruta;
		setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				MessagesPanelRutaRenderer.getString("PanelRutaRenderer.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64))); //$NON-NLS-1$
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 131, 15, 359, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblFoto = new JLabel("");
		lblFoto.setIcon(ruta.getFoto());
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridheight = 6;
		gbc_lblFoto.fill = GridBagConstraints.BOTH;
		gbc_lblFoto.insets = new Insets(0, 0, 0, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 0;
		add(lblFoto, gbc_lblFoto);

		lblNombre = new JLabel(ruta.getNombre());
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setToolTipText(MessagesPanelRutaRenderer.getString("PanelRutaRenderer.lblNombre.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.NORTH;
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);

		lblDia = new JLabel("Día: " + ruta.getDia());
		lblDia.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.WEST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 3;
		gbc_lblDia.gridy = 1;
		add(lblDia, gbc_lblDia);
		
		lblHorario = new JLabel("Horario: " + ruta.getHorario());
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.WEST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 3;
		gbc_lblHorario.gridy = 2;
		add(lblHorario, gbc_lblHorario);
		
		lblMonitores = new JLabel("");
		lblMonitores.setFont(new Font("Verdana", Font.PLAIN, 12));
		String monitores = "Monitor/es: ";
		for (Monitor monitor : ruta.getMonitores()) {
			monitores += (monitor.getNombre() + " " + monitor.getApellidos() + " - ");
		}
		lblMonitores.setText(monitores);
		GridBagConstraints gbc_lblMonitores = new GridBagConstraints();
		gbc_lblMonitores.anchor = GridBagConstraints.WEST;
		gbc_lblMonitores.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitores.gridx = 3;
		gbc_lblMonitores.gridy = 3;
		add(lblMonitores, gbc_lblMonitores);
		
		lblEncuentro = new JLabel("Punto de encuentro: " + ruta.getEncuentro());
		lblEncuentro.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblEncuentro = new GridBagConstraints();
		gbc_lblEncuentro.anchor = GridBagConstraints.WEST;
		gbc_lblEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncuentro.gridx = 3;
		gbc_lblEncuentro.gridy = 4;
		add(lblEncuentro, gbc_lblEncuentro);
		
		lblDificultad = new JLabel("Dificultad de la ruta: " + ruta.getDificultad());
		lblDificultad.setFont(new Font("Verdana", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.insets = new Insets(0, 0, 0, 5);
		gbc_lblDificultad.anchor = GridBagConstraints.WEST;
		gbc_lblDificultad.gridx = 3;
		gbc_lblDificultad.gridy = 5;
		add(lblDificultad, gbc_lblDificultad);

	}

	public Ruta getruta() {
		return this.ruta;
	}
}
