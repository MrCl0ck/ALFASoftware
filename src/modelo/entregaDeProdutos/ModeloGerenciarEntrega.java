package modelo.entregaDeProdutos;

import java.util.ArrayList;

import modelo.cadastros.produto.ModeloProduto;

public class ModeloGerenciarEntrega {
	private String notaFiscal;
	private String dataDaEntrega;
	private ArrayList<ModeloProduto> itensCadastrados;
	private ArrayList<ModeloProduto> itensNaoEntregues;
	private String novaDataDeEntrega;
	
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public String getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public ArrayList<ModeloProduto> getItensCadastrados() {
		return itensCadastrados;
	}
	public void setItensCadastrados(ArrayList<ModeloProduto> itensCadastrados) {
		this.itensCadastrados = itensCadastrados;
	}
	public ArrayList<ModeloProduto> getItensNaoEntregues() {
		return itensNaoEntregues;
	}
	public void setItensNaoEntregues(ArrayList<ModeloProduto> itensNaoEntregues) {
		this.itensNaoEntregues = itensNaoEntregues;
	}
	public String getNovaDataDeEntrega() {
		return novaDataDeEntrega;
	}
	public void setNovaDataDeEntrega(String novaDataDeEntrega) {
		this.novaDataDeEntrega = novaDataDeEntrega;
	}
	
	
}
