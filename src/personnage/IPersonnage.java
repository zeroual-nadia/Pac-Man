package personnage;

public interface IPersonnage {

	public int getId();
	public void updatePersonnage();
	public boolean estPredateur();
	public boolean estProie();
	public void mangePersonnage(IPersonnage personnage);
	public void meurt();
}
