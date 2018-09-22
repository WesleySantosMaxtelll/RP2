/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafico.onibus;

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
    
   public float px=0;
    
    int[]localOnibus;// em quais pontos estão os onibus
    boolean[] taNoPonto;// se o enezimo onibus esta ou não no ponto
    int[]qPessoaPonto;// quantidade de pessoas em um ponto
            
    public GraficoOnibus(){
        setSize(1200,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
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

         
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g.drawLine(0+50, 200,1200-50 ,200);
        // colocando os pontos na linha
        
        g.setColor(Color.BLACK);
        for(int i=0;i<5;i++){
            g.fillOval(i*(1100/4)+50-5,195,10,10);
        }
        povao(g,17, 50-10, 180);
        povao(g,13, 50-10+(1100*1/4), 180);
        povao(g,41, 50-10+(1100*2/4), 180);
        povao(g,2, 50-10+(1100*3/4), 180);
        povao(g,7, 50-10+(1100*4/4), 180);
        desenhaOnibus(g, (int)px, 260);
        
        
        
        
    }
    
}
