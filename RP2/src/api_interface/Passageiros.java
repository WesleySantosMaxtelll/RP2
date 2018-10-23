package api_interface;

public class Passageiros {
	private int destino = 0;
	private int partida = 0;
	private double inicioEspera = 0;
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
	
}
