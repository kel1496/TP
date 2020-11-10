package Main;
import java.util.Scanner;

import control.Controller;

import logic.Game;

public class BuffyVampireSlayer {
	
	
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		
			Game game = new Game(args);
			Controller controller = new Controller(game, in);
			controller.run();
		
	}
}