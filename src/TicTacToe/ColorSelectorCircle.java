package TicTacToe;

@SuppressWarnings("serial")
public class ColorSelectorCircle extends ColorSelecterSquare {

	//This is just an extension of the color selector to work with seleting circles.
	
	public ColorSelectorCircle(){
		super("Circle Color Selector");
		ColorSelecterSquare.colorOfCircleOrSquare = false;
	}
	
	public static void main(String[] args){
		new ColorSelectorCircle();
	}
}
