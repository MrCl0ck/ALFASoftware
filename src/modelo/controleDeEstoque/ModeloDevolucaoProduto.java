package modelo.controleDeEstoque;

import java.util.ArrayList;

import modelo.cadastros.produto.ModeloProduto;

public class ModeloDevolucaoProduto {
	private String notaFiscal;
	private String numeroItem;
	private ArrayList<ModeloProduto> itensDaNotaLista;
	private ArrayList<ModeloProduto> itensASeremDevolvidosLista;
	
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public String getNumeroItem() {
		return numeroItem;
	}
	public void setNumeroItem(String numeroItem) {
		this.numeroItem = numeroItem;
	}
	public ArrayList<ModeloProduto> getItensDaNotaLista() {
		return itensDaNotaLista;
	}
	public void setItensDaNotaLista(ArrayList<ModeloProduto> itensDaNotaLista) {
		this.itensDaNotaLista = itensDaNotaLista;
	}
	public ArrayList<ModeloProduto> getItensASeremDevolvidosLista() {
		return itensASeremDevolvidosLista;
	}
	public void setItensASeremDevolvidosLista(ArrayList<ModeloProduto> itensASeremDevolvidosLista) {
		this.itensASeremDevolvidosLista = itensASeremDevolvidosLista;
	}
	
	
}
