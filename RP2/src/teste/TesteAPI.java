package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import api_interface.Onibus;
import api_interface.Otibus;
import api_interface.PassageiroResposta;
import api_interface.Passageiros;
import api_interface.Resposta;
import api_interface.TemposMedios;
import geneticos.Cromossomo;
import geneticos.OperadorGenetico;
import graficos.GraficoCompPopoli;

public class TesteAPI {
	public static ArrayList<Passageiros> todosOsPassageiros() throws Exception {
		
		ArrayList<Passageiros> passageiros = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 3000; i++) {
			Passageiros p1 = new Passageiros();
			int origem = 0;
			if(Math.random() > 0.6)
				origem = rand.nextInt(19);
			else
				origem = rand.nextInt(8);
			
			int dest = 0;
			if(Math.random() > 0.2 && origem < 4)
				dest = 4 + rand.nextInt(20-4);
			else
				dest = origem+1 + rand.nextInt(19-origem);
			 
			p1.setDestino(dest);
			p1.setPartida(origem);
			int temp = 0;
			if(Math.random() > 0.6 && origem  < 5)
				temp = 100 + rand.nextInt(200-100);
			else
				temp = 2 + rand.nextInt(600);
			p1.setInicioEspera(temp);
			passageiros.add(p1);
			
		}
		for(Passageiros p:passageiros) {
			if(p.getDestino() > 19) throw new Exception("alem do possivel");
		}
		
//		Passageiros p1 = new Passageiros();
//		p1.setDestino(2);
//		p1.setPartida(0);
//		p1.setInicioEspera(9);
//		passageiros.add(p1);
//		Passageiros p2 = new Passageiros();
//		p2.setDestino(3);
//		p2.setPartida(0);
//		p2.setInicioEspera(78);
//		passageiros.add(p2);
//		Passageiros p3 = new Passageiros();
//		p3.setDestino(3);
//		p3.setPartida(1);
//		p3.setInicioEspera(35);
//		passageiros.add(p3);
//		Passageiros p4 = new Passageiros();
//		p4.setDestino(3);
//		p4.setPartida(2);
//		p4.setInicioEspera(81);
//		passageiros.add(p4);
//		Passageiros p5 = new Passageiros();
//		p5.setDestino(3);
//		p5.setPartida(2);
//		p5.setInicioEspera(40);
//		passageiros.add(p5);
		return passageiros;
	}
	
	public static ArrayList<Onibus> todosOnibus (double[] tempos){
		ArrayList<Onibus> onibusd= new ArrayList<>();
		for(int i = 0; i<tempos.length;i++) {
			Onibus novo = new Onibus();
			novo.setId(i);
//			if (Math.random() > 0.5)
			novo.atribuiModificavel();
			novo.setCapacidade(120);
			novo.setHorarioChegada(tempos[i]);
			onibusd.add(novo);
		}
		return onibusd;
	}
	
	public static ArrayList<Passageiros> passageirosArquivo() {
		ArrayList<Passageiros> passageiros = new ArrayList<Passageiros>();
		
		try {
			 
			Scanner sc= new Scanner(new File("/home/maxtelll/Documents/USP/sextoSemestre/rp2/passageiros.txt"));
			while(sc.hasNext()){
				String[] s = sc.nextLine().split(";");
				Passageiros p = new Passageiros();
				p.setInicioEspera(Double.parseDouble(s[0]));
				p.setPartida(Integer.parseInt(s[1]));
				p.setDestino(Integer.parseInt(s[2]));
				passageiros.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return passageiros;
	}
	
	
	public static void main(String[] args) throws Exception {
		
//		boolean[] b = new boolean[20];
//		Arrays.fill(b, Boolean.TRUE);
//		Cromossomo c1 = new Cromossomo(b);
//		
//		boolean[] c = new boolean[20];
//		Arrays.fill(c, Boolean.TRUE);
//		Cromossomo c2 = new Cromossomo(c);
//		
//		for(boolean i:c1.getConteudo()) {
//			System.out.print(i+"\t");
//		}
//		System.out.println("");
//		for(boolean i:c2.getConteudo()) {
//			System.out.print(i+"\t");
//		}
//		
//		
//		OperadorGenetico op = new OperadorGenetico();
//		Cromossomo d = op.mutacaoViagem(c1, new boolean[] {true, false}, 5, 4);
//		System.out.println("\n");
//		for(boolean i:d.getConteudo()) {
//			System.out.print(i+"\t");
//		}
//		System.out.println("");
//		for(boolean i:d[1].getConteudo()) {
//			System.out.print(i+"\t");
//		}
//		
//		
//		double tempoOnibus[] = {10, 15, 71, 80, 100};
		double tempoOnibus[] = {
//				10, 15, 71, 80, 100
//				10, 53, 90, 122, 154, 164, 199, 220, 280, 354, 377, 401, 454, 480, 510, 550, 583, 604, 645, 666
				35680,46446,57967,18570,26959,52969,32322,62839,22713,31718,43202,54987,65691,24010,44924,52526,63264,24530,28657,51362,60568,69430,38183,50055,61826,20197,28795,34998,45492,58017,24629,36814,44532,56895,67178,57137,48448,58865,49036,49275,43369,52229,64264,15328,22552,28747,38486,49144,61781,23065,30523,14497,20845,28627,51509,62081,70554,60632,70477,20086,50431,60115,69585,52819,61666,15840,21987,33026,41827,54781,65482,23377,19505,26330,36792,50271,59786,16348,27643,36506,46191,57296,16779,23264,30287,39950,56984,66138,74256,22852,29197,38148,49456,62005,19586,26374,47827,58497,22379
				};
		for(int i = 0; i <tempoOnibus.length; i++) {
			tempoOnibus[i] =(int)tempoOnibus[i]/4; 
		}
		ArrayList<Passageiros> passageiros = passageirosArquivo();
		System.out.println(passageiros.size());
		ArrayList<Onibus> onibus = todosOnibus(tempoOnibus);
		System.out.println(onibus.size());
		int qtdPontos = 39;
		int nGeracoes = 5;
		
//		Cromossomo c = new Cromossomo(qtdPontos, onibus);
//		for(int i = 0; i <c.getConteudo().length; i++)
//			System.out.println(c.getConteudo()[i]);
		
//		valores v = new valores();
		TesteV2 v = new TesteV2();
		Otibus o = new Otibus();
//		v.mostra();4
		long li = System.currentTimeMillis();
		Resposta r = o.start(passageiros, onibus, v, qtdPontos, nGeracoes);
		System.out.println((System.currentTimeMillis()-li)/1000.0);
//		for(PassageiroResposta pr:r.getMelhorGeracao()) {
//			System.out.println(pr.getDestino() + " "+pr.getPartida() + " " +pr.getHorarioTermino() + " "+pr.getOnibusId());
//		}
//		
//		for(PassageiroResposta pr:r.getBaseline()) {
//			System.out.println(pr.getDestino() + " "+pr.getPartida() + " " +pr.getHorarioTermino() + " "+pr.getOnibusId());
//		}
		new GraficoCompPopoli(r.getBaseline(), r.getMelhorGeracao());
		System.out.println(r.getFitnessBaseline());
		System.out.println(r.getUltimaGeracao()[0]);
	}
}

class valores implements TemposMedios{
//	 {10, 15, 71, 80, 100};
//	double tempoParadas[] = {3, 2, 4, 2};
	double tempoParadas[] = {6, 7, 8, 12, 5, 28, 12, 4, 6, 7, 12, 9, 4, 7, 13, 8, 7, 6, 8, 10};
//	double [][]temposTrajetos = {	
//			{3, 7, 1, 3, 2}, 
//			{2, 4, 2, 4, 2}, 
//			{4, 5, 1, 6, 3}};
	double [][]temposTrajetos = new double[20][20];
	Random rand = new Random(); 
	public valores() {
		for (int i = 0; i < temposTrajetos.length; i++) {     
	        for (int j = 0; j < temposTrajetos[0].length; j++) {
	        	temposTrajetos[i][j] = 40 + rand.nextInt((100 - 40));
	        }
	    }
	}
	
	public void mostra() {
		for (int i = 0; i < temposTrajetos.length; i++) {     
	        for (int j = 0; j < temposTrajetos[0].length; j++) {
	            System.out.println(temposTrajetos[i][j]);
	        } 
	    }
	}
//	double [][]temposTrajetos = {	
//			{3, 7, 1, 3, 2}, 
//			{2, 4, 2, 4, 2}, 
//			{4, 5, 1, 6, 3}};
	@Override
	public double tempoEntrePontos(int ponto, int idOnibus, double tempoCorrente) {
		// TODO Auto-generated method stub
		return temposTrajetos[ponto][idOnibus];
	}

	@Override
	public double tempoParadoNoPonto(int ponto, int idOnibus, double tempoCorrente, int quatidadePassageiros) {
		// TODO Auto-generated method stub
		return tempoParadas[ponto];
	}
	
}
