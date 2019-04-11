package visao;

import javax.swing.*;
import java.awt.*;

public class VisaoTelaLogin extends JPanel{
	private JLabel 			labelNomeDeUsuario      = null;
	private JLabel 			labelSenha        		= null;
	private JTextField 		textFieldNomeDeUsuario  = null;
	private JPasswordField  passwordFieldSenha      = null;
	private JButton 		buttonSair        		= null;
	private JButton 		buttonEntrar        	= null;
	private JSeparator 		separatorTitulo        	= null;
	private JLabel 			labelPaginaLogin        = null;
	private JLabel 			labelLogo        		= null;
	private Icon 			imagemSistema        	= null;
	
	public VisaoTelaLogin() {
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(804, 720));
		setMaximumSize(new Dimension(804, 720));
		add(getLabelNomeDeUsuario());
		add(getLabelSenha());
		add(getTextFieldNomeDeUsuario());
		add(getPasswordFieldSenha());
		add(getButtonSair());
		add(getButtonEntrar());
		add(getSeparatorTitulo());
		add(getLabelPaginaLogin());
		add(getLabelLogo());
	}
	
	public JLabel getLabelNomeDeUsuario() {
		if (labelNomeDeUsuario == null) {
			labelNomeDeUsuario = new JLabel("Nome de Usu\u00E1rio");
			labelNomeDeUsuario.setBackground(Color.WHITE);
			labelNomeDeUsuario.setForeground(Color.BLACK);
			labelNomeDeUsuario.setFont(new Font("Arial", Font.BOLD, 16));
			labelNomeDeUsuario.setBounds(643, 264, 241, 30);
		}
		return labelNomeDeUsuario;
	}
	public JLabel getLabelSenha() {
		if (labelSenha == null) {
			labelSenha = new JLabel("Senha");
			labelSenha.setBackground(Color.WHITE);
			labelSenha.setForeground(Color.BLACK);
			labelSenha.setFont(new Font("Arial", Font.BOLD, 16));
			labelSenha.setBounds(643, 342, 241, 30);
		}
		return labelSenha;
	}
	public JTextField getTextFieldNomeDeUsuario() {
		if (textFieldNomeDeUsuario == null) {
			textFieldNomeDeUsuario = new JTextField();
			textFieldNomeDeUsuario.setBackground(Color.WHITE);
			textFieldNomeDeUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNomeDeUsuario.setBounds(643, 295, 261, 30);
			textFieldNomeDeUsuario.setColumns(10);
		}
		return textFieldNomeDeUsuario;
	}
	public JPasswordField getPasswordFieldSenha() {
		if (passwordFieldSenha == null) {
			passwordFieldSenha = new JPasswordField();
			passwordFieldSenha.setBackground(Color.WHITE);
			passwordFieldSenha.setFont(new Font("Arial", Font.PLAIN, 16));
			passwordFieldSenha.setBounds(643, 373, 261, 30);
		}
		return passwordFieldSenha;
	}
	public JButton getButtonSair() {
		if (buttonSair == null) {
			buttonSair = new JButton("Sair");
			buttonSair.setBackground(Color.WHITE);
			buttonSair.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonSair.setForeground(Color.BLACK);
			buttonSair.setBounds(659, 431, 102, 34);
		}
		return buttonSair;
	}
	public JButton getButtonEntrar() {
		if (buttonEntrar == null) {
			buttonEntrar = new JButton("Entrar");
			buttonEntrar.setBackground(Color.WHITE);
			buttonEntrar.setFont(new Font("Arial", Font.PLAIN, 16));
			buttonEntrar.setForeground(Color.BLACK);
			buttonEntrar.setBounds(784, 431, 109, 34);
		}
		return buttonEntrar;
	}
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	
	public JLabel getLabelPaginaLogin() {
		if (labelPaginaLogin == null) {
			labelPaginaLogin = new JLabel(" Acesso do Funcionário");
			labelPaginaLogin.setFont(new Font("Arial", Font.BOLD, 22));
			labelPaginaLogin.setBounds(0, 0, 243, 30);
		}
		return labelPaginaLogin;
	}

	public JLabel getLabelLogo() {
		if(labelLogo == null) {
			imagemSistema = new ImageIcon("fundoLogoSistema1.png");
			labelLogo = new JLabel(imagemSistema);
			labelLogo.setBounds(86, 115, 535, 520);
		}
		return labelLogo;
	}
}
