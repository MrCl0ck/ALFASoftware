package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class VisaoPdvCancelamento extends JPanel{
	private JLabel lblTitulo;
	private JLabel lblEscSair;
	private JLabel lblFConfirmar;
	private JLabel lblNmeroDoItem;
	private JLabel lblDesejaRealmenteCancelar;
	private JTextField textFieldNumeroItem;
	public VisaoPdvCancelamento() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTitulo());
		add(getLblEscSair());
		add(getLblFConfirmar());
		add(getLblNmeroDoItem());
		add(getLblDesejaRealmenteCancelar());
		add(getTextFieldNumeroItem());
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel(" Cancelar Item");
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBounds(0, 0, 704, 30);
		}
		return lblTitulo;
	}
	public JLabel getLblEscSair() {
		if (lblEscSair == null) {
			lblEscSair = new JLabel("Esc - Sair");
			lblEscSair.setForeground(Color.BLACK);
			lblEscSair.setFont(new Font("Arial", Font.PLAIN, 20));
			lblEscSair.setBounds(442, 145, 129, 25);
		}
		return lblEscSair;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar");
			lblFConfirmar.setForeground(Color.BLACK);
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFConfirmar.setBounds(292, 145, 140, 25);
		}
		return lblFConfirmar;
	}

	public JLabel getLblNmeroDoItem() {
		if (lblNmeroDoItem == null) {
			lblNmeroDoItem = new JLabel("N\u00FAmero do Item:");
			lblNmeroDoItem.setForeground(Color.BLACK);
			lblNmeroDoItem.setFont(new Font("Arial", Font.PLAIN, 20));
			lblNmeroDoItem.setBounds(24, 76, 242, 25);
		}
		return lblNmeroDoItem;
	}
	public JLabel getLblDesejaRealmenteCancelar() {
		if (lblDesejaRealmenteCancelar == null) {
			lblDesejaRealmenteCancelar = new JLabel("Deseja realmente cancelar o item?");
			lblDesejaRealmenteCancelar.setVisible(false);
			lblDesejaRealmenteCancelar.setForeground(Color.BLACK);
			lblDesejaRealmenteCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblDesejaRealmenteCancelar.setBounds(110, 76, 333, 25);
		}
		return lblDesejaRealmenteCancelar;
	}
	public JTextField getTextFieldNumeroItem() {
		if (textFieldNumeroItem == null) {
			textFieldNumeroItem = new JTextField();
			textFieldNumeroItem.setFont(new Font("Arial", Font.PLAIN, 20));
			textFieldNumeroItem.setBounds(201, 76, 299, 25);
			textFieldNumeroItem.setColumns(10);
		}
		return textFieldNumeroItem;
	}
}
