package PeterCai.entity;

import PeterCai.Game;
import PeterCai.graphics.Screen;
import PeterCai.graphics.Sprite;
import PeterCai.input.KeyBoard;

public class Player extends Entity{
	
	private KeyBoard input;
	
	//public Player(KeyBoard input) {
		//this.input = input;
	//}
	
	public Player(int x, int y, KeyBoard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya -= Game.speed;;
    	//if (input.down) ya++;
    	//if (input.left) xa--;
    	//if (input.right) xa++;
    	xa += Game.map_speed;
    	ya += 2;
    	move (xa, ya); 
		
	}
	
	public void render(Screen screen) {
		screen.renderPlayer(x, y, Sprite.player);
	}

}
