package display;

import java.awt.event.KeyListener;
import game.Direction;
import game.Game;
import personnage.Pacman;

public class GestionTouche implements KeyListener {
		MyComponent gui;
		Pacman p;
		Game game;
		
		public  GestionTouche(MyComponent gui, Pacman p, Game game) {
			super();
			this.gui = gui;
			this.p = p;
			this.game = game;
		}

		@Override
		public void keyTyped(java.awt.event.KeyEvent e) {
		}

		public void keyPressed(java.awt.event.KeyEvent e) {
			if (e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
				p.setDirection(Direction.RIGHT);
			else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
				p.setDirection(Direction.LEFT);
			else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
				p.setDirection(Direction.UP);
			else  if (e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
				p.setDirection(Direction.DOWN);
			else if (e.getKeyChar() == 'x')
				game.setFinish(true);
			gui.repaint();
		
	
		}
		
		@Override
		public void keyReleased(java.awt.event.KeyEvent e) {
		}

}
	


