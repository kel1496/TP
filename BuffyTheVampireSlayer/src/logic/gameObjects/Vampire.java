package logic.gameObjects;

import logic.Game;

public class Vampire {

	
	private Game game;
	private int HP;
	private int velocidad;
	private int dmg;
	private int pos;
	private int cicloEntrada;
	private int x;
	private int y;
	
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
	
	public void Update(){
			
		boolean movimiento = true;
		int slayerCount, slayerY, slayerX;
	
		
		slayerCount = game.GetSCount();
		
		for (int i = 0; i < slayerCount; i++){
			
			slayerX = game.GetSx(i);
			slayerY = game.GetSy(i);
			
			if ((this.y == slayerY) && ((this.x - 1) == slayerX)){
				
				game.ReducirSHP(i, this.dmg);
				movimiento = false;
				
			}
			
		}
		
		
		if (movimiento){
			if(game.GetCiclo() - this.cicloEntrada) % this.velocidad ) == 0)
			
			this.x --;
			
		}
			
		
	}
		
	
	public int GetVy (){
	
		return this.y;
		
	}
	
	public int GetVx (){

		return this.x;
		
	}
	
	
	public void ReducirHP (int dmg){
		
		this.HP -= dmg;
		
		if (this.HP == 0){
			
			game.DelV(this.pos);
			
		}
				
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
	
}
	
	
