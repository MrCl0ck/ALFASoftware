package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.cadastros.fornecedor.ModeloFornecedorFisica;

public class FisicoTable_Fornecedor extends AbstractTableModel{
	private	ArrayList<ModeloFornecedorFisica> listaFornecedoresFisico;
	private String[] colunas = new String[]{"CPF","Nome","Endereço", "Telefone"};
	
	public FisicoTable_Fornecedor () {
		this.listaFornecedoresFisico = new ArrayList<>();		
	}	
	
	public void addFornecedor(ModeloFornecedorFisica fornecedor) {
		this.listaFornecedoresFisico.add(fornecedor);
		fireTableDataChanged();
	}	
	
	public void removerFornecedor(int linhaIndice) {
		this.listaFornecedoresFisico.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloFornecedorFisica getFornecedor(int linhaIndice) {
		return this.listaFornecedoresFisico.get(linhaIndice);
	}
	
	public ArrayList<ModeloFornecedorFisica> getFornecedorArray() {
		return listaFornecedoresFisico;
	}
	
	public void setFornecedorArray(ArrayList<ModeloFornecedorFisica> fornecedores) {
		this.listaFornecedoresFisico = fornecedores;
	}
	
	
	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaFornecedoresFisico.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0://coluna cpf
			return this.listaFornecedoresFisico.get(linha).getCpf();
		case 1://coluna nome
			return this.listaFornecedoresFisico.get(linha).getNome();		
		case 2://coluna endereço(logradouro)
			return this.listaFornecedoresFisico.get(linha).getLogradouro();
		case 3://coluna telefone
			return this.listaFornecedoresFisico.get(linha).getTelefone();
		default:
			return this.listaFornecedoresFisico.get(linha);
		} 
	}
}
