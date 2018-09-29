package geneticos;

import java.util.ArrayList;
import java.util.Iterator;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;
import teste.GeradorTeste;

public class Fitness {
	private Cromossomo cromossomo;
	GeradorTeste teste = new GeradorTeste();
	private TemposMedios tm = TemposMedios.getInstance();
	private int qtdPonto = tm.getTempoParada().length;

	private ArrayList<Pessoa> passageiros = teste.getPassageiros();
	private ArrayList<Onibus> onibus = teste.getOnibus();
	
	public double calculaFitness(Cromossomo cal, ArrayList<Onibus> onibu, ArrayList<Pessoa> pass) {
		double fitness = 0.0;
		onibus = onibu;
		cromossomo = cal;
		passageiros = pass;
		double tempoCorrente = 0.0;
		
		// Para cada rodada 
		while(tempoCorrente < 120.0) {
			for(int i = 0; i<onibus.size(); i++) {
				System.out.println("Atualização para o tempo " + tempoCorrente+ " e para o onibus "+i);
				atualizaOnibus(i, tempoCorrente); // Atualiza a posicao dos onibus pelo tempo corrente
				if(onibus.get(i).isParadoNoPonto()) {
					System.out.println("aqui");
					fitness += descem(tempoCorrente, i);
					sobem(tempoCorrente, i);
				}
				System.out.println("********************************************************************\n");
			}
			tempoCorrente+=1.0;
		}
		
		return fitness;
	}

	private double descem(double tempoCorrente, int i) {
		double fitness = 0.0;
		System.out.println(onibus.get(i).getPassageiros().size());
		
		Iterator<Pessoa> iterator = onibus.get(i).getPassageiros().iterator();      // it will return iterator
        while (iterator.hasNext()){
            Pessoa passageiro = iterator.next();
            if(passageiro.getDestino() == onibus.get(i).getParada()){   
            	System.out.println("Passageiro subiu no "+passageiro.getPartida());
            	passageiro.setHorarioChegada(tempoCorrente);
            	passageiro.desceDoOnibus();
				fitness+=tempoCorrente-passageiro.getInicioEspera();
                iterator.remove();                  // remove element if match condition
            }
        }
		
//		
//		for(int p = 0; p < onibus.get(i).getPassageiros().size(); p++) {
//			if(onibus.get(i).getPassageiros().get(p).getDestino() == onibus.get(i).getParada()) {
//				System.out.println("Passageiro subiu no "+onibus.get(i).getPassageiros().get(p).getPartida());
//				onibus.get(i).getPassageiros().get(p).desceDoOnibus();
//				fitness+=tempoCorrente-onibus.get(i).getPassageiros().get(p).getInicioEspera();
//				onibus.get(i).passageiroSai(p);
//			}
//		}
		return fitness;
	}

	private void atualizaOnibus(int i, double tempoCorrente) {
		// TODO Auto-generated method stub
		Onibus o = onibus.get(i); 
		if(tm.getTempoOnibus()[i] > tempoCorrente || o.terminou()) return; // o onibus ainda nao esta rodando
		
		if(o.isParadoNoPonto()) { // se o onibus esta parado no ponto
			if(o.deveSair()) {
				System.out.println("Onibus sai do ponto "+ o.getParada());
				o.setParadoNoPonto(false);
				if(o.getParada() < qtdPonto-1) {
					o.setTempoProxParada(tm.getTempoTrajetoEntrePontos()[o.getParada()][i]);
					o.setProxParada();
				} else
					o.setTerminou();
			} else
				System.out.println("Onibus esta parado no ponto " + o.getParada());
		}else {
			if(o.chegou()) {
				System.out.println("Onibus chegou no ponto "+ o.getParada());
				if(cromossomo.getConteudo()[i*qtdPonto+o.getParada()]) {
					o.setParadoNoPonto(true);
					o.setTempoParadoNoPronto(tm.getTempoParada()[o.getParada()]);
				} else {
					System.out.println("Onibus nao para nesse ponto");
					if(o.getParada() < qtdPonto-1) {
						o.setTempoProxParada(tm.getTempoTrajetoEntrePontos()[o.getParada()][i]);
						o.setProxParada();
					} else
						o.setTerminou();
				}
			} else
				System.out.println("Onibus esta no trajeto para o ponto "+o.getParada());
		}
	}
	
	private boolean paraAqui(int onibusIndice, int indiceParada) {
		return cromossomo.getConteudo()[onibusIndice*qtdPonto+indiceParada];
	}

	private void sobem(double tempoCorrente, int onibusIndice) {
		// TODO Auto-generated method stub
		for(Pessoa p:passageiros) {
			if(p.estaEsperando() && p.getInicioEspera() <= tempoCorrente &&
					onibus.get(onibusIndice).getParada() == p.getPartida() &&
							paraAqui(onibusIndice, p.getDestino()) ) {
				
					System.out.println("passageiro chegou em " +p.getInicioEspera());
					if(onibus.get(onibusIndice).cabemPassageiros()) {
						System.out.println("Passageiro vai descer no "
					+p.getDestino());
						onibus.get(onibusIndice).getPassageiros().add(p);
						p.sobeNoOnibus(onibusIndice);
					}

			}
		}
		
	}


	private boolean existemOnibusOuPassageiros() {
		// TODO Auto-generated method stub
		return false;
	}	
	
}
