package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class FramePrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private ScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setTitle("Formul\u00E1rio Derca");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		chamaPanelExcluir();
		
		
	}
	
	public void ChamaPaneLogin() {
		PanelLogin panelog = new PanelLogin();
		contentPane.add(panelog);
		panelog.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void ChamaPaneMenu() {
		PanelMenu paneMenu = new PanelMenu();
		contentPane.add(paneMenu);
		paneMenu.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void ChamaPaneNovoF() {
		scrollPane = new ScrollPane();
		contentPane.add(scrollPane);
		PanelNovoF paneNovoF = new PanelNovoF();
		contentPane.add(paneNovoF);
		paneNovoF.setVisible(true);
		revalidate();
		repaint();
		
	}
	
	public void chamaPaneBuscar() {
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPane = new ScrollPane();
		contentPane.add(scrollPane);
		PanelBuscar paneBuscar = new PanelBuscar();
		scrollPane.add(paneBuscar);
		paneBuscar.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void chamaPaneAtualizar() {
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPane = new ScrollPane();
		contentPane.add(scrollPane);
		
		PanelAtualizar paneAtualizar = new PanelAtualizar();
		scrollPane.add(paneAtualizar);
		paneAtualizar.setVisible(true);
		revalidate();
		repaint();
	}
	
	public void chamaPanelExcluir() {
		PanelExcluir paneExcluir = new PanelExcluir();
		contentPane.add(paneExcluir);
		paneExcluir.setVisible(true);
		repaint();
		revalidate();
	}
	
	

}
