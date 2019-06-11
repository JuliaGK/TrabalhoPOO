
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.Dao;
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

	private LoginSenha loginSenha = new LoginSenha();
	
	private Dao dao;
	
	public Controle() {

		framePrincipal = new FramePrincipal();
		framePrincipal.setVisible(true);
		
		// Inicia com o panel de login
		
		framePrincipal.setContentPane(panelLogin);
		framePrincipal.setSize(panelLogin.getWidth(), panelLogin.getHeight());
		
		panelLogin.getBtnLogin().addActionListener(this);
		panelLogin.getBtnLimpar().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(framePrincipal.getContentPane() == panelLogin){
			
			if(e.getActionCommand().equals("LIMPAR")){
				
				panelLogin.getFieldSenha().setText("");
				panelLogin.getFieldUsuario().setText("");
				
			}
			if(e.getActionCommand().equals("LOGIN")) {
							
				loginSenha.setLogin(panelLogin.getFieldUsuario().getText());
				loginSenha.setSenha(panelLogin.getFieldSenha().getText());
				
//============>> implementar loginEhValido em dao
				
				if(dao.loginEhValido(loginSenha.getLogin(),loginSenha.getSenha())) {
					
					//Da acesso ao panel de menu
					framePrincipal.setContentPane(panelMenu);
					
					panelMenu.getMntmNovoFormulrio().addActionListener(this);
					panelMenu.getMntmAtualizarFormulrio().addActionListener(this);
					panelMenu.getMntmBuscarFormulrio().addActionListener(this);
					panelMenu.getMntmExcluirFormulrio().addActionListener(this);
					
					if(framePrincipal.getContentPane() == panelMenu){
						
						if(e.getActionCommand().equals("Novo Formul\u00E1rio")) {
							
							//Da acesso ao panel para novo formulario
							framePrincipal.setContentPane(panelNovo);
							framePrincipal.setSize(panelNovo.getWidth(), panelNovo.getHeight());
							
							panelNovo.getBtnCadastrar().addActionListener(this);
							panelNovo.getBtnLimpar().addActionListener(this);
							
							if(framePrincipal.getContentPane() == panelNovo) {
								
								if(e.getActionCommand().equals("LIMPAR")){
									
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
									panelNovo.getComboBoxSemestre().getItemAt(0);
									panelNovo.getComboBoxCursoEst().getItemAt(0);
									panelNovo.getComboBoxUF().getItemAt(0);
									panelNovo.getComboBoxCursoCoord().getItemAt(0);
									panelNovo.getFieldDataInicial()..setText("");
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
									
								}else if(e.getActionCommand().equals("CADASTRAR")) {
									
									panelNovo.getFieldNomeCoord();
									panelNovo.getFieldNomeResp();
									panelNovo.getFieldNomeEst();
									panelNovo.getFieldCargoResp();
									panelNovo.getFieldEndereco();
									panelNovo.getFieldComplemento();
									panelNovo.getFieldBairro();
									panelNovo.getFieldCidade();
									panelNovo.getFieldAreaAtuacao();
									panelNovo.getFieldDuracaoEstag();
									panelNovo.getFieldCHSem();
									panelNovo.getFieldNApolSeg();
									panelNovo.getFieldSeguradora();
									panelNovo.getFieldProfResp();
									panelNovo.getFieldSIAPE();
									panelNovo.getFieldSupervidorEmpresa();
									panelNovo.getFieldCargoSupervEmpresa();
									panelNovo.getComboBoxSemestre();
									panelNovo.getComboBoxCursoEst();
									panelNovo.getComboBoxUF();
									panelNovo.getComboBoxCursoCoord();
									panelNovo.getFieldDataInicial();
									panelNovo.getFieldDataFinal();
									panelNovo.getFieldCEP();
									panelNovo.getFieldCPFEst();
									panelNovo.getFieldRGEst();
									panelNovo.getFieldNascEst();
									panelNovo.getFieldCPFResp();
									panelNovo.getFieldRGResp();
									panelNovo.getFieldMatEst();
									panelNovo.getFieldCPFCoord();
									panelNovo.getFieldRGCoord();
									panelNovo.getFieldCPFBusca();
									
								}
								
							}
														
						}else if(e.getActionCommand().equals("Atualizar  Formul\u00E1rio")) {
							
							//Da acesso ao panel para atualizar
							framePrincipal.setContentPane(panelAtualizar);
							framePrincipal.setSize(panelAtualizar.getWidth(), panelAtualizar.getHeight());
							
							panelAtualizar.getBtnAtualizar().addActionListener(this);
							panelAtualizar.getBtnBuscar().addActionListener(this);
							panelAtualizar.getBtnLimpar().addActionListener(this);
							panelAtualizar.getBtnLimparAtual().addActionListener(this);
							
						}else if(e.getActionCommand().equals("Buscar Formul\u00E1rio")) {
							
							//Da acesso ao panel para buscar
							framePrincipal.setContentPane(panelBuscar);
							framePrincipal.setSize(panelBuscar.getWidth(), panelBuscar.getHeight());

							panelBuscar.getBtnBuscar().addActionListener(this);
							panelBuscar.getBtnLimpar().addActionListener(this);
							
						}else if(e.getActionCommand().equals("Excluir  Formul\u00E1rio")) {
							
							//Da acesso ao panel para excluir
							framePrincipal.setContentPane(panelExcluir);
							framePrincipal.setSize(panelExcluir.getWidth(), panelExcluir.getHeight());

							panelExcluir.getBtnExcluir().addActionListener(this);
							panelExcluir.getBtnLimpar().addActionListener(this);
							
						}
						
					}
										
					
				}else {
					JOptionPane.showMessageDialog(panelLogin, "Falha ao realizar login!","Erro",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
	
		
		// TODO Auto-generated method stub

	}

}