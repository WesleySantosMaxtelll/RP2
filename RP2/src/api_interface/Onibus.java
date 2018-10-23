package api_interface;

public class Onibus {
	private int capacidade;
	private double horarioChegada;
	private int id;
	private boolean isFixo = false;
	
	
	public boolean isFixo() {
		return isFixo;
	}
	public void atribuiFixo() {
		this.isFixo = true;
	}
	
	public void atribuiModificavel() {
		this.isFixo = false;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public double getHorarioChegada() {
		return horarioChegada;
	}
	public void setHorarioChegada(double horarioChegada) {
		this.horarioChegada = horarioChegada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
