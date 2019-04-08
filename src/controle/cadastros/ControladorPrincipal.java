package controle.cadastros;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.VisaoTelaLogin;
import visao.cadastros.cliente.VisaoFramePrincipal;

public class ControladorPrincipal{
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaLogin telaLogin;
	
	public ControladorPrincipal() {
		inicializaTela();
		addEvento();
	}
	
	public void addEvento() {
		telaLogin.getButtonEntrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControladorTelaInicial(framePrincipal);				
			}
		});
	}
	
	public void inicializaTela() {
		framePrincipal = new VisaoFramePrincipal();
		telaLogin = new VisaoTelaLogin();
		
		framePrincipal.setContentPane(telaLogin);
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setMinimumSize(new Dimension(1055, 720));
		framePrincipal.setMaximumSize(new Dimension(1055, 720));
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.repaint();
		framePrincipal.validate();
	}	
	
	public static void main(String[] args) {
		new ControladorPrincipal();
	}

}
