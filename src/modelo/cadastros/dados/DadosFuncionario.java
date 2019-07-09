package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.funcionario.Cargo;
import modelo.cadastros.funcionario.ModeloFuncionario;
import modelo.tableModel.FisicoTable_F;

public class DadosFuncionario {

	private static FisicoTable_F funcionarioTabela = new FisicoTable_F();
	private static Banco banco = new Banco();

	public DadosFuncionario() {
		getFuncionarios();
		getFuncionariosNaTabela();
	}

	// ------------------------------------FUNÇÕES
	// TABELA-------------------------------------------------------------

	public void bancoDeDadosIncluir(ModeloFuncionario funcionario) {
		boolean retornoFuncao = false;

		try {
			retornoFuncao = banco.inserir("endereco", // Tabela, a inserção de email e telefone está sendo feita na
														// tabela de cliente fisico
					"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
					"'" + funcionario.getCep() + "','" + funcionario.getNumeroEndereco() + "','"
							+ funcionario.getLogradouro() + "','" + funcionario.getBairro() + "','"
							+ funcionario.getComplemento() + "','" + funcionario.getCidade() + "','"
							+ funcionario.getUf_estado() + "'");

			String id = banco.primeiroEultimo("endereco", "id", 1);
			
			int ret_id = busca_cargo(funcionario.getCargo().getNomeCargo());
			String idCargo;
			
			if(ret_id == -1) { //retorno indicando que não tem cargo igual na tabela cargo...
				retornoFuncao = banco.inserir("cargo", "`nome`", "'"+funcionario.getCargo().getNomeCargo()+"'");				
				idCargo = banco.primeiroEultimo("cargo", "id", 1);
			}
			else {
				idCargo = String.valueOf(ret_id);
			}			


			retornoFuncao = banco.inserir("funcionario",
					"`cpf`, `nome`, `rg`, `uf_rg`, `orgaoexpedidor`, `dataexpedicao`, `nacionalidade`, `naturalidade`, `datanasc`, `sexo`, `ctps`, `dataadmissao`, `cargo`, `telefone`, `email`, `setor`, `salario`, `usuario`, `senha`, `CARGO_id`, `ENDERECO_id`",
					"'" + funcionario.getCpf() + "','" + funcionario.getNome() + "','" + funcionario.getRg() + "','"
							+ funcionario.getUfRg() + "','" + funcionario.getOrgaoExpeditor() + "','"
							+ funcionario.getDataExpedicaoRg() + "','" + funcionario.getNacionalidade() + "','"
							+ funcionario.getNaturalidade() + "','" + funcionario.getDataDeNascimento() + "','"
							+ funcionario.getSexo() + "','" + funcionario.getCtps() + "','"
							+ funcionario.getDataDeAdmissao() + "','" + funcionario.getCargo().getNomeCargo() + "','" + funcionario.getTelefone() + "','"
							+ funcionario.getEmail() + "','" + funcionario.getSetor() + "','" + funcionario.getSalario()
							+ "','" + funcionario.getNomeDeUsuario() + "','" + funcionario.getSenha() + "','" + idCargo
							+ "','" + id + "'");
		} catch (Exception e) {
			// 
		}

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Cadastrado",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void bancoDeDadosAlterar(ModeloFuncionario funcionarioAtual, String cpfBusca, String idBusca,
			String idBuscaCargo) {
		boolean retornoFuncao = false;

		retornoFuncao = banco.atualizar("funcionario", "cpf", cpfBusca,
				"nome='" + funcionarioAtual.getNome() + "',cpf='" + funcionarioAtual.getCpf() + "',datanasc='"
						+ funcionarioAtual.getDataDeNascimento() + "',sexo='" + funcionarioAtual.getSexo() + "',rg='"
						+ funcionarioAtual.getRg() + "',uf_rg='" + funcionarioAtual.getUfRg() + "',orgaoexpedidor='"
						+ funcionarioAtual.getOrgaoExpeditor() + "',telefone='" + funcionarioAtual.getTelefone()
						+ "',email='" + funcionarioAtual.getEmail() + "',dataexpedicao='"
						+ funcionarioAtual.getDataExpedicaoRg() + "',nacionalidade='" + funcionarioAtual.getNacionalidade() 
						+ "',naturalidade='" + funcionarioAtual.getNaturalidade() + "',ctps='" + funcionarioAtual.getCtps()
						+ "',dataadmissao='" + funcionarioAtual.getDataDeAdmissao() +"',cargo='" +funcionarioAtual.getCargo().getNomeCargo() +"',setor='" + funcionarioAtual.getSetor()
						+ "',salario='" + funcionarioAtual.getSalario() + "',usuario='" + funcionarioAtual.getNomeDeUsuario() 
						+ "',senha='" + funcionarioAtual.getSenha() +  "'");

		retornoFuncao = banco.atualizar("endereco", "id", idBusca,
				"cep='" + funcionarioAtual.getCep() + "',logradouro='" + funcionarioAtual.getLogradouro()
						+ "',numero='" + funcionarioAtual.getNumeroEndereco() + "',bairro='"
						+ funcionarioAtual.getBairro() + "',complemento='" + funcionarioAtual.getComplemento()
						+ "',cidade='" + funcionarioAtual.getCidade() + "',uf='"
						+ funcionarioAtual.getUf_estado() + "'");
		
		//retornoFuncao = banco.atualizar("cargo", "id", idBuscaCargo,"nome='" + funcionarioAtual.getCargo().getNomeCargo() +  "'");

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Alteração do registro de funcionário feita com sucesso!", "Alteração",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public boolean bancoDeDadosExcluir(String cpfBusca, String idBusca, String idBuscaCargo) {
		boolean retornoFuncao = false;

		retornoFuncao = banco.excluir("funcionario", "cpf", cpfBusca);
		retornoFuncao = banco.excluir("endereco", "id", idBusca);
		//retornoFuncao = banco.excluir("cargo", "id", idBuscaCargo);

		if (retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Exclusão do registro de funcionário feita com sucesso!", "Exclusão",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		} else {
			return false;
		}
	}
	// ---------------------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES
	// TABELA-------------------------------------------------------------

	public void adicionarFuncionarioTabela(ModeloFuncionario funcionario) {
		funcionarioTabela.add_tabela(funcionario);
	}

	public FisicoTable_F getFuncionariosNaTabela() {
		return funcionarioTabela;
	}

	// ---------------------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES
	// ARRAYLIST-------------------------------------------------------------

	// -------------------------------------------------------------------------------------------------

	// GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE
	// DADOS E ATUALIZA.

	public ArrayList<ModeloFuncionario> getFuncionarios() {
		return banco.consultarFuncionario();
	}

	public static void setFuncionarios() {
		banco.consultarFuncionario();
	}

	// -------------------------------------------------------------------------------------------------

	// ------------------------------------FUNÇÕES DE
	// PESQUISA-------------------------------------------------------------

	public static ModeloFuncionario buscaArrayGeralPorCpfERg(ModeloFuncionario funcionarioASerBuscado) {
		for (ModeloFuncionario u : banco.consultarFuncionario()) {
			if (u.getCpf().equals(funcionarioASerBuscado.getCpf())) {
				return u;
			}
		}
		return null;
	}

	public int busca_cargo(String nome_cargo) {
		for (Cargo u : banco.consultarCargo()) {
			if (u.getNomeCargo().equals(nome_cargo)) {
				return u.getId();
			}
		}
		return -1;
	}
}
