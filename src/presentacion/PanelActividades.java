package presentacion;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelActividades extends JPanel {
	private JSplitPane splitPane;
	private JPanel pnlFormularioActs;
	private JPanel pnlGestionBusqueda;
	private JScrollPane scrollPaneListaActs;
	private JButton btnCrearActividad;
	private JButton btnEliminarActividad;
	private JLabel lblBarraBusqueda;
	private JTextField txtBarraBusqueda;

	/**
	 * Create the panel.
	 */
	public PanelActividades() {
		setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		pnlFormularioActs = new JPanel();
		splitPane.setRightComponent(pnlFormularioActs);
		pnlFormularioActs.setLayout(new CardLayout(0, 0));
		
		scrollPaneListaActs = new JScrollPane();
		splitPane.setLeftComponent(scrollPaneListaActs);
		
		pnlGestionBusqueda = new JPanel();
		add(pnlGestionBusqueda, BorderLayout.NORTH);
		GridBagLayout gbl_pnlGestionBusqueda = new GridBagLayout();
		gbl_pnlGestionBusqueda.columnWidths = new int[]{56, 83, 171, 0, 0, 0, 0, 0, 0};
		gbl_pnlGestionBusqueda.rowHeights = new int[]{19, 33, 0, 0};
		gbl_pnlGestionBusqueda.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGestionBusqueda.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGestionBusqueda.setLayout(gbl_pnlGestionBusqueda);
		
		btnCrearActividad = new JButton("Crear Actividad");
		btnCrearActividad.setFocusPainted(false);
		GridBagConstraints gbc_btnCrearActividad = new GridBagConstraints();
		gbc_btnCrearActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearActividad.gridx = 1;
		gbc_btnCrearActividad.gridy = 1;
		pnlGestionBusqueda.add(btnCrearActividad, gbc_btnCrearActividad);
		
		btnEliminarActividad = new JButton("Eliminar Actividad");
		btnEliminarActividad.setFocusPainted(false);
		GridBagConstraints gbc_btnEliminarActividad = new GridBagConstraints();
		gbc_btnEliminarActividad.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminarActividad.gridx = 2;
		gbc_btnEliminarActividad.gridy = 1;
		pnlGestionBusqueda.add(btnEliminarActividad, gbc_btnEliminarActividad);
		
		lblBarraBusqueda = new JLabel("Barra de búsqueda:");
		lblBarraBusqueda.setAlignmentX(1.0f);
		GridBagConstraints gbc_lblBarraBusqueda = new GridBagConstraints();
		gbc_lblBarraBusqueda.anchor = GridBagConstraints.EAST;
		gbc_lblBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarraBusqueda.gridx = 4;
		gbc_lblBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(lblBarraBusqueda, gbc_lblBarraBusqueda);
		
		txtBarraBusqueda = new JTextField();
		GridBagConstraints gbc_txtBarraBusqueda = new GridBagConstraints();
		gbc_txtBarraBusqueda.gridwidth = 2;
		gbc_txtBarraBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_txtBarraBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBarraBusqueda.gridx = 5;
		gbc_txtBarraBusqueda.gridy = 1;
		pnlGestionBusqueda.add(txtBarraBusqueda, gbc_txtBarraBusqueda);
		txtBarraBusqueda.setColumns(10);

	}

}
