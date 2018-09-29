package geneticos;

import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;
import teste.GeradorTeste;

public class Fitness {
	private Cromossomo cromossomo;
	GeradorTeste teste = new GeradorTeste();
	private int qtdPonto = teste.getQtdPontos();

	private ArrayList<Pessoa> passageiros = teste.getPassageiros();
	private ArrayList<Onibus> onibus = teste.getOnibus();
	private TemposMedios tm = TemposMedios.getIntance();
	
	public double calculaFitness(Cromossomo cal) {
		double fitness = 0.0;
		cromossomo = cal;
		double tempoCorrente = 0.0;
		
		// Para cada rodada 
		while(existemOnibusOuPassageiros()) {
			for(int i = 0; i<onibus.size(); i++) {
				atualizaOnibus(i); // Atualiza a posicao dos onibus pelo tempo corrente
				if(estaNoPonto(onibus.get(i))) {
					fitness += descem(tempoCorrente, i);
					sobrem(tempoCorrente);
				}
			}
			tempoCorrente+=1.0;
		}
		
		return fitness;
	}

	private double descem(double tempoCorrente, int i) {
		double fitness = 0.0;
		
			
		
		
		
		for(int p = 0; p < onibus.get(i).getPassageiros().size(); p++) {
			if(onibus.get(i).getPassageiros().get(p).getDestino() == onibus.get(i).getParada()) {
				onibus.get(i).getPassageiros().get(p).desceDoOnibus();
				fitness+=tempoCorrente-onibus.get(i).getPassageiros().get(p).getHorarioChegada();
				onibus.get(i).passageiroSai(p);
			}
		}
		return fitness;
	}

	private void atualizaOnibus(int i) {
		// TODO Auto-generated method stub
		onibus.get(i).atualizaTempoParadaAnterior();
		int paradaAnterior = onibus.get(i).getParada();
		if(onibus.get(i).getTempoUltimaParada() == tm.getTempoTrajetoEntrePontos()[i][paradaAnterior]) {
		}
	}
	
	private boolean paraAqui(int onibusIndice, int indiceParada) {
		return cromossomo.getConteudo()[onibusIndice*qtdPonto+indiceParada];
	}

	private boolean estaNoPonto(Onibus onibus2) {
		// TODO Auto-generated method stub
		return false;
	}

	private void sobrem(int tempoCorrente, int onibusIndice) {
		// TODO Auto-generated method stub
		for(Pessoa p:passageiros) {
			if(p.estaEsperando() && p.getHorarioChegada() > tempoCorrente) {
					int onibus = existeOnibusNoPonto(p);

			}
		}
		
	}

	private int existeOnibusNoPonto(Pessoa passageiro) {
		
		return 0;
	}


	private boolean existemOnibusOuPassageiros() {
		// TODO Auto-generated method stub
		return false;
	}	
	
}
