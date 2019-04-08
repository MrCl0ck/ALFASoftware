package modelo.controleDeConta.copy;

public class ModeloConsultaContaDeCliente {
	private String codigoCliente;
	private String nome;
	private String cpf;
	private double limiteTotal;
	private double limiteDisponivel;
	
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
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
	public double getLimiteTotal() {
		return limiteTotal;
	}
	public void setLimiteTotal(double limiteTotal) {
		this.limiteTotal = limiteTotal;
	}
	public double getLimiteDisponivel() {
		return limiteDisponivel;
	}
	public void setLimiteDisponivel(double limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}
	
	
}
