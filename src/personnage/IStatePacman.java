package personnage;

public interface IStatePacman {
	public int getId();
	public int getTempState();
	public int getTempDeplacementState();
	public void updateState();
	public boolean estProie();
	public boolean estPredateur();
}
