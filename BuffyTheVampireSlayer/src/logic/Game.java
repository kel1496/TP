package logic;

import view.GamePrinter;
import logic.GameObjectBoard;
import logic.Level;
import logic.gameObjects.*;
import java.util.Random;


public class Game {
		
	private Player player;
	private int remVampires;
	private int gameOver;
	public final int Coor_X = 7;
	public final int Coor_Y = 4;
	
	
	private int coins;
	private int numCycles;
	private int seed;
	
	private boolean Active;
	private Random rand;
	private GameObjectBoard GOB;

	private GamePrinter GPrinter;
	private Level level;
	private Slayer slayer;
	private Vampire vampire;

	
	public Game (Level level, int seed) {
		
		//this sirve para pasar por parametros mismo nombre
		this.rand = new Random(this.seed);
		this.numCycles = 0;
		this.Active = true;
		this.GOB = new GameObjectBoard(this);
		player = new Player();
		//this.level = Level.parse(level);
	}
	
	public Game(String level2, int seed2) {
		// TODO Auto-generated constructor stub
	}

	public int getRandomArbitrary(int min, int max) {
	    return (int) (Math.random() * (max - min) + min);
	}
	
	public void update () {

		//this.Slist.Update();
		//this.Vlist.Update();
		GOB.update();

		
		//if (this.GetCurrentCicle() != 0)

		
		if (numCycles == 0) {
			System.out.println("Seed : " + this.seed);
			
			if (Player.generateVampire(this)) {
				GOB.addVampire(getRandomArbitrary(0, Coor_X),getRandomArbitrary(0, Coor_Y)); 
			}
		}
		
		System.out.println("Current cicle : " + numCycles);
		System.out.println("Coins : " + coins);
		System.out.println("Vampires remaining : " + remVampires);
		System.out.println("###########################");
		
		System.out.println(this.GPrinter = new GamePrinter (this, 4, 8));
		
		System.out.print("Command > ");
		
		endGame();
		this.numCycles++;

	}
	
	public void addSlayer(int x, int y) {
		GOB.addSlayer(x, y); 
	}
	
	public Level getLevel() {
		return level;
	}

	public Random getRandom() { //cambio
		return rand;
	}
	
	public boolean endGame() {
		
		return Active;
		// UPDATE
	}
	
	public int GetLevelDimX() {
		
		return level.GetX();
	}
	
	public int GetLevelDimY() {
		
		return level.GetY();
	}
	
	public int GetScount() {
		
		return GOB.GetSlayerCount();
	}
	
	public int GetVcount() {
		
		return level.GetNVampires();
	}
	
	public void exitGame() {
		Active = false;
	}
	
	public int GetSx() {
	
		return slayer.GetSx();
	}
	
	public int GetSy() {
		return slayer.GetSy();
	}
	
	public int GetVx() {
		return vampire.GetVx(); 
	}
	
	public int GetVy() {
		return vampire.GetVy(); 
	}
	
	public int GetCoins() {
		return player.GetCoins();
	}
	
	public int GetSCost() {
		return slayer.GetCost();
	}
	
	public int getSeed() {
		return seed;
	}

	public void attackToVampire(int x, int dmg) {
		
		int i = 0;
		
		while (i < Coor_Y && !GOB.vampiroEncontrado(x, i)) {
			i++;
		}
		
		if (GOB.vampiroEncontrado(x, i)) {
		
			GOB.decVidaVamp(GOB.posicionVampiro(x, i), dmg);
		}
		
	}
	
	public void attackToSlayer(int x, int y, int dmg) {
		
		if (GOB.slayerEncontrado(x, y)) {
			GOB.decVidaSlayer(GOB.posicionSlayer(x, y), dmg);
		}
	}

	public boolean vacio(int x, int y) {
		
		return GOB.vacio(x, y);
	}

	public boolean vampiroCerca(int x, int y) {
		
		return GOB.vampiroEncontrado(x, y - 1);
	}

	public String StoString(int i) {
		return null;
		// TODO Auto-generated method stub
		//return GOB.StoString(i);
	}

	public String VtoString(int i) {
		return null;
		// TODO Auto-generated method stub
		//return GOB.VtoString(i);
	}

	public void SetCoins(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
