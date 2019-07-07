package visao.cadastros.funcionario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;
import modelo.tableModel.FisicoTable;
import modelo.tableModel.FisicoTable_F;
import visao.VisaoTelaPesquisa;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class VisaoTelaCadastroFuncionario extends JPanel {
	private VisaoTelaPesquisa telaPesquisa 	 = null;
	private JLabel labelCadastroDeFuncionrio = null;
	private JLabel labelNome 				 = null;
	private JLabel labelCpf 				 = null;
	private JLabel labelRg 				   	 = null;
	private JLabel labelUf 				   	 = null;
	private JLabel labelOrgoExpeditor 		 = null;
	private JLabel labelNacionalidade 	   	 = null;
	private JLabel labelNaturalidade 		 = null;
	private JLabel labelDataDeNascimento 	 = null;
	private JLabel labelSexo 				 = null;
	private JLabel labelCtps 				 = null;
	private JLabel labelDataDeAdmissao 	     = null;
	private JLabel labelCargo 			     = null;
	private JLabel labelCep  				 = null;
	private JLabel labelLogradouro 		   	 = null;
	private JLabel labelNumero 			   	 = null;
	private JLabel labelBairro 			   	 = null;
	private JLabel labelComplemento 		 = null;
	private JLabel labelCidade 			   	 = null;
	private JLabel labelUfEndereco 			 = null;
	private JLabel labelTelefone 			 = null;
	private JLabel labelSalario 			 = null;
	private JLabel labelSetor 			     = null;
	private JLabel labelNomeDeUsuario 		 = null;
	private JLabel labelSenha 			   	 = null;
	private JLabel labelEndereo 			 = null;
	private JLabel labelDadosPessoais 	   	 = null;
	private JLabel labelDadosDoCargo 		 = null;
	private JLabel labelEmail		 		 = null;
	private JLabel lblRS1		 			= null;
	private JTextField textFieldNomeUsuario  = null;
	private JTextField textFieldCtps 		 = null;
	private JPasswordField passwordFieldSenhaUsuario 			 = null;
	private JFormattedTextField formattedTextFieldCEP		 	 = null;
	private JFormattedTextField formattedTextFieldTelefone		 = null;	
	private JFormattedTextField formattedTextFieldDataNascimento = null;
	private JFormattedTextField formattedTextFieldDataAdmissao 	 = null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldRG		 		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNome		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldCPF		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldLogradouro		= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldBairro		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldComplemento	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNumero		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldCidade		 	= null;	
	private ValidacaoGeralCamposTexto validacaoJTextFieldOrgaoExpeditor	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldEmail		 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNaturalidade	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldNacionalidade  = null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldSalario 	 	= null;
	private ValidacaoGeralCamposTexto validacaoJTextFieldSetor 	 		= null;
	private JComboBox<String> comboBoxEstadoEndereco  = null;
	private JComboBox<String> comboBoxEstadoRG		  = null;
	private JComboBox<String> comboBoxSexo		 	  = null;
	private JComboBox<String> comboBoxCargo		 	  = null;
	private JButton buttonAdicionarCargo;
	private JButton buttonRemoverCargo;
	private JButton buttonAlterarCargo;
	FormataMascaras fm = new FormataMascaras();
	private JSeparator separator;
	private JSeparator separator_1;
	private FisicoTable_F tabela = null;	
	
	
	public VisaoTelaCadastroFuncionario() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1106, 720));
		setMaximumSize(new Dimension(1106, 720));
		add(getTelaPesquisa());
		add(getLabelCadastroDeFuncionrio());
		add(getLabelNome());
		add(getLabelCpf());
		add(getLabelRg());
		add(getLabelUf());
		add(getLabelOrgoExpeditor());
		add(getLabelNacionalidade());
		add(getLabelNaturalidade());
		add(getLabelDataDeNascimento());
		add(getLabelSexo());
		add(getLabelCtps());
		add(getLabelDataDeAdmissao());
		add(getLabelCargo());
		add(getLabelCep());
		add(getLabelLogradouro());
		add(getLabelNumero());
		add(getLabelBairro());
		add(getLabelComplemento());
		add(getLabelCidade());
		add(getLabelUfEndereco());
		add(getLabelTelefone());
		add(getLabelSalario());
		add(getLabelSetor());
		add(getLabelNomeDeUsuario());
		add(getLabelSenha());
		add(getLabelEndereo());
		add(getLabelDadosPessoais());
		add(getLabelDadosDoCargo());
		add(getLabelEmail());
		add(getLblRS1());
		add(getTextFieldNomeUsuario());
		add(getTextFieldCtps());
		add(getPasswordFieldSenhaUsuario());
		add(getFormattedTextFieldCEP());
		add(getFormattedTextFieldTelefone());
		add(getFormattedTextFieldDataNascimento());
		add(getFormattedTextFieldDataAdmissao());
		add(getFormattedTextFieldCPF());
		add(getValidacaoJTextFieldNome());
		add(getValidacaoJTextFieldNumero());
		add(getValidacaoJTextFieldCidade());
		add(getValidacaoJTextFieldRG());
		add(getValidacaoJTextFieldLogradouro());
		add(getValidacaoJTextFieldBairro());
		add(getValidacaoJTextFieldComplemento());
		add(getValidacaoTextFieldEmail());
		add(getValidacaoJTextFieldNacionalidade());
		add(getValidacaoJTextFieldNaturalidade());
		add(getValidacaoJTextFieldOrgaoExpeditor());
		add(getValidacaoTextFieldEmail());
		add(getValidacaoTextFieldSalario());
		add(getValidacaoTextFieldSetor());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxEstadoRG());	
		add(getComboBoxCargo());
		add(getComboBoxSexo());
		add(getButtonAdicionarCargo());
		add(getButtonRemoverCargo());
		add(getButtonAlterarCargo());
		add(getSeparator());
		add(getSeparator_1());	
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
			telaPesquisa.getComboBoxTipoPesquisa().removeItem("CNPJ");
			telaPesquisa.getComboBoxTipoPesquisa().removeItem("Razão Social");
			telaPesquisa.getComboBoxTipoPesquisa().setLocation(109, 38);
			telaPesquisa.getTextFieldEntradaDado().setLocation(320, 38);
			telaPesquisa.getButtonBuscar().setLocation(839, 38);
			telaPesquisa.getSeparatorBotoes().setSize(1105, 48);
			telaPesquisa.getSeparatorBotoes().setLocation(0, 308);
			telaPesquisa.getDadosJScrollPane().setBounds(48, 89, 987, 208);
			telaPesquisa.getSeparatorPesquisa().setBounds(0, 74, 1105, 20);
			telaPesquisa.getJTableDados().setModel(getTableModel());
			telaPesquisa.setBounds(0,334, 1105, 357);
		}
		return telaPesquisa;
	}
	
	public FisicoTable_F getTableModel() {
		if(tabela==null) {
			tabela = new FisicoTable_F();
		}
		return tabela;
	}

	public JLabel getLabelCadastroDeFuncionrio() {
		if (labelCadastroDeFuncionrio == null) {
			labelCadastroDeFuncionrio = new JLabel(" Cadastro de Funcion\u00E1rio");
			labelCadastroDeFuncionrio.setBorder(new LineBorder(Color.BLACK));
			labelCadastroDeFuncionrio.setFont(new Font("Arial", Font.BOLD, 22));
			labelCadastroDeFuncionrio.setBounds(0, 0, 1105, 26);
		}
		return labelCadastroDeFuncionrio;
	}
	public JLabel getLabelNome() {
		if (labelNome == null) {
			labelNome = new JLabel("Nome:*");
			labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNome.setBounds(10, 50, 104, 20);
		}
		return labelNome;
	}
	public JLabel getLabelCpf() {
		if (labelCpf == null) {
			labelCpf = new JLabel("CPF:*");
			labelCpf.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCpf.setBounds(439, 50, 46, 20);
		}
		return labelCpf;
	}
	public JLabel getLabelRg() {
		if (labelRg == null) {
			labelRg = new JLabel("RG:*");
			labelRg.setFont(new Font("Arial", Font.PLAIN, 16));
			labelRg.setBounds(595, 50, 46, 20);
		}
		return labelRg;
	}
	public JLabel getLabelUf() {
		if (labelUf == null) {
			labelUf = new JLabel("UF:*");
			labelUf.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUf.setBounds(733, 50, 46, 20);
		}
		return labelUf;
	}
	public JLabel getLabelOrgoExpeditor() {
		if (labelOrgoExpeditor == null) {
			labelOrgoExpeditor = new JLabel("\u00D3rg\u00E3o Expeditor:*");
			labelOrgoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelOrgoExpeditor.setBounds(858, 50, 187, 20);
		}
		return labelOrgoExpeditor;
	}
	public JLabel getLabelNacionalidade() {
		if (labelNacionalidade == null) {
			labelNacionalidade = new JLabel("Nacionalidade:*");
			labelNacionalidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNacionalidade.setBounds(10, 92, 131, 20);
		}
		return labelNacionalidade;
	}
	public JLabel getLabelNaturalidade() {
		if (labelNaturalidade == null) {
			labelNaturalidade = new JLabel("Naturalidade:*");
			labelNaturalidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNaturalidade.setBounds(197, 92, 175, 20);
		}
		return labelNaturalidade;
	}
	public JLabel getLabelDataDeNascimento() {
		if (labelDataDeNascimento == null) {
			labelDataDeNascimento = new JLabel("Data de nascimento:*");
			labelDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelDataDeNascimento.setBounds(382, 92, 167, 20);
		}
		return labelDataDeNascimento;
	}
	public JLabel getLabelSexo() {
		if (labelSexo == null) {
			labelSexo = new JLabel("Sexo:*");
			labelSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSexo.setBounds(539, 92, 46, 20);
		}
		return labelSexo;
	}
	public JLabel getLabelCtps() {
		if (labelCtps == null) {
			labelCtps = new JLabel("CTPS:*");
			labelCtps.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCtps.setBounds(10, 164, 104, 20);
		}
		return labelCtps;
	}
	public JLabel getLabelDataDeAdmissao() {
		if (labelDataDeAdmissao == null) {
			labelDataDeAdmissao = new JLabel("Data de admiss\u00E3o:*");
			labelDataDeAdmissao.setFont(new Font("Arial", Font.PLAIN, 16));
			labelDataDeAdmissao.setBounds(307, 164, 175, 20);
		}
		return labelDataDeAdmissao;
	}
	public JLabel getLabelCargo() {
		if (labelCargo == null) {
			labelCargo = new JLabel("Cargo:*");
			labelCargo.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCargo.setBounds(457, 164, 104, 20);
		}
		return labelCargo;
	}
	public JLabel getLabelCep() {
		if (labelCep == null) {
			labelCep = new JLabel("CEP:*");
			labelCep.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCep.setBounds(10, 280, 104, 20);
		}
		return labelCep;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBounds(114, 280, 239, 20);
		}
		return labelLogradouro;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00FAmero:*");
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBounds(551, 280, 104, 20);
		}
		return labelNumero;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBounds(619, 280, 78, 20);
		}
		return labelBairro;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBounds(331, 280, 211, 20);
		}
		return labelComplemento;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBounds(774, 280, 104, 20);
		}
		return labelCidade;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBounds(991, 280, 57, 20);
		}
		return labelUfEndereco;
	}
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Telefone:*");
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(648, 92, 133, 20);
		}
		return labelTelefone;
	}
	public JLabel getLabelSalario() {
		if (labelSalario == null) {
			labelSalario = new JLabel("Sal\u00E1rio:*");
			labelSalario.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSalario.setBounds(10, 210, 131, 20);
		}
		return labelSalario;
	}
	public JLabel getLabelSetor() {
		if (labelSetor == null) {
			labelSetor = new JLabel("Setor:*");
			labelSetor.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSetor.setBounds(750, 163, 149, 20);
		}
		return labelSetor;
	}
	public JLabel getLabelNomeDeUsuario() {
		if (labelNomeDeUsuario == null) {
			labelNomeDeUsuario = new JLabel("Nome de usu\u00E1rio:*");
			labelNomeDeUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNomeDeUsuario.setBounds(200, 208, 131, 20);
		}
		return labelNomeDeUsuario;
	}
	public JLabel getLabelSenha() {
		if (labelSenha == null) {
			labelSenha = new JLabel("Senha:*");
			labelSenha.setFont(new Font("Arial", Font.PLAIN, 16));
			labelSenha.setBounds(513, 210, 67, 20);
		}
		return labelSenha;
	}
	public JLabel getLabelEndereo() {
		if (labelEndereo == null) {
			labelEndereo = new JLabel("  Endere\u00E7o");
			labelEndereo.setFont(new Font("Arial", Font.BOLD, 20));
			labelEndereo.setBounds(0, 255, 996, 25);
		}
		return labelEndereo;
	}
	public JLabel getLabelDadosPessoais() {
		if (labelDadosPessoais == null) {
			labelDadosPessoais = new JLabel("  Dados Pessoais");
			labelDadosPessoais.setFont(new Font("Arial", Font.BOLD, 20));
			labelDadosPessoais.setBounds(0, 25, 415, 25);
		}
		return labelDadosPessoais;
	}
	public JLabel getLabelDadosDoCargo() {
		if (labelDadosDoCargo == null) {
			labelDadosDoCargo = new JLabel("  Dados do Cargo");
			labelDadosDoCargo.setFont(new Font("Arial", Font.BOLD, 20));
			labelDadosDoCargo.setBounds(0, 138, 1058, 25);
		}
		return labelDadosDoCargo;
	}
	public JLabel getLabelEmail() {
		if (labelEmail == null) {
			labelEmail = new JLabel("Email:*");
			labelEmail.setBackground(Color.WHITE);
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			labelEmail.setBounds(791, 92, 58, 20);
		}
		return labelEmail;
	}
	private JLabel getLblRS1() {
		if (lblRS1 == null) {
			lblRS1 = new JLabel("R$");
			lblRS1.setFont(new Font("Arial", Font.PLAIN, 16));
			lblRS1.setBounds(10, 227, 31, 20);
		}
		return lblRS1;
	}
	public JTextField getTextFieldNomeUsuario() {
		if(textFieldNomeUsuario == null) {
			textFieldNomeUsuario = new JTextField();
			textFieldNomeUsuario.setSize(249, 20);
			textFieldNomeUsuario.setLocation(200, 227);
		}
		return textFieldNomeUsuario;
	}

	public JTextField getTextFieldCtps() {
		if(textFieldCtps == null) {
			textFieldCtps = new JTextField();
			textFieldCtps.setSize(285, 20);
			textFieldCtps.setLocation(10, 182);
		}
		return textFieldCtps;
	}
	
	public JPasswordField getPasswordFieldSenhaUsuario() {
		if(passwordFieldSenhaUsuario == null) {
			passwordFieldSenhaUsuario = new JPasswordField();
			passwordFieldSenhaUsuario.setSize(254, 20);
			passwordFieldSenhaUsuario.setLocation(513, 229);
		}
		return passwordFieldSenhaUsuario;
	}

	public JFormattedTextField getFormattedTextFieldCEP() {
		if (formattedTextFieldCEP == null) {
			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCEP.setBackground(Color.WHITE);
			formattedTextFieldCEP.setForeground(Color.BLACK);
			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCEP.setBounds(10, 302, 99, 20);
		}
		return formattedTextFieldCEP;
	}
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(648, 113, 131, 20);
		}
		return formattedTextFieldTelefone;
	}
	public JFormattedTextField getFormattedTextFieldDataNascimento() {
		if (formattedTextFieldDataNascimento == null) {
			formattedTextFieldDataNascimento = new JFormattedTextField(fm.getData());
			formattedTextFieldDataNascimento.setBackground(Color.WHITE);
			formattedTextFieldDataNascimento.setForeground(Color.BLACK);
			formattedTextFieldDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldDataNascimento.setBounds(382, 113, 104, 20);
		}
		return formattedTextFieldDataNascimento;
	}
	public JFormattedTextField getFormattedTextFieldDataAdmissao() {
		if (formattedTextFieldDataAdmissao == null) {
			formattedTextFieldDataAdmissao = new JFormattedTextField(fm.getData());
			formattedTextFieldDataAdmissao.setBackground(Color.WHITE);
			formattedTextFieldDataAdmissao.setForeground(Color.BLACK);
			formattedTextFieldDataAdmissao.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldDataAdmissao.setBounds(307, 182, 125, 20);
		}
		return formattedTextFieldDataAdmissao;
	}
	public ValidacaoGeralCamposTexto getFormattedTextFieldCPF() {
		if (validacaoJTextFieldCPF == null) {
			validacaoJTextFieldCPF = new ValidacaoGeralCamposTexto("3");
			validacaoJTextFieldCPF.setBackground(Color.WHITE);
			validacaoJTextFieldCPF.setForeground(Color.BLACK);
			validacaoJTextFieldCPF.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldCPF.setBounds(439, 69, 133, 20);
		}
		return validacaoJTextFieldCPF;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNome() {//não precisa
		if (validacaoJTextFieldNome == null) {
			validacaoJTextFieldNome = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldNome.setBackground(Color.WHITE);
			validacaoJTextFieldNome.setForeground(Color.BLACK);
			validacaoJTextFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldNome.setBounds(10, 69, 412, 20);
		}
		return validacaoJTextFieldNome;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNumero() {
		if (validacaoJTextFieldNumero == null) {
			validacaoJTextFieldNumero = new ValidacaoGeralCamposTexto("8");
			validacaoJTextFieldNumero.setBackground(Color.WHITE);
			validacaoJTextFieldNumero.setForeground(Color.BLACK);
			validacaoJTextFieldNumero.setFont(new Font("Arial", Font.PLAIN, 16));

			validacaoJTextFieldNumero.setBounds(549, 302, 58, 21);
		}
		return validacaoJTextFieldNumero;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldCidade() {
		if (validacaoJTextFieldCidade == null) {
			validacaoJTextFieldCidade = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldCidade.setBackground(Color.WHITE);
			validacaoJTextFieldCidade.setForeground(Color.BLACK);
			validacaoJTextFieldCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldCidade.setBounds(774, 302, 207, 20);
		}
		return validacaoJTextFieldCidade;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoTextFieldEmail() {
		if (validacaoJTextFieldEmail == null) {
			validacaoJTextFieldEmail = new ValidacaoGeralCamposTexto("9");
			validacaoJTextFieldEmail.setBackground(Color.WHITE);
			validacaoJTextFieldEmail.setForeground(Color.BLACK);
			validacaoJTextFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldEmail.setBounds(791, 114, 290, 20);
			validacaoJTextFieldEmail.setColumns(10);
		}
		return validacaoJTextFieldEmail;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldRG() {
		if (validacaoJTextFieldRG == null) {
			validacaoJTextFieldRG = new ValidacaoGeralCamposTexto("2");
			validacaoJTextFieldRG.setBackground(Color.WHITE);
			validacaoJTextFieldRG.setForeground(Color.BLACK);
			validacaoJTextFieldRG.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldRG.setBounds(595, 69, 133, 20);
		}
		return validacaoJTextFieldRG;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldLogradouro() {
		if (validacaoJTextFieldLogradouro == null) {
			validacaoJTextFieldLogradouro = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldLogradouro.setBackground(Color.WHITE);
			validacaoJTextFieldLogradouro.setForeground(Color.BLACK);
			validacaoJTextFieldLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldLogradouro.setBounds(114, 302, 211, 20);
		}
		return validacaoJTextFieldLogradouro;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldBairro() {
		if (validacaoJTextFieldBairro == null) {
			validacaoJTextFieldBairro = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldBairro.setBackground(Color.WHITE);
			validacaoJTextFieldBairro.setForeground(Color.BLACK);
			validacaoJTextFieldBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldBairro.setBounds(619, 302, 149, 21);
		}
		return validacaoJTextFieldBairro;
	}
	
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldComplemento() {
		if (validacaoJTextFieldComplemento == null) {
			validacaoJTextFieldComplemento = new ValidacaoGeralCamposTexto("7");
			validacaoJTextFieldComplemento.setBackground(Color.WHITE);
			validacaoJTextFieldComplemento.setForeground(Color.BLACK);
			validacaoJTextFieldComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldComplemento.setBounds(331, 302, 211, 21);
		}
		return validacaoJTextFieldComplemento;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldOrgaoExpeditor() {
		if (validacaoJTextFieldOrgaoExpeditor == null) {
			validacaoJTextFieldOrgaoExpeditor = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldOrgaoExpeditor.setForeground(Color.BLACK);		
			validacaoJTextFieldOrgaoExpeditor.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldOrgaoExpeditor.setBackground(Color.WHITE);
			validacaoJTextFieldOrgaoExpeditor.setBounds(858, 69, 187, 20);
		}
		return validacaoJTextFieldOrgaoExpeditor;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNaturalidade() {
		if (validacaoJTextFieldNaturalidade == null) {
			validacaoJTextFieldNaturalidade = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldNaturalidade.setForeground(Color.BLACK);		
			validacaoJTextFieldNaturalidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldNaturalidade.setBackground(Color.WHITE);
			validacaoJTextFieldNaturalidade.setBounds(197, 113, 175, 20);
		}
		return validacaoJTextFieldNaturalidade;
	}
	public ValidacaoGeralCamposTexto getValidacaoJTextFieldNacionalidade() {
		if (validacaoJTextFieldNacionalidade == null) {
			validacaoJTextFieldNacionalidade = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldNacionalidade.setForeground(Color.BLACK);		
			validacaoJTextFieldNacionalidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoJTextFieldNacionalidade.setBackground(Color.WHITE);
			validacaoJTextFieldNacionalidade.setBounds(10, 113, 174, 20);
		}
		return validacaoJTextFieldNacionalidade;
	}
	public ValidacaoGeralCamposTexto getValidacaoTextFieldSalario() {
		if(validacaoJTextFieldSalario == null) {
			validacaoJTextFieldSalario = new ValidacaoGeralCamposTexto("10");
			validacaoJTextFieldSalario.setSize(106, 20);
			validacaoJTextFieldSalario.setLocation(35, 229);
		}
		return validacaoJTextFieldSalario;
	}
	public ValidacaoGeralCamposTexto getValidacaoTextFieldSetor() {
		if(validacaoJTextFieldSetor == null) {
			validacaoJTextFieldSetor = new ValidacaoGeralCamposTexto("1");
			validacaoJTextFieldSetor.setSize(301, 20);
			validacaoJTextFieldSetor.setLocation(750, 182);
		}
		return validacaoJTextFieldSetor;
	}
	public JComboBox<String> getComboBoxEstadoEndereco() {
		if(comboBoxEstadoEndereco == null) {
			comboBoxEstadoEndereco = new JComboBox<String>();
			comboBoxEstadoEndereco.setForeground(Color.BLACK);
			comboBoxEstadoEndereco.setBackground(Color.WHITE);
			comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoEndereco.setBounds(991, 299, 104, 20);
		}
		return comboBoxEstadoEndereco;
	}
	public JComboBox<String> getComboBoxEstadoRG() {
		if (comboBoxEstadoRG == null) {
			comboBoxEstadoRG = new JComboBox<String>();
			comboBoxEstadoRG.setForeground(Color.BLACK);
			comboBoxEstadoRG.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", 
					"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxEstadoRG.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEstadoRG.setBackground(Color.WHITE);
			comboBoxEstadoRG.setBounds(733, 69, 115, 20);
		}
		return comboBoxEstadoRG;
	}
	public JComboBox<String> getComboBoxSexo() {
		if (comboBoxSexo == null) {
			comboBoxSexo = new JComboBox<String>();
			//comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Feminino", "Masculino"}));
			comboBoxSexo.setBackground(Color.WHITE);
			comboBoxSexo.setForeground(Color.BLACK);
			comboBoxSexo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxSexo.addItem("Selecione");
			comboBoxSexo.addItem("Feminino");
			comboBoxSexo.addItem("Masculino");
			comboBoxSexo.setBounds(539, 113, 99, 20);
		}
		return comboBoxSexo;
	}
	public JComboBox<String> getComboBoxCargo() {
		if (comboBoxCargo == null) {
			comboBoxCargo = new JComboBox<String>();
			comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			comboBoxCargo.setBackground(Color.WHITE);
			comboBoxCargo.setForeground(Color.BLACK);
			comboBoxCargo.setFont(new Font("Arial", Font.PLAIN, 16));
			//comboBoxCargo.addItem("Selecione");
			comboBoxCargo.setBounds(457, 182, 115, 20);
		}
		return comboBoxCargo;
	}
	
	public JButton getButtonAdicionarCargo() {
		if (buttonAdicionarCargo == null) {
			buttonAdicionarCargo = new JButton("+");
			buttonAdicionarCargo.setBackground(Color.WHITE);
			buttonAdicionarCargo.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonAdicionarCargo.setBounds(582, 182, 46, 23);
		}
		return buttonAdicionarCargo;
	}
	public JButton getButtonRemoverCargo() {
		if (buttonRemoverCargo == null) {
			buttonRemoverCargo = new JButton("-");
			buttonRemoverCargo.setBackground(Color.WHITE);
			buttonRemoverCargo.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonRemoverCargo.setBounds(638, 182, 46, 23);
		}
		return buttonRemoverCargo;
	}
	public JButton getButtonAlterarCargo() {
		if (buttonAlterarCargo == null) {
			buttonAlterarCargo = new JButton("A");
			buttonAlterarCargo.setBackground(Color.WHITE);
			buttonAlterarCargo.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonAlterarCargo.setBounds(694, 182, 46, 23);
		}
		return buttonAlterarCargo;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 138, 1105, 2);
		}
		return separator;
	}
	public JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(0, 255, 1105, 2);
		}
		return separator_1;
	}
}
