package TicTacToe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ColorSelecterSquare extends JFrame implements ActionListener {

	static Color colorSquare = Color.blue;
	static Color colorCircle = Color.yellow;
	static boolean colorOfCircleOrSquare = true;
	Color orange = new Color(255, 85, 0);
	String[] buttonColors = { "Red", "Green", "Blue", "Yellow", "Orange", "Magenta", "Cyan", "Pink", "Gray" };
	Color[] buttonColors2 = { Color.red, Color.green, Color.blue, Color.yellow, orange, Color.magenta, Color.cyan,
			Color.pink, Color.darkGray };
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	JPanel panel = new JPanel();
	Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	GridLayout grid = new GridLayout(3, 3);
	FlowLayout flo = new FlowLayout();

	//This class is just incharge of the entire window for color selection.
	
	public ColorSelecterSquare(String string) {
		super(string);
		colorOfCircleOrSquare = true;
		setSize(Main.Width / 3, Main.Height / 3);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		createButtons();
		panel.setLayout(grid);
		panel.setBorder(padding);

		for (int i = 0; i < buttonColors.length; i++) {
			panel.add(buttonList.get(i));
			buttonList.get(i).addActionListener(this);
		}

		add(panel);
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2,dim.height / 2 - this.getSize().height / 2);
	}

	public void createButtons() {
		for (int i = 0; i < buttonColors.length; i++) {
			buttonList.add(new JButton(buttonColors[i]));
		}
	}

	public static void main(String[] args) {
		new ColorSelecterSquare("Square Color Selector");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();
		for (int i = 0; i < buttonColors.length; i++) {
			if (action.equals(buttonColors[i]) && colorOfCircleOrSquare) {
				colorSquare = buttonColors2[i];
				Main.squareColorText.setText(buttonColors[i]);
				super.dispose();
			} else if (action.equals(buttonColors[i]) && !colorOfCircleOrSquare) {
				colorCircle = buttonColors2[i];
				Main.circleColorText.setText(buttonColors[i]);
				super.dispose();
			}
		}

	}
}
