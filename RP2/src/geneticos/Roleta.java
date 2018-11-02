package geneticos;

import java.util.ArrayList;

public class Roleta {
	
	ArrayList<Setor>setores= new ArrayList<>();
	private double totalFitness=0;
	
	public Roleta(double fitness[]){
		for(int aux=0;aux<fitness.length;aux++){
			setores.add(new Setor(totalFitness,totalFitness+fitness[aux],aux));
			totalFitness+=fitness[aux];
		}
	}
	
	int sortear(){
		double agulha=Math.random()*totalFitness;
//		System.out.println(agulha);
		for(Setor s: setores){
			if(agulha<=s.topo && agulha>=s.base)return s.id;
			
		}
		
		return-1;// erro;
	}

}
