package itens;

import java.util.ArrayList;

import teste.GeradorTeste;

public class Principal {

	public static void main(String[] args) {
//		for(int i = 0; i < 10; i++) {
//			int g = (int)(Math.random()*10);
//			int h = (int)(Math.random()*(10-g)+g+1);
//			System.out.println(g + " "+h);
//		}
		GeradorTeste gerador = new GeradorTeste();
		gerador.criarCenario(60, 30, 1000);
		ArrayList<Pessoa> pessoas = gerador.getPassageiros();
		for(Pessoa p:pessoas) {
			System.out.println(p.getInicioEspera()+" "+p.getPartida() + " "+p.getDestino());
		}
//		ArrayList<Onibus> onibus = gerador.geraOnibus(50);
//		TemposMedios instancia = TemposMedios.getIntance();
//		System.out.println("****************************************\n");
//		for(Onibus o:onibus) {
//			
//			System.out.println(o.getId());
//			System.out.println(instancia.getTempoOnibus()[o.getId()]);
//			System.out.println("****************************************\n");
//		}
	}

}
