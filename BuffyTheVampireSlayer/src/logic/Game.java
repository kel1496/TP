package logic;

import java.util.*; 
import logic.lists.*;
import view.GamePrinter;
import logic.GameObjectBoard;
import logic.Level;
import logic.gameObjects.*;


public class Game {
		
	private int remVampires;
	private int gameOver;
	public final int Coor_X = 9;
	public final int Coor_Y = 5;
	
	private int coins;
	private int numCycles;
	private long seed;
	
	private boolean Active;
	private Random rand;
	private GameObjectBoard GOB;

	private GamePrinter GPrinter;
	private Level level;
	
	public Game (String[] args){
		
		if (args.length > 1) {
			if (Long.parseLong(args[1]) != 0)
					this.seed = Long.parseLong(args[1]);
			else
				this.seed = System.currentTimeMillis();
		}
		
		this.rand = new Random(this.seed);
		this.numCycles = 0;
		this.Active = true;
		this.level = Level.parse(args[0]);
				
	}
	
	public void update (){

		this.Slist.Update();
		this.Vlist.Update();

		
		if (this.GetCurrentCicle() != 0)

		
		if (this.GetCurrentCicle() == 0)
			System.out.println("Seed : " + this.seed);
		
		System.out.println("Current cicle : " + this.GetCiclo());
		System.out.println("Coins : " + this.GetCoins());
		System.out.println("Vampires remaining : " + this.VampiressRemaining());
		System.out.println("###########################");
		
		System.out.println(this.GPrinter = new GamePrinter (this, this.level.GetX(), this.level.GetY()));
		
		System.out.print("Command > ");
		
		this.endGame();
		this.numCycles++;

	}
}
