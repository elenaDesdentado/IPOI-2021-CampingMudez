package presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class PanelFormularioMonitores extends JPanel {

	private JLabel lblAvatar;
	private JButton btnAniadirAvatar;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblHorario;
	private JComboBox cbHorario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblMovil;
	private JLabel lblFijo;
	private JLabel lblCorreo;
	private JLabel lblMateriales;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JComboBox cbDestinatarios;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JButton btnAplicarCambios;
	private JButton btnCancelar;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private JFormattedTextField formattedTextField;
	
	/**
	 * Create the panel.
	 */
	public PanelFormularioMonitores() {
		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 108, 0, 0};
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
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 5;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 4;
		gbc_lblApellidos.gridy = 1;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 2;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 5;
		gbc_txtApellidos.gridy = 1;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		btnAniadirAvatar = new JButton("Añadir foto...");
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 3;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 0;
		gbc_btnAniadirAvatar.gridy = 2;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);
		
		lblDNI = new JLabel("DNI/NIF:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 4;
		gbc_lblDNI.gridy = 2;
		add(lblDNI, gbc_lblDNI);
		
		formattedTextField = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 5;
		gbc_formattedTextField.gridy = 2;
		add(formattedTextField, gbc_formattedTextField);
		
		lblMovil = new JLabel("Teléfono móvil:");
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 4;
		gbc_lblMovil.gridy = 3;
		add(lblMovil, gbc_lblMovil);
		
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
		
		lblFijo = new JLabel("Teléfono fijo:");
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.gridx = 4;
		gbc_lblFijo.gridy = 4;
		add(lblFijo, gbc_lblFijo);
		
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
		
		lblCorreo = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.gridx = 4;
		gbc_lblCorreo.gridy = 5;
		add(lblCorreo, gbc_lblCorreo);
		
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
