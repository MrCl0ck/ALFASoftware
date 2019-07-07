package controle.cadastros.produto;

import java.awt.Dimension;

import javax.swing.JFrame;

import dao.Banco;
import modelo.cadastros.produto.ModeloProduto;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.produto.VisaoTelaCadastroProduto;

public class ControladorProduto {
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaCadastroProduto tela;
	private ModeloProduto produto_atual;
	private ModeloProduto produto_antigo;
	private Banco banco = new Banco();

	public ControladorProduto(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		buttons_inicial();
		add_eventos();
		campos_bool(false);
	}

	private void campos_bool(boolean b) {
		tela.getTextFieldCodigo().setEnabled(b);
		tela.getTextFieldCodigoBarras().setEnabled(b);
		tela.getTextFieldDescricao().setEnabled(b);
		tela.getTextFieldValorCompra().setEnabled(b);
		tela.getTextFieldValorVenda().setEnabled(b);
		tela.getTextFieldLucro().setEnabled(b);
		
		tela.getComboBoxUnidade().setEnabled(b);
		tela.getButtonAdicionarUnidade().setEnabled(b);
		tela.getButtonRemoverUnidade().setEnabled(b);
		tela.getButtonAlterarUnidade().setEnabled(b);
		
		tela.getComboBoxTipo().setEnabled(b);
		tela.getButtonAdicionarTipo().setEnabled(b);
		tela.getButtonRemoverTipo().setEnabled(b);
		tela.getButtonAlterarTipo().setEnabled(b);
		
		tela.getTextFieldEstoqueMinimo().setEnabled(b);
		tela.getTextFieldEstoqueMaximo().setEnabled(b);
	}

	private void add_eventos() {
		getBotaoBuscarAction();
		getBotaoIncluirAction();
		getBotaoExcluirAction();
		getBotaoAlterarAction();
		getBotaoCancelarAction();
		getBotaoConfirmarAction();
		getBotaoFecharAction();
		getSelecionarUmFuncionarioTabela();
		getSelecionarUmFuncionarioTabelaTyped();
		getMaisUnidade();
		getMenosUnidade();
		getAlterarUnidade();
		getMaisTipo();
		getMenosTipo();
		getAlterarTipo();
	}

	private void getAlterarTipo() {
		// 
		
	}

	private void getMenosTipo() {
		// 
		
	}

	private void getMaisTipo() {
		// 
		
	}

	private void getAlterarUnidade() {
		// 
		
	}

	private void getMenosUnidade() {
		// 
		
	}

	private void getMaisUnidade() {
		// 
		
	}

	private void getSelecionarUmFuncionarioTabelaTyped() {
		// 
		
	}

	private void getSelecionarUmFuncionarioTabela() {
		// 
		
	}

	private void getBotaoFecharAction() {
		// 
		
	}

	private void getBotaoConfirmarAction() {
		// 
		
	}

	private void getBotaoCancelarAction() {
		// 
		
	}

	private void getBotaoAlterarAction() {
		// 
		
	}

	private void getBotaoExcluirAction() {
		// 
		
	}

	private void getBotaoIncluirAction() {
		// 
		
	}
	
	private void getBotaoBuscarAction() {
		// 
		
	}

	private void buttons_inicial() {
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		tela.getTelaPesquisa().getButtonBuscar().setEnabled(true);	
	}

	private void inicializaTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(getTela());
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setMinimumSize(new Dimension(1107, 720));
		framePrincipal.setMaximumSize(new Dimension(1107, 720));
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	public VisaoTelaCadastroProduto getTela() {
		if(tela==null) {
			tela = new VisaoTelaCadastroProduto();
		}
		return tela;
	}
}
