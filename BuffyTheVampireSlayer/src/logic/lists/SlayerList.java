package logic.lists;

import logic.Game;
import logic.gameObjects.Slayer;;

public class SlayerList {

	private Game game;
	private int numSlayer;
	private Slayer[] lista;
	
	// Methods

	public SlayerList(Game game){
		
		this.game = game;
		this.numSlayer = 0;
		this.lista = new Slayer[30];
		
	}

	
	public void Update (){
		
		for (int i = 0; i < this.numSlayer; i ++){
			
			lista[i].Update();
			
		}
		
	}
	
	public void AddPeashooter(int x, int y){
		
		this.lista[numSlayer] = new numSlayer(x, y, game, this.numSlayer);
		this.numSlayer ++;
		
	}

	public int GetPSx (int i){

		return this.list[i].GetPSx();
		
	}
	
	public int GetPSy (int i){

		return this.lista[i].GetPSy();
		
	}
	
	public int GetPScount (){

		return this.numSlayer;
		
	}
	
	public void DecreasePSHP(int i, int dmg){
		
		this.lista[i].DecreaseHP (dmg);
		
	}
	
	public String PStoString(int i) {
		
		return this.lista[i].toString();
		
	}
	
	public void DeleteS (int i){
		
		this.numSlayer--;
		
		for (int j = i; j < this.numSlayer; j++){
			
			this.lista[j].CambiarPos(i - 1);
			
		}
		
		for (int j = i; j < this.numSlayer; j++){
			
			this.lista[j] = this.lista[j + 1];
			
		}
		
	}
	
}
