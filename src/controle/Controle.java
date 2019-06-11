
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
					
					if(e.getActionCommand().equals("Novo Formul\u00E1rio")) {
						
						//Da acesso ao panel para novo formulario
						framePrincipal.setContentPane(panelNovo);
						framePrincipal.setSize(panelNovo.getWidth(), panelNovo.getHeight());
						
						panelNovo.getBtnCadastrar().addActionListener(this);
						panelNovo.getBtnLimpar().addActionListener(this);
						
						
						
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
					
				}else {
					JOptionPane.showMessageDialog(panelLogin, "Falha ao realizar login!","Erro",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
	
		
		// TODO Auto-generated method stub

	}

}