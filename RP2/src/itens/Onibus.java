package itens;

public class Onibus {
	
	private int id; // Associado a uma coluna da matriz do cromossomo
	private double tempoUltimaParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private int parada=0;// registra a ultima parada que o onibus estava;
	private int capacidade=0; // numero maximo de passageiros

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getTempoUltimaParada() {
		return tempoUltimaParada;
	}

	public void setTempoUltimaParada(double tempoUltimaParada) {
		this.tempoUltimaParada = tempoUltimaParada;
	}

	public int getParada() {
		return parada;
	}

	public void setParada(int parada) {
		this.parada = parada;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	

}
