package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		setTitle("Camping Mudez");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/presentacion/campingMudez.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar tbGestion = new JToolBar();
		contentPane.add(tbGestion, BorderLayout.WEST);
		
		JPanel pnlListaFormulario = new JPanel();
		contentPane.add(pnlListaFormulario, BorderLayout.CENTER);
		pnlListaFormulario.setLayout(new CardLayout(0, 0));
		
		JLabel lblInfoLegal = new JLabel("Done by: elena.desdentado@alu.uclm.es and ruben.grande@alu.uclm.es");
		lblInfoLegal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInfoLegal, BorderLayout.SOUTH);
		
		JPanel pnlMenu = new JPanel();
		contentPane.add(pnlMenu, BorderLayout.NORTH);
		
		JToolBar tbUsuario = new JToolBar();
		pnlMenu.add(tbUsuario);
		
		JLabel lblAvatar = new JLabel("AVATAR");
		tbUsuario.add(lblAvatar);
		
		JLabel lblName = new JLabel("NAME");
		tbUsuario.add(lblName);
		
		JLabel lblUltimaConexion = new JLabel("ULTIMA CONEXION");
		tbUsuario.add(lblUltimaConexion);
		
		JButton btnConfiguracion = new JButton("CONFIG");
		tbUsuario.add(btnConfiguracion);
		
		JMenuBar mnbAyuda = new JMenuBar();
		pnlMenu.add(mnbAyuda);
		
		
	}

}
