package PeterCai.input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import PeterCai.Game;
import PeterCai.level.RandomLevel;

public class Mouse implements MouseListener{
	

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		//public Rectangle playButton = new Rectangle(170, 150, 140, 80);
		//public Rectangle helpButton = new Rectangle(170, 300, 140, 80);
		//public Rectangle quitButton = new Rectangle(170, 450, 140, 80);
		
		int mx = e.getX();
		int my = e.getY();
		
		if (Game.State == Game.STATE.MENU && mx >= 170 && mx < 310) {
			if (my >= 150 && my <= 230) {
				Game.State = Game.STATE.DIFFICULTY;
			}
		}
		
		if (Game.State == Game.STATE.MENU && mx >= 170 && mx < 310) {
			if (my >= 450 && my <= 530) {
				System.exit(1);
			}
		}
		
		if (Game.State == Game.STATE.DIFFICULTY && mx >= 170 && mx < 310) {
			if (my >= 70 && my <= 150) {
				Game.State = Game.STATE.MODE;
			}
		}
		
		if (Game.State == Game.STATE.DIFFICULTY && mx >= 170 && mx < 310) {
			if (my >= 220 && my <= 300) {
				Game.speed = 4;
				Game.State = Game.STATE.MODE;
			}
		}
		
		if (Game.State == Game.STATE.DIFFICULTY && mx >= 170 && mx < 310) {
			if (my >= 370 && my <= 450) {
				Game.speed = 5;
				Game.State = Game.STATE.MODE;
			}
		}
		
		if (Game.State == Game.STATE.MODE && mx >= 170 && mx < 310) {
			if (my >= 0 && my <= 80) {
				Game.State = Game.STATE.GAME;
			}
		}
		
		//if (Game.State == Game.STATE.MODE && mx >= 170 && mx < 310) {
			//if (my >= 150 && my <= 230) {
				//Game.interval = 5;
				//Game.speed++;
				//Game.level = new RandomLevel(640, 640);
			//}
		//}
		
		if (Game.State == Game.STATE.MODE && mx >= 170 && mx < 310) {
			if (my >= 300 && my <= 380) {
				Game.hidden = true;
			}
		}
		
		if (Game.State == Game.STATE.MODE && mx >= 170 && mx < 310) {
			if (my >= 450 && my <= 530) {
				Game.speed++;
				Game.map_speed = 2;
			}
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	
}
