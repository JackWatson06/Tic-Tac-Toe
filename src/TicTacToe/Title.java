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
	
	BufferedImage testing;
	
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
		
		testing = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		
	}
	
	public void drawTesting(int[] pointData) {
		
		System.out.println(": Draw Testing");
		
		Font font = new Font("Verodana", Font.BOLD, 20);
		Graphics2D g = testing.createGraphics();
		g.setFont(font);
		String drawString = "";
		for(int i = 0; i < pointData.length; i++) {
			if(i + 1 < pointData.length) {
				drawString += pointData[i] + " , ";
			}else {
				drawString += pointData[i];
			}
		}
		
		
		g.setBackground(new Color(255, 255, 255, 0));
        g.clearRect(0,0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawString(drawString, 400, 40);
		g.dispose();
		repaint();
		
	}
	
	public void removeDrawTesting() {
		Graphics2D g = testing.createGraphics();
		g.setBackground(new Color(255,255,255,0));
		g.clearRect(0, 0, getWidth(), getHeight());
		g.dispose();
	}
	
	
	public void paintComponent(Graphics render){

		Graphics2D g = (Graphics2D) render.create();
		g.drawImage(image, 0, 0, this);
		g.drawImage(testing, 0, 0, this);
		g.dispose();

	}
	
}
