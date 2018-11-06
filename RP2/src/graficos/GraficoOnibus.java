/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author a9779197
 */
public class GraficoOnibus extends JFrame {
    
	
  
    private int qonibusPonto[];
   	int qPontos;
    int[]onibusPos;// em quais pontos est√£o os onibus
    boolean[] taNoPonto;// se o enezimo onibus esta ou n√£o no ponto
    int[]qPessoaPonto;// quantidade de pessoas em um ponto
            
    public GraficoOnibus(int qPontos,int[] onibusPos,boolean[] taNoPonto,int[] qPessoaPonto){
    	this.qPontos=qPontos;
    	this.onibusPos=onibusPos;
    	this.taNoPonto=taNoPonto;
    	this.qPessoaPonto=qPessoaPonto;
    	qonibusPonto=new int[qPontos];
        setSize(1200,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    void zeraQtdPonto(){
    	
    	for(int i=0; i<qonibusPonto.length;i++){
    		qonibusPonto[i]=0;
    	}
    }
    
    public void  desenhaOnibus(Graphics g,int x,int y){
       g.setColor(Color.red);
       g.fillRect(x, y,30, 15);
       g.setColor(Color.BLACK);
       g.fillOval(x+3, y+10, 8,8);
       g.fillOval(x+30-3-8, y+10, 8,8);
      
    }
    
    public void povao(Graphics g,int n, int x,int y){
        g.setColor(Color.BLACK);
        int col=0;
        int lin=0;
        for(int i=0;i<n;i++){
           g.fillOval( x+(col*8), y-(lin*8), 7,7);
            col++;
           if(col>4){
               col=0;
               lin++;
           }
            
          
        }
        
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1200, 400);
        g.setColor(new Color(220,240,20));

        zeraQtdPonto(); 
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g.drawLine(0+50, 200,1200-50 ,200);
        // colocando os pontos na linha
        
        //colocando os pontos
        
        g.setColor(Color.BLACK);
        for(int i=0;i<qPontos;i++){
            g.fillOval(i*(1100/(qPontos-1))+50-5,195,10,10);
        }
        
        //colocando a lotaÁ„o de cada ponto
        
        for(int i=0; i<qPontos;i++){
        	povao(g,qPessoaPonto[i], 50-10+i*(1100/(qPontos-1)), 180);
        }
        
        for(int i=0;i<onibusPos.length;i++){
        	if(taNoPonto[i]){
        		desenhaOnibus(g,50-10+(onibusPos[i])*(1100/(qPontos-1)), 300+(qonibusPonto[onibusPos[i]])*40);
        	}else{
        		desenhaOnibus(g,50-10+(onibusPos[i])*(1100/(qPontos-1))+(1100/(qPontos-1)*2), 300+(qonibusPonto[onibusPos[i]])*40);
        	}
        	qonibusPonto[onibusPos[i]]++;
        }
       
    }
    
}
