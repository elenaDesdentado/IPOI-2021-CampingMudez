package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import dominio.Monitor;
import persistencia.Monitores;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PanelInfoMonitoresRutas extends JFrame {
	private JSplitPane splitPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JList list;
	
	private ArrayList<PanelMonitorRenderer> panelesEjemplo = new ArrayList<PanelMonitorRenderer>();
	private Monitores monitoresDb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelInfoMonitoresRutas frame = new PanelInfoMonitoresRutas(null);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public PanelInfoMonitoresRutas(Monitores monitoresDb) {
		
		this.monitoresDb = monitoresDb;
		
		for(Monitor monitor : monitoresDb.getMonitores())
			panelesEjemplo.add(new PanelMonitorRenderer(monitor));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 945);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(420, 220));
		splitPane.setLeftComponent(scrollPane);
		
		list = new JList();
		list.addListSelectionListener(new ListListSelectionListener());
		scrollPane.setViewportView(list);
		DefaultListModel lstModel = new DefaultListModel();

		for(PanelMonitorRenderer panel : panelesEjemplo)
			lstModel.addElement(panel);
		
		list.setModel(lstModel);
		list.setFixedCellHeight(220);
		list.setCellRenderer(new MonitorRenderer());

		list.setMinimumSize(new Dimension(420, 220));
		scrollPane.setViewportView(list);

	}

	private class ListListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if (list.getSelectedIndex() != -1) {
				Monitor monitorSeleccionado = monitoresDb.getMonitores().get(list.getSelectedIndex());
				PanelFormularioMonitores panelMonitorInfoCompleta = new PanelFormularioMonitores(list,
						monitoresDb, list.getSelectedIndex());
				panelMonitorInfoCompleta.lblAvatar.setIcon(monitorSeleccionado.getAvatar());
				panelMonitorInfoCompleta.txtNombre.setText(monitorSeleccionado.getNombre());
				panelMonitorInfoCompleta.spnEdad.setValue(monitorSeleccionado.getEdad());
				panelMonitorInfoCompleta.txtApellidos.setText(monitorSeleccionado.getApellidos());
				panelMonitorInfoCompleta.ftxtDNI.setText(monitorSeleccionado.getDni());
				panelMonitorInfoCompleta.ftxtMovil.setText(monitorSeleccionado.getMovil());
				panelMonitorInfoCompleta.ftxtFijo.setText(monitorSeleccionado.getFijo());
				panelMonitorInfoCompleta.txtCorreo.setText(monitorSeleccionado.getCorreo());
				panelMonitorInfoCompleta.cbEstudios.setSelectedItem(monitorSeleccionado.getEstudios());
				panelMonitorInfoCompleta.txtSueldo.setText(monitorSeleccionado.getSueldo().toString());
				panelMonitorInfoCompleta.cbHorario.setSelectedItem(monitorSeleccionado.getHorario());
				panelMonitorInfoCompleta.cbDisponibilidad.setSelectedItem(monitorSeleccionado.getDisponibilidad());
				DefaultListModel model = new DefaultListModel();
				for (String idioma : monitorSeleccionado.getIdiomas())
					model.addElement(idioma);
				panelMonitorInfoCompleta.lstIdiomas.setModel(model);
				panel.add(panelMonitorInfoCompleta, monitorSeleccionado.getDni());
				((CardLayout) panel.getLayout()).show(panel, monitorSeleccionado.getDni());

				panelMonitorInfoCompleta.btnAniadirAvatar.setEnabled(false);
				panelMonitorInfoCompleta.btnAplicarCambios.setEnabled(false);
				panelMonitorInfoCompleta.btnAniadirIdioma.setEnabled(false);
				panelMonitorInfoCompleta.lstIdiomas.setEnabled(false);
				panelMonitorInfoCompleta.txtNombre.setEnabled(false);
				panelMonitorInfoCompleta.txtApellidos.setEnabled(false);
				panelMonitorInfoCompleta.spnEdad.setEnabled(false);
				panelMonitorInfoCompleta.ftxtDNI.setEnabled(false);
				panelMonitorInfoCompleta.ftxtMovil.setEnabled(false);
				panelMonitorInfoCompleta.ftxtFijo.setEnabled(false);
				panelMonitorInfoCompleta.txtCorreo.setEnabled(false);
				panelMonitorInfoCompleta.txtSueldo.setEnabled(false);
				panelMonitorInfoCompleta.cbHorario.setEnabled(false);
				panelMonitorInfoCompleta.cbEstudios.setEnabled(false);
				panelMonitorInfoCompleta.cbDisponibilidad.setEnabled(false);
				panelMonitorInfoCompleta.btnModificar.setEnabled(false);

				UIManager.getDefaults().put("Button.disabledText", Color.DARK_GRAY);
				UIManager.getDefaults().put("ComboBox.disabledText", Color.DARK_GRAY);
			}
		}
	}
}
