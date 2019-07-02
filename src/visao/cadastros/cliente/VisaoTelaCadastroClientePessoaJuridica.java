package visao.cadastros.cliente;

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
import modelo.tableModel.JuridicoTable;
import visao.VisaoTelaPesquisa;

import java.awt.Rectangle;
import javax.swing.border.LineBorder;

public class VisaoTelaCadastroClientePessoaJuridica extends JPanel {
	private JLabel labelTipoCliente		 	  = null;
	private JLabel labelSituacao		 	  = null;
	private JLabel labelRazaoSocial		 	  = null;
	private JLabel labelContato		 	 	  = null;
	private JLabel labelCep		 	 		  = null;
	private JLabel labelCnpj		 	 	  = null;
	private JLabel labelInscricaoEstadualN	  = null;
	private JLabel labelUfEndereco		 	  = null;
	private JLabel labelNumero		 	 	  = null;
	private JLabel labelCidade		 	 	  = null;
	private JLabel labelEmail		 	 	  = null;
	private JLabel labelBairro		 	 	  = null;
	private JLabel labelTelefone		 	  = null;
	private JLabel labelComplemento		 	  = null;
	private JLabel labelLogradouro		 	  = null;
	private JLabel labelLimiteDeCredito		  = null;
	private JLabel labelUfInscricaoEstadual	  = null;
	private JLabel label		 	 		  = null;
	private JLabel labelTituloEndereo		  = null;
	private JLabel lblR		 	 		      = null;
	private JComboBox<String> comboBoxTipoCliente		  = null;
	private JComboBox<String> comboBoxSituacaoCliente	  = null;
	private JComboBox<String> comboBoxEstadoEndereco	  = null;
	private JComboBox<String> comboBoxUfInscricaoEstadual = null;
	private JFormattedTextField formattedTextFieldCEP	  = null;
	private JFormattedTextField formattedTextFieldTelefone	= null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldNumero		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldCnpj		 	    = null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldInscricaoEstadual	= null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldCidade	    = null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldLogradouro	= null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldBairro		= null;	
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldRazaoSocial	= null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldRepresentante	= null;
	private ValidacaoGeralCamposTexto validacaoGeralJTextFieldComplemento	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldEmail		 	 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldLimiteCredito		= null;
	private JSeparator separator		= null;
	private JSeparator separator_1		= null;
	private JSeparator separatorTitulo	= null;	
	private JuridicoTable clienteJuridicoTableModel = null;
	private JuridicoTable buscaExibicaoTableModel   = null;
	FormataMascaras fm = new FormataMascaras();
	
