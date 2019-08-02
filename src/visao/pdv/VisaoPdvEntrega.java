package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import modelo.cadastros.validacoes.FormataMascaras;
import modelo.cadastros.validacoes.ValidacaoGeralCamposTexto;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;

public class VisaoPdvEntrega extends JPanel {
	FormataMascaras fm = new FormataMascaras();
	private JLabel labelTitulo;
	private JLabel labelItensNotaFiscal;
	private JLabel labeltensASeremEntregues;
	private JLabel labelNome = null;
	private JLabel labelCEP = null;
	private JLabel labelNumero = null;
	private JLabel labelCidade = null;
	private JLabel labelUfEndereco = null;
	private JLabel labelLogradouro = null;
	private JLabel labelBairro = null;
	private JLabel labelTelefone = null;
	private JLabel labelComplemento = null;
	private JLabel lblDataDaEntrega;
	private JLabel lblEndereoDaEntrega;
	private JLabel lblFCancelar;
	private JLabel lblFConfirmar;
	private JLabel lblEscSair;
	private JFormattedTextField formattedTextFieldCEP		 	 = null;
	private JFormattedTextField formattedTextFieldTelefone		 = null;	
	private JFormattedTextField formattedTextFieldDataEntrega = null;
	private JTextField textFieldNome;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	
	private JComboBox<String> comboBoxEstadoEndereco  = null;
	private JComboBox<String> comboBoxEnderecoEntrega;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JSeparator separator;
	
