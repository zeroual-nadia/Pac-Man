package personnage;


import game.*;
import game.PacmanEvent.Event;
import game.PacmanEvent.Observable;
import main.*;

public class Pacman extends Personnage{
	private StatePacman state;

	private int pv;
	private int point; // Score
	boolean bonus = false;

	public Pacman(Carte carte) {
		super(InformationPacman.PositionOriginePacman,
				InformationPacman.directionOriginePacman, carte);
		this.pv = InformationPacman.pvOriginePacman;
		state = new StatePacmanStandart(this);
		point = 0;

	}


	public void setEtat(StatePacman s)
	{
		if (state.getId() == InformationPacman.identifiantEtatPacmanArchitecte)
			carte.transformeMap(); //Si.il.etait.architecte.on.remets.la.map.d'origine
		state = s;
	}

	public void mangePacgomme()
	{
		Cellule cellule = carte.getCarteIJ(position); 

		if (cellule.hasPacgomme())
		{
			cellule.getPacgomme().actionPacgomme(this);
			cellule.detruirePacgomme();
			carte.setPacgommeDisponible(carte.getPacgommeDisponible()-1);
		}
	}

	public void addPoint(int point)
	{
		this.setPoint(this.getPoint() + point);
		if (!bonus && this.point > 5000)
		{
			pv++;
			bonus = true;
		}
	}

	public int getPv() {
		return pv;
	}

	public void deplace()
	{
		super.deplace();
		events.add(new PacmanEvent(Observable.PACMAN, Event.MOVE));
	}


	public void updatePersonnage() {
		state.updateState();

	}


	@Override
	public boolean estPredateur() {
		return state.estPredateur();
	}


	@Override
	public boolean estProie() {
		return state.estProie();
	}

	
	
	public void mangePersonnage(IPersonnage personnage) {
		personnage.meurt();
		events.add(new PacmanEvent(Observable.PACMAN, Event.EAT));
	}

	public void meurt() {
		pv--;
		events.add(new PacmanEvent(Observable.PACMAN, Event.DIE));
		setEtat(new StatePacmanStandart(this));
		super.initPersonnage(InformationPacman.PositionOriginePacman,
				InformationPacman.directionOriginePacman, carte);
	}
	
	public int getId() {

		return state.getId();
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
		events.add(new PacmanEvent(Observable.PACMAN, Event.POINT));
	}

}
