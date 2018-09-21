package itens;

public class TemposMedios {
	private double tempoParada[]; // Tempo medio de parada em cada ponto
	private double tempoOnibus[]; // Tempo que o onibus inicia na linha
	private double tempoTrajetoSemParadas[]; // Tempo que o onibus levaria sem parar nenhuma vez
	
	private static TemposMedios instance = new TemposMedios();
	private TemposMedios() {}
	
	public static TemposMedios getIntance() {
		return instance;
	}
	
	public void crieArrayOnibus(int tamanho) {
		tempoOnibus = new double[tamanho];
	}
	

	public double[] getTempoTrajetoSemParadas() {
		return tempoTrajetoSemParadas;
	}

	public void setTempoTrajetoSemParadas(double[] tempoTrajetoSemParadas) {
		this.tempoTrajetoSemParadas = tempoTrajetoSemParadas;
	}

	public void atribuiValorOnibus(int indice, double valor) {
		tempoOnibus[indice] = valor;
	}
	
	public void crieArrayParadas(int tamanho) {
		tempoParada = new double[tamanho];
	}
	
	public double[] getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(double[] tempoParada) {
		this.tempoParada = tempoParada;
	}
	public double[] getTempoOnibus() {
		return tempoOnibus;
	}
	public void setTempoOnibus(double[] tempoOnibus) {
		this.tempoOnibus = tempoOnibus;
	}
	
	
}
