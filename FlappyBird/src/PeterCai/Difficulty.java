package PeterCai;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Difficulty {
	public Rectangle playButton = new Rectangle(170, 70, 140, 80);
	public Rectangle helpButton = new Rectangle(170, 220, 140, 80);
	public Rectangle quitButton = new Rectangle(170, 370, 140, 80);
	
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 70);
		g.setFont(fnt0);
		g.setColor(Color.BLACK);
		g.drawString("DIFFICULTY", 35, 60);
		
		Font fnt1 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		g.drawString("EASY", playButton.x, playButton.y + 60);
		g.drawString("MEDIAN", helpButton.x - 20, helpButton.y + 60);
		g.drawString("HARD", quitButton.x, quitButton.y + 60);
		
		//g2d.draw(playButton);
		//g2d.draw(helpButton);
		//g2d.draw(quitButton);
	}
}
