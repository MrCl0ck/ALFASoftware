package modelo.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.Banco;
import modelo.cadastros.funcionario.Cargo;
import modelo.cadastros.funcionario.ModeloFuncionario;
import modelo.cadastros.produto.ModeloProduto;

public class ProdutoTable extends AbstractTableModel{
		private	ArrayList<ModeloProduto> lista;
		private String[] colunas = new String[]{"Código","Descrição","Código de Barras", "Quantidade"};
		
		public ProdutoTable() {
			this.lista = new ArrayList<>();		
		}	
		
		public void add_tabela(ModeloProduto produto) {
			this.lista.add(produto);
			fireTableDataChanged();
		}	
				
		public void remover_tabela(int linhaIndice) {
			this.lista.remove(linhaIndice);
			fireTableDataChanged();
		}
		
		public ModeloProduto getProduto(int linhaIndice) {
			return this.lista.get(linhaIndice);
		}
		
		public ArrayList<ModeloProduto> getArray() {
			return lista;
		}
		
		public void setArray(ArrayList<ModeloProduto> produtos) {
			this.lista = produtos;
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
				return this.lista.get(linha).getCodigo();
			case 1://coluna nome
				return this.lista.get(linha).getDescricao();
			case 2://coluna endereço(logradouro)
				return this.lista.get(linha).getCodigoDeBarras();
			case 3://coluna telefone
				return this.lista.get(linha).getQuantidade();
			default:
				return this.lista.get(linha);
			} 
		}
	

}
