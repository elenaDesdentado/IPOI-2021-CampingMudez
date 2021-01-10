package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import dominio.Ruta;
import dominio.Monitor;
import persistencia.Rutas;
import persistencia.Monitores;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelFormularioRutas extends JPanel {
	public JLabel lblFoto;
	public JButton btnAniadirAvatar;
	private JLabel lblNombre;
	private JLabel lblDia;
	private JLabel lblCupo;
	private JLabel lblEncuentro;
	private JLabel lblDificultad;
	public JTextField txtNombre;
	public JSpinner spinCupo;
	public JButton btnAplicarCambios;

	private Color colorFondo = new Color(255, 255, 255);
	private Color colorBoton = new Color(159, 177, 57);
	public JButton btnModificar;

	private int indice;
	private Rutas rutasDb = new Rutas(new ArrayList<Ruta>());
	private Monitores monitoresDb;
	private JList lstRutas;
	public JTextField txtEncuentro;
	private JLabel lblHorario;
	private JLabel lblDescripcion;
	private JScrollPane scrollPaneDescripcion;
	public JTextPane tPDescripcion;
	private JLabel lblMonitores;
	private JButton btnInfo;
	public JComboBox cbDificultad;
	public JComboBox cbHorario;
	public JComboBox cbDia;

	/**
	 * Create the panel.
	 */
	public PanelFormularioRutas(JList lstRutas, Rutas rutasDb, int indice, Monitores monitoresDb) {

		this.monitoresDb = monitoresDb;
		this.lstRutas = lstRutas;
		this.rutasDb = rutasDb;
		this.indice = indice;

		setBackground(colorFondo);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 0, 67, 219, 111, 97, 0, 40, 0 };
		gridBagLayout.rowHeights = new int[] { 27, 28, 21, 0, 0, 0, 0, 0, 0, 0, 20, 0, 15, 42, 40, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		btnModificar = new JButton(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.btnModificar.text")); //$NON-NLS-1$
		btnModificar.addKeyListener(new BtnModificarKeyListener());
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 6;
		gbc_btnModificar.gridy = 1;
		add(btnModificar, gbc_btnModificar);

		lblFoto = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridheight = 3;
		gbc_lblFoto.gridwidth = 2;
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 1;
		add(lblFoto, gbc_lblFoto);

		lblNombre = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 5;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		btnAniadirAvatar = new JButton(
				MessagesPanelFormularioRutas.getString("PanelFormularioRutas.btnAniadirAvatar.text")); //$NON-NLS-1$
		btnAniadirAvatar.addKeyListener(new BtnAniadirAvatarKeyListener());
		btnAniadirAvatar.addActionListener(new BtnAniadirAvatarActionListener());
		GridBagConstraints gbc_btnAniadirAvatar = new GridBagConstraints();
		gbc_btnAniadirAvatar.gridwidth = 2;
		gbc_btnAniadirAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirAvatar.gridx = 1;
		gbc_btnAniadirAvatar.gridy = 4;
		add(btnAniadirAvatar, gbc_btnAniadirAvatar);

		lblDia = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblDia.text")); //$NON-NLS-1$
		lblDia.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.anchor = GridBagConstraints.EAST;
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 4;
		gbc_lblDia.gridy = 4;
		add(lblDia, gbc_lblDia);

		cbDia = new JComboBox();
		cbDia.setModel(new DefaultComboBoxModel(
				new String[] { MessagesPanelFormularioRutas.getString("PanelFormularioRutas.1"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.2"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.3"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.4"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.5"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.6"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.7") })); //$NON-NLS-1$
		GridBagConstraints gbc_cbDia = new GridBagConstraints();
		gbc_cbDia.insets = new Insets(0, 0, 5, 5);
		gbc_cbDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDia.gridx = 5;
		gbc_cbDia.gridy = 4;
		add(cbDia, gbc_cbDia);

		lblHorario = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblHorario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 4;
		gbc_lblHorario.gridy = 5;
		add(lblHorario, gbc_lblHorario);

		cbHorario = new JComboBox();
		cbHorario.setModel(new DefaultComboBoxModel(new String[] { "8:00 - 10:00", "9:00 - 10:15", "10:15 - 11:30", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				"11:00 - 14:00", "11:15 - 12:45", "17:30 - 19:30", "18:30 - 20:00" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.gridx = 5;
		gbc_cbHorario.gridy = 5;
		add(cbHorario, gbc_cbHorario);

		lblMonitores = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblMonitores.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMonitores = new GridBagConstraints();
		gbc_lblMonitores.anchor = GridBagConstraints.EAST;
		gbc_lblMonitores.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitores.gridx = 4;
		gbc_lblMonitores.gridy = 6;
		add(lblMonitores, gbc_lblMonitores);

		btnInfo = new JButton(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.btnInfo.text")); //$NON-NLS-1$
		btnInfo.addKeyListener(new BtnInfoKeyListener());
		btnInfo.setIcon(new ImageIcon(PanelFormularioRutas.class.getResource("/presentacion/icono-info.png"))); //$NON-NLS-1$
		btnInfo.addActionListener(new BtnInfoActionListener());
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.anchor = GridBagConstraints.WEST;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 5;
		gbc_btnInfo.gridy = 6;
		add(btnInfo, gbc_btnInfo);

		lblCupo = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblCupo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCupo = new GridBagConstraints();
		gbc_lblCupo.anchor = GridBagConstraints.EAST;
		gbc_lblCupo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupo.gridx = 4;
		gbc_lblCupo.gridy = 7;
		add(lblCupo, gbc_lblCupo);

		spinCupo = new JSpinner();
		spinCupo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GridBagConstraints gbc_spinCupo = new GridBagConstraints();
		gbc_spinCupo.anchor = GridBagConstraints.WEST;
		gbc_spinCupo.insets = new Insets(0, 0, 5, 5);
		gbc_spinCupo.gridx = 5;
		gbc_spinCupo.gridy = 7;
		add(spinCupo, gbc_spinCupo);

		lblEncuentro = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblEncuentro.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEncuentro = new GridBagConstraints();
		gbc_lblEncuentro.anchor = GridBagConstraints.EAST;
		gbc_lblEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncuentro.gridx = 4;
		gbc_lblEncuentro.gridy = 8;
		add(lblEncuentro, gbc_lblEncuentro);

		txtEncuentro = new JTextField();
		GridBagConstraints gbc_txtEncuentro = new GridBagConstraints();
		gbc_txtEncuentro.gridwidth = 2;
		gbc_txtEncuentro.insets = new Insets(0, 0, 5, 5);
		gbc_txtEncuentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEncuentro.gridx = 5;
		gbc_txtEncuentro.gridy = 8;
		add(txtEncuentro, gbc_txtEncuentro);
		txtEncuentro.setColumns(10);

		lblDificultad = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblDificultad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDificultad = new GridBagConstraints();
		gbc_lblDificultad.anchor = GridBagConstraints.EAST;
		gbc_lblDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDificultad.gridx = 4;
		gbc_lblDificultad.gridy = 9;
		add(lblDificultad, gbc_lblDificultad);

		btnAplicarCambios = new JButton(
				MessagesPanelFormularioRutas.getString("PanelFormularioRutas.btnAplicarCambios.text")); //$NON-NLS-1$
		btnAplicarCambios.addKeyListener(new BtnAplicarCambiosKeyListener());
		btnAplicarCambios.addActionListener(new BtnAplicarCambiosActionListener());

		cbDificultad = new JComboBox();
		cbDificultad.setModel(new DefaultComboBoxModel(
				new String[] { MessagesPanelFormularioRutas.getString("PanelFormularioRutas.16"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.17"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.18"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.19") })); //$NON-NLS-1$
		GridBagConstraints gbc_cbDificultad = new GridBagConstraints();
		gbc_cbDificultad.insets = new Insets(0, 0, 5, 5);
		gbc_cbDificultad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDificultad.gridx = 5;
		gbc_cbDificultad.gridy = 9;
		add(cbDificultad, gbc_cbDificultad);

		lblDescripcion = new JLabel(MessagesPanelFormularioRutas.getString("PanelFormularioRutas.lblDescripcion.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.gridwidth = 4;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 11;
		add(lblDescripcion, gbc_lblDescripcion);

		scrollPaneDescripcion = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDescripcion = new GridBagConstraints();
		gbc_scrollPaneDescripcion.gridheight = 2;
		gbc_scrollPaneDescripcion.gridwidth = 6;
		gbc_scrollPaneDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneDescripcion.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDescripcion.gridx = 1;
		gbc_scrollPaneDescripcion.gridy = 12;
		add(scrollPaneDescripcion, gbc_scrollPaneDescripcion);

		tPDescripcion = new JTextPane();
		tPDescripcion.addKeyListener(new TPDescripcionKeyListener());
		scrollPaneDescripcion.setViewportView(tPDescripcion);
		btnAplicarCambios.setForeground(Color.BLACK);
		btnAplicarCambios.setBackground(colorBoton);
		GridBagConstraints gbc_btnAplicarCambios = new GridBagConstraints();
		gbc_btnAplicarCambios.insets = new Insets(0, 0, 0, 5);
		gbc_btnAplicarCambios.gridx = 6;
		gbc_btnAplicarCambios.gridy = 15;
		add(btnAplicarCambios, gbc_btnAplicarCambios);

	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			txtNombre.setEnabled(true);
			txtNombre.setEditable(true);
			cbDia.setEnabled(true);
			cbHorario.setEnabled(true);
			spinCupo.setEnabled(true);
			txtEncuentro.setEnabled(true);
			cbDificultad.setEnabled(true);
			cbDia.setEnabled(true);
			tPDescripcion.setEnabled(true);
			btnAplicarCambios.setEnabled(true);
			btnAniadirAvatar.setEnabled(true);
		}
	}

	private class BtnModificarKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				txtNombre.setEnabled(true);
				txtNombre.setEditable(true);
				cbDia.setEnabled(true);
				cbHorario.setEnabled(true);
				spinCupo.setEnabled(true);
				txtEncuentro.setEnabled(true);
				cbDificultad.setEnabled(true);
				cbDia.setEnabled(true);
				tPDescripcion.setEnabled(true);
				btnAplicarCambios.setEnabled(true);
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
					Image imagenEscalada = imagenOriginal.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
					ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
					lblFoto.setIcon(iconoLabel);
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
						Image imagenEscalada = imagenOriginal.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
						ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
						lblFoto.setIcon(iconoLabel);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}

	private class BtnAplicarCambiosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Ruta ruta = rutasDb.getRutas().get(indice);
			try {
				ruta.setNombre(txtNombre.getText());
				ruta.setDia((String) cbDia.getSelectedItem());
				ruta.setCupo((Integer) spinCupo.getValue());
				ruta.setDificultad((String) cbDificultad.getSelectedItem());
				ruta.setEncuentro(txtEncuentro.getText());
				ruta.setDescripcion(tPDescripcion.getText());
				ruta.setHorario((String) cbHorario.getSelectedItem());
				Image imagenEscalada1 = ((ImageIcon) lblFoto.getIcon()).getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH);
				ImageIcon foto = new ImageIcon(imagenEscalada1);
				ruta.setFoto(foto);
				DefaultListModel modeloRutas = (DefaultListModel) lstRutas.getModel();
				modeloRutas.set(indice, new PanelRutaRenderer(ruta));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, MessagesPanelFormularioRutas.getString("PanelFormularioRutas.20"), //$NON-NLS-1$
						MessagesPanelFormularioRutas.getString("PanelFormularioRutas.21"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
			}
		}
	}

	private class BtnAplicarCambiosKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Ruta ruta = rutasDb.getRutas().get(indice);
				try {
					ruta.setNombre(txtNombre.getText());
					ruta.setDia((String) cbDia.getSelectedItem());
					ruta.setCupo((Integer) spinCupo.getValue());
					ruta.setDificultad((String) cbDificultad.getSelectedItem());
					ruta.setEncuentro(txtEncuentro.getText());
					ruta.setDescripcion(tPDescripcion.getText());
					ruta.setHorario((String) cbHorario.getSelectedItem());
					Image imagenEscalada1 = ((ImageIcon) lblFoto.getIcon()).getImage().getScaledInstance(128, 128,
							java.awt.Image.SCALE_SMOOTH);
					ImageIcon foto = new ImageIcon(imagenEscalada1);
					ruta.setFoto(foto);
					DefaultListModel modeloRutas = (DefaultListModel) lstRutas.getModel();
					modeloRutas.set(indice, new PanelRutaRenderer(ruta));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							MessagesPanelFormularioRutas.getString("PanelFormularioRutas.20"), //$NON-NLS-1$
							MessagesPanelFormularioRutas.getString("PanelFormularioRutas.21"), //$NON-NLS-1$
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class BtnInfoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PanelInfoMonitoresRutas infoMons = new PanelInfoMonitoresRutas(monitoresDb);
			infoMons.setLocationRelativeTo(null);
			infoMons.setVisible(true);
		}
	}
	private class BtnInfoKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				PanelInfoMonitoresRutas infoMons = new PanelInfoMonitoresRutas(monitoresDb);
				infoMons.setLocationRelativeTo(null);
				infoMons.setVisible(true);
			}
		}
	}
	private class TPDescripcionKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_TAB)
				tPDescripcion.transferFocus();
		}
	}
}
