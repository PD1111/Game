package PeterCai.entity;

import PeterCai.Game;
import PeterCai.graphics.Sprite;
import PeterCai.level.Level;
import PeterCai.level.RandomLevel;

public class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean movinf = false;
	
	public void move (int xa, int ya) {
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		} else {
			x = 0;
			y = 88;
			if (Game.interval != Game.interval) {
			Game.interval = 7;
			Game.level = new RandomLevel(640, 640);
			}
			Game.speed = 3;
			Game.map_speed = 1;
			Game.hidden = false;
			Game.State = Game.STATE.MENU;
		}
		
	}
	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 10 + 4) / 16 ;
			int yt = ((y + ya) + c / 2 * 10 + 3) / 16;
			//System.out.println("xt : " + xt + " yt : " + yt);
			//System.out.println("yt : " + yt);
			if (level.getTile(xt, yt).solid() || y < 0 || y >= 176) solid = true;
		}
		return solid;
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	
}
