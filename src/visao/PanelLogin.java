package visao;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField FieldUsuario;
	private JTextField FieldSenha;
	private JButton btnLogin;
	private JButton btnLimpar;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {

		setBounds(100, 100, 380, 470);
		setBackground(SystemColor.inactiveCaption);
		setBorder(null);
		setLayout(null);
		JLabel labelImagemLogin = new JLabel("");
		labelImagemLogin.setBounds(127, 26, 115, 115);
		add(labelImagemLogin);

		try {
			labelImagemLogin.setIcon(new ImageIcon(
					ImageIO.read(PanelLogin.class.getResource("/imagens/logoUfcspa.png")).getScaledInstance(
							labelImagemLogin.getWidth(), labelImagemLogin.getHeight(), BufferedImage.TYPE_INT_RGB)));

			FieldUsuario = new JTextField();
			FieldUsuario.setBounds(78, 214, 221, 28);
			add(FieldUsuario);
			FieldUsuario.setColumns(10);

			FieldSenha = new JPasswordField();
			FieldSenha.setBounds(78, 292, 221, 28);
			add(FieldSenha);

			JLabel labelUsuario = new JLabel("USU\u00C1RIO");
			labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
			labelUsuario.setBounds(152, 181, 74, 22);
			add(labelUsuario);

			JLabel labelSenha = new JLabel("SENHA");
			labelSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
			labelSenha.setBounds(165, 266, 57, 15);
			add(labelSenha);

			btnLogin = new JButton("LOGIN");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnLogin.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagens/user.png")));
			btnLogin.setBounds(78, 360, 101, 23);
			add(btnLogin);

			btnLimpar = new JButton("LIMPAR");
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLimpar.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagens/close-button.png")));
			btnLimpar.setBounds(198, 360, 101, 23);
			add(btnLimpar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JTextField getFieldUsuario() {
		return FieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldUsuario) {
		FieldUsuario = fieldUsuario;
	}

	public JTextField getFieldSenha() {
		return FieldSenha;
	}

	public void setFieldSenha(JTextField fieldSenha) {
		FieldSenha = fieldSenha;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
}
