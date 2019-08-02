package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class VisaoPdvTerminal extends JPanel{
	private JLabel lblTitulo;
	private JLabel lblLivre;
	private JLabel lblFNova;
	private JLabel lblFBusca;
	private JLabel lblDescontoTotal;
	private JLabel lblTotalAPagar;
	private JLabel lblCdigoProduto;
	private JLabel lblQuantidade;
	private JLabel lblValorUnitrio;
	private JLabel lblDescrio;
	private JLabel lblDesconto;
	private JLabel lblFCancelar;
	private JLabel lblFPagamento;
	private JLabel lblFCredirio;
	private JLabel lblFBuscar;
	private JLabel lblFAlterar;
	private JTextField txtCodigoProduto;
	private JTextField textFieldQuantidade;
	private JTextField txtValorUnitario;
	private JTextField txtDescricao;
	private JTextField txtDesconto;
	private JTable table;
	private JScrollPane scrollPane;
	public VisaoPdvTerminal() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTitulo());
		add(getLblLivre());
		add(getLblFNova());
		add(getLblFBusca());
		add(getLblDescontoTotal());
		add(getLblTotalAPagar());
		add(getLblCdigoProduto());
		add(getLblQuantidade());
		add(getLblValorUnitrio());
		add(getLblDescrio());
		add(getLblDesconto());
		add(getLblFCancelar());
		add(getLblFPagamento());
		add(getLblFCredirio());
		add(getLblFBuscar());
		add(getLblFAlterar());
		add(getTxtCodigoProduto());
		add(getTextFieldQuantidade());
		add(getTxtValorUnitario());
		add(getTxtDescricao());
		add(getTxtDesconto());
		add(getScrollPane());
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Terminal");
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 1188, 30);
		}
		return lblTitulo;
	}

	public JLabel getLblLivre() {
		if (lblLivre == null) {
			lblLivre = new JLabel("LIVRE");
			lblLivre.setFont(new Font("Arial", Font.PLAIN, 200));
			lblLivre.setBounds(0, 176, 583, 231);
		}
		return lblLivre;
	}
	public JLabel getLblFNova() {
		if (lblFNova == null) {
			lblFNova = new JLabel("F1 - Nova Compra");
			lblFNova.setFont(new Font("Arial", Font.PLAIN, 26));
			lblFNova.setBounds(10, 682, 256, 30);
		}
		return lblFNova;
	}
	public JLabel getLblFBusca() {
		if (lblFBusca == null) {
			lblFBusca = new JLabel("F2 - Busca de Produto");
			lblFBusca.setFont(new Font("Arial", Font.PLAIN, 26));
			lblFBusca.setBounds(243, 682, 285, 30);
		}
		return lblFBusca;
	}
	public JLabel getLblDescontoTotal() {
		if (lblDescontoTotal == null) {
			lblDescontoTotal = new JLabel("Desconto total:");
			lblDescontoTotal.setFont(new Font("Arial", Font.PLAIN, 26));
			lblDescontoTotal.setBounds(772, 630, 406, 50);
		}
		return lblDescontoTotal;
	}
	public JLabel getLblTotalAPagar() {
		if (lblTotalAPagar == null) {
			lblTotalAPagar = new JLabel("Total a pagar:");
			lblTotalAPagar.setFont(new Font("Arial", Font.PLAIN, 26));
			lblTotalAPagar.setBounds(772, 664, 406, 50);
		}
		return lblTotalAPagar;
	}
	public JLabel getLblCdigoProduto() {
		if (lblCdigoProduto == null) {
			lblCdigoProduto = new JLabel("C\u00F3d. Produto:");
			lblCdigoProduto.setFont(new Font("Arial", Font.PLAIN, 26));
			lblCdigoProduto.setBounds(10, 70, 173, 50);
		}
		return lblCdigoProduto;
	}
	public JLabel getLblQuantidade() {
		if (lblQuantidade == null) {
			lblQuantidade = new JLabel("Quantidade:");
			lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 26));
			lblQuantidade.setBounds(10, 163, 212, 50);
		}
		return lblQuantidade;
	}
	public JLabel getLblValorUnitrio() {
		if (lblValorUnitrio == null) {
			lblValorUnitrio = new JLabel("<html>Valor<br />Unit\u00E1rio:</html>");
			lblValorUnitrio.setFont(new Font("Arial", Font.PLAIN, 26));
			lblValorUnitrio.setBounds(10, 239, 159, 60);
		}
		return lblValorUnitrio;
	}
	public JLabel getLblDescrio() {
		if (lblDescrio == null) {
			lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
			lblDescrio.setFont(new Font("Arial", Font.PLAIN, 26));
			lblDescrio.setBounds(10, 337, 149, 50);
		}
		return lblDescrio;
	}
	public JLabel getLblDesconto() {
		if (lblDesconto == null) {
			lblDesconto = new JLabel("Desconto:");
			lblDesconto.setFont(new Font("Arial", Font.PLAIN, 26));
			lblDesconto.setBounds(10, 464, 149, 50);
		}
		return lblDesconto;
	}
	public JLabel getLblFCancelar() {
		if (lblFCancelar == null) {
			lblFCancelar = new JLabel("F4 - Cancelar Item");
			lblFCancelar.setFont(new Font("Arial", Font.PLAIN, 26));
			lblFCancelar.setBounds(10, 682, 256, 30);
		}
		return lblFCancelar;
	}
	public JLabel getLblFPagamento() {
		if (lblFPagamento == null) {
			lblFPagamento = new JLabel("F5 - Pagamento");
			lblFPagamento.setFont(new Font("Arial", Font.PLAIN, 26));
			lblFPagamento.setBounds(243, 682, 212, 30);
		}
		return lblFPagamento;
	}
	public JLabel getLblFCredirio() {
		if (lblFCredirio == null) {
			lblFCredirio = new JLabel("F11 - Credi\u00E1rio");
			lblFCredirio.setFont(new Font("Arial", Font.PLAIN, 26));
			lblFCredirio.setBounds(538, 682, 217, 30);
		}
		return lblFCredirio;
	}
	public JLabel getLblFBuscar() {
		if (lblFBuscar == null) {
			lblFBuscar = new JLabel("F2 para busca");
			lblFBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFBuscar.setBounds(179, 122, 145, 30);
		}
		return lblFBuscar;
	}
	public JLabel getLblFAlterar() {
		if (lblFAlterar == null) {
			lblFAlterar = new JLabel("F1 para alterar");
			lblFAlterar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFAlterar.setBounds(179, 214, 145, 30);
		}
		return lblFAlterar;
	}
	public JTextField getTxtCodigoProduto() {
		if (txtCodigoProduto == null) {
			txtCodigoProduto = new JTextField();
			txtCodigoProduto.setFont(new Font("Arial", Font.PLAIN, 26));
			txtCodigoProduto.setBounds(179, 70, 356, 50);
			txtCodigoProduto.setColumns(10);
		}
		return txtCodigoProduto;
	}
	public JTextField getTextFieldQuantidade() {
		if (textFieldQuantidade == null) {
			textFieldQuantidade = new JTextField();
			textFieldQuantidade.setFont(new Font("Arial", Font.PLAIN, 26));
			textFieldQuantidade.setBounds(179, 163, 356, 50);
			textFieldQuantidade.setColumns(10);
		}
		return textFieldQuantidade;
	}
	public JTextField getTxtValorUnitario() {
		if (txtValorUnitario == null) {
			txtValorUnitario = new JTextField();
			txtValorUnitario.setFont(new Font("Arial", Font.PLAIN, 26));
			txtValorUnitario.setBounds(179, 255, 356, 50);
			txtValorUnitario.setColumns(10);
		}
		return txtValorUnitario;
	}
	public JTextField getTxtDescricao() {
		if (txtDescricao == null) {
			txtDescricao = new JTextField();
			txtDescricao.setFont(new Font("Arial", Font.PLAIN, 26));
			txtDescricao.setBounds(10, 383, 525, 50);
			txtDescricao.setColumns(10);
		}
		return txtDescricao;
	}
	public JTextField getTxtDesconto() {
		if (txtDesconto == null) {
			txtDesconto = new JTextField();
			txtDesconto.setFont(new Font("Arial", Font.PLAIN, 26));
			txtDesconto.setBounds(179, 464, 356, 50);
			txtDesconto.setColumns(10);
		}
		return txtDesconto;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFont(new Font("Arial", Font.PLAIN, 26));
		}
		return table;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(595, 70, 583, 549);
			scrollPane.add(getTable());
		}
		return scrollPane;
	}
}
