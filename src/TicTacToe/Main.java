/*
 * 
 * Jack Watson
 * Tic-Tac-Toe Game Code
 * 
 * 
 */
package TicTacToe;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener, ItemListener, Runnable {

	Canvas graphics = new Canvas();
	Title title = new Title();
	boolean running = true;
	static int Width = 900;
	static int Height = 900;
	boolean playersTurn2 = true;
	boolean player = true;
	boolean computerPlayersTurn = true;
	boolean endScreen = true;
	boolean win2 = true;
	boolean running2 = true;
	int testPoint;
	int pressed2;
	int difficultyNumber = 1;
	int status2 = 0;
	int[] point = new int[9];
	int first = 0;
	int firstButtonPressed = 0;
	JPanel squareCircle = new JPanel();
	JPanel color = new JPanel();
	JPanel difficulty = new JPanel();
	JPanel playPanel = new JPanel();
	JPanel squareColor = new JPanel();
	JPanel circleColor = new JPanel();
	JPanel resetPanel = new JPanel();
	JPanel exitPanel = new JPanel();
	static JTextField squareColorText = new JTextField();
	static JTextField circleColorText = new JTextField();
	JCheckBox squareCheck = new JCheckBox("Squares", true);
	JCheckBox circleCheck = new JCheckBox("Circles", false);
	JLabel Color2 = new JLabel("Color: ");
	JLabel Difficulty = new JLabel("Difficulty: ");
	JLabel check = new JLabel("Do you want to play as Circles or Squares?");
	JButton colorOfSquares = new JButton("Square Color");
	JButton colorOfCircles = new JButton("Circle Color");
	JButton reset = new JButton("Return To Title Screen");
	JButton exit = new JButton("Exit Game");
	JCheckBox difficultyEasy = new JCheckBox("Easy Difficulty");
	JCheckBox difficultyNormal = new JCheckBox("Normal Difficulty");
	JCheckBox difficultyHard = new JCheckBox("Hard Difficulty");
	JButton play = new JButton("Play");
	BoxLayout box = new BoxLayout(title, BoxLayout.Y_AXIS);
	BoxLayout box2 = new BoxLayout(squareColor, BoxLayout.Y_AXIS);
	BoxLayout box3 = new BoxLayout(circleColor, BoxLayout.Y_AXIS);
	BoxLayout box4 = new BoxLayout(graphics, BoxLayout.Y_AXIS);
	FlowLayout secondLayout = new FlowLayout();
	private static final int window = JComponent.WHEN_IN_FOCUSED_WINDOW;
	boolean positionFound = false;

	// This main constructor sets the frame of the game.
	
	public Main() {
		super("Tic-Tac-Toe");
		setSize(Width, Height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		title.setLayout(box);
		title.setLayout(box);
		title.setBorder(new EmptyBorder((getWidth() / 3) - 50, getHeight() / 3, getWidth() / 3, getHeight() / 3));
		squareCircle.setLayout(secondLayout);
		squareCircle.setBorder(new EmptyBorder(0, 0, 0, 0));
		color.setLayout(secondLayout);
		color.setBorder(new EmptyBorder(0, 0, -15, 0));
		difficulty.setLayout(secondLayout);
		difficulty.setBorder(new EmptyBorder(0, 0, 20, 0));
		playPanel.setLayout(secondLayout);
		playPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		squareColor.setLayout(box2);
		circleColor.setLayout(box3);
		squareColorText.setEditable(false);
		squareColorText.setHorizontalAlignment(JTextField.CENTER);
		circleColorText.setEditable(false);
		circleColorText.setHorizontalAlignment(JTextField.CENTER);
		squareCircle.setOpaque(false);
		color.setOpaque(false);
		squareColor.setOpaque(false);
		circleColor.setOpaque(false);
		difficulty.setOpaque(false);
		playPanel.setOpaque(false);
		squareCheck.setOpaque(false);
		circleCheck.setOpaque(false);
		difficultyEasy.setOpaque(false);
		difficultyNormal.setOpaque(false);
		difficultyHard.setOpaque(false);

		squareCircle.add(check);
		squareCircle.add(squareCheck);
		squareCircle.add(circleCheck);
		squareCheck.addItemListener(this);
		circleCheck.addItemListener(this);

		squareColor.add(colorOfSquares);
		squareColor.add(Box.createRigidArea(new Dimension(0, 15)));
		squareColor.add(squareColorText);
		circleColor.add(colorOfCircles);
		circleColor.add(Box.createRigidArea(new Dimension(0, 15)));
		circleColor.add(circleColorText);
		color.add(squareColor);
		color.add(circleColor);
		colorOfSquares.addActionListener(this);
		colorOfCircles.addActionListener(this);

		difficulty.add(difficultyEasy);
		difficulty.add(difficultyNormal);
		difficulty.add(difficultyHard);
		difficultyEasy.addItemListener(this);
		difficultyNormal.addItemListener(this);
		difficultyHard.addItemListener(this);

		playPanel.add(play);
		play.addActionListener(this);

		difficultyEasy.setSelected(true);

		title.add(squareCircle);
		title.add(color);
		title.add(difficulty);
		title.add(playPanel);
		add(title);

		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2,dim.height / 2 - this.getSize().height / 2);

		title.drawTitle();

		squareColorText.setText("Blue");
		circleColorText.setText("Yellow");

		run();

	}

	public static void main(String[] args) {
		new Main();
	}

	// This is what runs the game and keep tracks of the game order.

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 9; i++) {
				point[i] = 0;
			}
			boolean waiting = true;
			while (waiting) {
				try {
					this.wait();

				} catch (Exception e) {

				}
				waiting = false;

			}
			int test = (int) ((float) (Math.random() * 10));

			if (test <= 5) {
				first = 1;
			}
			if (test > 5) {
				first = 2;
			}
			while (running) {

				if (first == 2) {
					graphics.turnNotification(false);
					computerPlayer();
					win();
					win2 = false;
				}
				if (first == 1) {
					win2 = true;
				}

				keyBindings(true);
				while (playersTurn2) {
					try {
						graphics.turnNotification(true);
						this.wait();
					} catch (Exception e) {

					}

					setIndex();

				}
				keyBindings(false);
				playersTurn2 = true;
				if (running) {
					win();
				}
				if (win2) {
					graphics.turnNotification(false);
					computerPlayer();
					win();
				}
			}
			running = true;
			while (endScreen) {
				try {
					this.wait();
				} catch (Exception e) {
				}

				
				run();
				System.out.println("THIS SHOULD NEVER PRINT");
			}
		}
	}

	//This determines where the player wants to move
	
	public void setIndex() {
		firstButtonPressed = pressed2;
		int[] lettersPressed = { 81, 87, 69, 65, 83, 68, 90, 88, 67 };
		int[] modifierPressed = { 36, 38, 33, 37, 12, 39, 35, 40, 34 };
		int[] numberPressed = {103, 104, 105, 100, 101, 102, 97, 98, 99};

		for (int a = 0; a < 9; a++) {
			if ((pressed2 == lettersPressed[a] || pressed2 == modifierPressed[a] || pressed2 == numberPressed[a]) && point[a] == 0) {
				playersTurn2 = false;
				if (player) {
					graphics.addSquare(a + 1, ColorSelecterSquare.colorSquare);
				} else {
					graphics.addCircle(a + 1, ColorSelectorCircle.colorCircle);
				}
				if (player) {
					point[a] = 1;
				} else {
					point[a] = 2;
				}
			}
		}

	}

	
	//This determines the computer players move based on the threed differing levels of difficulty.
	//Easy chooses randomly.
	//Normal tries to block the player.
	//Hard tries to set up instances where the computer can win.
	public void computerPlayer() {

		// EASY DIFFICULTY
		if (difficultyNumber == 1) {
			
			while (computerPlayersTurn) {
				int zeroCount = 0;
				for (int i = 0; i < point.length; i++) {
					if (point[i] == 0) {
						zeroCount++;
					}
				}

				try {
					if (zeroCount > 1) {
						Thread.sleep(500);
					} else {
						Thread.sleep(200);
					}
				} catch (Exception e) {

				}

				float test = (float) Math.random() * 10;
				int test2 = (int) test;
				int[] test3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

				for (int a = 0; a < 9; a++) {
					if (test2 == test3[a] && point[a] == 0) {
						computerPlayersTurn = false;
						if (player) {
							graphics.addCircle(a + 1, ColorSelectorCircle.colorCircle);

						} else {
							graphics.addSquare(a + 1, ColorSelecterSquare.colorSquare);
						}
						if (player) {
							point[a] = 2;
						} else {
							point[a] = 1;
						}
					}
				}
			}

			computerPlayersTurn = true;

			// NORMAL DIFFIUCLTY
		} else if (difficultyNumber == 2) {

			normalAndHardDifficultyMovement();

			if (!positionFound) {

				/*
				 * if(point[1] == 0 && !positionFound){ point[1] = 2; graphics.addCircle(2,
				 * ColorSelectorCircle.colorCircle); System.out.println("Test"); positionFound =
				 * true; }
				 */

				while (computerPlayersTurn) {
					int zeroCount = 0;
					for (int i = 0; i < point.length; i++) {
						if (point[i] == 0) {
							zeroCount++;
						}
					}

					try {
						if (zeroCount > 1) {
							Thread.sleep(500);
						} else {
							Thread.sleep(200);
						}
					} catch (Exception e) {

					}

					float test = (float) Math.random() * 10;
					int test2 = (int) test;
					int[] test3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

					for (int a = 0; a < 9; a++) {
						if (test2 == test3[a] && point[a] == 0) {
							computerPlayersTurn = false;
							if (player) {
								graphics.addCircle(a + 1, ColorSelectorCircle.colorCircle);

							} else {
								graphics.addSquare(a + 1, ColorSelecterSquare.colorSquare);
							}
							if (player) {
								point[a] = 2;
							} else {
								point[a] = 1;
							}
						}
					}
				}
			}

			positionFound = false;
			computerPlayersTurn = true;

			// HARD DIFFICULTY

		} else if (difficultyNumber == 3) {
			normalAndHardDifficultyMovement();

			if (!positionFound) {

				int[] activeSpaces = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
				int[] cornerNumbers = { 0, 0, 2, 0, 6, 0, 8 };
				int[] centerNumbers = { 1, 0, 3, 0, 5, 0, 7 };
				int[] centerConstants = { 0, 2, 0, 6, 2, 8, 6, 8 };
				int[] centerHorizontalandVerticalConstants = { 4, 7, 4, 5, 4, 3, 4, 1 };
				int[] horizontalConstants = { 1, 2, 0, 1, 7, 8, 6, 7 };
				int[] diagonalConstants = { 4, 8, 4, 6, 4, 2, 4, 0 };
				int[] verticalConstants = { 3, 6, 5, 8, 0, 3, 2, 5 };

				for (int i = 0; i < 7; i += 2) {

					if (!positionFound) {
						boolean activeSpacesTrueFalse = false;
						int number;
						if (player) {
							number = 2;
						} else {
							number = 1;
						}

						if (point[1] == 0 && point[7] == 0 && point[4] == number) {
							activeSpaces[10] = 1;
							activeSpaces[11] = 7;
							activeSpacesTrueFalse = true;
						}

						if (point[3] == 0 && point[5] == 0 && point[4] == number) {
							activeSpaces[12] = 3;
							activeSpaces[13] = 5;
							activeSpacesTrueFalse = true;
						}
						if (point[0] == 0 && point[8] == 0 && point[4] == number) {
							activeSpaces[14] = 0;
							activeSpaces[15] = 8;
							activeSpacesTrueFalse = true;
						}
						if (point[2] == 0 && point[6] == 0 && point[4] == number) {
							activeSpaces[16] = 2;
							activeSpaces[17] = 6;
							activeSpacesTrueFalse = true;
						}
						if (point[centerConstants[i]] == 0 && point[centerConstants[i + 1]] == 0
								&& point[centerNumbers[i]] == number) {
							activeSpaces[6] = centerConstants[i];
							activeSpaces[7] = centerConstants[i + 1];
							activeSpacesTrueFalse = true;
						}

						if (point[centerHorizontalandVerticalConstants[i]] == 0
								&& point[centerHorizontalandVerticalConstants[i + 1]] == 0
								&& point[centerNumbers[i]] == number) {
							activeSpaces[8] = centerHorizontalandVerticalConstants[i];
							activeSpaces[9] = centerHorizontalandVerticalConstants[i + 1];
							activeSpacesTrueFalse = true;
						}

						if (point[horizontalConstants[i]] == 0 && point[horizontalConstants[i + 1]] == 0
								&& point[cornerNumbers[i]] == number) {
							activeSpaces[0] = horizontalConstants[i];
							activeSpaces[1] = horizontalConstants[i + 1];
							activeSpacesTrueFalse = true;
						}

						if (point[diagonalConstants[i]] == 0 && point[diagonalConstants[i + 1]] == 0
								&& point[cornerNumbers[i]] == number) {
							activeSpaces[2] = diagonalConstants[i];
							activeSpaces[3] = diagonalConstants[i + 1];
							activeSpacesTrueFalse = true;
						}

						if (point[verticalConstants[i]] == 0 && point[verticalConstants[i + 1]] == 0
								&& point[cornerNumbers[i]] == number) {
							activeSpaces[4] = verticalConstants[i];
							activeSpaces[5] = verticalConstants[i + 1];
							activeSpacesTrueFalse = true;
						}

						if (activeSpacesTrueFalse == true) {
							boolean choosingActiveSpaces = true;
							while (choosingActiveSpaces) {

								float test = (float) Math.random() * 9;
								int test2 = (int) test;


								for (int j = 0; j < activeSpaces.length; j++) {
									if (activeSpaces[j] == test2) {

										try {
											Thread.sleep(1000);
										} catch (Exception e) {

										}

										//for (int z = 0; z < activeSpaces.length; z++) {
											//System.out.println("ActiveSpaces: " + activeSpaces[z]);
										//}
										//System.out.println(activeSpaces.length);
										//System.out.println("I number: " + j);
										//System.out.println("Where the computer moved: " + activeSpaces[j]);

										if (player) {
											point[activeSpaces[j]] = 2;
										} else {
											point[activeSpaces[j]] = 1;
										}
										if (player) {
											graphics.addCircle(activeSpaces[j] + 1, ColorSelectorCircle.colorCircle);

										} else {
											graphics.addSquare(activeSpaces[j] + 1, ColorSelecterSquare.colorSquare);
										}

										choosingActiveSpaces = false;
										for (int y = 0; y < 6; y++) {
											activeSpaces[y] = 9;
										}
										positionFound = true;
									}
								}

							}
						}

					}
				}

				if (!positionFound) {

					while (computerPlayersTurn) {
						int zeroCount = 0;
						for (int i = 0; i < point.length; i++) {
							if (point[i] == 0) {
								zeroCount++;
							}
						}

						try {
							if (zeroCount > 1) {
								Thread.sleep(500);
							} else {
								Thread.sleep(200);
							}
						} catch (Exception e) {

						}

						float test = (float) Math.random() * 10;
						int test2 = (int) test;
						int[] test3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

						for (int a = 0; a < 9; a++) {
							if (test2 == test3[a] && point[a] == 0) {
								computerPlayersTurn = false;
								if (player) {
									graphics.addCircle(a + 1, ColorSelectorCircle.colorCircle);

								} else {
									graphics.addSquare(a + 1, ColorSelecterSquare.colorSquare);
								}
								if (player) {
									point[a] = 2;
								} else {
									point[a] = 1;
								}
							}
						}
					}
				}

				computerPlayersTurn = true;

			}

			positionFound = false;
		}

	}

	//This is the code for the blocking mechanisms, and this applys to only hard and normal difficulty.
	
	public void normalAndHardDifficultyMovement() {
		int[] horizontalConstants = { 1, 1, 1, 4, 4, 4, 7, 7, 7 };
		int[] horizontalShapePositions = { 3, 0, 1, 6, 0, 4, 9, 0, 7 };
		int[] verticalConstants = { 3, 4, 5, 0, 0, 0, 3, 4, 5 };
		int[] verticalShapePositions = { 7, 8, 9, 0, 0, 0, 1, 2, 3 };
		boolean winMove = false;
		boolean blockMove = false;
		int iValueWin = 0;
		int iValueBlock = 0;
		String positionBlock = "";
		String positionWin = "";

		// horizontal check
		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 9; i++) {

				if (point[i] == a && point[horizontalConstants[i]] == a && i != 1 && i != 4 && i != 7
						&& point[horizontalShapePositions[i] - 1] == 0) {
					if ((player && a == 1) || (!player && a == 2)) {
						blockMove = true;
						iValueBlock = i;
						positionBlock = "horizontal";
					}
					if ((player && a == 2) || (!player && a == 1)) {
						winMove = true;
						iValueWin = i;
						positionWin = "horizontal";
					}
					positionFound = true;
				}

			}
		}

		// vertical check

		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 9; i++) {

				if (point[i] == a && point[verticalConstants[i]] == a && i != 3 && i != 4 && i != 5
						&& point[verticalShapePositions[i] - 1] == 0) {
					if ((player && a == 1) || (!player && a == 2)) {
						blockMove = true;
						iValueBlock = i;
						positionBlock = "vertical";
					}
					if ((player && a == 2) || (!player && a == 1)) {
						winMove = true;
						iValueWin = i;
						positionWin = "vertical";
					}
					positionFound = true;
				}

			}

		}

		// Horizontal Corners Check
		int[] horizontalCornersShapePosition = { 2, 0, 0, 5, 0, 0, 8 };

		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 7; i += 3) {
				if (point[i] == a && point[i + 2] == a && point[i + 1] == 0) {
					if ((player && a == 1) || (!player && a == 2)) {
						blockMove = true;
						iValueBlock = i;
						positionBlock = "horizontalCorners";
					} else if ((!player && a == 1) || (player && a == 2)) {
						winMove = true;
						iValueWin = i;
						positionWin = "horizontalCorners";
					}
					positionFound = true;
				}
			}
		}
		// Vertical Corners Check
		int[] verticalCornersShapePosition = { 4, 5, 6 };

		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 3; i++) {
				if (point[i] == a && point[i + 6] == a && point[i + 3] == 0) {
					if ((player && a == 1) || (!player && a == 2)) {
						blockMove = true;
						iValueBlock = i;
						positionBlock = "verticalCorners";
					} else if ((!player && a == 1) || (player && a == 2)) {
						winMove = true;
						iValueWin = i;
						positionWin = "verticalCorners";
					}
					positionFound = true;
				}
			}

		}

		// Diagonal Check (both corners and other one)
		int diagonalConstant = 4;
		int[] diagonalShapePosition = { 9, 0, 7, 0, 0, 0, 3, 0, 1 };
		int[] diagonalCorners = { 8, 0, 6 };
		int diagonalCornersPosition = 5;

		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 9; i += 2) {
				if (point[i] == a && point[diagonalConstant] == a && i != 4
						&& point[diagonalShapePosition[i] - 1] == 0) {
					if ((player && a == 1) || (!player && a == 2)) {
						blockMove = true;
						iValueBlock = i;
						positionBlock = "diagonal";
					} else if ((!player && a == 1) || (player && a == 2)) {
						winMove = true;
						iValueWin = i;
						positionWin = "diagonal";
					}
					positionFound = true;
				} else if ((i == 0 || i == 2) && point[i] == a && point[diagonalCorners[i]] == a
						&& point[diagonalCornersPosition - 1] == 0) {
					positionFound = true;
					positionWin = "diagonalCorners";
					winMove = true;
				}
			}
		}

		// Where the computer moves!!!

		if (positionFound) {
			boolean test = true;

			int sleep = 0;
			while (test) {
				try {
					Thread.sleep(150);
				} catch (Exception e) {

				}
				sleep++;
				if (sleep > 10) {
					test = false;
				}
			}
			if (winMove) {
				if (positionWin.equals("horizontal")) {
					if (player) {
						graphics.addCircle(horizontalShapePositions[iValueWin], ColorSelectorCircle.colorCircle);
						point[horizontalShapePositions[iValueWin] - 1] = 2;
					} else {
						graphics.addSquare(horizontalShapePositions[iValueWin], ColorSelecterSquare.colorSquare);
						point[horizontalShapePositions[iValueWin] - 1] = 1;
					}
					positionWin = "";
				} else if (positionWin.equals("vertical")) {
					if (player) {
						graphics.addCircle(verticalShapePositions[iValueWin], ColorSelectorCircle.colorCircle);
						point[verticalShapePositions[iValueWin] - 1] = 2;
					} else {
						graphics.addSquare(verticalShapePositions[iValueWin], ColorSelecterSquare.colorSquare);
						point[verticalShapePositions[iValueWin] - 1] = 1;
					}
					positionWin = "";
				} else if (positionWin.equals("horizontalCorners")) {
					if (player) {
						graphics.addCircle(horizontalCornersShapePosition[iValueWin], ColorSelectorCircle.colorCircle);
						point[horizontalCornersShapePosition[iValueWin] - 1] = 2;
					} else {
						graphics.addSquare(horizontalCornersShapePosition[iValueWin], ColorSelecterSquare.colorSquare);
						point[horizontalCornersShapePosition[iValueWin] - 1] = 1;
					}
					positionWin = "";
				} else if (positionWin.equals("verticalCorners")) {
					if (player) {
						graphics.addCircle(verticalCornersShapePosition[iValueWin], ColorSelectorCircle.colorCircle);
						point[verticalCornersShapePosition[iValueWin] - 1] = 2;
					} else {
						graphics.addSquare(verticalCornersShapePosition[iValueWin], ColorSelecterSquare.colorSquare);
						point[verticalCornersShapePosition[iValueWin] - 1] = 1;
					}
					positionWin = "";
				} else if (positionWin.equals("diagonal")) {
					if (player) {
						graphics.addCircle(diagonalShapePosition[iValueWin], ColorSelectorCircle.colorCircle);
						point[diagonalShapePosition[iValueWin] - 1] = 2;
					} else {
						graphics.addSquare(diagonalShapePosition[iValueWin], ColorSelecterSquare.colorSquare);
						point[diagonalShapePosition[iValueWin] - 1] = 1;
					}
					positionWin = "";
				} else if (positionWin.equals("diagonalCorners")) {
					if (player) {
						graphics.addCircle(diagonalCornersPosition, ColorSelectorCircle.colorCircle);
						point[diagonalCornersPosition - 1] = 2;
					} else {
						graphics.addSquare(diagonalCornersPosition, ColorSelecterSquare.colorSquare);
						point[diagonalCornersPosition - 1] = 1;
					}
					positionWin = "";
				}
				winMove = false;
				blockMove = false;
			} else if (blockMove) {
				if (positionBlock.equals("horizontal")) {
					if (player) {
						graphics.addCircle(horizontalShapePositions[iValueBlock], ColorSelectorCircle.colorCircle);
						point[horizontalShapePositions[iValueBlock] - 1] = 2;
					} else {
						graphics.addSquare(horizontalShapePositions[iValueBlock], ColorSelecterSquare.colorSquare);
						point[horizontalShapePositions[iValueBlock] - 1] = 1;
					}
					positionBlock = "";
				} else if (positionBlock.equals("vertical")) {
					if (player) {
						graphics.addCircle(verticalShapePositions[iValueBlock], ColorSelectorCircle.colorCircle);
						point[verticalShapePositions[iValueBlock] - 1] = 2;
					} else {
						graphics.addSquare(verticalShapePositions[iValueBlock], ColorSelecterSquare.colorSquare);
						point[verticalShapePositions[iValueBlock] - 1] = 1;
					}
					positionBlock = "";
				} else if (positionBlock.equals("horizontalCorners")) {
					if (player) {
						graphics.addCircle(horizontalCornersShapePosition[iValueBlock],
								ColorSelectorCircle.colorCircle);
						point[horizontalCornersShapePosition[iValueBlock] - 1] = 2;
					} else {
						graphics.addSquare(horizontalCornersShapePosition[iValueBlock],
								ColorSelecterSquare.colorSquare);
						point[horizontalCornersShapePosition[iValueBlock] - 1] = 1;
					}
					positionBlock = "";
				} else if (positionBlock.equals("verticalCorners")) {
					if (player) {
						graphics.addCircle(verticalCornersShapePosition[iValueBlock], ColorSelectorCircle.colorCircle);
						point[verticalCornersShapePosition[iValueBlock] - 1] = 2;
					} else {
						graphics.addSquare(verticalCornersShapePosition[iValueBlock], ColorSelecterSquare.colorSquare);
						point[verticalCornersShapePosition[iValueBlock] - 1] = 1;
					}
					positionBlock = "";
				} else if (positionBlock.equals("diagonal")) {
					if (player) {
						graphics.addCircle(diagonalShapePosition[iValueBlock], ColorSelectorCircle.colorCircle);
						point[diagonalShapePosition[iValueBlock] - 1] = 2;
					} else {
						graphics.addSquare(diagonalShapePosition[iValueBlock], ColorSelecterSquare.colorSquare);
						point[diagonalShapePosition[iValueBlock] - 1] = 1;
					}
					positionBlock = "";
				}
				winMove = false;
				blockMove = false;
			}
		}

	}

	
	//This checks to see if either the player or the computer has one the game yet.
	
	public void win() {
		boolean win2Squares = false;
		boolean win2Circles = false;
		// Square win check
		for (int a = 1; a < 3; a++) {
			for (int i = 0; i < 9; i++) {
				if (i == 0 || i == 3 || i == 6) {
					if (point[i] == a && point[i + 1] == a && point[i + 2] == a) {
						if (i == 0) {
							graphics.drawLine(1);

						}
						if (i == 3) {
							graphics.drawLine(2);

						}
						if (i == 6) {
							graphics.drawLine(3);

						}
						computerPlayersTurn = false;
						playersTurn2 = false;
						running = false;
						if (a == 1) {
							win2Squares = true;
						} else {
							win2Circles = true;
						}
						graphics.clearTurnNotification();
					}

				}

			}

			for (int i = 0; i < 3; i++) {
				if (point[i] == a && point[i + 3] == a && point[i + 6] == a) {
					if (i == 0) {
						graphics.drawLine(4);

					}
					if (i == 1) {
						graphics.drawLine(5);

					}
					if (i == 2) {
						graphics.drawLine(6);

					}
					computerPlayersTurn = false;
					playersTurn2 = false;
					running = false;
					if (a == 1) {
						win2Squares = true;
					} else {
						win2Circles = true;
					}
					graphics.clearTurnNotification();
				}

			}

			if (point[0] == a && point[4] == a && point[8] == a) {
				graphics.drawLine(7);

				computerPlayersTurn = false;
				playersTurn2 = false;
				running = false;
				if (a == 1) {
					win2Squares = true;
				} else {
					win2Circles = true;
				}
				graphics.clearTurnNotification();

			}
			if (point[2] == a && point[4] == a && point[6] == a) {
				graphics.drawLine(8);

				computerPlayersTurn = false;
				playersTurn2 = false;
				running = false;
				if (a == 1) {
					win2Squares = true;
				} else {
					win2Circles = true;
				}
				graphics.clearTurnNotification();
			}
		}

		int test = 0;

		for (int i = 0; i < 9; i++) {
			if (point[i] != 0) {
				test++;
			}
		}

		// Tie Game Screen
		if (test == 9 && !win2Circles && !win2Squares) {
			int sleep = 0;
			boolean tieGame = true;
			graphics.clearTurnNotification();
			while (tieGame) {
				try {
					Thread.sleep(200);
				} catch (Exception e) {

				}
				sleep++;
				if (sleep > 10) {

					graphics.drawTieScreen();
					addResetButton();

				}
				if (sleep > 11) {
					win2Circles = false;
					win2Squares = false;
					tieGame = false;
				}
			}
			computerPlayersTurn = false;
			playersTurn2 = false;
			running = false;
		}
		test = 0;
		// Loose screen
		if ((player == true && win2Circles) || (player == false && win2Squares)) {
			int sleep = 0;
			while (win2Circles || win2Squares) {
				try {
					Thread.sleep(200);
				} catch (Exception e) {

				}
				sleep++;
				if (sleep > 10) {

					graphics.drawLooseScreen();
					addResetButton();

				}
				if (sleep > 11) {
					win2Circles = false;
					win2Squares = false;
				}
			}
		}

		// Win Screen
		if (win2Squares || win2Circles) {
			int sleep = 0;
			while (win2Squares || win2Circles) {
				try {
					Thread.sleep(200);
				} catch (Exception e) {

				}
				sleep++;
				if (sleep > 10) {

					graphics.clearTurnNotification();
					graphics.drawWinScreen();
					addResetButton();
					win2 = false;
				}
				if (sleep > 11) {
					win2Squares = false;
					win2Circles = false;
				}
			}
		}
	}

	//This is the key bindings for the game
	
	public void keyBindings(boolean test) {

		String[] keyStroke = { "Q", "W", "E", "A", "S", "D", "Z", "X", "C", "HOME", "UP", "PAGE_UP", "LEFT", "CLEAR",
				"RIGHT", "END", "DOWN", "PAGE_DOWN", "NUMPAD7", "NUMPAD8", "NUMPAD9", "NUMPAD4", "NUMPAD5", "NUMPAD6", "NUMPAD1", "NUMPAD2", "NUMPAD3"};
		int[] keyCode = { 81, 87, 69, 65, 83, 68, 90, 88, 67, 36, 38, 33, 37, 12, 39, 35, 40, 34, 103, 104, 105, 100, 101, 102, 97, 98, 99};
		if (test) {
			for (int i = 0; i < keyStroke.length; i++) {
				graphics.getInputMap(window).put(KeyStroke.getKeyStroke(keyStroke[i]), keyStroke[i]);
				graphics.getActionMap().put(keyStroke[i], new actions(keyCode[i]));
			}
		}
		if (!test) {
			for (int i = 0; i < keyStroke.length; i++) {
				graphics.getInputMap(window).put(KeyStroke.getKeyStroke(keyStroke[i]), "none");
			}
		}
	}

	//This adds a reset button when the game is tied, lost, or one.
	
	public void addResetButton() {
		reset.addActionListener(this);
		exit.addActionListener(this);
		graphics.setLayout(box4);
		resetPanel.setBorder(new EmptyBorder(450, 0, -325, 0));
		resetPanel.add(reset);
		exitPanel.add(exit);
		resetPanel.setOpaque(false);
		exitPanel.setOpaque(false);
		graphics.add(resetPanel);
		graphics.add(exitPanel);
		setVisible(true);
		running = false;
	}

	//This is for the buttons on all components, it checks to see if the button is pressed.
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		synchronized (this) {
			String command = arg0.getActionCommand();
			if (command.equals("Square Color")) {
				new ColorSelecterSquare("Square Color Selector");
			} else if (command.equals("Circle Color")) {
				new ColorSelectorCircle();
			} else if (command.equals("Play")) {
				remove(title);
				add(graphics);
				setVisible(true);
				graphics.setUpBoard(6);
				this.notifyAll();

			} else if (command.equals("Return To Title Screen")) {
				graphics.remove(resetPanel);
				graphics.remove(exitPanel);
				remove(graphics);
				add(title);
				title.drawTitle();
				playersTurn2 = true;
				computerPlayersTurn = true;
				win2 = true;
				this.notifyAll();

			} else if (command.equalsIgnoreCase("Exit Game")) {
				System.exit(0);
			}
		}
	}

	//This method moves the game along.
	
	public void notifyEverything() {
		synchronized (this) {
			this.notifyAll();
		}
	}

	//This method is for the check boxes on the main menu.
	
	public void itemStateChanged(ItemEvent event) {
		Object item = event.getItem();
		int status = event.getStateChange();
		if (item == squareCheck && status == ItemEvent.SELECTED) {
			circleCheck.setSelected(false);
			player = true;
		} else if (item == circleCheck && status == ItemEvent.SELECTED) {
			squareCheck.setSelected(false);
			player = false;
		} else if (item == squareCheck && status == ItemEvent.DESELECTED) {
			circleCheck.setSelected(true);
		} else if (item == circleCheck && status == ItemEvent.DESELECTED) {
			squareCheck.setSelected(true);
		}

		if (item == difficultyEasy && status == ItemEvent.SELECTED) {
			difficultyNumber = 1;
			status2 = 1;
			difficultyNormal.setSelected(false);
			difficultyHard.setSelected(false);
		} else if (item == difficultyNormal && status == ItemEvent.SELECTED) {
			status2 = 2;
			difficultyNumber = 2;
			difficultyEasy.setSelected(false);
			difficultyHard.setSelected(false);
		} else if (item == difficultyHard && status == ItemEvent.SELECTED) {
			difficultyNumber = 3;
			status2 = 3;
			difficultyEasy.setSelected(false);
			difficultyNormal.setSelected(false);
		}
		if (item == difficultyEasy && status == ItemEvent.DESELECTED && status2 == 1) {
			difficultyEasy.setSelected(true);
		} else if (item == difficultyNormal && status == ItemEvent.DESELECTED && status2 == 2) {
			difficultyNormal.setSelected(true);
		} else if (item == difficultyHard && status == ItemEvent.DESELECTED && status2 == 3) {
			difficultyHard.setSelected(true);
		}

	}

	//Activates the key presses.
	
	public class actions extends AbstractAction {

		int pressed3;

		public actions(int pressed) {
			pressed3 = pressed;

		}

		public void actionPerformed(ActionEvent arg0) {
			synchronized (this) {
				pressed2 = pressed3;
				//System.out.println("Hello");
				notifyEverything();
			}
		}

	}

}
