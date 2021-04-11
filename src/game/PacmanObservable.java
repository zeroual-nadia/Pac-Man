package game;

import java.util.ArrayList;

/*
 * Vu que toute les element observable font exactement la meme chose
 * On a decider de faire une classe abstraite a la place d'une interface
 */
public abstract class PacmanObservable {
	protected ArrayList<PacmanObserver> observers = new ArrayList<>();
	protected ArrayList<PacmanEvent> events = new ArrayList<>();

	public void register(PacmanObserver o) {
		observers.add(o);
	}

	public void unregister(PacmanObserver o) {
		observers.remove(o);
	}	

	/*
	 * Contrairement a la version vu en cours on a decider
	 * decider de supprimer tous les events apres les avoir notifier
	 * Pour eviter d'avoir a recreer des arrayList a chaque fois
	 */
	public void notifyObserver()
	{
		for (PacmanObserver pacmanObserver : observers)
			pacmanObserver.notify(events);
		while (!events.isEmpty())
			events.remove(0);
	}

}
