package visao.cadastros.fornecedor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;
import visao.VisaoTelaPesquisa;
import javax.swing.JButton;

public class VisaoTelaCadastroFornecedorPessoaFisica extends JPanel{
	private JLabel labelTipoFornecedor			 = null;
	private JLabel labelNome					 = null;
	private JLabel labelCPF						 = null;
	private JLabel labelCEP						 = null;
	private JLabel labelNumero					 = null;
	private JLabel labelCidade					 = null;
	private JLabel labelEmail					 = null;
	private JLabel labelUfEndereco				 = null;
	private JLabel labelSituacao				 = null;
	private JLabel labelRg						 = null;
	private JLabel labelUfRg					 = null;
	private JLabel labelOrgaoExpeditor			 = null;
	private JLabel labelLogradouro				 = null;
	private JLabel labelBairro					 = null;
	private JLabel labelTelefone				 = null;
	private JLabel labelFax						 = null;
	private JLabel labelComplemento				 = null;
	private JLabel lblDataDeNascimento			 = null;
	private JLabel labelSexo					 = null;
	private JLabel labelPaginaCadastroFornecedor = null;
	private JLabel lblRamoDeAtividade			 = null;
	private JLabel labelDadosPessoais			 = null;
	private JLabel labelEndereco				 = null;
	private JFormattedTextField formattedTextFieldCPF				= null;
	private JFormattedTextField formattedTextFieldNome				= null;
	private JFormattedTextField formattedTextFieldCEP				= null;
	private JFormattedTextField formattedTextFieldNumero			= null;
	private JFormattedTextField formattedTextFieldCidade			= null;
	private JFormattedTextField formattedTextFieldLogradouro		= null;
	private JFormattedTextField formattedTextFieldBairro			= null;	
	private JFormattedTextField formattedTextFieldTelefone			= null;	
	private JFormattedTextField formattedTextFieldFax				= null;
	private JFormattedTextField formattedTextFieldComplemento		= null;
	private JFormattedTextField formattedTextFieldDataNascimento	= null;
	private JFormattedTextField formattedTextFieldRamoAtividade		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldRG				= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldOrgaoExpeditor	= null;
	private JComboBox<String> comboBoxTipoFornecedor			= null;
	private JComboBox<String> comboBoxEstadoEndereco			= null;
	private JComboBox<String> comboBoxSituacaoFornecedor		= null;
	private JComboBox<String> comboBoxEstadoRG					= null;
	private JComboBox<String> comboBoxSexo						= null;
	private JTextField 	textFieldEmail			= null;
	private JSeparator  separatorTitulo  		= null;
	private JSeparator 	separator 				= null;
	private JSeparator 	separator_1 			= null;
	private JButton 	buttonCadastroEndereco 	= null;
	private VisaoTelaPesquisa telaPesquisa 		= null;
	FormataMascaras fm = new FormataMascaras();
	