	public VisaoPdvEntrega() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLabelTitulo());
		add(getLabelItensNotaFiscal());
		add(getLabeltensASeremEntregues());
		add(getLabelNome());
		add(getLabelCEP());
		add(getLabelNumero());
		add(getLabelCidade());
		add(getLabelUfEndereco());
		add(getLabelLogradouro());
		add(getLabelBairro());
		add(getLabelTelefone());
		add(getLabelComplemento());
		add(getLblDataDaEntrega());
		add(getLblEndereoDaEntrega());
		add(getLblFCancelar());
		add(getLblFConfirmar());
		add(getLblEscSair());
		add(getFormattedTextFieldCEP());
		add(getFormattedTextFieldTelefone());
		add(getFormattedTextFieldDataEntrega());
		add(getTextFieldNome());
		add(getTxtNumero());
		add(getTxtComplemento());
		add(getTxtCidade());
		add(getTxtBairro());
		add(getTxtLogradouro());
		add(getComboBoxEstadoEndereco());
		add(getComboBoxEnderecoEntrega());
		add(getButton());
		add(getButton_1());
		add(getButton_2());
		add(getButton_3());
		add(getScrollPane());
		add(getScrollPane_1());
		add(getSeparator());
	}

	public JLabel getLabelTitulo() {
		if (labelTitulo == null) {
			labelTitulo = new JLabel(" Entrega");
			labelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			labelTitulo.setBounds(0, 0, 1055, 30);
		}
		return labelTitulo;
	}
	public JLabel getLabelItensNotaFiscal() {
		if (labelItensNotaFiscal == null) {
			labelItensNotaFiscal = new JLabel("Itens da Nota Fiscal");
			labelItensNotaFiscal.setFont(new Font("Arial", Font.BOLD, 18));
			labelItensNotaFiscal.setBounds(23, 57, 245, 20);
		}
		return labelItensNotaFiscal;
	}
	public JLabel getLabeltensASeremEntregues() {
		if (labeltensASeremEntregues == null) {
			labeltensASeremEntregues = new JLabel("Itens a serem entregues");
			labeltensASeremEntregues.setFont(new Font("Arial", Font.BOLD, 18));
			labeltensASeremEntregues.setBounds(581, 57, 265, 20);
		}
		return labeltensASeremEntregues;
	}
	public JLabel getLabelNome() {
		if (labelNome == null) {
			labelNome = new JLabel("Nome:*");
			labelNome.setBackground(Color.WHITE);
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNome.setBounds(10, 478, 58, 20);
		}
		return labelNome;
	}
	public JLabel getLabelCEP() {
		if (labelCEP == null) {
			labelCEP = new JLabel("CEP:*");
			labelCEP.setBackground(Color.WHITE);
			labelCEP.setForeground(Color.BLACK);
			labelCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCEP.setBounds(10, 526, 46, 20);
		}
		return labelCEP;
	}
	public JLabel getLabelNumero() {
		if (labelNumero == null) {
			labelNumero = new JLabel("N\u00BA:*");
			labelNumero.setBackground(Color.WHITE);
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			labelNumero.setBounds(10, 586, 46, 20);
		}
		return labelNumero;
	}
	public JLabel getLabelCidade() {
		if (labelCidade == null) {
			labelCidade = new JLabel("Cidade:*");
			labelCidade.setBackground(Color.WHITE);
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			labelCidade.setBounds(10, 638, 72, 20);
		}
		return labelCidade;
	}
	public JLabel getLabelUfEndereco() {
		if (labelUfEndereco == null) {
			labelUfEndereco = new JLabel("UF:*");
			labelUfEndereco.setBackground(Color.WHITE);
			labelUfEndereco.setForeground(Color.BLACK);
			labelUfEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			labelUfEndereco.setBounds(510, 638, 46, 20);
		}
		return labelUfEndereco;
	}
	public JLabel getLabelLogradouro() {
		if (labelLogradouro == null) {
			labelLogradouro = new JLabel("Logradouro:*");
			labelLogradouro.setBackground(Color.WHITE);
			labelLogradouro.setForeground(Color.BLACK);
			labelLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelLogradouro.setBounds(312, 526, 93, 20);
		}
		return labelLogradouro;
	}
	public JLabel getLabelBairro() {
		if (labelBairro == null) {
			labelBairro = new JLabel("Bairro:*");
			labelBairro.setBackground(Color.WHITE);
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			labelBairro.setBounds(175, 586, 93, 20);
		}
		return labelBairro;
	}
	public JLabel getLabelTelefone() {
		if (labelTelefone == null) {
			labelTelefone = new JLabel("Tel. Contato:*");
			labelTelefone.setBackground(Color.WHITE);
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			labelTelefone.setBounds(739, 640, 178, 20);
		}
		return labelTelefone;
	}
	public JLabel getLabelComplemento() {
		if (labelComplemento == null) {
			labelComplemento = new JLabel("Complemento:");
			labelComplemento.setBackground(Color.WHITE);
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			labelComplemento.setBounds(592, 588, 111, 20);
		}
		return labelComplemento;
	}
	public JLabel getLblDataDaEntrega() {
		if (lblDataDaEntrega == null) {
			lblDataDaEntrega = new JLabel("Data da Entrega:");
			lblDataDaEntrega.setFont(new Font("Arial", Font.PLAIN, 16));
			lblDataDaEntrega.setBounds(10, 432, 135, 20);
		}
		return lblDataDaEntrega;
	}
	public JLabel getLblEndereoDaEntrega() {
		if (lblEndereoDaEntrega == null) {
			lblEndereoDaEntrega = new JLabel("Endere\u00E7o de Entrega:");
			lblEndereoDaEntrega.setFont(new Font("Arial", Font.PLAIN, 16));
			lblEndereoDaEntrega.setBounds(610, 432, 177, 20);
		}
		return lblEndereoDaEntrega;
	}
	public JLabel getLblFCancelar() {
		if (lblFCancelar == null) {
			lblFCancelar = new JLabel("F4 - Cancelar");
			lblFCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFCancelar.setBounds(579, 689, 115, 20);
		}
		return lblFCancelar;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar");
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFConfirmar.setBounds(703, 689, 115, 20);
		}
		return lblFConfirmar;
	}
	public JLabel getLblEscSair() {
		if (lblEscSair == null) {
			lblEscSair = new JLabel("Esc - Sair");
			lblEscSair.setFont(new Font("Arial", Font.PLAIN, 16));
			lblEscSair.setBounds(830, 689, 115, 20);
		}
		return lblEscSair;
	}
	public JFormattedTextField getFormattedTextFieldTelefone() {
		if (formattedTextFieldTelefone == null) {
			formattedTextFieldTelefone = new JFormattedTextField(fm.getTelefone());
			formattedTextFieldTelefone.setBackground(Color.WHITE);
			formattedTextFieldTelefone.setForeground(Color.BLACK);
			formattedTextFieldTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldTelefone.setBounds(846, 638, 162, 20);
		}
		return formattedTextFieldTelefone;
	}
	public JFormattedTextField getFormattedTextFieldCEP() {
		if (formattedTextFieldCEP == null) {
			formattedTextFieldCEP = new JFormattedTextField(fm.getCEP());
			formattedTextFieldCEP.setBackground(Color.WHITE);
			formattedTextFieldCEP.setForeground(Color.BLACK);
			formattedTextFieldCEP.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldCEP.setBounds(66, 524, 189, 20);
		}
		return formattedTextFieldCEP;
	}
	public JFormattedTextField getFormattedTextFieldDataEntrega() {
		if (formattedTextFieldDataEntrega == null) {
			formattedTextFieldDataEntrega = new JFormattedTextField(fm.getData());
			formattedTextFieldDataEntrega.setBackground(Color.WHITE);
			formattedTextFieldDataEntrega.setForeground(Color.BLACK);
			formattedTextFieldDataEntrega.setFont(new Font("Arial", Font.PLAIN, 16));
			formattedTextFieldDataEntrega.setBounds(143, 432, 207, 20);
		}
		return formattedTextFieldDataEntrega;
	}
	public JTextField getTextFieldNome() {
		if (textFieldNome == null) {
			textFieldNome = new JTextField();
			textFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNome.setBounds(78, 478, 810, 20);
			textFieldNome.setColumns(10);
		}
		return textFieldNome;
	}
	public JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setFont(new Font("Arial", Font.PLAIN, 16));
			txtNumero.setBounds(52, 586, 86, 20);
			txtNumero.setColumns(10);
		}
		return txtNumero;
	}
	public JTextField getTxtComplemento() {
		if (txtComplemento == null) {
			txtComplemento = new JTextField();
			txtComplemento.setFont(new Font("Arial", Font.PLAIN, 16));
			txtComplemento.setBounds(703, 588, 305, 20);
			txtComplemento.setColumns(10);
		}
		return txtComplemento;
	}
	public JTextField getTxtCidade() {
		if (txtCidade == null) {
			txtCidade = new JTextField();
			txtCidade.setFont(new Font("Arial", Font.PLAIN, 16));
			txtCidade.setBounds(90, 640, 357, 20);
			txtCidade.setColumns(10);
		}
		return txtCidade;
	}
	public JTextField getTxtBairro() {
		if (txtBairro == null) {
			txtBairro = new JTextField();
			txtBairro.setFont(new Font("Arial", Font.PLAIN, 16));
			txtBairro.setBounds(241, 588, 315, 20);
			txtBairro.setColumns(10);
		}
		return txtBairro;
	}
	public JTextField getTxtLogradouro() {
		if (txtLogradouro == null) {
			txtLogradouro = new JTextField();
			txtLogradouro.setFont(new Font("Arial", Font.PLAIN, 16));
			txtLogradouro.setBounds(415, 524, 593, 20);
			txtLogradouro.setColumns(10);
		}
		return txtLogradouro;
	}
	public JComboBox<String> getComboBoxEstadoEndereco() {
	if(comboBoxEstadoEndereco == null) {
		comboBoxEstadoEndereco = new JComboBox<String>();
		comboBoxEstadoEndereco.setForeground(Color.BLACK);
		comboBoxEstadoEndereco.setBackground(Color.WHITE);
		comboBoxEstadoEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBoxEstadoEndereco.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "AC", "AL", "AM", "AP", "BA", "CE", 
				"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", 
				"RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		comboBoxEstadoEndereco.setBounds(554, 638, 115, 20);
	}
	return comboBoxEstadoEndereco;
}
	public JComboBox<String> getComboBoxEnderecoEntrega() {
		if (comboBoxEnderecoEntrega == null) {
			comboBoxEnderecoEntrega = new JComboBox();
			comboBoxEnderecoEntrega.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxEnderecoEntrega.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
			comboBoxEnderecoEntrega.setBounds(773, 432, 115, 20);
		}
		return comboBoxEnderecoEntrega;
	}
	public JButton getButton() {
		if (button == null) {
			button = new JButton(">>");
			button.setForeground(Color.BLACK);
			button.setFont(new Font("Arial", Font.PLAIN, 16));
			button.setBackground(Color.WHITE);
			button.setBounds(468, 154, 69, 24);
		}
		return button;
	}
	public JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton(">");
			button_1.setForeground(Color.BLACK);
			button_1.setFont(new Font("Arial", Font.PLAIN, 16));
			button_1.setBackground(Color.WHITE);
			button_1.setBounds(468, 188, 69, 24);
		}
		return button_1;
	}
	public JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("<<");
			button_2.setForeground(Color.BLACK);
			button_2.setFont(new Font("Arial", Font.PLAIN, 16));
			button_2.setBackground(Color.WHITE);
			button_2.setBounds(468, 255, 69, 24);
		}
		return button_2;
	}
	public JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("<");
			button_3.setForeground(Color.BLACK);
			button_3.setFont(new Font("Arial", Font.PLAIN, 16));
			button_3.setBackground(Color.WHITE);
			button_3.setBounds(468, 290, 69, 24);
		}
		return button_3;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(20, 88, 427, 333);
		}
		return scrollPane;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setBackground(Color.WHITE);
			scrollPane_1.setBounds(554, 88, 424, 333);
		}
		return scrollPane_1;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 464, 1293, 20);
		}
		return separator;
	}
}
