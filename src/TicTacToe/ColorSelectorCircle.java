package TicTacToe;

@SuppressWarnings("serial")
public class ColorSelectorCircle extends ColorSelecterSquare {

	public ColorSelectorCircle(){
		super("Circle Color Selector");
		ColorSelecterSquare.colorOfCircleOrSquare = false;
	}
	
	public static void main(String[] args){
		new ColorSelectorCircle();
	}
}
