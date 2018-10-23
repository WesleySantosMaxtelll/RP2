package api_interface;

public interface TemposMedios {
	public double tempoEntrePontos(int ponto, int idOnibus, double tempoCorrente);
	public double tempoParadoNoPonto(int ponto, int idOnibus, double tempoCorrente, int quatidadePassageiros);
	
}
