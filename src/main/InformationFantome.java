package main;

import java.awt.Color;

import game.Direction;

public class InformationFantome {
	public static final int nombreFantomes = 4;
	public static final Point PositionOrigineFantome= new Point(5,3);
	public static final Direction directionOrigineFantome = Direction.UP; 
	

	public static final int identifiantEtatFantomeStandart = 8;
	public static final int identifiantEtatFantomeCraintif = 7;
	
	public static final Color couleurFantomeStandart = Color.BLUE;
	public static final Color couleurFantomeCraintif = Color.RED;
	
	public static final int tempDeplacementFantomeStandart = 400;
	public static final int tempDeplacementFantomeCraintif = 2 * tempDeplacementFantomeStandart;
	public static final int tempStateFantomeCraintif = InformationPacman.tempStatePacmanSuper;
	
}	
