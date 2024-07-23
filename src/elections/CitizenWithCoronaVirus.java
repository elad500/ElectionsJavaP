package elections;

import java.io.Serializable;

public class CitizenWithCoronaVirus extends Citizen implements Serializable {
	public CitizenWithCoronaVirus(String citizenName, int citizenId, int birthYear, Kalpi homeKalpi,
			int daysWithCorona) {
		super(citizenName, citizenId, birthYear, homeKalpi);
		this.daysWithCorona = daysWithCorona;
	}

	private int daysWithCorona;

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && this.daysWithCorona == (((CitizenWithCoronaVirus) obj).daysWithCorona);
	}

	@Override
	public String toString() {
		return super.toString() + "\t and the days with corona virus" + this.daysWithCorona;
	}

}
