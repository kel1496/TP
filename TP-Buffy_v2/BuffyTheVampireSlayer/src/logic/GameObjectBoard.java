package logic;

import logic.lists.*;


public class GameObjectBoard {

	private SlayerList Slist;
	private VampireList Vlist;
	
	public GameObjectBoard (Game game){
		
		this.Slist = new SlayerList(game);
		this.Vlist = new VampireList(game);
				
	}
	
	public void addSlayer(int x, int y) {
		Slist.addSlayer(x, y);
	}

	public void addVampire(int randomArbitrary, int randomArbitrary2) {
		Vlist.addVampire(randomArbitrary, randomArbitrary2);
		
	}
	
	public void update() {
		Slist.Update();
		Vlist.Update();
	}
	
	public int GetSlayerCount() {
		return Slist.GetScount();
	}
	
	public int GetSy (int i){

		return Slist.GetSy(i);
		
	}
	
	public int GetSx (int i){

		return Slist.GetSx(i);
		
	}
	
	public int GetVampireCount() {
		return Vlist.GetVcount();
	}
	
	public int GetVy (int i){

		return Vlist.GetVy(i);
		
	}
	
	public int GetVx (int i){

		return Vlist.GetVx(i);
		
	}
	
	public boolean vampiroEncontrado(int x, int y) {
		
		return Vlist.vampiroEncontrado(x, y);
	}


	public boolean slayerEncontrado(int x, int y) {
		
		return Slist.slayerEncontrado(x, y);
	}

	public int posicionSlayer(int x, int y) {
		
		return Slist.pos(x, y);  
	}
	
	public int posicionVampiro(int x, int y) {
		
		return Vlist.pos(x, y);
	}

	public void decVidaSlayer(int posicionSlayer, int dmg) {
		Slist.decHP(posicionSlayer, dmg);
	}

	public void decVidaVamp(int posicionVampiro, int dmg) {
		
		Vlist.decHP(posicionVampiro, dmg);		
	}
	
	public boolean vacio(int x, int y) {
		boolean empty = false;
		if (!slayerEncontrado(x, y) && !vampiroEncontrado(x, y)) {
			empty = true;
		}
		return empty;
	}
	
}
