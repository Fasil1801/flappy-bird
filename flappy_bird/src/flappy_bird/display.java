package flappy_bird;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class display {


	 
	
	
	public static void main(String game[]) {
		int width=360;
		int height=630;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		Entity entity=new Entity();
		frame.add(entity);
		frame.pack();
		frame.setVisible(true);
		
		JLabel points=new JLabel();
		points.setBounds(40,40,100,100);
		points.setBackground(Color.black);
		points.setOpaque(true);
		frame.add(points);
	}
}
