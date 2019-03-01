package dndutility;

public class Character extends UnitTemplate {
	
	private int exp;
	
	public Character(int init, String unit, int health, int ac,
			int ref, int fort, int willp, int atkM,
			int dmgW, String dmgD, int dmgM) {
		super(init, unit, health, ac, ref, fort, willp, atkM, dmgW, dmgD, dmgM);
		exp = 0;
	}
	
	public Character(int init, String unit, int health, int ac,
			int ref, int fort, int willp, int atkM,
			int dmgW, String dmgD, int dmgM, int exp) {
		super(init, unit, health, ac, ref, fort, willp, atkM, dmgW, dmgD, dmgM);
		this.exp = exp;
	}

}
