package geneticos;

import java.awt.PageAttributes;
import java.util.ArrayList;

import itens.Onibus;
import itens.Pessoa;
import itens.TemposMedios;

public class Principal {
	
//	static double fitnessTroll(Cromossomo c){
//		double saida=0;
//		if(c.conteudo[0]==1)saida++;
//		if(c.conteudo[1]==2)saida++;
//		if(c.conteudo[2]==3)saida++;
//		if(c.conteudo[3]==4)saida++;
//		if(c.conteudo[4]==5)saida++;
//		return saida;
//	}
//	
//	static void VidaCruel(Cromossomo[] cromossomos,int Maxgeracoes,double mutacaoTx,int[] alfabeto){
//		
//		//temos que ter uma popula�� aleatoria;
//		
//		double fitness[]=new double[cromossomos.length];
//		Cromossomo[]geracaoAtual=cromossomos;
//		
//		for(int geracao=0;geracao<Maxgeracoes;geracao++){
//			// para cada uma das geracoes 
//			System.out.println("gera��o G"+geracao);
//			
//			
//			for(int aux=0; aux<fitness.length;aux++){
//				fitness[aux]=fitnessTroll(geracaoAtual[aux]);///FUNCAO DE MEDIR O FITNESS DO CROMOSSOMO
//			}
//			
//			
//			// para compor a nova geracao
//			
//			Roleta roleta = new Roleta(fitness);//roleta que escolhe individuos
//			
//			Cromossomo[] novaGeracao=new Cromossomo[cromossomos.length];
//			
//			double[]probabilidade ={0.8,0.05,0.15};//chances de cada opera��o genetica
//			Roleta roletaOperacao = new Roleta(probabilidade);// roleta pra escolher a opera��o;
//			
//			for(int i=0;i<cromossomos.length;i++){
//				//hora de escolher a opera�ao genetica
//				
//				int sorteio=roletaOperacao.sortear(); 
//				
//				switch(sorteio){
//					case 0:
//						novaGeracao[i]=OperadorGenetico.clonagem(geracaoAtual[roleta.sortear()]);
//						break;
//					case 1:
//						novaGeracao[i]=OperadorGenetico.mutacao(geracaoAtual[roleta.sortear()], alfabeto);
//						break;
//					case 2:
//						if(i==cromossomos.length-1){
//							i--;
//							continue;
//						}
//						novaGeracao[i]=OperadorGenetico.Crossover1(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
//						novaGeracao[i+1]=OperadorGenetico.Crossover2(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
//						i++;
//						break;
//				}
//				
//				
//				
//			}
//			geracaoAtual=novaGeracao;
//			for(Cromossomo c: geracaoAtual){
//				for(Integer i: c.conteudo){
//					System.out.print(i.intValue());
//				}
//				System.out.println("");
//			}
//		}
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testeOnibus();
		
//		Cromossomo[]cromossomos= new Cromossomo[100];
//		for(int i=0;i<cromossomos.length;i++){
//			cromossomos[i]= new Cromossomo(5);
//		}
//		int[]alfabeto={1,2,3,4,5,6,7,8,9,0};
//		VidaCruel(cromossomos, 100, 3, alfabeto);

	}
	
	public static void testeOnibus() {
		int nOnibus = 5;
		int nPontos = 4;
		double tempoOnibus[] = {10, 15, 71, 80, 100};
		double tempoParadas[] = {3, 2, 4, 22};
		TemposMedios tm = TemposMedios.getInstance();
		tm.setTempoOnibus(tempoOnibus);
		tm.setTempoParada(tempoParadas);
		Cromossomo cromossomo = new Cromossomo(nPontos*nPontos);
		
		boolean b[] = {
				true, false, true, true,
				false, true, true, false,
				true, true, true, true,
				true, false, false, true,
				false, true, true, true
		};
		
		
		cromossomo.setConteudo(b);
		
		double [][]temposTrajetos = {	{3, 7, 1, 3, 2}, 
										{2, 4, 2, 4, 2}, 
										{4, 5, 1, 6, 3}};
		
		tm.setTempoTrajetoEntrePontos(temposTrajetos);
		ArrayList<Onibus> onibusd= new ArrayList<>();
		for(int i = 0; i<nOnibus;i++) {
			Onibus novo = new Onibus();
			novo.setId(i);
			onibusd.add(novo);
		}
		
		Fitness f = new Fitness();
		long tempoInicial = System.currentTimeMillis();
		f.calculaFitness(cromossomo, onibusd, todosOsPassageiros());
		long tempoFinal = System.currentTimeMillis();
		System.out.println(tempoFinal - tempoInicial);
//		System.out.println(f.calculaFitness(cromossomo, onibusd, todosOsPassageiros()));
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
