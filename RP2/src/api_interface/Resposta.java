package api_interface;

import geneticos.Cromossomo;

public class Resposta {
	private Cromossomo[] ultimaGeracao;
	private double fitnessBaseline;
	private double[] fitnessPorGeracao;
	private PassageiroResposta[] passsageirosDados;
	private PassageiroResposta[] passsageirosDadosBaseline;
	
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
	public double[] getFitnessPorGeracao() {
		return fitnessPorGeracao;
	}
	public void setFitnessPorGeracao(double[] fitnessPorGeracao) {
		this.fitnessPorGeracao = fitnessPorGeracao;
	}

	public PassageiroResposta[] getPasssageirosDadosBaseline() {
		return passsageirosDadosBaseline;
	}
	public void setPasssageirosDadosBaseline(PassageiroResposta[] passsageirosDadosBaseline) {
		this.passsageirosDadosBaseline = passsageirosDadosBaseline;
	}
	public PassageiroResposta[] getPasssageirosDados() {
		return passsageirosDados;
	}
	public void setPasssageirosDados(PassageiroResposta[] passsageirosDados) {
		this.passsageirosDados = passsageirosDados;
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