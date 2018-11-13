package geneticos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Grafico1 extends JFrame {
	
	Painel p;
	
	ArrayList<Double>dados;
	ArrayList<Double>minimos;
	ArrayList<Double>maximos;
	double alturaLinhabase=0;
	public Grafico1(ArrayList<Double>dados, double alturaLinhabase,ArrayList<Double>minimos,ArrayList<Double>maximos){
		this.maximos=maximos;
		this.alturaLinhabase=alturaLinhabase;
		this.dados=dados;
		this.minimos=minimos;
		setSize(2000,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();
		this.alturaLinhabase=alturaLinhabase;
		
		
	}
	//gambiarra
	{
		p=new Painel(this);
	}
	
	public void salvarImagem(String nome, File file) {
		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		try{
			ImageIO.write(image, "png",new File(file.getAbsolutePath()+"//"+nome+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 2000, 1000);
		g.setColor(Color.BLACK);
		double min=Double.MAX_VALUE;
		double max=Double.MIN_VALUE;
		for(Double dado: dados){
			if(dado.doubleValue()>max)max=dado.doubleValue();
			if(dado.doubleValue()<min)min=dado.doubleValue();
		}
		
		if(alturaLinhabase>max)max=alturaLinhabase;
		if(alturaLinhabase<min)min=alturaLinhabase-10;
		
		double razao= 800/(100+max-min);
		
		double r= (1500.0/(int)(dados.size()*1.1));
		
		if(p!=null)r=r*(p.zoom);
		
		double antX =120;
		int antY=getHeight()-60;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		for(Double dado:dados){
			if(dado!=dados.get(0))
			g.drawLine((int)antX, antY,(int) (antX+r), getHeight()-((int)(dado.doubleValue()*razao)-(int)(min*razao)+80));
			antX=antX+r;
			antY=getHeight()-((int)(dado.doubleValue()*razao)-(int)(min*razao)+80);
		}
		///resetando parametros de ligamento de dados
		antX =120;
		antY=getHeight()-60;
		
		g.setColor(Color.blue);
		g2.setStroke(new BasicStroke(2));
		for(Double minimo:minimos){
			
			if(minimo!=minimos.get(0))
				g.drawLine((int)antX, antY,(int) (antX+r), getHeight()-((int)(minimo.doubleValue()*razao)-(int)(min*razao)+80));
				antX=antX+r;
				antY=getHeight()-((int)(minimo.doubleValue()*razao)-(int)(min*razao)+80);
		}
		///resetando parametros de ligamento de dados
				antX =120;
				antY=getHeight()-60;
				
				g.setColor(Color.MAGENTA);
				g2.setStroke(new BasicStroke(2));
				for(Double maximo:maximos){
					
					if(maximo!=minimos.get(0))
						g.drawLine((int)antX, antY,(int) (antX+r), getHeight()-((int)(maximo.doubleValue()*razao)-(int)(min*razao)+80));
						antX=antX+r;
						antY=getHeight()-((int)(maximo.doubleValue()*razao)-(int)(min*razao)+80);
				}
		
		
		
		g.setColor(Color.DARK_GRAY);
		g.drawLine(120, getHeight()-60, 120, 0);
		
		g.drawLine(100, getHeight()-60, 2000,getHeight()-60);
		
		g.setColor(Color.BLACK);
		
		g.drawLine(90,getHeight()-80,110,getHeight()-80);// significa 0.1
		//g.drawLine(300-150,30,300-150,70);// siginifica -0.05
		
		g.setFont(new Font("diafgdjhlog",Font.BOLD,18));
		for(int i=0;i<9;i++){
		g.drawString((float)(min+(i*100)/razao)+"",10,getHeight()-80-(i*100));
		g.drawLine(90+20,getHeight()-80-(i*100),110+20,getHeight()-80-(i*100));
		}
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,10));
		for(int k=0;k<50;k++){
			g.drawLine(120+k*30,getHeight()-60,120+k*30,getHeight()-50);
			g.drawString(""+(int)((k*30)/r)+"",(120+k*30)-5,getHeight()-30);
		}
		//g.drawString(,320-150,71);
		g.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
		g.setColor(Color.red);
		g.drawLine(0,getHeight()-((int)(alturaLinhabase*razao)-(int)(min*razao)+80) , 2000, getHeight()-((int)(alturaLinhabase*razao)-(int)(min*razao)+80));
		g.drawString(alturaLinhabase+"",40,getHeight()-((int)(alturaLinhabase*razao)-(int)(min*razao)+80)+14);
		
	}
}