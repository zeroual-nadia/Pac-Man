package game;

import main.Point;

public class Cellule {
	private int x;
	private int y;
	private boolean navigable;
	private Pacgomme pacgomme; 
	
	public Cellule(int x, int y, boolean navigable, Pacgomme pacgomme) {
		this.x = x;
		this.y = y;
		this.navigable = navigable;
		this.pacgomme = pacgomme;
	}
	
	
	public void detruirePacgomme() {
		if (hasPacgomme())
			pacgomme = null;
	}
	
	public boolean hasPacgomme() {
		if (pacgomme == null)
			return false;
		else
			return true;
	}
	
	public Point getPosition() {
		return new Point(x, y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isNavigable() {
		return navigable;
	}
	public void setNavigable(boolean navigable) {
		this.navigable = navigable;
	}
	public Pacgomme getPacgomme() {
		return pacgomme;
	}
	

}
