package geneticos;


public class Principal {
	
	static double fitnessTroll(Cromossomo c){
		double saida=0;
		if(c.conteudo[0]==1)saida++;
		if(c.conteudo[1]==2)saida++;
		if(c.conteudo[2]==3)saida++;
		if(c.conteudo[3]==4)saida++;
		if(c.conteudo[4]==5)saida++;
		return saida;
	}
	
	static void VidaCruel(Cromossomo[] cromossomos,int Maxgeracoes,double mutacaoTx,int[] alfabeto){
		
		//temos que ter uma populaçã aleatoria;
		
		double fitness[]=new double[cromossomos.length];
		Cromossomo[]geracaoAtual=cromossomos;
		
		for(int geracao=0;geracao<Maxgeracoes;geracao++){
			// para cada uma das geracoes 
			System.out.println("geração G"+geracao);
			
			
			for(int aux=0; aux<fitness.length;aux++){
				fitness[aux]=fitnessTroll(geracaoAtual[aux]);///FUNCAO DE MEDIR O FITNESS DO CROMOSSOMO
			}
			
			
			// para compor a nova geracao
			
			Roleta roleta = new Roleta(fitness);//roleta que escolhe individuos
			
			Cromossomo[] novaGeracao=new Cromossomo[cromossomos.length];
			
			double[]probabilidade ={0.8,0.05,0.15};//chances de cada operação genetica
			Roleta roletaOperacao = new Roleta(probabilidade);// roleta pra escolher a operação;
			
			for(int i=0;i<cromossomos.length;i++){
				//hora de escolher a operaçao genetica
				
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
			for(Cromossomo c: geracaoAtual){
				for(Integer i: c.conteudo){
					System.out.print(i.intValue());
				}
				System.out.println("");
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cromossomo[]cromossomos= new Cromossomo[100];
		for(int i=0;i<cromossomos.length;i++){
			cromossomos[i]= new Cromossomo(5);
		}
		int[]alfabeto={1,2,3,4,5,6,7,8,9,0};
		VidaCruel(cromossomos, 100, 3, alfabeto);

	}
	
}
