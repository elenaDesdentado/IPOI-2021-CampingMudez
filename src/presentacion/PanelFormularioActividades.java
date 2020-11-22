package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import java.awt.Color;

public class PanelFormularioActividades extends JPanel {
	private JLabel lblAvatar;
	private JButton btnAniadirAvatar;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblHorario;
	private JComboBox cbHorario;
	private JLabel lblNombre;
	private JLabel lblMonitor;
	private JLabel lblCupo;
	private JLabel lblDestinatarios;
	private JLabel lblArea;
	private JLabel lblDescripcion;
	private JLabel lblMateriales;
	private JTextField txtNombre;
	private JTextField txtMonitor;
	private JSpinner spinner;
	private JComboBox cbDestinatarios;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JButton btnAplicarCambios;
	private JButton btnCancelar;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);

	/**
	 * Create the panel.
	 */
	public PanelFormularioActividades() {
		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblAvatar = new JLabel("");
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridheight = 2;
		gbc_lblAvatar.gridwidth = 3;
		gbc_lblAvatar.gridx = 0;
		gbc_lblAvatar.gridy = 0;
		add(lblAvatar, gbc_lblAvatar);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 5;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblMonitor = new JLabel("Monitor:");
		lblMonitor.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 4;
		gbc_lblMonitor.gridy = 1;
		add(lblMonitor, gbc_lblMonitor);
		
		txtMonitor = new JTextField();
		GridBagConstraints gbc_txtMonitor = new GridBagConstraints();
		gbc_txtMonitor.gridwidth = 2;
		gbc_txtMonitor.insets = new Insets(0, 0, 5, 0);
		gbc_txtMonitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonitor.gridx = 5;
		gbc_txtMonitor.gridy = 1;
		add(txtMonitor, gbc_txtMonitor);
		txtMonitor.setColumns(10);
		
		btnAniadirAvatar = new JButton("Añadir foto...");
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 3;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 0;
		gbc_btnAniadirAvatar.gridy = 2;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);
		
		lblCupo = new JLabel("Cupo:");
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 4;
		gbc_lblCupo.gridy = 2;
		add(lblCupo, gbc_lblCupo);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, null, 15, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 5;
		gbc_spinner.gridy = 2;
		add(spinner, gbc_spinner);
		
		lblDestinatarios = new JLabel("Destinatarios:");
		GridBagConstraints gbc_lblDestinatarios = new GridBagConstraints();
		gbc_lblDestinatarios.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarios.gridx = 4;
		gbc_lblDestinatarios.gridy = 3;
		add(lblDestinatarios, gbc_lblDestinatarios);
		
		cbDestinatarios = new JComboBox();
		GridBagConstraints gbc_cbDestinatarios = new GridBagConstraints();
		gbc_cbDestinatarios.insets = new Insets(0, 0, 5, 5);
		gbc_cbDestinatarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDestinatarios.gridx = 5;
		gbc_cbDestinatarios.gridy = 3;
		add(cbDestinatarios, gbc_cbDestinatarios);
		
		lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 4;
		add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 4;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		lblArea = new JLabel("Área:");
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.anchor = GridBagConstraints.EAST;
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 4;
		gbc_lblArea.gridy = 4;
		add(lblArea, gbc_lblArea);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		lblHorario = new JLabel("Horario:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 5;
		add(lblHorario, gbc_lblHorario);
		
		cbHorario = new JComboBox();
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 1;
		gbc_cbHorario.gridy = 5;
		add(cbHorario, gbc_cbHorario);
		
		lblDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.gridx = 4;
		gbc_lblDescripcion.gridy = 5;
		add(lblDescripcion, gbc_lblDescripcion);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 5;
		gbc_textArea.gridy = 5;
		add(textArea, gbc_textArea);
		
		lblMateriales = new JLabel("Materiales:");
		GridBagConstraints gbc_lblMateriales = new GridBagConstraints();
		gbc_lblMateriales.anchor = GridBagConstraints.EAST;
		gbc_lblMateriales.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateriales.gridx = 4;
		gbc_lblMateriales.gridy = 7;
		add(lblMateriales, gbc_lblMateriales);
		
		textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridwidth = 2;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 5;
		gbc_textArea_1.gridy = 7;
		add(textArea_1, gbc_textArea_1);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 9;
		add(btnCancelar, gbc_btnCancelar);
		
		btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.gridx = 6;
		gbc_btnAplicarCambios.gridy = 9;
		add(btnAplicarCambios, gbc_btnAplicarCambios);

	}

}
