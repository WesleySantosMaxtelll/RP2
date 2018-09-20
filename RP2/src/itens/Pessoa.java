package itens;

public class Pessoa {
	
	private int destino = 0;
	private int partida = 0;
	private float inicioEspera = 0;// em que tempo(horario a pessoa chegou ao ponto)
	private float horarioChegada = 0;
	public Pessoa(int destino, int partida, float inicioEspera) {
		super();
		this.destino = destino;
		this.partida = partida;
		this.inicioEspera = inicioEspera;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	public int getPartida() {
		return partida;
	}
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public float getInicioEspera() {
		return inicioEspera;
	}
	public void setInicioEspera(float inicioEspera) {
		this.inicioEspera = inicioEspera;
	}
	public float getHorarioChegada() {
		return horarioChegada;
	}
	public void setHorarioChegada(float horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
	
	

}
