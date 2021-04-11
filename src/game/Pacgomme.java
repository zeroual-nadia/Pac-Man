package game;


import game.PacmanEvent.Event;
import game.PacmanEvent.Observable;
import main.InformationJeu;
import personnage.Pacman;
import personnage.StatePacmanArchitecte;
import personnage.StatePacmanInvisible;
import personnage.StatePacmanSuper;



public class Pacgomme {
	private int stateId;
	
	public Pacgomme(int stateId) {
		this.stateId = stateId;
	}
	
	public void actionPacgomme(Pacman p) {
		if (stateId == InformationJeu.identifiantPacgommeSuper)
			actionPacgommeSuper(p);
		else if (stateId == InformationJeu.identifiantPacgommeInvisible)
			actionPacgommeInvisible(p);
		else if (stateId == InformationJeu.identifiantPacgommeArchitecte)
			actionPacgommeArchitecte(p);
		else
			actionPacgommeStandard(p);
	}
	
	private void actionPacgommeStandard(Pacman p)
	{
		p.events.add(new PacmanEvent(Observable.PACMAN, Event.STANDARDPACBON));
		p.addPoint(InformationJeu.pointPacgommeStandart);	
	}
	
	private void actionPacgommeSuper(Pacman p)
	{
		p.events.add(new PacmanEvent(Observable.PACMAN, Event.SUPERPACBON));
		p.addPoint(InformationJeu.pointPacgommeSuper);
		p.setEtat(new StatePacmanSuper(p));
	}
	
	private void actionPacgommeInvisible(Pacman p)
	{
		p.events.add(new PacmanEvent(Observable.PACMAN, Event.INVISIBLEPACBON));
		p.addPoint(InformationJeu.pointPacgommeInvisible);
		p.setEtat(new StatePacmanInvisible(p));	
	}
	
	
	private void actionPacgommeArchitecte(Pacman p)
	{
		p.events.add(new PacmanEvent(Observable.PACMAN, Event.ARCHITECTEPACBON));
		p.addPoint(InformationJeu.pointPacgommeArchitecte);
		p.setEtat(new StatePacmanArchitecte(p));
	}
	
	
	public int getstateId() {
		return stateId;
	}
}
