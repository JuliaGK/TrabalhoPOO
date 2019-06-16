
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
	private PanelAtualizar panelAtualizar = new PanelAtualizar();
	private PanelBuscar panelBuscar = new PanelBuscar();
	private PanelExcluir panelExcluir = new PanelExcluir();
	private PanelLogin panelLogin = new PanelLogin();
	private PanelMenu panelMenu = new PanelMenu();
	private PanelNovoF panelNovo = new PanelNovoF();
	private LinkedList<String> listaCursos;

	private LoginSenha loginSenha = new LoginSenha();
	private CadastroEstudante cadastroEstudante;

	private Dao dao;

	private boolean flagBtnBuscarAcionado = false;
	private boolean flagBtnLimparFormAcionado = false;
	
	
	public Controle() {

		framePrincipal = new FramePrincipal();

		// Inicia com o panel de login

		framePrincipal.setContentPane(panelLogin);
		framePrincipal.setSize(panelLogin.getWidth(), panelLogin.getHeight());
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setVisible(true);

		panelLogin.getBtnLogin().addActionListener(this);
		panelLogin.getBtnLimpar().addActionListener(this);
		panelBuscar.getBtnBuscar().addActionListener(this);
		panelBuscar.getBtnLimpar().addActionListener(this);
		panelBuscar.getBtnVoltarMenu().addActionListener(this);
		panelExcluir.getBtnExcluir().addActionListener(this);
		panelExcluir.getBtnLimpar().addActionListener(this);
		panelExcluir.getBtnVoltarMenu().addActionListener(this);
		panelNovo.getBtnCadastrar().addActionListener(this);
		panelNovo.getBtnLimpar().addActionListener(this);
		panelNovo.getBtnVoltarMenu().addActionListener(this);
		panelAtualizar.getBtnAtualizar().addActionListener(this);
		panelAtualizar.getBtnBuscar().addActionListener(this);
		panelAtualizar.getBtnLimpar().addActionListener(this);
		panelAtualizar.getBtnLimparAtual().addActionListener(this);
		panelAtualizar.getBtnVoltarMenu().addActionListener(this);

		dao = new Dao();
		listaCursos = dao.retornarTodosCursos();
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**
		 * Funcionalidades do panel de login
		 */
		
		if (framePrincipal.getContentPane() == panelLogin) {

			/**
			 * Acao do botao LIMPAR
			 */
			
			if (e.getActionCommand().equals("LIMPAR")) {

				panelLogin.getFieldSenha().setText("");
				panelLogin.getFieldUsuario().setText("");

			}

			/**
			 * Acao do botao LOGIN
			 */
			
			if (e.getActionCommand().equals("LOGIN")) {

				loginSenha.setLogin(panelLogin.getFieldUsuario().getText());
				loginSenha.setSenha(panelLogin.getFieldSenha().getText());

				if (dao.validarLogin(loginSenha)) {

					// Da acesso ao panel de menu

					panelMenu.getMntmNovoFormulrio().addActionListener(this);
					panelMenu.getMntmAtualizarFormulrio().addActionListener(this);
					panelMenu.getMntmBuscarFormulrio().addActionListener(this);
					panelMenu.getMntmExcluirFormulrio().addActionListener(this);

					framePrincipal.setContentPane(panelMenu);
					framePrincipal.setSize(374, 461);
					framePrincipal.repaint();
					
				} else {
					JOptionPane.showMessageDialog(panelLogin, "Falha ao realizar login!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		/**
		 * Funcionalidades do panel Menu
		 */
		
		if (framePrincipal.getContentPane() == panelMenu) {
			
			/**
			 * Acao do menuItem novo formulario
			 */
			
			if (e.getActionCommand().equals("Novo Formul\u00E1rio")) {
				// Da acesso ao panel para novo formulario
				framePrincipal.setSize(800, 800);
				framePrincipal.setContentPane(panelNovo);
				framePrincipal.setLocationRelativeTo(null);

				addCursosComboBox(panelNovo.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelNovo.getComboBoxCursoEst(), listaCursos);
				
				
				panelNovo.getBtnCadastrar().addActionListener(this);
				panelNovo.getBtnLimpar().addActionListener(this);
			}
			
			/**
			 * Acao do menuItem atualizar formulario
			 */
			
			if (e.getActionCommand().equals("Atualizar  Formul\u00E1rio")) {
				// Da acesso ao panel para atualizar
				framePrincipal.setSize(800, 800);
				framePrincipal.setContentPane(panelAtualizar);
				framePrincipal.setLocationRelativeTo(null);
				
				addCursosComboBox(panelAtualizar.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelAtualizar.getComboBoxCursoEst(), listaCursos);
				addUFsComboBox(panelAtualizar.getComboBoxUF());
				addSemestresComboBox(panelAtualizar.getComboBoxSemestre());
				
			}

			/**
			 * Acao do menuItem buscar formulario
			 */
			
			if (e.getActionCommand().equals("Buscar Formul\u00E1rio")) {
				// Da acesso ao panel para buscar
				framePrincipal.setSize(800, 800);
				framePrincipal.setContentPane(panelBuscar);
				framePrincipal.setLocationRelativeTo(null);
				addCursosComboBox(panelBuscar.getComboBoxCursoCoord(), listaCursos);
				addCursosComboBox(panelBuscar.getComboBoxCursoEst(), listaCursos);

			}

			/**
			 * Acao do menuItem excluir formulario
			 */
			
			if (e.getActionCommand().equals("Excluir  Formul\u00E1rio")) {
				// Da acesso ao panel para excluir
				framePrincipal.setContentPane(panelExcluir);
				framePrincipal.setSize(360, 180);
				framePrincipal.setLocationRelativeTo(null);

			}

		}
		
		/**
 		* Funcionalidades do panel de novo cadastro
 		*/
		
		if (framePrincipal.getContentPane() == panelNovo) {
			
			/**
			 * Acao do botao LIMPAR
			 */
			
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
			
			/**
			 * Acao do botao CADASTRAR
			 */
			
			if (e.getActionCommand().equalsIgnoreCase("CADASTRAR")) {
				//verifica se todos os campos foram preenchidos
				if(panelNovo.getFieldNomeCoord().getText().isEmpty() || panelNovo.getFieldNomeResp().getText().isEmpty() ||
				panelNovo.getFieldNomeEst().getText().isEmpty() || panelNovo.getFieldCargoResp().getText().isEmpty() ||
				panelNovo.getFieldEndereco().getText().isEmpty() || panelNovo.getFieldComplemento().getText().isEmpty() ||
				panelNovo.getFieldBairro().getText().isEmpty() || panelNovo.getFieldCidade().getText().isEmpty() ||
				panelNovo.getFieldAreaAtuacao().getText().isEmpty() || panelNovo.getFieldDuracaoEstag().getText().isEmpty() ||
				panelNovo.getFieldCHSem().getText().isEmpty() || panelNovo.getFieldNApolSeg().getText().isEmpty() ||
				panelNovo.getFieldSeguradora().getText().isEmpty() || panelNovo.getFieldProfResp().getText().isEmpty() ||
				panelNovo.getFieldSIAPE().getText().isEmpty() || panelNovo.getFieldSupervidorEmpresa().getText().isEmpty() ||
				panelNovo.getFieldCargoSupervEmpresa().getText().isEmpty() || panelNovo.getComboBoxSemestre().getSelectedIndex() == -1 ||
				panelNovo.getComboBoxCursoEst().getSelectedIndex() == -1 || panelNovo.getComboBoxUF().getSelectedIndex() == -1 ||
				panelNovo.getComboBoxCursoCoord().getSelectedIndex() == -1 || panelNovo.getFieldDataInicial().getText().isEmpty() ||
				panelNovo.getFieldDataFinal().getText().isEmpty() || panelNovo.getFieldCEP().getText().isEmpty() ||
				panelNovo.getFieldCPFEst().getText().isEmpty() || panelNovo.getFieldRGEst().getText().isEmpty() ||
				panelNovo.getFieldNascEst().getText().isEmpty() || panelNovo.getFieldCPFResp().getText().isEmpty() ||
				panelNovo.getFieldRGResp().getText().isEmpty() || panelNovo.getFieldMatEst().getText().isEmpty() ||
				panelNovo.getFieldCPFCoord().getText().isEmpty() || panelNovo.getFieldRGCoord().getText().isEmpty() ||
				panelNovo.getFieldCPFBusca().getText().isEmpty() || panelNovo.getTextArea().getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(panelAtualizar, 
							"Falha ao cadastrar! Todos os campos sÃ£o obrigatÃ³rios.", "Erro",
							JOptionPane.ERROR_MESSAGE);
					
				}else {
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
				
					dao.registrarFormulario(cadastroEstudante);
					JOptionPane.showMessageDialog(panelNovo, "Cadastrado com sucesso!");
				}
			}
		}
		

		/**
		 * Funcionalidades do panel de atualizar formulario
		 */
		
		if(framePrincipal.getContentPane() == panelAtualizar) {
			
			framePrincipal.setContentPane(panelAtualizar);
			framePrincipal.setSize(800,800);
			/**
			 * Acao do botao Atualizar
			 */
			
			if(e.getActionCommand().equalsIgnoreCase("Atualizar")) {
			
				//buscar -> atualizar = dados jÃ¡ carregados na tela
				if(flagBtnBuscarAcionado==true && flagBtnLimparFormAcionado==false) {
					cadastroEstudante = new CadastroEstudante();
					cadastroEstudante.setNomeCoord(panelAtualizar.getFieldNomeCoord().getText());
					cadastroEstudante.setNomeResp(panelAtualizar.getFieldNomeResp().getText());
					cadastroEstudante.setNomeEstudante(panelAtualizar.getFieldNomeEst().getText());
					cadastroEstudante.setCargoResp(panelAtualizar.getFieldCargoResp().getText());
					cadastroEstudante.setEnderecoEtudante(panelAtualizar.getFieldEndereco().getText());
					cadastroEstudante.setComplemEstudante(panelAtualizar.getFieldComplemento().getText());
					cadastroEstudante.setBairroEstudante(panelAtualizar.getFieldBairro().getText());
					cadastroEstudante.setCidadeEstudante(panelAtualizar.getFieldCidade().getText());
					cadastroEstudante.setAreaAtuacaoEstagio(panelAtualizar.getFieldAreaAtuacao().getText());
					cadastroEstudante.setDuracaoEstagio(panelAtualizar.getFieldDuracaoEstag().getText());
					cadastroEstudante.setCargaHorariaEstagio(panelAtualizar.getFieldCHSem().getText());
					cadastroEstudante.setNumApoliceSeguroEstagio(panelAtualizar.getFieldNApolSeg().getText());
					cadastroEstudante.setSeguradoraEstagio(panelAtualizar.getFieldSeguradora().getText());
					cadastroEstudante.setOrientadorEstagio(panelAtualizar.getFieldProfResp().getText());
					cadastroEstudante.setNumSiapeEstagio(panelAtualizar.getFieldSIAPE().getText());
					cadastroEstudante.setSupervEstagio(panelAtualizar.getFieldSupervidorEmpresa().getText());
					cadastroEstudante.setCargoSupervEstagio(panelAtualizar.getFieldCargoSupervEmpresa().getText());
					cadastroEstudante.setCepEstudante(panelAtualizar.getFieldCEP().getText());
					cadastroEstudante.setCpfEstudante(panelAtualizar.getFieldCPFEst().getText());
					cadastroEstudante.setRgEstudante(panelAtualizar.getFieldRGEst().getText());
					cadastroEstudante.setCpfResp(panelAtualizar.getFieldCPFResp().getText());
					cadastroEstudante.setRgResp(panelAtualizar.getFieldRGResp().getText());
					cadastroEstudante.setMatricEstudante(panelAtualizar.getFieldMatEst().getText());
					cadastroEstudante.setCpfCoord(panelAtualizar.getFieldCPFCoord().getText());
					cadastroEstudante.setRgCoord(panelAtualizar.getFieldRGCoord().getText());
					cadastroEstudante.setDataInicialEstagio(panelAtualizar.getFieldDataInicial().getText());	
					cadastroEstudante.setDataFinalEstagio(panelAtualizar.getFieldDataFinal().getText());
					cadastroEstudante.setDataNascEstudante(panelAtualizar.getFieldNascEst().getText());
					cadastroEstudante.setSemestEstudante(
					Integer.parseInt(panelAtualizar.getComboBoxSemestre().getSelectedItem().toString()));
					cadastroEstudante.setUfEstudante(panelAtualizar.getComboBoxUF().getSelectedItem().toString());
					cadastroEstudante.setCursoEstudante(panelAtualizar.getComboBoxCursoEst().getSelectedIndex());
					cadastroEstudante.setCursoCoord(panelAtualizar.getComboBoxCursoCoord().getSelectedIndex());
					cadastroEstudante.setAtividadesEstagio(panelAtualizar.getTextArea().getText());
					Calendar cal = Calendar.getInstance();
					cadastroEstudante.setDataPreenchimento(cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR));
					
					dao.atualizar(cadastroEstudante.getCpfEstudante(), cadastroEstudante);
					JOptionPane.showMessageDialog(panelAtualizar, "Cadastro atualizado com sucesso!");
					
				}else {
					JOptionPane.showMessageDialog(panelAtualizar, "Falha ao atualizar!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
	
			}

			/**
			 * Acao do botao Buscar
			 */
			
			if(e.getActionCommand().equalsIgnoreCase("Buscar")) {
				cadastroEstudante = dao.consultarFormulario(panelAtualizar.getFieldCPFBusca().getText());
				
				if(cadastroEstudante == null) {
					JOptionPane.showMessageDialog(panelAtualizar, "Cadastro nao encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else {
					
					flagBtnBuscarAcionado = true;
					flagBtnLimparFormAcionado = false;
					
					panelAtualizar.getFieldNomeCoord().setText(cadastroEstudante.getNomeCoord());
					panelAtualizar.getFieldNomeResp().setText(cadastroEstudante.getNomeResp());
					panelAtualizar.getFieldNomeEst().setText(cadastroEstudante.getNomeEstudante());
					panelAtualizar.getFieldCargoResp().setText(cadastroEstudante.getCargoResp());
					panelAtualizar.getFieldEndereco().setText(cadastroEstudante.getEnderecoEtudante());
					panelAtualizar.getFieldComplemento().setText(cadastroEstudante.getComplemEstudante());
					panelAtualizar.getFieldBairro().setText(cadastroEstudante.getBairroEstudante());
					panelAtualizar.getFieldCidade().setText(cadastroEstudante.getCidadeEstudante());
					panelAtualizar.getFieldAreaAtuacao().setText(cadastroEstudante.getAreaAtuacaoEstagio());
					panelAtualizar.getFieldDuracaoEstag().setText(cadastroEstudante.getDuracaoEstagio());
					panelAtualizar.getFieldCHSem().setText(cadastroEstudante.getCargaHorariaEstagio());
					panelAtualizar.getFieldNApolSeg().setText(cadastroEstudante.getNumApoliceSeguroEstagio());
					panelAtualizar.getFieldSeguradora().setText(cadastroEstudante.getSeguradoraEstagio());
					panelAtualizar.getFieldProfResp().setText(cadastroEstudante.getOrientadorEstagio());
					panelAtualizar.getFieldSIAPE().setText(cadastroEstudante.getNumSiapeEstagio());
					panelAtualizar.getFieldSupervidorEmpresa().setText(cadastroEstudante.getSupervEstagio());
					panelAtualizar.getFieldCargoSupervEmpresa().setText(cadastroEstudante.getCargoSupervEstagio());
					panelAtualizar.getFieldCEP().setText(cadastroEstudante.getCepEstudante());
					panelAtualizar.getFieldCPFEst().setText(cadastroEstudante.getCpfEstudante());
					panelAtualizar.getFieldRGEst().setText(cadastroEstudante.getRgEstudante());
					panelAtualizar.getFieldCPFResp().setText(cadastroEstudante.getCpfResp());
					panelAtualizar.getFieldRGResp().setText(cadastroEstudante.getRgResp());
					panelAtualizar.getFieldMatEst().setText(cadastroEstudante.getMatricEstudante());
					panelAtualizar.getFieldCPFCoord().setText(cadastroEstudante.getCpfCoord());
					panelAtualizar.getFieldRGCoord().setText(cadastroEstudante.getRgCoord());
					panelAtualizar.getFieldDataInicial().setText(cadastroEstudante.getDataInicialEstagio());
					panelAtualizar.getFieldDataFinal().setText(cadastroEstudante.getDataFinalEstagio());
					panelAtualizar.getFieldNascEst().setText(cadastroEstudante.getDataNascEstudante());
					panelAtualizar.getComboBoxSemestre().setSelectedIndex(cadastroEstudante.getSemestEstudante());
					panelAtualizar.getComboBoxUF().setSelectedItem(cadastroEstudante.getUfEstudante());
					panelAtualizar.getComboBoxCursoEst().setSelectedIndex(cadastroEstudante.getCursoEstudante());
					panelAtualizar.getComboBoxCursoCoord().setSelectedIndex(cadastroEstudante.getCursoCoord());
					panelAtualizar.getTextArea().setText(cadastroEstudante.getAtividadesEstagio());
				}
			}
			
			/**
			 * Acao do botao de limpar dados existentes no formulario
			 */

			Object comando = e.getSource();
			if(comando.equals(panelAtualizar.getBtnLimparAtual())) {
				
				flagBtnLimparFormAcionado = true;
				
				panelAtualizar.getFieldNomeCoord().setText("");
				panelAtualizar.getFieldNomeResp().setText("");
				panelAtualizar.getFieldNomeEst().setText("");
				panelAtualizar.getFieldCargoResp().setText("");
				panelAtualizar.getFieldEndereco().setText("");
				panelAtualizar.getFieldComplemento().setText("");
				panelAtualizar.getFieldBairro().setText("");
				panelAtualizar.getFieldCidade().setText("");
				panelAtualizar.getFieldAreaAtuacao().setText("");
				panelAtualizar.getFieldDuracaoEstag().setText("");
				panelAtualizar.getFieldCHSem().setText("");
				panelAtualizar.getFieldNApolSeg().setText("");
				panelAtualizar.getFieldSeguradora().setText("");
				panelAtualizar.getFieldProfResp().setText("");
				panelAtualizar.getFieldSIAPE().setText("");
				panelAtualizar.getFieldSupervidorEmpresa().setText("");
				panelAtualizar.getFieldCargoSupervEmpresa().setText("");
				panelAtualizar.getComboBoxSemestre().setSelectedIndex(0);
				panelAtualizar.getComboBoxCursoEst().setSelectedIndex(0);
				panelAtualizar.getComboBoxUF().setSelectedIndex(0);
				panelAtualizar.getComboBoxCursoCoord().setSelectedIndex(0);
				panelAtualizar.getFieldDataInicial().setText("");
				panelAtualizar.getFieldDataFinal().setText("");
				panelAtualizar.getFieldCEP().setText("");
				panelAtualizar.getFieldCPFEst().setText("");
				panelAtualizar.getFieldRGEst().setText("");
				panelAtualizar.getFieldNascEst().setText("");
				panelAtualizar.getFieldCPFResp().setText("");
				panelAtualizar.getFieldRGResp().setText("");
				panelAtualizar.getFieldMatEst().setText("");
				panelAtualizar.getFieldCPFCoord().setText("");
				panelAtualizar.getFieldRGCoord().setText("");
				panelAtualizar.getTextArea().setText("");			
			}

			/**
			 * Acao do botao que limpa a area de pesquisa
			 */
			
			if(comando.equals(panelAtualizar.getBtnLimpar())){
				panelAtualizar.getFieldCPFBusca().setText("");
			}
			
		}
		
		/**
		 * Funcionalidades do painel de busca por formulario
		 */
		
		if(framePrincipal.getContentPane() == panelBuscar) {

			/**
			 * Acao do botao Buscar
			 */
			if(e.getActionCommand().equalsIgnoreCase("Buscar")) {
				
				cadastroEstudante = dao.consultarFormulario(panelBuscar.getFieldCPFBusca().getText());
				//System.out.println(cadastroEstudante.getRgCoord());
				//System.out.println(cadastroEstudante.getRgResp());
				
				if(cadastroEstudante == null) {
					JOptionPane.showMessageDialog(panelBuscar, "Cadastro nao encontrado!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}else {
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
					
					panelBuscar.repaint();
				}
			}

			/**
			 * Acao do botao Limpar
			 */
			
			if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
				
				panelBuscar.getFieldCPFBusca().setText("");
				
				panelBuscar.getFieldNomeCoord().setText("");
				panelBuscar.getFieldNomeResp().setText("");
				panelBuscar.getFieldNomeEst().setText("");
				panelBuscar.getFieldCargoResp().setText("");
				panelBuscar.getFieldEndereco().setText("");
				panelBuscar.getFieldComplemento().setText("");
				panelBuscar.getFieldBairro().setText("");
				panelBuscar.getFieldCidade().setText("");
				panelBuscar.getFieldAreaAtuacao().setText("");
				panelBuscar.getFieldDuracaoEstag().setText("");
				panelBuscar.getFieldCHSem().setText("");
				panelBuscar.getFieldNApolSeg().setText("");
				panelBuscar.getFieldSeguradora().setText("");
				panelBuscar.getFieldProfResp().setText("");
				panelBuscar.getFieldSIAPE().setText("");
				panelBuscar.getFieldSupervidorEmpresa().setText("");
				panelBuscar.getFieldCargoSupervEmpresa().setText("");
				panelBuscar.getComboBoxSemestre().setSelectedIndex(0);
				panelBuscar.getComboBoxCursoEst().setSelectedIndex(0);
				panelBuscar.getComboBoxUF().setSelectedIndex(0);
				panelBuscar.getComboBoxCursoCoord().setSelectedIndex(0);
				
				panelBuscar.getFieldDataInicial().setText("");
				panelBuscar.getFieldDataFinal().setText("");
				panelBuscar.getFieldCEP().setText("");
				panelBuscar.getFieldCPFEst().setText("");
				panelBuscar.getFieldRGEst().setText("");
				panelBuscar.getFieldNascEst().setText("");
				panelBuscar.getFieldCPFResp().setText("");
				panelBuscar.getFieldRGResp().setText("");
				panelBuscar.getFieldMatEst().setText("");
				panelBuscar.getFieldCPFCoord().setText("");
				panelBuscar.getFieldRGCoord().setText("");
				panelBuscar.getFieldCPFBusca().setText("");
				
				panelBuscar.getTextArea().setText("");
			}
		}
				
		/**
		 * Funcionalidades do painel de exclusao
		 */
		
		if(framePrincipal.getContentPane() == panelExcluir) {
			
			/**
			 * Acao do botao excluir
			 */
			
			if(e.getActionCommand().equalsIgnoreCase("Excluir")) {
				
				if(dao.consultarFormulario(panelExcluir.getFormattedTextField().getText()) != null) {
					dao.excluirFormulario(panelExcluir.getFormattedTextField().getText());
					JOptionPane.showMessageDialog(panelExcluir, "Excluido com sucesso!");
				}else {
					JOptionPane.showMessageDialog(panelExcluir, "Erro ao excluir!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}

			/**
			 * Acao do botao limpar
			 */
			
			if(e.getActionCommand().equalsIgnoreCase("Limpar")) {
				panelExcluir.getFormattedTextField().setText("");
				
			}
			
		}
		
		if(e.getActionCommand().equals("Voltar")){
			framePrincipal.setSize(374, 461);
			framePrincipal.setContentPane(panelMenu);
			framePrincipal.setLocationRelativeTo(null);
			
		}

	}

	/**
	 * Adiciona ao comboBox de cursos os cursos registrados no banco de dados
	 * @param box O comboBox a ser adicionado
	 * @param cursos Uma linkedList com os cursos do banco de dados
	 */
	
	public static void addCursosComboBox(JComboBox<String> box, LinkedList<String> cursos) {

		box.addItem("Selecionar opção");
		for (int i = 0; i < cursos.size(); i++) {
			box.addItem(cursos.get(i));
		}

	}
	
	public static void addUFsComboBox(JComboBox<String> box) {
		String [] UFs = {"Selecionar opção","Acre","Amapá","Amazonas","Bahia","Ceará","Distrito Federal","Espírito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
		for(int i = 0; i < UFs.length; i++) {
			box.addItem(UFs[i]);
		}
	}
	
	public static void addSemestresComboBox(JComboBox<String> box) {
		
		box.addItem("Selecionar opção");
		for(int i = 1; i < 13; i++) {		
			box.addItem(String.valueOf(i));
		}
		
	}

}