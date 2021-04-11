package main;

import java.awt.Color;

import game.Direction;

public class InformationPacman {
	public static final Point PositionOriginePacman = new Point(5,9);
	public static final int pvOriginePacman = 3;
	public static final int tempBoucheOuverte = 2;
	public static final Direction directionOriginePacman = Direction.UP; 
	
	//public static final String nameEtatPacmanStandart = "PacmanStandart";
	//public static final String nameEtatPacmanSuper = "PacmanSuper";
	//public static final String nameEtatPacmanInvisible = "PacmanInvisible";
	//public static final String nameEtatPacmanArchitecte = "PacmanArchitecte";
	public static final int identifiantEtatPacmanStandart = 4;
	public static final int identifiantEtatPacmanSuper = 5;
	public static final int identifiantEtatPacmanInvisible = 6;
	public static final int identifiantEtatPacmanArchitecte = 7;
	
	public static final Color couleurPacmanStandart = Color.YELLOW;
	public static final Color couleurPacmanSuper = Color.ORANGE;
	public static final Color couleurPacmanInvisible = Color.DARK_GRAY; //new Color(255, 255, 224);
	public static final Color couleurPacmanArchitecte = couleurPacmanStandart;
	
	public static final int tempDeplacementPacmanStandart = 200;
	public static final int tempDeplacementPacmanSuper = 200;
	public static final int tempDeplacementPacmanInvisible = 200;
	public static final int tempDeplacementPacmanArchitecte = tempDeplacementPacmanStandart;
	public static final int tempStatePacmanSuper = 8000;
	public static final int tempStatePacmanInvisble = 8000;
	public static final int tempStatePacmanArchitecte = 8000;

}
