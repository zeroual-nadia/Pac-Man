package personnage;

import java.util.ArrayList;
import game.Carte;
import main.InformationFantome;

public class PersonnageFactory {
	
	public static ArrayList<Fantome> getFantomes(Carte carte)
	{
		ArrayList<Fantome> fantomes = new ArrayList<>();
		for (int i = 0; i < InformationFantome.nombreFantomes ; i++) {
			fantomes.add(new Fantome(carte));
		}
		return fantomes;
	}
	public static Pacman getPacman(Carte carte)
	{
		return new Pacman(carte);
	}
}
