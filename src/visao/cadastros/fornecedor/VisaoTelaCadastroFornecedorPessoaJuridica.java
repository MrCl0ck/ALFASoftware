package visao.cadastros.fornecedor;

import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;
import visao.VisaoTelaPesquisa;

import java.awt.Rectangle;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

public class VisaoTelaCadastroFornecedorPessoaJuridica extends JPanel {
	private JLabel labelTitulo				= null;
	private JLabel labelTipoFornecedor		= null;
	private JLabel labelSituacaoFornecedor  = null;
	private JLabel labelDadosPesoais		= null;
	private JLabel labelRazaoSocial			= null;
	private JLabel labelCnpj				= null;
	private JLabel labelEmail				= null;
	private JLabel labelContatar			= null;
	private JLabel labelEndereco			= null;
	private JLabel labelCep					= null;
	private JLabel labelLogradouro			= null;
	private JLabel labelBairro				= null;
	private JLabel labelCidade				= null;
	private JLabel labelNumero				= null;
	private JLabel labelComplemento			= null;
	private JLabel labelUfEndereco			= null;
	private JLabel lblRamoDeAtividade		= null;
	private JLabel labelTelefone			= null;
	private JLabel labelFax					= null;
	private JComboBox<String> comboBoxTipoFornecedor	 = null;
	private JComboBox<String> comboBoxSituacaoFornecedor = null;
	private JComboBox<String> comboBoxUfEndereco		 = null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoRazaoSocial	= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoCnpj			= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoEmail		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoContatar		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoLogradouro	= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoBairro		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoCidade		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoNumero		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoComplemento	= null;
	private JFormattedTextField formattedTextFieldCep			= null;
	private JFormattedTextField formattedTextFieldRamoAtividade = null;
	private JFormattedTextField formattedTextFieldTelefone		= null;	
	private JFormattedTextField formattedTextFieldFax			= null;
	private JSeparator separator	= null;
	private JSeparator separator_1	= null;
	private JSeparator separator_2	= null;
	private JButton buttonCadastroEndereco	= null;
	FormataMascaras fm = new FormataMascaras();
	
