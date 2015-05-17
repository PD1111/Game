package PeterCai.level;

import java.util.Random;

import PeterCai.Game;

public class RandomLevel extends Level{
	
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	protected void generateLevel() {
		for (int x = 0; x < height; x ++) {
			int a = random.nextInt(7);
			int b = a + 1;
			int c = b + 1;
			int m = a - 1;
			int n = c + 1;
			for (int y = 0; y < width; y++) {
				//System.out.println("interval : " + Game.interval);
				if (x % Game.interval == 0 && x > 0) {
					if (y == a || y == b || y == c) {
						tiles[x + y * width] = 0;
					} else if (y == m){
						tiles[x + y * width] = 2;
					} else if (y == n) {
						tiles[x + y * width] = -2;
					} else if (y >= 10) {
						tiles[x + y * width] = 3;
					} else {
						tiles[x + y * width] = 1;
					}
				} else if (y >= 10) {
					tiles[x + y * width] = 3;
				} else {
					tiles[x + y * width] = 0;
				}
			}
		}
	}

}
