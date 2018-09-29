package geneticos;


public class Cromossomo {
	
	boolean[]conteudo;
	
	public Cromossomo(int qGenes){
		conteudo=new boolean[qGenes];
	}

	public boolean[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(boolean[] conteudo) {
		this.conteudo = conteudo;
	}
	
}
