package visao.cadastros.produto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;
import modelo.tableModel.FisicoTable_F;
import modelo.tableModel.ProdutoTable;
import visao.VisaoTelaPesquisa;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VisaoTelaCadastroProduto extends JPanel {
	private VisaoTelaPesquisa telaPesquisa	= null;
	private JLabel labelCadastroDeProduto	= null;
	private JLabel labelCodigo		 		= null;
	private JLabel labelDescricao		 	= null;
	private JLabel labelValorDaCompra		= null;
	private JLabel labelValorDaVenda		= null;
	private JLabel labelLucro		 		= null;
	private JLabel labelUnidade		 		= null;
	private JLabel labelTipo		 		= null;
	private JLabel labelEstoqueMinimo		= null;
	private JLabel labelEstoqueMaximo		= null;
	private JLabel labelCodigoDeBarras		= null;
	private JLabel lblRS1		 			= null;
	private JLabel lblRS2		 			= null;
	private JComboBox<String> comboBoxUnidade = null;
	private JComboBox<String> comboBoxTipo	  = null;
	private JTextField textFieldDescricao	  = null;
	private ValidacaoGeralCamposTexto textFieldCodigo		  = null;
	private ValidacaoGeralCamposTexto textFieldValorVenda	  = null;
	private ValidacaoGeralCamposTexto textFieldLucro		  = null;
	private ValidacaoGeralCamposTexto textFieldValorCompra	  = null;
	private ValidacaoGeralCamposTexto textFieldEstoqueMinimo = null;
	private ValidacaoGeralCamposTexto textFieldCodigoBarras  = null;
	private ValidacaoGeralCamposTexto textFieldEstoqueMaximo = null;
	private JButton buttonAdicionarUnidade	  = null;
	private JButton buttonRemoverUnidade	  = null;
	private JButton buttonAlterarUnidade	  = null;
	private JButton buttonAlterarTipo		  = null;
	private JButton buttonAdicionarTipo		  = null;
	private JButton buttonRemoverTipo		  = null;
	private ProdutoTable busca_exibicao;
	
	public VisaoTelaCadastroProduto() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 770));
		setMaximumSize(new Dimension(1055, 770));
		add(getTelaPesquisa());
		add(getLabelCadastroDeProduto());
		add(getLabelCodigo());
		add(getLabelDescricao());
		add(getLabelValorDaCompra());
		add(getLabelValorDaVenda());
		add(getLabelLucro());
		add(getLabelUnidade());
		add(getLabelTipo());
		add(getLabelEstoqueMinimo());
		add(getLabelEstoqueMaximo());
		add(getLabelCodigoDeBarras());
		add(getLblRS1());
		add(getLblRS2());
		add(getComboBoxUnidade());
		add(getComboBoxTipo());
		add(getTextFieldDescricao());
		add(getTextFieldCodigo());
		add(getTextFieldValorVenda());
		add(getTextFieldLucro());
		add(getTextFieldValorCompra());
		add(getTextFieldEstoqueMinimo());
		add(getTextFieldCodigoBarras());
		add(getTextFieldEstoqueMaximo());
		add(getButtonAdicionarUnidade());
		add(getButtonRemoverUnidade());
		add(getButtonAlterarUnidade());
		add(getButtonAlterarTipo());
		add(getButtonAdicionarTipo());
		add(getButtonRemoverTipo());
	}
	public VisaoTelaPesquisa getTelaPesquisa() {
		if(telaPesquisa == null) {
			telaPesquisa = new VisaoTelaPesquisa();
			telaPesquisa.setBorder(new LineBorder(new Color(0, 0, 0)));
			telaPesquisa.getButtonFechar().setLocation(832, 321);
			telaPesquisa.getButtonConfirmar().setLocation(683, 321);
			telaPesquisa.getButtonCancelar().setLocation(539, 321);
			telaPesquisa.getButtonAlterar().setLocation(388, 321);
			telaPesquisa.getButtonExcluir().setLocation(233, 321);
			telaPesquisa.getButtonIncluir().setLocation(85, 321);
			telaPesquisa.getButtonBuscar().setSize(135, 24);
			telaPesquisa.getComboBoxTipoPesquisa().setSize(163, 20);
			telaPesquisa.getComboBoxTipoPesquisa().setLocation(59, 41);
			telaPesquisa.getTextFieldEntradaDado().setLocation(270, 41);
			telaPesquisa.getButtonBuscar().setLocation(789, 41);
			telaPesquisa.getSeparatorBotoes().setSize(1058, 48);
			telaPesquisa.getSeparatorBotoes().setLocation(0, 308);
			telaPesquisa.getDadosJScrollPane().setBounds(48, 89, 905, 208);
			telaPesquisa.getSeparatorPesquisa().setBounds(0, 74, 1082, 20);
			telaPesquisa.getJTableDados().setModel(get_busca_table_model(false));
			telaPesquisa.getComboBoxTipoPesquisa().removeAllItems();
			telaPesquisa.getComboBoxTipoPesquisa().addItem("Selecione");
			telaPesquisa.getComboBoxTipoPesquisa().addItem("Código do produto");
			telaPesquisa.getComboBoxTipoPesquisa().addItem("Código de barras");
			telaPesquisa.setBounds(0,334, 1055, 357);			
		}
		return telaPesquisa;
	}
	public JLabel getLabelCadastroDeProduto() {
		if (labelCadastroDeProduto == null) {
			labelCadastroDeProduto = new JLabel("  Cadastro de Produto");
			labelCadastroDeProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelCadastroDeProduto.setFont(new Font("Arial", Font.BOLD, 22));
			labelCadastroDeProduto.setBounds(0, 0, 1080, 32);
		}
		return labelCadastroDeProduto;
	}
	public JLabel getLabelCodigo() {
		if (labelCodigo == null) {
			labelCodigo = new JLabel("C\u00F3digo:*");
			labelCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCodigo.setBounds(10, 54, 117, 20);
		}
		return labelCodigo;
	}
	public JLabel getLabelDescricao() {
		if (labelDescricao == null) {
			labelDescricao = new JLabel("Descri\u00E7\u00E3o:*");
			labelDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
			labelDescricao.setBounds(10, 114, 117, 20);
		}
		return labelDescricao;
	}
	public JLabel getLabelValorDaCompra() {
		if (labelValorDaCompra == null) {
			labelValorDaCompra = new JLabel("Valor da compra:*");
			labelValorDaCompra.setFont(new Font("Arial", Font.PLAIN, 16));
			labelValorDaCompra.setBounds(10, 167, 156, 20);
		}
		return labelValorDaCompra;
	}
	public JLabel getLabelValorDaVenda() {
		if (labelValorDaVenda == null) {
			labelValorDaVenda = new JLabel("Valor da venda:*");
			labelValorDaVenda.setFont(new Font("Arial", Font.PLAIN, 16));
			labelValorDaVenda.setBounds(349, 167, 117, 20);
		}
		return labelValorDaVenda;
	}
	public JLabel getLabelLucro() {
		if (labelLucro == null) {
			labelLucro = new JLabel("Lucro (%):*");
			labelLucro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLucro.setBounds(722, 167, 117, 20);
		}
		return labelLucro;
	}
	public JLabel getLabelUnidade() {
		if (labelUnidade == null) {
			labelUnidade = new JLabel("Unidade:*");
			labelUnidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUnidade.setBounds(9, 223, 117, 20);
		}
		return labelUnidade;
	}
	public JLabel getLabelTipo() {
		if (labelTipo == null) {
			labelTipo = new JLabel("Tipo:*");
			labelTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTipo.setBounds(503, 223, 117, 20);
		}
		return labelTipo;
	}
	public JLabel getLabelEstoqueMinimo() {
		if (labelEstoqueMinimo == null) {
			labelEstoqueMinimo = new JLabel("Estoque m\u00EDnimo:*");
			labelEstoqueMinimo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEstoqueMinimo.setBounds(10, 280, 156, 20);
		}
		return labelEstoqueMinimo;
	}
	public JLabel getLabelEstoqueMaximo() {
		if (labelEstoqueMaximo == null) {
			labelEstoqueMaximo = new JLabel("Estoque máximo:*");
			labelEstoqueMaximo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEstoqueMaximo.setBounds(349, 283, 181, 20);
		}
		return labelEstoqueMaximo;
	}
	public JLabel getLabelCodigoDeBarras() {
		if (labelCodigoDeBarras == null) {
			labelCodigoDeBarras = new JLabel("C\u00F3digo de barras:*");
			labelCodigoDeBarras.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCodigoDeBarras.setBounds(470, 54, 181, 20);
		}
		return labelCodigoDeBarras;
	}
	private JLabel getLblRS1() {
		if (lblRS1 == null) {
			lblRS1 = new JLabel("R$");
			lblRS1.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRS1.setBounds(10, 190, 31, 20);
		}
		return lblRS1;
	}
	private JLabel getLblRS2() {
		if (lblRS2 == null) {
			lblRS2 = new JLabel("R$");
			lblRS2.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRS2.setBounds(349, 190, 31, 20);
		}
		return lblRS2;
	}
	public JComboBox<String> getComboBoxUnidade() {
		if (comboBoxUnidade == null) {
			comboBoxUnidade = new JComboBox<String>();
			comboBoxUnidade.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxUnidade.setBackground(Color.WHITE);
			comboBoxUnidade.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			comboBoxUnidade.setBounds(9, 249, 174, 20);
		}
		return comboBoxUnidade;
	}
	public JComboBox<String> getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox<String>();
			comboBoxTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipo.setBackground(Color.WHITE);
			comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			comboBoxTipo.setBounds(503, 249, 174, 20);
		}
		return comboBoxTipo;
	}
	public JTextField getTextFieldDescricao() {
		if (textFieldDescricao == null) {
			textFieldDescricao = new JTextField();
			textFieldDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldDescricao.setBounds(10, 136, 622, 20);
			textFieldDescricao.setColumns(10);
		}
		return textFieldDescricao;
	}
	public ValidacaoGeralCamposTexto getTextFieldCodigo() {
		if (textFieldCodigo == null) {
			textFieldCodigo = new ValidacaoGeralCamposTexto("3");
			textFieldCodigo.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldCodigo.setText("");
			textFieldCodigo.setBounds(10, 78, 341, 20);
			textFieldCodigo.setColumns(10);
		}
		return textFieldCodigo;
	}
	public ValidacaoGeralCamposTexto getTextFieldValorVenda() {
		if (textFieldValorVenda == null) {
			textFieldValorVenda = new ValidacaoGeralCamposTexto("10");
			textFieldValorVenda.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldValorVenda.setBounds(377, 190, 188, 20);
			textFieldValorVenda.setColumns(10);
		}
		return textFieldValorVenda;
	}
	public ValidacaoGeralCamposTexto getTextFieldLucro() {
		if (textFieldLucro == null) {
			textFieldLucro = new ValidacaoGeralCamposTexto("10");
			textFieldLucro.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldLucro.setBounds(724, 192, 166, 20);
			textFieldLucro.setColumns(10);
		}
		return textFieldLucro;
	}
	public ValidacaoGeralCamposTexto getTextFieldValorCompra() {
		if (textFieldValorCompra == null) {
			textFieldValorCompra = new ValidacaoGeralCamposTexto("10");
			textFieldValorCompra.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldValorCompra.setBounds(36, 190, 156, 20);
			textFieldValorCompra.setColumns(10);
		}
		return textFieldValorCompra;
	}
	public ValidacaoGeralCamposTexto getTextFieldEstoqueMinimo() {
		if (textFieldEstoqueMinimo == null) {
			textFieldEstoqueMinimo = new ValidacaoGeralCamposTexto("3");
			textFieldEstoqueMinimo.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldEstoqueMinimo.setBounds(10, 303, 230, 20);
			textFieldEstoqueMinimo.setColumns(10);
		}
		return textFieldEstoqueMinimo;
	}
	public ValidacaoGeralCamposTexto getTextFieldCodigoBarras() {
		if (textFieldCodigoBarras == null) {
			textFieldCodigoBarras = new ValidacaoGeralCamposTexto("3");
			textFieldCodigoBarras.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldCodigoBarras.setText("");
			textFieldCodigoBarras.setBounds(470, 78, 341, 20);
			textFieldCodigoBarras.setColumns(10);
		}
		return textFieldCodigoBarras;
	}
	public ValidacaoGeralCamposTexto getTextFieldEstoqueMaximo() {
		if (textFieldEstoqueMaximo == null) {
			textFieldEstoqueMaximo = new ValidacaoGeralCamposTexto("3");
			textFieldEstoqueMaximo.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldEstoqueMaximo.setBounds(349, 303, 230, 20);
			textFieldEstoqueMaximo.setColumns(10);
		}
		return textFieldEstoqueMaximo;
	}
	public JButton getButtonAdicionarUnidade() {
		if (buttonAdicionarUnidade == null) {
			buttonAdicionarUnidade = new JButton("+");
			buttonAdicionarUnidade.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonAdicionarUnidade.setBackground(Color.WHITE);
			buttonAdicionarUnidade.setBounds(193, 249, 47, 23);
		}
		return buttonAdicionarUnidade;
	}
	public JButton getButtonRemoverUnidade() {
		if (buttonRemoverUnidade == null) {
			buttonRemoverUnidade = new JButton("-");
			buttonRemoverUnidade.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonRemoverUnidade.setBackground(Color.WHITE);
			buttonRemoverUnidade.setBounds(249, 249, 47, 23);
		}
		return buttonRemoverUnidade;
	}
	public JButton getButtonAlterarUnidade() {
		if (buttonAlterarUnidade == null) {
			buttonAlterarUnidade = new JButton("A");
			buttonAlterarUnidade.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonAlterarUnidade.setBackground(Color.WHITE);
			buttonAlterarUnidade.setBounds(304, 249, 47, 23);
		}
		return buttonAlterarUnidade;
	}
	public JButton getButtonAlterarTipo() {
		if (buttonAlterarTipo == null) {
			buttonAlterarTipo = new JButton("A");
			buttonAlterarTipo.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonAlterarTipo.setBackground(Color.WHITE);
			buttonAlterarTipo.setBounds(798, 246, 47, 23);
		}
		return buttonAlterarTipo;
	}
	public JButton getButtonAdicionarTipo() {
		if (buttonAdicionarTipo == null) {
			buttonAdicionarTipo = new JButton("+");
			buttonAdicionarTipo.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonAdicionarTipo.setBackground(Color.WHITE);
			buttonAdicionarTipo.setBounds(696, 246, 47, 23);
		}
		return buttonAdicionarTipo;
	}
	public JButton getButtonRemoverTipo() {
		if (buttonRemoverTipo == null) {
			buttonRemoverTipo = new JButton("-");
			buttonRemoverTipo.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonRemoverTipo.setBackground(Color.WHITE);
			buttonRemoverTipo.setBounds(747, 246, 47, 23);
		}
		return buttonRemoverTipo;
	}
	
	public ProdutoTable get_busca_table_model(boolean consulta) {
		if(consulta == true) {
			return busca_exibicao;
		}
		else{
			busca_exibicao = new ProdutoTable();
						
			return busca_exibicao;
		}				
	}
}
