//package visao.cadastros.fornecedor;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JFormattedTextField;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.JTextField;
//
//import controle.FormataMascaras;
//
//public class VisaoTelaCadastroFornecedorPessoaFisica extends JPanel{
//	private JLabel labelTipoFornecedor;
//	private JLabel labelNome;
//	private JLabel labelCPF;
//	private JLabel labelCEP;
//	private JLabel labelNumero;
//	private JLabel labelCidade;
//	private JLabel labelEmail;
//	private JLabel labelUfEndereco;
//	private JLabel labelSituacao;
//	private JLabel labelRg;
//	private JLabel labelUfRg;
//	private JLabel labelOrgaoExpeditor;
//	private JLabel labelLogradouro;
//	private JLabel labelBairro;
//	private JLabel labelTelefone;
//	private JLabel labelComplemento;
//	private JLabel labelLimiteDeCredito;
//	private JLabel lblDataDeNascimento;
//	private JLabel labelSexo;
//	private JFormattedTextField formattedTextFieldCPF;
//	private JFormattedTextField formattedTextFieldNome;
//	private JFormattedTextField formattedTextFieldCEP;
//	private JFormattedTextField formattedTextFieldNumero;
//	private JFormattedTextField formattedTextFieldCidade;
//	private JFormattedTextField formattedTextFieldRG;
//	private JFormattedTextField formattedTextFieldLogradouro;
//	private JFormattedTextField formattedTextFieldBairro;	
//	private JFormattedTextField formattedTextFieldTelefone;	
//	private JFormattedTextField formattedTextFieldComplemento;
//	private JFormattedTextField formattedTextFieldDataNascimento;
//	private JComboBox<String> comboBoxTipoFornecedor;
//	private JComboBox<String> 	comboBoxEstadoEndereco;
//	private JComboBox<String> comboBoxSituacaoFornecedor;
//	private JComboBox<String> comboBoxEstadoRG;
//	private JComboBox<String> comboBoxOrgaoExpeditor;
//	private JComboBox<String> comboBoxSexo;
//	private JTextField textFieldEmail;
//	private JTextField textFieldLimiteCredito;
//	private JLabel labelPaginaCadastroFornecedor;
//	private JSeparator separatorTitulo;
//	FormataMascaras fm = new FormataMascaras();
//	private JLabel lblRamoDeAtividade;
//	private JFormattedTextField formattedTextField;
//	
//	public VisaoTelaCadastroFornecedorPessoaFisica() {
//		setLayout(null);
//		setBackground(new Color(252, 246, 229));
//		setMinimumSize(new Dimension(1055, 720));
//		setMaximumSize(new Dimension(1055, 720));
//		add(getLabelTipoFornecedor());
//		add(getLabelNome());
//		add(getLabelCPF());
//		add(getLabelCEP());
//		add(getLabelNumero());
//		add(getLabelCidade());
//		add(getLabelEmail());
//		add(getLabelUfEndereco());
//		add(getLabelSituacao());
//		add(getLabelRg());
//		add(getLabelUfRg());
//		add(getLabelOrgaoExpeditor());
//		add(getLabelLogradouro());
//		add(getLabelBairro());
//		add(getLabelTelefone());
//		add(getLabelLimiteDeCredito());
//		add(getLabelSexo());
//		add(getLabelComplemento());
//		add(getLblDataDeNascimento());
//		add(getFormattedTextFieldCPF());
//		add(getFormattedTextFieldNome());
//		add(getFormattedTextFieldCEP());
//		add(getFormattedTextFieldNumero());
//		add(getFormattedTextFieldCidade());
//		add(getFormattedTextFieldRG());
//		add(getFormattedTextFieldLogradouro());
//		add(getFormattedTextFieldBairro());
//		add(getFormattedTextFieldTelefone());
//		add(getFormattedTextFieldComplemento());
//		add(getFormattedTextFieldDataNascimento());
//		add(getTextFieldEmail());
//		add(getTextFieldLimiteCredito());
//		add(getComboBoxTipoFornecedor());
//		add(getComboBoxEstadoEndereco());
//		add(getComboBoxSituacaoFornecedor());
//		add(getComboBoxEstadoRG());
//		add(getComboBoxOrgaoExpeditor());
//		add(getComboBoxSexo());
//		add(getSeparatorTitulo());
//		add(getLabelPaginaCadastroFornecedor());
//		add(getLblRamoDeAtividade());
//		add(getFormattedTextField());
//	}
//	
//	public JLabel getLabelTipoFornecedor() {
//		if (labelTipoFornecedor == null) {
//			labelTipoFornecedor = new JLabel("Tipo:");
//			labelTipoFornecedor.setBackground(Color.WHITE);
//			labelTipoFornecedor.setForeground(Color.BLACK);
//			labelTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelTipoFornecedor.setBounds(10, 40, 46, 17);
//		}
//		return labelTipoFornecedor;
//	}
//	public JLabel getLabelNome() {
//		if (labelNome == null) {
//			labelNome = new JLabel("Nome:");
//			labelNome.setBackground(Color.WHITE);
//			labelNome.setForeground(Color.BLACK);
//			labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelNome.setBounds(10, 92, 46, 17);
//		}
//		return labelNome;
//	}
//	public JLabel getLabelCPF() {
//		if (labelCPF == null) {
//			labelCPF = new JLabel("CPF:");
//			labelCPF.setBackground(Color.WHITE);
//			labelCPF.setForeground(Color.BLACK);
//			labelCPF.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelCPF.setBounds(153, 143, 46, 17);
//		}
//		return labelCPF;
//	}
//	public JLabel getLabelCEP() {
//		if (labelCEP == null) {
//			labelCEP = new JLabel("CEP:");
//			labelCEP.setBackground(Color.WHITE);
//			labelCEP.setForeground(Color.BLACK);
//			labelCEP.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelCEP.setBounds(10, 197, 46, 17);
//		}
//		return labelCEP;
//	}
//	public JLabel getLabelNumero() {
//		if (labelNumero == null) {
//			labelNumero = new JLabel("N\u00BA:");
//			labelNumero.setBackground(Color.WHITE);
//			labelNumero.setForeground(Color.BLACK);
//			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelNumero.setBounds(463, 197, 46, 21);
//		}
//		return labelNumero;
//	}
//	public JLabel getLabelCidade() {
//		if (labelCidade == null) {
//			labelCidade = new JLabel("Cidade:");
//			labelCidade.setBackground(Color.WHITE);
//			labelCidade.setForeground(Color.BLACK);
//			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelCidade.setBounds(575, 248, 72, 20);
//		}
//		return labelCidade;
//	}
//	public JLabel getLabelEmail() {
//		if (labelEmail == null) {
//			labelEmail = new JLabel("Email:");
//			labelEmail.setBackground(Color.WHITE);
//			labelEmail.setForeground(Color.BLACK);
//			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelEmail.setBounds(336, 302, 46, 17);
//		}
//		return labelEmail;
//	}
//	public JFormattedTextField getFormattedTextFieldCPF() {
//		if (formattedTextFieldCPF == null) {
//			formattedTextFieldCPF = new JFormattedTextField(fm.getCPF());
//			formattedTextFieldCPF.setBackground(Color.WHITE);
//			formattedTextFieldCPF.setForeground(Color.BLACK);
//			formattedTextFieldCPF.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldCPF.setBounds(153, 163, 133, 20);
//		}
//		return formattedTextFieldCPF;
//	}
//	public JFormattedTextField getFormattedTextFieldNome() {
//		if (formattedTextFieldNome == null) {
//			formattedTextFieldNome = new JFormattedTextField(fm.getNome());
//			formattedTextFieldNome.setBackground(Color.WHITE);
//			formattedTextFieldNome.setForeground(Color.BLACK);
//			formattedTextFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldNome.setBounds(10, 112, 347, 20);
//		}
//		return formattedTextFieldNome;
//	}
//	public JFormattedTextField getFormattedTextFieldCEP() {
//		if (formattedTextFieldCEP == null) {
//			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
//			formattedTextFieldCEP.setBackground(Color.WHITE);
//			formattedTextFieldCEP.setForeground(Color.BLACK);
//			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldCEP.setBounds(10, 215, 104, 20);
//		}
//		return formattedTextFieldCEP;
//	}
//	public JFormattedTextField getFormattedTextFieldNumero() {
//		if (formattedTextFieldNumero == null) {
//			formattedTextFieldNumero = new JFormattedTextField(fm.getNumero());
//			formattedTextFieldNumero.setBackground(Color.WHITE);
//			formattedTextFieldNumero.setForeground(Color.BLACK);
//			formattedTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldNumero.setBounds(463, 216, 72, 21);
//		}
//		return formattedTextFieldNumero;
//	}
//	public JFormattedTextField getFormattedTextFieldCidade() {
//		if (formattedTextFieldCidade == null) {
//			formattedTextFieldCidade = new JFormattedTextField(fm.getNome());
//			formattedTextFieldCidade.setBackground(Color.WHITE);
//			formattedTextFieldCidade.setForeground(Color.BLACK);
//			formattedTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldCidade.setBounds(575, 271, 207, 20);
//		}
//		return formattedTextFieldCidade;
//	}
//	public JComboBox getComboBoxTipoFornecedor() {
//		if (comboBoxTipoFornecedor == null) {
//			comboBoxTipoFornecedor = new JComboBox();
//			comboBoxTipoFornecedor.setBackground(Color.WHITE);
//			comboBoxTipoFornecedor.setForeground(Color.BLACK);
//			comboBoxTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxTipoFornecedor.setEditable(true);
//			comboBoxTipoFornecedor.setEnabled(false);
//			comboBoxTipoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa F\u00EDsica", "Pessoa Jur\u00EDdica"}));
//			comboBoxTipoFornecedor.setBounds(10, 61, 123, 20);
//			comboBoxTipoFornecedor.setSelectedIndex(1);
//		}
//		return comboBoxTipoFornecedor;
//	}
//	public JTextField getTextFieldEmail() {
//		if (textFieldEmail == null) {
//			textFieldEmail = new JTextField();
//			textFieldEmail.setBackground(Color.WHITE);
//			textFieldEmail.setForeground(Color.BLACK);
//			textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
//			textFieldEmail.setBounds(336, 320, 219, 20);
//			textFieldEmail.setColumns(10);
//		}
//		return textFieldEmail;
//	}
//	
//	public JComboBox<String> getComboBoxEstadoEndereco() {
//		if(comboBoxEstadoEndereco == null) {
//			comboBoxEstadoEndereco = new JComboBox<String>();
//			comboBoxEstadoEndereco.setForeground(Color.BLACK);
//			comboBoxEstadoEndereco.setBackground(Color.WHITE);
//			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
//			comboBoxEstadoEndereco.setBounds(10, 320, 115, 20);
//		}
//		return comboBoxEstadoEndereco;
//	}
//	public JLabel getLabelUfEndereco() {
//		if (labelUfEndereco == null) {
//			labelUfEndereco = new JLabel("UF:");
//			labelUfEndereco.setBackground(Color.WHITE);
//			labelUfEndereco.setForeground(Color.BLACK);
//			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelUfEndereco.setBounds(11, 302, 46, 17);
//		}
//		return labelUfEndereco;
//	}
//	public JLabel getLabelSituacao() {
//		if (labelSituacao == null) {
//			labelSituacao = new JLabel("Situa\u00E7\u00E3o:");
//			labelSituacao.setBackground(Color.WHITE);
//			labelSituacao.setForeground(Color.BLACK);
//			labelSituacao.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelSituacao.setBounds(204, 41, 68, 17);
//		}
//		return labelSituacao;
//	}
//	public JComboBox<String> getComboBoxSituacaoFornecedor() {
//		if (comboBoxSituacaoFornecedor == null) {
//			comboBoxSituacaoFornecedor = new JComboBox();
//			comboBoxSituacaoFornecedor.setBackground(Color.WHITE);
//			comboBoxSituacaoFornecedor.setForeground(Color.BLACK);
//			comboBoxSituacaoFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxSituacaoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Ativo", "Inativo"}));
//			comboBoxSituacaoFornecedor.setBounds(204, 61, 123, 20);
//		}
//		return comboBoxSituacaoFornecedor;
//	}
//	public JLabel getLabelRg() {
//		if (labelRg == null) {
//			labelRg = new JLabel("RG:");
//			labelRg.setBackground(Color.WHITE);
//			labelRg.setForeground(Color.BLACK);
//			labelRg.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelRg.setBounds(329, 146, 46, 17);
//		}
//		return labelRg;
//	}
//	public JFormattedTextField getFormattedTextFieldRG() {
//		if (formattedTextFieldRG == null) {
//			formattedTextFieldRG = new JFormattedTextField(fm.getRG());
//			formattedTextFieldRG.setBackground(Color.WHITE);
//			formattedTextFieldRG.setForeground(Color.BLACK);
//			formattedTextFieldRG.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldRG.setBounds(329, 163, 133, 20);
//		}
//		return formattedTextFieldRG;
//	}
//	public JLabel getLabelUfRg() {
//		if (labelUfRg == null) {
//			labelUfRg = new JLabel("UF:");
//			labelUfRg.setBackground(Color.WHITE);
//			labelUfRg.setForeground(Color.BLACK);
//			labelUfRg.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelUfRg.setBounds(483, 146, 46, 17);
//		}
//		return labelUfRg;
//	}
//	public JComboBox<String> getComboBoxEstadoRG() {
//		if (comboBoxEstadoRG == null) {
//			comboBoxEstadoRG = new JComboBox<String>();
//			comboBoxEstadoRG.setForeground(Color.BLACK);
//			comboBoxEstadoRG.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", 
//					"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
//			comboBoxEstadoRG.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxEstadoRG.setBackground(Color.WHITE);
//			comboBoxEstadoRG.setBounds(483, 164, 115, 20);
//		}
//		return comboBoxEstadoRG;
//	}
//	public JLabel getLabelOrgaoExpeditor() {
//		if (labelOrgaoExpeditor == null) {
//			labelOrgaoExpeditor = new JLabel("\u00D3rg\u00E3o Expeditor:");
//			labelOrgaoExpeditor.setBackground(Color.WHITE);
//			labelOrgaoExpeditor.setForeground(Color.BLACK);
//			labelOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelOrgaoExpeditor.setBounds(620, 143, 162, 19);
//		}
//		return labelOrgaoExpeditor;
//	}
//	public JComboBox<String> getComboBoxOrgaoExpeditor() {
//		if (comboBoxOrgaoExpeditor == null) {
//			comboBoxOrgaoExpeditor = new JComboBox<String>();
//			comboBoxOrgaoExpeditor.setForeground(Color.BLACK);
//			comboBoxOrgaoExpeditor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "SSP", "Pol\u00EDcia Civil"}));
//			comboBoxOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxOrgaoExpeditor.setBackground(Color.WHITE);
//			comboBoxOrgaoExpeditor.setBounds(621, 164, 115, 20);
//		}
//		return comboBoxOrgaoExpeditor;
//	}
//	public JLabel getLabelLogradouro() {
//		if (labelLogradouro == null) {
//			labelLogradouro = new JLabel("Logradouro:");
//			labelLogradouro.setBackground(Color.WHITE);
//			labelLogradouro.setForeground(Color.BLACK);
//			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelLogradouro.setBounds(137, 199, 93, 19);
//		}
//		return labelLogradouro;
//	}
//	public JFormattedTextField getFormattedTextFieldLogradouro() {
//		if (formattedTextFieldLogradouro == null) {
//			formattedTextFieldLogradouro = new JFormattedTextField(fm.getNome());
//			formattedTextFieldLogradouro.setBackground(Color.WHITE);
//			formattedTextFieldLogradouro.setForeground(Color.BLACK);
//			formattedTextFieldLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldLogradouro.setBounds(137, 217, 307, 20);
//		}
//		return formattedTextFieldLogradouro;
//	}
//	
//	public JLabel getLabelBairro() {
//		if (labelBairro == null) {
//			labelBairro = new JLabel("Bairro:");
//			labelBairro.setBackground(Color.WHITE);
//			labelBairro.setForeground(Color.BLACK);
//			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelBairro.setBounds(10, 248, 93, 21);
//		}
//		return labelBairro;
//	}
//	public JFormattedTextField getFormattedTextFieldBairro() {
//		if (formattedTextFieldBairro == null) {
//			formattedTextFieldBairro = new JFormattedTextField(fm.getNome());
//			formattedTextFieldBairro.setBackground(Color.WHITE);
//			formattedTextFieldBairro.setForeground(Color.BLACK);
//			formattedTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldBairro.setBounds(10, 270, 262, 21);
//		}
//		return formattedTextFieldBairro;
//	}
//	
//	public JLabel getLabelTelefone() {
//		if (labelTelefone == null) {
//			labelTelefone = new JLabel("Telefone:");
//			labelTelefone.setBackground(Color.WHITE);
//			labelTelefone.setForeground(Color.BLACK);
//			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelTelefone.setBounds(158, 302, 74, 17);
//		}
//		return labelTelefone;
//	}
//	public JFormattedTextField getFormattedTextFieldTelefone() {
//		if (formattedTextFieldTelefone == null) {
//			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
//			formattedTextFieldTelefone.setBackground(Color.WHITE);
//			formattedTextFieldTelefone.setForeground(Color.BLACK);
//			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldTelefone.setBounds(157, 320, 162, 20);
//		}
//		return formattedTextFieldTelefone;
//	}
//	
//	public JLabel getLabelComplemento() {
//		if (labelComplemento == null) {
//			labelComplemento = new JLabel("Complemento:");
//			labelComplemento.setBackground(Color.WHITE);
//			labelComplemento.setForeground(Color.BLACK);
//			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelComplemento.setBounds(296, 248, 104, 21);
//		}
//		return labelComplemento;
//	}
//	public JFormattedTextField getFormattedTextFieldComplemento() {
//		if (formattedTextFieldComplemento == null) {
//			formattedTextFieldComplemento = new JFormattedTextField(fm.getNome());
//			formattedTextFieldComplemento.setBackground(Color.WHITE);
//			formattedTextFieldComplemento.setForeground(Color.BLACK);
//			formattedTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldComplemento.setBounds(296, 270, 249, 21);
//		}
//		return formattedTextFieldComplemento;
//	}
//	public JLabel getLabelLimiteDeCredito() {
//		if (labelLimiteDeCredito == null) {
//			labelLimiteDeCredito = new JLabel("Limite de Cr\u00E9dito:");
//			labelLimiteDeCredito.setBackground(Color.WHITE);
//			labelLimiteDeCredito.setForeground(Color.BLACK);
//			labelLimiteDeCredito.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelLimiteDeCredito.setBounds(575, 302, 150, 17);
//		}
//		return labelLimiteDeCredito;
//	}
//	public JTextField getTextFieldLimiteCredito() {
//		if (textFieldLimiteCredito == null) {
//			textFieldLimiteCredito = new JTextField();
//			textFieldLimiteCredito.setBackground(Color.WHITE);
//			textFieldLimiteCredito.setForeground(Color.BLACK);
//			textFieldLimiteCredito.setFont(new Font("Arial", Font.PLAIN, 16));
//			textFieldLimiteCredito.setBounds(575, 320, 133, 20);
//			textFieldLimiteCredito.setColumns(10);
//		}
//		return textFieldLimiteCredito;
//	}
//	public JLabel getLabelSexo() {
//		if (labelSexo == null) {
//			labelSexo = new JLabel("Sexo:");
//			labelSexo.setBackground(Color.WHITE);
//			labelSexo.setForeground(Color.BLACK);
//			labelSexo.setFont(new Font("Arial", Font.PLAIN, 16));
//			labelSexo.setBounds(10, 143, 46, 17);
//		}
//		return labelSexo;
//	}
//	public JComboBox<String> getComboBoxSexo() {
//		if (comboBoxSexo == null) {
//			comboBoxSexo = new JComboBox();
//			comboBoxSexo.setBackground(Color.WHITE);
//			comboBoxSexo.setForeground(Color.BLACK);
//			comboBoxSexo.setFont(new Font("Arial", Font.PLAIN, 16));
//			comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Feminino", "Masculino"}));
//			comboBoxSexo.setBounds(10, 163, 99, 20);
//		}
//		return comboBoxSexo;
//	}
//	public JLabel getLblDataDeNascimento() {
//		if (lblDataDeNascimento == null) {
//			lblDataDeNascimento = new JLabel("Data de nascimento:");
//			lblDataDeNascimento.setBackground(Color.WHITE);
//			lblDataDeNascimento.setForeground(Color.BLACK);
//			lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
//			lblDataDeNascimento.setBounds(632, 92, 150, 17);
//		}
//		return lblDataDeNascimento;
//	}
//	public JFormattedTextField getFormattedTextFieldDataNascimento() {
//		if (formattedTextFieldDataNascimento == null) {
//			formattedTextFieldDataNascimento = new JFormattedTextField(fm.getData());
//			formattedTextFieldDataNascimento.setBackground(Color.WHITE);
//			formattedTextFieldDataNascimento.setForeground(Color.BLACK);
//			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextFieldDataNascimento.setBounds(632, 112, 122, 20);
//		}
//		return formattedTextFieldDataNascimento;
//	}
//	public JSeparator getSeparatorTitulo() {
//		if (separatorTitulo == null) {
//			separatorTitulo = new JSeparator();
//			separatorTitulo.setForeground(Color.BLACK);
//			separatorTitulo.setBounds(0, 30, 1500, 22);
//		}
//		return separatorTitulo;
//	}
//	public JLabel getLabelPaginaCadastroFornecedor() {
//		if (labelPaginaCadastroFornecedor == null) {
//			labelPaginaCadastroFornecedor = new JLabel(" Cadastro de Fornecedor - Pessoa F\u00EDsica");
//			labelPaginaCadastroFornecedor.setFont(new Font("Arial", Font.BOLD, 22));
//			labelPaginaCadastroFornecedor.setBounds(0, 0, 493, 30);
//		}
//		return labelPaginaCadastroFornecedor;
//	}
//	public JLabel getLblRamoDeAtividade() {
//		if (lblRamoDeAtividade == null) {
//			lblRamoDeAtividade = new JLabel("Ramo de atividade:");
//			lblRamoDeAtividade.setFont(new Font("Arial", Font.PLAIN, 16));
//			lblRamoDeAtividade.setBounds(381, 93, 158, 14);
//		}
//		return lblRamoDeAtividade;
//	}
//	public JFormattedTextField getFormattedTextField() {
//		if (formattedTextField == null) {
//			formattedTextField = new JFormattedTextField(fm.getNome());
//			formattedTextField.setFont(new Font("Arial", Font.PLAIN, 16));
//			formattedTextField.setBounds(381, 112, 230, 20);
//		}
//		return formattedTextField;
//	}
//}
