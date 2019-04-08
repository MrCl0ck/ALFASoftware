package visao;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import modelo.tableModel.ClienteFisicoTable;
import modelo.tableModel.ClienteJuridicoTable;

public class VisaoTelaPesquisa extends JPanel {
	private JLabel labelPesquisa;
	private JComboBox<String> comboBoxTipoPesquisa;
	private JTextField textFieldEntradaDado;
	private JButton buttonBuscar;
	private JButton buttonIncluir;
	private JButton buttonExcluir;
	private JButton buttonAlterar;
	private JButton buttonCancelar;
	private JButton buttonConfirmar;
	private JButton buttonFechar;
	private JSeparator separatorPesquisa;
	private JSeparator separatorBotoes;
	private JTable jtableDadosCliente;
	private JScrollPane dadosClienteJScrollPane;
	
	public VisaoTelaPesquisa() {
		setLayout(null);
		setBorder(new LineBorder(Color.BLACK));
		setBackground(new Color(252, 246, 229));
		setSize(1016, 356);
		setLocation(0, 385);
		setMinimumSize(new Dimension(1055, 770));
		setMaximumSize(new Dimension(1055, 770));
		add(getLabelPesquisa());
		add(getComboBoxTipoPesquisa());
		add(getTextFieldEntradaDado());
		add(getButtonBuscar());
		add(getButtonIncluir());
		add(getButtonExcluir());
		add(getButtonAlterar());
		add(getButtonCancelar());
		add(getButtonConfirmar());
		add(getButtonFechar());
		add(getSeparatorPesquisa());
		add(getSeparatorBotoes());
		add(getDadosClienteJScrollPane());
	}
	public JLabel getLabelPesquisa() {
		if (labelPesquisa == null) {
			labelPesquisa = new JLabel("Pesquisa");
			labelPesquisa.setFont(new Font("Arial", Font.BOLD, 19));
			labelPesquisa.setBounds(10, 0, 99, 32);
		}
		return labelPesquisa;
	}
	public JComboBox<String> getComboBoxTipoPesquisa() {
		if (comboBoxTipoPesquisa == null) {
			comboBoxTipoPesquisa = new JComboBox<String>();
			comboBoxTipoPesquisa.setForeground(Color.BLACK);
			comboBoxTipoPesquisa.setBackground(Color.WHITE);
			comboBoxTipoPesquisa.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoPesquisa.addItem("Selecione");
			comboBoxTipoPesquisa.addItem("Nome");
			comboBoxTipoPesquisa.addItem("Razão Social");
			comboBoxTipoPesquisa.addItem("CNPJ");//ADICIONADOS NO GET TELAPESQUISA DE CADA CADASTRO DE CLIENTE
			comboBoxTipoPesquisa.addItem("CPF");
			comboBoxTipoPesquisa.setBounds(59, 43, 163, 24);
		}
		return comboBoxTipoPesquisa;
	}
	public JTextField getTextFieldEntradaDado() {
		if (textFieldEntradaDado == null) {
			textFieldEntradaDado = new JTextField();
			textFieldEntradaDado.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldEntradaDado.setBounds(243, 41, 511, 24);
			textFieldEntradaDado.setColumns(10);
		}
		return textFieldEntradaDado;
	}
	public JButton getButtonBuscar() {
		if (buttonBuscar == null) {
			buttonBuscar = new JButton("Buscar");
			buttonBuscar.setForeground(Color.BLACK);
			buttonBuscar.setBackground(Color.WHITE);
			buttonBuscar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonBuscar.setBounds(850, 41, 135, 24);
		}
		return buttonBuscar;
	}
	public JButton getButtonIncluir() {
		if (buttonIncluir == null) {
			buttonIncluir = new JButton("Incluir");
			buttonIncluir.setForeground(Color.BLACK);
			buttonIncluir.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonIncluir.setBackground(Color.WHITE);
			buttonIncluir.setBounds(85, 321, 121, 24);
		}
		return buttonIncluir;
	}
	public JButton getButtonExcluir() {
		if (buttonExcluir == null) {
			buttonExcluir = new JButton("Excluir");
			buttonExcluir.setForeground(Color.BLACK);
			buttonExcluir.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonExcluir.setBackground(Color.WHITE);
			buttonExcluir.setBounds(233, 321, 121, 24);
		}
		return buttonExcluir;
	}
	public JButton getButtonAlterar() {
		if (buttonAlterar == null) {
			buttonAlterar = new JButton("Alterar");
			buttonAlterar.setForeground(Color.BLACK);
			buttonAlterar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonAlterar.setBackground(Color.WHITE);
			buttonAlterar.setBounds(388, 321, 121, 24);
		}
		return buttonAlterar;
	}
	public JButton getButtonCancelar() {
		if (buttonCancelar == null) {
			buttonCancelar = new JButton("Cancelar");
			buttonCancelar.setForeground(Color.BLACK);
			buttonCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonCancelar.setBackground(Color.WHITE);
			buttonCancelar.setBounds(539, 321, 121, 24);
		}
		return buttonCancelar;
	}
	public JButton getButtonConfirmar() {
		if (buttonConfirmar == null) {
			buttonConfirmar = new JButton("Confirmar");
			buttonConfirmar.setForeground(Color.BLACK);
			buttonConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonConfirmar.setBackground(Color.WHITE);
			buttonConfirmar.setBounds(683, 321, 121, 24);
		}
		return buttonConfirmar;
	}
	public JButton getButtonFechar() {
		if (buttonFechar == null) {
			buttonFechar = new JButton("Fechar");
			buttonFechar.setForeground(Color.BLACK);
			buttonFechar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonFechar.setBackground(Color.WHITE);
			buttonFechar.setBounds(832, 321, 121, 24);
		}
		return buttonFechar;
	}
	public JSeparator getSeparatorPesquisa() {
		if (separatorPesquisa == null) {
			separatorPesquisa = new JSeparator();
			separatorPesquisa.setBackground(Color.WHITE);
			separatorPesquisa.setForeground(Color.BLACK);
			separatorPesquisa.setBounds(0, 74, 804, 20);
		}
		return separatorPesquisa;
	}
	public JSeparator getSeparatorBotoes() {
		if (separatorBotoes == null) {
			separatorBotoes = new JSeparator();
			separatorBotoes.setForeground(Color.BLACK);
			separatorBotoes.setBackground(Color.WHITE);
			separatorBotoes.setBounds(0, 308, 1053, 48);
		}
		return separatorBotoes;
	}
	
	public JTable getJTableDadosCliente() {
		if (jtableDadosCliente == null) {
			jtableDadosCliente = new JTable();
			jtableDadosCliente.setBorder(new LineBorder(new Color(0, 0, 0)));
			jtableDadosCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			jtableDadosCliente.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"CPF/CNPJ", "Nome/Razão Social", "Endere\u00E7o", "Telefone"
				}
			));
			jtableDadosCliente.getColumnModel().getColumn(0).setPreferredWidth(128);
			jtableDadosCliente.getColumnModel().getColumn(1).setPreferredWidth(231);
			jtableDadosCliente.getColumnModel().getColumn(2).setPreferredWidth(241);
			jtableDadosCliente.getColumnModel().getColumn(3).setPreferredWidth(124);
			jtableDadosCliente.setBounds(10, 89, 776, 208);
		}
		return jtableDadosCliente;
	}
	
	public JScrollPane getDadosClienteJScrollPane() {
		if(dadosClienteJScrollPane == null) {
			dadosClienteJScrollPane = new JScrollPane(getJTableDadosCliente());
			dadosClienteJScrollPane.setBounds(10, 89, 776, 208);
		}
		return dadosClienteJScrollPane;
	}	
}
