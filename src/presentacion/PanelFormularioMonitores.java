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

import dominio.Monitor;
import persistencia.Monitores;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
	private JButton btnModificar;

	private int indice; // Indice del monitor en la lsita
	private Monitores monitoresDb;
	private JLabel lblDisponibilidad;
	private JList lstMonitores;
	public JComboBox cbDisponibilidad;
	private JLabel lblFijo;

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
		gridBagLayout.rowHeights = new int[] { 28, 0, 0, 0, 0, 0, 0, 0, 24, 60, 39, 34, 32, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblAvatar = new JLabel("");
		GridBagConstraints gbc_lblAvatar = new GridBagConstraints();
		gbc_lblAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvatar.gridheight = 2;
		gbc_lblAvatar.gridwidth = 4;
		gbc_lblAvatar.gridx = 1;
		gbc_lblAvatar.gridy = 1;
		add(lblAvatar, gbc_lblAvatar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 10;
		gbc_btnModificar.gridy = 1;
		add(btnModificar, gbc_btnModificar);

		lblNombre = new JLabel("Nombre:");
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

		btnAniadirAvatar = new JButton("Añadir foto...");
		btnAniadirAvatar.addActionListener(new BtnAniadirAvatarActionListener());
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 4;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 1;
		gbc_btnAniadirAvatar.gridy = 3;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);

		lblApellidos = new JLabel("Apellidos:");
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

		lblDNI = new JLabel("DNI/NIF:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 7;
		gbc_lblDNI.gridy = 4;
		add(lblDNI, gbc_lblDNI);

		ftxtDNI = new JFormattedTextField();
		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 8;
		gbc_ftxtDNI.gridy = 4;
		add(ftxtDNI, gbc_ftxtDNI);

		txtSueldo = new JTextField();
		GridBagConstraints gbc_txtSueldo = new GridBagConstraints();
		gbc_txtSueldo.gridwidth = 3;
		gbc_txtSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_txtSueldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSueldo.gridx = 2;
		gbc_txtSueldo.gridy = 6;
		add(txtSueldo, gbc_txtSueldo);
		txtSueldo.setColumns(10);

		lblSimboloEuros = new JLabel("€");
		GridBagConstraints gbc_lblSimboloEuros = new GridBagConstraints();
		gbc_lblSimboloEuros.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimboloEuros.gridx = 5;
		gbc_lblSimboloEuros.gridy = 6;
		add(lblSimboloEuros, gbc_lblSimboloEuros);

		lblMovil = new JLabel("Teléfono móvil:");
		GridBagConstraints gbc_lblMovil = new GridBagConstraints();
		gbc_lblMovil.anchor = GridBagConstraints.EAST;
		gbc_lblMovil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMovil.gridx = 7;
		gbc_lblMovil.gridy = 5;
		add(lblMovil, gbc_lblMovil);

		ftxtMovil = new JFormattedTextField();
		GridBagConstraints gbc_ftxtMovil = new GridBagConstraints();
		gbc_ftxtMovil.gridwidth = 2;
		gbc_ftxtMovil.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtMovil.gridx = 8;
		gbc_ftxtMovil.gridy = 5;
		add(ftxtMovil, gbc_ftxtMovil);

		lblSueldo = new JLabel("Sueldo:");
		GridBagConstraints gbc_lblSueldo = new GridBagConstraints();
		gbc_lblSueldo.anchor = GridBagConstraints.EAST;
		gbc_lblSueldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSueldo.gridx = 1;
		gbc_lblSueldo.gridy = 6;
		add(lblSueldo, gbc_lblSueldo);
		
		lblFijo = new JLabel("Teléfono fijo:");
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.gridx = 7;
		gbc_lblFijo.gridy = 6;
		add(lblFijo, gbc_lblFijo);

		ftxtFijo = new JFormattedTextField();
		GridBagConstraints gbc_ftxtFijo = new GridBagConstraints();
		gbc_ftxtFijo.gridwidth = 2;
		gbc_ftxtFijo.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFijo.gridx = 8;
		gbc_ftxtFijo.gridy = 6;
		add(ftxtFijo, gbc_ftxtFijo);

		lblHorario = new JLabel("Horario:");
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 7;
		add(lblHorario, gbc_lblHorario);

		cbHorario = new JComboBox();
		cbHorario.setModel(new DefaultComboBoxModel(new String[] { "7:00-14:00", "8:00-15:00", "9:30-14:30",
				"10:00-15:00", "15:00-22:00", "15:30-23:00" }));
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.gridwidth = 4;
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 2;
		gbc_cbHorario.gridy = 7;
		add(cbHorario, gbc_cbHorario);

		lblCorreo = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.gridx = 7;
		gbc_lblCorreo.gridy = 7;
		add(lblCorreo, gbc_lblCorreo);

		txtCorreo = new JTextField();
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridwidth = 3;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.gridx = 8;
		gbc_txtCorreo.gridy = 7;
		add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);

		lblDisponibilidad = new JLabel("Disponibilidad:");
		lblDisponibilidad.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDisponibilidad = new GridBagConstraints();
		gbc_lblDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidad.gridx = 1;
		gbc_lblDisponibilidad.gridy = 8;
		add(lblDisponibilidad, gbc_lblDisponibilidad);

		cbDisponibilidad = new JComboBox();
		cbDisponibilidad
				.setModel(new DefaultComboBoxModel(new String[] { "Disponible", "Baja laboral", "Vacaciones" }));
		GridBagConstraints gbc_cbDisponibilidad = new GridBagConstraints();
		gbc_cbDisponibilidad.gridwidth = 4;
		gbc_cbDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_cbDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDisponibilidad.gridx = 2;
		gbc_cbDisponibilidad.gridy = 8;
		add(cbDisponibilidad, gbc_cbDisponibilidad);

		lblEstudios = new JLabel("Nivel de estudios:");
		GridBagConstraints gbc_lblEstudios = new GridBagConstraints();
		gbc_lblEstudios.anchor = GridBagConstraints.EAST;
		gbc_lblEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstudios.gridx = 7;
		gbc_lblEstudios.gridy = 8;
		add(lblEstudios, gbc_lblEstudios);

		cbEstudios = new JComboBox();
		cbEstudios.setModel(new DefaultComboBoxModel(new String[] { "Ninguno", "Educación Secundaria Obligatoria",
				"Bachillerato", "Formación Profesional", "Estudios Universitarios", "Estudios post-universitarios" }));
		GridBagConstraints gbc_cbEstudios = new GridBagConstraints();
		gbc_cbEstudios.gridwidth = 3;
		gbc_cbEstudios.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstudios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstudios.gridx = 8;
		gbc_cbEstudios.gridy = 8;
		add(cbEstudios, gbc_cbEstudios);

		lblIdiomas = new JLabel("Idiomas:");
		GridBagConstraints gbc_lblIdiomas = new GridBagConstraints();
		gbc_lblIdiomas.anchor = GridBagConstraints.EAST;
		gbc_lblIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdiomas.gridx = 7;
		gbc_lblIdiomas.gridy = 9;
		add(lblIdiomas, gbc_lblIdiomas);

		spIdiomas = new JScrollPane();
		GridBagConstraints gbc_spIdiomas = new GridBagConstraints();
		gbc_spIdiomas.gridwidth = 2;
		gbc_spIdiomas.insets = new Insets(0, 0, 5, 5);
		gbc_spIdiomas.fill = GridBagConstraints.BOTH;
		gbc_spIdiomas.gridx = 8;
		gbc_spIdiomas.gridy = 9;
		add(spIdiomas, gbc_spIdiomas);

		DefaultListModel model = new DefaultListModel();
		lstIdiomas = new JList(model);
		spIdiomas.setViewportView(lstIdiomas);

		btnAniadirIdioma = new JButton("Añadir...");
		btnAniadirIdioma.addActionListener(new BtnAniadirIdiomaActionListener());
		GridBagConstraints gbc_btnAniadirIdioma = new GridBagConstraints();
		gbc_btnAniadirIdioma.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirIdioma.gridx = 10;
		gbc_btnAniadirIdioma.gridy = 9;
		add(btnAniadirIdioma, gbc_btnAniadirIdioma);

		btnAplicarCambios = new JButton("Aplicar cambios");
		btnAplicarCambios.addActionListener(new BtnAplicarCambiosActionListener());
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 5, 5);
		gbc_btnAplicarCambios.gridx = 10;
		gbc_btnAplicarCambios.gridy = 11;
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

	private class BtnAniadirIdiomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nuevoIdioma = JOptionPane.showInputDialog("Introduzca un nuevo idioma");
			Monitor monitor = monitoresDb.getMonitores().get(indice);
			monitor.getIdiomas().add(nuevoIdioma);	// En caso de nuevo panel con nuevop monitor, crear lista vacia y setear y tal...
			DefaultListModel modeloLista = (DefaultListModel) lstIdiomas.getModel();
			modeloLista.addElement(nuevoIdioma);
		}
	}

	private class BtnAplicarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Monitor monitor = null;
			try {
				monitor = monitoresDb.getMonitores().get(indice);
			} catch (IndexOutOfBoundsException ex) {
				monitoresDb.addMonitor(new Monitor());
				monitor = monitoresDb.getMonitores().get(indice);
			}

			monitor.setNombre(txtNombre.getText());
			monitor.setApellidos(txtApellidos.getText());
			monitor.setDni(ftxtDNI.getText());
			monitor.setMovil(ftxtMovil.getText());
			monitor.setFijo(ftxtFijo.getText());
			monitor.setCorreo(txtCorreo.getText());
			monitor.setSueldo(Double.valueOf(txtSueldo.getText()));
			monitor.setEstudios((String) cbEstudios.getSelectedItem());
			monitor.setHorario((String) cbHorario.getSelectedItem());
			/*monitor.setDisponibilidad((String) cbDisponibilidad.getSelectedItem());
			String iconfilename = ((ImageIcon) lblAvatar.getIcon()).getDescription();
			String fileName = "./" + iconfilename.substring(iconfilename.lastIndexOf('\\') + 1);
			monitor.setAvatar(fileName);*/
			DefaultListModel modelo = (DefaultListModel) lstIdiomas.getModel();
			ArrayList<String> nuevosIdiomas = new ArrayList<String>();
			for (int i = 0; i < modelo.getSize(); ++i)
				nuevosIdiomas.add(modelo.get(i).toString());
			monitor.setIdiomas(nuevosIdiomas);
			// Alguna forma mas eficiente de refrescar las listas?
			DefaultListModel modeloMonitores = (DefaultListModel) lstMonitores.getModel();
			try {
				modeloMonitores.set(indice, new PanelMonitorRenderer(monitor));
			} catch (IndexOutOfBoundsException ex) {
				modeloMonitores.add(indice, new PanelMonitorRenderer(monitor));
			}
			
		}
	}

	private class BtnAniadirAvatarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(null);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				lblAvatar.setIcon(new ImageIcon(file.getAbsolutePath()));
			}
		}
	}
}
