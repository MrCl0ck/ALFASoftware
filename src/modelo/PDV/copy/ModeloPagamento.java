package modelo.PDV.copy;

public class ModeloPagamento {
	private double valorTotalPagar;
	private double valorRecebido;
	private double troco;
	private String cpf_cnpj;
	
	public double getValorTotalPagar() {
		return valorTotalPagar;
	}
	public void setValorTotalPagar(double valorTotalPagar) {
		this.valorTotalPagar = valorTotalPagar;
	}
	public double getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public double getTroco() {
		return troco;
	}
	public void setTroco(double troco) {
		this.troco = troco;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	
}
