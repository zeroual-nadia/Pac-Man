package game;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import main.*;

public class CarteFactory {
	
	/*
	 * prend une chaine de caractere contenant 2 nombres entiers separer par un espace
	 * et renvois un point avec x = premiere valeur et y = seconde valeur
	 * 
	 */
	private static Point getTailleCarte(String fLine) {
		String []mots = fLine.split(" ");
		int heigth;
		int width;
		
		if (mots == null || mots.length != 2)
			return null;
		heigth = Integer.parseInt(mots[0]);
		width = Integer.parseInt(mots[1]);
		return new Point(heigth, width);
		
	}
	
	
	private static Cellule getCellule(int identifiant, Carte carte, int x, int y) {
		boolean isnavigable;
		Pacgomme pacgomme = null;
		
		if (identifiant > 100 || identifiant < 0)
		{
			System.out.println("identifiant non reconnu pour la carte getCellule");
			return null;
		}
		if (identifiant / 10 == InformationJeu.identifiantMur)
			isnavigable = false;
		else if (identifiant / 10 == InformationJeu.identifiantCaseVide)
			isnavigable = true;
		else
		{
			System.out.println("identifiant non reconnu pour la carte getCellule");
			return null;
		}
		identifiant %= 10;
		if (identifiant > 0)
			pacgomme = new Pacgomme(identifiant);
		return new Cellule(x, y, isnavigable, pacgomme);
	}
	
	
	private static boolean completeCarte(Carte carte, Scanner scan) {
		int pacgommeDispo = 0;
		for (int i = 0; i < carte.getHeigth(); i++) {
			if (!scan.hasNext())
			{
				System.out.println("Mauvais format nombre de ligne");
				return false;
			}
			
			String []nombre = scan.nextLine().split(" ");
			
			if (nombre.length < carte.getWidth()-1)
			{
				System.out.println(nombre.length + "  " + carte.getWidth());
				System.out.println("Mauvais format nombre de case sur la ligne" + i);
				return false;
			}
			for (int j = 0; j < carte.width; j++) {
				

				int tmp = Integer.parseInt(nombre[j]);
				carte.setCarteIJ(i, j, getCellule(tmp, carte, j, i));
				
				if (tmp%10 > 0)
					pacgommeDispo++; //compter.les.pacgommes
			}
		}
			carte.setPacgommeDisponible(pacgommeDispo);
			return true;
		
	}
	
	
	private static ArrayList<Point> getPointModifiable(Scanner s) {
		ArrayList<Point> map = new ArrayList<Point>();
		while (s.hasNext())
		{
			String tmp[] = s.nextLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			map.add(new Point(x, y));
		}
		return map;
	}
	

	public static Carte chargementCarte()
	{
		File file = new File(InformationJeu.CheminCarte);
		Scanner s;
		Carte carte;
		
		try {
			s= new Scanner(file);
        } catch (Exception eof) {
        	System.out.println("Mauvais fichier");
        	return null;
        }
		
		if (!s.hasNext()) {
			System.out.println("mauvais format");
			s.close();
			return null;
		}
		
		Point size = getTailleCarte(s.nextLine());
		if (size == null)
		{
			s.close();
			return null;
		}
		carte = new Carte(size.getX(), size.getY());
		completeCarte(carte, s);
		carte.setModifiable(getPointModifiable(s));
		s.close();
		return carte;
		
		
	}
}
