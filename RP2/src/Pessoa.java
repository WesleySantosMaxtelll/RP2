
public class Pessoa {
	
	int destino=0;
	float inicioEspera=0;// em que tempo(horario a pessoa chegou ao ponto)
	
	public Pessoa(int pontoAtual){
		
		destino= 0;// tem que ser um ponto depois do ponto atual;
		inicioEspera=Cronos.tempoUniversal;// começou a espera;
	}

}
