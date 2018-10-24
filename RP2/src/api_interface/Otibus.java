package api_interface;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import geneticos.BaseInfo;
import geneticos.Cromossomo;
import geneticos.Fitness;
import geneticos.Grafico1;
import geneticos.OperadorGenetico;
import geneticos.Principal;
import geneticos.Roleta;
import itens.OnibusUtilizacao;
import itens.Pessoa;

public class Otibus {
	
	
	public Resposta start(ArrayList<Passageiros> passageiros, ArrayList<Onibus> onibus, TemposMedios temposMedios,
			int quantidadePontos, int numeroGeracoes) {
		
//		double[] fitnessGeracao = new double[numeroGeracoes];
//		boolean[] fixos = defineTrajetosconstantes(onibus);
//		ArrayList<PassageiroResposta> prBaseline = new ArrayList<PassageiroResposta>();
//		ArrayList<PassageiroResposta> prUltimaGeracao = new ArrayList<PassageiroResposta>();
		ArrayList<OnibusUtilizacao> oni = defineOnibus(onibus);
		ArrayList<Pessoa> pass = definePassageiros(passageiros);
		BaseInfo base = BaseInfo.getInstance();
		base.setOnibus(oni);
		base.setPassageiros(pass);
		base.setTm(temposMedios);
		base.setQtdPonto(quantidadePontos);
		atualizeTempoOnibus(onibus, base);
		Cromossomo[]cromossomos = definePrimeiraGeracao(quantidadePontos, onibus);
//		rodaTeste();
		run(cromossomos);
//		for (OnibusUtilizacao o:oni) {
//			System.out.println(o.getCapacidade());
//		}
		return null;
	}
	
	private void rodaTeste() {
		boolean b[] = {
			true, false, true, false,
			true, true, true, false,
			false, true, false, true,
			true, false, false, true,
			false, false, true, true
	};
		
		Cromossomo c = new Cromossomo(b);
		Fitness f = new Fitness();
		System.out.println(f.calculaFitness(c));
	}
	
	private void run(Cromossomo[]cromossomos) {
		boolean[]alfabeto={true,false};
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cromossomo[] geracao = Principal.VidaCruel(cromossomos, 10, 3, alfabeto);
		
		for(Cromossomo b:geracao) {
			System.out.println(Arrays.toString(b.getConteudo()));
		}
	}
	
	private Cromossomo[] definePrimeiraGeracao(int quantidadePontos, ArrayList<Onibus> onibus) {
		Cromossomo[]cromossomos= new Cromossomo[10];
		for(int i=0;i<cromossomos.length;i++){
			cromossomos[i]= new Cromossomo(quantidadePontos,onibus);
		}
		
		return cromossomos;
	}
	
	
	private void atualizeTempoOnibus(ArrayList<Onibus> onibus, BaseInfo base) {
		double[] tempoOnibus = new double[onibus.size()];
		for (Onibus o:onibus) {
			tempoOnibus[onibus.indexOf(o)] = o.getHorarioChegada();
		}
		base.setTempoOnibus(tempoOnibus);
	}
	
	private ArrayList<OnibusUtilizacao> defineOnibus(ArrayList<Onibus> onibus) {
		ArrayList<OnibusUtilizacao> oni = new ArrayList<OnibusUtilizacao>();
		for(Onibus o:onibus) {
			OnibusUtilizacao novo = new OnibusUtilizacao();
			novo.setId(o.getId());
			novo.setCapacidade(o.getCapacidade());
			oni.add(novo);
		}
		return oni;
	}
	
	private boolean[] defineTrajetosconstantes(ArrayList<Onibus> onibus) {
		boolean[] fixos = new boolean[onibus.size()];
		for(Onibus o:onibus) {
			fixos[onibus.indexOf(o)] = o.isFixo();
		}
		return fixos;
	}
	private ArrayList<Pessoa> definePassageiros(ArrayList<Passageiros> passageiros) {
		ArrayList<Pessoa> pass = new ArrayList<Pessoa>();
		for(Passageiros p:passageiros) {
			Pessoa novo = new Pessoa(p.getDestino(), p.getPartida(), p.getInicioEspera());
			pass.add(novo);
		}
		return pass;
	}
	
	private double calculeBaseline(int quantidadePontos, ArrayList<Onibus> onibus, ArrayList<PassageiroResposta> pass) {
		Fitness f = new Fitness();
		boolean[] baselineTeste = new boolean[quantidadePontos*onibus.size()];
		Cromossomo c = new Cromossomo(baselineTeste);
		Arrays.fill(baselineTeste, Boolean.TRUE);
		return f.calculaFitness(c);
	}
}
