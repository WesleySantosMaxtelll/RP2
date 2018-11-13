package geneticos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import api_interface.Onibus;
import api_interface.PassageiroResposta;
import api_interface.TemposMedios;
import itens.OnibusUtilizacao;
import itens.Pessoa;


public class BaseInfo {
	private BaseInfo() {}
	private static BaseInfo instance = new BaseInfo();
	public static BaseInfo getInstance() {
		return instance;
	}
	
	private Cromossomo melhorAteAgora;
	private double melhorFitness;
	private TemposMedios tm;
	private int qtdPonto;
	private ArrayList<Pessoa>[] passageiros;
	private ArrayList<Pessoa> passageirosListados;
	private ArrayList<OnibusUtilizacao> onibusListados;
	private final int fatorDivisao = 80;
	private double tempoOnibus[];
	private Integer[] mutaveis;
	private Integer[] onibusMutaveis;
	
	public void definePermitidos(ArrayList<Onibus> onibus, int qtdPontos) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for(Onibus o:onibus) {
			if(!o.isFixo()) {
				b.add(onibus.indexOf(o));
				for(int i = onibus.indexOf(o)*qtdPontos; i < (1+onibus.indexOf(o))*qtdPontos;i++) {
					a.add(i);
				}
			}
		}
		mutaveis = new Integer[a.size()];
		mutaveis = a.toArray(mutaveis);
		onibusMutaveis = new Integer[b.size()];
		onibusMutaveis = b.toArray(onibusMutaveis);
		
	}
	
	
	
	public Integer[] getOnibusMutaveis() {
		return onibusMutaveis;
	}



	public void setOnibusMutaveis(Integer[] onibusMutaveis) {
		this.onibusMutaveis = onibusMutaveis;
	}



	public Cromossomo getMelhorAteAgora() {
		return melhorAteAgora;
	}


	public void setMelhorAteAgora(Cromossomo melhorAteAgora) {
		this.melhorAteAgora = melhorAteAgora;
	}


	public double getMelhorFitness() {
		return melhorFitness;
	}


	public void setMelhorFitness(double melhorFitness) {
		this.melhorFitness = melhorFitness;
	}


	public void setMutaveis(Integer[] mutaveis) {
		this.mutaveis = mutaveis;
	}


	public Integer[] getMutaveis() {
		return mutaveis;
	}

	public double[] getTempoOnibus() {
		return tempoOnibus;
	}
	public void setTempoOnibus(double[] tempoOnibus) {
		this.tempoOnibus = tempoOnibus;
	}
	public TemposMedios getTm() {
		return tm;
	}
	public int getQtdPonto() {
		return qtdPonto;
	}
	public void setQtdPonto(int qtdPonto) {
		passageiros = new ArrayList[qtdPonto];
		this.qtdPonto = qtdPonto;
	}
	public ArrayList<Pessoa>[] getPassageiros() {
		return passageiros;
	}
	
	
	public ArrayList<Pessoa> getPassageirosListados() {
		return passageirosListados;
	}


	public void setPassageirosListados(ArrayList<Pessoa> passageirosListados) {
		this.passageirosListados = passageirosListados;
	}

	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		
		for(int i = 0; i < this.passageiros.length; i++) {
			this.passageiros[i] = new ArrayList<>();
			for(Pessoa p:passageiros) {
				if(p.getPartida() == i) {
					this.passageiros[i].add(p);
				}
			}
			
			Collections.sort(this.passageiros[i], new Comparator <Pessoa>() {

				@Override
				public int compare(Pessoa o1, Pessoa o2) {
					if (o1.getInicioEspera() >= o2.getInicioEspera())
						return 1;
					return -1;
				}
			});
			
		}
		
		
//		Collections.sort(passageiros, new Comparator <Pessoa>() {
//
//			@Override
//			public int compare(Pessoa o1, Pessoa o2) {
//				if (o1.getInicioEspera() >= o2.getInicioEspera())
//					return 1;
//				return -1;
//			}
//		});
		
		passageirosListados = passageiros;
	}
	
	
	public ArrayList<OnibusUtilizacao> getOnibusListados() {
		return onibusListados;
	}


	public int getFatorDivisao() {
		return fatorDivisao;
	}

	public void setOnibus(ArrayList<OnibusUtilizacao> onibus) {
		
//		this.onibus = new ArrayList[fatorDivisao];
//		
//		for(int i = 0; i < fatorDivisao; i++) {
//			this.onibus[i] = new ArrayList<>();
//		}
//		System.out.println(this.onibus.length);
//		System.out.println(this.onibus[0].size());
//		for(int j = 0; j< onibus.size(); j++) {
//			System.out.println(onibus.size());
//			System.out.println(tempoOnibus.length);
//			System.out.println((int)tempoOnibus[j]%fatorDivisao);
//			this.onibus[(int)tempoOnibus[j]%fatorDivisao].add(onibus.get(j));
//		}
		
		onibusListados= onibus;
	}
	public static void setInstance(BaseInfo instance) {
		BaseInfo.instance = instance;
	}
	public void setTm(TemposMedios temposMedios) {
		tm = temposMedios;
	}
	
}
