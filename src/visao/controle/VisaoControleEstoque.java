package visao.controle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class VisaoControleEstoque extends JPanel {
	private JLabel lblTipoDaMovimentacao;
	private JLabel lblDescrioDaOperacao;
	private JLabel lblFornecedor;
	private JLabel lblNome;
	private JLabel lblCpfCnpj;
	private JLabel lblData;
	private JLabel lblItem;
	private JLabel lblCodId;
	private JLabel lblDescricao;
	private JLabel lblQuantidade;
	private JLabel lblValor;
	private JLabel labelControleDeEstoque;
	private JComboBox comboBoxTipoMovimentação;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAno;
	private JTextField textFieldDescricaoOperacao;
	private JTextField textFieldNomeFornecedor;
	private JTextField textFieldCpfCnpjFornecedor;
	private JTextField textFieldCodigoId;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	private JButton btnBuscarDados;
	private JButton btnIncluir;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JButton btnFechar;
	private JTextArea textAreaDetalhes;
	private JScrollPane scrollPane;
	private JSeparator separator;

	public VisaoControleEstoque() {
		super();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(252, 246, 229));
		setLayout(null);
		setMinimumSize(new Dimension(1055, 335));
		setMaximumSize(new Dimension(1055, 335));
		add(getLblTipoDaMovimentacao());
		add(getLblDescrioDaOperacao());
		add(getLblFornecedor());
		add(getLblNome());
		add(getLblCpfCnpj());
		add(getLblData());
		add(getLblItem());
		add(getLblCodId());
		add(getLblDescricao());
		add(getLblQuantidade());
		add(getLblValor());
		add(getLabelControleDeEstoque());
		add(getComboBoxTipoMovimentação());
		add(getComboBoxDia());
		add(getComboBoxMes());
		add(getComboBoxAno());
		add(getTextFieldDescricaoOperacao());
		add(getTextFieldNomeFornecedor());
		add(getTextFieldCpfCnpjFornecedor());
		add(getTextFieldCodigoId());
		add(getTextFieldDescricao());
		add(getTextFieldQuantidade());
		add(getTextFieldValor());
		add(getBtnBuscarDados());
		add(getBtnIncluir());
		add(getBtnExcluir());
		add(getBtnPesquisar());
		add(getBtnCancelar());
		add(getBtnConfirmar());
		add(getBtnFechar());
		add(getScrollPane());
		add(getSeparator());
		
	}
	public JLabel getLblTipoDaMovimentacao() {
		if (lblTipoDaMovimentacao == null) {
			lblTipoDaMovimentacao = new JLabel("Tipo da Movimenta\u00E7\u00E3o:");
			lblTipoDaMovimentacao.setForeground(Color.BLACK);
			lblTipoDaMovimentacao.setFont(new Font("Arial", Font.PLAIN, 16));
			lblTipoDaMovimentacao.setBounds(10, 41, 175, 20);
		}
		return lblTipoDaMovimentacao;
	}
	public JLabel getLblDescrioDaOperacao() {
		if (lblDescrioDaOperacao == null) {
			lblDescrioDaOperacao = new JLabel("Descri\u00E7\u00E3o da Opera\u00E7\u00E3o:");
			lblDescrioDaOperacao.setForeground(Color.BLACK);
			lblDescrioDaOperacao.setFont(new Font("Arial", Font.PLAIN, 16));
			lblDescrioDaOperacao.setBounds(10, 82, 175, 20);
		}
		return lblDescrioDaOperacao;
	}
	public JLabel getLblFornecedor() {
		if (lblFornecedor == null) {
			lblFornecedor = new JLabel("Fornecedor:");
			lblFornecedor.setForeground(Color.BLACK);
			lblFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			lblFornecedor.setBounds(10, 120, 116, 20);
		}
		return lblFornecedor;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNome.setBounds(10, 158, 175, 20);
		}
		return lblNome;
	}
	public JLabel getLblCpfCnpj() {
		if (lblCpfCnpj == null) {
			lblCpfCnpj = new JLabel("CPF/CNPJ n\u00BA:");
			lblCpfCnpj.setForeground(Color.BLACK);
			lblCpfCnpj.setFont(new Font("Arial", Font.PLAIN, 16));
			lblCpfCnpj.setBounds(566, 158, 219, 20);
		}
		return lblCpfCnpj;
	}
	public JLabel getLblData() {
		if (lblData == null) {
			lblData = new JLabel("Data:");
			lblData.setForeground(Color.BLACK);
			lblData.setFont(new Font("Arial", Font.PLAIN, 16));
			lblData.setBounds(10, 217, 52, 20);
		}
		return lblData;
	}
	public JLabel getLblItem() {
		if (lblItem == null) {
			lblItem = new JLabel("Item:");
			lblItem.setForeground(Color.BLACK);
			lblItem.setFont(new Font("Arial", Font.PLAIN, 16));
			lblItem.setBounds(449, 217, 66, 20);
		}
		return lblItem;
	}
	public JLabel getLblCodId() {
		if (lblCodId == null) {
			lblCodId = new JLabel("Cod. ID:");
			lblCodId.setForeground(Color.BLACK);
			lblCodId.setFont(new Font("Arial", Font.PLAIN, 16));
			lblCodId.setBounds(10, 256, 175, 20);
		}
		return lblCodId;
	}
	public JLabel getLblDescricao() {
		if (lblDescricao == null) {
			lblDescricao = new JLabel("Descri\u00E7\u00E3o");
			lblDescricao.setForeground(Color.BLACK);
			lblDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
			lblDescricao.setBounds(189, 256, 340, 20);
		}
		return lblDescricao;
	}
	public JLabel getLblQuantidade() {
		if (lblQuantidade == null) {
			lblQuantidade = new JLabel("Quantidade:");
			lblQuantidade.setForeground(Color.BLACK);
			lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 16));
			lblQuantidade.setBounds(613, 256, 122, 20);
		}
		return lblQuantidade;
	}
	public JLabel getLblValor() {
		if (lblValor == null) {
			lblValor = new JLabel("Valor:");
			lblValor.setForeground(Color.BLACK);
			lblValor.setFont(new Font("Arial", Font.PLAIN, 16));
			lblValor.setBounds(760, 256, 86, 20);
		}
		return lblValor;
	}
	public JLabel getLabelControleDeEstoque() {
		if (labelControleDeEstoque == null) {
			labelControleDeEstoque = new JLabel(" Controle de Estoque");
			labelControleDeEstoque.setBorder(new LineBorder(new Color(0, 0, 0)));
			labelControleDeEstoque.setForeground(Color.BLACK);
			labelControleDeEstoque.setFont(new Font("Arial", Font.BOLD, 22));
			labelControleDeEstoque.setBounds(0, 0, 1055, 30);
		}
		return labelControleDeEstoque;
	}
	public JComboBox getComboBoxTipoMovimentação() {
		if (comboBoxTipoMovimentação == null) {
			comboBoxTipoMovimentação = new JComboBox();
			comboBoxTipoMovimentação.setBackground(Color.WHITE);
			comboBoxTipoMovimentação.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Entrada", "Sa\u00EDda"}));
			comboBoxTipoMovimentação.setForeground(Color.BLACK);
			comboBoxTipoMovimentação.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxTipoMovimentação.setBounds(195, 41, 116, 20);
		}
		return comboBoxTipoMovimentação;
	}
	public JComboBox getComboBoxDia() {
		if (comboBoxDia == null) {
			comboBoxDia = new JComboBox();
			comboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBoxDia.setBackground(Color.WHITE);
			comboBoxDia.setForeground(Color.BLACK);
			comboBoxDia.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxDia.setBounds(60, 217, 66, 20);
		}
		return comboBoxDia;
	}
	public JComboBox getComboBoxMes() {
		if (comboBoxMes == null) {
			comboBoxMes = new JComboBox();
			comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
			comboBoxMes.setBackground(Color.WHITE);
			comboBoxMes.setForeground(Color.BLACK);
			comboBoxMes.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxMes.setBounds(136, 217, 127, 20);
		}
		return comboBoxMes;
	}
	public JComboBox getComboBoxAno() {
		if (comboBoxAno == null) {
			comboBoxAno = new JComboBox();
			comboBoxAno.setBackground(Color.WHITE);
			comboBoxAno.setForeground(Color.BLACK);
			comboBoxAno.setFont(new Font("Arial", Font.PLAIN, 16));
			comboBoxAno.setBounds(273, 217, 80, 20);
		}
		return comboBoxAno;
	}
	public JTextField getTextFieldDescricaoOperacao() {
		if (textFieldDescricaoOperacao == null) {
			textFieldDescricaoOperacao = new JTextField();
			textFieldDescricaoOperacao.setForeground(Color.BLACK);
			textFieldDescricaoOperacao.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldDescricaoOperacao.setBounds(195, 82, 585, 20);
			textFieldDescricaoOperacao.setColumns(10);
		}
		return textFieldDescricaoOperacao;
	}
	public JTextField getTextFieldNomeFornecedor() {
		if (textFieldNomeFornecedor == null) {
			textFieldNomeFornecedor = new JTextField();
			textFieldNomeFornecedor.setForeground(Color.BLACK);
			textFieldNomeFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldNomeFornecedor.setBounds(10, 179, 519, 20);
			textFieldNomeFornecedor.setColumns(10);
		}
		return textFieldNomeFornecedor;
	}
	public JTextField getTextFieldCpfCnpjFornecedor() {
		if (textFieldCpfCnpjFornecedor == null) {
			textFieldCpfCnpjFornecedor = new JTextField();
			textFieldCpfCnpjFornecedor.setForeground(Color.BLACK);
			textFieldCpfCnpjFornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldCpfCnpjFornecedor.setBounds(566, 179, 280, 20);
			textFieldCpfCnpjFornecedor.setColumns(10);
		}
		return textFieldCpfCnpjFornecedor;
	}
	public JTextField getTextFieldCodigoId() {
		if (textFieldCodigoId == null) {
			textFieldCodigoId = new JTextField();
			textFieldCodigoId.setForeground(Color.BLACK);
			textFieldCodigoId.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldCodigoId.setBounds(10, 276, 157, 20);
			textFieldCodigoId.setColumns(10);
		}
		return textFieldCodigoId;
	}
	public JTextField getTextFieldDescricao() {
		if (textFieldDescricao == null) {
			textFieldDescricao = new JTextField();
			textFieldDescricao.setForeground(Color.BLACK);
			textFieldDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldDescricao.setBounds(189, 276, 340, 20);
			textFieldDescricao.setColumns(10);
		}
		return textFieldDescricao;
	}
	public JTextField getTextFieldQuantidade() {
		if (textFieldQuantidade == null) {
			textFieldQuantidade = new JTextField();
			textFieldQuantidade.setForeground(Color.BLACK);
			textFieldQuantidade.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldQuantidade.setBounds(613, 276, 86, 20);
			textFieldQuantidade.setColumns(10);
		}
		return textFieldQuantidade;
	}
	public JTextField getTextFieldValor() {
		if (textFieldValor == null) {
			textFieldValor = new JTextField();
			textFieldValor.setForeground(Color.BLACK);
			textFieldValor.setFont(new Font("Arial", Font.PLAIN, 16));
			textFieldValor.setBounds(760, 276, 86, 20);
			textFieldValor.setColumns(10);
		}
		return textFieldValor;
	}
	public JButton getBtnBuscarDados() {
		if (btnBuscarDados == null) {
			btnBuscarDados = new JButton("Buscar Dados");
			btnBuscarDados.setBackground(Color.WHITE);
			btnBuscarDados.setForeground(Color.BLACK);
			btnBuscarDados.setFont(new Font("Arial", Font.PLAIN, 16));
			btnBuscarDados.setBounds(126, 120, 157, 20);
		}
		return btnBuscarDados;
	}
	public JButton getBtnIncluir() {
		if (btnIncluir == null) {
			btnIncluir = new JButton("Incluir");
			btnIncluir.setBackground(Color.WHITE);
			btnIncluir.setForeground(Color.BLACK);
			btnIncluir.setFont(new Font("Arial", Font.PLAIN, 16));
			btnIncluir.setBounds(189, 329, 127, 24);
		}
		return btnIncluir;
	}
	public JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setBackground(Color.WHITE);
			btnExcluir.setForeground(Color.BLACK);
			btnExcluir.setFont(new Font("Arial", Font.PLAIN, 16));
			btnExcluir.setBounds(326, 329, 127, 24);
		}
		return btnExcluir;
	}
	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBackground(Color.WHITE);
			btnPesquisar.setForeground(Color.BLACK);
			btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnPesquisar.setBounds(495, 216, 143, 23);
		}
		return btnPesquisar;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setForeground(Color.BLACK);
			btnCancelar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnCancelar.setBounds(619, 666, 127, 24);
		}
		return btnCancelar;
	}
	public JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBackground(Color.WHITE);
			btnConfirmar.setForeground(Color.BLACK);
			btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnConfirmar.setBounds(756, 666, 127, 24);
		}
		return btnConfirmar;
	}
	public JButton getBtnFechar() {
		if (btnFechar == null) {
			btnFechar = new JButton("Fechar");
			btnFechar.setBackground(Color.WHITE);
			btnFechar.setForeground(Color.BLACK);
			btnFechar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnFechar.setBounds(893, 666, 127, 24);
		}
		return btnFechar;
	}
	public JTextArea getTextAreaDetalhes() {
		if (textAreaDetalhes == null) {
			textAreaDetalhes = new JTextArea();
			textAreaDetalhes.setBackground(Color.WHITE);
			textAreaDetalhes.setBounds(23, 500, 726, 198);
		}
		return textAreaDetalhes;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 404, 1010, 227);
			scrollPane.add(getTextAreaDetalhes());
		}
		return scrollPane;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(0, 376, 1055, 30);
		}
		return separator;
	}
}
