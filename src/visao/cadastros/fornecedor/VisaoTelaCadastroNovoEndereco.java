package visao.cadastros.fornecedor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;

public class VisaoTelaCadastroNovoEndereco extends JPanel {

	private JLabel labelEndereco 	= null;
	private JLabel labelCep		 	= null;
	private JLabel labelLogradouro 	= null;
	private JLabel labelBairro 		= null;
	private JLabel labelCidade 		= null;
	private JLabel labelNumero		= null;
	private JLabel labelComplemento = null;
	private JLabel labelUfEndereco 	= null;
	private JComboBox<String> 		comboBoxUfEndereco 		= null;
	private JFormattedTextField 	formattedTextFieldCep 	= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoLogradouro 	= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoBairro 		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoCidade 		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoNumero 		= null;
	private ValidacaoGeralCamposTexto validacaoGeralCamposTextoComplemento 	= null;
	private JButton buttonVoltar 	= null;
	private JButton buttonConfirmar = null;
	FormataMascaras fm = new FormataMascaras();
	
	public VisaoTelaCadastroNovoEndereco() {
		setLayout(null);
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 720));
		setMaximumSize(new Dimension(1055, 720));
		add(getLabelEndereco());
		add(getLabelCep());
		add(getLabelLogradouro());
		add(getLabelBairro());
		add(getLabelCidade());
		add(getLabelNumero());
		add(getLabelComplemento());
		add(getLabelUfEndereco());
		add(getComboBoxUfEndereco());
		add(getValidacaoGeralCamposTextoLogradouro());
		add(getValidacaoGeralCamposTextoBairro());
		add(getValidacaoGeralCamposTextoCidade());
		add(getValidacaoGeralCamposTextoNumero());
		add(getValidacaoGeralCamposTextoComplemento());
		add(getFormattedTextFieldCep());
		add(getButtonVoltar());
		add(getButtonConfirmar());
	}
	public JLabel getLabelEndereco() {
		if (labelEndereco == null) {
			labelEndereco = new JLabel("Endere\u00E7o Secundário");
			labelEndereco.setFont(new Font("Arial", Font.BOLD, 22));
			labelEndereco.setBounds(10, 11, 411, 30);
		}
		return labelEndereco;
	}
	public JLabel getLabelCep() {
		if (labelCep == null) {
			labelCep = new JLabel("CEP:*");
			labelCep.setForeground(Color.BLACK);
			labelCep.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCep.setBounds(10, 81, 46, 20);
		}
		return labelCep;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoLogradouro() {
		if (validacaoGeralCamposTextoLogradouro == null) {
			validacaoGeralCamposTextoLogradouro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoLogradouro.setForeground(Color.BLACK);
			validacaoGeralCamposTextoLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoLogradouro.setBackground(Color.WHITE);
			validacaoGeralCamposTextoLogradouro.setBounds(161, 100, 340, 20);
		}
		return validacaoGeralCamposTextoLogradouro;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setBounds(161, 81, 93, 20);
		}
		return labelLogradouro;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setBounds(10, 182, 93, 20);
		}
		return labelBairro;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoBairro() {
		if (validacaoGeralCamposTextoBairro == null) {
			validacaoGeralCamposTextoBairro = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoBairro.setForeground(Color.BLACK);
			validacaoGeralCamposTextoBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoBairro.setBackground(Color.WHITE);
			validacaoGeralCamposTextoBairro.setBounds(10, 201, 262, 20);
		}
		return validacaoGeralCamposTextoBairro;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoCidade() {
		if (validacaoGeralCamposTextoCidade == null) {
			validacaoGeralCamposTextoCidade = new ValidacaoGeralCamposTexto("1");
			validacaoGeralCamposTextoCidade.setForeground(Color.BLACK);
			validacaoGeralCamposTextoCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoCidade.setBackground(Color.WHITE);
			validacaoGeralCamposTextoCidade.setBounds(328, 201, 191, 20);
		}
		return validacaoGeralCamposTextoCidade;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setBounds(328, 183, 72, 20);
		}
		return labelCidade;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoNumero() {
		if (validacaoGeralCamposTextoNumero == null) {
			validacaoGeralCamposTextoNumero = new ValidacaoGeralCamposTexto("8");
			validacaoGeralCamposTextoNumero.setForeground(Color.BLACK);
			validacaoGeralCamposTextoNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoNumero.setBackground(Color.WHITE);
			validacaoGeralCamposTextoNumero.setBounds(10, 151, 67, 20);
		}
		return validacaoGeralCamposTextoNumero;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setBounds(10, 132, 46, 20);
		}
		return labelNumero;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setBounds(139, 132, 104, 20);
		}
		return labelComplemento;
	}
	public ValidacaoGeralCamposTexto getValidacaoGeralCamposTextoComplemento() {
		if (validacaoGeralCamposTextoComplemento == null) {
			validacaoGeralCamposTextoComplemento = new ValidacaoGeralCamposTexto("7");
			validacaoGeralCamposTextoComplemento.setForeground(Color.BLACK);
			validacaoGeralCamposTextoComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			validacaoGeralCamposTextoComplemento.setBackground(Color.WHITE);
			validacaoGeralCamposTextoComplemento.setBounds(139, 151, 261, 20);
		}
		return validacaoGeralCamposTextoComplemento;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setBounds(561, 182, 46, 20);
		}
		return labelUfEndereco;
	}
	public JComboBox<String> getComboBoxUfEndereco() {
		if (comboBoxUfEndereco == null) {
			comboBoxUfEndereco = new JComboBox<String>();
			comboBoxUfEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", 
					"AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", 
					"PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			comboBoxUfEndereco.setForeground(Color.BLACK);
			comboBoxUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxUfEndereco.setBackground(Color.WHITE);
			comboBoxUfEndereco.setBounds(561, 200, 115, 20);
		}
		return comboBoxUfEndereco;
	}
	public JFormattedTextField getFormattedTextFieldCep() {
		if (formattedTextFieldCep == null) {
			formattedTextFieldCep = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCep.setForeground(Color.BLACK);
			formattedTextFieldCep.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCep.setBackground(Color.WHITE);
			formattedTextFieldCep.setBounds(10, 102, 100, 20);
		}
		return formattedTextFieldCep;
	}
	public JButton getButtonVoltar() {
		if(buttonVoltar == null) {
			buttonVoltar = new JButton("Voltar");
			buttonVoltar.setBackground(Color.WHITE);
			buttonVoltar.setForeground(Color.BLACK);
			buttonVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonVoltar.setSize(104, 27);
			buttonVoltar.setLocation(447, 280);
		}
		return buttonVoltar;
	}
	public JButton getButtonConfirmar() {
		if(buttonConfirmar == null) {
			buttonConfirmar = new JButton("Confirmar");
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setForeground(Color.BLACK);
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonConfirmar.setSize(115, 27);
			buttonConfirmar.setLocation(571, 280);
		}
		return buttonConfirmar;
	}
	

}
