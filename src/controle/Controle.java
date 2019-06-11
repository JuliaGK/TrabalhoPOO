
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			
		}
	
		
		// TODO Auto-generated method stub

	}

}