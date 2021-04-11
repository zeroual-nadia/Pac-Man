package personnage;

public abstract class StatePacman implements IStatePacman{
	private long debutState;	
	private Pacman moi;

	public StatePacman(Pacman moi) {
		this.moi = moi;
		debutState = System.currentTimeMillis();
	}

	
	public void updateState() {
		if (System.currentTimeMillis() - debutState > getTempState())
		{
			moi.setEtat(new StatePacmanStandart(moi));
			moi.updatePersonnage();
			return;
		}
		if (System.currentTimeMillis() - moi.getLastDeplacement() > getTempDeplacementState())
			moi.deplace(); //Gerer.le.Temps.De.Deplacemets
	}
	
	public long getDebutState() {
		return debutState;
	}
	public void setDebutState(long debutState) {
		this.debutState = debutState;
	}
	public Pacman getMoi() {
		return moi;
	}
	public void setMoi(Pacman moi) {
		this.moi = moi;
	}
}
