package visao.cadastros.cliente;

import java.awt.*;
import javax.swing.*;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;
import modelo.tableModel.FisicoTable;
import visao.VisaoTelaPesquisa;
import javax.swing.border.LineBorder;

public class VisaoTelaCadastroClientePessoaFisica extends JPanel {
	private JLabel labelTipoCliente		 	  = null;
	private JLabel labelNome		 		  = null;
	private JLabel labelCPF		 		      = null;
	private JLabel labelCEP		 		      = null;
	private JLabel labelNumero		 		  = null;
	private JLabel labelCidade		 		  = null;
	private JLabel labelEmail		 		  = null;
	private JLabel labelUfEndereco		 	  = null;
	private JLabel labelSituacao		 	  = null;
	private JLabel labelRg		 	 		  = null;
	private JLabel labelUfRg		 		  = null;
	private JLabel labelOrgaoExpeditor		  = null;
	private JLabel labelLogradouro		 	  = null;
	private JLabel labelBairro		 		  = null;
	private JLabel labelTelefone		 	  = null;
	private JLabel labelComplemento		 	  = null;
	private JLabel labelLimiteDeCredito		  = null;
	private JLabel lblDataDeNascimento		  = null;
	private JLabel labelSexo		 		  = null;
	private JLabel lblR		 				  = null;
	private JLabel labelDadosPessoais		  = null;
	private JLabel labelEndereo		 		  = null;
	private JFormattedTextField formattedTextFieldCEP		 	 = null;
	private JFormattedTextField formattedTextFieldTelefone		 = null;	
	private JFormattedTextField formattedTextFieldDataNascimento = null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldRG		 		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNome		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldCPF		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldLogradouro		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldBairro		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldComplemento	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNumero		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldCidade		 	= null;	
	private ValidacaoGeralCamposTexto validacaoJTextFieldOrgaoExpeditor	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldLimiteCredito	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldEmail		 	= null;
	private JComboBox<String> comboBoxTipoCliente	  = null;
	private JComboBox<String> comboBoxEstadoEndereco  = null;
	private JComboBox<String> comboBoxSituacaoCliente = null;
	private JComboBox<String> comboBoxEstadoRG		  = null;
	private JComboBox<String> comboBoxSexo		 	  = null;
	private JSeparator separatorTitulo	= null;
	private JSeparator separator		= null;
	private JSeparator separator_2	    = null;
	private FisicoTable clienteFisicoTableModel = null;
	private FisicoTable buscaExibicaoTableModel = null;
	
