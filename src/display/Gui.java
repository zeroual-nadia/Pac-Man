package display;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import game.Game;
import game.PacmanEvent;
import game.PacmanEvent.Event;
import game.PacmanObserver;


public class Gui implements PacmanObserver{
	private JFrame frame;
	private MyComponent component;


	public Gui(Game game) {
		this.component = new MyComponent(game.getCarte(), game.getFantomes(), game.getPacman());
		frame = init_frame(component, game);
		MyComponent.popMessage("Bonne chance");
	}
	
	private static JFrame init_frame(MyComponent component, Game game) {
		JFrame frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("MON SUPER JEU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(component);
		frame.setVisible(true);
		frame.addKeyListener(new GestionTouche(component, game.getPacman(), game));
		return frame;
	}
	
	public void notify(List<PacmanEvent> events) {
		component.repaint();
		for (PacmanEvent pacmanEvent : events) {
			if (pacmanEvent.getEvent() != Event.MOVE)
			{
				if (pacmanEvent.getEvent() == Event.START)
					MyComponent.popMessage("Bonne chance!");
				if (pacmanEvent.getEvent() == Event.LOSE)
					MyComponent.popMessage("Game Over!");
				if (pacmanEvent.getEvent() == Event.WIN)
					MyComponent.popMessage("Winner!");
				break;
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
