package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTable;

public class VisaoPdvBuscaProduto extends JPanel{
	private JLabel lblTitulo;
	private JLabel lblEscSair;
	private JLabel lblFConfirmar;
	private JComboBox comboBoxTipo;
	private JTextField textFieldNome;
	private JButton btnPesquisar;
	private JTable table;
	private JScrollPane scrollPane;
	
	public VisaoPdvBuscaProduto() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTitulo());
		add(getComboBoxTipo());
		add(getTextFieldNome());
		add(getBtnPesquisar());
		add(getScrollPane());
		add(getLblEscSair());
		add(getLblFConfirmar());
		
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Busca do Produto");
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 763, 30);
		}
		return lblTitulo;
	}
	public JLabel getLblEscSair() {
		if (lblEscSair == null) {
			lblEscSair = new JLabel("Esc - Sair");
			lblEscSair.setForeground(Color.BLACK);
			lblEscSair.setFont(new Font("Arial", Font.PLAIN, 20));
			lblEscSair.setBounds(643, 462, 110, 25);
		}
		return lblEscSair;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar");
			lblFConfirmar.setForeground(Color.BLACK);
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFConfirmar.setBounds(474, 462, 140, 25);
		}
		return lblFConfirmar;
	}
	public JComboBox getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox();
			comboBoxTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipo.setForeground(Color.BLACK);
			comboBoxTipo.setBackground(Color.WHITE);
			comboBoxTipo.setBounds(10, 56, 128, 23);
		}
		return comboBoxTipo;
	}
	public JTextField getTextFieldNome() {
		if (textFieldNome == null) {
			textFieldNome = new JTextField();
			textFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNome.setForeground(Color.BLACK);
			textFieldNome.setBackground(Color.WHITE);
			textFieldNome.setBounds(158, 56, 460, 23);
			textFieldNome.setColumns(10);
		}
		return textFieldNome;
	}
	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnPesquisar.setForeground(Color.BLACK);
			btnPesquisar.setBackground(Color.WHITE);
			btnPesquisar.setBounds(628, 55, 125, 23);
		}
		return btnPesquisar;
	}
	
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Arial", Font.PLAIN, 16));
		}
		return table;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(20, 99, 720, 298);
			scrollPane.add(getTable());
		}
		return scrollPane;
	}
	
}
