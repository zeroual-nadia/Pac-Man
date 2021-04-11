package game;


import java.util.ArrayList;

import main.InformationPacman;
import main.Point;
import personnage.*;

public class Carte {
	int width;
	int heigth;
	int pacgommeDisponible;
	Cellule carte[][];
	private Pacman pacman;
	private ArrayList<Fantome> fantomes;
	private ArrayList<Point> modifiable; //Pour.transforme.carte
	
	
	public Carte(int width, int heigth) {
		this.width = width;
		this.heigth = heigth;
		carte = new Cellule[heigth][width];
		
	}
	
	
	public Point nextPosition(Point p, Direction d) {
		Point pos = Point.getNextPosition(p, d);
		Point next = new Point((pos.getX()+width)%width, (pos.getY()+heigth)%heigth); //pour.eviter.les.val.de.pos.neg
		return next;
	}
	
	public Point previousPosition(Point p, Direction d) {
		Point pos = Point.getPreviousPosition(p, d);
		Point previous = new Point((pos.getX()+width)%width, (pos.getY()+heigth)%heigth); //pour.eviter.les.val.de.pos.neg
		return previous;
	}
	public Cellule nextCellule(Point p, Direction d) {
		return getCarteIJ(nextPosition(p, d));
	}
	
	public void transformeMap() {
		Cellule cells;
		for (Point points : modifiable) {
			cells = getCarteIJ(points);
			
			for (Fantome fantome : fantomes) {
				if (points.equal(fantome.getPosition()))
					fantome.meurt(); //Si.le.se.referme.sur.le.fontome.il.meurt
			}
			if (points.equal(pacman.getPosition()))
				pacman.setPosition(InformationPacman.PositionOriginePacman); //Si.le.se.referme.sur.le.fpacman.reviens a la position de depart
			cells.setNavigable(!cells.isNavigable());
		}
	}
	
	//Getter.Setter
	
	public int getWidth() {
		return width;
	}
	
	public int getHeigth() {
		return heigth;
	}

	public Cellule getCarteIJ(int i, int j) {
		if (i >= 0 && j >= 0 && i < heigth && j < width)
			return carte[i][j];
		return null;
	}
	
	public Cellule getCarteIJ(Point p) {
		return getCarteIJ(p.getY(), p.getX());
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}

	public void setFantomes(ArrayList<Fantome> fantomes) {
		this.fantomes = fantomes;
	}
	
	public void setCarteIJ(int i, int j, Cellule cellule)
	{
		if (i >= 0 && j >= 0 && i < heigth && j < width)
			carte[i][j] = cellule;
		else
			System.out.println("sorti de tableau dans setCarteIJ");
	}

	public ArrayList<Point> getModifiable() {
		return modifiable;
	}

	public void setModifiable(ArrayList<Point> modifiable) {
		this.modifiable = modifiable;
	}


	public int getPacgommeDisponible() {
		return pacgommeDisponible;
	}

	public void setPacgommeDisponible(int pacgommeDisponible) {
		this.pacgommeDisponible = pacgommeDisponible;
			
	}
	

}