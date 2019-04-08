package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.dados.DadosClientePessoaFisica;

public class ValidacaoClientePessoaFisica {
	private ModeloClientePessoaFisica cliente;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoCpfRg;

	public ValidacaoClientePessoaFisica(ModeloClientePessoaFisica cliente) {
		this.cliente = cliente;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());	
	}
	
	public void validarCPF() {
		setResultadoValidacaoCpfRg(validacaoCpfRg());
	}
	
	public boolean validacaoTodosCamposGeral() {
		boolean resultado = true;
		String errosConcatenados = "";
		
		if(cliente.getSituacao().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Situação'!\n";
			resultado = false;
		}
		if(cliente.getNome().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(cliente.getDataNascimento().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Data de Nascimento'!\n";
			resultado = false;
		}
		if(cliente.getSexo().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Sexo'!\n";
			resultado = false;
		}
		if(cliente.getCpf().trim().length() < 11) {//----------------------
			errosConcatenados += "Preencha o campo 'CPF'!\n";
			resultado = false;
		}
		if(cliente.getRg().trim().length() <= 9 ) {//---------------------
			errosConcatenados += "Preencha o campo 'RG'!\n";
			resultado = false;
		}
		if(cliente.getUfRg().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(cliente.getOrgaoExpeditorRg().equals("")) {
			errosConcatenados += "Preencha o campo 'Órgão Expeditor'!\n";
			resultado = false;
		}
		if(cliente.getLimiteCredito() <= 0) {
			errosConcatenados += "Insira um valor válido no campo 'Limite de Crédito'!\n";
			resultado = false;
		}
		if(cliente.getCep().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(cliente.getLogradouro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Logradouro'!\n";
			resultado = false;
		}
		if(cliente.getNumeroEndereco().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nº'!\n";
			resultado = false;
		}
		if(cliente.getBairro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Bairro'!\n";
			resultado = false;
		}
		if(cliente.getCidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Cidade'!\n";
			resultado = false;
		}
		if(cliente.getUf_estado().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(cliente.getTelefone().trim().length() <= 11) {
			errosConcatenados += "Preencha o campo 'Telefone'!\n";
			resultado = false;
		}
		if(cliente.getEmail().trim().equals("")) {
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
	
	public boolean validacaoCpfRg() {
		DadosClientePessoaFisica clienteCpfRg = new DadosClientePessoaFisica();
			
		for (int i = 0; i < clienteCpfRg.getClientesFisicos().size() ; i++) {
			if(cliente.getCpf().equals(clienteCpfRg.getClientesFisicos().get(i).getCpf().toString()) || cliente.getRg().equals(clienteCpfRg.getClientesFisicos().get(i).getRg().toString())){
				JOptionPane.showMessageDialog(null, "Este cliente já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
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

	public boolean isResultadoValidacaoCpfRg() {
		return resultadoValidacaoCpfRg;
	}

	private void setResultadoValidacaoCpfRg(boolean resultadoValidacaoCpfRg) {
		this.resultadoValidacaoCpfRg = resultadoValidacaoCpfRg;
	}	
}
