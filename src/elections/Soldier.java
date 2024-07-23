package elections;

import java.io.Serializable;

public class Soldier extends Citizen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean isCarryWeapon = false;

	public Soldier(String citizenName, int citizenId, int birthYear, Kalpi homeKalpi, boolean isCarryWeapon) {
		super(citizenName, citizenId, birthYear, homeKalpi);
		this.isCarryWeapon = isCarryWeapon;

	}

	public void carryWeapon() {

		if (this.isCarryWeapon) {
			System.out.println("The soldier is carry weapon");
		} else {
			System.out.println("The soldier is not carry weapon");
		}

	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && this.isCarryWeapon == (((Soldier) obj).isCarryWeapon);
	}

	@Override
	public String toString() {
		return super.toString() + "and it" + this.isCarryWeapon + "that is carry weapon";
	}

}
