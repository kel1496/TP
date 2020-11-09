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
	private int cicloEntrada;
	
	
	public Slayer(int pos, int x, int y, Game game){
		
		this.pos = pos;
		this.game = game;
		this.HP = 3;
		this.x = x;
		this.y = y;
		this.cicloEntrada = game.GetCiclo();
		
	}
	
	public void Update(){
		
		int Vshot;
		int aux =0;
		Boolean f = false;
		Boolean dispara = false;
		
		if (game.GetCiclo() != this.cicloEntrada) {

			for (int i = 0; i < game.GetVcount(); i++) {
				
				if (this.x == game.GetVx(i)) {
					Vshot = game.GetVy(i)
				
					if(game.GetVy(i) < Vshot)
						Vshot = game.GetVy(i)
					}
			}
			while (aux < game.GetVcount() && !f){
				
				if ((game.GetVx(aux) == this.x) && (game.GetVy(aux) == Vshot)){
					
					game.DecreaseVHP(aux, DMG);
					f = true;
					
				}
				
				aux++;
			}
				
		}
		
	}
	public int GetCost (){
		
		return COSTE;
		
	}
	
	public int GetSx (){

		return this.x;
		
	}
	
	public int GetSy (){
		
		return this.y;
		
	}
	
	public void ReducirHP (int dmg){
		
		this.HP -= dmg;
		
		if (this.HP == 0){
			
			game.DelS(this.pos);
			
		}
		
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
		
}
	

