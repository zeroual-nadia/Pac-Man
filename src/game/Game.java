package game;


import java.util.ArrayList;
import game.PacmanEvent.Event;
import game.PacmanEvent.Observable;
import main.InformationPacman;
import personnage.Fantome;
import personnage.Pacman;
import personnage.PersonnageFactory;

public class Game extends PacmanObservable{
	private Pacman pacman;
	private ArrayList<Fantome> fantomes;
	private Carte carte;
	private boolean isFinish;
	
	
	public Game() {
		isFinish = false;
		carte = CarteFactory.chargementCarte();
		fantomes = PersonnageFactory.getFantomes(carte);
		pacman = PersonnageFactory.getPacman(carte);
		carte.setFantomes(fantomes);
		carte.setPacman(pacman);
		fantomeLookPacman();
	}
	
	public void play(long time) {
		
		// deplacement
		pacman.updatePersonnage();
		for (Fantome fantome : fantomes) {
			fantome.updatePersonnage();
		}
		
		//conflit
		bonAppetit();
		
		// est fini ??
		if (carte.getPacgommeDisponible() == 0)
		{
			events.add(new PacmanEvent(Observable.GAME, Event.WIN));
			isFinish = true;
		}
		if (pacman.getPv() == 0)
		{
			events.add(new PacmanEvent(Observable.GAME, Event.LOSE));
			isFinish = true;
		}
		
		// envoie les notif
		pacman.notifyObserver();
		for (Fantome fantome : fantomes) {
			fantome.notifyObserver();
		}
		notifyObserver();
	}

	/*
	 * retourne true si le pacman est seule dans ca cellule ou que
	 * (le pacman est au meme endroit que l'un des fantome ET
	 *  qu'il y soit depuis plus longtempt)
	 */
	private boolean premierArriver() {
		for (Fantome fantome : fantomes) {
			if (fantome.getPosition().equal(pacman.getPosition()) &&
				fantome.getLastDeplacement() < pacman.getLastDeplacement())
					return false;
		}
		return true;
	}
	
	public void bonAppetit() {
		// avant conflit
		if (premierArriver())
			pacman.mangePacgomme();
		
		// conflit
		if (pacman.getId() != InformationPacman.identifiantEtatPacmanInvisible)
			for (Fantome fantome : fantomes) {
				if (fantome.getPosition().equal(pacman.getPosition())
				|| (fantome.getPosition().equal(carte.previousPosition(pacman.getPosition(),pacman.getDirection()))
				&&  carte.previousPosition(fantome.getPosition(),fantome.getDirection()).equal(pacman.getPosition())))
				{
					if (fantome.estPredateur())
						fantome.mangePersonnage(pacman);
					else if (fantome.estProie() && pacman.estPredateur())
						pacman.mangePersonnage(fantome);
				}
			}
	}


	public void	registerForAll(PacmanObserver o) {
		register(o);
		pacman.register(o);
		for (Fantome fantome : fantomes) {
			fantome.register(o);
		}
	}

	private void fantomeLookPacman() {
		for (Fantome fantome : fantomes) {
			pacman.register(fantome);
		}
	}

	// getter and setter 

	public Pacman getPacman() {
		return pacman;
	}

	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public ArrayList<Fantome> getFantomes() {
		return fantomes;
	}

	public void setFantomes(ArrayList<Fantome> fantomes) {
		this.fantomes = fantomes;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}
}