	FormataMascaras fm = new FormataMascaras();
	public VisaoTelaCadastroClientePessoaFisica() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLabelTipoCliente());
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
		add(getLabelLimiteDeCredito());
		add(getLabelSexo());
		add(getLabelComplemento());
		add(getLblDataDeNascimento());
		add(getLabelDadosPessoais());
		add(getLabelEndereo());
		add(getLblR());
		add(getFormattedTextFieldCEP());
		add(getFormattedTextFieldTelefone());
		add(getFormattedTextFieldDataNascimento());
		add(getFormattedTextFieldCPF());
		add(getValidacaoJTextFieldNome());
		add(getValidacaoJTextFieldNumero());
		add(getValidacaoJTextFieldCidade());
		add(getValidacaoJTextFieldRG());
		add(getValidacaoJTextFieldLogradouro());
		add(getValidacaoJTextFieldBairro());
		add(getValidacaoJTextFieldComplemento());
		add(getTextFieldEmail());
		add(getTextFieldLimiteCredito());
		add(getValidacaoJTextFieldOrgaoExpeditor());
		add(getComboBoxTipoCliente());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxSituacaoCliente());
		add(getComboBoxEstadoRG());
		add(getTextFieldLimiteCredito());
		add(getComboBoxTipoCliente());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxSituacaoCliente());
		add(getComboBoxEstadoRG());
		add(getComboBoxSexo());
		add(getSeparatorTitulo());
		add(getSeparator());
		add(getSeparator_2());
	}
	public JLabel getLabelTipoCliente() {
		if (labelTipoCliente == null) {
			labelTipoCliente = new JLabel("Tipo:");
			labelTipoCliente.setBackground(Color.WHITE);
			labelTipoCliente.setForeground(Color.BLACK);
			labelTipoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTipoCliente.setBounds(10, 40, 46, 17);
		}
		return labelTipoCliente;
	}
	public JLabel getLabelNome() {
		if (labelNome == null) {
			labelNome = new JLabel("Nome:*");
			labelNome.setBackground(Color.WHITE);
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNome.setBounds(10, 93, 58, 17);
		}
		return labelNome;
	}
	public JLabel getLabelCPF() {
		if (labelCPF == null) {
			labelCPF = new JLabel("CPF:*");
			labelCPF.setBackground(Color.WHITE);
			labelCPF.setForeground(Color.BLACK);
			labelCPF.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCPF.setBounds(10, 147, 46, 17);
		}
		return labelCPF;
	}
	public JLabel getLabelCEP() {
		if (labelCEP == null) {
			labelCEP = new JLabel("CEP:*");
			labelCEP.setBackground(Color.WHITE);
			labelCEP.setForeground(Color.BLACK);
			labelCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCEP.setBounds(10, 233, 46, 17);
		}
		return labelCEP;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBounds(539, 231, 46, 21);
		}
		return labelNumero;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBounds(401, 282, 72, 20);
		}
		return labelCidade;
	}
	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("Email:*");
			labelEmail.setBackground(Color.WHITE);
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEmail.setBounds(666, 147, 58, 17);
		}
		return labelEmail;
	}
	public ValidacaoGeralCamposTexto getFormattedTextFieldCPF() {
		if (validacaoJTextFieldCPF == null) {
			validacaoJTextFieldCPF = new ValidacaoGeralCamposTexto("3");
			validacaoJTextFieldCPF.setBackground(Color.WHITE);
			validacaoJTextFieldCPF.setForeground(Color.BLACK);
			validacaoJTextFieldCPF.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldCPF.setBounds(10, 167, 133, 20);
		}
		return validacaoJTextFieldCPF;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNome() {//não precisa
		if (validacaoJTextFieldNome == null) {
			validacaoJTextFieldNome = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldNome.setBackground(Color.WHITE);
			validacaoJTextFieldNome.setForeground(Color.BLACK);
			validacaoJTextFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldNome.setBounds(10, 113, 412, 20);
		}
		return validacaoJTextFieldNome;
	}
	public JFormattedTextField getFormattedTextFieldCEP() {
		if (formattedTextFieldCEP == null) {
			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCEP.setBackground(Color.WHITE);
			formattedTextFieldCEP.setForeground(Color.BLACK);
			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCEP.setBounds(10, 251, 104, 20);
		}
		return formattedTextFieldCEP;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNumero() {
		if (validacaoJTextFieldNumero == null) {
			validacaoJTextFieldNumero = new ValidacaoGeralCamposTexto("8");
			validacaoJTextFieldNumero.setBackground(Color.WHITE);
			validacaoJTextFieldNumero.setForeground(Color.BLACK);
			validacaoJTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 16));

			validacaoJTextFieldNumero.setBounds(539, 250, 72, 21);
		}
		return validacaoJTextFieldNumero;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldCidade() {
		if (validacaoJTextFieldCidade == null) {
			validacaoJTextFieldCidade = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldCidade.setBackground(Color.WHITE);
			validacaoJTextFieldCidade.setForeground(Color.BLACK);
			validacaoJTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldCidade.setBounds(401, 305, 207, 20);
		}
		return validacaoJTextFieldCidade;
	}
	public JComboBox<String> getComboBoxTipoCliente() {
		if (comboBoxTipoCliente == null) {
			comboBoxTipoCliente = new JComboBox<String>();
			comboBoxTipoCliente.setBackground(Color.WHITE);
			comboBoxTipoCliente.setForeground(Color.BLACK);
			comboBoxTipoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoCliente.setEditable(true);
			comboBoxTipoCliente.setEnabled(false);
			comboBoxTipoCliente.setBounds(54, 38, 155, 20);
			comboBoxTipoCliente.addItem("Selecione");
			comboBoxTipoCliente.addItem("Pessoa Física");
			comboBoxTipoCliente.addItem("Pessoa Jurídica");
			comboBoxTipoCliente.setSelectedIndex(1);
		}
		return comboBoxTipoCliente;
	}
	public ValidacaoGeralCamposTexto getTextFieldEmail() {
		if (validacaoJTextFieldEmail == null) {
			validacaoJTextFieldEmail = new ValidacaoGeralCamposTexto("9");
			validacaoJTextFieldEmail.setBackground(Color.WHITE);
			validacaoJTextFieldEmail.setForeground(Color.BLACK);
			validacaoJTextFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldEmail.setBounds(666, 167, 219, 20);
			validacaoJTextFieldEmail.setColumns(10);
		}
		return validacaoJTextFieldEmail;
	}
	
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if(comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox<String>();
			comboBoxEstadoEndereco.setForeground(Color.BLACK);
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(724, 303, 115, 20);
		}
		return comboBoxEstadoEndereco;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBounds(724, 282, 46, 17);
		}
		return labelUfEndereco;
	}
	public JLabel getLabelSituacao() {
		if (labelSituacao == null) {
			labelSituacao = new JLabel("Situa\u00E7\u00E3o:*");
			labelSituacao.setBackground(Color.WHITE);
			labelSituacao.setForeground(Color.BLACK);
			labelSituacao.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSituacao.setBounds(323, 40, 83, 17);
		}
		return labelSituacao;
	}
	public JComboBox<String> getComboBoxSituacaoCliente() {
		if (comboBoxSituacaoCliente == null) {
			comboBoxSituacaoCliente = new JComboBox<String>();
			comboBoxSituacaoCliente.setBackground(Color.WHITE);
			comboBoxSituacaoCliente.setForeground(Color.BLACK);
			comboBoxSituacaoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSituacaoCliente.addItem("Selecione");
			comboBoxSituacaoCliente.addItem("Ativo");
			comboBoxSituacaoCliente.addItem("Inativo");
			comboBoxSituacaoCliente.setBounds(416, 38, 123, 20);
		}
		return comboBoxSituacaoCliente;
	}
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("RG:*");
			labelRg.setBackground(Color.WHITE);
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Arial", Font.PLAIN, 16));
			labelRg.setBounds(163, 150, 46, 17);
		}
		return labelRg;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldRG() {
		if (validacaoJTextFieldRG == null) {
			validacaoJTextFieldRG = new ValidacaoGeralCamposTexto("2");
			validacaoJTextFieldRG.setBackground(Color.WHITE);
			validacaoJTextFieldRG.setForeground(Color.BLACK);
			validacaoJTextFieldRG.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldRG.setBounds(163, 167, 133, 20);
		}
		return validacaoJTextFieldRG;
	}
	public JLabel getLabelUfRg() {
		if (labelUfRg == null) {
			labelUfRg = new JLabel("UF:*");
			labelUfRg.setBackground(Color.WHITE);
			labelUfRg.setForeground(Color.BLACK);
			labelUfRg.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfRg.setBounds(315, 147, 46, 17);
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
			comboBoxEstadoRG.setBounds(315, 167, 115, 20);
		}
		return comboBoxEstadoRG;
	}
	public JLabel getLabelOrgaoExpeditor() {
		if (labelOrgaoExpeditor == null) {
			labelOrgaoExpeditor = new JLabel("\u00D3rg\u00E3o Expedidor:*");
			labelOrgaoExpeditor.setBackground(Color.WHITE);
			labelOrgaoExpeditor.setForeground(Color.BLACK);
			labelOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelOrgaoExpeditor.setBounds(449, 146, 162, 19);
		}
		return labelOrgaoExpeditor;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBounds(166, 233, 93, 19);
		}
		return labelLogradouro;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldLogradouro() {
		if (validacaoJTextFieldLogradouro == null) {
			validacaoJTextFieldLogradouro = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldLogradouro.setBackground(Color.WHITE);
			validacaoJTextFieldLogradouro.setForeground(Color.BLACK);
			validacaoJTextFieldLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldLogradouro.setBounds(166, 251, 307, 20);
		}
		return validacaoJTextFieldLogradouro;
	}
	
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBounds(10, 282, 93, 21);
		}
		return labelBairro;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldBairro() {
		if (validacaoJTextFieldBairro == null) {
			validacaoJTextFieldBairro = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldBairro.setBackground(Color.WHITE);
			validacaoJTextFieldBairro.setForeground(Color.BLACK);
			validacaoJTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldBairro.setBounds(10, 304, 262, 21);
		}
		return validacaoJTextFieldBairro;
	}
	
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:*");
			labelTelefone.setBackground(Color.WHITE);
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(868, 93, 74, 17);
		}
		return labelTelefone;
	}
	
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(867, 111, 162, 20);
		}
		return formattedTextFieldTelefone;
	}
	
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBounds(691, 228, 104, 21);
		}
		return labelComplemento;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldComplemento() {
		if (validacaoJTextFieldComplemento == null) {
			validacaoJTextFieldComplemento = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldComplemento.setBackground(Color.WHITE);
			validacaoJTextFieldComplemento.setForeground(Color.BLACK);
			validacaoJTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldComplemento.setBounds(691, 250, 249, 21);
		}
		return validacaoJTextFieldComplemento;
	}
	public JLabel getLabelLimiteDeCredito() {
		if (labelLimiteDeCredito == null) {
			labelLimiteDeCredito = new JLabel("Limite de Cr\u00E9dito:*");
			labelLimiteDeCredito.setBackground(Color.WHITE);
			labelLimiteDeCredito.setForeground(Color.BLACK);
			labelLimiteDeCredito.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLimiteDeCredito.setBounds(908, 147, 150, 17);
		}
		return labelLimiteDeCredito;
	}
	
	public ValidacaoGeralCamposTexto getTextFieldLimiteCredito() {
		if (validacaoJTextFieldLimiteCredito == null) {
			validacaoJTextFieldLimiteCredito = new ValidacaoGeralCamposTexto("10");
			validacaoJTextFieldLimiteCredito.setBackground(Color.WHITE);
			validacaoJTextFieldLimiteCredito.setForeground(Color.BLACK);
			validacaoJTextFieldLimiteCredito.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldLimiteCredito.setBounds(931, 167, 110, 20);
			validacaoJTextFieldLimiteCredito.setColumns(10);
		}
		return validacaoJTextFieldLimiteCredito;
	}
	public JLabel getLabelSexo() {
		if (labelSexo == null) {
			labelSexo = new JLabel("Sexo:*");
			labelSexo.setBackground(Color.WHITE);
			labelSexo.setForeground(Color.BLACK);
			labelSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSexo.setBounds(701, 93, 46, 17);
		}
		return labelSexo;
	}
	public JComboBox<String> getComboBoxSexo() {
		if (comboBoxSexo == null) {
			comboBoxSexo = new JComboBox<String>();
			comboBoxSexo.setBackground(Color.WHITE);
			comboBoxSexo.setForeground(Color.BLACK);
			comboBoxSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSexo.addItem("Selecione");
			comboBoxSexo.addItem("Feminino");
			comboBoxSexo.addItem("Masculino");
			comboBoxSexo.setBounds(701, 113, 99, 20);
		}
		return comboBoxSexo;
	}
	public JLabel getLblDataDeNascimento() {
		if (lblDataDeNascimento == null) {
			lblDataDeNascimento = new JLabel("Data de nascimento:*");
			lblDataDeNascimento.setBackground(Color.WHITE);
			lblDataDeNascimento.setForeground(Color.BLACK);
			lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			lblDataDeNascimento.setBounds(463, 93, 169, 17);
		}
		return lblDataDeNascimento;
	}
	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(fm.getData());
			formattedTextFieldDataNascimento.setBackground(Color.WHITE);
			formattedTextFieldDataNascimento.setForeground(Color.BLACK);
			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldDataNascimento.setBounds(463, 113, 148, 20);
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
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldOrgaoExpeditor() {
		if (validacaoJTextFieldOrgaoExpeditor == null) {
			validacaoJTextFieldOrgaoExpeditor = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldOrgaoExpeditor.setForeground(Color.BLACK);		
			validacaoJTextFieldOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldOrgaoExpeditor.setBackground(Color.WHITE);
			validacaoJTextFieldOrgaoExpeditor.setBounds(449, 167, 187, 20);
		}
		return validacaoJTextFieldOrgaoExpeditor;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 197, 1076, 11);
		}
		return separator;
	}
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("Dados Pessoais");
			labelDadosPessoais.setFont(new Font("Arial", Font.BOLD, 22));
			labelDadosPessoais.setBounds(11, 63, 411, 30);
		}
		return labelDadosPessoais;
	}
	public JLabel getLabelEndereo() {
		if (labelEndereo == null) {
			labelEndereo = new JLabel("Endere\u00E7o");
			labelEndereo.setFont(new Font("Arial", Font.BOLD, 22));
			labelEndereo.setBounds(11, 202, 411, 30);
		}
		return labelEndereo;
	}
	public JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setForeground(Color.BLACK);
			separator_2.setBounds(0, 63, 1076, 11);
		}
		return separator_2;
	}
	
	private JLabel getLblR() {
		if (lblR == null) {
			lblR = new JLabel("R$");
			lblR.setFont(new Font("Arial", Font.PLAIN, 16));
			lblR.setBounds(908, 165, 31, 25);
		}
		return lblR;
	}
}
