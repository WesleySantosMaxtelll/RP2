package geneticos;

import java.util.Random;

public class OperadorGenetico {
	private static BaseInfo b = BaseInfo.getInstance();
	private static Integer[] mutaveis = b.getMutaveis();
	private static Random rand = new Random();
	static Cromossomo mutacao(Cromossomo original,boolean[]alfabeto){
		
		int quantidadeGenes=original.conteudo.length;//quantidade de Genes que tem um Cromossomo;
		Cromossomo resultante=new Cromossomo(quantidadeGenes);
		resultante.conteudo=original.conteudo.clone();
		
		int posicao=devolvePosicao();// escolhe uma posicao aleatoria no conteudo do cromossomo
//		System.out.println(posicao);
		if(Math.random() > 0.65)
			resultante.conteudo[posicao]=true;
		else
			resultante.conteudo[posicao]=false;
		
		return resultante;
	}
	
	
	public static Cromossomo mutacaoViagem(Cromossomo original,boolean[]alfabeto, int qtdOnibus,int qtdPontos) {
		int quantidadeGenes=original.conteudo.length;//quantidade de Genes que tem um Cromossomo;
		Cromossomo resultante=new Cromossomo(quantidadeGenes);
		resultante.conteudo=original.conteudo.clone();
		int onibus = rand.nextInt(b.getOnibusMutaveis().length);
		onibus = b.getOnibusMutaveis()[onibus];
//		System.out.println(onibus);
		for(int i=0; i < qtdPontos; i++) {
			if(Math.random() > 0.5)
				resultante.conteudo[onibus*qtdPontos+i]=true;
			else
				resultante.conteudo[onibus*qtdPontos+i]=false;
				
		}
		
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
	
	
	public static Cromossomo[] CrossoverPorOnibus(Cromossomo original1,Cromossomo original2, int qtdOnibus, int qtdPontos){
		
		int onibus = rand.nextInt(qtdOnibus);
		int ponto = rand.nextInt(qtdPontos);
//		
//		System.out.println("\n"+ponto);
//		System.out.println(onibus);
		
		int quantidadeGenes=original1.conteudo.length;//quantidade de Genes que tem um Cromossomo;
		Cromossomo resultante1=new Cromossomo(quantidadeGenes);
		Cromossomo resultante2=new Cromossomo(quantidadeGenes);
		
		for(int i = 0; i <resultante1.getConteudo().length; i++) {
			if(i <= onibus*qtdPontos+ponto || i >= (onibus+1)*qtdPontos) {
				resultante1.getConteudo()[i] = original1.getConteudo()[i];
				resultante2.getConteudo()[i] = original2.getConteudo()[i];
			} else {
				resultante1.getConteudo()[i] = original2.getConteudo()[i];
				resultante2.getConteudo()[i] = original1.getConteudo()[i];
			}
		}
		
		return new Cromossomo[] {resultante1, resultante2};
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