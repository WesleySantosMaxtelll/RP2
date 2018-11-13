package api_interface;

import java.util.ArrayList;

import geneticos.Cromossomo;

public class Resposta {
	private Cromossomo[] ultimaGeracao;
	private double fitnessBaseline;
	private ArrayList<Double> fitnessPorGeracao;
	
	private ArrayList<PassageiroResposta> baseline= new ArrayList<>();
	private ArrayList<PassageiroResposta> melhorGeracao= new ArrayList<>();
	
	
	
	public ArrayList<PassageiroResposta> getBaseline() {
		return baseline;
	}
	public void setBaseline(ArrayList<PassageiroResposta> baseline) {
		this.baseline = baseline;
	}
	public ArrayList<PassageiroResposta> getMelhorGeracao() {
		return melhorGeracao;
	}
	public void setMelhorGeracao(ArrayList<PassageiroResposta> melhorGeracao) {
		this.melhorGeracao = melhorGeracao;
	}
	public Cromossomo[] getUltimaGeracao() {
		return ultimaGeracao;
	}
	public void setUltimaGeracao(Cromossomo[] ultimaGeracao) {
		this.ultimaGeracao = ultimaGeracao;
	}
	public double getFitnessBaseline() {
		return fitnessBaseline;
	}
	public void setFitnessBaseline(double fitnessBaseline) {
		this.fitnessBaseline = fitnessBaseline;
	}
	public ArrayList<Double> getFitnessPorGeracao() {
		return fitnessPorGeracao;
	}
	public void setFitnessPorGeracao(ArrayList<Double> fitnessPorGeracao) {
		this.fitnessPorGeracao = fitnessPorGeracao;
	}
}

