package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.cadastros.fornecedor.ModeloFornecedorJuridica;


public class JuridicoTable_Fornecedor extends AbstractTableModel{
	
	private	ArrayList<ModeloFornecedorJuridica> listaFornecedoresJuridico;
	private String[] colunas = new String[]{"CNPJ","Razao Social","Endereço", "Telefone"};
	
	public JuridicoTable_Fornecedor () {
		this.listaFornecedoresJuridico = new ArrayList<>();		
	}
		
	public void addFornecedor(ModeloFornecedorJuridica fornecedores) {
		this.listaFornecedoresJuridico.add(fornecedores);
		fireTableDataChanged();
	}	
	
	public void removerFornecedor(int linhaIndice) {
		this.listaFornecedoresJuridico.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloFornecedorJuridica getFornecedor(int linhaIndice) {
		return this.listaFornecedoresJuridico.get(linhaIndice);
	}
	
	public ArrayList<ModeloFornecedorJuridica> getFornecedorArray() {
		return listaFornecedoresJuridico;
	}
	
	public void setFornecedorArray(ArrayList<ModeloFornecedorJuridica> fornecedores) {
		this.listaFornecedoresJuridico = fornecedores;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaFornecedoresJuridico.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0://coluna cpf
			return this.listaFornecedoresJuridico.get(linha).getCnpj();
		case 1://coluna nome
			return this.listaFornecedoresJuridico.get(linha).getRazaoSocial();		
		case 2://coluna endereço(logradouro)
			return this.listaFornecedoresJuridico.get(linha).getLogradouro();
		case 3://coluna telefone
			return this.listaFornecedoresJuridico.get(linha).getTelefone();
		default:
			return this.listaFornecedoresJuridico.get(linha);
		} 
	}
}
