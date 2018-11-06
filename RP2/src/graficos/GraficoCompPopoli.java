package graficos;

import api_interface.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;

public class GraficoCompPopoli extends JFrame {
	
	int recuoX=50;
	int recuoY=50;
	
	ArrayList<PassageiroResposta> passageiros= new ArrayList<>();//baseline
	ArrayList<PassageiroResposta> passageiros2= new ArrayList<>();//melhor caso
	public GraficoCompPopoli(ArrayList<PassageiroResposta> passageiros,ArrayList<PassageiroResposta> passageiros2){
		this.passageiros=passageiros;
		this.passageiros2=passageiros2;
		setSize(1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//passageiros.get(0).getInicioEspera();// x
		//passageiros.get(0).getHorarioTermino()-passageiros.get(0).getInicioEspera();
	}
	

	void barrinhaX(Graphics g,int x,int y){
		g.drawLine(x, y-3, x, y+3);
	}
	void barrinhaY(Graphics g,int x,int y){
		g.drawLine(x-3, y, x+3, y);
	}

	void EscalaX(Graphics g,double ratio, int n,double min){
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		
		g.drawLine(0, getHeight()-recuoY, getWidth(),getHeight()-recuoY);
		double auxratio=getWidth()/n;
		
		for(int i=0;i<n;i++){
			barrinhaX(g,(int)(recuoX+i*auxratio),getHeight()-recuoY);
			
			DecimalFormat df = new DecimalFormat("0.0##");
			String result = df.format(((min+((i*auxratio)*ratio))/1));
			
			g.drawString(result+"",(int)(recuoX+i*auxratio)-10,(int) getHeight()-recuoY+20);
		}
	}
	
void EscalaY(Graphics g,double ratio, int n,double min){
		
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		
		g.drawLine(recuoX, 0, recuoX,getHeight());
		
		double auxratio=getHeight()/n;
		
		for(int i=0;i<n;i++){
			barrinhaY(g,recuoX,getHeight()-(int)(recuoY+i*auxratio));
			DecimalFormat df = new DecimalFormat("0.0##");
			String result = df.format(min+((i*auxratio)*ratio));
			g.drawString(result,recuoX-30,getHeight()-(int)(recuoY+i*auxratio));
		}
	}

	public void paint(Graphics g){
		double minX= Double.MAX_VALUE;
		double maxX= Double.MIN_VALUE;
		
		double minY= Double.MAX_VALUE;
		double maxY= Double.MIN_VALUE;
		
		for(PassageiroResposta pr:passageiros){
			
			
			
			if(minX>pr.getInicioEspera())minX=pr.getInicioEspera();
			if(maxX<pr.getInicioEspera())maxX=pr.getInicioEspera();
		}
		
		for(int i=0;i<passageiros.size();i++){
			double base= passageiros.get(i).getHorarioTermino()-passageiros.get(i).getInicioEspera();
			double modelo= passageiros2.get(i).getHorarioTermino()-passageiros2.get(i).getInicioEspera();
		
			double delta = modelo-base;
//			System.out.println("DELTA"+delta);
			
			
			if(minY>delta)minY=delta;
			if(maxY<delta)maxY=delta;
			
		}
		
		maxY=600;
		
		double ratioX= (maxX-minX)/getWidth();
		double ratioY= (maxY-minY)/getHeight();
		
		
		
		g.setColor(Color.BLACK);
		
		
		for(int i=0;i<passageiros.size();i++){
			double base= passageiros.get(i).getHorarioTermino()-passageiros.get(i).getInicioEspera();
			double modelo= passageiros2.get(i).getHorarioTermino()-passageiros2.get(i).getInicioEspera();
		
			double delta = modelo-base;
			double y=delta;
			double x=passageiros.get(i).getInicioEspera();
			g.fillOval(recuoX+(int)((x-minX)/ratioX)-5,getHeight()-(int)((y-minY)/ratioY)-5-recuoX, 10, 10);
			
			
		}
		
		g.setColor(Color.red);
		g.drawLine(0,getHeight()-(int)((0-minY)/ratioY)-10-recuoX,1000,getHeight()-(int)((0-minY)/ratioY)-10-recuoX);
		
		
		
		
		
		//minX=;
		//minY=;
		
		
		
		

		EscalaX(g,ratioX,10,minX);
		EscalaY(g,ratioY,10,minY);
//		
//		System.out.println("MINX"+minX);
//		System.out.println("MINY"+minY);
//		System.out.println("MAXX"+maxX);
//		System.out.println("MAXY"+maxY);
//		
		
		
	}
	
	
	
	
	

}
