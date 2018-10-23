package api_interface;
import java.util.ArrayList;
import java.util.Arrays;

import itens.OnibusUtilizacao;
import itens.Pessoa;

public class Otibus {
	
	
	public Resposta start(ArrayList<Passageiros> passageiros, ArrayList<Onibus> onibus, TemposMedios temposMedios,
			int quantidadePontos) {
		boolean[] baselineTeste = new boolean[quantidadePontos*onibus.size()];
		Arrays.fill(baselineTeste, Boolean.TRUE);
		
		ArrayList<OnibusUtilizacao> oni = new ArrayList<OnibusUtilizacao>();
		for(Onibus o:onibus) {
			OnibusUtilizacao novo = new OnibusUtilizacao();
			novo.setId(o.getId());
			novo.setCapacidade(o.getCapacidade());
			
			oni.add(novo);
		}
		
		ArrayList<Pessoa> pass = new ArrayList<Pessoa>();
		
		return null;
	}
	
}
