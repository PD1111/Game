package PeterCai.level;

import PeterCai.graphics.Screen;
import PeterCai.level.tile.Tile;

public class Level {

	protected int width;
	protected int height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width =width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}

	private void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}
	
	public void update() {
		
	}
	
	public void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		//System.out.println("tiles : " + (x + y *width) +" " + tiles[x + y * width] + " x : " + x + " y : " + y);
		//System.out.println(tiles[7 + 640 * 2]);
		if (tiles[x + y * width] == 1) return Tile.wall;
		if (tiles[x + y * width] == 3) return Tile.soil;
		if (tiles[x + y * width] == 2) return Tile.walldown;
		if (tiles[x + y * width] == -2) return Tile.wallup;
		return Tile.VoidTile;
	}
}
