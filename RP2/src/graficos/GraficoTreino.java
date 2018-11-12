package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JFrame;

import geneticos.Cromossomo;
import teste.TesteAPI;
import teste.TesteV2;

public class GraficoTreino extends JFrame {
	
	Graphics gdb;
	Image idb;
	int[]tipo;
	int X=0;
	double LARGURA=3200.0;
	public void SetCromosso(Cromossomo[] individoss) {
		// TODO Auto-generated method stub
		this.individos= individoss;
	}
	
	double tempoOnibus[] = {
//			10, 15, 71, 80, 100
//			10, 53, 90, 122, 154, 164, 199, 220, 280, 354, 377, 401, 454, 480, 510, 550, 583, 604, 645, 666
			35680,46446,57967,18570,26959,52969,32322,62839,22713,31718,43202,54987,65691,24010,44924,52526,63264,24530,28657,51362,60568,69430,38183,50055,61826,20197,28795,34998,45492,58017,24629,36814,44532,56895,67178,57137,48448,58865,49036,49275,43369,52229,64264,15328,22552,28747,38486,49144,61781,23065,30523,14497,20845,28627,51509,62081,70554,60632,70477,20086,50431,60115,69585,52819,61666,15840,21987,33026,41827,54781,65482,23377,19505,26330,36792,50271,59786,16348,27643,36506,46191,57296,16779,23264,30287,39950,56984,66138,74256,22852,29197,38148,49456,62005,19586,26374,47827,58497,22379
			};
	
	
	Cromossomo[]individos;
		public GraficoTreino (Cromossomo[] individoss,int[]tipo){
			this.tipo=tipo;
			this.individos=individoss;
			setSize(1000,1000);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			Arrays.sort(tempoOnibus);
			
			
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyChar()=='a')X-=10;
					if(e.getKeyChar()=='d'&& X<0)X+=10;
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
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
			idb= createImage(3750,getHeight());
			gdb=idb.getGraphics();
			paintComponent(gdb);
			g.drawImage(idb,X, 0,this);
		}
		
		public void paintComponent(Graphics g){
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, (int) LARGURA, getHeight());

			double razaoX=(LARGURA-200)/individos[0].getConteudo().length;
			
			double razaoY=600.0/individos.length;
			double Yacu=0;
			for(int j=0;j<individos.length;j++){
				double Xacu=0;
				for(int i=0;i<individos[0].getConteudo().length;i++){
					
					if(individos[j].getConteudo()[i]==true)g.setColor(Color.black);
					else g.setColor(Color.PINK);
					
					g.drawRect((int)Xacu, (int)Yacu,((int)(Xacu+razaoX))-((int)Xacu),((int)(Yacu+razaoY))-((int)Yacu));
					
					
					Xacu+=razaoX;
				}
				Yacu+=razaoY;
			}
			
			
			
			Yacu=0;
			for(int j=0;j<individos.length;j++){
			
				g.setColor(corHash(tipo[j]));
				//g.setColor(Color.red);
				g.fillRect((int) (LARGURA-200), (int)Yacu,50,((int)(Yacu+razaoY))-((int)Yacu));
				Yacu+=razaoY;
			}
			
			
			for(int i=0;i<100;i++){
				g.setColor(Color.blue);
				g.drawLine((int)(i*39*(razaoX)), 0,(int)( i*39*(razaoX)), 800);
			}
			//risquinhos da escala de tempo
			for(int i=0;i<99;i++){
				g.setColor(Color.black);
				if(i%2==0)g.drawLine((int)(i*39*(razaoX)),getHeight()-65,(int)( i*39*(razaoX)),getHeight()-45);
				else g.drawLine((int)(i*39*(razaoX)),getHeight()-60,(int)( i*39*(razaoX)),getHeight()-50);
			}
			
			g.setFont(new Font(Font.DIALOG,Font.BOLD, 11));
			for(int i=0;i<99;i++){
				g.setColor(Color.black);
				String hora=(int)(tempoOnibus[i]/3600)+"";
				String minuto="";
				if((int)((tempoOnibus[i]%3600)/60)<10)minuto+="0";
				minuto+=(int)((tempoOnibus[i]%3600)/60)+"";
				g.drawString(hora+":"+minuto,(int)(i*39*(razaoX))-10, getHeight()-30);
				i++;
			}
			
			
			
			
			
		}
		
}
