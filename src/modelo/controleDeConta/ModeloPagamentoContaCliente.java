package modelo.controleDeConta;

import java.util.ArrayList;

import modelo.cadastros.produto.ModeloProduto;

public class ModeloPagamentoContaCliente {
	private String nome;
	private String cpf;
	private ArrayList<ModeloProduto> listaProdutosComprados;
	private ArrayList<ModeloProduto> listaProdutosParaPagamento;
	private double totalConta;
	private double totalPagamento;
	private double valorRecebido;
	private double troco;
	
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
	public ArrayList<ModeloProduto> getListaProdutosComprados() {
		return listaProdutosComprados;
	}
	public void setListaProdutosComprados(ArrayList<ModeloProduto> listaProdutosComprados) {
		this.listaProdutosComprados = listaProdutosComprados;
	}
	public ArrayList<ModeloProduto> getListaProdutosParaPagamento() {
		return listaProdutosParaPagamento;
	}
	public void setListaProdutosParaPagamento(ArrayList<ModeloProduto> listaProdutosParaPagamento) {
		this.listaProdutosParaPagamento = listaProdutosParaPagamento;
	}
	public double getTotalConta() {
		return totalConta;
	}
	public void setTotalConta(double totalConta) {
		this.totalConta = totalConta;
	}
	public double getTotalPagamento() {
		return totalPagamento;
	}
	public void setTotalPagamento(double totalPagamento) {
		this.totalPagamento = totalPagamento;
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
	
	
}
