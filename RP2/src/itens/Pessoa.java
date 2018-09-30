package itens;

public class Pessoa {
	
	private int destino = 0;
	private int partida = 0;
	private double inicioEspera = 0;// em que tempo(horario a pessoa chegou ao ponto)
	private double horarioChegada = Integer.MAX_VALUE;
	private int onibus = -1;
	
	public Pessoa(int destino, int partida, double inicioEspera) {
		super();
		this.destino = destino;
		this.partida = partida;
		this.inicioEspera = inicioEspera;
	}
	
	public void sobeNoOnibus(int i) {
		onibus = i;
	}
	
	public void desceDoOnibus() {
		onibus = -2;
	}
	
	public boolean estaEsperando() {
		if (onibus == -1) return true;
		return false;
	}
	
	public boolean estaNesteOnibus(int i) {
		if(onibus == i) return true;
		return false;
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
	public double getInicioEspera() {
		return inicioEspera;
	}
	public void setInicioEspera(double inicioEspera) {
		this.inicioEspera = inicioEspera;
	}
	public double getHorarioChegada() {
		return horarioChegada;
	}
	public void setHorarioChegada(double horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
	
	

}
