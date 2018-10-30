package api_interface;

import java.util.ArrayList;

import geneticos.Cromossomo;

public class Resposta {
	private Cromossomo[] ultimaGeracao;
	private double fitnessBaseline;
	private ArrayList<Double> fitnessPorGeracao;
	
	
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


class PassageiroResposta {
	private double horarioTermino = Short.MAX_VALUE;
	private int onibusId = -1;
	public double getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(double horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public int getOnibusId() {
		return onibusId;
	}
	public void setOnibusId(int onibusId) {
		this.onibusId = onibusId;
	}
	
}