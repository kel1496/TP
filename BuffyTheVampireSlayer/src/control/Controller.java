package control;

import java.util.Scanner;

import logic.Game;
import logic.Level;

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
		boolean vacio;
		boolean pass;
		int pos, aux;
		
		comando = this.in.nextLine();
		comando = comando.trim();
		comando = comando.toLowerCase();
		
		while ((comando != "exit") && (game.Active())){
			comando = comando.toLowerCase();
			String[] argumentos = comando.split(" ");
			vacio = true;
			pass = false;
			
			switch (argumentos[0]){
				case "add": case "a":
					
					if(argumentos.length < 3 || argumentos.length > 3) {
						System.out.print(invalidCommandMsg);
						System.out.print(prompt);
						break;
					}
					
					x = Integer.valueOf(argumentos[1]);
					y = Integer.valueOf(argumentos[2]);
					
					if ((x >= 0) && (x <= this.game.GetLevelDimX()) && (y >= 0) && (y <= this.game.GetLevelDimY())) {
						
						pos = 0;
						if (vacio){
						
							pos = 0;
							aux = 0;
							while(pos < game.GetScount() && vacio){
								
								if ((game.GetSx(pos) == x) && (game.GetSy(pos) == y))
									vacio = false;
								
								pos++;
							}
							while(aux < game.GetVcount() && vacio){
								
								if ((game.GetVx(aux) == x) && (game.GetVy(aux) == y))
									vacio = false;
								
								aux++;
							}
							if (game.GetCoins() >= game.GetSCost()){
								
								game.AddSlayer(x, y);
								game.SetCoins(game.GetCoins() - game.GetSCost());
								pass = true;
								
							}
							else {
								
								System.out.println("[ERROR]: Not enough Coins\n");
								System.out.print(prompt);
								pass = false;
								
							}
							
							
						}						
						else {
							
							System.out.println("[ERROR]: Seleccione una casilla válida.\n");
							System.out.print("Command > ");
							pass = false;
												
						}
						
					}				
					else {
									
						System.out.println(invalidPositionMsg);
						System.out.println(prompt);
						
						pass = false;
						
					}
					
					
					
					break;
				case "reset": case "r":
					
					this.game = new Game(new String[]{game.GetDif(), String.valueOf(game.GetSeed())});	
					pass = false;
					
					break;
					
				case "exit": case "e":
					
					game.exitGame();
					
					break;
					
				case "help": case "h":	
					System.out.println(helpMsg);
					
					break;
					
				case "":
					
					pass = true;
					
					break;
					
				default:
					
					System.out.println(unknownCommandMsg);
					System.out.print(prompt);
					pass = false;
					
					break;
			}	
			
			if(pass) {				
				this.game.update();
			}
			comando = in.nextLine();
		}
	}
}


