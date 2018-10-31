package api_interface;

public class PassageiroResposta {
	private double horarioTermino = Short.MAX_VALUE;
	private double inicioEspera = 0;
	private int destino = 0;
	private int partida = 0;
	
	public double getInicioEspera() {
		return inicioEspera;
	}
	public void setInicioEspera(double inicioEspera) {
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