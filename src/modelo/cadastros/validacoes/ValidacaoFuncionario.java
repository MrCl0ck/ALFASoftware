package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.dados.DadosFuncionario;
import modelo.cadastros.funcionario.ModeloFuncionario;

public class ValidacaoFuncionario {
	private ModeloFuncionario funcionario;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoCpf;

	public ValidacaoFuncionario(ModeloFuncionario funcionario) {
		this.funcionario = funcionario;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());	
	}
	
	public void validarCPF() {
		setResultadoValidacaoCpf(validacao_cpf());
	}
	
	public boolean validacaoTodosCamposGeral() {
		boolean resultado = true;
		String errosConcatenados = "";
		
		//DADOS PESSOAIS
		if(funcionario.getNome().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(funcionario.getCpf().trim().length() < 11) {//----------------------
			errosConcatenados += "Preencha o campo 'CPF'!\n";
			resultado = false;
		}
		if(funcionario.getRg().trim().length() <= 9 ) {//---------------------
			errosConcatenados += "Preencha o campo 'RG'!\n";
			resultado = false;
		}
		if(funcionario.getUfRg().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(funcionario.getOrgaoExpeditor().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Órgão Expeditor'!\n";
			resultado = false;
		}
		if(funcionario.getNacionalidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nacionalidade'!\n";
			resultado = false;
		}
		if(funcionario.getNaturalidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Naturalidade'!\n";
			resultado = false;
		}		
		if(funcionario.getDataDeNascimento().trim().equals("/  /")) {
			errosConcatenados += "Preencha o campo 'Data de Nascimento'!\n";
			resultado = false;
		}
		if(funcionario.getSexo().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Sexo'!\n";
			resultado = false;
		}
		if(funcionario.getTelefone().trim().equals("( )    -")) {
			errosConcatenados += "Preencha o campo 'Telefone'!\n";
			resultado = false;
		}
		if(funcionario.getEmail().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Email'!\n";
			resultado = false;
		}
		
		//DADOS DO CARGO
		if(funcionario.getCtps().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'CTPS'!\n";
			resultado = false;
		}
		if(funcionario.getDataDeAdmissao().trim().equals("/  /")) {//**
			errosConcatenados += "Preencha o campo 'Data de Admissão'!\n";
			resultado = false;
		}
		if(funcionario.getCargo().equals("Selecione")) {//**
			errosConcatenados += "Preencha o campo 'Cargo'!\n";
			resultado = false;
		}
		if(funcionario.getSetor().trim().equals("")) {//***
			errosConcatenados += "Preencha o campo 'Setor'!\n";
			resultado = false;
		}
		if(funcionario.getSalario() == 0) {//***
			errosConcatenados += "Preencha o campo 'Salário'!\n";
			resultado = false;
		}
		if(funcionario.getNomeDeUsuario().trim().equals("")) {//***
			errosConcatenados += "Preencha o campo 'Nome de Usuário'!\n";
			resultado = false;
		}
		if(funcionario.getSenha().trim().equals("")) {//****
			errosConcatenados += "Preencha o campo 'Senha'!\n";
			resultado = false;
		}
		
		//ENDEREÇO
		if(funcionario.getCep().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(funcionario.getLogradouro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Logradouro'!\n";
			resultado = false;
		}
		if(funcionario.getNumeroEndereco().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nº'!\n";
			resultado = false;
		}
		if(funcionario.getBairro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Bairro'!\n";
			resultado = false;
		}
		if(funcionario.getCidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Cidade'!\n";
			resultado = false;
		}
		if(funcionario.getUf_estado().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(funcionario.getTelefone().trim().length() <= 11) {
			errosConcatenados += "Preencha o campo 'Telefone'!\n";
			resultado = false;
		}
		if(funcionario.getEmail().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Email'!\n";
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
	
	public boolean validacao_cpf() {
		DadosFuncionario funcionarioCPF = new DadosFuncionario();
			
		for (int i = 0; i < funcionarioCPF.getFuncionarios().size() ; i++) {
			if(funcionario.getCpf().equals(funcionarioCPF.getFuncionarios().get(i).getCpf().toString()) || funcionario.getRg().equals(funcionarioCPF.getFuncionarios().get(i).getRg().toString())){
				JOptionPane.showMessageDialog(null, "Este funcionário já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}		
		
		return true;
	}
	
	public boolean isResultadoValidacaoTodosCamposGeral() {
		return resultadoValidacaoTodosCamposGeral;
	}

	private void setResultadoValidacaoTodosCamposGeral(boolean resultadoValidacaoTodosCamposGeral) {
		this.resultadoValidacaoTodosCamposGeral = resultadoValidacaoTodosCamposGeral;
	}

	public boolean isResultadoValidacaoCpf() {
		return resultadoValidacaoCpf;
	}

	private void setResultadoValidacaoCpf(boolean resultadoValidacaoCpf) {
		this.resultadoValidacaoCpf = resultadoValidacaoCpf;
	}	
}
