package logic.gameObjects;

import logic.Game;

public class Slayer {
	public static final int COSTE = 50;
	public static final int DMG = 1;
	private int HP;
	private Game game;
	private int x;
	private int y;
	private int pos;
	//private int cicloEntrada;
	
	
	public Slayer(int x, int y, Game game){
		
		this.game = game;
		this.HP = 3;
		this.x = x;
		this.y = y;
		//this.cicloEntrada = game.GetCiclo();
		
	}
	
	public void Update() {
		
		game.attackToVampire(x, DMG);
		
	}
	public int GetCost (){
		
		return COSTE;
	}
	
	public int GetSx (){

		return this.x;
		
	}
	
	public int GetSy () {
		
		return this.y;
		
	}
	
	
	public void CambiarPos(int i){
		
		this.pos = i;
		
	}

	public String toString (){
		
		String a;
		a = "S [";
		a += this.HP;
		a += "]";
		
		return a;
		
	}

	public void DecreaseHP(int dmg) {
		HP -= dmg;
		
	}
		
}
	

