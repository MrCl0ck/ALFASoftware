package visao.cadastros.cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import modelo.tableModel.FisicoTable;
import modelo.tableModel.JuridicoTable;
import visao.VisaoTelaPesquisa;

public class VisaoTelaCadastroCliente extends JPanel {
	private JLabel 					labelTipoCliente		 		= null;
	private JLabel 					labelPaginaCadastroCliente		= null;
	private JComboBox<String> 		comboBoxTipoCliente		 		= null;
	private JSeparator 				separatorTitulo		 			= null;
	private VisaoTelaPesquisa 		telaPesquisa		 			= null;
	private FisicoTable 		buscaExibicaoTableModelFisico	= null;
	private JuridicoTable 	buscaExibicaoTableModelJuridico	= null;
	private VisaoTelaCadastroClientePessoaFisica fisica;
	private VisaoTelaCadastroClientePessoaJuridica juridica;
	private JPanel panel;
	
	public VisaoTelaCadastroCliente() {		
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(804, 770));
		setMaximumSize(new Dimension(804, 770));
		add(getLabelPaginaCadastroCliente());	
		add(getTelaPesquisa());
		add(getPanel());
	}
	public JLabel getLabelTipoCliente() {
		if (labelTipoCliente == null) {
			labelTipoCliente = new JLabel("Tipo:");
			labelTipoCliente.setBackground(Color.WHITE);
			labelTipoCliente.setForeground(Color.BLACK);
			labelTipoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
			labelTipoCliente.setBounds(10, 41, 46, 17);
		}
		return labelTipoCliente;
	}
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	public JLabel getLabelPaginaCadastroCliente() {
		if (labelPaginaCadastroCliente == null) {
			labelPaginaCadastroCliente = new JLabel(" Cadastro de Cliente");
			labelPaginaCadastroCliente.setFont(new Font("Arial", Font.BOLD, 22));
			labelPaginaCadastroCliente.setBounds(0, 0, 606, 30);
		}
		return labelPaginaCadastroCliente;
	}
	public JComboBox<String> getComboBoxTipoCliente() {
		if (comboBoxTipoCliente == null) {
			comboBoxTipoCliente = new JComboBox<String>();
			comboBoxTipoCliente.setBackground(Color.WHITE);
			comboBoxTipoCliente.setForeground(Color.BLACK);
			comboBoxTipoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTipoCliente.setBounds(50, 39, 145, 20);
			comboBoxTipoCliente.addItem("Selecione");
			comboBoxTipoCliente.addItem("Pessoa Física");
			comboBoxTipoCliente.addItem("Pessoa Jurídica");
		}
		return comboBoxTipoCliente;
	}
	
	public VisaoTelaPesquisa getTelaPesquisa() {
		if(telaPesquisa == null) {
			telaPesquisa = new VisaoTelaPesquisa();
			telaPesquisa.getButtonFechar().setLocation(832, 321);
			telaPesquisa.getButtonConfirmar().setLocation(683, 321);
			telaPesquisa.getButtonCancelar().setLocation(539, 321);
			telaPesquisa.getButtonAlterar().setLocation(388, 321);
			telaPesquisa.getButtonExcluir().setLocation(233, 321);
			telaPesquisa.getButtonIncluir().setLocation(85, 321);
			telaPesquisa.getButtonBuscar().setSize(135, 24);
			telaPesquisa.getComboBoxTipoPesquisa().setSize(163, 20);
			telaPesquisa.getComboBoxTipoPesquisa().setLocation(59, 41);
			telaPesquisa.getTextFieldEntradaDado().setLocation(270, 41);
			telaPesquisa.getButtonBuscar().setLocation(789, 41);
			telaPesquisa.getSeparatorBotoes().setSize(1058, 48);
			telaPesquisa.getSeparatorBotoes().setLocation(0, 308);
			telaPesquisa.getDadosJScrollPane().setBounds(48, 89, 905, 208);
			telaPesquisa.getSeparatorPesquisa().setBounds(0, 74, 1058, 20);
			telaPesquisa.setBounds(0,334, 1058, 357);
		}
		return telaPesquisa;
	}
	
	public FisicoTable getBuscaExibicaoTableModelFisico(boolean consulta) {
		if(consulta == true) {
			return buscaExibicaoTableModelFisico;
		}
		else{
			buscaExibicaoTableModelFisico = new FisicoTable();
			
			return buscaExibicaoTableModelFisico;
		}		
	}
	
	public JuridicoTable getBuscaExibicaoTableModelJuridico(boolean consulta) {
		if(consulta == true) {
			return buscaExibicaoTableModelJuridico;
		}
		else{
			buscaExibicaoTableModelJuridico = new JuridicoTable();
			
			return buscaExibicaoTableModelJuridico;
		}		
	}
	
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(252, 246, 229));
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(0, 0, 1055, 335);
			panel.setLayout(null);
			panel.add(getComboBoxTipoCliente());
			panel.add(getLabelTipoCliente());
			panel.add(getSeparatorTitulo());
		}
		return panel;
	}
	
	public VisaoTelaCadastroClientePessoaFisica getTelaFisica()
	{
		if(fisica==null)
		{
			fisica = new VisaoTelaCadastroClientePessoaFisica();
			fisica.setBounds(0,0,1055,335);
		}
		return fisica;
	}
	
	public VisaoTelaCadastroClientePessoaJuridica getTelaJuridica()
	{
		if(juridica==null)
		{
			juridica = new VisaoTelaCadastroClientePessoaJuridica();
			juridica.setBounds(0,0,1055,335);
		}
		return juridica;
	}
	
	public void removePanel() {
		this.remove(panel);
	}
	
	public void removeTelaPesquisa() {
		this.remove(telaPesquisa);
	}
	
	public void removeTelaFisica() {
		this.remove(fisica);
	}
	
	public void removeTelaJuridica() {
		this.remove(juridica);
	}
}
