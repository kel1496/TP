package control;

import java.util.Scanner;

import logic.Game;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner in;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.in = scanner;
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
		// TODO fill your code
    	String comando;
		int x , y;
		boolean empty, pass = false;
		int pos;
		
		comando = this.in.nextLine();
		comando = this.in.trim();
		comando = this.in.toLowerCase();
		
		while ((com != "exit") && (game.GetActive())){
		
		}
		}
    }

}

