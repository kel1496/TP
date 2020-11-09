package logic.gameObjects;

import logic.Game;

public class Vampire {

	
	private Game game;
	private int HP;
	private int velocidad;
	private int dmg;
	private int cicloEntrada;
	private int x;
	private int y;
	private int pos;
	
	public Vampire(int pos, int x, int y, Game game){
			
			this.game = game;
			this.HP = 5;
			this.dmg = 1;
			this.velocidad = 2;
			this.cicloEntrada = 0;
			this.x = 6;
			this.y = y;	
	}
	
	public void Update(){
			
		cicloEntrada += 1;

		if (game.vacio(x, y - 1) && cicloEntrada % 2 == 0) {
			this.y = this.y - velocidad;
			
		} 
		else if (game.vacio(x, y - 1) && cicloEntrada % 2 != 0) {
			
			
		} else {
			
			if (!game.vampiroCerca(x,y)) {
				game.attackToSlayer(x, y - 1, dmg);
			}
		}	
		
	}
		
	
	public int GetVy (){
	
		return this.y;
		
	}
	
	public int GetVx (){

		return this.x;
		
	}
	

	public void CambiarPos(int i){
		
		this.pos = i;
		
	}
	
	public String toString (){
		
		String a;
		a = "V [";
		a += this.HP;
		a += "]";
		
		return a;
		
	}

	public void decHP(int dmg2) {
		// TODO Auto-generated method stub
		HP -= dmg;
	}
	
}
	
	
