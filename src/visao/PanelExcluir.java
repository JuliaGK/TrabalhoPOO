package visao;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import java.text.ParseException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelExcluir extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFormattedTextField formattedTextField;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private MaskFormatter CPFExcluir;
	private JButton btnVoltarMenu;

	/**
	 * Create the panel.
	 */
	public PanelExcluir() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(new MigLayout("", "[354.00][525.00][20.00,grow]", "[][][][][]"));

		JLabel lblExcluirFormulrioDe = new JLabel("EXCLUIR FORMUL\u00C1RIO DE EST\u00C1GIO");
		lblExcluirFormulrioDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblExcluirFormulrioDe, "cell 0 0 3 1,alignx center");

		JLabel lblCpfEstudante = new JLabel("CPF Estudante");
		lblCpfEstudante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCpfEstudante, "cell 0 2,alignx center");
		try {
			CPFExcluir = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formattedTextField = new JFormattedTextField(CPFExcluir);
		add(formattedTextField, "cell 1 2,growx");

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PanelExcluir.class.getResource("/imagens/remove.png")));
		add(btnExcluir, "flowx,cell 1 4,alignx left");

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(PanelExcluir.class.getResource("/imagens/close-button.png")));
		add(btnLimpar, "cell 1 4,alignx right");
		
		btnVoltarMenu = new JButton("Voltar");
		add(btnVoltarMenu, "cell 1 4");

	}
	
	
	
	public JButton getBtnVoltarMenu() {
		return btnVoltarMenu;
	}



	public void setBtnVoltarMenu(JButton btnVoltarMenu) {
		this.btnVoltarMenu = btnVoltarMenu;
	}



	public MaskFormatter getCPFExc() {
		return CPFExcluir;
	}

	public void setCPFExc(MaskFormatter cPFExc) {
		CPFExcluir = cPFExc;
	}

	public JFormattedTextField getFormattedTextField() {
		return formattedTextField;
	}

	public void setFormattedTextField(JFormattedTextField formattedTextField) {
		this.formattedTextField = formattedTextField;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

}
