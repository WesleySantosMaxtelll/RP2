package geneticos;

import java.util.ArrayList;
import java.util.Arrays;

import api_interface.Onibus;

public class Cromossomo {
	
	boolean[]conteudo;
	public Cromossomo(boolean[]conteudo) {
		this.conteudo = conteudo;
	}
	public Cromossomo(int qGenes){
		conteudo=new boolean[qGenes];
		for(int i = 0; i<qGenes;i++) {
			if(Math.random() < 0.3) 
				conteudo[i] = false;
			else
				conteudo[i] = true;
		}
//		System.out.println(Arrays.toString(conteudo));
		
	}
	
	public Cromossomo(int quantidadePontos, ArrayList<Onibus> onibus) {
		conteudo=new boolean[quantidadePontos*onibus.size()];
		
		if(Math.random() < 0.2) {
			Arrays.fill(conteudo, Boolean.TRUE);
		} else {
			for(int i = 0; i<onibus.size();i++) {
				for (int j = 0; j <quantidadePontos; j++) {
					if(onibus.get(i).isFixo()) {
						conteudo[i*quantidadePontos+j] = true;
					} else {
						if(Math.random() < 0.3) 
							conteudo[i*quantidadePontos+j] = false;
						else
							conteudo[i*quantidadePontos+j] = true;
					}
				}
			}
		}
	}

	
	public void setRotaPadrao(){
		for(int i=0;i<conteudo.length;i++){
			conteudo[i]=true;
		}
	}

	public boolean[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(boolean[] conteudo) {
		this.conteudo = conteudo;
	}
	
}
