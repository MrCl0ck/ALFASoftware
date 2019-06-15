package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.funcionario.ModeloFuncionario;
import modelo.cadastros.produto.ModeloProduto;

public class DadosProduto {

	private static ProdutoTable ProdutoTabela = new ProdutoTable();
	private static Banco banco = new Banco();
	
	public DadosProduto() {
		getProdutos();
		getProdutosNaTabela();
	}

	// ------------------------------------FUNÇÕES
		// TABELA-------------------------------------------------------------

		public void bancoDeDadosIncluir(ModeloProduto produto) {
			boolean retornoFuncao = false;

			try {
				retornoFuncao = banco.inserir("tipo", "`nome`", produto.getTipo());

				String idTipo = banco.primeiroEultimo("tipo", "id", 1);

				retornoFuncao = banco.inserir("unidade", "`nome`", produto.getUnidade());

				String idUnidade = banco.primeiroEultimo("unidade", "id", 1);

				retornoFuncao = banco.inserir("produto",
						"`codigobarras`, `descricao`, `valorcompra`, `valorvenda`, `lucro`, `estoqueminimo`, `estoquemaximo`, `UNIDADE_id`, `TIPO_id`",
						"'" + produto.getCodigoDeBarras() + "','" + produto.getDescricao() + "','" + produto.getValorDaCompra() + "','"
								+ produto.getValorDaVenda() + "','" + produto.getLucro() + "','"
								+ produto.getEstoqueMinimo() + "','" + produto.getEstoqueMaximo() + "','" + idUnidade
								+ "','" + idTipo + "'");
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Cadastrado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		public void bancoDeDadosAlterar(ModeloProduto produtoAtual, String codigoBusca, String idBuscaUnidade,
				String idBuscaTipo) {
			boolean retornoFuncao = false;

			retornoFuncao = banco.atualizar("produto", "codigo", codigoBusca,
					"codigo='" + produtoAtual.getCodigo() + "',codigobarras='" + produtoAtual.getCodigoDeBarras() + "',descricao='"
							+ produtoAtual.getDescricao() + "',valorcompra='" + produtoAtual.getValorDaCompra() + "',valorvenda='"
							+ produtoAtual.getValorDaVenda() + "',lucro='" + produtoAtual.getLucro() + "',estoqueminimo='"
							+ produtoAtual.getEstoqueMinimo() + "',estoquemaximo='" + produtoAtual.getEstoqueMaximo() +  "'");

			retornoFuncao = banco.atualizar("unidade", "id", idBuscaUnidade,
					"nome='" + produtoAtual.getUnidade() + "'");
			
			retornoFuncao = banco.atualizar("tipo", "id", idBuscaTipo,
					"nome='" + produtoAtual.getTipo() + "'");

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Alteração do registro de produto feita com sucesso!", "Alteração",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		public boolean bancoDeDadosExcluir(String codigoBusca, String idBuscaUnidade, String idBuscaTipo) {
			boolean retornoFuncao = false;

			retornoFuncao = banco.excluir("produto", "codigo", codigoBusca);
			retornoFuncao = banco.excluir("unidade", "id", idBuscaUnidade);
			retornoFuncao = banco.excluir("tipo", "id", idBuscaTipo);

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Exclusão do registro de produto feita com sucesso!", "Exclusão",
						JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				return false;
			}
		}
		// ---------------------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES
		// TABELA-------------------------------------------------------------

		public void adicionarProdutoTabela(ModeloProduto produto) {
			produtoTabela.addProduto(produto);
		}

		public ProdutoTable getProdutosNaTabela() {
			return produtosTabela;
		}

		// ---------------------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES
		// ARRAYLIST-------------------------------------------------------------

		// -------------------------------------------------------------------------------------------------

		// GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE
		// DADOS E ATUALIZA.

		public ArrayList<ModeloProduto> getProdutos() {
			return banco.consultarProduto();
		}

		public static void setProdutos() {
			banco.consultarProduto();
		}

		// -------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES DE
		// PESQUISA-------------------------------------------------------------

		public static ModeloProduto buscaArrayGeralPorCodigo(ModeloProduto produtoASerBuscado) {
			for (ModeloProduto u : banco.consultarProduto()) {
				if (u.getCodigo().equals(produtoASerBuscado.getCodigo())) {
					return u;
				}
			}
			return null;
		}

		public static ModeloProduto buscaArrayGeralDescricao(ModeloProduto produtoASerBuscado) {
			for (ModeloProduto u : banco.consultarProduto()) {
				if (u.getDescricao().equals(produtoASerBuscado.getDescricao())) {
					return u;
				}
			}
			return null;
		}
}
