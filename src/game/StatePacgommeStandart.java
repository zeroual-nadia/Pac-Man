package game;

import main.InformationJeu;
import personnage.Pacman;

public class StatePacgommeStandart implements IStatePacgomme{

	@Override
	public int getPoint() {
		return InformationJeu.pointPacgommeStandart;
	}

	@Override
	public void actionPacgomme(Pacman pacman) {
	}

}
