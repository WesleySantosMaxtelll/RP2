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
			 
			Scanner sc= new Scanner(new File("C:\\Users\\gusta\\Downloads\\averages (1).txt"));
			while(sc.hasNext()){
				tempoTrajeto.add( Double.parseDouble(sc.nextLine().split(";")[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
	
	

	@Override
	public double tempoEntrePontos(int ponto, int idOnibus, double tempoCorrente) {
		// TODO Auto-generated method stub
		return (int)(tempoTrajeto.get(ponto)/4)+0.0;
	}

	@Override
	public double tempoParadoNoPonto(int ponto, int idOnibus, double tempoCorrente, int quatidadePassageiros) {
		// TODO Auto-generated method stub
		return 10 ;
	}
	
	public static void main(String[] args) {
		TesteV2 t = new TesteV2();
		System.out.println(t.tempoEntrePontos(2, 0, 0));
	}

}
