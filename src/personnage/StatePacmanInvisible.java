package personnage;

import main.InformationPacman;

public class StatePacmanInvisible extends StatePacman{

	
	public StatePacmanInvisible(Pacman moi) {
		super(moi);
	}


	public int getId() {
		return InformationPacman.identifiantEtatPacmanInvisible;

	}

	public boolean estProie() {
		return false;
	}


	public boolean estPredateur() {
		return false;
	}

	
	public int getTempState() {
		return InformationPacman.tempStatePacmanInvisble;
	}

	
	public int getTempDeplacementState() {
		return InformationPacman.tempDeplacementPacmanInvisible;
	}

}
