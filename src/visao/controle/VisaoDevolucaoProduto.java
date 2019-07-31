package visao.controle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;

public class VisaoDevolucaoProduto extends JPanel {
	private JLabel lblDevoluoDeProduto;
	private JLabel lblNotaFiscalN;
	private JLabel lblNDoItem;
	private JLabel lblNewLabelItensNotaFiscal;
	private JLabel lblItensASerem;
	private JTextField textFieldNumeroNota;
	private JTextField textFieldNumeroItem;
	private JButton btnBuscar;
	private JButton btnDevolverTudo;
	private JButton btnDevolverSelecionados;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton btnFechar;
	private JTable tableItensNotaFical;
	private JTable tableItensDevolvidos;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	public VisaoDevolucaoProduto() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblDevoluoDeProduto());
		add(getLblNotaFiscalN());
		add(getLblNDoItem());
		add(getLblNewLabelItensNotaFiscal());
		add(getLblItensASerem());
		add(getTextFieldNumeroNota());
		add(getTextFieldNumeroItem());
		add(getBtnBuscar());
		add(getBtnDevolverTudo());
		add(getBtnDevolverSelecionados());
		add(getButton1());
		add(getButton2());
		add(getButton3());
		add(getButton4());
		add(getBtnFechar());
		add(getScrollPane1());
		add(getScrollPane2());
	}

	public JLabel getLblDevoluoDeProduto() {
		if (lblDevoluoDeProduto == null) {
			lblDevoluoDeProduto = new JLabel(" Devolu\u00E7\u00E3o de Produto");
			lblDevoluoDeProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblDevoluoDeProduto.setFont(new Font("Arial", Font.BOLD, 22));
			lblDevoluoDeProduto.setBounds(0, 0, 1055, 31);
		}
		return lblDevoluoDeProduto;
	}
	public JLabel getLblNotaFiscalN() {
		if (lblNotaFiscalN == null) {
			lblNotaFiscalN = new JLabel("Nota Fiscal n\u00BA:");
			lblNotaFiscalN.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNotaFiscalN.setBounds(10, 69, 110, 20);
		}
		return lblNotaFiscalN;
	}
	public JLabel getLblNDoItem() {
		if (lblNDoItem == null) {
			lblNDoItem = new JLabel("N\u00BA do Item:");
			lblNDoItem.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNDoItem.setBounds(434, 69, 79, 20);
		}
		return lblNDoItem;
	}
	public JLabel getLblNewLabelItensNotaFiscal() {
		if (lblNewLabelItensNotaFiscal == null) {
			lblNewLabelItensNotaFiscal = new JLabel("Itens da Nota Fiscal");
			lblNewLabelItensNotaFiscal.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabelItensNotaFiscal.setBounds(10, 132, 207, 20);
		}
		return lblNewLabelItensNotaFiscal;
	}
	public JLabel getLblItensASerem() {
		if (lblItensASerem == null) {
			lblItensASerem = new JLabel("Itens a serem devolvidos");
			lblItensASerem.setFont(new Font("Arial", Font.BOLD, 16));
			lblItensASerem.setBounds(585, 132, 207, 20);
		}
		return lblItensASerem;
	}
	public JTextField getTextFieldNumeroNota() {
		if (textFieldNumeroNota == null) {
			textFieldNumeroNota = new JTextField();
			textFieldNumeroNota.setForeground(Color.BLACK);
			textFieldNumeroNota.setBackground(Color.WHITE);
			textFieldNumeroNota.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNumeroNota.setBounds(130, 69, 228, 20);
			textFieldNumeroNota.setColumns(10);
		}
		return textFieldNumeroNota;
	}
	public JTextField getTextFieldNumeroItem() {
		if (textFieldNumeroItem == null) {
			textFieldNumeroItem = new JTextField();
			textFieldNumeroItem.setForeground(Color.BLACK);
			textFieldNumeroItem.setBackground(Color.WHITE);
			textFieldNumeroItem.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNumeroItem.setText("");
			textFieldNumeroItem.setBounds(523, 69, 141, 20);
			textFieldNumeroItem.setColumns(10);
		}
		return textFieldNumeroItem;
	}
	public JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(Color.BLACK);
			btnBuscar.setBackground(Color.WHITE);
			btnBuscar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnBuscar.setBounds(708, 68, 121, 24);
		}
		return btnBuscar;
	}
	public JButton getBtnDevolverTudo() {
		if (btnDevolverTudo == null) {
			btnDevolverTudo = new JButton("Devolver tudo");
			btnDevolverTudo.setForeground(Color.BLACK);
			btnDevolverTudo.setBackground(Color.WHITE);
			btnDevolverTudo.setFont(new Font("Arial", Font.PLAIN, 16));
			btnDevolverTudo.setBounds(25, 546, 179, 24);
		}
		return btnDevolverTudo;
	}
	public JButton getBtnDevolverSelecionados() {
		if (btnDevolverSelecionados == null) {
			btnDevolverSelecionados = new JButton("Devolver selecionados");
			btnDevolverSelecionados.setForeground(Color.BLACK);
			btnDevolverSelecionados.setBackground(Color.WHITE);
			btnDevolverSelecionados.setFont(new Font("Arial", Font.PLAIN, 16));
			btnDevolverSelecionados.setBounds(238, 546, 194, 24);
		}
		return btnDevolverSelecionados;
	}
	public JButton getButton1() {
		if (button1 == null) {
			button1 = new JButton(">>");
			button1.setForeground(Color.BLACK);
			button1.setBackground(Color.WHITE);
			button1.setFont(new Font("Arial", Font.PLAIN, 16));
			button1.setBounds(491, 220, 69, 24);
		}
		return button1;
	}
	public JButton getButton2() {
		if (button2 == null) {
			button2 = new JButton(">");
			button2.setForeground(Color.BLACK);
			button2.setBackground(Color.WHITE);
			button2.setFont(new Font("Arial", Font.PLAIN, 16));
			button2.setBounds(491, 254, 69, 24);
		}
		return button2;
	}
	public JButton getButton3() {
		if (button3 == null) {
			button3 = new JButton("<<");
			button3.setForeground(Color.BLACK);
			button3.setBackground(Color.WHITE);
			button3.setFont(new Font("Arial", Font.PLAIN, 16));
			button3.setBounds(491, 321, 69, 24);
		}
		return button3;
	}
	public JButton getButton4() {
		if (button4 == null) {
			button4 = new JButton("<");
			button4.setForeground(Color.BLACK);
			button4.setBackground(Color.WHITE);
			button4.setFont(new Font("Arial", Font.PLAIN, 16));
			button4.setBounds(491, 356, 69, 24);
		}
		return button4;
	}
	public JButton getBtnFechar() {
		if (btnFechar == null) {
			btnFechar = new JButton("Fechar");
			btnFechar.setForeground(Color.BLACK);
			btnFechar.setBackground(Color.WHITE);
			btnFechar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnFechar.setBounds(903, 582, 121, 24);
		}
		return btnFechar;
	}
	public JTable getTableItensNotaFical() {
		if (tableItensNotaFical == null) {
			tableItensNotaFical = new JTable();
			tableItensNotaFical.setFont(new Font("Arial", Font.PLAIN, 16));
		}
		return tableItensNotaFical;
	}
	public JTable getTableItensDevolvidos() {
		if (tableItensDevolvidos == null) {
			tableItensDevolvidos = new JTable();
			tableItensDevolvidos.setFont(new Font("Arial", Font.PLAIN, 16));
		}
		return tableItensDevolvidos;
	}
	
	public JScrollPane getScrollPane1() {
		if (scrollPane1 == null) {
			scrollPane1 = new JScrollPane();
			scrollPane1.setBackground(Color.WHITE);
			scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane1.setBounds(10, 156, 460, 379);
			scrollPane1.add(getTableItensNotaFical());
		}
		return scrollPane1;
	}
	public JScrollPane getScrollPane2() {
		if (scrollPane2 == null) {
			scrollPane2 = new JScrollPane();
			scrollPane2.setBackground(Color.WHITE);
			scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane2.setBounds(585, 156, 460, 379);
			scrollPane2.add(getTableItensDevolvidos());
		}
		return scrollPane2;
	}
}
