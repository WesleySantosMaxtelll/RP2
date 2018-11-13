package geneticos;

import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;

import api_interface.PassageiroResposta;
import api_interface.TemposMedios;
import itens.OnibusUtilizacao;
import itens.Pessoa;


public class Fitness {
	private Cromossomo cromossomo;
	BaseInfo baseinfo = BaseInfo.getInstance();
	private TemposMedios tm = baseinfo.getTm();
	private int qtdPonto = baseinfo.getQtdPonto();
	private ArrayList<Pessoa>[] passageiros = baseinfo.getPassageiros();
	private int proxPassageiro = 0;
	private ArrayList<OnibusUtilizacao> onibus = baseinfo.getOnibusListados();
	private final int fatorDivisao = baseinfo.getFatorDivisao();
	private ArrayList<OnibusUtilizacao>[] onibusPorTempo;
	private int onibusRodando = 0;
	private boolean printa = false;
	private boolean trabalhoLista = false;
	
	
	private double obterAtrasoInicial(int i) {
		double tempo = baseinfo.getTempoOnibus()[i];
		OnibusUtilizacao o = onibus.get(i); 
//		System.out.println("entrou "+!cromossomo.conteudo[i*qtdPonto]);
		int proxParada = 0;
		for(proxParada = 0; !cromossomo.conteudo[i*qtdPonto+proxParada]; proxParada++) {
			if(proxParada >= qtdPonto-1) {
				o.setTerminou();
				onibusRodando--;
				if(printa)System.out.println("O onibus "+o.getId() + " encerrou as atividades");
				return -1;
			}
			tempo += tm.tempoEntrePontos(proxParada, i, tempo);
		}
		o.setProxParada(proxParada);
		return tempo;
	}
	private void divideEmTempos() {
		onibusPorTempo = new ArrayList[fatorDivisao];
		
		for(int i = 0; i < fatorDivisao; i++) {
			onibusPorTempo[i] = new ArrayList<>();
		}
		for(int j = 0; j< onibus.size(); j++) {
			int t = (int)onibus.get(j).getTempoProxAtualizacao();
			if(t !=-1)
				onibusPorTempo[t%fatorDivisao].add(onibus.get(j));
		}
	}
	
	public double calculaFitness(Cromossomo cal, ArrayList<PassageiroResposta> melhorGeracao) {
		cromossomo = cal;
		double tempoCorrente = 0.0;
		onibusRodando = onibus.size();
		if(printa)System.out.println(onibusRodando);
		if(printa)System.out.println("Iniciaçao dos tempos");
		for(int i = 0; i <onibus.size(); i++) {
			onibus.get(i).setTempoProxAtualizacao(obterAtrasoInicial(i));
			if(printa)System.out.println(i + " " +onibus.get(i).getTempoProxAtualizacao());
		}
		
		divideEmTempos();
		
		if(printa) {
			System.out.println("**************************");
			System.out.println("Configuracao de onibus inicial");
			for(int i = 0; i < onibusPorTempo.length; i++) {
				for(OnibusUtilizacao p:onibusPorTempo[i])
					System.out.print(p.getId()+ "\t");
				System.out.println("");
			}
			if(printa)System.out.println("**************************");
			if(printa)System.out.println("pessoas");
		
			for(int i = 0; i < passageiros.length; i++) {
				for(Pessoa p:passageiros[i])
					System.out.print(p.getPartida()+ " "+p.getDestino()+" "+p.getInicioEspera()+",\t");
				System.out.println("");
			}
			
			System.out.println(fatorDivisao);
		}
		while(onibusRodando > 0) {
			if(printa)System.out.println("avaliando a posicao: " +(int)tempoCorrente%fatorDivisao);
			if(printa)System.out.println("\nAtualização para o tempo " + tempoCorrente);
			if(trabalhoLista) {
				System.out.println("Quantidade de onibus que sobraram: " + onibusPorTempo[(int)tempoCorrente%fatorDivisao].size());
				System.out.print("Onibus da rodada: ");
				for(OnibusUtilizacao o:onibusPorTempo[(int)tempoCorrente%fatorDivisao]) {
					System.out.print(o.getId() + " ");
				}
				System.out.print("\n");
			}

			Iterator<OnibusUtilizacao> iterator = onibusPorTempo[(int)tempoCorrente%fatorDivisao].iterator();      // it will return iterator
	        ArrayList<OnibusUtilizacao> aux = new ArrayList<>();
			while (iterator.hasNext()){
	        
	        	OnibusUtilizacao o = iterator.next();
	        	if(printa)System.out.println(o.getTempoProxAtualizacao());
	        	if(o.getTempoProxAtualizacao() == tempoCorrente) {
	        		iterator.remove();
	        		
		        	if(atualizaOnibus(o, tempoCorrente))
		        		aux.add(o);
		        	if(o.canAnybodyGetOn()) {
		        		if(printa)System.out.println("pessoas podem subir: ");
		        		sobem(tempoCorrente, o.getId());
		        	}
		        	if(o.isThereAnybodyToGetOff()) {
		        		if(printa)System.out.println("pessoas podem descer: ");
		        		descem(tempoCorrente, o.getId());
		        	}
		        }
	        	if(printa)System.out.println("\n\n");
	        }
			
			for(OnibusUtilizacao o:aux) {
				onibusPorTempo[(int)o.getTempoProxAtualizacao()%fatorDivisao].add(o);
			}
			
	        if(printa)System.out.println("********************************************************************\n");
			
			tempoCorrente+=1.0;
		}
		double f = 0.0;
		int sucesso = 0;
		for(Pessoa c:baseinfo.getPassageirosListados()) {
			if(melhorGeracao != null) {
				PassageiroResposta r = new PassageiroResposta();
				r.setHorarioTermino(c.getHorarioChegada());
				r.setInicioEspera(c.getInicioEspera());
				r.setOnibusId(c.getOnibus());
				r.setPartida(c.getPartida());
				r.setDestino(c.getDestino());
				melhorGeracao.add(r);
			}
			
			if (c.getHorarioChegada() == Short.MAX_VALUE)
				c.setHorarioChegada(tempoCorrente*1.2);
			else
				sucesso +=1;
			f+=c.getHorarioChegada()-c.getInicioEspera();
			double temp = c.getHorarioChegada()-c.getInicioEspera();
//			System.out.println(c.getPartida() + " " +c.getDestino() + " " +c.getOnibus() + " " +temp);
			c.restart();
//			System.out.println(f);
		}
		
		
		for(OnibusUtilizacao c:onibus) {
			c.restart();
		}
		
		
		if(printa)System.out.println(f);
		return 1/(f/sucesso);
//		return 1/((f/total)/(sucesso/total));
	}

