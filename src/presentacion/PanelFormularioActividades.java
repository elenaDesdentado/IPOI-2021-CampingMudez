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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFormularioActividades extends JPanel {
	public JLabel lblFoto;
	public JButton btnAniadirAvatar;
	private JLabel lblPrecio;
	public JTextField txtPrecio;
	private JLabel lblHorario;
	public JComboBox cbHorario;
	private JLabel lblNombre;
	private JLabel lblMonitor;
	private JLabel lblCupo;
	private JLabel lblDestinatarios;
	private JLabel lblArea;
	private JLabel lblDescripcion;
	private JLabel lblMateriales;
	public JTextField txtNombre;
	public JTextField txtMonitor;
	public JSpinner spinCupo;
	public JComboBox cbDestinatarios;
	public JComboBox cbArea;
	public JTextArea tADescripcion;
	public JTextArea tAMateriales;
	public JButton btnAplicarCambios;
	public JButton btnCancelar;
	
	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	private JLabel lblSimboloEuro;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public PanelFormularioActividades() {
		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{47, 0, 67, 0, 76, 0, 0, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{27, 28, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 7;
		gbc_btnModificar.gridy = 1;
		add(btnModificar, gbc_btnModificar);
		
		lblFoto = new JLabel("");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridheight = 2;
		gbc_lblFoto.gridwidth = 3;
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 2;
		add(lblFoto, gbc_lblFoto);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 5;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 6;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		btnAniadirAvatar = new JButton("Añadir foto...");
		btnAniadirAvatar.setEnabled(false);
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 3;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 1;
		gbc_btnAniadirAvatar.gridy = 4;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);
		
		lblMonitor = new JLabel("Monitor:");
		lblMonitor.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 5;
		gbc_lblMonitor.gridy = 4;
		add(lblMonitor, gbc_lblMonitor);
		
		txtMonitor = new JTextField();
		txtMonitor.setEditable(false);
		GridBagConstraints gbc_txtMonitor = new GridBagConstraints();
		gbc_txtMonitor.gridwidth = 2;
		gbc_txtMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_txtMonitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMonitor.gridx = 6;
		gbc_txtMonitor.gridy = 4;
		add(txtMonitor, gbc_txtMonitor);
		txtMonitor.setColumns(10);
		
		lblCupo = new JLabel("Cupo:");
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 5;
		gbc_lblCupo.gridy = 5;
		add(lblCupo, gbc_lblCupo);
		
		spinCupo = new JSpinner();
		spinCupo.setEnabled(false);
		spinCupo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GridBagConstraints gbc_spinCupo = new GridBagConstraints();
		gbc_spinCupo.anchor = GridBagConstraints.WEST;
		gbc_spinCupo.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupo.gridx = 6;
		gbc_spinCupo.gridy = 5;
		add(spinCupo, gbc_spinCupo);
		
		lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 6;
		add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 6;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);
		
		lblSimboloEuro = new JLabel("€");
		GridBagConstraints gbc_lblSimboloEuro = new GridBagConstraints();
		gbc_lblSimboloEuro.anchor = GridBagConstraints.WEST;
		gbc_lblSimboloEuro.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimboloEuro.gridx = 3;
		gbc_lblSimboloEuro.gridy = 6;
		add(lblSimboloEuro, gbc_lblSimboloEuro);
		
		lblDestinatarios = new JLabel("Destinatarios:");
		GridBagConstraints gbc_lblDestinatarios = new GridBagConstraints();
		gbc_lblDestinatarios.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatarios.gridx = 5;
		gbc_lblDestinatarios.gridy = 6;
		add(lblDestinatarios, gbc_lblDestinatarios);
		
		cbDestinatarios = new JComboBox();
		cbDestinatarios.setEditable(true);
		cbDestinatarios.setEnabled(false);
		cbDestinatarios.setModel(new DefaultComboBoxModel(new String[] {"Niños de menos de 12 años", "Niños de 12 a 14 años", "Niños de 14 a 17 años", "Adultos", "Adultos de más de 65 años"}));
		GridBagConstraints gbc_cbDestinatarios = new GridBagConstraints();
		gbc_cbDestinatarios.insets = new Insets(0, 0, 5, 5);
		gbc_cbDestinatarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDestinatarios.gridx = 6;
		gbc_cbDestinatarios.gridy = 6;
		add(cbDestinatarios, gbc_cbDestinatarios);
		
		lblHorario = new JLabel("Horario:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 7;
		add(lblHorario, gbc_lblHorario);
		
		cbHorario = new JComboBox();
		cbHorario.setEnabled(false);
		cbHorario.setEditable(true);
		cbHorario.setModel(new DefaultComboBoxModel(new String[] {"9:00-12:00", "10:00-11:30", "11:00-12:00", "15:30-17:00", "16:00-18:00", "19:00-21:00"}));
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.gridwidth = 2;
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 2;
		gbc_cbHorario.gridy = 7;
		add(cbHorario, gbc_cbHorario);
		
		lblArea = new JLabel("Área:");
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.anchor = GridBagConstraints.EAST;
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 5;
		gbc_lblArea.gridy = 7;
		add(lblArea, gbc_lblArea);
		
		cbArea = new JComboBox();
		cbArea.setEditable(true);
		cbArea.setEnabled(false);
		cbArea.setModel(new DefaultComboBoxModel(new String[] {"Escorpión", "Ciervo", "Salmón", "Águila"}));
		GridBagConstraints gbc_cbArea = new GridBagConstraints();
		gbc_cbArea.insets = new Insets(0, 0, 5, 5);
		gbc_cbArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbArea.gridx = 6;
		gbc_cbArea.gridy = 7;
		add(cbArea, gbc_cbArea);
		
		lblDescripcion = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.gridx = 5;
		gbc_lblDescripcion.gridy = 8;
		add(lblDescripcion, gbc_lblDescripcion);
		
		tADescripcion = new JTextArea();
		tADescripcion.setEditable(false);
		tADescripcion.setLineWrap(true);
		GridBagConstraints gbc_tADescripcion = new GridBagConstraints();
		gbc_tADescripcion.gridheight = 2;
		gbc_tADescripcion.gridwidth = 2;
		gbc_tADescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_tADescripcion.fill = GridBagConstraints.BOTH;
		gbc_tADescripcion.gridx = 6;
		gbc_tADescripcion.gridy = 8;
		add(tADescripcion, gbc_tADescripcion);
		
		lblMateriales = new JLabel("Materiales:");
		GridBagConstraints gbc_lblMateriales = new GridBagConstraints();
		gbc_lblMateriales.anchor = GridBagConstraints.EAST;
		gbc_lblMateriales.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateriales.gridx = 5;
		gbc_lblMateriales.gridy = 10;
		add(lblMateriales, gbc_lblMateriales);
		
		tAMateriales = new JTextArea();
		tAMateriales.setEditable(false);
		tAMateriales.setLineWrap(true);
		GridBagConstraints gbc_tAMateriales = new GridBagConstraints();
		gbc_tAMateriales.gridwidth = 2;
		gbc_tAMateriales.insets = new Insets(0, 0, 5, 5);
		gbc_tAMateriales.fill = GridBagConstraints.BOTH;
		gbc_tAMateriales.gridx = 6;
		gbc_tAMateriales.gridy = 10;
		add(tAMateriales, gbc_tAMateriales);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 13;
		add(btnCancelar, gbc_btnCancelar);
		
		btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.setEnabled(false);
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnAplicarCambios.gridx = 7;
		gbc_btnAplicarCambios.gridy = 13;
		add(btnAplicarCambios, gbc_btnAplicarCambios);

	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnAniadirAvatar.setEnabled(true);
			btnAplicarCambios.setEnabled(true);
			btnCancelar.setEnabled(true);
			txtNombre.setEditable(true);
			txtMonitor.setEditable(true);
			txtPrecio.setEditable(true);
			spinCupo.setEnabled(true);
			tADescripcion.setEnabled(true);
			tAMateriales.setEnabled(true);
			cbDestinatarios.setEnabled(true);
			cbArea.setEnabled(true);
			cbHorario.setEnabled(true);
		}
	}
}
