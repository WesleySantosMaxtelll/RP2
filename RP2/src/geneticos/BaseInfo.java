package geneticos;

import java.util.ArrayList;

import api_interface.TemposMedios;
import itens.OnibusUtilizacao;
import itens.Pessoa;


public class BaseInfo {
	private BaseInfo() {}
	private static BaseInfo instance = new BaseInfo();
	public static BaseInfo getInstance() {
		return instance;
	}
	
	private TemposMedios tm;
	private int qtdPonto;
	private ArrayList<Pessoa> passageiros;
	private ArrayList<OnibusUtilizacao> onibus;
	private double tempoOnibus[];
	
	
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
