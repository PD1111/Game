package PeterCai;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Mode {
	public Rectangle noButton = new Rectangle(170, 0, 140, 80);
	public Rectangle playButton = new Rectangle(170, 150, 140, 80);
	public Rectangle helpButton = new Rectangle(170, 300, 140, 80);
	public Rectangle quitButton = new Rectangle(170, 450, 140, 80);
	
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.BLACK);
		g.drawString("MODE :", 0, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt1);
		g.drawString("Start", noButton.x + 20, noButton.y + 60);
		g.drawString("Hard Rock", playButton.x + 20, playButton.y + 60);
		g.drawString("Hidden", helpButton.x + 20, helpButton.y + 60);
		g.drawString("Double Time", quitButton.x + 20, quitButton.y + 60);
		
		//g2d.draw(playButton);
		//g2d.draw(helpButton);
		//g2d.draw(quitButton);
	}
}
