package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.cadastros.cliente.ModeloClientePessoaFisica;

public class ClienteFisicoTable extends AbstractTableModel{
	private	ArrayList<ModeloClientePessoaFisica> listaClientesFisico;
	private String[] colunas = new String[]{"CPF","Nome","Endereço", "Telefone"};
	
	public ClienteFisicoTable () {
		this.listaClientesFisico = new ArrayList<>();		
	}	
	
	public void addCliente(ModeloClientePessoaFisica cliente) {
		this.listaClientesFisico.add(cliente);
		fireTableDataChanged();
	}	
	
	public void removerCliente(int linhaIndice) {
		this.listaClientesFisico.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloClientePessoaFisica getCliente(int linhaIndice) {
		return this.listaClientesFisico.get(linhaIndice);
	}
	
	public ArrayList<ModeloClientePessoaFisica> getClienteArray() {
		return listaClientesFisico;
	}
	
	public void setClienteArray(ArrayList<ModeloClientePessoaFisica> clientes) {
		this.listaClientesFisico = clientes;
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
		return this.listaClientesFisico.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0://coluna cpf
			return this.listaClientesFisico.get(linha).getCpf();
		case 1://coluna nome
			return this.listaClientesFisico.get(linha).getNome();		
		case 2://coluna endereço(logradouro)
			return this.listaClientesFisico.get(linha).getLogradouro();
		case 3://coluna telefone
			return this.listaClientesFisico.get(linha).getTelefone();
		default:
			return this.listaClientesFisico.get(linha);
		} 
	}
}
