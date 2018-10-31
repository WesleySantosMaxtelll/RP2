package geneticos;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
	private ArrayList<Pessoa> passageiros;
	private ArrayList<OnibusUtilizacao> onibus;
	private double tempoOnibus[];
	private Integer[] mutaveis;
	
	public void definePermitidos(ArrayList<Onibus> onibus, int qtdPontos) {
		ArrayList<Integer> a = new ArrayList<>();
		for(Onibus o:onibus) {
			if(!o.isFixo()) {
				for(int i = onibus.indexOf(o)*qtdPontos; i < (1+onibus.indexOf(o))*qtdPontos;i++) {
					a.add(i);
				}
			}
		}
		mutaveis = new Integer[a.size()];
		mutaveis = a.toArray(mutaveis);
		
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
		this.qtdPonto = qtdPonto;
	}
	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}
	public ArrayList<OnibusUtilizacao> getOnibus() {
		return onibus;
	}
	public void setOnibus(ArrayList<OnibusUtilizacao> onibus) {
		this.onibus = onibus;
	}
	public static void setInstance(BaseInfo instance) {
		BaseInfo.instance = instance;
	}
	public void setTm(TemposMedios temposMedios) {
		tm = temposMedios;
	}
	
}
