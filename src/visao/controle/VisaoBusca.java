package visao.controle;

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

public class VisaoBusca extends JPanel{
	private JLabel lblBuscaDo;
	private JComboBox comboBoxTipo;
	private JTextField textFieldNome;
	private JButton btnPesquisar;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JButton btnFechar;
	private JTable table;
	private JScrollPane scrollPane;
	
	public VisaoBusca() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblBuscaDo());
		add(getComboBoxTipo());
		add(getTextFieldNome());
		add(getBtnPesquisar());
		add(getBtnCancelar());
		add(getBtnConfirmar());
		add(getBtnFechar());
		add(getScrollPane());
		
	}
	public JLabel getLblBuscaDo() {
		if (lblBuscaDo == null) {
			lblBuscaDo = new JLabel(" Busca do");
			lblBuscaDo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblBuscaDo.setFont(new Font("Arial", Font.BOLD, 22));
			lblBuscaDo.setBounds(0, 0, 763, 30);
		}
		return lblBuscaDo;
	}
	public JComboBox getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox();
			comboBoxTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipo.setForeground(Color.BLACK);
			comboBoxTipo.setBackground(Color.WHITE);
			comboBoxTipo.setBounds(10, 56, 128, 20);
		}
		return comboBoxTipo;
	}
	public JTextField getTextFieldNome() {
		if (textFieldNome == null) {
			textFieldNome = new JTextField();
			textFieldNome.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNome.setForeground(Color.BLACK);
			textFieldNome.setBackground(Color.WHITE);
			textFieldNome.setBounds(158, 56, 460, 20);
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
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(345, 417, 121, 24);
		}
		return btnCancelar;
	}
	public JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnConfirmar.setForeground(Color.BLACK);
			btnConfirmar.setBackground(Color.WHITE);
			btnConfirmar.setBounds(476, 417, 121, 24);
		}
		return btnConfirmar;
	}
	public JButton getBtnFechar() {
		if (btnFechar == null) {
			btnFechar = new JButton("Fechar");
			btnFechar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnFechar.setForeground(Color.BLACK);
			btnFechar.setBackground(Color.WHITE);
			btnFechar.setBounds(607, 417, 121, 24);
		}
		return btnFechar;
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
