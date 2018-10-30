package geneticos;
public class OperadorGenetico {
	private static BaseInfo b = BaseInfo.getInstance();
	private static Integer[] mutaveis = b.getMutaveis();
	static Cromossomo mutacao(Cromossomo original,boolean[]alfabeto){
		
		int quantidadeGenes=original.conteudo.length;//quantidade de Genes que tem um Cromossomo;
		Cromossomo resultante=new Cromossomo(quantidadeGenes);
		resultante.conteudo=original.conteudo.clone();
		
		int posicao=devolvePosicao();// escolhe uma posicao aleatoria no conteudo do cromossomo
//		System.out.println(posicao);
		resultante.conteudo[posicao]=alfabeto[(int)(Math.random()*alfabeto.length)];
		
		return resultante;
	}
	
	static Cromossomo clonagem(Cromossomo original){
		int quantidadeGenes=original.conteudo.length;
		Cromossomo resultante=new Cromossomo(quantidadeGenes);
		resultante.conteudo=original.conteudo.clone();
		return resultante;
		
		
	}
	
	private static int devolvePosicao() {
		int r = (int)(Math.random()*mutaveis.length);
		return mutaveis[r];
		
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