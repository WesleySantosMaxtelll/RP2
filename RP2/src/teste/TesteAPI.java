package teste;

import java.util.ArrayList;
import java.util.Random;

import api_interface.Onibus;
import api_interface.Otibus;
import api_interface.PassageiroResposta;
import api_interface.Passageiros;
import api_interface.Resposta;
import api_interface.TemposMedios;
import graficos.GraficoCompPopoli;

public class TesteAPI {
	public static ArrayList<Passageiros> todosOsPassageiros() throws Exception {
		
		ArrayList<Passageiros> passageiros = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 1000; i++) {
			Passageiros p1 = new Passageiros();
			int origem = 0;
			if(Math.random() > 0.8)
				origem = rand.nextInt(15);
			else
				origem = rand.nextInt(4);
			
			int dest = 0;
			if(Math.random() > 0.2 && origem < 4)
				dest = 8 + rand.nextInt(16-8);
			else
				dest = origem+1 + rand.nextInt(15-origem);
			 
			p1.setDestino(dest);
			p1.setPartida(origem);
			int temp = 0;
			if(Math.random() > 0.7 && origem  < 4)
				temp = 120 + rand.nextInt(200-120);
			else
				temp = 2 + rand.nextInt(550 - 2);
			p1.setInicioEspera(temp);
			passageiros.add(p1);
			
		}
		for(Passageiros p:passageiros) {
			if(p.getDestino() > 15) throw new Exception("alem do possivel");
		}
		
//		Passageiros p1 = new Passageiros();
//		p1.setDestino(2);
//		p1.setPartida(0);
//		p1.setInicioEspera(9);
//		passageiros.add(p1);
//		Passageiros p2 = new Passageiros();
//		p2.setDestino(3);
//		p2.setPartida(0);
//		p2.setInicioEspera(78);
//		passageiros.add(p2);
//		Passageiros p3 = new Passageiros();
//		p3.setDestino(3);
//		p3.setPartida(1);
//		p3.setInicioEspera(35);
//		passageiros.add(p3);
//		Passageiros p4 = new Passageiros();
//		p4.setDestino(3);
//		p4.setPartida(2);
//		p4.setInicioEspera(81);
//		passageiros.add(p4);
//		Passageiros p5 = new Passageiros();
//		p5.setDestino(3);
//		p5.setPartida(2);
//		p5.setInicioEspera(40);
//		passageiros.add(p5);
		return passageiros;
	}
	
	public static ArrayList<Onibus> todosOnibus (double[] tempos){
		ArrayList<Onibus> onibusd= new ArrayList<>();
		for(int i = 0; i<tempos.length;i++) {
			Onibus novo = new Onibus();
			novo.setId(i);
//			if (Math.random() > 0.5)
			novo.atribuiModificavel();
			novo.setCapacidade(120);
			novo.setHorarioChegada(tempos[i]);
			onibusd.add(novo);
		}
		return onibusd;
	}
	
	public static void main(String[] args) throws Exception {
//		double tempoOnibus[] = {10, 15, 71, 80, 100};
		double tempoOnibus[] = {10, 50, 90, 120, 150, 170, 195, 220, 280, 350, 375, 400, 450, 480, 510, 550, 580, 600, 640, 660};
		ArrayList<Passageiros> passageiros = todosOsPassageiros();
		ArrayList<Onibus> onibus = todosOnibus(tempoOnibus);
		
		int qtdPontos = 16;
		int nGeracoes = 30;
		
//		Cromossomo c = new Cromossomo(qtdPontos, onibus);
//		for(int i = 0; i <c.getConteudo().length; i++)
//			System.out.println(c.getConteudo()[i]);
		
		valores v = new valores();
		Otibus o = new Otibus();
//		v.mostra();
		Resposta r = o.start(passageiros, onibus, v, qtdPontos, nGeracoes);
		for(PassageiroResposta pr:r.getMelhorGeracao()) {
			System.out.println(pr.getDestino() + " "+pr.getPartida() + " " +pr.getHorarioTermino() + " "+pr.getOnibusId());
		}
		
		for(PassageiroResposta pr:r.getBaseline()) {
			System.out.println(pr.getDestino() + " "+pr.getPartida() + " " +pr.getHorarioTermino() + " "+pr.getOnibusId());
		}
		new GraficoCompPopoli(r.getBaseline(), r.getMelhorGeracao());
//		System.out.println(r.getFitnessBaseline());
//		System.out.println(r.getUltimaGeracao()[0]);
	}
}

class valores implements TemposMedios{
//	 {10, 15, 71, 80, 100};
//	double tempoParadas[] = {3, 2, 4, 2};
	double tempoParadas[] = {6, 7, 8, 12, 5, 28, 12, 4, 6, 7, 12, 9, 4, 7, 13, 8};
//	double [][]temposTrajetos = {	
//			{3, 7, 1, 3, 2}, 
//			{2, 4, 2, 4, 2}, 
//			{4, 5, 1, 6, 3}};
	double [][]temposTrajetos = new double[16][20];
	Random rand = new Random(); 
	public valores() {
		for (int i = 0; i < temposTrajetos.length; i++) {     
	        for (int j = 0; j < temposTrajetos[0].length; j++) {
	        	temposTrajetos[i][j] = 40 + rand.nextInt((100 - 40));
	        }
	    }
	}
	
	public void mostra() {
		for (int i = 0; i < temposTrajetos.length; i++) {     
	        for (int j = 0; j < temposTrajetos[0].length; j++) {
	            System.out.println(temposTrajetos[i][j]);
	        } 
	    }
	}
//	double [][]temposTrajetos = {	
//			{3, 7, 1, 3, 2}, 
//			{2, 4, 2, 4, 2}, 
//			{4, 5, 1, 6, 3}};
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
