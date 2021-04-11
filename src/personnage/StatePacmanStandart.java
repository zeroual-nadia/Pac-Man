package personnage;

import main.*;


public  class StatePacmanStandart extends StatePacman{
	
	public StatePacmanStandart(Pacman moi) {
		super(moi);
	}

	
	public boolean estPredateur() {
		return false;
	}

	public boolean estProie() {
		return true;
	}


	public int getId() {

		return InformationPacman.identifiantEtatPacmanStandart;
	}

	public int getTempState() {
		return Integer.MAX_VALUE;
	}

	public int getTempDeplacementState() {
		return InformationPacman.tempDeplacementPacmanStandart;
	}
}
