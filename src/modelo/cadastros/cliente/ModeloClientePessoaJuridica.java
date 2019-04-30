package modelo.cadastros.cliente;

import modelo.cadastros.EnderecoCadastro;

public class ModeloClientePessoaJuridica extends EnderecoCadastro{
	
	private int id;
	private String situacao;
	private String razaoSocial;
	private String cnpj;
	private String representante;
	private String inscricaoEstadual;
	private String inscricaoEstadualUF;
	private double limiteCredito;			

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String contato) {
		this.representante = contato;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}	
	public String getInscricaoEstadualUF() {
		return inscricaoEstadualUF;
	}
	public void setInscricaoEstadualUF(String inscricaoEstadualUF) {
		this.inscricaoEstadualUF = inscricaoEstadualUF;
	}
}
