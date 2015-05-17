package PeterCai;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import PeterCai.entity.Player;
import PeterCai.graphics.Screen;
import PeterCai.input.KeyBoard;
import PeterCai.input.Mouse;
import PeterCai.level.Level;
import PeterCai.level.RandomLevel;


public class Game extends Canvas implements Runnable {
	
	private static int width = 160;
	private static int height = 192;
	private static int scale = 3;
	public static String title = "FlappyBird";
	public static int interval = 6;
	public static int speed = 3;
	public static int map_speed = 1;
	public static boolean hidden = false;
	
	public Thread thread;
	public JFrame frame;
	public boolean running = false;
	private KeyBoard key;
	private Mouse mouse;
	public static Level level;
	private Player player;
	private BufferedImage background = null;
	private Menu menu;
	private Difficulty difficulty;
	private Mode mode;
	
	public Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height , BufferedImage.TYPE_INT_RGB);
	private int [] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public static enum STATE{
		MENU,
		DIFFICULTY,
		GAME,
		MODE
	};
	
	public static STATE State = STATE.MENU;
	
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		
		frame = new JFrame();
		screen = new Screen(width , height);
		key = new KeyBoard();
		mouse = new Mouse();
		level = new RandomLevel(640, 640);
		player = new Player(0, 88, key);
		menu = new Menu();
		difficulty = new Difficulty();
		mode = new Mode();
		player.init(level);
		try {
			background = ImageIO.read(getClass().getResource("/kotori.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(key);
		addMouseListener(mouse);
		
	}
	
	public static int getWindowWidth() {
		return width * scale;
	}
	
	public static int getWindoHeight() {
		return height * scale;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
    public void run() {
    	long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
    
    //int x = 0;
    
    public void update() {
    	if (State == STATE.GAME) {
    		key.update();
    		player.update();
    	}
    	//if (key.up) y--;
    	//if (key.down) y++;
    	//if (key.left) x--;
    	//if (key.right) x++;
    	//x++;
    }
    
    
    public void render() {
    	BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if (State != STATE.GAME) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		}
		if (State == STATE.GAME) {
			screen.clear(); 
			level.render(player.x, 0, screen);
			if (!hidden) {
				player.render(screen);
			} else {
				if ((player.x % 32) < 16) {
					player.render(screen);
				}
			}
			
			for (int i = 0; i < width * height; i++) {
				pixels[i] = screen.pixels[i];		
			}
			g.setColor(Color.BLACK);
			g.setFont(new Font("Verdana", 0, 50));
			g.drawString("SCORE : " + (player.x - 16) / (interval * 16), 180, 50) ;
			//System.out.println("position : " + player.x);
		}  else if (State == STATE.MENU) {
			menu.render(g);
		}  else if (State == STATE.DIFFICULTY) {
			difficulty.render(g);
		}  else if (State == STATE.MODE) {
			mode.render(g);
		}
		//System.out.println("interval : " + interval);
		
		g.dispose();
		bs.show();
    }
	

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		//game.start();

	}


}
