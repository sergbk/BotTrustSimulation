import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	boolean btnPressed = false;
	boolean ReadNextLine = false;
	
	final int circleDim= 12;
	final int ff = 15;
	
	public static int oHx = 14;		// Orange's Head X position
	public static int oBx = 14;		// Orange's Body X position
	public static int oRHx = 10;	// Orange's Right Hand X position
	public static int oLHx = 30;	// Orange's Left Hand X position
	public static int oRLx = 16;	// Orange's Right Leg X position
	public static int oLLx = 24;	// Orange's Left Leg X position
	public static int oRAx = 19;	// Orange's Right Antenna X position
	public static int oLAx = 24;	// Orange's Left Antenna X position
	public static int oRAx2 = 14;	// Orange's Right Antenna X2 position
	public static int oLAx2 = 29;	// Orange's Left Antenna X2 position
	public static int oRYx = 24;	// Orange's Right Eye X position
	public static int oLYx = 18;	// Orange's Left Eye X position
	
	public static int bHx = 14;		// Blue's Head X position
	public static int bBx = 14;		// Blue's Body X position
	public static int bRHx = 10;	// Blue's Right Hand X position
	public static int bLHx = 30;	// Blue's Left Hand X position
	public static int bRLx = 16;	// Blue's Right Leg X position
	public static int bLLx = 24;	// Blue's Left Leg X position
	public static int bRAx = 19;	// Blue's Right Antenna X position
	public static int bLAx = 24;	// Blue's Left Antenna X position
	public static int bRAx2 = 14;	// Blue's Right Antenna X2 position
	public static int bLAx2 = 29;	// Blue's Left Antenna X2 position
	public static int bRYx = 24;	// Blue's Right Eye X position
	public static int bLYx = 18;	// Blue's Left Eye X position
	
		@Override
		public void run() {
			logic();
			
			try {
	            Thread.sleep(10);
	        } catch (InterruptedException ex) {
	            
	        }
	        
			repaint();
	    }
	
		public void logic() {
			Scanner input = null;
			try {
				input = new Scanner(new File("BotTrustInput.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    int numTests = input.nextInt(); 			//	Storing Total number of Cases

		    input.nextLine();
		    
		    for (int i = 1; i <= numTests; i++) 
		    {    	
		    	int time = 0;		// Overall Time
		    	
		    	int Otime = 0;		// Orange's Time
		    	int Btime = 0;		// Blue's Time
		    	
		    	int Opos = 1;		// Orange's position - Always 1
		    	int Bpos = 1;		// Blue's position - Always 1
		    	
		    	promptNextLine();
		    	
		    	if (ReadNextLine) {
			    	int numBtns = input.nextInt();			// Storing number of buttons for the given set
			    	    	
			    	for (int j = 0; j < numBtns; j++) {
			    		
			    		if (input.next().equals("O"))
			    		{
			    	 		int btn = input.nextInt();
			    	 		Btime = max(Btime + abs(Bpos - btn), Otime) + 1;
			    	 		Bpos = btn;
			    	 		updateOrange(btn);
			    		} 
			    		
			    		else
			    		{
			    	 		int btn = input.nextInt();
			    	 		Otime = max(Otime + abs(Opos - btn), Btime) + 1;
			    	 		Opos = btn;
			    	 		updateBlue(btn);
			    		} 
			    		ReadNextLine = false;
	
			    	}
		    	}
		    	System.out.println("Case #" + i + ": " + max(Btime, Otime));
		    }
		}
		
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			
			/*
			 * Drawing Orange Robot
			 */
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g2d.setColor(new Color(255, 165, 0));
		    
		    g2d.fillArc(oHx, 75, 15, 10, 0, 180); 				// head circle
		    g2d.fillRect(oBx, 81, 15, 15); 						// body
		    
		    g2d.fillRoundRect(oRHx, 80, 3, 12, 30, 30); 		// right hand
		    g2d.fillRoundRect(oLHx, 80, 3, 12, 30, 30); 		// left hand
		    
		    g2d.fillRoundRect(oRLx, 94, 3, 8, 30, 30); 			// right leg
		    g2d.fillRoundRect(oLLx, 94, 3, 8, 30, 30); 			// left leg
		    
		    g2d.drawLine(oRAx, 74, oRAx2, 69); 					// right antenna 
		    g2d.drawLine(oLAx, 74, oLAx2, 69); 					// left antenna
		    
		    g2d.setColor(Color.white);
		    g2d.fillOval(oLYx, 77, 1, 1); 						// left eye
		    g2d.fillOval(oRYx, 77, 1, 1); 						// right eye
			
		    
		    
		    /*
			 * Drawing Blue Robot
			 */
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    g2d.setColor(new Color(0, 0, 255));
		    
		    g2d.fillArc(bHx, 280, 15, 10, 0, 180); 				// head circle
		    g2d.fillRect(bBx, 286, 15, 15); 					// body
		    
		    g2d.fillRoundRect(bRHx, 285, 3, 12, 30, 30); 		// right hand
		    g2d.fillRoundRect(bLHx, 285, 3, 12, 30, 30); 		// left hand
		    
		    g2d.fillRoundRect(bRLx, 299, 3, 8, 30, 30); 		// right leg
		    g2d.fillRoundRect(bLLx, 299, 3, 8, 30, 30); 		// left leg
		    
		    g2d.drawLine(bRAx, 279, bRAx2, 274); 				// right antenna 
		    g2d.drawLine(bLAx, 279, bLAx2, 274); 				// left antenna
		    
		    g2d.setColor(Color.white);
		    g2d.fillOval(bLYx, 282, 1, 1); 						// left eye
		    g2d.fillOval(bRYx, 282, 1, 1); 						// right eye
		    
		    
		    
		    /*
		     * Drawing buttons
		     */
			g.setColor(Color.red);
			for(int i = 1; i <= 100; i++) {
				g.drawOval(i * ff, 115, circleDim, circleDim);
				g.drawOval(i * ff, 320, circleDim, circleDim);
			}
			
			
			
			/*
			 * Drawing Hallways
			 */
			g.setColor(Color.orange);
			g.drawRect(5, 50, 1520, 150);
			g.setFont(new Font("Calibri", 1, 30));
			g.drawString("ORANGE HALLWAY", 630, 45);
			
			g.setColor(Color.blue);
			g.drawRect(5, 250, 1520, 150);
			g.setFont(new Font("Calibri", 1, 30));
			g.drawString("BLUE HALLWAY", 650, 245);

			
			if(btnPressed) {
				g.setColor(Color.red);
				//g.fillOval(flags, flags, flags, flags);	// Fill Red button to simulate Button Push
			}

		}
		
		public void updateOrange(int bpos) {
			System.out.println("Moving Orange to button " + bpos);
			for (int i = 1; i < bpos; i++) {
				oHx += ff;		// Orange's Head X position
				oBx += ff;		// Orange's Body X position
				oRHx += ff;		// Orange's Right Hand X position
				oLHx += ff;		// Orange's Left Hand X position
				oRLx += ff;		// Orange's Right Leg X position
				oLLx += ff;		// Orange's Left Leg X position
				oRAx += ff;		// Orange's Right Antenna X position
				oLAx += ff;		// Orange's Left Antenna X position
				oRAx2 += ff;	// Orange's Right Antenna X2 position
				oLAx2 += ff;	// Orange's Left Antenna X2 position
				oRYx += ff;		// Orange's Right Eye X position
				oLYx += ff;		// Orange's Left Eye X position
	
				repaint();
			}
		}
		
		public void updateBlue(int bpos) {
			System.out.println("Moving Blue to button " + bpos);
			for (int i = 1; i < bpos; i++) {
				bHx += ff;		// Blue's Head X position
				bBx += ff;		// Blue's Body X position
				bRHx += ff;		// Blue's Right Hand X position
				bLHx += ff;		// Blue's Left Hand X position
				bRLx += ff;		// Blue's Right Leg X position
				bLLx += ff;		// Blue's Left Leg X position
				bRAx += ff;		// Blue's Right Antenna X position
				bLAx += ff;		// Blue's Left Antenna X position
				bRAx2 += ff;	// Blue's Right Antenna X2 position
				bLAx2 += ff;	// Blue's Left Antenna X2 position
				bRYx += ff;		// Blue's Right Eye X position
				bLYx += ff;		// Blue's Left Eye X position
				
				repaint();
			}
		}
		
		public void promptNextLine() {
			System.out.println("Hit 'N' to read next line");
			Scanner s = new Scanner(System.in);
			String scan  = s.nextLine();
			
			if (scan.equals("N")) {
				ReadNextLine = true;
			}
				
		}
		
}