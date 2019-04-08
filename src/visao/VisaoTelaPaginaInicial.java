package visao;



import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class VisaoTelaPaginaInicial extends JPanel {
	private JMenuBar  menuBarMenu        			 = null;
	private JMenu     menuCadastros		 			 = null;
	private JMenu     menuControle		 		 	 = null;
	private JMenu     menuPDV			 			 = null;
	private JMenu     menuEntrega		 			 = null;
	private JMenu     menuRelatorios	 		 	 = null;
	private JMenu     menuSobre			 			 = null;
	private JMenuItem menuItemCadastroCliente 	 	 = null;
	private JMenuItem menuItemCadastroFornecedor 	 = null;
	private JMenuItem menuItemCadastroFuncionario 	 = null;
	private JMenuItem menuItemCadastroProduto 	 	 = null;
	private JMenuItem menuItemControleEstoque 	 	 = null;
	private JMenuItem menuItemControleContas 	 	 = null;
	private JMenuItem menuItemPDVTerminal 	 		 = null;
	private JMenuItem menuItemPDVPagamentoVista 	 = null;
	private JMenuItem menuItemPDVPagamentoCrediario  = null;
	private JMenuItem menuItemEntregaInserirEndereco = null;
	private JMenuItem menuItemEntregaConsultar 	 	 = null;
	private JMenuItem menuItemEntregaGerenciar 	 	 = null;
	private JSeparator separatorTitulo;
	private JLabel labelPaginaInicial;
	private JLabel labelLogo;
	private Icon imagemSistema;
	
	public VisaoTelaPaginaInicial() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(1055, 720));
		setMaximumSize(new Dimension(1055, 720));
		add(getMenuBarMenu());
		add(getSeparatorTitulo());
		add(getLabelPaginaInicial());
		add(getLabelLogo());
	}

	public JMenuBar getMenuBarMenu() {
		if(menuBarMenu == null) {
			menuBarMenu = new JMenuBar();
			menuBarMenu.setBackground(new Color(252, 246, 229));
			menuBarMenu.setLayout(null);
			menuBarMenu.setBounds(0, 31, 1752, 30);
			menuBarMenu.add(getMenuCadastros());
			menuBarMenu.add(getMenuEntrega());
			menuBarMenu.add(getMenuControle());
			menuBarMenu.add(getMenuPDV());
			menuBarMenu.add(getMenuRelatorios());
			menuBarMenu.add(getMenuSobre());
			
		}
		return menuBarMenu;
	}
	public JMenu getMenuCadastros() {
		if(menuCadastros == null) {
			menuCadastros = new JMenu(" Cadastro");
			menuCadastros.setBorder(null);
			menuCadastros.setIcon(null);
			menuCadastros.setLayout(null);
			menuCadastros.setHorizontalAlignment(SwingConstants.CENTER);
			menuCadastros.setFont(new Font("Arial", Font.PLAIN, 22));
			menuCadastros.setBackground(Color.WHITE);
			menuCadastros.setForeground(Color.BLACK);
			menuCadastros.setBounds(0, 0, 160, 30);
			menuCadastros.add(getMenuItemCadastroCliente());
			menuCadastros.add(getMenuItemCadastroFornecedor());
			menuCadastros.add(getMenuItemCadastroFuncionario());
			menuCadastros.add(getMenuItemCadastroProduto());
		}
		return menuCadastros;
	}

	public JMenu getMenuControle() {
		if(menuControle == null) {
			menuControle = new JMenu(" Controle");
			menuControle.setBorder(null);
			menuControle.setIcon(null);
			menuControle.setLayout(null);
			menuControle.setHorizontalAlignment(SwingConstants.CENTER);
			menuControle.setFont(new Font("Arial", Font.PLAIN, 22));
			menuControle.setBackground(Color.WHITE);
			menuControle.setForeground(Color.BLACK);
			menuControle.setBounds(160, 0, 140, 30);
			menuControle.add(getMenuItemControleEstoque());
			menuControle.add(getMenuItemControleContas());
		}
		return menuControle;
	}
	
	public JMenu getMenuPDV() {
		if(menuPDV == null) {
			menuPDV = new JMenu(" PDV");
			menuPDV.setBorder(null);
			menuPDV.setIcon(null);
			menuPDV.setLayout(null);
			menuPDV.setHorizontalAlignment(SwingConstants.TRAILING);
			menuPDV.setFont(new Font("Arial", Font.PLAIN, 22));
			menuPDV.setBackground(Color.WHITE);
			menuPDV.setForeground(Color.BLACK);
			menuPDV.setBounds(300, 0, 110, 30);
			menuPDV.add(getMenuItemPDVTerminal());
			menuPDV.add(getMenuItemPDVPagamentoVista());
			menuPDV.add(getMenuItemPDVPagamentoCrediario());
		}
		return menuPDV;
	}
	
	public JMenu getMenuEntrega() {
		if(menuEntrega == null) {
			menuEntrega = new JMenu(" Entrega");
			menuEntrega.setBorder(null);
			menuEntrega.setIcon(null);
			menuEntrega.setLayout(null);
			menuEntrega.setHorizontalAlignment(SwingConstants.CENTER);
			menuEntrega.setFont(new Font("Arial", Font.PLAIN, 22));
			menuEntrega.setBackground(Color.WHITE);
			menuEntrega.setForeground(Color.BLACK);
			menuEntrega.setBounds(410, 0, 140, 30);
			menuEntrega.add(getMenuItemEntregaInserirEndereco());
			menuEntrega.add(getMenuItemEntregaConsultar());
			menuEntrega.add(getMenuItemEntregaGerenciar());
		}
		return menuEntrega;
	}
	
	public JMenu getMenuRelatorios() {
		if(menuRelatorios == null) {
			menuRelatorios = new JMenu(" Relatórios");
			menuRelatorios.setBorder(null);
			menuRelatorios.setIcon(null);
			menuRelatorios.setLayout(null);
			menuRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
			menuRelatorios.setFont(new Font("Arial", Font.PLAIN, 22));
			menuRelatorios.setBackground(Color.WHITE);
			menuRelatorios.setForeground(Color.BLACK);
			menuRelatorios.setBounds(550, 0, 145, 30);
		}
		return menuRelatorios;
	}
	
	public JMenu getMenuSobre() {
		if(menuSobre == null) {
			menuSobre = new JMenu("   Sobre");
			menuSobre.setBorder(null);
			menuSobre.setIcon(null);
			menuSobre.setLayout(null);
			menuSobre.setHorizontalAlignment(SwingConstants.CENTER);
			menuSobre.setFont(new Font("Arial", Font.PLAIN, 22));
			menuSobre.setBackground(Color.WHITE);
			menuSobre.setForeground(Color.BLACK);
			menuSobre.setBounds(680, 0, 130, 30);
		}
		return menuSobre;
	}

	public JMenuItem getMenuItemCadastroCliente() {
		if(menuItemCadastroCliente == null) {
			menuItemCadastroCliente = new JMenuItem("Cliente");
			menuItemCadastroCliente.setForeground(Color.BLACK);
			menuItemCadastroCliente.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemCadastroCliente.setBackground(Color.WHITE);
		}
		return menuItemCadastroCliente;
	}

	public JMenuItem getMenuItemCadastroFornecedor() {
		if(menuItemCadastroFornecedor == null) {
			menuItemCadastroFornecedor = new JMenuItem("Fornecedor");
			menuItemCadastroFornecedor.setForeground(Color.BLACK);
			menuItemCadastroFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemCadastroFornecedor.setBackground(Color.WHITE);
		}
		return menuItemCadastroFornecedor;
	}

	public JMenuItem getMenuItemCadastroFuncionario() {
		if(menuItemCadastroFuncionario == null) {
			menuItemCadastroFuncionario = new JMenuItem("Funcionário");
			menuItemCadastroFuncionario.setForeground(Color.BLACK);
			menuItemCadastroFuncionario.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemCadastroFuncionario.setBackground(Color.WHITE);
		}
		return menuItemCadastroFuncionario;
	}

	public JMenuItem getMenuItemCadastroProduto() {
		if(menuItemCadastroProduto == null) {
			menuItemCadastroProduto = new JMenuItem("Produto");
			menuItemCadastroProduto.setForeground(Color.BLACK);
			menuItemCadastroProduto.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemCadastroProduto.setBackground(Color.WHITE);
		}
		return menuItemCadastroProduto;
	}

	public JMenuItem getMenuItemControleEstoque() {
		if(menuItemControleEstoque == null) {
			menuItemControleEstoque = new JMenuItem("Estoque");
			menuItemControleEstoque.setForeground(Color.BLACK);
			menuItemControleEstoque.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemControleEstoque.setBackground(Color.WHITE);
		}
		return menuItemControleEstoque;
	}

	public JMenuItem getMenuItemControleContas() {
		if(menuItemControleContas == null) {
			menuItemControleContas = new JMenuItem("Contas");
			menuItemControleContas.setForeground(Color.BLACK);
			menuItemControleContas.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemControleContas.setBackground(Color.WHITE);
		}
		return menuItemControleContas;
	}

	public JMenuItem getMenuItemPDVTerminal() {
		if(menuItemPDVTerminal == null) {
			menuItemPDVTerminal = new JMenuItem("Terminal");
			menuItemPDVTerminal.setForeground(Color.BLACK);
			menuItemPDVTerminal.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemPDVTerminal.setBackground(Color.WHITE);
		}
		return menuItemPDVTerminal;
	}

	public JMenuItem getMenuItemPDVPagamentoVista() {
		if(menuItemPDVPagamentoVista == null) {
			menuItemPDVPagamentoVista = new JMenuItem("Pagamento à vista");
			menuItemPDVPagamentoVista.setForeground(Color.BLACK);
			menuItemPDVPagamentoVista.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemPDVPagamentoVista.setBackground(Color.WHITE);
		}
		return menuItemPDVPagamentoVista;
	}

	public JMenuItem getMenuItemPDVPagamentoCrediario() {
		if(menuItemPDVPagamentoCrediario == null) {
			menuItemPDVPagamentoCrediario = new JMenuItem("Pagamento no crediário");
			menuItemPDVPagamentoCrediario.setForeground(Color.BLACK);
			menuItemPDVPagamentoCrediario.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemPDVPagamentoCrediario.setBackground(Color.WHITE);
		}
		return menuItemPDVPagamentoCrediario;
	}

	public JMenuItem getMenuItemEntregaInserirEndereco() {
		if(menuItemEntregaInserirEndereco == null) {
			menuItemEntregaInserirEndereco = new JMenuItem("Inserir Endereço");
			menuItemEntregaInserirEndereco.setForeground(Color.BLACK);
			menuItemEntregaInserirEndereco.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemEntregaInserirEndereco.setBackground(Color.WHITE);
		}
		return menuItemEntregaInserirEndereco;
	}

	public JMenuItem getMenuItemEntregaConsultar() {
		if(menuItemEntregaConsultar == null) {
			menuItemEntregaConsultar = new JMenuItem("Consultar");
			menuItemEntregaConsultar.setForeground(Color.BLACK);
			menuItemEntregaConsultar.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemEntregaConsultar.setBackground(Color.WHITE);
		}
		return menuItemEntregaConsultar;
	}

	public JMenuItem getMenuItemEntregaGerenciar() {
		if(menuItemEntregaGerenciar == null) {
			menuItemEntregaGerenciar = new JMenuItem("Gerenciar");
			menuItemEntregaGerenciar.setForeground(Color.BLACK);
			menuItemEntregaGerenciar.setFont(new Font("Arial", Font.PLAIN, 16));
			menuItemEntregaGerenciar.setBackground(Color.WHITE);
		}
		return menuItemEntregaGerenciar;
	}
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	public JLabel getLabelPaginaInicial() {
		if (labelPaginaInicial == null) {
			labelPaginaInicial = new JLabel(" P\u00E1gina Inicial");
			labelPaginaInicial.setFont(new Font("Arial", Font.BOLD, 22));
			labelPaginaInicial.setBounds(0, 0, 243, 30);
		}
		return labelPaginaInicial;
	}

	public JLabel getLabelLogo() {
		if(labelLogo == null) {
			imagemSistema = new ImageIcon("fundoLogoSistema.png");
			labelLogo = new JLabel(imagemSistema);
			labelLogo.setBounds(258, 136, 535, 520);
		}
		return labelLogo;
	}

	
}
