package TicTacToe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Canvas extends JPanel{
	
	JButton reset = new JButton("Reset");
	BufferedImage board;
	BufferedImage turnNotification;
	int width;
	
	
	//The Canvas class is in control of all drawing to the screen.
	
	public Canvas(){
		
	}
	
	//This draws the initial board.
	
	public void setUpBoard(int lineWidth){
		

		board = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		//Background
		Graphics2D g = board.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.dispose();
		
		//Lines
		Graphics2D g2 = board.createGraphics();
		g2.setColor(Color.black);
		g2.fillRect((getWidth() / 3), 0, lineWidth, getHeight());
		g2.fillRect((getWidth() / 3) * 2, 0, lineWidth, getHeight());
		g2.fillRect(0, getHeight() / 3, getWidth(), lineWidth);
		g2.fillRect(0, getHeight() / 3 * 2, getWidth(), lineWidth);
		width = lineWidth;
		g2.dispose();
		
		//Set Up Turn Notification
		turnNotification = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		repaint();
		
	}
	
	//This adds a square when a square needs to be added.
	
	public void addSquare(int where, Color color){
		Graphics2D g3 = board.createGraphics();
		g3.setColor(color);
		if(where == 1){
			g3.fillRect(5, 5, (getWidth() / 3) - 10, (getHeight() / 3) - 10);

		}else if(where == 2){
			g3.fillRect((getWidth() / 3) + 11, 5, ((getWidth() / 3)) - 15, (getHeight() / 3) - 10);
			
		}else if(where == 3){
			g3.fillRect(((getWidth() / 3) * 2) + 11, 5, ((getWidth() / 3)) - 15, (getHeight() / 3) - 10);
			
		}else if(where == 4){
			g3.fillRect(5, (getHeight() / 3) + 11, ((getWidth() / 3)) - 10, (getHeight() / 3) - 15);
			
		}else if(where == 5){
			g3.fillRect((getWidth() / 3) + 11, (getHeight() / 3) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 6){
			g3.fillRect(((getWidth() / 3) * 2) + 11, (getHeight() / 3) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 7){
			g3.fillRect(5, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 10, (getHeight() / 3) - 15);
			
		}else if(where == 8){
			g3.fillRect((getWidth() / 3)  + 11, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 9){
			g3.fillRect(((getWidth() / 3) * 2) + 11, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
		}
		g3.dispose();
		repaint();
		
	}
	
	//This adds a circle when a circle needs to be added.
	
	public void addCircle(int where, Color color){
		Graphics2D g3 = board.createGraphics();
		g3.setColor(color);
		if(where == 1){
			g3.fillOval(5, 5, (getWidth() / 3) - 10, (getHeight() / 3) - 10);

		}else if(where == 2){
			g3.fillOval((getWidth() / 3) + 11, 5, ((getWidth() / 3)) - 15, (getHeight() / 3) - 10);
			
		}else if(where == 3){
			g3.fillOval(((getWidth() / 3) * 2) + 11, 5, ((getWidth() / 3)) - 15, (getHeight() / 3) - 10);
			
		}else if(where == 4){
			g3.fillOval(5, (getHeight() / 3) + 11, ((getWidth() / 3)) - 10, (getHeight() / 3) - 15);
			
		}else if(where == 5){
			g3.fillOval((getWidth() / 3) + 11, (getHeight() / 3) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 6){
			g3.fillOval(((getWidth() / 3) * 2) + 11, (getHeight() / 3) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 7){
			g3.fillOval(5, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 10, (getHeight() / 3) - 15);
			
		}else if(where == 8){
			g3.fillOval((getWidth() / 3)  + 11, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
			
		}else if(where == 9){
			g3.fillOval(((getWidth() / 3) * 2) + 11, ((getHeight() / 3) * 2) + 11, ((getWidth() / 3)) - 15, (getHeight() / 3) - 15);
		}
		g3.dispose();
		repaint();
	}
	
	//This draws a line for when the game is one.
	
	public void drawLine(int where){
		//System.out.println("Test");
		Graphics2D g4 = board.createGraphics();
		g4.setColor(Color.black);
		if(where == 1){
			g4.fillRect(5, (getHeight() / 6), (getWidth() - 10), width - 2);
		}else if(where == 2){
			g4.fillRect(5, (getHeight() / 6) * 3, (getWidth() - 10), width - 2);
		}else if(where == 3){
			g4.fillRect(5, (getHeight() / 6) * 5, (getWidth() - 10), width - 2);
		}else if(where == 4){
			g4.fillRect((getWidth() / 6), 5, width - 2, (getHeight() - 10));
		}else if(where == 5){
			g4.fillRect((getWidth() / 6) * 3, 5, width - 2, (getHeight() - 10));
		}else if(where == 6){
			g4.fillRect((getWidth() / 6) * 5, 5, width - 2, (getHeight() - 10));
		}else if(where == 7){
			g4.setStroke(new BasicStroke(width-2));
			g4.drawLine(0, 0, getWidth(), getHeight());
		}else if(where == 8){
			g4.setStroke(new BasicStroke(width - 2));
			g4.drawLine(getWidth(), 0, 0, getHeight());
		}
		g4.dispose();
		repaint();
		
	}
	
	//This draws the win screen.
	
	public void drawWinScreen(){
		Font font = new Font("Verodana", Font.BOLD, 30);
		Graphics2D g4 = board.createGraphics();
		g4.setColor(Color.white);
		g4.fillRect(0, 0, getWidth(), getHeight());
		g4.setColor(Color.orange);
		g4.setFont(font);
		g4.drawString("You Win!!!", (getWidth() / 2) - 70, getHeight() / 2);
		g4.dispose();
		repaint();
	}
	
	//This draws the loose screen.
	
	public void drawLooseScreen(){
		Font font = new Font("Verodana", Font.BOLD, 30);
		Graphics2D g4 = board.createGraphics();
		g4.setColor(Color.white);
		g4.fillRect(0, 0, getWidth(), getHeight());
		g4.setColor(Color.DARK_GRAY);
		g4.setFont(font);
		g4.drawString("You Lost", (getWidth() / 2) - 70, getHeight() / 2);
		g4.dispose();
		repaint();

	}
	
	//This draws the tie screen.
	
	public void drawTieScreen(){
		Font font = new Font("Verodana", Font.BOLD, 30);
		Graphics2D g4 = board.createGraphics();
		g4.setColor(Color.white);
		g4.fillRect(0, 0, getWidth(), getHeight());
		g4.setColor(Color.gray);
		g4.setFont(font);
		g4.drawString("Tie Game", (getWidth() / 2) - 70, getHeight() / 2);
		g4.dispose();
		repaint();

	}
	
	//This draws the turn notification.
	
	public void turnNotification(boolean test){
		Font font = new Font("Verodana", Font.BOLD, 20);
		Graphics2D g = turnNotification.createGraphics();
		g.setFont(font);
		if(test){
			
			g.setBackground(new Color(255, 255, 255, 0));
            g.clearRect(0,0, getWidth(), getHeight());
			g.setColor(Color.black);
			g.drawString("Your Turn...", 60, 40);
			g.dispose();
			repaint();
			
		}else if(!test){
			
			g.setBackground(new Color(255, 255, 255, 0));
            g.clearRect(0,0, getWidth(), getHeight());
			g.setColor(Color.black);
			g.drawString("Computer's Turn...", 60, 40);
			g.dispose();
			repaint();
			
		}
		
	}

	
	public void clearTurnNotification(){
		Graphics2D g = turnNotification.createGraphics();
		g.setBackground(new Color(255,255,255,0));
		g.clearRect(0, 0, getWidth(), getHeight());
		g.dispose();
		
	}
	
	//This is the actually method that paints the graphics to the screen.
	
	public void paintComponent(Graphics render){
	

		super.paintComponent(render);
		Graphics2D g = (Graphics2D) render.create();
		g.drawImage(board, 0, 0, this);
		g.drawImage(turnNotification, 0, 0, this);
		g.dispose();
		
		
		
	}
	

}
