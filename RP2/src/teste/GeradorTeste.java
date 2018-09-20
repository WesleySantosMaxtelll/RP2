package teste;

import java.util.ArrayList;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;

public class GeradorTeste {
	private ArrayList<Pessoa> passageiros = new ArrayList<>();
	private ArrayList<Onibus> onibus = new ArrayList<>();
	// Tempo total de um dia é 1000 unidades
	
	public ArrayList<Pessoa> gerarFluxo() {
		return passageiros;
	}
	
	
	public ArrayList<Onibus> geraOnibus(int qtd) {
		int tempo = 0;
		int id = 0;
		TemposMedios.getIntance().crieArrayOnibus(qtd);
		for(int i = 0; i <qtd; i++) {
			Onibus novo = new Onibus();
			novo.setId(id);
			novo.setCapacidade(60);
			TemposMedios.getIntance().atribuiValorOnibus(id++, (float)tempo);
			tempo += 1000/qtd;
			
		}
		return onibus;
	}
}
