package geneticos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import api_interface.PassageiroResposta;
import api_interface.Resposta;
import itens.OnibusUtilizacao;
import itens.Pessoa;
import itens.TemposMedios;

public class Principal {
	
public static Cromossomo[] VidaCruel(Cromossomo[] cromossomos,int Maxgeracoes,double mutacaoTx,boolean[] alfabeto, Resposta resposta){
		
		Fitness f=  new Fitness();
		//temos que ter uma populaçã aleatoria;
		ArrayList<Double>fitMedio=new ArrayList<>();
		
		double fitness[]=new double[cromossomos.length];// para armazenar os fitness;
		Cromossomo[]geracaoAtual=cromossomos;
		Cromossomo cAux=new Cromossomo(cromossomos[0].conteudo.length);
		cAux.setRotaPadrao();
		resposta.setBaseline(new ArrayList<PassageiroResposta>());
		double daux=f.calculaFitness(cAux, resposta.getBaseline());
		for(int geracao=0;geracao<Maxgeracoes;geracao++){
			// para cada uma das geracoes 
			
			System.out.println("Geração G"+geracao);
			
			double totalFitness=0;
//			System.out.println("Fitness por cromossomo:");
			for(int aux=0; aux<fitness.length;aux++){
				double tempFit = f.calculaFitness(geracaoAtual[aux], null);
				fitness[aux]=tempFit;
//				System.out.println(tempFit);
				totalFitness+=1/tempFit;///FUNCAO DE MEDIR O FITNESS DO CROMOSSOMO
			}
			
//			System.out.println("/------------------/");
		
			
			// para compor a nova geracao
			
			Roleta roleta = new Roleta(fitness);//roleta que escolhe individuos
			
			Cromossomo[] novaGeracao=new Cromossomo[cromossomos.length];
			
			double[]probabilidade ={1,(500/(geracao*0.3+1)),1};//chances de cada operação genetica
			Roleta roletaOperacao = new Roleta(probabilidade);// roleta pra escolher a operação;
			
			for(int i=0;i<cromossomos.length;i++){
				//hora de escolher a operaçao genetica
				
				int sorteio=roletaOperacao.sortear(); 
				
				switch(sorteio){
					case 0:
						novaGeracao[i]=OperadorGenetico.clonagem(geracaoAtual[roleta.sortear()]);
						//System.out.println("clonagem");
						break;
					case 1:
//						System.out.println("aqui:"+sorteio+" "+i+" "+roleta.sortear());
						
						novaGeracao[i]=OperadorGenetico.mutacao(geracaoAtual[roleta.sortear()], alfabeto);
						//System.out.println("mutação");
						break;
					case 2:
						if(i==cromossomos.length-1){
							i--;
							continue;
						}
						//System.out.println("crossover");
						novaGeracao[i]=OperadorGenetico.Crossover1(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
						novaGeracao[i+1]=OperadorGenetico.Crossover2(geracaoAtual[roleta.sortear()],geracaoAtual[roleta.sortear()]);
						i++;
						break;
				}
				
				
				
			}
			System.out.println("F:"+totalFitness/geracaoAtual.length);
			System.out.println("");
			geracaoAtual=novaGeracao;
			fitMedio.add(totalFitness/geracaoAtual.length);
			
			
		}
		
//		double ftest = 0;
//		ArrayList<PassageiroResposta> pr = new ArrayList<>();
//		int h = -1;
//		for(int i = 0; i < geracaoAtual.length; i++) {
//			ArrayList<PassageiroResposta> temp = new ArrayList<>();
//			double ft = f.calculaFitness(geracaoAtual[i], temp);
//			if(ft > ftest) {
//				pr = temp;
//				h = i;
//			}
//		}
//		resposta.setMelhorGeracao(pr);
//		resposta.setUltimaGeracao(geracaoAtual[h]);
		JOptionPane.showMessageDialog(null, 1/daux);
		new Grafico1(fitMedio,1/daux);
		return geracaoAtual;
	}



//
//	public static void main(String[] args) {
//		 //TODO Auto-generated method stub
//		
//		testeOnibus();
//		
////		
//		Cromossomo[]cromossomos= new Cromossomo[10];
//		for(int i=0;i<cromossomos.length;i++){
//			cromossomos[i]= new Cromossomo(20);
//		}
//		boolean[]alfabeto={true,false};
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Cromossomo[] geracao = VidaCruel(cromossomos, 2, 3, alfabeto);
//		
//		for(Cromossomo b:geracao) {
//			System.out.println(Arrays.toString(b.getConteudo()));
//		}
//	}
//	
//	public static void testeOnibus() {
//		int nOnibus = 5;
//		int nPontos = 4;
//		double tempoOnibus[] = {10, 15, 71, 80, 100};
//		double tempoParadas[] = {3, 2, 4, 2};
////		
//		TemposMedios tm = TemposMedios.getInstance();
//		tm.setTempoOnibus(tempoOnibus);
//		tm.setTempoParada(tempoParadas);
//		Cromossomo cromossomo = new Cromossomo(nPontos*nOnibus);
////		
////		boolean b[] = {
////				true, false, true, true,
////				false, true, true, false,
////				true, true, true, true,
////				true, false, false, true,
////				false, true, true, true
////		};
//		boolean b[] = {
//				true,true,true,true,
//				true,true,true,true,
//				true,true,true,true,
//				true,true,true,true,
//				true,true,true,true
//		};
//		cromossomo.setConteudo(b);
//		
//		tm.setTempoTrajetoEntrePontos(temposTrajetos);
//		
//		ArrayList<OnibusUtilizacao> oni = todosOnibus(nOnibus);
//		ArrayList<Pessoa> pass = todosOsPassageiros();
//		Fitness f = new Fitness();
////		System.out.println(pass.size());
////		for (Pessoa p: pass) {
////			System.out.println(p.getDestino() + " "+p.getPartida()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
////		}
////		for (Onibus p: oni) {
////			System.out.println(p.getCapacidade() + " "+p.getParada()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
////		}
////		
//		long tempoInicial = System.currentTimeMillis();
//		double t = f.calculaFitness(cromossomo);
//		long tempoFinal = System.currentTimeMillis();
//		System.out.println(tempoFinal - tempoInicial);
//		System.out.println(t);
////		System.out.println(pass.size());
////		for (Pessoa p: pass) {
////			System.out.println(p.getDestino() + " "+p.getPartida()+ " "+p.getHorarioChegada()+" "+p.getInicioEspera());
////		}
//		tempoInicial = System.currentTimeMillis();
//		t = f.calculaFitness(cromossomo);
//		tempoFinal = System.currentTimeMillis();
//		System.out.println(tempoFinal - tempoInicial);
//		System.out.println(t);
//	
//	}
	

//	public static ArrayList<OnibusUtilizacao> todosOnibus (int nOnibus){
//		ArrayList<OnibusUtilizacao> onibusd= new ArrayList<>();
//		for(int i = 0; i<nOnibus;i++) {
//			OnibusUtilizacao novo = new OnibusUtilizacao();
//			novo.setId(i);
//			onibusd.add(novo);
//		}
//		return onibusd;
//	}
//	
//	public static ArrayList<Pessoa> todosOsPassageiros() {
//		
//		ArrayList<Pessoa> passageiros = new ArrayList<>();
//		Pessoa p1 = new Pessoa(2, 0, 9);
//		passageiros.add(p1);
//		Pessoa p2 = new Pessoa(3, 0, 78);
//		passageiros.add(p2);
//		Pessoa p3 = new Pessoa(3, 1, 35);
//		passageiros.add(p3);
//		Pessoa p4 = new Pessoa(3, 2, 81);
//		passageiros.add(p4);
//		Pessoa p5 = new Pessoa(3, 2, 40);
//		passageiros.add(p5);
//		return passageiros;
//	}
	
}
