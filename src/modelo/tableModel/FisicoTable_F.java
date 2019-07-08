package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.Banco;
import modelo.cadastros.funcionario.Cargo;
import modelo.cadastros.funcionario.ModeloFuncionario;

public class FisicoTable_F extends AbstractTableModel{
		private	ArrayList<ModeloFuncionario> lista;
		private String[] colunas = new String[]{"CPF","Nome","Endereço", "Telefone"};
		
		public FisicoTable_F() {
			this.lista = new ArrayList<>();		
		}	
		
		public void add_tabela(ModeloFuncionario funcionario) {
			this.lista.add(funcionario);
			fireTableDataChanged();
		}	
				
		public void remover_tabela(int linhaIndice) {
			this.lista.remove(linhaIndice);
			fireTableDataChanged();
		}
		
		public ModeloFuncionario getFuncionario(int linhaIndice) {
			return this.lista.get(linhaIndice);
		}
		
		public ArrayList<ModeloFuncionario> getArray() {
			return lista;
		}
		
		public void setArray(ArrayList<ModeloFuncionario> funcionarios) {
			this.lista = funcionarios;
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
			return this.lista.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			switch (coluna) {
			case 0://coluna cpf
				return this.lista.get(linha).getCpf();
			case 1://coluna nome
				return this.lista.get(linha).getNome();		
			case 2://coluna endereço(logradouro)
				return this.lista.get(linha).getLogradouro();
			case 3://coluna telefone
				return this.lista.get(linha).getTelefone();
			default:
				return this.lista.get(linha);
			} 
		}
	

}
