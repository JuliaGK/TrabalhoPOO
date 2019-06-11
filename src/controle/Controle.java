
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.Dao;
import modelo.CadastroEstudante;
import modelo.LoginSenha;
import visao.FramePrincipal;
import visao.PanelAtualizar;
import visao.PanelBuscar;
import visao.PanelExcluir;
import visao.PanelLogin;
import visao.PanelMenu;
import visao.PanelNovoF;

public class Controle implements ActionListener {

	private FramePrincipal framePrincipal;
	private PanelAtualizar panelAtualizar;
	private PanelBuscar panelBuscar;
	private PanelExcluir panelExcluir;
	private PanelLogin panelLogin = new PanelLogin();
	private PanelMenu panelMenu;
	private PanelNovoF panelNovo;
	private LinkedList<String> listaCursos;

	private LoginSenha loginSenha = new LoginSenha();
	private CadastroEstudante cadastroEstudante;

	private Dao dao;

	public Controle() {

		framePrincipal = new FramePrincipal();
		framePrincipal.setVisible(true);

		// Inicia com o panel de login

		framePrincipal.setContentPane(panelLogin);
		framePrincipal.setSize(panelLogin.getWidth(), panelLogin.getHeight());

		panelLogin.getBtnLogin().addActionListener(this);
		panelLogin.getBtnLimpar().addActionListener(this);

		dao = new Dao();
		listaCursos = dao.retornarTodosCursos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

// 		+++ Funcionalidades do Panel Login

		if (framePrincipal.getContentPane() == panelLogin) {

//			* Botão limpar
			if (e.getActionCommand().equals("LIMPAR")) {

				panelLogin.getFieldSenha().setText("");
				panelLogin.getFieldUsuario().setText("");

			}

//			* Botão login
			if (e.getActionCommand().equals("LOGIN")) {

				loginSenha.setLogin(panelLogin.getFieldUsuario().getText());
				loginSenha.setSenha(panelLogin.getFieldSenha().getText());

				if (dao.validarLogin(loginSenha)) {

					// Da acesso ao panel de menu
					panelMenu = new PanelMenu();

					panelMenu.getMntmNovoFormulrio().addActionListener(this);
					panelMenu.getMntmAtualizarFormulrio().addActionListener(this);
					panelMenu.getMntmBuscarFormulrio().addActionListener(this);
					panelMenu.getMntmExcluirFormulrio().addActionListener(this);

					framePrincipal.setContentPane(panelMenu);
					framePrincipal.setSize(framePrincipal.getWidth() + 1, framePrincipal.getHeight() + 1);
				} else {
					JOptionPane.showMessageDialog(panelLogin, "Falha ao realizar login!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

//		+++ Funcionalidades Panel Menu
		if (framePrincipal.getContentPane() == panelMenu) {

//			* Botão Novo Formulário
			if (e.getActionCommand().equals("Novo Formul\u00E1rio")) {
				panelNovo = new PanelNovoF();
				// Da acesso ao panel para novo formulario
				framePrincipal.setContentPane(panelNovo);
				framePrincipal.setExtendedState(framePrincipal.MAXIMIZED_BOTH); // deixa fullscreen

				addCursosComboBox(panelNovo.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelNovo.getComboBoxCursoEst(), listaCursos);

				panelNovo.getBtnCadastrar().addActionListener(this);
				panelNovo.getBtnLimpar().addActionListener(this);

			}

// 			* Botão Atualizar Formulário
			if (e.getActionCommand().equals("Atualizar  Formul\u00E1rio")) {
				panelAtualizar = new PanelAtualizar();
				// Da acesso ao panel para atualizar
				framePrincipal.setContentPane(panelAtualizar);
				framePrincipal.setExtendedState(framePrincipal.MAXIMIZED_BOTH); // deixa fullscreen
				addCursosComboBox(panelAtualizar.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelAtualizar.getComboBoxCursoEst(), listaCursos);

				panelAtualizar.getBtnAtualizar().addActionListener(this);
				panelAtualizar.getBtnBuscar().addActionListener(this);
				panelAtualizar.getBtnLimpar().addActionListener(this);
				panelAtualizar.getBtnLimparAtual().addActionListener(this);
			}
//			* Botão Buscar Formulário
			if (e.getActionCommand().equals("Buscar Formul\u00E1rio")) {
				panelBuscar = new PanelBuscar();
				// Da acesso ao panel para buscar
				framePrincipal.setContentPane(panelBuscar);
				framePrincipal.setExtendedState(framePrincipal.MAXIMIZED_BOTH); // deixa fullscreen
				addCursosComboBox(panelBuscar.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelBuscar.getComboBoxCursoEst(), listaCursos);

				panelBuscar.getBtnBuscar().addActionListener(this);
				panelBuscar.getBtnLimpar().addActionListener(this);
			}
//			* Botão Excluir Formulário
			if (e.getActionCommand().equals("Excluir  Formul\u00E1rio")) {
				panelExcluir = new PanelExcluir();
				// Da acesso ao panel para excluir
				framePrincipal.setContentPane(panelExcluir);
				framePrincipal.setSize(360, 180);

				panelExcluir.getBtnExcluir().addActionListener(this);
				panelExcluir.getBtnLimpar().addActionListener(this);

			}

		}

		if (framePrincipal.getContentPane() == panelNovo) {
			if (e.getActionCommand().equalsIgnoreCase("LIMPAR")) {

				panelNovo.getFieldNomeCoord().setText("");
				panelNovo.getFieldNomeResp().setText("");
				panelNovo.getFieldNomeEst().setText("");
				panelNovo.getFieldCargoResp().setText("");
				panelNovo.getFieldEndereco().setText("");
				panelNovo.getFieldComplemento().setText("");
				panelNovo.getFieldBairro().setText("");
				panelNovo.getFieldCidade().setText("");
				panelNovo.getFieldAreaAtuacao().setText("");
				panelNovo.getFieldDuracaoEstag().setText("");
				panelNovo.getFieldCHSem().setText("");
				panelNovo.getFieldNApolSeg().setText("");
				panelNovo.getFieldSeguradora().setText("");
				panelNovo.getFieldProfResp().setText("");
				panelNovo.getFieldSIAPE().setText("");
				panelNovo.getFieldSupervidorEmpresa().setText("");
				panelNovo.getFieldCargoSupervEmpresa().setText("");
				panelNovo.getComboBoxSemestre().setSelectedIndex(0);
				panelNovo.getComboBoxCursoEst().setSelectedIndex(0);
				panelNovo.getComboBoxUF().setSelectedIndex(0);
				panelNovo.getComboBoxCursoCoord().setSelectedIndex(0);
				
				panelNovo.getFieldDataInicial().setText("");
				panelNovo.getFieldDataFinal().setText("");
				panelNovo.getFieldCEP().setText("");
				panelNovo.getFieldCPFEst().setText("");
				panelNovo.getFieldRGEst().setText("");
				panelNovo.getFieldNascEst().setText("");
				panelNovo.getFieldCPFResp().setText("");
				panelNovo.getFieldRGResp().setText("");
				panelNovo.getFieldMatEst().setText("");
				panelNovo.getFieldCPFCoord().setText("");
				panelNovo.getFieldRGCoord().setText("");
				panelNovo.getFieldCPFBusca().setText("");
				
				panelNovo.getTextArea().setText("");
				
			}

			if (e.getActionCommand().equalsIgnoreCase("CADASTRAR")) {
				System.out.println("CADASTRA");
				cadastroEstudante = new CadastroEstudante();
				cadastroEstudante.setNomeCoord(panelNovo.getFieldNomeCoord().getText());
				cadastroEstudante.setNomeResp(panelNovo.getFieldNomeResp().getText());
				cadastroEstudante.setNomeEstudante(panelNovo.getFieldNomeEst().getText());
				cadastroEstudante.setCargoResp(panelNovo.getFieldCargoResp().getText());
				cadastroEstudante.setEnderecoEtudante(panelNovo.getFieldEndereco().getText());
				cadastroEstudante.setComplemEstudante(panelNovo.getFieldComplemento().getText());
				cadastroEstudante.setBairroEstudante(panelNovo.getFieldBairro().getText());
				cadastroEstudante.setCidadeEstudante(panelNovo.getFieldCidade().getText());
				cadastroEstudante.setAreaAtuacaoEstagio(panelNovo.getFieldAreaAtuacao().getText());
				cadastroEstudante.setDuracaoEstagio(panelNovo.getFieldDuracaoEstag().getText());
				cadastroEstudante.setCargaHorariaEstagio(panelNovo.getFieldCHSem().getText());
				cadastroEstudante.setNumApoliceSeguroEstagio(panelNovo.getFieldNApolSeg().getText());
				cadastroEstudante.setSeguradoraEstagio(panelNovo.getFieldSeguradora().getText());
				cadastroEstudante.setOrientadorEstagio(panelNovo.getFieldProfResp().getText());
				cadastroEstudante.setNumSiapeEstagio(panelNovo.getFieldSIAPE().getText());
				cadastroEstudante.setSupervEstagio(panelNovo.getFieldSupervidorEmpresa().getText());
				cadastroEstudante.setCargoSupervEstagio(panelNovo.getFieldCargoSupervEmpresa().getText());
				cadastroEstudante.setCepEstudante(panelNovo.getFieldCEP().getText());
				cadastroEstudante.setCpfEstudante(panelNovo.getFieldCPFEst().getText());
				cadastroEstudante.setRgEstudante(panelNovo.getFieldRGEst().getText());
				cadastroEstudante.setCpfResp(panelNovo.getFieldCPFResp().getText());
				cadastroEstudante.setRgResp(panelNovo.getFieldRGResp().getText());
				cadastroEstudante.setMatricEstudante(panelNovo.getFieldMatEst().getText());
				cadastroEstudante.setCpfCoord(panelNovo.getFieldCPFCoord().getText());
				cadastroEstudante.setRgCoord(panelNovo.getFieldRGCoord().getText());

				cadastroEstudante.setDataInicialEstagio(panelNovo.getFieldDataInicial().getText());
				
				cadastroEstudante.setDataFinalEstagio(panelNovo.getFieldDataFinal().getText());
				cadastroEstudante.setDataNascEstudante(panelNovo.getFieldNascEst().getText());

				cadastroEstudante.setSemestEstudante(
						Integer.parseInt(panelNovo.getComboBoxSemestre().getSelectedItem().toString()));
				cadastroEstudante.setUfEstudante(panelNovo.getComboBoxUF().getSelectedItem().toString());

				cadastroEstudante.setCursoEstudante(panelNovo.getComboBoxCursoEst().getSelectedIndex());
				cadastroEstudante.setCursoCoord(panelNovo.getComboBoxCursoCoord().getSelectedIndex());
				
				cadastroEstudante.setAtividadesEstagio(panelNovo.getTextArea().getText());
				
				Calendar cal = Calendar.getInstance();
				cadastroEstudante.setDataPreenchimento(cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
				
				System.out.println(cadastroEstudante.toString());
				dao.registrarFormulario(cadastroEstudante);

			}
		}
		
		if(framePrincipal.getContentPane() == panelExcluir) {
			if(e.getActionCommand().equalsIgnoreCase("Excluir")) {
				dao.excluirFormulario(panelExcluir.getFormattedTextField().getText());
			}
			if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
				panelExcluir.getFormattedTextField().setText("");
			}
			
		}
		
		if(framePrincipal.getContentPane() == panelBuscar) {
			if(e.getActionCommand().equalsIgnoreCase("Buscar")) {
				cadastroEstudante = new CadastroEstudante();
				cadastroEstudante = dao.consultarFormulario(panelBuscar.getFieldCPFBusca().getText());
				
				panelBuscar.getFieldNomeCoord().setText(cadastroEstudante.getNomeCoord());
				panelBuscar.getFieldNomeResp().setText(cadastroEstudante.getNomeResp());
				panelBuscar.getFieldNomeEst().setText(cadastroEstudante.getNomeEstudante());
				panelBuscar.getFieldCargoResp().setText(cadastroEstudante.getCargoResp());
				panelBuscar.getFieldEndereco().setText(cadastroEstudante.getEnderecoEtudante());
				panelBuscar.getFieldComplemento().setText(cadastroEstudante.getComplemEstudante());
				panelBuscar.getFieldBairro().setText(cadastroEstudante.getBairroEstudante());
				panelBuscar.getFieldCidade().setText(cadastroEstudante.getCidadeEstudante());
				panelBuscar.getFieldAreaAtuacao().setText(cadastroEstudante.getAreaAtuacaoEstagio());
				panelBuscar.getFieldDuracaoEstag().setText(cadastroEstudante.getDuracaoEstagio());
				panelBuscar.getFieldCHSem().setText(cadastroEstudante.getCargaHorariaEstagio());
				panelBuscar.getFieldNApolSeg().setText(cadastroEstudante.getNumApoliceSeguroEstagio());
				panelBuscar.getFieldSeguradora().setText(cadastroEstudante.getSeguradoraEstagio());
				panelBuscar.getFieldProfResp().setText(cadastroEstudante.getOrientadorEstagio());
				panelBuscar.getFieldSIAPE().setText(cadastroEstudante.getNumSiapeEstagio());
				panelBuscar.getFieldSupervidorEmpresa().setText(cadastroEstudante.getSupervEstagio());
				panelBuscar.getFieldCargoSupervEmpresa().setText(cadastroEstudante.getCargoSupervEstagio());
				panelBuscar.getFieldCEP().setText(cadastroEstudante.getCepEstudante());
				panelBuscar.getFieldCPFEst().setText(cadastroEstudante.getCpfEstudante());
				panelBuscar.getFieldRGEst().setText(cadastroEstudante.getRgEstudante());
				panelBuscar.getFieldCPFResp().setText(cadastroEstudante.getCpfResp());
				panelBuscar.getFieldRGResp().setText(cadastroEstudante.getRgResp());
				panelBuscar.getFieldMatEst().setText(cadastroEstudante.getMatricEstudante());
				panelBuscar.getFieldCPFCoord().setText(cadastroEstudante.getCpfCoord());
				panelBuscar.getFieldRGCoord().setText(cadastroEstudante.getRgCoord());

				panelBuscar.getFieldDataInicial().setText(cadastroEstudante.getDataInicialEstagio());
				
				panelBuscar.getFieldDataFinal().setText(cadastroEstudante.getDataFinalEstagio());
				panelBuscar.getFieldNascEst().setText(cadastroEstudante.getDataNascEstudante());

				panelBuscar.getComboBoxSemestre().setSelectedIndex(cadastroEstudante.getSemestEstudante());
				panelBuscar.getComboBoxUF().setSelectedItem(cadastroEstudante.getUfEstudante());

				panelBuscar.getComboBoxCursoEst().setSelectedIndex(cadastroEstudante.getCursoEstudante());
				panelBuscar.getComboBoxCursoCoord().setSelectedIndex(cadastroEstudante.getCursoCoord());
				
				panelBuscar.getTextArea().setText(cadastroEstudante.getAtividadesEstagio());
				
				System.out.println(cadastroEstudante.toString());
				
			}
		}

	}

	public static void addCursosComboBox(JComboBox<String> box, LinkedList<String> cursos) {

		box.addItem("");
		for (int i = 0; i < cursos.size(); i++) {
			box.addItem(cursos.get(i));
		}

	}

}