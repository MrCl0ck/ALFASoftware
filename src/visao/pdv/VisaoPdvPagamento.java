package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class VisaoPdvPagamento extends JPanel{
	private JLabel lblTitulo;
	private JLabel lblTotalAPagar;
	private JLabel lblValorRecebido;
	private JLabel lblTroco;
	private JLabel lblCpfcnpjN;
	private JLabel lblFCancelar;
	private JLabel lblFConfirmar;
	private JTextField txtTotalPagar;
	private JTextField txtValorRecebido;
	private JTextField txtTroco;
	private JTextField txtCpfcnpj;
	public VisaoPdvPagamento() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTitulo());
		add(getLblTotalAPagar());
		add(getLblValorRecebido());
		add(getLblTroco());
		add(getLblCpfcnpjN());
		add(getLblFCancelar());
		add(getLblFConfirmar());
		add(getTxtTotalPagar());
		add(getTxtValorRecebido());
		add(getTxtTroco());
		add(getTxtCpfcnpj());
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Pagamento");
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 672, 30);
		}
		return lblTitulo;
	}
	public JLabel getLblTotalAPagar() {
		if (lblTotalAPagar == null) {
			lblTotalAPagar = new JLabel("Total a pagar:");
			lblTotalAPagar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblTotalAPagar.setBounds(10, 77, 210, 26);
		}
		return lblTotalAPagar;
	}
	public JLabel getLblValorRecebido() {
		if (lblValorRecebido == null) {
			lblValorRecebido = new JLabel("Valor recebido:");
			lblValorRecebido.setFont(new Font("Arial", Font.PLAIN, 20));
			lblValorRecebido.setBounds(10, 135, 148, 26);
		}
		return lblValorRecebido;
	}
	public JLabel getLblTroco() {
		if (lblTroco == null) {
			lblTroco = new JLabel("Troco:");
			lblTroco.setFont(new Font("Arial", Font.PLAIN, 20));
			lblTroco.setBounds(10, 184, 130, 26);
		}
		return lblTroco;
	}
	public JLabel getLblCpfcnpjN() {
		if (lblCpfcnpjN == null) {
			lblCpfcnpjN = new JLabel("CPF/CNPJ n\u00BA:");
			lblCpfcnpjN.setFont(new Font("Arial", Font.PLAIN, 20));
			lblCpfcnpjN.setBounds(10, 236, 148, 26);
		}
		return lblCpfcnpjN;
	}
	public JLabel getLblFCancelar() {
		if (lblFCancelar == null) {
			lblFCancelar = new JLabel("F4 - Cancelar");
			lblFCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFCancelar.setBounds(244, 319, 148, 30);
		}
		return lblFCancelar;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar");
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFConfirmar.setBounds(402, 319, 154, 30);
		}
		return lblFConfirmar;
	}
	public JTextField getTxtTotalPagar() {
		if (txtTotalPagar == null) {
			txtTotalPagar = new JTextField();
			txtTotalPagar.setFont(new Font("Arial", Font.PLAIN, 20));
			txtTotalPagar.setBounds(162, 77, 244, 26);
			txtTotalPagar.setColumns(10);
		}
		return txtTotalPagar;
	}
	public JTextField getTxtValorRecebido() {
		if (txtValorRecebido == null) {
			txtValorRecebido = new JTextField();
			txtValorRecebido.setFont(new Font("Arial", Font.PLAIN, 20));
			txtValorRecebido.setBounds(162, 135, 244, 26);
			txtValorRecebido.setColumns(10);
		}
		return txtValorRecebido;
	}
	public JTextField getTxtTroco() {
		if (txtTroco == null) {
			txtTroco = new JTextField();
			txtTroco.setFont(new Font("Arial", Font.PLAIN, 20));
			txtTroco.setBounds(162, 184, 244, 26);
			txtTroco.setColumns(10);
		}
		return txtTroco;
	}
	public JTextField getTxtCpfcnpj() {
		if (txtCpfcnpj == null) {
			txtCpfcnpj = new JTextField();
			txtCpfcnpj.setFont(new Font("Arial", Font.PLAIN, 20));
			txtCpfcnpj.setBounds(162, 236, 244, 26);
			txtCpfcnpj.setColumns(10);
		}
		return txtCpfcnpj;
	}
}
