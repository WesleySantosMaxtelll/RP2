package itens;

public class TemposMedios {
	private double tempoParada[]; // Tempo medio de parada em cada ponto
	private double tempoOnibus[]; // Tempo que o onibus inicia na linha
	private double tempoTrajetoEntrePontos[][]; // Tempo entre os pontos
	
	private static TemposMedios instance = new TemposMedios();
	private TemposMedios() {
		tempoParada = getTemposParadasArquivo();
		tempoOnibus = getTemposDosOnibus();
		tempoTrajetoEntrePontos = getTemposEntrePontos();
	}
	
	
	private double[][] getTemposEntrePontos() {
		// TODO Auto-generated method stub
		return null;
	}


	private double[] getTemposDosOnibus() {
		// TODO Auto-generated method stub
		return null;
	}


	private double[] getTemposParadasArquivo() {
		// TODO Auto-generated method stub
		return null;
	}


	public double getEstimativaTempoTrajetoEntrePontos(int paradaAtual, double tempoCorrente) {
		double tempoExperado = 0.0;
		return tempoCorrente;
	}
	

	public double[][] getTempoTrajetoEntrePontos() {
		return tempoTrajetoEntrePontos;
	}


	public void setTempoTrajetoEntrePontos(double[][] tempoTrajetoEntrePontos) {
		this.tempoTrajetoEntrePontos = tempoTrajetoEntrePontos;
	}


	public void alterarTempoTrajetoEntrePontos(int x, int y, double t) {
		tempoTrajetoEntrePontos[x][y] = t;
	}

	public static TemposMedios getInstance() {
		return instance;
	}

	public static void setInstance(TemposMedios instance) {
		TemposMedios.instance = instance;
	}

	public void crieArrayOnibus(int tamanho) {
		tempoOnibus = new double[tamanho];
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
