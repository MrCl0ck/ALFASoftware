package visao.cadastros.fornecedor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import modelo.tableModel.FisicoTable_Fornecedor;
import modelo.tableModel.JuridicoTable_Fornecedor;
import visao.VisaoTelaPesquisa;

public class VisaoTelaCadastroFornecedor extends JPanel {
	private JLabel labelTipoFornecedor;
	private JLabel labelPaginaCadastroFornecedor;
	private JComboBox<String> comboBoxTipoFornecedor;
	private JSeparator separatorTitulo;
	private VisaoTelaPesquisa telaPesquisa;
	private JPanel panel;
	private FisicoTable_Fornecedor buscaExibicaoTableModelFisico;
	private JuridicoTable_Fornecedor buscaExibicaoTableModelJuridico;
	private VisaoTelaCadastroFornecedorPessoaFisica fisica;
	private VisaoTelaCadastroFornecedorPessoaJuridica juridica;

	public VisaoTelaCadastroFornecedor() {
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setMinimumSize(new Dimension(804, 770));
		setMaximumSize(new Dimension(804, 770));
		add(getLabelPaginaCadastroFornecedor());		
		add(getPanel());
		add(getTelaPesquisa());
	}

	public JLabel getLabelTipoFornecedor() {
		if (labelTipoFornecedor == null) {
			labelTipoFornecedor = new JLabel("Tipo:");
			labelTipoFornecedor.setBackground(Color.WHITE);
			labelTipoFornecedor.setForeground(Color.BLACK);
			labelTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 15));
			labelTipoFornecedor.setBounds(10, 41, 46, 17);
		}
		return labelTipoFornecedor;
	}
	public JSeparator getSeparatorTitulo() {
		if (separatorTitulo == null) {
			separatorTitulo = new JSeparator();
			separatorTitulo.setForeground(Color.BLACK);
			separatorTitulo.setBounds(0, 30, 1500, 22);
		}
		return separatorTitulo;
	}
	public JLabel getLabelPaginaCadastroFornecedor() {
		if (labelPaginaCadastroFornecedor == null) {
			labelPaginaCadastroFornecedor = new JLabel(" Cadastro de Fornecedor");
			labelPaginaCadastroFornecedor.setFont(new Font("Arial", Font.BOLD, 22));
			labelPaginaCadastroFornecedor.setBounds(0, 0, 606, 30);
		}
		return labelPaginaCadastroFornecedor;
	}
	public JComboBox<String> getComboBoxTipoFornecedor() {
		if (comboBoxTipoFornecedor == null) {
			comboBoxTipoFornecedor = new JComboBox<String>();
			comboBoxTipoFornecedor.setBackground(Color.WHITE);
			comboBoxTipoFornecedor.setForeground(Color.BLACK);
			comboBoxTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 15));
			comboBoxTipoFornecedor.setBounds(50, 39, 145, 20);
			comboBoxTipoFornecedor.addItem("Selecione");
			comboBoxTipoFornecedor.addItem("Pessoa Física");
			comboBoxTipoFornecedor.addItem("Pessoa Jurídica");
		}
		return comboBoxTipoFornecedor;
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
			telaPesquisa.getSeparatorPesquisa().setBounds(0, 74, 1082, 20);
			telaPesquisa.setBounds(0,334, 1058, 357);
		}
		return telaPesquisa;
	}
	
	public FisicoTable_Fornecedor getBuscaExibicaoTableModelFisico(boolean consulta) {
		if(consulta == true) {
			return buscaExibicaoTableModelFisico;
		}
		else{
			buscaExibicaoTableModelFisico = new FisicoTable_Fornecedor();
			
			return buscaExibicaoTableModelFisico;
		}		
	}
	
	public JuridicoTable_Fornecedor getBuscaExibicaoTableModelJuridico(boolean consulta) {
		if(consulta == true) {
			return buscaExibicaoTableModelJuridico;
		}
		else{
			buscaExibicaoTableModelJuridico = new JuridicoTable_Fornecedor();
			
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
			panel.add(getComboBoxTipoFornecedor());
			panel.add(getLabelTipoFornecedor());
			panel.add(getSeparatorTitulo());
		}
		return panel;
	}
	
	public VisaoTelaCadastroFornecedorPessoaFisica getTelaFisica()
	{
		if(fisica==null)
		{
			fisica = new VisaoTelaCadastroFornecedorPessoaFisica();
			fisica.setBounds(0,0,1055,335);
		}
		return fisica;
	}
	
	public VisaoTelaCadastroFornecedorPessoaJuridica getTelaJuridica()
	{
		if(juridica==null)
		{
			juridica = new VisaoTelaCadastroFornecedorPessoaJuridica();
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
