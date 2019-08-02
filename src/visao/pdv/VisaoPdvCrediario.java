package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class VisaoPdvCrediario extends JPanel {
	private JLabel lblTitulo;
	private JLabel lblItensAdquiridos;
	private JLabel lblCdigoCliente;
	private JLabel lblFParaBusca;
	private JLabel lblTipo;
	private JLabel lblCpfcnpjN;
	private JLabel lblNome;
	private JLabel lblSituao;
	private JLabel lblValorDaCompra;
	private JLabel lblFCancelar;
	private JLabel lblFConfirmar;
	private JTextField txtCodigoCliente;
	private JTextField txtTipo;
	private JTextField txtCpfCnpj;
	private JTextField txtNome;
	private JTextField txtSitucao;
	private JTextField txtValorCompra;
	private JTable table;
	private JScrollPane scrollPane;
	public VisaoPdvCrediario() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTitulo());
		add(getLblItensAdquiridos());
		add(getLblCdigoCliente());
		add(getLblFParaBusca());
		add(getLblTipo());
		add(getLblCpfcnpjN());
		add(getLblNome());
		add(getLblSituao());
		add(getLblValorDaCompra());
		add(getLblFCancelar());
		add(getLblFConfirmar());
		add(getTxtCodigoCliente());
		add(getTxtTipo());
		add(getTxtCpfCnpj());
		add(getTxtNome());
		add(getTxtSitucao());
		add(getTxtValorCompra());
		add(getScrollPane());
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Compra a Prazo");
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 1008, 30);
		}
		return lblTitulo;
	}

	public JLabel getLblItensAdquiridos() {
		if (lblItensAdquiridos == null) {
			lblItensAdquiridos = new JLabel("Itens Adquiridos");
			lblItensAdquiridos.setFont(new Font("Arial", Font.BOLD, 20));
			lblItensAdquiridos.setBounds(10, 58, 266, 30);
		}
		return lblItensAdquiridos;
	}
	public JLabel getLblCdigoCliente() {
		if (lblCdigoCliente == null) {
			lblCdigoCliente = new JLabel("C\u00F3digo Cliente:");
			lblCdigoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			lblCdigoCliente.setBounds(502, 123, 205, 20);
		}
		return lblCdigoCliente;
	}
	public JLabel getLblFParaBusca() {
		if (lblFParaBusca == null) {
			lblFParaBusca = new JLabel("F2 para busca");
			lblFParaBusca.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFParaBusca.setBounds(631, 154, 173, 20);
		}
		return lblFParaBusca;
	}
	public JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			lblTipo.setBounds(502, 185, 54, 20);
		}
		return lblTipo;
	}
	public JLabel getLblCpfcnpjN() {
		if (lblCpfcnpjN == null) {
			lblCpfcnpjN = new JLabel("CPF/CNPJ n\u00BA:");
			lblCpfcnpjN.setFont(new Font("Arial", Font.PLAIN, 16));
			lblCpfcnpjN.setBounds(502, 243, 120, 20);
		}
		return lblCpfcnpjN;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNome.setBounds(502, 305, 61, 20);
		}
		return lblNome;
	}
	public JLabel getLblSituao() {
		if (lblSituao == null) {
			lblSituao = new JLabel("Situa\u00E7\u00E3o:");
			lblSituao.setFont(new Font("Arial", Font.PLAIN, 16));
			lblSituao.setBounds(502, 363, 79, 20);
		}
		return lblSituao;
	}
	public JLabel getLblValorDaCompra() {
		if (lblValorDaCompra == null) {
			lblValorDaCompra = new JLabel("Valor da Compra:");
			lblValorDaCompra.setFont(new Font("Arial", Font.PLAIN, 16));
			lblValorDaCompra.setBounds(502, 418, 137, 20);
		}
		return lblValorDaCompra;
	}
	public JLabel getLblFCancelar() {
		if (lblFCancelar == null) {
			lblFCancelar = new JLabel("F4 - Cancelar");
			lblFCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFCancelar.setBounds(605, 527, 114, 20);
		}
		return lblFCancelar;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar");
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFConfirmar.setBounds(729, 527, 114, 20);
		}
		return lblFConfirmar;
	}
	public JTextField getTxtCodigoCliente() {
		if (txtCodigoCliente == null) {
			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			txtCodigoCliente.setBounds(631, 123, 276, 25);
			txtCodigoCliente.setColumns(10);
		}
		return txtCodigoCliente;
	}
	public JTextField getTxtTipo() {
		if (txtTipo == null) {
			txtTipo = new JTextField();
			txtTipo.setFont(new Font("Arial", Font.PLAIN, 16));
			txtTipo.setBounds(553, 185, 354, 25);
			txtTipo.setColumns(10);
		}
		return txtTipo;
	}
	public JTextField getTxtCpfCnpj() {
		if (txtCpfCnpj == null) {
			txtCpfCnpj = new JTextField();
			txtCpfCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			txtCpfCnpj.setBounds(621, 243, 286, 25);
			txtCpfCnpj.setColumns(10);
		}
		return txtCpfCnpj;
	}
	public JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setFont(new Font("Arial", Font.PLAIN, 16));
			txtNome.setBounds(564, 305, 343, 25);
			txtNome.setColumns(10);
		}
		return txtNome;
	}
	public JTextField getTxtSitucao() {
		if (txtSitucao == null) {
			txtSitucao = new JTextField();
			txtSitucao.setFont(new Font("Arial", Font.PLAIN, 16));
			txtSitucao.setBounds(585, 363, 322, 25);
			txtSitucao.setColumns(10);
		}
		return txtSitucao;
	}
	public JTextField getTxtValorCompra() {
		if (txtValorCompra == null) {
			txtValorCompra = new JTextField();
			txtValorCompra.setFont(new Font("Arial", Font.PLAIN, 16));
			txtValorCompra.setBounds(647, 418, 260, 25);
			txtValorCompra.setColumns(10);
		}
		return txtValorCompra;
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
			scrollPane.setBounds(10, 99, 454, 432);
			scrollPane.add(getTable());
		}
		return scrollPane;
	}
}
