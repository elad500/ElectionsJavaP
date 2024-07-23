package elections;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Citizen implements Serializable {

	private String citizenName;
	private int citizenId;
	private int birthYear;
	private Kalpi homeKalpi;
	private boolean votedAlready = false;
	private boolean isCarryWeapon = false;

	public Citizen(String citizenName, int citizenId, int birthYear, Kalpi homeKalpi) {
		this.citizenName = citizenName;
		this.birthYear = birthYear;
		this.homeKalpi = homeKalpi;
		this.setCitizenId(citizenId);

	}

	public boolean equals(Object obj) {
		if (this.getClass().equals(obj.getClass())) {
			Citizen tmp = (Citizen) obj;
			return tmp.citizenName == this.citizenName && tmp.citizenId == this.citizenId
					&& tmp.birthYear == this.birthYear && tmp.homeKalpi == this.homeKalpi
					&& tmp.votedAlready == this.votedAlready;

		}
		return false;
	}

	public void vote(String vote) {

		// check if the citizen can vote in his kalpi
		// if can vote - its add his vote to the votes of the kalpi
		// clasify to the citizen that he alerady voted so he couldnt vote more than
		// once

		if (this.homeKalpi.canVote(this)) {
			this.homeKalpi.addSingleVote(vote);
			this.votedAlready = true;
		}

	}

	public void carryWeapon() {

		if (this.isCarryWeapon) {
			System.out.println("The soldier is carry weapon");
		} else {
			System.out.println("The soldier is not carry weapon");
		}

	}

	public boolean setHomeKalpi(Kalpi homeKalpi) {
		this.homeKalpi = homeKalpi;
		return true;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public boolean setName(String citizenName) {
		this.citizenName = citizenName;
		return true;
	}

	public int getId() {
		return citizenId;
	}

	public boolean setCitizenId(int citizenId) {

		if (!(citizenId > 99999999 && citizenId < 999999999)) {// check if the citizen id is 9 digits}
			throw new IllegalArgumentException("id must contains 9 digits!");

		}

		this.citizenId = citizenId;
		return true;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public boolean setBirthYear(int birthYear) {
		this.birthYear = birthYear;
		return true;
	}

	public Kalpi<?> getHomeKalpi() {
		return homeKalpi;
	}

	public boolean getIsVotedAlready() {
		return votedAlready;

	}

	public boolean setVotedAlready(boolean votedAlready) {
		this.votedAlready = votedAlready;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("name : ").append(" ").append(this.citizenName).append(",").append("Id: ").append(" ")
				.append(this.citizenId).append(",").append("year of birth: ").append(" ").append(this.birthYear)
				.append(",").append("His Kalpi: ").append(" ").append(this.homeKalpi.getKalpiAddress());
		return sb.toString();
	}

}
