package main;


import display.Gui;
import game.Game;

public class App {
	
	public static void main(String[] args) {
		Game game;
		Gui gui;
		long time;
		
		game = new Game();
		gui = new Gui(game);
		game.registerForAll(gui);
		time = System.currentTimeMillis();
		//game.registerForAll(new Test());
		
		while (!game.isFinish())
		{
			if (System.currentTimeMillis() - time > 100)
			{
				game.play(time);
				time = System.currentTimeMillis();
			}
		}
		gui.getFrame().dispose();
	}

}

