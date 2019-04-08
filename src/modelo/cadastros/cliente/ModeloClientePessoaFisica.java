package modelo.cadastros.cliente;

import modelo.cadastros.EnderecoCadastro;

public class ModeloClientePessoaFisica extends EnderecoCadastro{
	private int id;
	private String situacao;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String rg;
	private String ufRg;
	private String orgaoExpeditorRg;
	private double limiteCredito;
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getUfRg() {
		return ufRg;
	}
	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}
	public String getOrgaoExpeditorRg() {
		return orgaoExpeditorRg;
	}
	public void setOrgaoExpeditorRg(String orgaoExpeditorRg) {
		this.orgaoExpeditorRg = orgaoExpeditorRg;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
			
}
