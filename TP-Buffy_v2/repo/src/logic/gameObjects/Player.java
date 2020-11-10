package logic.gameObjects;

import java.util.Random;

import logic.Game;

public class Player {

	private Random rand;
	private int coins;

	
	public Vampire(int pos, int x, int y, Game game){
			
			this.game = game;
			this.HP = 5;
			this.dmg = 1;
			this.velocidad = 2;
			this.pos = pos;
			this.cicloEntrada = game.GetCiclo();
			this.x = 7;
			this.y = y;	
	}
	
}
