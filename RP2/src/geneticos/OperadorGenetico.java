package geneticos;


public class OperadorGenetico {

	static Cromossomo mutacao(Cromossomo original,int[]alfabeto){
		
		int posicao=(int)(Math.random()*original.conteudo.length);// escolhe uma posicao aleatoria no conteudo do cromossomo
		original.conteudo[posicao]=alfabeto[(int)(Math.random()*alfabeto.length)];
		return original;
	}
	
	static Cromossomo clonagem(Cromossomo original){
		return original;
		
		
	}
	static Cromossomo Crossover1(Cromossomo original1,Cromossomo original2){
		
		int quantidadeGenes=original1.conteudo.length;//quantidade de Genes que tem um Cromossomo;
		
		int posicao=(int)(Math.random()*original1.conteudo.length);// escolhe uma posicao aleatoria no conteudo do cromossomo
		Cromossomo resultante=new Cromossomo(quantidadeGenes);// problematico já que o Cromossomo vem vazio;
		int i=0;
		for(;i<posicao;i++){
			resultante.conteudo[i]=original1.conteudo[i];
		}
		for(;i<original1.conteudo.length;i++){
			resultante.conteudo[i]=original2.conteudo[i];
		}
		return resultante;
	}
	
static Cromossomo Crossover2(Cromossomo original1,Cromossomo original2){
		
		int quantidadeGenes=original1.conteudo.length;//quantidade de Genes que tem um Cromossomo;
	
		int posicao=(int)(Math.random()*original1.conteudo.length);// escolhe uma posicao aleatoria no conteudo do cromossomo
		Cromossomo resultante=new Cromossomo(quantidadeGenes);// problematico já que o Cromossomo vem vazio;
		int i=0;
		for(;i<posicao;i++){
			resultante.conteudo[i]=original2.conteudo[i];
		}
		for(;i<original1.conteudo.length;i++){
			resultante.conteudo[i]=original1.conteudo[i];
		}
		return resultante;
	}
}
