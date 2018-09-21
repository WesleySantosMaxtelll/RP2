package teste;

import java.util.ArrayList;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;

public class GeradorTeste {
	private ArrayList<Pessoa> passageiros = new ArrayList<>();
	private ArrayList<Onibus> onibus = new ArrayList<>();
	private final double totalTime = 50000;
	// Tempo total de um dia é 50000 unidades
	

	public void criarCenario(int onibus, int pontos, int passageirosN) {
		geraTemposPontos(pontos);
		geraOnibus(onibus);
		geraTemposTrajetos(onibus);
		geraUsuarios(passageirosN);
	}
	
	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}
	
	
	public void geraOnibus(int qtd) {
		int tempo = 0;
		int id = 0;
		TemposMedios.getIntance().crieArrayOnibus(qtd);
		for(int i = 0; i <qtd; i++) {
			Onibus novo = new Onibus();
			novo.setId(id);
			novo.setCapacidade(60);
			TemposMedios.getIntance().atribuiValorOnibus(id++, (float)tempo);
			tempo += totalTime/qtd;
			onibus.add(novo);
		}
	}
	
	private double numeroNoIntervalo(double d, double e) {
		double num = (double) Math.random();
		num = num*(e-d) + d;
		return num;
	}
	
	public void geraTemposPontos(int qtd) {
		TemposMedios instancia = TemposMedios.getIntance();
		instancia.crieArrayParadas(qtd);
		for(int i = 0; i <qtd; i++) {
			double tempo = numeroNoIntervalo(40, 300);
			instancia.getTempoParada()[i] = tempo;
		}
	}
	
	public void geraTemposTrajetos(int qtd) {
		TemposMedios instancia = TemposMedios.getIntance();
		instancia.crieArrayOnibus(qtd);
		double tempo = 0.0;
		for(int i = 0; i <qtd; i++) {
			if(i%5 == 0 || i%6 == 0)
				tempo = numeroNoIntervalo(5000, 7000);
			else
				tempo = numeroNoIntervalo(3500, 5500);
			instancia.getTempoOnibus()[i] = tempo;
		}
	}
	
	public void geraUsuarios(int qtd) {
		TemposMedios instancia = TemposMedios.getIntance();
		for(int i = 0; i <qtd/2; i++) {
			int partida = (int)(Math.random()*instancia.getTempoParada().length);
			int destino = (int)(Math.random()*(instancia.getTempoParada().length - partida) + partida+1);
			if(destino > 30) destino = 30;
			double inicioHorario = Math.random()*totalTime;
			
			Pessoa p = new Pessoa(destino, partida, inicioHorario);
			passageiros.add(p);
		}
		
		for(int i = 0; i <qtd/2; i++) {
			double chance = Math.random();
			if(chance > 0.5) {
				int partida = (int)(Math.random()*(instancia.getTempoParada().length/4));
				int destino = (int)(Math.random()*(instancia.getTempoParada().length - (instancia.getTempoParada().length - partida)) + instancia.getTempoParada().length - partida+1);
				double inicioHorario = Math.random()*totalTime/10;
				if(destino > 30) destino = 30;
				Pessoa p = new Pessoa(destino, partida, inicioHorario);
				passageiros.add(p);
			} else{
				int partida = (int)(Math.random()*(instancia.getTempoParada().length/4));
				int destino = (int)(Math.random()*(instancia.getTempoParada().length - (instancia.getTempoParada().length - partida)) + instancia.getTempoParada().length - partida+1);
				double inicioHorario = Math.random()*(totalTime/2 - totalTime/3) + totalTime/3;
				if(destino > 30) destino = 30;
				Pessoa p = new Pessoa(destino, partida, inicioHorario);
				passageiros.add(p);
			}
		}
	}
	
}
