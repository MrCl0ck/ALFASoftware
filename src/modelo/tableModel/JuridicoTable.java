package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;

public class JuridicoTable extends AbstractTableModel{
	
	private	ArrayList<ModeloClientePessoaJuridica> listaClientesJuridico;
	private String[] colunas = new String[]{"CNPJ","Razao Social","Endereço", "Telefone"};
	
	public JuridicoTable () {
		this.listaClientesJuridico = new ArrayList<>();		
	}
		
	public void addCliente(ModeloClientePessoaJuridica disciplina) {
		this.listaClientesJuridico.add(disciplina);
		fireTableDataChanged();
	}	
	
	public void removerCliente(int linhaIndice) {
		this.listaClientesJuridico.remove(linhaIndice);
		fireTableDataChanged();
	}
	
	public ModeloClientePessoaJuridica getCliente(int linhaIndice) {
		return this.listaClientesJuridico.get(linhaIndice);
	}
	
	public ArrayList<ModeloClientePessoaJuridica> getClienteArray() {
		return listaClientesJuridico;
	}
	
	public void setClienteArray(ArrayList<ModeloClientePessoaJuridica> clientes) {
		this.listaClientesJuridico = clientes;
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
		return this.listaClientesJuridico.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0://coluna cpf
			return this.listaClientesJuridico.get(linha).getCnpj();
		case 1://coluna nome
			return this.listaClientesJuridico.get(linha).getRazaoSocial();		
		case 2://coluna endereço(logradouro)
			return this.listaClientesJuridico.get(linha).getLogradouro();
		case 3://coluna telefone
			return this.listaClientesJuridico.get(linha).getTelefone();
		default:
			return this.listaClientesJuridico.get(linha);
		} 
	}
}
