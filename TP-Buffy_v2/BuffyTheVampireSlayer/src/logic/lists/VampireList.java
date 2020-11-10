package logic.lists;

import logic.Game;
import logic.gameObjects.Vampire;

public class VampireList {

	
	private Game game;
	private int numVampire;
	private Vampire[] lista;
	int count = 0;
	
	// Methods
	
	
	public VampireList(Game game) {
		
		this.game = game;
		this.numVampire = 0;
		this.lista = new Vampire[30];
		
	}
	
	
	public void Update() {
		
		for (int i = 0; i < this.numVampire; i ++) {
			lista[i].Update();
		}
		
	}
	
	
	public void addVampire(int x, int y) {
		
		this.lista[numVampire] = new Vampire(numVampire, x, y, game);
		this.numVampire ++;
		
	}
	
	
	public int GetVx (int i) {

		return this.lista[i].GetVx();
		
	}
	
	public int GetVy (int i) {
		
		return this.lista[i].GetVy();
		
	}
		
	public int GetVcount () {
		
		return this.numVampire;
		
	}
	
	public void DeleteV (int i) {
		
		this.numVampire--;	
				
		for (int j = i; j < this.numVampire; j++) {
			
			this.lista[j] = this.lista[j + 1];
			
		}
		
		for (int j = i; j < this.numVampire; j++) {
			
			this.lista[j].CambiarPos(j);
			
		}
		
	}
	
	public String VtoString (int i) {
		
		return this.lista[i].toString();
		
	}
	
	public int pos(int x, int y) {
		// TODO Auto-generated method stub
		int i = 0;
		
		boolean encontrado = false;
		
		while (i < count && !encontrado) {
			if ((lista[i].GetVx() == x) && (lista[i].GetVy() == y)) {
				encontrado = true;
			} else {
				i++;
			}
		}
		
		return i;
	}


	public void decHP(int posicionVampiro, int dmg) {
		// TODO Auto-generated method stub
		lista[posicionVampiro].decHP(dmg);
	}


	public boolean vampiroEncontrado(int x, int y) {
		
		int i = 0;
		boolean found = false;
		while (i < count && !found) {
			if ((lista[i].GetVx() == x) && (lista[i].GetVy() == y)) {
				found = true;
			} else {
				i++;
			}
		}
		return found;
	}
	
}

