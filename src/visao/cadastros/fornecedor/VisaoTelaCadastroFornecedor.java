//package visao.cadastros.fornecedor;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.LayoutManager;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.border.LineBorder;
//
//public class VisaoTelaCadastroFornecedor extends JPanel {
//	private JLabel labelTipoFornecedor;
//	private JLabel labelPaginaCadastroFornecedor;
//	private JComboBox<String> comboBoxTipoFornecedor;
//	private JSeparator separatorTitulo;
//	
//	public VisaoTelaCadastroFornecedor() {
//		setLayout(null);
//		setBorder(new LineBorder(new Color(0, 0, 0)));
//		setBackground(new Color(252, 246, 229));
//		setMinimumSize(new Dimension(1055, 720));
//		setMaximumSize(new Dimension(1055, 720));
//		add(getComboBoxTipoFornecedor());
//		add(getLabelTipoFornecedor());
//		add(getSeparatorTitulo());
//		add(getLabelPaginaCadastroFornecedor());
//	}
//	
//	public JLabel getLabelTipoFornecedor() {
//		if (labelTipoFornecedor == null) {
//			labelTipoFornecedor = new JLabel("Tipo:");
//			labelTipoFornecedor.setBackground(Color.WHITE);
//			labelTipoFornecedor.setForeground(Color.BLACK);
//			labelTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 15));
//			labelTipoFornecedor.setBounds(10, 41, 46, 17);
//		}
//		return labelTipoFornecedor;
//	}
//	public JSeparator getSeparatorTitulo() {
//		if (separatorTitulo == null) {
//			separatorTitulo = new JSeparator();
//			separatorTitulo.setForeground(Color.BLACK);
//			separatorTitulo.setBounds(0, 30, 1500, 22);
//		}
//		return separatorTitulo;
//	}
//	public JLabel getLabelPaginaCadastroFornecedor() {
//		if (labelPaginaCadastroFornecedor == null) {
//			labelPaginaCadastroFornecedor = new JLabel(" Cadastro de Fornecedor");
//			labelPaginaCadastroFornecedor.setFont(new Font("Arial", Font.BOLD, 22));
//			labelPaginaCadastroFornecedor.setBounds(0, 0, 336, 30);
//		}
//		return labelPaginaCadastroFornecedor;
//	}
//	public JComboBox<String> getComboBoxTipoFornecedor() {
//		if (comboBoxTipoFornecedor == null) {
//			comboBoxTipoFornecedor = new JComboBox<String>();
//			comboBoxTipoFornecedor.setBackground(Color.WHITE);
//			comboBoxTipoFornecedor.setForeground(Color.BLACK);
//			comboBoxTipoFornecedor.setFont(new Font("Arial", Font.PLAIN, 15));
//			comboBoxTipoFornecedor.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa F\u00EDsica", "Pessoa Jur\u00EDdica"}));		
//			comboBoxTipoFornecedor.setBounds(10, 61, 123, 20);
//		}
//		return comboBoxTipoFornecedor;
//	}
//
//}
