package teste;

import java.util.ArrayList;

import api_interface.Onibus;
import api_interface.Otibus;
import api_interface.Passageiros;
import api_interface.TemposMedios;

public class TesteAPI {
	public static ArrayList<Passageiros> todosOsPassageiros() {
		
		ArrayList<Passageiros> passageiros = new ArrayList<>();
		Passageiros p1 = new Passageiros();
		p1.setDestino(2);
		p1.setPartida(0);
		p1.setInicioEspera(9);
		passageiros.add(p1);
		Passageiros p2 = new Passageiros();
		p2.setDestino(3);
		p2.setPartida(0);
		p2.setInicioEspera(78);
		passageiros.add(p2);
		Passageiros p3 = new Passageiros();
		p3.setDestino(3);
		p3.setPartida(1);
		p3.setInicioEspera(35);
		passageiros.add(p3);
		Passageiros p4 = new Passageiros();
		p4.setDestino(3);
		p4.setPartida(2);
		p4.setInicioEspera(81);
		passageiros.add(p4);
		Passageiros p5 = new Passageiros();
		p5.setDestino(3);
		p5.setPartida(2);
		p5.setInicioEspera(40);
		passageiros.add(p5);
		return passageiros;
	}
	
	public static ArrayList<Onibus> todosOnibus (double[] tempos){
		ArrayList<Onibus> onibusd= new ArrayList<>();
		for(int i = 0; i<tempos.length;i++) {
			Onibus novo = new Onibus();
			novo.setId(i);
			novo.atribuiModificavel();
			novo.setCapacidade(60);
			novo.setHorarioChegada(tempos[i]);
			novo.atribuiModificavel();
			onibusd.add(novo);
		}
		return onibusd;
	}
	
	public static void main(String[] args) {
		double tempoOnibus[] = {10, 15, 71, 80, 100};
		
		ArrayList<Passageiros> passageiros = todosOsPassageiros();
		ArrayList<Onibus> onibus = todosOnibus(tempoOnibus);
		
		int qtdPontos = 4;
		int nGeracoes = 5;
		
//		Cromossomo c = new Cromossomo(qtdPontos, onibus);
//		for(int i = 0; i <c.getConteudo().length; i++)
//			System.out.println(c.getConteudo()[i]);
		
		valores v = new valores();
		Otibus o = new Otibus();
	
		o.start(passageiros, onibus, v, qtdPontos, nGeracoes);
	}
}

class valores implements TemposMedios{
	double tempoParadas[] = {3, 2, 4, 2};
	double [][]temposTrajetos = {	
			{3, 7, 1, 3, 2}, 
			{2, 4, 2, 4, 2}, 
			{4, 5, 1, 6, 3}};
	@Override
	public double tempoEntrePontos(int ponto, int idOnibus, double tempoCorrente) {
		// TODO Auto-generated method stub
		return temposTrajetos[ponto][idOnibus];
	}

	@Override
	public double tempoParadoNoPonto(int ponto, int idOnibus, double tempoCorrente, int quatidadePassageiros) {
		// TODO Auto-generated method stub
		return tempoParadas[ponto];
	}
	
}