	public VisaoTelaCadastroFornecedorPessoaJuridica() {
		setLayout(null);
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 720));
		setMaximumSize(new Dimension(1055, 720));
		
		add(getLabelTitulo());
		add(getLabelTipoFornecedor());
		add(getLabelSituacaoFornecedor());
		add(getLabelDadosPesoais());
		add(getLabelRazaoSocial());
		add(getLabelCnpj());
		add(getLabelEmail());
		add(getLabelContatar());
		add(getLabelEndereco());
		add(getLabelCep());
		add(getLabelLogradouro());
		add(getLabelBairro());
		add(getLabelCidade());
		add(getLabelNumero());
		add(getLabelComplemento());
		add(getLabelUfEndereco());
		add(getLblRamoDeAtividade());
		add(getLabelTelefone());
		add(getLblFax());
		add(getComboBoxTipoFornecedor());
		add(getComboBoxUfEndereco());
		add(getComboBoxSituacaoFornecedor());
		add(getValidacaoGeralCamposTextoRazaoSocial());
		add(getValidacaoGeralCamposTextoCnpj());
		add(getValidacaoGeralCamposTextoEmail());
		add(getValidacaoGeralCamposTextoContatar());
		add(getValidacaoGeralCamposTextoLogradouro());
		add(getValidacaoGeralCamposTextoBairro());
		add(getValidacaoGeralCamposTextoCidade());
		add(getValidacaoGeralCamposTextoNumero());
		add(getValidacaoGeralCamposTextoComplemento());
		add(getFormattedTextFieldCep());
		add(getSeparator());
		add(getSeparator_1());
		add(getSeparator_2());
		add(getFormattedTextFieldRamoAtividade());
		add(getFormattedTextFieldFax());
		add(getFormattedTextFieldTelefone());
		add(getButtonCadastroEndereco());
	}
	public JLabel getLabelTitulo() {
		if (labelTitulo == null) {
			labelTitulo = new JLabel(" Cadastro de Fornecedor - Pessoa Jur\u00EDdica");
			labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			labelTitulo.setBounds(0, 0, 621, 30);
		}
		return labelTitulo;
	}
	public JLabel getLabelTipoFornecedor() {
		if (labelTipoFornecedor == null) {
			labelTipoFornecedor = new JLabel("Tipo:");
			labelTipoFornecedor.setForeground(Color.BLACK);
			labelTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTipoFornecedor.setBackground(Color.WHITE);
			labelTipoFornecedor.setBounds(10, 41, 46, 20);
		}
		return labelTipoFornecedor;
	}
	public JComboBox<String> getComboBoxTipoFornecedor() {
		if (comboBoxTipoFornecedor == null) {
			comboBoxTipoFornecedor = new JComboBox<String>();
			comboBoxTipoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa F\u00EDsica", "Pessoa Jur\u00EDdica"}));
			comboBoxTipoFornecedor.setSelectedIndex(2);
			comboBoxTipoFornecedor.setForeground(Color.BLACK);
			comboBoxTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoFornecedor.setEnabled(false);
			comboBoxTipoFornecedor.setEditable(true);
			comboBoxTipoFornecedor.setBackground(Color.WHITE);
			comboBoxTipoFornecedor.setBounds(53, 41, 155, 20);
		}
		return comboBoxTipoFornecedor;
	}
	public JLabel getLabelSituacaoFornecedor() {
		if (labelSituacaoFornecedor == null) {
			labelSituacaoFornecedor = new JLabel("Situa\u00E7\u00E3o:*");
			labelSituacaoFornecedor.setForeground(Color.BLACK);
			labelSituacaoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSituacaoFornecedor.setBackground(Color.WHITE);
			labelSituacaoFornecedor.setBounds(274, 41, 81, 20);
		}
		return labelSituacaoFornecedor;
	}
	public JComboBox<String> getComboBoxSituacaoFornecedor() {
		if (comboBoxSituacaoFornecedor == null) {
			comboBoxSituacaoFornecedor = new JComboBox<String>();
			comboBoxSituacaoFornecedor.setForeground(Color.BLACK);
			comboBoxSituacaoFornecedor.addItem("Selecione");
			comboBoxSituacaoFornecedor.addItem("Ativo");
			comboBoxSituacaoFornecedor.addItem("Inativo");
			comboBoxSituacaoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSituacaoFornecedor.setBackground(Color.WHITE);
			comboBoxSituacaoFornecedor.setBounds(352, 41, 147, 20);
		}
		return comboBoxSituacaoFornecedor;
	}
	public JLabel getLabelDadosPesoais() {
		if (labelDadosPesoais == null) {
			labelDadosPesoais = new JLabel("Dados Pessoais");
			labelDadosPesoais.setFont(new Font("Arial", Font.BOLD, 22));
			labelDadosPesoais.setBounds(10, 72, 411, 30);
		}
		return labelDadosPesoais;
	}
	public JLabel getLabelRazaoSocial() {
		if (labelRazaoSocial == null) {
			labelRazaoSocial = new JLabel("Raz\u00E3o Social:*");
			labelRazaoSocial.setForeground(Color.BLACK);
			labelRazaoSocial.setFont(new Font("Arial", Font.PLAIN, 16));
			labelRazaoSocial.setBounds(10, 101, 115, 20);
		}
		return labelRazaoSocial;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoRazaoSocial() {
		if (validacaoGeralCamposTextoRazaoSocial == null) {
			validacaoGeralCamposTextoRazaoSocial = new ValidacaoGeralCamposTexto("1");
			validacaoGeralCamposTextoRazaoSocial.setForeground(Color.BLACK);
			validacaoGeralCamposTextoRazaoSocial.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoRazaoSocial.setBackground(Color.WHITE);
			validacaoGeralCamposTextoRazaoSocial.setBounds(10, 121, 358, 20);
		}
		return validacaoGeralCamposTextoRazaoSocial;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoCnpj() {
		if (validacaoGeralCamposTextoCnpj == null) {
			validacaoGeralCamposTextoCnpj = new ValidacaoGeralCamposTexto("4");
			validacaoGeralCamposTextoCnpj.setForeground(Color.BLACK);
			validacaoGeralCamposTextoCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoCnpj.setBounds(786, 121, 198, 20);
		}
		return validacaoGeralCamposTextoCnpj;
	}
	public JLabel getLabelCnpj() {
		if (labelCnpj == null) {
			labelCnpj = new JLabel("CNPJ:*");
			labelCnpj.setForeground(Color.BLACK);
			labelCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCnpj.setBounds(785, 101, 199, 20);
		}
		return labelCnpj;
	}
	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("Email:*");
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEmail.setBackground(Color.WHITE);
			labelEmail.setBounds(737, 150, 58, 20);
		}
		return labelEmail;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoEmail() {
		if (validacaoGeralCamposTextoEmail == null) {
			validacaoGeralCamposTextoEmail = new ValidacaoGeralCamposTexto("9");
			validacaoGeralCamposTextoEmail.setForeground(Color.BLACK);
			validacaoGeralCamposTextoEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoEmail.setColumns(10);
			validacaoGeralCamposTextoEmail.setBackground(Color.WHITE);
			validacaoGeralCamposTextoEmail.setBounds(735, 170, 262, 20);
		}
		return validacaoGeralCamposTextoEmail;
	}
	public JLabel getLabelContatar() {
		if (labelContatar == null) {
			labelContatar = new JLabel("Contatar a:*");
			labelContatar.setForeground(Color.BLACK);
			labelContatar.setFont(new Font("Arial", Font.PLAIN, 16));
			labelContatar.setBounds(10, 149, 115, 20);
		}
		return labelContatar;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoContatar() {
		if (validacaoGeralCamposTextoContatar == null) {
			validacaoGeralCamposTextoContatar = new ValidacaoGeralCamposTexto("1");
			validacaoGeralCamposTextoContatar.setForeground(Color.BLACK);
			validacaoGeralCamposTextoContatar.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoContatar.setBounds(new Rectangle(0, 0, 0, 20));
			validacaoGeralCamposTextoContatar.setBackground(Color.WHITE);
			validacaoGeralCamposTextoContatar.setBounds(10, 170, 345, 20);
		}
		return validacaoGeralCamposTextoContatar;
	}
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("Endere\u00E7o");
			labelEndereco.setFont(new Font("Arial", Font.BOLD, 22));
			labelEndereco.setBounds(6, 204, 411, 30);
		}
		return labelEndereco;
	}
	public JLabel getLabelCep() {
		if (labelCep == null) {
			labelCep = new JLabel("CEP:*");
			labelCep.setForeground(Color.BLACK);
			labelCep.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCep.setBounds(10, 232, 46, 20);
		}
		return labelCep;
	}
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:*");
			labelTelefone.setBackground(Color.WHITE);
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(378, 149, 74, 17);
		}
		return labelTelefone;
	}
	public JLabel getLblFax() {
		if (labelFax == null) {
			labelFax = new JLabel("Fax:");
			labelFax.setForeground(Color.BLACK);
			labelFax.setFont(new Font("Arial", Font.PLAIN, 16));
			labelFax.setBackground(Color.WHITE);
			labelFax.setBounds(561, 149, 74, 17);
		}
		return labelFax;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoLogradouro() {
		if (validacaoGeralCamposTextoLogradouro == null) {
			validacaoGeralCamposTextoLogradouro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoLogradouro.setForeground(Color.BLACK);
			validacaoGeralCamposTextoLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoLogradouro.setBackground(Color.WHITE);
			validacaoGeralCamposTextoLogradouro.setBounds(161, 251, 340, 20);
		}
		return validacaoGeralCamposTextoLogradouro;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setBounds(161, 232, 93, 20);
		}
		return labelLogradouro;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setBounds(10, 282, 93, 20);
		}
		return labelBairro;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoBairro() {
		if (validacaoGeralCamposTextoBairro == null) {
			validacaoGeralCamposTextoBairro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoBairro.setForeground(Color.BLACK);
			validacaoGeralCamposTextoBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoBairro.setBackground(Color.WHITE);
			validacaoGeralCamposTextoBairro.setBounds(10, 301, 262, 20);
		}
		return validacaoGeralCamposTextoBairro;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoCidade() {
		if (validacaoGeralCamposTextoCidade == null) {
			validacaoGeralCamposTextoCidade = new ValidacaoGeralCamposTexto("1");
			validacaoGeralCamposTextoCidade.setForeground(Color.BLACK);
			validacaoGeralCamposTextoCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoCidade.setBackground(Color.WHITE);
			validacaoGeralCamposTextoCidade.setBounds(328, 301, 191, 20);
		}
		return validacaoGeralCamposTextoCidade;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setBounds(328, 283, 72, 20);
		}
		return labelCidade;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoNumero() {
		if (validacaoGeralCamposTextoNumero == null) {
			validacaoGeralCamposTextoNumero = new ValidacaoGeralCamposTexto("8");
			validacaoGeralCamposTextoNumero.setForeground(Color.BLACK);
			validacaoGeralCamposTextoNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoNumero.setBackground(Color.WHITE);
			validacaoGeralCamposTextoNumero.setBounds(578, 251, 67, 20);
		}
		return validacaoGeralCamposTextoNumero;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setBounds(578, 232, 46, 20);
		}
		return labelNumero;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setBounds(702, 232, 104, 20);
		}
		return labelComplemento;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoComplemento() {
		if (validacaoGeralCamposTextoComplemento == null) {
			validacaoGeralCamposTextoComplemento = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoComplemento.setForeground(Color.BLACK);
			validacaoGeralCamposTextoComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoComplemento.setBackground(Color.WHITE);
			validacaoGeralCamposTextoComplemento.setBounds(702, 251, 261, 20);
		}
		return validacaoGeralCamposTextoComplemento;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setBounds(561, 282, 46, 20);
		}
		return labelUfEndereco;
	}
	public JComboBox<String> getComboBoxUfEndereco() {
		if (comboBoxUfEndereco == null) {
			comboBoxUfEndereco = new JComboBox<String>();
			comboBoxUfEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", 
					"AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", 
					"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxUfEndereco.setForeground(Color.BLACK);
			comboBoxUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxUfEndereco.setBackground(Color.WHITE);
			comboBoxUfEndereco.setBounds(561, 300, 115, 20);
		}
		return comboBoxUfEndereco;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 31, 1500, 22);
		}
		return separator;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(-12, 66, 1076, 11);
		}
		return separator_1;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setForeground(Color.BLACK);
			separator_2.setBounds(0, 198, 1076, 11);
		}
		return separator_2;
	}
	public JFormattedTextField getFormattedTextFieldCep() {
		if (formattedTextFieldCep == null) {
			formattedTextFieldCep = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCep.setForeground(Color.BLACK);
			formattedTextFieldCep.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCep.setBackground(Color.WHITE);
			formattedTextFieldCep.setBounds(10, 253, 100, 20);
		}
		return formattedTextFieldCep;
	}
	public JLabel getLblRamoDeAtividade() {
		if (lblRamoDeAtividade == null) {
			lblRamoDeAtividade = new JLabel("Ramo de atividade:*");
			lblRamoDeAtividade.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRamoDeAtividade.setBounds(411, 101, 304, 14);
		}
		return lblRamoDeAtividade;
	}
	public JFormattedTextField getFormattedTextFieldRamoAtividade() {
		if (formattedTextFieldRamoAtividade == null) {
			formattedTextFieldRamoAtividade = new JFormattedTextField(fm.getNome());
			formattedTextFieldRamoAtividade.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldRamoAtividade.setBounds(411, 121, 304, 20);
		}
		return formattedTextFieldRamoAtividade;
	}
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(377, 170, 155, 20);
		}
		return formattedTextFieldTelefone;
	}
	public JFormattedTextField getFormattedTextFieldFax() {
		if (formattedTextFieldFax == null) {
			formattedTextFieldFax = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldFax.setForeground(Color.BLACK);
			formattedTextFieldFax.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldFax.setBackground(Color.WHITE);
			formattedTextFieldFax.setBounds(560, 170, 155, 20);
		}
		return formattedTextFieldFax;
	}
	public JButton getButtonCadastroEndereco() {
		if (buttonCadastroEndereco == null) {
			buttonCadastroEndereco = new JButton("Cadastrar mais endere\u00E7os");
			buttonCadastroEndereco.setBackground(new Color(135, 206, 250));
			buttonCadastroEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonCadastroEndereco.setBounds(773, 296, 207, 30);
		}
		return buttonCadastroEndereco;
	}
	
}
