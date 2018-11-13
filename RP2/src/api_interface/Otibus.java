package api_interface;
import java.io.File;
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
			int quantidadePontos, int numeroGeracoes, String versao, File file) {
		
//		double[] fitnessGeracao = new double[numeroGeracoes];
//		boolean[] fixos = defineTrajetosconstantes(onibus);
//		ArrayList<PassageiroResposta> prBaseline = new ArrayList<PassageiroResposta>();
//		ArrayList<PassageiroResposta> prUltimaGeracao = new ArrayList<PassageiroResposta>();
		Resposta resposta = new Resposta();
		ArrayList<OnibusUtilizacao> oni = defineOnibus(onibus);
//		System.out.println("aqui "+oni.size());
		ArrayList<Pessoa> pass = definePassageiros(passageiros);
		BaseInfo base = BaseInfo.getInstance();
		
//		for(Pessoa as:pass)
//			System.out.println(as.getInicioEspera());
//		
//		System.out.println("aquuuuuui");
		atualizeTempoOnibus(onibus, base);
		base.setQtdPonto(quantidadePontos);
		base.setOnibus(oni);
		base.setPassageiros(pass);
		
//		for(Pessoa as:base.getPassageiros())
//			System.out.println(as.getInicioEspera());
		
		base.setTm(temposMedios);
		
		base.definePermitidos(onibus, quantidadePontos);
//		ArrayList<Pessoa>[] z = base.getPassageiros();
//		ArrayList<OnibusUtilizacao>[] onibusPorTempo = base.getOnibus();
		
//		for(int i = 0; i < onibusPorTempo.length; i++) {
//			for(OnibusUtilizacao p:onibusPorTempo[i])
//				System.out.print(p.getId()+ "\t");
//			System.out.println("");
//		}
//		System.out.println(base.getMutaveis().length);
		
//		for(int z = 0; z < base.getMutaveis().length; z++)
//			System.out.println(base.getMutaveis()[z]);
//		
//		resposta.setFitnessBaseline(calculeBaseline(quantidadePontos,onibus.size()));
//		System.out.println(calculeBaseline(quantidadePontos,onibus.size()));
//		System.out.println(calculeBaseline(quantidadePontos,onibus.size()));
//		System.out.println(calculeBaseline(quantidadePontos,onibus.size()));
//		System.out.println(calculeBaseline(quantidadePontos,onibus.size()));
//		System.out.println(resposta.getFitnessBaseline());
		Cromossomo[]cromossomos = definePrimeiraGeracao(quantidadePontos, onibus);
//		rodaTeste();

//		rodaTeste();
		run(cromossomos, resposta, numeroGeracoes, versao, file);
//		for (OnibusUtilizacao o:oni) {
//			System.out.println(o.getCapacidade());
//		}
		return resposta;
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
		for(boolean s:c.getConteudo())
			System.out.println(s);
		Fitness f = new Fitness();
		System.out.println(f.calculaFitness(c, null));
	}
	
	private void run(Cromossomo[]cromossomos, Resposta resposta, int geracoes, String versao, File file) {
		boolean[]alfabeto={true,false};
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cromossomo[] geracao = Principal.VidaCruel(cromossomos, geracoes, 3, alfabeto, resposta, versao, file);
		resposta.setUltimaGeracao(geracao);
		
	}
	
	private Cromossomo[] definePrimeiraGeracao(int quantidadePontos, ArrayList<Onibus> onibus) {
		Cromossomo[]cromossomos= new Cromossomo[20];
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
	
	private double calculeBaseline(int quantidadePontos, int onibus) {
		Fitness f = new Fitness();
		boolean[] baselineTeste = new boolean[quantidadePontos*onibus];
		Cromossomo c = new Cromossomo(baselineTeste);
		Arrays.fill(baselineTeste, Boolean.TRUE);
		return f.calculaFitness(c, null);
	}
}
