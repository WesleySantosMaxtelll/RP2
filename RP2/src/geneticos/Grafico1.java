package geneticos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Grafico1 extends JFrame {
	
	ArrayList<Double>dados;
	public Grafico1(ArrayList<Double>dados){
		this.dados=dados;
		setSize(2000,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();
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
		
		double razao= 800/(max-min);
		
		int r=5;
		
		int antX =120;
		int antY=1000-60;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		
		for(Double dado:dados){
			if(dado!=dados.get(0))
			g.drawLine(antX, antY, antX+r, 700-((int)(dado.doubleValue()*razao)-(int)(min*razao)+80));
			antX=antX+r;
			antY=700-((int)(dado.doubleValue()*razao)-(int)(min*razao)+80);
		}
		
		g.setColor(Color.DARK_GRAY);
		g.drawLine(120, 1000-60, 120, 0);
		
		g.drawLine(100, 1000-60, 2000,1000-60);
		
		g.setColor(Color.BLACK);
		
		g.drawLine(90,1000-80,110,1000-80);// significa 0.1
		//g.drawLine(300-150,30,300-150,70);// siginifica -0.05
		
		g.setFont(new Font("diafgdjhlog",Font.BOLD,18));
		for(int i=0;i<9;i++){
		g.drawString((float)(min+(i*100)/razao)+"",10,700-80-(i*100));
		g.drawLine(90+20,700-80-(i*100),110+20,700-80-(i*100));
		}
		for(int k=0;k<100;k++){
			g.drawLine(150+k*r+20,1000-60,150+k*r+20,1000-50);
			g.drawString(""+(k)+"",170+k*r,1000-20);
		}
		//g.drawString(,320-150,71);
	}
}