	public VisaoTelaCadastroClientePessoaJuridica() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLabelTipoCliente());
		add(getLabelSituacao());
		add(getLabelRazoSocial());
		add(getLabelContato());
		add(getLabelCep());
		add(getLabelCnpj());
		add(getLabelInscrioEstadualN());
		add(getLabelNumero());
		add(getLabelCidade());
		add(getLabelEmail());
		add(getLabelUfEndereco());
		add(getLabelSituacao());
		add(getLabelLogradouro());
		add(getLabelBairro());
		add(getLabelTelefone());
		add(getLabelLimiteDeCredito());
		add(getLabelComplemento());
		add(getLabel());
		add(getLabelTituloEndereo());
		add(getLblR());
		add(getLabelUfInscricaoEstadual());
		add(getComboBoxTipoCliente());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxSituacaoCliente());
		add(getComboBoxUfInscricaoEstadual());
		add(getValidacaoGeralJTextFieldRazaoSocial());
		add(getFormattedTextFieldTelefone());
		add(getFormattedTextFieldCEP());
		add(getValidacaoGeralJTextFieldNumero());
		add(getValidacaoGeralJTextFieldCidade());
		add(getValidacaoGeralJTextFieldLogradouro());
		add(getValidacaoGeralJTextFieldBairro());
		add(getValidacaoGeralJTextFieldComplemento());
		add(getValidacaoJTextFieldEmail());
		add(getValidacaoJTextFieldLimiteCredito());
		add(getValidacaoJTextFieldInscricaoEstadual());
		add(getValidacaoJTextFieldCnpj());
		add(getValidacaoGeralJTextFieldRepresentante());
		add(getSeparatorTitulo());	
		add(getSeparator());
		add(getSeparator_1());
		
	}
	
	public JLabel getLabelTipoCliente() {
		if (labelTipoCliente == null) {
			labelTipoCliente = new JLabel("Tipo:");
			labelTipoCliente.setBackground(Color.WHITE);
			labelTipoCliente.setForeground(Color.BLACK);
			labelTipoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTipoCliente.setBounds(10, 40, 46, 20);
		}
		return labelTipoCliente;
	}
	public JLabel getLabelSituacao() {
		if (labelSituacao == null) {
			labelSituacao = new JLabel("Situa\u00E7\u00E3o:*");
			labelSituacao.setBackground(Color.WHITE);
			labelSituacao.setForeground(Color.BLACK);
			labelSituacao.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSituacao.setBounds(274, 40, 81, 20);
		}
		return labelSituacao;
	}
	public JLabel getLabelRazoSocial() {
		if (labelRazaoSocial == null) {
			labelRazaoSocial = new JLabel("Raz\u00E3o Social:*");
			labelRazaoSocial.setForeground(Color.BLACK);
			labelRazaoSocial.setFont(new Font("Arial", Font.PLAIN, 16));
			labelRazaoSocial.setBounds(10, 100, 115, 20);
		}
		return labelRazaoSocial;
	}
	public JLabel getLabelContato() {
		if (labelContato == null) {
			labelContato = new JLabel("Contatar a:*");
			labelContato.setForeground(Color.BLACK);
			labelContato.setFont(new Font("Arial", Font.PLAIN, 16));
			labelContato.setBounds(10, 148, 115, 20);
		}
		return labelContato;
	}
	public JLabel getLabelCep() {
		if (labelCep == null) {
			labelCep = new JLabel("CEP:*");
			labelCep.setForeground(Color.BLACK);
			labelCep.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCep.setBounds(10, 231, 46, 20);
		}
		return labelCep;
	}
	public JLabel getLabelCnpj() {
		if (labelCnpj == null) {
			labelCnpj = new JLabel("CNPJ:*");
			labelCnpj.setForeground(Color.BLACK);
			labelCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCnpj.setBounds(383, 100, 58, 20);
		}
		return labelCnpj;
	}
	public JLabel getLabelInscrioEstadualN() {
		if (labelInscricaoEstadualN == null) {
			labelInscricaoEstadualN = new JLabel("Inscri\u00E7\u00E3o Estadual n\u00BA:*");
			labelInscricaoEstadualN.setForeground(Color.BLACK);
			labelInscricaoEstadualN.setFont(new Font("Arial", Font.PLAIN, 16));
			labelInscricaoEstadualN.setBounds(400, 148, 171, 20);
		}
		return labelInscricaoEstadualN;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBounds(578, 231, 46, 20);
		}
		return labelNumero;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBounds(400, 282, 72, 20);
		}
		return labelCidade;
	}
	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("Email:*");
			labelEmail.setBackground(Color.WHITE);
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEmail.setBounds(777, 100, 58, 20);
		}
		return labelEmail;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBounds(775, 282, 46, 20);
		}
		return labelUfEndereco;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBounds(161, 231, 93, 20);
		}
		return labelLogradouro;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBounds(10, 281, 93, 20);
		}
		return labelBairro;
	}
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:*");
			labelTelefone.setBackground(Color.WHITE);
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(608, 100, 74, 20);
		}
		return labelTelefone;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBounds(702, 231, 104, 20);
		}
		return labelComplemento;
	}
	public JLabel getLabelLimiteDeCredito() {
		if (labelLimiteDeCredito == null) {
			labelLimiteDeCredito = new JLabel("Limite de Cr\u00E9dito:*");
			labelLimiteDeCredito.setBackground(Color.WHITE);
			labelLimiteDeCredito.setForeground(Color.BLACK);
			labelLimiteDeCredito.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLimiteDeCredito.setBounds(830, 148, 133, 20);
		}
		return labelLimiteDeCredito;
	}
	public JComboBox<String> getComboBoxTipoCliente() {
		if (comboBoxTipoCliente == null) {
			comboBoxTipoCliente = new JComboBox<String>();
			comboBoxTipoCliente.setBackground(Color.WHITE);
			comboBoxTipoCliente.setForeground(Color.BLACK);
			comboBoxTipoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoCliente.setEditable(true);
			comboBoxTipoCliente.setEnabled(false);
			comboBoxTipoCliente.setBounds(53, 40, 155, 20);
			comboBoxTipoCliente.addItem("Selecione");
			comboBoxTipoCliente.addItem("Pessoa Física");
			comboBoxTipoCliente.addItem("Pessoa Jurídica");
			comboBoxTipoCliente.setSelectedIndex(2);
		}
		return comboBoxTipoCliente;
	}	
	public JComboBox<String> getComboBoxSituacaoCliente() {
		if (comboBoxSituacaoCliente == null) {
			comboBoxSituacaoCliente = new JComboBox<String>();
			comboBoxSituacaoCliente.setBackground(Color.WHITE);
			comboBoxSituacaoCliente.setForeground(Color.BLACK);
			comboBoxSituacaoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSituacaoCliente.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Ativo", "Inativo"}));
			comboBoxSituacaoCliente.setBounds(352, 40, 147, 20);
		}
		return comboBoxSituacaoCliente;
	}	
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if(comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox<String>();
			comboBoxEstadoEndereco.setForeground(Color.BLACK);
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(775, 300, 115, 20);
		}
		return comboBoxEstadoEndereco;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldRazaoSocial() {
		if (validacaoGeralJTextFieldRazaoSocial == null) {
			validacaoGeralJTextFieldRazaoSocial = new ValidacaoGeralCamposTexto("1");
			validacaoGeralJTextFieldRazaoSocial.setBackground(Color.WHITE);
			validacaoGeralJTextFieldRazaoSocial.setForeground(Color.BLACK);
			validacaoGeralJTextFieldRazaoSocial.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldRazaoSocial.setBounds(10, 120, 345, 20);
		}
		return validacaoGeralJTextFieldRazaoSocial;
	}	

	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldNumero() {
		if (validacaoGeralJTextFieldNumero == null) {
			validacaoGeralJTextFieldNumero = new ValidacaoGeralCamposTexto("8");
			validacaoGeralJTextFieldNumero.setBackground(Color.WHITE);
			validacaoGeralJTextFieldNumero.setForeground(Color.BLACK);
			validacaoGeralJTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldNumero.setBounds(578, 250, 67, 20);
		}
		return validacaoGeralJTextFieldNumero;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldCidade() {
		if (validacaoGeralJTextFieldCidade == null) {
			validacaoGeralJTextFieldCidade = new ValidacaoGeralCamposTexto("1");
			validacaoGeralJTextFieldCidade.setBackground(Color.WHITE);
			validacaoGeralJTextFieldCidade.setForeground(Color.BLACK);
			validacaoGeralJTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldCidade.setBounds(400, 300, 191, 20);
		}
		return validacaoGeralJTextFieldCidade;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldLogradouro() {
		if (validacaoGeralJTextFieldLogradouro == null) {
			validacaoGeralJTextFieldLogradouro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralJTextFieldLogradouro.setBackground(Color.WHITE);
			validacaoGeralJTextFieldLogradouro.setForeground(Color.BLACK);
			validacaoGeralJTextFieldLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldLogradouro.setBounds(161, 250, 340, 20);
		}
		return validacaoGeralJTextFieldLogradouro;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldBairro() {
		if (validacaoGeralJTextFieldBairro == null) {
			validacaoGeralJTextFieldBairro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralJTextFieldBairro.setBackground(Color.WHITE);
			validacaoGeralJTextFieldBairro.setForeground(Color.BLACK);
			validacaoGeralJTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldBairro.setBounds(10, 300, 262, 20);
		}
		return validacaoGeralJTextFieldBairro;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldComplemento() {
		if (validacaoGeralJTextFieldComplemento == null) {
			validacaoGeralJTextFieldComplemento = new ValidacaoGeralCamposTexto("7");
			validacaoGeralJTextFieldComplemento.setBackground(Color.WHITE);
			validacaoGeralJTextFieldComplemento.setForeground(Color.BLACK);
			validacaoGeralJTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldComplemento.setBounds(702, 250, 261, 20);
		}
		return validacaoGeralJTextFieldComplemento;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldInscricaoEstadual() {
		if (validacaoJTextFieldInscricaoEstadual == null) {
			validacaoJTextFieldInscricaoEstadual = new ValidacaoGeralCamposTexto("5");
			validacaoJTextFieldInscricaoEstadual.setForeground(Color.BLACK);
			validacaoJTextFieldInscricaoEstadual.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldInscricaoEstadual.setBounds(400, 169, 152, 20);
		}
		return validacaoJTextFieldInscricaoEstadual;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldCnpj() {
		if (validacaoJTextFieldCnpj == null) {
			validacaoJTextFieldCnpj = new ValidacaoGeralCamposTexto("4");
			validacaoJTextFieldCnpj.setForeground(Color.BLACK);
			validacaoJTextFieldCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldCnpj.setBounds(384, 120, 191, 20);
		}
		return validacaoJTextFieldCnpj;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldLimiteCredito() {
		if (validacaoJTextFieldLimiteCredito == null) {
			validacaoJTextFieldLimiteCredito = new ValidacaoGeralCamposTexto("10");
			validacaoJTextFieldLimiteCredito.setBackground(Color.WHITE);
			validacaoJTextFieldLimiteCredito.setForeground(Color.BLACK);
			validacaoJTextFieldLimiteCredito.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldLimiteCredito.setBounds(853, 169, 110, 20);
			validacaoJTextFieldLimiteCredito.setColumns(10);
		}
		return validacaoJTextFieldLimiteCredito;
	}	
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldEmail() {
		if (validacaoJTextFieldEmail == null) {
			validacaoJTextFieldEmail = new ValidacaoGeralCamposTexto("9");
			validacaoJTextFieldEmail.setBackground(Color.WHITE);
			validacaoJTextFieldEmail.setForeground(Color.BLACK);
			validacaoJTextFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldEmail.setBounds(775, 120, 262, 20);
			validacaoJTextFieldEmail.setColumns(10);
		}
		return validacaoJTextFieldEmail;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralJTextFieldRepresentante() {
		if (validacaoGeralJTextFieldRepresentante == null) {
			validacaoGeralJTextFieldRepresentante = new ValidacaoGeralCamposTexto("1");
			validacaoGeralJTextFieldRepresentante.setBounds(new Rectangle(0, 0, 0, 20));
			validacaoGeralJTextFieldRepresentante.setForeground(Color.BLACK);
			validacaoGeralJTextFieldRepresentante.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralJTextFieldRepresentante.setBackground(Color.WHITE);
			validacaoGeralJTextFieldRepresentante.setBounds(10, 169, 345, 20);
		}
		return validacaoGeralJTextFieldRepresentante;
	}

	
	public JFormattedTextField getFormattedTextFieldCEP() {
		if (formattedTextFieldCEP == null) {
			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCEP.setBackground(Color.WHITE);
			formattedTextFieldCEP.setForeground(Color.BLACK);
			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCEP.setBounds(10, 250, 100, 20);
		}
		return formattedTextFieldCEP;
	}
	
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(608, 120, 138, 20);
		}
		return formattedTextFieldTelefone;
	}
	
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	public JLabel getLabelUfInscricaoEstadual() {
		if (labelUfInscricaoEstadual == null) {
			labelUfInscricaoEstadual = new JLabel("UF:*");
			labelUfInscricaoEstadual.setForeground(Color.BLACK);
			labelUfInscricaoEstadual.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfInscricaoEstadual.setBackground(Color.WHITE);
			labelUfInscricaoEstadual.setBounds(648, 148, 46, 20);
		}
		return labelUfInscricaoEstadual;
	}
	public JComboBox<String> getComboBoxUfInscricaoEstadual() {
		if (comboBoxUfInscricaoEstadual == null) {
			comboBoxUfInscricaoEstadual = new JComboBox<String>();
			comboBoxUfInscricaoEstadual.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", 
					"AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", 
					"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxUfInscricaoEstadual.setForeground(Color.BLACK);
			comboBoxUfInscricaoEstadual.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxUfInscricaoEstadual.setBackground(Color.WHITE);
			comboBoxUfInscricaoEstadual.setBounds(648, 169, 115, 20);
		}
		return comboBoxUfInscricaoEstadual;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(-12, 65, 1076, 11);
		}
		return separator;
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Dados Pessoais");
			label.setFont(new Font("Arial", Font.BOLD, 22));
			label.setBounds(10, 71, 411, 30);
		}
		return label;
	}
	public JLabel getLabelTituloEndereo() {
		if (labelTituloEndereo == null) {
			labelTituloEndereo = new JLabel("Endere\u00E7o");
			labelTituloEndereo.setFont(new Font("Arial", Font.BOLD, 22));
			labelTituloEndereo.setBounds(6, 203, 411, 30);
		}
		return labelTituloEndereo;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(0, 197, 1076, 11);
		}
		return separator_1;
	}
	
	public JuridicoTable getBuscaExibicaoTableModel(boolean consulta) {
		if(consulta == true) {
			return buscaExibicaoTableModel;
		}
		else{
			buscaExibicaoTableModel = new JuridicoTable();
			
			return buscaExibicaoTableModel;
		}		
	}

	private JLabel getLblR() {
		if (lblR == null) {
			lblR = new JLabel("R$");
			lblR.setFont(new Font("Arial", Font.PLAIN, 16));
			lblR.setBounds(830, 170, 27, 19);
		}
		return lblR;
	}
}
