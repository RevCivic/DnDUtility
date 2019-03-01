package dndutility;

public class Enemy extends UnitTemplate {
	
	private int expWorth;
	
	public Enemy(int init, String unit, int health, int ac,
	int ref, int fort, int willp, int atkM,
	int dmgW, String dmgD, int dmgM, int expWorth) {
		super(init, unit, health, ac, ref, fort, willp, atkM, dmgW, dmgD, dmgM);
		this.expWorth = expWorth;
	}
	

}
