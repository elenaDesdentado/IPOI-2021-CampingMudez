package presentacion;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import dominio.Monitor;
import persistencia.Monitores;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelFormularioMonitores extends JPanel {

	public JLabel lblAvatar;
	public JButton btnAniadirAvatar;
	public JLabel lblSueldo;
	public JTextField txtSueldo;
	private JLabel lblHorario;
	public JComboBox cbHorario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblMovil;
	private JLabel lblCorreo;
	private JLabel lblIdiomas;
	public JTextField txtNombre;
	public JTextField txtApellidos;
	public JButton btnAplicarCambios;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	public JFormattedTextField ftxtDNI;
	public JFormattedTextField ftxtMovil;
	public JFormattedTextField ftxtFijo;
	public JTextField txtCorreo;
	private JLabel lblEstudios;
	public JComboBox cbEstudios;
	private JScrollPane spIdiomas;
	public JButton btnAniadirIdioma;
	public JList lstIdiomas;
	private JLabel lblSimboloEuros;
	public JButton btnModificar;

	private int indice; // Indice del monitor en la lsita
	private Monitores monitoresDb;
	private JLabel lblDisponibilidad;
	private JList lstMonitores;
	public JComboBox cbDisponibilidad;
	private JLabel lblFijo;
	private JLabel lblEdad;
	public JSpinner spnEdad;

	/**
	 * Create the panel.
	 */
	public PanelFormularioMonitores(JList lstMonitores, Monitores db, int indice) {

		this.lstMonitores = lstMonitores;
		this.monitoresDb = db;
		this.indice = indice;

		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 23, 86, 0, 41, 61, 0, 20, 0, 108, 44, 103, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 28, 0, 0, 0, 0, 0, 0, 0, 0, 24, 60, 39, 34, 32, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblAvatar = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridheight = 2;
		gbc_lblAvatar.gridwidth = 4;
		gbc_lblAvatar.gridx = 1;
		gbc_lblAvatar.gridy = 1;
		add(lblAvatar, gbc_lblAvatar);

		btnModificar = new JButton(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.btnModificar.text")); //$NON-NLS-1$
		btnModificar.addKeyListener(new BtnModificarKeyListener());
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 10;
		gbc_btnModificar.gridy = 1;
		add(btnModificar, gbc_btnModificar);

		lblNombre = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 7;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 8;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		btnAniadirAvatar = new JButton(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.btnAniadirAvatar.text")); //$NON-NLS-1$
		btnAniadirAvatar.addKeyListener(new BtnAniadirAvatarKeyListener());
		btnAniadirAvatar.addActionListener(new BtnAniadirAvatarActionListener());
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 4;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 1;
		gbc_btnAniadirAvatar.gridy = 3;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);

		lblApellidos = new JLabel(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblApellidos.text")); //$NON-NLS-1$
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 7;
		gbc_lblApellidos.gridy = 3;
		add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 2;
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 8;
		gbc_txtApellidos.gridy = 3;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);

		lblEdad = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblEdad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 7;
		gbc_lblEdad.gridy = 4;
		add(lblEdad, gbc_lblEdad);

		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(16, 16, 67, 1));
		GridBagConstraints gbc_spnEdad = new GridBagConstraints();
		gbc_spnEdad.anchor = GridBagConstraints.WEST;
		gbc_spnEdad.insets = new Insets(0, 0, 5, 5);
		gbc_spnEdad.gridx = 8;
		gbc_spnEdad.gridy = 4;
		add(spnEdad, gbc_spnEdad);

		lblDNI = new JLabel("DNI/NIF:"); //$NON-NLS-1$
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 7;
		gbc_lblDNI.gridy = 5;
		add(lblDNI, gbc_lblDNI);

		MaskFormatter formatoDNI;
		try {
			formatoDNI = new MaskFormatter("########U"); //$NON-NLS-1$
			formatoDNI.setPlaceholderCharacter('X');
			ftxtDNI = new JFormattedTextField(formatoDNI);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 8;
		gbc_ftxtDNI.gridy = 5;
		add(ftxtDNI, gbc_ftxtDNI);

		txtSueldo = new JTextField();
		GridBagConstraints gbc_txtSueldo = new GridBagConstraints();
		gbc_txtSueldo.gridwidth = 3;
		gbc_txtSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSueldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSueldo.gridx = 2;
		gbc_txtSueldo.gridy = 7;
		add(txtSueldo, gbc_txtSueldo);
		txtSueldo.setColumns(10);

		lblSimboloEuros = new JLabel("€"); //$NON-NLS-1$
		GridBagConstraints gbc_lblSimboloEuros = new GridBagConstraints();
		gbc_lblSimboloEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimboloEuros.gridx = 5;
		gbc_lblSimboloEuros.gridy = 7;
		add(lblSimboloEuros, gbc_lblSimboloEuros);

		lblMovil = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblMovil.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 7;
		gbc_lblMovil.gridy = 6;
		add(lblMovil, gbc_lblMovil);

		MaskFormatter formatoMovil;
		try {
			formatoMovil = new MaskFormatter("###' ##' ##' ##"); //$NON-NLS-1$
			formatoMovil.setPlaceholderCharacter('*');
			ftxtMovil = new JFormattedTextField(formatoMovil);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtMovil = new GridBagConstraints();
		gbc_ftxtMovil.gridwidth = 2;
		gbc_ftxtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtMovil.gridx = 8;
		gbc_ftxtMovil.gridy = 6;
		add(ftxtMovil, gbc_ftxtMovil);

		lblSueldo = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblSueldo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
		gbc_lblSueldo.anchor = GridBagConstraints.EAST;
		gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSueldo.gridx = 1;
		gbc_lblSueldo.gridy = 7;
		add(lblSueldo, gbc_lblSueldo);

		lblFijo = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblFijo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.gridx = 7;
		gbc_lblFijo.gridy = 7;
		add(lblFijo, gbc_lblFijo);

		MaskFormatter formatoFijo;
		try {
			formatoFijo = new MaskFormatter("###' ##' ##' ##"); //$NON-NLS-1$
			formatoFijo.setPlaceholderCharacter('*');
			ftxtFijo = new JFormattedTextField(formatoFijo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagConstraints gbc_ftxtFijo = new GridBagConstraints();
		gbc_ftxtFijo.gridwidth = 2;
		gbc_ftxtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFijo.gridx = 8;
		gbc_ftxtFijo.gridy = 7;
		add(ftxtFijo, gbc_ftxtFijo);

		lblHorario = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblHorario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 8;
		add(lblHorario, gbc_lblHorario);

		cbHorario = new JComboBox();
		cbHorario.setModel(new DefaultComboBoxModel(new String[] { "7:00-14:00", "8:00-15:00", "9:30-14:30", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"10:00-15:00", "15:00-22:00", "15:30-23:00" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.gridwidth = 4;
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 2;
		gbc_cbHorario.gridy = 8;
		add(cbHorario, gbc_cbHorario);

		lblCorreo = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblCorreo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.gridx = 7;
		gbc_lblCorreo.gridy = 8;
		add(lblCorreo, gbc_lblCorreo);

		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridwidth = 3;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 8;
		gbc_txtCorreo.gridy = 8;
		add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);

		lblDisponibilidad = new JLabel(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblDisponibilidad.text")); //$NON-NLS-1$
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDisponibilidad = new GridBagConstraints();
		gbc_lblDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidad.gridx = 1;
		gbc_lblDisponibilidad.gridy = 9;
		add(lblDisponibilidad, gbc_lblDisponibilidad);

		cbDisponibilidad = new JComboBox();
		cbDisponibilidad.setModel(new DefaultComboBoxModel(
				new String[] { MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptDisponible"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptBaja"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptVacaciones") })); //$NON-NLS-1$
		GridBagConstraints gbc_cbDisponibilidad = new GridBagConstraints();
		gbc_cbDisponibilidad.gridwidth = 4;
		gbc_cbDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_cbDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDisponibilidad.gridx = 2;
		gbc_cbDisponibilidad.gridy = 9;
		add(cbDisponibilidad, gbc_cbDisponibilidad);

		lblEstudios = new JLabel(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblEstudios.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstudios = new GridBagConstraints();
		gbc_lblEstudios.anchor = GridBagConstraints.EAST;
		gbc_lblEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstudios.gridx = 7;
		gbc_lblEstudios.gridy = 9;
		add(lblEstudios, gbc_lblEstudios);

		cbEstudios = new JComboBox();
		cbEstudios.setModel(new DefaultComboBoxModel(
				new String[] { MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptNinguno"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptESO"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptBachillerato"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptFP"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptUni"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.OptPostUni") })); //$NON-NLS-1$
		GridBagConstraints gbc_cbEstudios = new GridBagConstraints();
		gbc_cbEstudios.gridwidth = 3;
		gbc_cbEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstudios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstudios.gridx = 8;
		gbc_cbEstudios.gridy = 9;
		add(cbEstudios, gbc_cbEstudios);

		lblIdiomas = new JLabel(MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.lblIdiomas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblIdiomas = new GridBagConstraints();
		gbc_lblIdiomas.anchor = GridBagConstraints.EAST;
		gbc_lblIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdiomas.gridx = 7;
		gbc_lblIdiomas.gridy = 10;
		add(lblIdiomas, gbc_lblIdiomas);

		spIdiomas = new JScrollPane();
		GridBagConstraints gbc_spIdiomas = new GridBagConstraints();
		gbc_spIdiomas.gridwidth = 2;
		gbc_spIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_spIdiomas.fill = GridBagConstraints.BOTH;
		gbc_spIdiomas.gridx = 8;
		gbc_spIdiomas.gridy = 10;
		add(spIdiomas, gbc_spIdiomas);

		DefaultListModel model = new DefaultListModel();
		lstIdiomas = new JList(model);
		spIdiomas.setViewportView(lstIdiomas);

		btnAniadirIdioma = new JButton(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.btnAniadirIdioma.text")); //$NON-NLS-1$
		btnAniadirIdioma.addKeyListener(new BtnAniadirIdiomaKeyListener());
		btnAniadirIdioma.addActionListener(new BtnAniadirIdiomaActionListener());
		GridBagConstraints gbc_btnAniadirIdioma = new GridBagConstraints();
		gbc_btnAniadirIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirIdioma.gridx = 10;
		gbc_btnAniadirIdioma.gridy = 10;
		add(btnAniadirIdioma, gbc_btnAniadirIdioma);

		btnAplicarCambios = new JButton(
				MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.btnAplicarCambios.text")); //$NON-NLS-1$
		btnAplicarCambios.addKeyListener(new BtnAplicarCambiosKeyListener());
		btnAplicarCambios.addActionListener(new BtnAplicarCambiosActionListener());
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 5, 5);
		gbc_btnAplicarCambios.gridx = 10;
		gbc_btnAplicarCambios.gridy = 12;
		add(btnAplicarCambios, gbc_btnAplicarCambios);
	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			btnAniadirAvatar.setEnabled(true);
			btnAplicarCambios.setEnabled(true);
			btnAniadirIdioma.setEnabled(true);
			lstIdiomas.setEnabled(true);
			txtNombre.setEnabled(true);
			txtApellidos.setEnabled(true);
			spnEdad.setEnabled(true);
			ftxtDNI.setEnabled(true);
			ftxtMovil.setEnabled(true);
			ftxtFijo.setEnabled(true);
			txtCorreo.setEnabled(true);
			cbEstudios.setEnabled(true);
			txtSueldo.setEnabled(true);
			cbHorario.setEnabled(true);
			cbDisponibilidad.setEnabled(true);
		}
	}

	private class BtnModificarKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				btnAniadirAvatar.setEnabled(true);
				btnAplicarCambios.setEnabled(true);
				btnAniadirIdioma.setEnabled(true);
				lstIdiomas.setEnabled(true);
				txtNombre.setEnabled(true);
				txtApellidos.setEnabled(true);
				spnEdad.setEnabled(true);
				ftxtDNI.setEnabled(true);
				ftxtMovil.setEnabled(true);
				ftxtFijo.setEnabled(true);
				txtCorreo.setEnabled(true);
				cbEstudios.setEnabled(true);
				txtSueldo.setEnabled(true);
				cbHorario.setEnabled(true);
				cbDisponibilidad.setEnabled(true);
			}
		}
	}

	private class BtnAniadirIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nuevoIdioma = (String) JOptionPane.showInputDialog(null,
					MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.IntroduzcaUn") //$NON-NLS-1$
							+ MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.NuevoIdioma"), //$NON-NLS-1$
					MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.TituloIntroduzcaIdioma"), //$NON-NLS-1$
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			Monitor monitor = monitoresDb.getMonitores().get(indice);
			if (monitor.getIdiomas() == null)
				monitor.setIdiomas(new ArrayList<String>());
			monitor.getIdiomas().add(nuevoIdioma);
			DefaultListModel modeloLista = (DefaultListModel) lstIdiomas.getModel();
			modeloLista.addElement(nuevoIdioma);
		}
	}

	private class BtnAniadirIdiomaKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				String nuevoIdioma = (String) JOptionPane.showInputDialog(null,
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.IntroduzcaUn") //$NON-NLS-1$
								+ MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.NuevoIdioma"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.TituloIntroduzcaIdioma"), //$NON-NLS-1$
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (!nuevoIdioma.isEmpty()) {
					Monitor monitor = monitoresDb.getMonitores().get(indice);
					if (monitor.getIdiomas() == null)
						monitor.setIdiomas(new ArrayList<String>());
					monitor.getIdiomas().add(nuevoIdioma);
					DefaultListModel modeloLista = (DefaultListModel) lstIdiomas.getModel();
					modeloLista.addElement(nuevoIdioma);
				}
			}
		}
	}

	private class BtnAplicarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Monitor monitor = monitoresDb.getMonitores().get(indice);
			try {
				monitor.setNombre(txtNombre.getText());
				monitor.setApellidos(txtApellidos.getText());
				monitor.setEdad((Integer) spnEdad.getValue());
				monitor.setDni(ftxtDNI.getText());
				monitor.setMovil(ftxtMovil.getText());
				monitor.setFijo(ftxtFijo.getText());
				if (txtCorreo.getText().contains("@") && txtCorreo.getText().contains(".")) //$NON-NLS-1$ //$NON-NLS-2$
					monitor.setCorreo(txtCorreo.getText());
				else
					JOptionPane.showMessageDialog(null, MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.CorreoInvalido1"), //$NON-NLS-1$
							MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.CorreoInvalidoTitulo1"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
				monitor.setSueldo(Double.valueOf(txtSueldo.getText()));
				monitor.setEstudios((String) cbEstudios.getSelectedItem());
				monitor.setHorario((String) cbHorario.getSelectedItem());
				monitor.setDisponibilidad((String) cbDisponibilidad.getSelectedItem());
				monitor.setAvatar((ImageIcon) lblAvatar.getIcon());
				DefaultListModel modelo = (DefaultListModel) lstIdiomas.getModel();
				ArrayList<String> nuevosIdiomas = new ArrayList<String>();
				for (int i = 0; i < modelo.getSize(); ++i)
					nuevosIdiomas.add(modelo.get(i).toString());
				monitor.setIdiomas(nuevosIdiomas);
				DefaultListModel modeloMonitores = (DefaultListModel) lstMonitores.getModel();
				if (modeloMonitores.getSize() == indice)
					modeloMonitores.addElement(null); // En caso de nuevo monitor, agregarlo al modelo
				modeloMonitores.set(indice, new PanelMonitorRenderer(monitor));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.Error"), //$NON-NLS-1$
						MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.TituloError"), //$NON-NLS-1$
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class BtnAplicarCambiosKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Monitor monitor = monitoresDb.getMonitores().get(indice);
				try {
					monitor.setNombre(txtNombre.getText());
					monitor.setApellidos(txtApellidos.getText());
					monitor.setEdad((Integer) spnEdad.getValue());
					monitor.setDni(ftxtDNI.getText());
					monitor.setMovil(ftxtMovil.getText());
					monitor.setFijo(ftxtFijo.getText());
					if (txtCorreo.getText().contains("@") && txtCorreo.getText().contains(".")) //$NON-NLS-1$ //$NON-NLS-2$
						monitor.setCorreo(txtCorreo.getText());
					else
						JOptionPane.showMessageDialog(null, MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.CorreoInvalido2"), //$NON-NLS-1$
								MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.CorreoInvalidoTitulo2"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
					monitor.setSueldo(Double.valueOf(txtSueldo.getText()));
					monitor.setEstudios((String) cbEstudios.getSelectedItem());
					monitor.setHorario((String) cbHorario.getSelectedItem());
					monitor.setDisponibilidad((String) cbDisponibilidad.getSelectedItem());
					monitor.setAvatar((ImageIcon) lblAvatar.getIcon());
					DefaultListModel modelo = (DefaultListModel) lstIdiomas.getModel();
					ArrayList<String> nuevosIdiomas = new ArrayList<String>();
					for (int i = 0; i < modelo.getSize(); ++i)
						nuevosIdiomas.add(modelo.get(i).toString());
					monitor.setIdiomas(nuevosIdiomas);
					DefaultListModel modeloMonitores = (DefaultListModel) lstMonitores.getModel();
					if (modeloMonitores.getSize() == indice)
						modeloMonitores.addElement(null); // En caso de nuevo monitor, agregarlo al modelo
					modeloMonitores.set(indice, new PanelMonitorRenderer(monitor));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.Error"), //$NON-NLS-1$
							MessagesPanelFormularioMonitores.getString("PanelFormularioMonitores.TituloError"), //$NON-NLS-1$
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class BtnAniadirAvatarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(null);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				Image imagenOriginal;
				try {
					imagenOriginal = ImageIO.read(file);
					Image imagenEscalada = imagenOriginal.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
					ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
					lblAvatar.setIcon(iconoLabel);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private class BtnAniadirAvatarKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				JFileChooser fcAbrir = new JFileChooser();
				int valorDevuelto = fcAbrir.showOpenDialog(null);
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					File file = fcAbrir.getSelectedFile();
					Image imagenOriginal;
					try {
						imagenOriginal = ImageIO.read(file);
						Image imagenEscalada = imagenOriginal.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
						ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
						lblAvatar.setIcon(iconoLabel);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
