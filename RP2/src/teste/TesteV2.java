package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api_interface.TemposMedios;

public class TesteV2 implements TemposMedios {
	 
	 ArrayList<Double> tempoTrajeto= new ArrayList<>();
	 ArrayList<Double> tempoParada;
	 
	 public TesteV2(){
		 try {
			 
			Scanner sc= new Scanner(new File("/home/maxtelll/Documents/USP/sextoSemestre/rp2/averages.txt"));
			while(sc.hasNext()){
				tempoTrajeto.add( Double.parseDouble(sc.nextLine().split(";")[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
	double[] tep = {
				20,20,22,21,25,28,30,32,35,40,
				42,55,39,38,32,42,40,39,35,33,
				42,55,39,45,43,42,55,39,45,43,
				28,25,20,22,19,20,20,18,22
			};
	

	@Override
	public double tempoEntrePontos(int ponto, int idOnibus, double tempoCorrente) {
		// TODO Auto-generated method stub
		return (int)(tempoTrajeto.get(ponto)/4)+0.0;
	}

	@Override
	public double tempoParadoNoPonto(int ponto, int idOnibus, double tempoCorrente, int quatidadePassageiros) {
		// TODO Auto-generated method stub
		return tep[ponto];
	}
	
}
