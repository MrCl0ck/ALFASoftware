package visao.pdv;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VisaoPdvConfirmacao extends JPanel {
	private JLabel lblMensagemSolicitndoConfirmao;
	private JLabel lblFConfirmar;
	private JLabel lblEscSair;
	private JLabel lblTitulo;
	private JLabel lblFImprimir;

	public VisaoPdvConfirmacao() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblMensagemSolicitndoConfirmao());
		add(getLblFConfirmar());
		add(getLblEscSair());
		add(getLblTitulo());
		add(getLblFImprimir());
	}

	public JLabel getLblMensagemSolicitndoConfirmao() {
		if (lblMensagemSolicitndoConfirmao == null) {
			lblMensagemSolicitndoConfirmao = new JLabel("mensagem solicitando confirma\u00E7\u00E3o");
			lblMensagemSolicitndoConfirmao.setVisible(false);
			lblMensagemSolicitndoConfirmao.setForeground(Color.BLACK);
			lblMensagemSolicitndoConfirmao.setFont(new Font("Arial", Font.PLAIN, 20));
			lblMensagemSolicitndoConfirmao.setBounds(110, 76, 333, 25);
		}
		return lblMensagemSolicitndoConfirmao;
	}
	public JLabel getLblFConfirmar() {
		if (lblFConfirmar == null) {
			lblFConfirmar = new JLabel("F5 - Confirmar / F1 - Entrega");
			lblFConfirmar.setForeground(Color.BLACK);
			lblFConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFConfirmar.setBounds(10, 145, 272, 25);
		}
		return lblFConfirmar;
	}
	public JLabel getLblEscSair() {
		if (lblEscSair == null) {
			lblEscSair = new JLabel("Esc - Sair / Enter - Continuar");
			lblEscSair.setForeground(Color.BLACK);
			lblEscSair.setFont(new Font("Arial", Font.PLAIN, 20));
			lblEscSair.setBounds(508, 145, 262, 25);
		}
		return lblEscSair;
	}
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Confirma\u00E7\u00E3o de ");
			lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
			lblTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblTitulo.setBounds(0, 0, 780, 30);
		}
		return lblTitulo;
	}
	public JLabel getLblFImprimir() {
		if (lblFImprimir == null) {
			lblFImprimir = new JLabel("F3 - Imprimir Nota");
			lblFImprimir.setForeground(Color.BLACK);
			lblFImprimir.setFont(new Font("Arial", Font.PLAIN, 20));
			lblFImprimir.setBounds(310, 145, 166, 25);
		}
		return lblFImprimir;
	}
}
