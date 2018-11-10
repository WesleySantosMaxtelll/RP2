package geneticos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Painel extends JFrame {
	
	double zoom=1;
	double X=0;
	double Y=0;
	
	JFrame controlado;
	
	Painel(JFrame controlado ){
		this.controlado=controlado;
		setSize(200,200);
		setLayout(new GridLayout(2, 2));;
		;
		JButton zoomin= new JButton("+denso");
		JButton zoomout= new JButton("+esparso");
		JButton direita= new JButton(">>");
		JButton esquerda= new JButton("<<");
		
		zoomin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				zoom*=2;
				controlado.repaint();
			}
		});
		zoomout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				zoom*=0.5;
				controlado.repaint();
			}
		});
		direita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				X++;
				controlado.repaint();
			}
		});
		esquerda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				X--;
				controlado.repaint();
			}
		});
		
		
		add(zoomin);
		add(zoomout);
		add(esquerda);
		add(direita);
		setVisible(true);
	}

}
