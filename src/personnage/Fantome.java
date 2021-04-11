package personnage;


import java.util.List;

import game.Carte;
import game.Direction;
import game.PacmanEvent;
import game.PacmanEvent.Event;
import game.PacmanEvent.Observable;
import game.PacmanObserver;
import main.*;
import main.Point;

public class Fantome extends Personnage implements PacmanObserver{
	StateFantome state;

	public Fantome(Carte carte) {
		super(InformationFantome.PositionOrigineFantome, 
				InformationFantome.directionOrigineFantome, carte);
		state = new StateFantomeStandart(this);
	}

	public void deplace() {
		Point tmp = new Point(position);
		super.deplace();
		
		if (position.equal(tmp)) {
			direction = Direction.createDirection((int)(Math.random() * 4));
			deplace();
		}
		events.add(new PacmanEvent(Observable.FANTOME, Event.MOVE));
	}

	
	public void updatePersonnage() {
		state.updateState();		
	}

	public void mangePersonnage(IPersonnage personnage) {
		events.add(new PacmanEvent(Observable.FANTOME, Event.EAT));
		personnage.meurt();
		
	}

	public void meurt() {
		state = new StateFantomeStandart(this);
		super.initPersonnage(InformationFantome.PositionOrigineFantome,
				InformationFantome.directionOrigineFantome, carte);
		events.add(new PacmanEvent(Observable.FANTOME, Event.DIE));

	}

	public void notify(List<PacmanEvent> events) {
		for (PacmanEvent pacmanEvent : events) {
			if ((pacmanEvent.getEvent() == Event.DIE || pacmanEvent.getEvent() == Event.INVISIBLEPACBON || pacmanEvent.getEvent() == Event.ARCHITECTEPACBON)
					&& state.getId() != InformationFantome.identifiantEtatFantomeStandart)
				setState(new StateFantomeStandart(this));
			if (pacmanEvent.getEvent() == Event.SUPERPACBON)
				setState(new StateFantomeCraintif(this));
		}		
	}

	public StateFantome getState() {
		return state;
	}

	public void setState(StateFantome state) {
		this.state = state;
	}
		
	public int getId() {
		return state.getId();
	}

	public boolean estPredateur() {
		return state.estPredateur();
	}

	public boolean estProie() {
		return state.estProie();
	}
}
