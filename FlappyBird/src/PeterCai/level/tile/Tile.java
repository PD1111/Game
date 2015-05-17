package PeterCai.level.tile;

import PeterCai.graphics.Screen;
import PeterCai.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile wall = new WallTile(Sprite.wall);
	public static Tile wallup = new WallTile(Sprite.wallup);
	public static Tile walldown = new WallTile(Sprite.walldown);
	public static Tile VoidTile = new VoidTile(Sprite.voidSprite);
	public static Tile soil = new WallTile(Sprite.soil);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
}
