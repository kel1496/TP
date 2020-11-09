package Main;
import java.util.Random;

import control.Controller;

import logic.Game;

public class BuffyVampireSlayer {
	
	public static void main(String[] args) { 
		if (args.length == 2) {
			Game game = new Game(args[0].toLowerCase(), Integer.parseInt(args[1])); 
			//toLoverCase() convierte todos los caracteres de la cadena a minúsculas
			//parseInt() convierte una cadena de texto en un número entero
			Controller controller = new Controller(game);							
			controller.run();
		}
		else if (args.length == 1) { //solo un argumento significa que no hay semilla
			Random randomize = new Random(); //como no hay semilla, usamos Random()
			Game game = new Game(args[0].toLowerCase(), randomize.nextInt());
			Controller controller = new Controller(game);
			controller.run();
		}
	}
}
