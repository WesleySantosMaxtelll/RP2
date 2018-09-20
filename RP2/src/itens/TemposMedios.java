package itens;

public class TemposMedios {
	private float tempoParada[];
	private float tempoOnibus[];
	
	private static TemposMedios instance = new TemposMedios();
	private TemposMedios() {}
	
	public static TemposMedios getIntance() {
		return instance;
	}
	
	public void crieArrayOnibus(int tamanho) {
		tempoOnibus = new float[tamanho];
	}
	
	public void atribuiValorOnibus(int indice, float valor) {
		tempoOnibus[indice] = valor;
	}
	
	public void crieArrayParadas(int tamanho) {
		tempoParada = new float[tamanho];
	}
	
	public float[] getTempoParada() {
		return tempoParada;
	}
	public void setTempoParada(float[] tempoParada) {
		this.tempoParada = tempoParada;
	}
	public float[] getTempoOnibus() {
		return tempoOnibus;
	}
	public void setTempoOnibus(float[] tempoOnibus) {
		this.tempoOnibus = tempoOnibus;
	}
	
	
}
