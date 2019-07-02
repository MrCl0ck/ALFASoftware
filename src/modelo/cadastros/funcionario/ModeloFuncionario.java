package modelo.cadastros.funcionario;

import modelo.cadastros.EnderecoCadastro;

public class ModeloFuncionario extends EnderecoCadastro{
	
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String orgaoExpeditor;
	private String ufRg;
	private String dataExpedicaoRg;
	private String nacionalidade;
	private String naturalidade;
	private String dataDeNascimento;
	private String sexo;
	private String ctps;
	private String dataDeAdmissao;
	private Cargo cargo;
	private String setor;
	private double salario;
	private String nomeDeUsuario;
	private String senha;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}
	
	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}
	
	public String getUfRg() {
		return ufRg;
	}
	
	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}
	
	public String getDataExpedicaoRg() {
		return dataExpedicaoRg;
	}
	
	public void setDataExpedicaoRg(String dataExpedicaoRg) {
		this.dataExpedicaoRg = dataExpedicaoRg;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	public String getDataDeAdmissao() {
		return dataDeAdmissao;
	}
	
	public void setDataDeAdmissao(String dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}
	
	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}
	
	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
