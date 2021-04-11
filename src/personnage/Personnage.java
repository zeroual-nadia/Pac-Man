package personnage;

import game.Carte;
import game.Cellule;
import game.Direction;
import game.PacmanObservable;
import main.Point;

public abstract class Personnage extends PacmanObservable implements IPersonnage{

	protected Point position;
	protected Direction direction;
	protected Carte carte;
	protected long lastDeplacement;
	
	
	public void initPersonnage(Point position, Direction direction, Carte carte) {
		this.position = position;
		this.direction = direction;
		this.carte = carte;
		this.lastDeplacement = System.currentTimeMillis();
	}
	
	public Personnage(Point position, Direction direction, Carte carte) {
		initPersonnage(position, direction, carte);

	}

	public void deplace() {
		Cellule potentielNext;
		potentielNext = carte.nextCellule(position, direction);
		if (!potentielNext.isNavigable())
			return;
		else {
			position = potentielNext.getPosition();
			lastDeplacement = System.currentTimeMillis();
		}
	}
	
	
	public Point getPosition() {
		return position;
		}
	public void setPosition(Point pos) {
		this.position = pos;
	}

	public Direction getDirection() {
		return direction;
	}


	public void setDirection(Direction direction) {
		this.direction = direction;
	}


	public long getLastDeplacement() {
		return lastDeplacement;
	}
}
