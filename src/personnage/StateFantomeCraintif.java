package personnage;

import main.InformationFantome;

public class StateFantomeCraintif extends StateFantome{

	
	public StateFantomeCraintif(Fantome moi) {
		super(moi);
	}


	public void updateState() {
		if (System.currentTimeMillis() - getDebutState() > InformationFantome.tempStateFantomeCraintif)
		{
			moi.setState(new StateFantomeStandart(moi));
			moi.updatePersonnage(); // Revenir en Standart après un temps donner
			return;
		}
		if (System.currentTimeMillis() - moi.getLastDeplacement() > InformationFantome.tempDeplacementFantomeCraintif)
			moi.deplace(); // Pour gerer la vitesse de deplacemenets 
	}
	
		
	public boolean estProie() {
		return true;
	}

	public boolean estPredateur() {
		return false;
	}

	public int getId() {
		return InformationFantome.identifiantEtatFantomeCraintif;
	}

	

}
