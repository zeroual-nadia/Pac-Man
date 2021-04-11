package personnage;

import main.InformationFantome;

public class StateFantomeStandart extends StateFantome {
	
	
	public StateFantomeStandart(Fantome moi) {
		super(moi);
	}
	

	public void updateState() {
		if (moi == null)
			System.out.println("pb fontome");
		if (System.currentTimeMillis() - moi.getLastDeplacement() >InformationFantome.tempDeplacementFantomeStandart)
			moi.deplace(); // Gerer la vitesse de deplacements 
	}


	public boolean estProie() {
		return false;
	}

	public boolean estPredateur() {
		return true;
	}


	public int getId() {
		return InformationFantome.identifiantEtatFantomeStandart;
	}
}
