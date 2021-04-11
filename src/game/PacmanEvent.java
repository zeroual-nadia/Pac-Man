package game;


public class PacmanEvent {

	public static enum Event {
		MOVE, 
		START, LOSE, WIN,
		EAT, DIE, POINT,
		SUPERPACBON,ARCHITECTEPACBON,INVISIBLEPACBON,STANDARDPACBON
	}
	public static enum Observable {
		PACMAN, FANTOME, GAME
	}
	
	private final Event event;
	private final Observable objet;
	
	public PacmanEvent(Observable obj, Event event) {
		this.event = event;
		this.objet = obj;	
	}
	
	public Event getEvent() {
		return event;
	}

	public Observable getObjet() {
		return objet;
	}
}
