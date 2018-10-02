package geneticos;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;

public class Principal {
	
	
	
	
	static Cromossomo[] VidaCruel(Cromossomo[] cromossomos,int Maxgeracoes,double mutacaoTx,boolean[] alfabeto,ArrayList<Onibus> onibusd,ArrayList<Pessoa> passageiros){
		
		Fitness f=  new Fitness();
		
		//temos que ter uma popula�� aleatoria;
		
		double fitness[]=new double[cromossomos.length];
		Cromossomo[]geracaoAtual=cromossomos;
		
		for(int geracao=0;geracao<Maxgeracoes;geracao++){
			// para cada uma das geracoes 
			System.out.println("geracao G"+geracao);
			
			
			for(int aux=0; aux<fitness.length;aux++){
				fitness[aux]=f.calculaFitness(geracaoAtual[aux], onibusd, passageiros);
				System.out.println("Calculou fitness de :"+aux);
				System.out.println("fitness:"+1/fitness[aux]+"\n\n");
			}
			
			
			// para compor a nova geracao
			
			Roleta roleta = new Roleta(fitness);//roleta que escolhe individuos
			
			Cromossomo[] novaGeracao=new Cromossomo[cromossomos.length];
			
			double[]probabilidade ={0.8,0.05,0.15};//chances de cada opera��o genetica
			Roleta roletaOperacao = new Roleta(probabilidade);// roleta pra escolher a opera��o;
			
			for(int i=0;i<cromossomos.length;i++){
				//hora de escolher a opera�ao genetica
				
				int sorteio=roletaOperacao.sortear(); 
				
				switch(sorteio){
					case 0:
						novaGeracao[i]=OperadorGenetico.clonagem(geracaoAtual[roleta.sortear()]);
						break;
					case 1:
						novaGeracao[i]=OperadorGenetico.mutacao(geracaoAtual[roleta.sortear()], alfabeto);
						break;
					case 2:
						if(i==cromossomos.length-1){
							i--;
							continue;
						}
						novaGeracao[i]=OperadorGenetico.Crossover1(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
						novaGeracao[i+1]=OperadorGenetico.Crossover2(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
						i++;
						break;
				}
				
				
				
			}
			geracaoAtual=novaGeracao;
			
		}
		
		return geracaoAtual;
	}

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		testeOnibus();
		
//		
		Cromossomo[]cromossomos= new Cromossomo[6];
		for(int i=0;i<cromossomos.length;i++){
			cromossomos[i]= new Cromossomo(20);
		}
		boolean[]alfabeto={true,false};
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cromossomo[] geracao = VidaCruel(cromossomos, 10000, 3, alfabeto,todosOnibus(5),todosOsPassageiros());
		
		for(Cromossomo b:geracao) {
			System.out.println(Arrays.toString(b.getConteudo()));
		}
	}
	
	public static void testeOnibus() {
		int nOnibus = 5;
		int nPontos = 4;
		double tempoOnibus[] = {10, 15, 71, 80, 100};
		double tempoParadas[] = {3, 2, 4, 2};
		
		TemposMedios tm = TemposMedios.getInstance();
		tm.setTempoOnibus(tempoOnibus);
		tm.setTempoParada(tempoParadas);
		Cromossomo cromossomo = new Cromossomo(nPontos*nOnibus);
//		
//		boolean b[] = {
//				true, false, true, true,
//				false, true, true, false,
//				true, true, true, true,
//				true, false, false, true,
//				false, true, true, true
//		};
		boolean b[] = {
				false, true, false, false, false, true, false, true, false, false, false, false, true, true, false, true, true, true, false, false
		};
		cromossomo.setConteudo(b);
		
		double [][]temposTrajetos = {	{3, 7, 1, 3, 2}, 
										{2, 4, 2, 4, 2}, 
										{4, 5, 1, 6, 3}};
		
		tm.setTempoTrajetoEntrePontos(temposTrajetos);
		
		ArrayList<Onibus> oni = todosOnibus(nOnibus);
		ArrayList<Pessoa> pass = todosOsPassageiros();
		Fitness f = new Fitness();
//		System.out.println(pass.size());
//		for (Pessoa p: pass) {
//			System.out.println(p.getDestino() + " "+p.getPartida()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
//		}
//		for (Onibus p: oni) {
//			System.out.println(p.getCapacidade() + " "+p.getParada()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
//		}
//		
		long tempoInicial = System.currentTimeMillis();
		double t = f.calculaFitness(cromossomo, oni, pass);
		long tempoFinal = System.currentTimeMillis();
		System.out.println(tempoFinal - tempoInicial);
		System.out.println(1/t);
//		System.out.println(pass.size());
//		for (Pessoa p: pass) {
//			System.out.println(p.getDestino() + " "+p.getPartida()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
//		}
//		tempoInicial = System.currentTimeMillis();
//		t = f.calculaFitness(cromossomo, oni, pass);
//		tempoFinal = System.currentTimeMillis();
//		System.out.println(tempoFinal - tempoInicial);
//		System.out.println(t);
//	
	}
	

	public static ArrayList<Onibus> todosOnibus (int nOnibus){
		ArrayList<Onibus> onibusd= new ArrayList<>();
		for(int i = 0; i<nOnibus;i++) {
			Onibus novo = new Onibus();
			novo.setId(i);
			onibusd.add(novo);
		}
		return onibusd;
	}
	
	public static ArrayList<Pessoa> todosOsPassageiros() {
		ArrayList<Pessoa> passageiros = new ArrayList<>();
		Pessoa p1 = new Pessoa(2, 0, 9);
		passageiros.add(p1);
		Pessoa p2 = new Pessoa(3, 0, 78);
		passageiros.add(p2);
		Pessoa p3 = new Pessoa(3, 1, 35);
		passageiros.add(p3);
		Pessoa p4 = new Pessoa(3, 2, 81);
		passageiros.add(p4);
		Pessoa p5 = new Pessoa(3, 2, 40);
		passageiros.add(p5);
		return passageiros;
	}
	
}
