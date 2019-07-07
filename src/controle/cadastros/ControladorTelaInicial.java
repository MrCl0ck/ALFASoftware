package controle.cadastros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controle.cadastros.cliente.ControladorTelaCadastroCliente;
import controle.cadastros.funcionario.ControladorFuncionario;
import controle.cadastros.produto.ControladorProduto;
import visao.VisaoTelaPaginaInicial;
import visao.cadastros.cliente.VisaoFramePrincipal;

public class ControladorTelaInicial {
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaPaginaInicial telaInicial;
	private static ControladorTelaCadastroCliente controladorTelaCadastroCliente;
	
	public ControladorTelaInicial(VisaoFramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
		inicializaTela();		
		addEvento();
	}

	public void addEvento() {
		telaInicial.getMenuItemCadastroCliente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ControladorTelaCadastroCliente(new VisaoFramePrincipal());
			}
		});
		telaInicial.getMenuItemCadastroFuncionario().addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ControladorFuncionario(new VisaoFramePrincipal());				
			}
		});
		telaInicial.getMenuItemCadastroProduto().addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ControladorProduto(new VisaoFramePrincipal());				
			}
		});
		
		
	}
	
	public void inicializaTela() {
		this.telaInicial = new VisaoTelaPaginaInicial();
		
		framePrincipal.setContentPane(telaInicial);		
		framePrincipal.repaint();
		framePrincipal.validate();
	}
}
