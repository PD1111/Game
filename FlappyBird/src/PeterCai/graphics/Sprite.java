package PeterCai.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite wall = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite wallup = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite walldown = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	public static Sprite player = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite soil = new Sprite(16, 4, 0, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		steColour(colour);
	}

	private void steColour(int colour) {
		for (int i =0; i < SIZE*SIZE; i ++) {
			pixels[i] = colour;
		}
		
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x <SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}	
	}
}
