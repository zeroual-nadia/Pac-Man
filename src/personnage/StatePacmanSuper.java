package personnage;

import main.*;

public class StatePacmanSuper extends StatePacman{


public StatePacmanSuper(Pacman moi) {
	super(moi);
}

public boolean estPredateur() {
	return true;
}

public boolean estProie() {
	return false;
}



public int getId() {
	return InformationPacman.identifiantEtatPacmanSuper;
}


public int getTempState() {
	return InformationPacman.tempStatePacmanSuper;
}

public int getTempDeplacementState() {
	
	return InformationPacman.tempDeplacementPacmanSuper;
}
}
