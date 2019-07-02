package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.fornecedor.ModeloFornecedorFisica;
import modelo.tableModel.FisicoTable;

public class DadosFornecedorPessoaFisica {

	private static FornecedorFisicoTable FornecedorTabela = new FornecedorFisicoTable();
	private static Banco banco = new Banco();

	public DadosFornecedorPessoaFisica() {
		getFornecedoresFisicos();
		getFornecedoresNaTabela();
	}

	// ------------------------------------FUNÇÕES TABELA-------------------------------------------------------------

	public void bancoDeDadosIncluir(ModeloFornecedorFisica fornecedorFisico) {
		boolean retornoFuncao = false;

		try {
			retornoFuncao = banco.inserir("endereco", // Tabela, a inserção de email e telefone está sendo feita na
														// tabela de cliente fisico
					"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
					"'" + fornecedorFisico.getCep() + "','" + fornecedorFisico.getNumeroEndereco() + "','"
							+ fornecedorFisico.getLogradouro() + "','" + fornecedorFisico.getBairro() + "','"
							+ fornecedorFisico.getComplemento() + "','" + fornecedorFisico.getCidade() + "','"
							+ fornecedorFisico.getUf_estado() + "'");

			String id = banco.primeiroEultimo("endereco", "id", 1);

			retornoFuncao = banco.inserir("fornecedor",
					"`cpf`, `cnpj`, `nome`, `razaosocial`, `rg`, `representante`, `uf_rg`, `orgaoexpedidor`, `sexo`, `datanasc`, `telefone`, `fax`, `email`, `situacao`, `ramoatividade`, `ENDERECO_id`",
					"'" + fornecedorFisico.getCpf() + "','" + null + "','" + fornecedorFisico.getNome() + "','" + null + "','"
							+ fornecedorFisico.getRg() + "','" + null + "','" + fornecedorFisico.getUfRg() + "','" + fornecedorFisico.getOrgaoExpeditorRg()
							+ "','" + fornecedorFisico.getSexo() + "','" + fornecedorFisico.getDataNascimento() + "','"
							+ fornecedorFisico.getTelefone() + "','" + fornecedorFisico.getFax() + "','"
							+ fornecedorFisico.getEmail() + "','" + fornecedorFisico.getSituacao() + "','"
							+ fornecedorFisico.getRamoAtividade() + "','" + id + "'");
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!", "Cadastrado",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void bancoDeDadosAlterar(ModeloFornecedorFisica fornecedorFisicoAtual, String cpfBusca, String idBusca) {
		boolean retornoFuncao = false;

		retornoFuncao = banco.atualizar("fornecedor", "cpf", cpfBusca,
				"situacao='" + fornecedorFisicoAtual.getSituacao() + "',nome='" + fornecedorFisicoAtual.getNome() + "',cpf='"
						+ fornecedorFisicoAtual.getCpf() + "',datanasc='" + fornecedorFisicoAtual.getDataNascimento()
						+ "',sexo='" + fornecedorFisicoAtual.getSexo() + "',rg='" + fornecedorFisicoAtual.getRg()
						+ "',uf_rg='" + fornecedorFisicoAtual.getUfRg() + "',orgaoexpedidor='"
						+ fornecedorFisicoAtual.getOrgaoExpeditorRg() + "',telefone='" + fornecedorFisicoAtual.getTelefone()
						+ "',email='" + fornecedorFisicoAtual.getEmail() + "',ramoatividade='"
						+ fornecedorFisicoAtual.getRamoAtividade() + "',fax='"
						+ fornecedorFisicoAtual.getFax() + "'");
		
		retornoFuncao = banco.atualizar("endereco", "id", idBusca,
				"cep='" + fornecedorFisicoAtual.getCep() + "',logradouro='" + fornecedorFisicoAtual.getLogradouro()
						+ "',numero='" + fornecedorFisicoAtual.getNumeroEndereco() + "',bairro='"
						+ fornecedorFisicoAtual.getBairro() + "',complemento='" + fornecedorFisicoAtual.getComplemento()
						+ "',cidade='" + fornecedorFisicoAtual.getCidade() + "',uf='" + fornecedorFisicoAtual.getUf_estado()
						+ "'");

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Alteração do registro de fornecedor feita com sucesso!", "Alteração",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean bancoDeDadosExcluir(String cpfBusca, String idBusca) {
		boolean retornoFuncao = false;

		retornoFuncao = banco.excluir("fornecedor", "cpf", cpfBusca);
		retornoFuncao = banco.excluir("endereco", "id", idBusca);

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Exclusão do registro de fornecedor feita com sucesso!", "Exclusão",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			return false;
		}
	}
	// ---------------------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES TABELA-------------------------------------------------------------

	public void adicionarFornecedorTabela(ModeloFornecedorFisica fornecedor) {
		fornecedorTabela.addFornecedor(fornecedor);
	}

	public FornecedorFisicoTable getFornecedoresNaTabela() {
		return fornecedoresTabela;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES ARRAYLIST-------------------------------------------------------------

	// -------------------------------------------------------------------------------------------------

	// GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE DADOS E ATUALIZA.

	public ArrayList<ModeloFornecedorFisica> getFornecedoresFisicos() {
		return banco.consultarFornecedorFisico();
	}

	public static void setFornecedores() {
		banco.consultarFornecedorFisico();
	}

	// -------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES DE PESQUISA-------------------------------------------------------------

	public static ModeloFornecedorFisica buscaArrayGeralPorCpfERg(ModeloFornecedorFisica fornecedorASerBuscado) {
		for (ModeloFornecedorFisica u : banco.consultarFornecedorFisico()) {
			if (u.getCpf().equals(fornecedorASerBuscado.getCpf()) && u.getRg().equals(fornecedorASerBuscado.getRg())) {
				return u;
			}
		}
		return null;
	}

	public static ModeloFornecedorFisica buscaArrayGeralNomeContem(ModeloFornecedorFisica fornecedorASerBuscado) {
		for (ModeloFornecedorFisica u : banco.consultarFornecedorFisico()) {
			if (u.getNome().equals(fornecedorASerBuscado.getNome())) {
				return u;
			}
		}
		return null;
	}
}
