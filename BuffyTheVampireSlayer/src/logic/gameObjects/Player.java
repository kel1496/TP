package logic.gameObjects;

import java.util.Random;


public class Player {

	private Random rand;
	private int coins;

	
	public Player(){
			
		this.coins = 50;
		this.rand = new Random(System.currentTimeMillis());
	}
	
	public int GetCoins(){
		return this.coins;
	}
	
	public void SetCoins(int x){
		this.coins = x;
	}
	
	public Random GetRandom() {
		return this.rand;
	}
}
