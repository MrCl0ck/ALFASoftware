package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.dados.DadosProduto;
import modelo.cadastros.produto.ModeloProduto;

public class ValidacaoProduto {
		private ModeloProduto produto;
		private boolean res_val_geral;
		private boolean result_codigos;

		public boolean isRes_val_geral() {
			return res_val_geral;
		}

		public void setRes_val_geral(boolean res_val_geral) {
			this.res_val_geral = res_val_geral;
		}

		public boolean isResult_codigos() {
			return result_codigos;
		}

		public void setResult_codigos(boolean result_codigos) {
			this.result_codigos = result_codigos;
		}

		public ValidacaoProduto(ModeloProduto produto) {
			this.produto = produto;
			setRes_val_geral(validacaoTodosCamposGeral());	
		}
		
		public boolean validacaoTodosCamposGeral() {
			boolean resultado = true;
			String errosConcatenados = "";
			
			//GERAL
			if(produto.getCodigo().trim().equals("")) {
				errosConcatenados += "Preencha o campo 'Código'!\n";
				resultado = false;
			}
			if(produto.getCodigoDeBarras().trim().equals("")) {//----------------------
				errosConcatenados += "Preencha o campo 'Código de Barras'!\n";
				resultado = false;
			}
			if(produto.getDescricao().trim().equals("")) {//---------------------
				errosConcatenados += "Preencha o campo 'Descrição'!\n";
				resultado = false;
			}
			if(produto.getValorDaCompra() == -1) {
				errosConcatenados += "Preencha o campo 'Valor da Compra'!\n";
				resultado = false;
			}
			if(produto.getValorDaVenda() == -1) {
				errosConcatenados += "Preencha o campo 'Órgão Expeditor'!\n";
				resultado = false;
			}
			if(produto.getLucro() == -1) {
				errosConcatenados += "Preencha o campo 'Nacionalidade'!\n";
				resultado = false;
			}
			if(produto.getUnidade().equals("Selecione")) {
				errosConcatenados += "Escolha uma opção da lista 'Unidade'!\n";
				resultado = false;
			}	
			if(produto.getTipo().equals("Selecione")) {
				errosConcatenados += "Escolha uma opção da lista 'Tipo'!\n";
				resultado = false;
			}
			if(produto.getEstoqueMinimo() == -1) {
				errosConcatenados += "Preencha o campo 'Estoque Mínimo'!\n";
				resultado = false;
			}
			if(produto.getEstoqueMaximo() == -1) {
				errosConcatenados += "Preencha o campo 'Estoque Máximo'!\n";
				resultado = false;
			}
			
			if(resultado == true) {
				return true;
			}
			else {			
				JOptionPane.showMessageDialog(null, errosConcatenados, "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}				
		}
		
		public boolean validacao_codigos() {
			DadosProduto produtos = new DadosProduto();
				
			for (int i = 0; i < produtos.getProdutos().size() ; i++) {
				if(produto.getCodigo().equals(produtos.getProdutos().get(i).getCodigo().toString()) || produto.getCodigoDeBarras().equals(produtos.getProdutos().get(i).getCodigoDeBarras().toString())){
					JOptionPane.showMessageDialog(null, "Este produto já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}		
			
			return true;
		}
}


