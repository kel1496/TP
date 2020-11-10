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
	public final int Coor_X = 8;
	public final int Coor_Y = 4;
	private int numCycles;
	private long seed;
	
	private boolean Active;
	private Random rand;
	private GameObjectBoard GOB;

	private GamePrinter GPrinter;
	private Level level;
	private Slayer slayer;
	private Vampire vampire;

	
	public Game (String[] args) {
		
		//this sirve para pasar por parametros mismo nombre
		if (args.length > 1) {
			if (Long.parseLong(args[1]) != 0)
					this.seed = Long.parseLong(args[1]);
			else
				this.seed = System.currentTimeMillis();
		}
		else
			this.seed = System.currentTimeMillis();
		
		this.rand = new Random(this.seed);
		this.numCycles = 0;
		this.Active = true;
		this.GOB = new GameObjectBoard(this);
		player = new Player();
		this.level = Level.parse(args[0]);
		this.remVampires = this.level.GetNVampires();
	}

	public int getRandomArbitrary(int min, int max) {
	    return (int) (Math.random() * (max - min) + min);
	}
	
	public void update () {

		//this.Slist.Update();
		//this.Vlist.Update();
		GOB.update();

		
		//if (this.GetCurrentCicle() != 0)

		
		if (numCycles != 0) {
			System.out.println("Seed : " + this.seed);
			
			if (Player.generateVampire(this)) {
				GOB.addVampire(getRandomArbitrary(1, Coor_X),getRandomArbitrary(1, Coor_Y)); 
			}
		}
		
		System.out.println("Current cicle : " + numCycles);
		System.out.println("Coins : " + player.GetCoins());
		System.out.println("Vampires remaining : " + remVampires);
		System.out.println("Vampires on board" + this.GetVcount());
		
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
	
	public String GetName() {
		return level.GetName();
	}

	public Random getRandom() { //cambio
		return this.rand;
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
		
		return GOB.GetVampireCount();
	}
	
	public void exitGame() {
		Active = false;
	}
	
	public int GetSx(int i) {
	
		return GOB.GetSx(i);
	}
	
	public int GetSy(int i) {
		return GOB.GetSy(i);
	}
	
	public int GetVx(int i) {
		
		return GOB.GetVx(i);
	}
	
	public int GetVy(int i) {
		return GOB.GetVy(i);
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
	
	public void SetCoins(int a) {
		player.SetCoins(a);
	}
	
	public int GetSCost() {
		return slayer.COSTE;
	}
	
	public long GetSeed() {
		return this.seed;
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

	
}
