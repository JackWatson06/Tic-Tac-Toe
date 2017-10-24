package TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Title extends JPanel {

	BufferedImage image;
	
	//This class just draws the title at the start of the game in random colors.
	
	public Title(){
		
	}
	
	
	public void drawTitle(){
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		int r = (int) ((float)(Math.random() * 100) * 2.55);
		int gr = (int) ((float)(Math.random() * 100) * 2.55);
		int b = (int) ((float)(Math.random() * 100) * 2.55);
		Color color = new Color(r, gr, b);
		Font font = new Font("Verodana", Font.BOLD, 40);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(color);
		g.setFont(font);
		g.drawString("Tic-Tac-Toe", 330, 175);
		g.dispose();
		repaint();
		
	}
	
	
	public void paintComponent(Graphics render){

		Graphics2D g = (Graphics2D) render.create();
		g.drawImage(image, 0, 0, this);
		g.dispose();

	}
	
}