	private void descem(double tempoCorrente, int i) {
		if(printa)System.out.println(onibus.get(i).getPassageiros().size());
		
		Iterator<Pessoa> iterator = onibus.get(i).getPassageiros().iterator();      // it will return iterator
        while (iterator.hasNext()){
            Pessoa passageiro = iterator.next();
            if(passageiro.getDestino() == onibus.get(i).getParada()){   
            	if(printa)System.out.println("Passageiro subiu no "+passageiro.getPartida());
            	passageiro.setHorarioChegada(tempoCorrente);
            	passageiro.desceDoOnibus();
                iterator.remove();                  // remove element if match condition
            }
        }
        onibus.get(i).todosDesceram();
	}

	private boolean proximaAcaoOnibus(OnibusUtilizacao o, int i, double tempoCorrente) {
		// TODO Auto-generated method stub
		double tempoProxEvento = tm.tempoEntrePontos(o.getParada(), i, tempoCorrente);;
		int p = o.getParada()+1;
		for(int proxParada = o.getParada()+1; !cromossomo.conteudo[i*qtdPonto+proxParada]; proxParada++) {
			p ++;
			if(proxParada >= qtdPonto-1) {
				o.setTerminou();
				onibusRodando--;
				if(printa)System.out.println("O onibus "+o.getId() + " encerrou as atividades");
				return false;
			}
			tempoProxEvento += tm.tempoEntrePontos(proxParada, i, tempoCorrente+tempoProxEvento);
		}
		o.setTempoProxAtualizacao(tempoCorrente + tempoProxEvento);
		o.setProxParada(p);
		o.podemSubir();
		if(printa)System.out.println("proximo movimento sera em " +o.getTempoProxAtualizacao() + " na parada "+o.getParada());
		return true;
	}
	
	
	
	private boolean atualizaOnibus(OnibusUtilizacao o, double tempoCorrente) {
		 
		int i = o.getId();
		if(o.deveSair(tempoCorrente)) {
			if(printa)System.out.println("Onibus sai do ponto "+ o.getParada());
			if(o.getParada() < qtdPonto-1) {
				if(!proximaAcaoOnibus(o, i, tempoCorrente))return false;
			} else {
				o.setTerminou();
				onibusRodando--;
				if(printa)System.out.println("O onibus "+o.getId() + " encerrou as atividades");
				return false;
			}
		}
		if(o.chegou(tempoCorrente)) {
			if(printa)System.out.println("Onibus"+o.getId()+" chegou no ponto " +o.getParada());
			o.setParadoNoPonto();
			o.podemDescer();
			
			o.setTempoProxAtualizacao(tempoCorrente+tm.tempoParadoNoPonto(o.getParada(), i, tempoCorrente, o.getPassageiros().size()));
			if(printa)System.out.println("proximo movimento sera em " +o.getTempoProxAtualizacao());
		}
		
		return true;
	}


	private boolean paraAqui(int onibusIndice, int indiceParada) {
		return cromossomo.getConteudo()[onibusIndice*qtdPonto+indiceParada];
	}

	private void sobem(double tempoCorrente, int onibusIndice) {
		if(printa)System.out.println("Pessoas no ponto: ");
		for(int i = proxPassageiro; i< passageiros[onibus.get(onibusIndice).getParadaAnt()].size(); i++) {
			Pessoa p = passageiros[onibus.get(onibusIndice).getParadaAnt()].get(i);
			if(printa)System.out.print("inicio da espera: "+ p.getInicioEspera()+" destino: "+p.getDestino());
			if(p.getInicioEspera() > tempoCorrente) {
				break;
			}
			if(p.estaEsperando() && paraAqui(onibusIndice, p.getDestino())) {
						if(onibus.get(onibusIndice).cabemPassageiros()) {
							if(printa)System.out.println(" vai subir ");
							onibus.get(onibusIndice).getPassageiros().add(p);
							p.sobeNoOnibus(onibusIndice);
						}

			}
		}
		onibus.get(onibusIndice).todosSubiram();
		
	}

}
