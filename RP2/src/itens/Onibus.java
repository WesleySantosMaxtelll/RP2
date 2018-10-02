package itens;

import java.util.ArrayList;
import itens.Pessoa;

public class Onibus {
	
	private int id; // Associado a uma coluna da matriz do cromossomo
	private double tempoUltimaParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private double tempoProxParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private double tempoParadoNoPronto=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private int parada=0;// registra a proxima parada que o onibus estava;
	private int capacidade=2; // numero maximo de passageiros
	private boolean paradoNoPonto = false;
	private boolean operacao = false;
	private ArrayList<Pessoa> passageiros = new ArrayList<>();
	

	
	public boolean isParadoNoPonto() {
		return paradoNoPonto;
	}

	public void setParadoNoPonto(boolean paradoNoPonto) {
		this.paradoNoPonto = paradoNoPonto;
	}

	public double getTempoParadoNoPronto() {
		return tempoParadoNoPronto;
	}

	public void setTempoParadoNoPronto(double tempoParadoNoPronto) {
		this.tempoParadoNoPronto = tempoParadoNoPronto;
	}

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

	public void setProxParada() {
		parada++;
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
	
	public boolean deveSair() {
		tempoParadoNoPronto --;
		if(tempoParadoNoPronto <= 0.0)
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

	public boolean cabemPassageiros() {
		if(passageiros.size() < capacidade) return true;
		return false;
	}

	public boolean terminou() {
		return operacao;
	}
	
	public void restart() {
		operacao = false;
	}
	public void setTerminou() {
		tempoUltimaParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
		tempoProxParada=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
		tempoParadoNoPronto=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
		parada=0;// registra a proxima parada que o onibus estava;
		capacidade=2; // numero maximo de passageiros
		paradoNoPonto = false;
		operacao = true;
	}

}
