package personnage;

public abstract class StateFantome  implements IStateFantome{
	private long debutState;	
	protected Fantome moi;

	public StateFantome(Fantome moi) {
		this.moi = moi;
		if (moi == null)
			System.out.println("pb constructeur fontome");
		debutState = System.currentTimeMillis();
	}
	
	public void updateState() {
		}
	
	public long getDebutState() {
		return debutState;
	}
	public void setDebutState(long debutState) {
		this.debutState = debutState;
	}
	
}
