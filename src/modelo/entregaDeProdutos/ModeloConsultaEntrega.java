package modelo.entregaDeProdutos;

import java.util.ArrayList;

import modelo.PDV.ModeloEntrega;

public class ModeloConsultaEntrega {
	private String dataInicial;
	private String dataFinal;
	private ArrayList<ModeloEntrega> listaEntregas;
	
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public ArrayList<ModeloEntrega> getListaEntregas() {
		return listaEntregas;
	}
	public void setListaEntregas(ArrayList<ModeloEntrega> listaEntregas) {
		this.listaEntregas = listaEntregas;
	}
	
	
}
