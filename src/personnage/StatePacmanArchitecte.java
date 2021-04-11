package personnage;

import main.InformationPacman;

public class StatePacmanArchitecte extends StatePacman{


	public StatePacmanArchitecte(Pacman moi) {
		super(moi);
		moi.carte.transformeMap(); //Si.il.etait.architecte.on.remets.la.map.d'origine

		
	}


	public int getId() {
		return InformationPacman.identifiantEtatPacmanArchitecte;

	}

	public boolean estProie() {
		return true;
	}


	public boolean estPredateur() {
		return false;
	}

	
	public int getTempState() {
		return InformationPacman.tempStatePacmanArchitecte;
	}

	
	public int getTempDeplacementState() {
		return InformationPacman.tempDeplacementPacmanArchitecte;
	}
}
