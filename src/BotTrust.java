import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static java.lang.Math.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class BotTrust {

	public static void main(String[] args) throws IOException {
		
		GamePanel gamePanel = new GamePanel();
		Thread t1 = new Thread(gamePanel);
		
		JFrame frame = new JFrame("Bot Trust Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
                
        frame.add(gamePanel, BorderLayout.CENTER);
        
        frame.setSize(1550, 500);
        frame.setVisible(true);

	 	t1.start();
		
	}
}