	public VisaoTelaCadastroFornecedorPessoaFisica() {
		setLayout(null);
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 720));
		setMaximumSize(new Dimension(1055, 720));
		add(getLabelTipoFornecedor());
		add(getLabelNome());
		add(getLabelCPF());
		add(getLabelCEP());
		add(getLabelNumero());
		add(getLabelCidade());
		add(getLabelEmail());
		add(getLabelUfEndereco());
		add(getLabelSituacao());
		add(getLabelRg());
		add(getLabelUfRg());
		add(getLabelOrgaoExpeditor());
		add(getLabelLogradouro());
		add(getLabelBairro());
		add(getLabelTelefone());
		add(getLabelSexo());
		add(getLabelComplemento());
		add(getLblDataDeNascimento());
		add(getFormattedTextFieldCPF());
		add(getFormattedTextFieldNome());
		add(getFormattedTextFieldCEP());
		add(getFormattedTextFieldNumero());
		add(getFormattedTextFieldCidade());
		add(getValidacaoJTextFieldRG());
		add(getValidacaoJTextFieldOrgaoExpeditor());
		add(getFormattedTextFieldLogradouro());
		add(getFormattedTextFieldBairro());
		add(getFormattedTextFieldTelefone());
		add(getFormattedTextFieldComplemento());
		add(getFormattedTextFieldDataNascimento());
		add(getTextFieldEmail());
		add(getComboBoxTipoFornecedor());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxSituacaoFornecedor());
		add(getComboBoxEstadoRG());
		add(getComboBoxSexo());
		add(getSeparatorTitulo());
		add(getLabelPaginaCadastroFornecedor());
		add(getLblRamoDeAtividade());
		add(getFormattedTextFieldRamoAtividade());
		add(getTelaPesquisa());
		add(getSeparator());
		add(getLabelDadosPessoais());
		add(getSeparator_1());
		add(getLabelEndereco());
		add(getLabelFax());
		add(getFormattedTextFieldFax());
		add(getButtonCadastroEndereco());
	}
	
	public JLabel getLabelTipoFornecedor() {
		if (labelTipoFornecedor == null) {
			labelTipoFornecedor = new JLabel("Tipo:");
			labelTipoFornecedor.setBackground(Color.WHITE);
			labelTipoFornecedor.setForeground(Color.BLACK);
			labelTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTipoFornecedor.setBounds(10, 35, 46, 18);
		}
		return labelTipoFornecedor;
	}
	public JLabel getLabelNome() {
		if (labelNome == null) {
			labelNome = new JLabel("Nome:*");
			labelNome.setBackground(Color.WHITE);
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNome.setBounds(10, 92, 79, 17);
		}
		return labelNome;
	}
	public JLabel getLabelCPF() {
		if (labelCPF == null) {
			labelCPF = new JLabel("CPF:*");
			labelCPF.setBackground(Color.WHITE);
			labelCPF.setForeground(Color.BLACK);
			labelCPF.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCPF.setBounds(900, 94, 46, 17);
		}
		return labelCPF;
	}
	public JLabel getLabelCEP() {
		if (labelCEP == null) {
			labelCEP = new JLabel("CEP:*");
			labelCEP.setBackground(Color.WHITE);
			labelCEP.setForeground(Color.BLACK);
			labelCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCEP.setBounds(10, 238, 46, 17);
		}
		return labelCEP;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBounds(555, 236, 46, 21);
		}
		return labelNumero;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBounds(335, 287, 72, 20);
		}
		return labelCidade;
	}
	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("Email:*");
			labelEmail.setBackground(Color.WHITE);
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEmail.setBounds(778, 145, 193, 17);
		}
		return labelEmail;
	}
	public JFormattedTextField getFormattedTextFieldCPF() {
		if (formattedTextFieldCPF == null) {
			formattedTextFieldCPF = new JFormattedTextField(fm.getCPF());
			formattedTextFieldCPF.setBackground(Color.WHITE);
			formattedTextFieldCPF.setForeground(Color.BLACK);
			formattedTextFieldCPF.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCPF.setBounds(900, 114, 140, 20);
		}
		return formattedTextFieldCPF;
	}
	public JFormattedTextField getFormattedTextFieldNome() {
		if (formattedTextFieldNome == null) {
			formattedTextFieldNome = new JFormattedTextField(fm.getNome());
			formattedTextFieldNome.setBackground(Color.WHITE);
			formattedTextFieldNome.setForeground(Color.BLACK);
			formattedTextFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldNome.setBounds(10, 112, 307, 20);
		}
		return formattedTextFieldNome;
	}
	public JFormattedTextField getFormattedTextFieldCEP() {
		if (formattedTextFieldCEP == null) {
			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCEP.setBackground(Color.WHITE);
			formattedTextFieldCEP.setForeground(Color.BLACK);
			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCEP.setBounds(10, 256, 104, 20);
		}
		return formattedTextFieldCEP;
	}
	public JFormattedTextField getFormattedTextFieldNumero() {
		if (formattedTextFieldNumero == null) {
			formattedTextFieldNumero = new JFormattedTextField(fm.getEndereco());
			formattedTextFieldNumero.setBackground(Color.WHITE);
			formattedTextFieldNumero.setForeground(Color.BLACK);
			formattedTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldNumero.setBounds(555, 255, 72, 21);
		}
		return formattedTextFieldNumero;
	}
	public JFormattedTextField getFormattedTextFieldCidade() {
		if (formattedTextFieldCidade == null) {
			formattedTextFieldCidade = new JFormattedTextField(fm.getEndereco());
			formattedTextFieldCidade.setBackground(Color.WHITE);
			formattedTextFieldCidade.setForeground(Color.BLACK);
			formattedTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCidade.setBounds(335, 310, 207, 20);
		}
		return formattedTextFieldCidade;
	}
	public JComboBox getComboBoxTipoFornecedor() {
		if (comboBoxTipoFornecedor == null) {
			comboBoxTipoFornecedor = new JComboBox();
			comboBoxTipoFornecedor.setBackground(Color.WHITE);
			comboBoxTipoFornecedor.setForeground(Color.BLACK);
			comboBoxTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoFornecedor.setEditable(true);
			comboBoxTipoFornecedor.setEnabled(false);
			comboBoxTipoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa F\u00EDsica", "Pessoa Jur\u00EDdica"}));
			comboBoxTipoFornecedor.setBounds(50, 35, 123, 20);
			comboBoxTipoFornecedor.setSelectedIndex(1);
		}
		return comboBoxTipoFornecedor;
	}
	public JTextField getTextFieldEmail() {
		if (textFieldEmail == null) {
			textFieldEmail = new JTextField();
			textFieldEmail.setBackground(Color.WHITE);
			textFieldEmail.setForeground(Color.BLACK);
			textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldEmail.setBounds(778, 166, 262, 20);
			textFieldEmail.setColumns(10);
		}
		return textFieldEmail;
	}
	
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if(comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox<String>();
			comboBoxEstadoEndereco.setForeground(Color.BLACK);
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(600, 310, 115, 20);
		}
		return comboBoxEstadoEndereco;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBounds(601, 292, 46, 17);
		}
		return labelUfEndereco;
	}
	public JLabel getLabelSituacao() {
		if (labelSituacao == null) {
			labelSituacao = new JLabel("Situa\u00E7\u00E3o:*");
			labelSituacao.setBackground(Color.WHITE);
			labelSituacao.setForeground(Color.BLACK);
			labelSituacao.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSituacao.setBounds(204, 35, 68, 17);
		}
		return labelSituacao;
	}
	public JComboBox<String> getComboBoxSituacaoFornecedor() {
		if (comboBoxSituacaoFornecedor == null) {
			comboBoxSituacaoFornecedor = new JComboBox();
			comboBoxSituacaoFornecedor.setBackground(Color.WHITE);
			comboBoxSituacaoFornecedor.setForeground(Color.BLACK);
			comboBoxSituacaoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSituacaoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Ativo", "Inativo"}));
			comboBoxSituacaoFornecedor.setBounds(277, 35, 123, 20);
		}
		return comboBoxSituacaoFornecedor;
	}
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("RG:*");
			labelRg.setBackground(Color.WHITE);
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Arial", Font.PLAIN, 16));
			labelRg.setBounds(15, 145, 46, 17);
		}
		return labelRg;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldRG() {
		if (validacaoJTextFieldRG == null) {
			validacaoJTextFieldRG = new ValidacaoGeralCamposTexto("2");
			validacaoJTextFieldRG.setBackground(Color.WHITE);
			validacaoJTextFieldRG.setForeground(Color.BLACK);
			validacaoJTextFieldRG.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldRG.setBounds(10, 166, 133, 20);
		}
		return validacaoJTextFieldRG;
	}
	public JLabel getLabelUfRg() {
		if (labelUfRg == null) {
			labelUfRg = new JLabel("UF:*");
			labelUfRg.setBackground(Color.WHITE);
			labelUfRg.setForeground(Color.BLACK);
			labelUfRg.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfRg.setBounds(160, 145, 46, 17);
		}
		return labelUfRg;
	}
	public JComboBox<String> getComboBoxEstadoRG() {
		if (comboBoxEstadoRG == null) {
			comboBoxEstadoRG = new JComboBox<String>();
			comboBoxEstadoRG.setForeground(Color.BLACK);
			comboBoxEstadoRG.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", 
					"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoRG.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoRG.setBackground(Color.WHITE);
			comboBoxEstadoRG.setBounds(160, 166, 115, 20);
		}
		return comboBoxEstadoRG;
	}
	public JLabel getLabelOrgaoExpeditor() {
		if (labelOrgaoExpeditor == null) {
			labelOrgaoExpeditor = new JLabel("\u00D3rg\u00E3o Expeditor:*");
			labelOrgaoExpeditor.setBackground(Color.WHITE);
			labelOrgaoExpeditor.setForeground(Color.BLACK);
			labelOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelOrgaoExpeditor.setBounds(295, 145, 162, 19);
		}
		return labelOrgaoExpeditor;
	}
	
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBounds(187, 238, 93, 19);
		}
		return labelLogradouro;
	}
	public JFormattedTextField getFormattedTextFieldLogradouro() {
		if (formattedTextFieldLogradouro == null) {
			formattedTextFieldLogradouro = new JFormattedTextField(fm.getEndereco());
			formattedTextFieldLogradouro.setBackground(Color.WHITE);
			formattedTextFieldLogradouro.setForeground(Color.BLACK);
			formattedTextFieldLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldLogradouro.setBounds(187, 256, 307, 20);
		}
		return formattedTextFieldLogradouro;
	}
	
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBounds(10, 287, 93, 21);
		}
		return labelBairro;
	}
	public JFormattedTextField getFormattedTextFieldBairro() {
		if (formattedTextFieldBairro == null) {
			formattedTextFieldBairro = new JFormattedTextField(fm.getEndereco());
			formattedTextFieldBairro.setBackground(Color.WHITE);
			formattedTextFieldBairro.setForeground(Color.BLACK);
			formattedTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldBairro.setBounds(10, 309, 262, 21);
		}
		return formattedTextFieldBairro;
	}
	
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:*");
			labelTelefone.setBackground(Color.WHITE);
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(483, 145, 74, 17);
		}
		return labelTelefone;
	}
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(482, 166, 133, 20);
		}
		return formattedTextFieldTelefone;
	}
	
	
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBounds(706, 233, 104, 21);
		}
		return labelComplemento;
	}
	public JFormattedTextField getFormattedTextFieldComplemento() {
		if (formattedTextFieldComplemento == null) {
			formattedTextFieldComplemento = new JFormattedTextField(fm.getEndereco());
			formattedTextFieldComplemento.setBackground(Color.WHITE);
			formattedTextFieldComplemento.setForeground(Color.BLACK);
			formattedTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldComplemento.setBounds(706, 255, 249, 21);
		}
		return formattedTextFieldComplemento;
	}
	public JLabel getLabelSexo() {
		if (labelSexo == null) {
			labelSexo = new JLabel("Sexo:*");
			labelSexo.setBackground(Color.WHITE);
			labelSexo.setForeground(Color.BLACK);
			labelSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSexo.setBounds(767, 94, 46, 17);
		}
		return labelSexo;
	}
	public JComboBox<String> getComboBoxSexo() {
		if (comboBoxSexo == null) {
			comboBoxSexo = new JComboBox();
			comboBoxSexo.setBackground(Color.WHITE);
			comboBoxSexo.setForeground(Color.BLACK);
			comboBoxSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Feminino", "Masculino"}));
			comboBoxSexo.setBounds(767, 114, 99, 20);
		}
		return comboBoxSexo;
	}
	public JLabel getLblDataDeNascimento() {
		if (lblDataDeNascimento == null) {
			lblDataDeNascimento = new JLabel("Data de nascimento:*");
			lblDataDeNascimento.setBackground(Color.WHITE);
			lblDataDeNascimento.setForeground(Color.BLACK);
			lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			lblDataDeNascimento.setBounds(600, 94, 150, 17);
		}
		return lblDataDeNascimento;
	}
	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(fm.getData());
			formattedTextFieldDataNascimento.setBackground(Color.WHITE);
			formattedTextFieldDataNascimento.setForeground(Color.BLACK);
			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldDataNascimento.setBounds(600, 114, 115, 20);
		}
		return formattedTextFieldDataNascimento;
	}
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	public JLabel getLabelPaginaCadastroFornecedor() {
		if (labelPaginaCadastroFornecedor == null) {
			labelPaginaCadastroFornecedor = new JLabel(" Cadastro de Fornecedor - Pessoa F\u00EDsica");
			labelPaginaCadastroFornecedor.setFont(new Font("Arial", Font.BOLD, 22));
			labelPaginaCadastroFornecedor.setBounds(0, 0, 754, 30);
		}
		return labelPaginaCadastroFornecedor;
	}
	public JLabel getLblRamoDeAtividade() {
		if (lblRamoDeAtividade == null) {
			lblRamoDeAtividade = new JLabel("Ramo de atividade:*");
			lblRamoDeAtividade.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRamoDeAtividade.setBounds(335, 92, 255, 14);
		}
		return lblRamoDeAtividade;
	}
	public JFormattedTextField getFormattedTextFieldRamoAtividade() {
		if (formattedTextFieldRamoAtividade == null) {
			formattedTextFieldRamoAtividade = new JFormattedTextField(fm.getNome());
			formattedTextFieldRamoAtividade.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldRamoAtividade.setBounds(335, 112, 255, 20);
		}
		return formattedTextFieldRamoAtividade;
	}
	
	public VisaoTelaPesquisa getTelaPesquisa() {
		if(telaPesquisa == null) {
			telaPesquisa = new VisaoTelaPesquisa();
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
//			telaPesquisa.getJTableDadosCliente().setModel(getBuscaExibicaoTableModel(false));
			telaPesquisa.getSeparatorBotoes().setSize(1121, 48);
			telaPesquisa.getSeparatorBotoes().setLocation(0, 308);
			telaPesquisa.getDadosClienteJScrollPane().setBounds(48, 89, 905, 208);
			telaPesquisa.getSeparatorPesquisa().setBounds(0, 74, 1121, 20);
			telaPesquisa.setBounds(0,343, 1055, 348);
			//algumas alterações, variantes de tabela pra tabela
			telaPesquisa.getComboBoxTipoPesquisa().removeItem("Razão Social");
			telaPesquisa.getComboBoxTipoPesquisa().removeItem("CNPJ");
		}
		return telaPesquisa;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(-14, 58, 1500, 22);
		}
		return separator;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldOrgaoExpeditor() {
		if (validacaoJTextFieldOrgaoExpeditor == null) {
			validacaoJTextFieldOrgaoExpeditor = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldOrgaoExpeditor.setForeground(Color.BLACK);		
			validacaoJTextFieldOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldOrgaoExpeditor.setBackground(Color.WHITE);
			validacaoJTextFieldOrgaoExpeditor.setBounds(295, 166, 172, 20);
		}
		return validacaoJTextFieldOrgaoExpeditor;
	}
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("Dados Pessoais");
			labelDadosPessoais.setFont(new Font("Arial", Font.BOLD, 22));
			labelDadosPessoais.setBounds(10, 60, 411, 30);
		}
		return labelDadosPessoais;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(0, 197, 1161, 11);
		}
		return separator_1;
	}
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("Endere\u00E7o");
			labelEndereco.setFont(new Font("Arial", Font.BOLD, 22));
			labelEndereco.setBounds(10, 197, 411, 30);
		}
		return labelEndereco;
	}
	public JLabel getLabelFax() {
		if (labelFax == null) {
			labelFax = new JLabel("Fax:");
			labelFax.setForeground(Color.BLACK);
			labelFax.setFont(new Font("Arial", Font.PLAIN, 16));
			labelFax.setBackground(Color.WHITE);
			labelFax.setBounds(636, 145, 74, 17);
		}
		return labelFax;
	}
	public JFormattedTextField getFormattedTextFieldFax() {
		if (formattedTextFieldFax == null) {
			formattedTextFieldFax = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldFax.setForeground(Color.BLACK);
			formattedTextFieldFax.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldFax.setBackground(Color.WHITE);
			formattedTextFieldFax.setBounds(635, 166, 133, 20);
		}
		return formattedTextFieldFax;
	}
	public JButton getButtonCadastroEndereco() {
		if (buttonCadastroEndereco == null) {
			buttonCadastroEndereco = new JButton("Cadastrar mais endere\u00E7os");
			buttonCadastroEndereco.setBackground(new Color(135, 206, 250));
			buttonCadastroEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
			buttonCadastroEndereco.setBounds(767, 306, 207, 30);
		}
		return buttonCadastroEndereco;
	}
}
