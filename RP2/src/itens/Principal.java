package itens;

import java.util.ArrayList;

import teste.GeradorTeste;

public class Principal {

	public static void main(String[] args) {
		GeradorTeste gerador = new GeradorTeste();
		ArrayList<Onibus> onibus = gerador.geraOnibus(10);
		TemposMedios instancia = TemposMedios.getIntance();
		for(Onibus o:onibus) {
			
			System.out.println(o.getId());
			System.out.println(instancia.get);
		}
	}

}
