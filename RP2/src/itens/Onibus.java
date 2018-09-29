package itens;

import java.util.ArrayList;
import itens.Pessoa;

public class Onibus {
	
	private int id; // Associado a uma coluna da matriz do cromossomo
	private double tempoUltimaParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private double tempoProxParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private int parada=0;// registra a ultima parada que o onibus estava;
	private int capacidade=0; // numero maximo de passageiros
	
	private ArrayList<Pessoa> passageiros = new ArrayList<>();
	

	
	public double getTempoProxParada() {
		return tempoProxParada;
	}

	public void setTempoProxParada(double tempoProxParada) {
		this.tempoProxParada = tempoProxParada;
	}

	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}

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

	public boolean chegou() {
		tempoProxParada --;
		if(tempoProxParada <= 0.0)
			return true;
		return false;
	}
	
	public void atualizaTempoParadaAnterior() {
		// TODO Auto-generated method stub
		tempoUltimaParada++;
	}

	public void passageiroSai(int p) {
		passageiros.remove(p);
	}


}
