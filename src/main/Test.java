package main;

import java.util.List;

import game.PacmanEvent;
import game.PacmanEvent.Event;
import game.PacmanEvent.Observable;
import game.PacmanObserver;

public class Test implements PacmanObserver{

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	private void pacmanTest(PacmanEvent pacmanEvent)
	{
		if (pacmanEvent.getEvent() == Event.DIE)
			System.out.println("Le pacman viens de mourir");
		if (pacmanEvent.getEvent() == Event.EAT)
			System.out.println("le pacman viens de manger un fantome");
		if (pacmanEvent.getEvent() == Event.SUPERPACBON
				|| pacmanEvent.getEvent() == Event.ARCHITECTEPACBON
				|| pacmanEvent.getEvent() == Event.INVISIBLEPACBON)
			System.out.println("le pacman viens de manger pacbon speciale");
		//if (pacmanEvent.getEvent() == Event.POINT)
		//	System.out.println("Le pacman viens de gagner des points");
		//if (pacmanEvent.getEvent() == Event.STANDARDPACBON)
		//	System.out.println("le pacman viens de manger un pacbon classique");
		//if (pacmanEvent.getEvent() == Event.MOVE)
		//	System.out.println("le pacman viens de ce deplacer");	
	}
	
	
	private void fantomeTest(PacmanEvent pacmanEvent)
	{
		if (pacmanEvent.getEvent() == Event.DIE)
			System.out.println("Un fantome viens de mourir");
		if (pacmanEvent.getEvent() == Event.EAT)
			System.out.println("Un fantome viens de manger le pacman");		
	}
	
	private void gameTest(PacmanEvent pacmanEvent)
	{
		if (pacmanEvent.getEvent() == Event.START)
			System.out.println("debut de la parti");
		if (pacmanEvent.getEvent() == Event.LOSE)
			System.out.println("vous avez perdu");
		if (pacmanEvent.getEvent() == Event.WIN)
			System.out.println("vous avez gagné");
	}

	public void notify(List<PacmanEvent> events)
	{
		for (PacmanEvent pacmanEvent : events)
		{
			if (pacmanEvent.getObjet() == Observable.PACMAN)
				pacmanTest(pacmanEvent);
			
			else if (pacmanEvent.getObjet() == Observable.FANTOME)
				fantomeTest(pacmanEvent);
			else
				gameTest(pacmanEvent);
			
		}
	}
}

