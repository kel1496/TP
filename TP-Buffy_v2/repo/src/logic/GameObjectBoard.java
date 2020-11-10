package logic;

import logic.lists.*;

import java.util.Random;

import logic.gameObjects.*;

public class GameObjectBoard {

	private SlayerList Slist;
	private VampireList Vlist;
	
	public GameObjectBoard (String[] args){
		
		this.Slist = new SlayerList(this);
		this.Vlist = new VampireList(this);
				
	}
	
	
}
