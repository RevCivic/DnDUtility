package dndutility;

public abstract class UnitTemplate {
	
	private int initiative;
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int armorClass;
	private int reflex;
	private int fortitude;
	private int will;
	private int attackMod;
	private int weaponCount;
	private int weaponDamage;
	private int damageMod;
	
	public UnitTemplate(int init, String unit, int health, int ac,
	int ref, int fort, int willp, int atkM,
	int dmgW, String dmgD, int dmgM) {
		
		initiative = init;
		name = unit;
		maxHealth = health;
		currentHealth = maxHealth;
		armorClass = ac;
		reflex = ref;
		fortitude = fort;
		will = willp;
		attackMod = atkM;
		weaponCount = dmgW;
		weaponDamage = Integer.parseInt(dmgD.replace("d", ""));
		damageMod = dmgM;
	}
	
	public int roll(String attr) {
		return 0;
	}
	public int[] makeAttack() {
		int attack[] = new int[2];
		attack[1] = damageMod;
		attack[0] = (int)((Math.random()*20) + 1)+attackMod;
		for (int i=1; i<(weaponCount+1); i++) {
			int roll = (int)((Math.random()*weaponDamage) + 1);
			attack[1] = attack[1]+roll;
		}
		return attack;
	}
	public void takeAttack(int attack[]) {
		if (attack[0] >= armorClass) {
			currentHealth = currentHealth - attack[1];
		}
		updateStatus();
	}
	public void updateStatus() {
		//future status effect stuff, it'll be cool!
	}
	public Object[] addRow() {
		String initstring = String.format("%03d", initiative);
		return new Object[] {initstring, name, maxHealth, armorClass, reflex, fortitude, will, attackMod, weaponCount+"d"+weaponDamage+"+"+damageMod};
	}
}
