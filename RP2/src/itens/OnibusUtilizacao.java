package itens;

import java.util.ArrayList;
import itens.Pessoa;

public class OnibusUtilizacao {
	
	private int id; // Associado a uma coluna da matriz do cromossomo
	private double tempoProxAtualizacao=0;// em qual tempo o onibus esta, para descobrir se ele esta chegando na proxima parada
	private int parada=0;// registra a proxima parada que o onibus estava;
	private int paradaAnt=0;// registra a proxima parada que o onibus estava;
	private int capacidade=2; // numero maximo de passageiros
	private boolean paradoNoPonto = false;
	private int capbackup;
	private boolean operacao = false;
	private boolean alguemParaDescer = false;
	private boolean alguemParaSubir = false;
	private ArrayList<Pessoa> passageiros = new ArrayList<>();
	

	
	public double getTempoProxAtualizacao() {
		return tempoProxAtualizacao;
	}

	public void setTempoProxAtualizacao(double tempoProxAtualizacao) {
		this.tempoProxAtualizacao = tempoProxAtualizacao;
	}

	public boolean isThereAnybodyToGetOff() {
		return alguemParaDescer;
	}
	
	public void todosDesceram() {
		alguemParaDescer = false;
	}
	
	public void podemDescer() {
		alguemParaDescer = true;
	}
	
	public boolean canAnybodyGetOn() {
		return alguemParaSubir;
	}
	
	public void podemSubir() {
		paradoNoPonto = false;
		alguemParaSubir = true;
	}
	
	public void todosSubiram() {
		alguemParaSubir = false;
	}

	
	public boolean isParadoNoPonto() {
		return paradoNoPonto;
	}

	public void setParadoNoPonto() {
		paradoNoPonto = true;
		podemDescer();
		todosSubiram();
	}
	
	public void setSaiDoPonto() {
		paradoNoPonto = false;
		podemSubir();
		todosDesceram();
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


	public int getParada() {
		return parada;
	}

	public int getParadaAnt() {
		return paradaAnt;
	}

	public void setProxParada(int pp) {
		paradaAnt = parada;
		parada = pp;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		capbackup = capacidade;
		this.capacidade = capacidade;
	}

	public boolean chegou(double tempoCorrente) {
		return (tempoCorrente == tempoProxAtualizacao) && !paradoNoPonto;
	}
	
	public boolean deveSair(double tempocorrente) {
		return (tempoProxAtualizacao == tempocorrente) && paradoNoPonto;
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
		parada=0;// registra a proxima parada que o onibus estava;
		paradaAnt=0;
		capacidade=capbackup; // numero maximo de passageiros
		alguemParaDescer = false;
		alguemParaSubir = false;
		paradoNoPonto = false;
		operacao = true;
	}

}
