package visao;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PanelMenu extends JPanel {

	private JMenuItem mntmNovoFormulario;
	private JMenuItem mntmAtualizarFormulario;
	private JMenuItem mntmBuscarFormulario;
	private JMenuItem mntmExcluirFormulario;
	
	/**
	 * Create the panel.
	 */
	public PanelMenu() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(true);
		menuBar.setEnabled(true);
		menuBar.setBounds(0, 0, 380, 21);
		add(menuBar);
		
		JMenu Menu = new JMenu("Menu");
		menuBar.add(Menu);
		
		mntmNovoFormulario = new JMenuItem("Novo Formul\u00E1rio");
		mntmNovoFormulario.setIcon(new ImageIcon(PanelMenu.class.getResource("/imagens/plus (1).png")));
		Menu.add(mntmNovoFormulario);
		
		mntmAtualizarFormulario = new JMenuItem("Atualizar  Formul\u00E1rio");
		mntmAtualizarFormulario.setIcon(new ImageIcon(PanelMenu.class.getResource("/imagens/refresh.png")));
		Menu.add(mntmAtualizarFormulario);
		
		mntmBuscarFormulario = new JMenuItem("Buscar Formul\u00E1rio");
		mntmBuscarFormulario.setIcon(new ImageIcon(PanelMenu.class.getResource("/imagens/magnifying-glass.png")));
		Menu.add(mntmBuscarFormulario);
		
		mntmExcluirFormulario = new JMenuItem("Excluir  Formul\u00E1rio");
		mntmExcluirFormulario.setIcon(new ImageIcon(PanelMenu.class.getResource("/imagens/remove.png")));
		Menu.add(mntmExcluirFormulario);
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setBounds(66, 120, 240, 228);
		try {
			labelImagem.setIcon(new ImageIcon(ImageIO.read(PanelMenu.class.getResource("/imagens/Imagem4.png")
					).getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(labelImagem);		
		
	}

	public JMenuItem getMntmNovoFormulrio() {
		return mntmNovoFormulario;
	}

	public void setMntmNovoFormulrio(JMenuItem mntmNovoFormulrio) {
		this.mntmNovoFormulario = mntmNovoFormulrio;
	}

	public JMenuItem getMntmAtualizarFormulrio() {
		return mntmAtualizarFormulario;
	}

	public void setMntmAtualizarFormulrio(JMenuItem mntmAtualizarFormulrio) {
		this.mntmAtualizarFormulario = mntmAtualizarFormulrio;
	}

	public JMenuItem getMntmBuscarFormulrio() {
		return mntmBuscarFormulario;
	}

	public void setMntmBuscarFormulrio(JMenuItem mntmBuscarFormulrio) {
		this.mntmBuscarFormulario = mntmBuscarFormulrio;
	}

	public JMenuItem getMntmExcluirFormulrio() {
		return mntmExcluirFormulario;
	}

	public void setMntmExcluirFormulrio(JMenuItem mntmExcluirFormulrio) {
		this.mntmExcluirFormulario = mntmExcluirFormulrio;
	}
	
	
}
