package geneticos;

import java.util.Arrays;

public class Cromossomo {
	
	boolean[]conteudo;
	
	public Cromossomo(int qGenes){
		conteudo=new boolean[qGenes];
		for(int i = 0; i<qGenes;i++) {
			if(Math.random() < 0.5) 
				conteudo[i] = false;
			else
				conteudo[i] = true;
		}
//		System.out.println(Arrays.toString(conteudo));
		
	}

	public boolean[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(boolean[] conteudo) {
		this.conteudo = conteudo;
	}
	
}
