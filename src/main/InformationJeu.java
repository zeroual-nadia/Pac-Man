package main;

import java.awt.Color;

public class InformationJeu {
	// chemin absolu ou relatif 
	public static final String CheminCarte = "src/map.txt";
	
	public static final Color Mur = Color.BLUE;
	public static final Color CelluleNavigable = Color.BLACK;
	public static final int RayonPacgomme  = 20;

	public static final Color PacbonStandart = Color.white;
	public static final Color PacbonCourage = Color.PINK;
	public static final Color PacbonInvisible = Color.MAGENTA;
	public static final Color PacbonArchitecte = Color.GREEN;
	
	public static final int identifiantPacgommeStandart = 1;
	public static final int identifiantPacgommeSuper = 2;
	public static final int identifiantPacgommeInvisible = 3;
	public static final int identifiantPacgommeArchitecte = 4;
	
	public static final int pointPacgommeStandart = 100;
	public static final int pointPacgommeSuper = 500;
	public static final int pointPacgommeInvisible = 300;
	public static final int pointPacgommeArchitecte = 1000;
	
	public static final int identifiantMur = 2;
	public static final int identifiantCaseVide = 1;
	
}
