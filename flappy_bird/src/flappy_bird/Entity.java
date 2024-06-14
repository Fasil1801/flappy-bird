package flappy_bird;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class Entity  extends JPanel implements ActionListener,KeyListener{

	int arrayposition=0;
	// frame size
    int width = 360;
    int height = 630;
    // timer
    Timer timer;
    // movement
    int xvelocity = 1;
    int yvelocity = 0;
    // bird position
    int x = width / 8;
    int y = height / 2;
    // pipe
    int pipex = 360;
    int pipex2 = 360;
    int[] pipeytop = {-200,-400};
    int[] pipeybottom = {500,300};
    int velpipe = 0;
    int pipewidth = 50;
    
    int[] pipePositions = { 360};
    
    // image

    Image bird;
    Image toppipe;
    Image bottompipe;

    Graphics2D g2d;
    
    boolean gameover=false;

    
    int score=0;
    
    Entity() {
    	this.setBackground(Color.cyan);
        this.setPreferredSize(new Dimension(width, height));

        bird = new ImageIcon("C:\\Users\\fasil\\Desktop\\flappy bird\\flappybird.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);//new image to bird from path and resize the image
        toppipe = new ImageIcon("C:\\Users\\fasil\\Desktop\\flappy bird\\pipedown.png").getImage().getScaledInstance(pipewidth, 600, Image.SCALE_DEFAULT);
        bottompipe = new ImageIcon("C:\\Users\\fasil\\Desktop\\flappy bird\\pipeup.png").getImage().getScaledInstance(pipewidth, 600, Image.SCALE_DEFAULT);
        timer = new Timer(1000 / 60, (ActionListener) this);// this can set the time of motion of image
        timer.start();
        
        setFocusable(true);

        addKeyListener(this);
        
    }
  
  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);// show background color
        g2d = (Graphics2D) g;

        

        g2d.drawImage(bird, x, y, null);

        // Draw multiple pipes
        
        for (int i = 0; i < pipePositions.length; i++) {       
        	
            g2d.drawImage(toppipe, pipePositions[i], pipeytop[arrayposition], null);
            g2d.drawImage(bottompipe, pipePositions[i], pipeybottom[arrayposition], null);
            
        
       
        }
        if (gameover) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over!", width / 2 -120, height/ 2);
            timer.stop();
        }
    }
    public void collision(){
    	if(y > height|| y < 0) {
    		gameover=true;
    	}
    	for (int i = 0; i < pipePositions.length; i++) {System.out.println(y);}
    		if(pipePositions[0]  <=x+36 && pipePositions[0] >=1) {
            	if (score==0) {
            	if(y <= 395|| y >= 467) {
					            	
					            	gameover=true; 
					            	 }else {
					            		 gameover=false;
					            	 }        	
                        	
    		
            	}
            	
            	
	
    		}}
    public void actionPerformed(ActionEvent e) {
        y = y + yvelocity;

        
        for(int i=0;i < pipePositions.length;i++) {
     	   if(pipePositions[i] == 30) {
     		  score=score+1;
     		 }
     	   if(pipePositions[0] == 360) {
        		  if(score==2) {
         			  score=0;
         		  }
     	   }
     	   
     	  }
        for (int i = 0; i < pipePositions.length; i++) {
        	pipePositions[i] = pipePositions[i] + velpipe;
            if (pipePositions[i] <= -pipewidth) {
                pipePositions[i] = width; // Reset the pipe to the right side when it goes off-screen
            }
        }
        if(!gameover) {
        	collision();
        }

        for(int i=0;i < pipePositions.length;i++) {
        	if(pipePositions[i]==0) {
        		arrayposition=arrayposition+1;
        	}
        	}
        if(arrayposition>=pipeytop.length) {
        	arrayposition=0;
        }
        
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            yvelocity = -8;
            velpipe = -3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        yvelocity = 8;
    }
}