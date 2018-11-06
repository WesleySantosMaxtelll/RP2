package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import geneticos.Cromossomo;

public class GraficoTreino extends JFrame {
	
	Graphics gdb;
	Image idb;
	int[]tipo;
	public void SetCromosso(Cromossomo[] individoss) {
		// TODO Auto-generated method stub
		this.individos= individoss;
	}
	
	Cromossomo[]individos;
		public GraficoTreino (Cromossomo[] individoss,int[]tipo){
			this.tipo=tipo;
			this.individos=individoss;
			setSize(1000,2000);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
			
		}
		{
			new Thread(new Runnable(){

				@Override
				public void run() {
					while(true){
						repaint();
						try {
							Thread.sleep((1000/10));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}).start();
			
		}
		Color corHash(double seed){
			
			
			
			int red =(int)((int)(Math.pow(2.17, (int)(seed)%40))%220);

			int green =(int)((int)(Math.pow(2.3,(int)(seed)%40))%220);
			int blue= (int)((int)(Math.pow(2.43,(int)(seed)%40))%220);
			
			//JOptionPane.showMessageDialog(null,"red"+red+" blue"+blue+" green"+green);
			
			return new Color(red,green,blue);
		}
		
		
		
		public void paint(Graphics g){
			idb= createImage(getWidth(),getHeight());
			gdb=idb.getGraphics();
			paintComponent(gdb);
			g.drawImage(idb, 0, 0,this);
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			double razaoX=1750.0/individos[0].getConteudo().length;
			
			double razaoY=1000.0/individos.length;
			double Yacu=0;
			for(int j=0;j<individos.length;j++){
				double Xacu=0;
				for(int i=0;i<individos[0].getConteudo().length;i++){
					
					if(individos[j].getConteudo()[i]==true)g.setColor(Color.black);
					else g.setColor(Color.green);
					
					g.drawRect((int)Xacu, (int)Yacu,((int)(Xacu+razaoX))-((int)Xacu),((int)(Yacu+razaoY))-((int)Yacu));
					
					
					Xacu+=razaoX;
				}
				Yacu+=razaoY;
			}
			
			
			
			Yacu=0;
			for(int j=0;j<individos.length;j++){
			
				g.setColor(corHash(tipo[j]));
				//g.setColor(Color.red);
				g.fillRect(1750, (int)Yacu,50,((int)(Yacu+razaoY))-((int)Yacu));
				Yacu+=razaoY;
			}
			
			
			for(int i=0;i<100;i++){
				g.setColor(Color.blue);
				g.drawLine((int)(i*39*(razaoX)), 0,(int)( i*39*(razaoX)), 1000);
			}
			
			
			
			
			
		}
		
}
