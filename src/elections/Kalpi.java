package elections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Kalpi<T extends Citizen> implements Serializable {

	private static int id = 1000;
	private int kalpiId;

	public int getKalpiId() {
		return kalpiId;
	}

	private String kalpiAddress;
	private ArrayList<Citizen> kalpiVoters;
	private int currentNumOfKalpiVoters;
	private int capacityOfKalpiVoters = 10;
	private double kalpiVotingPercent;
	private ArrayList<String> votesResult;
	private int numOfVotes = 0;

	public Kalpi(String kalpiAddress, Citizen[] kalpiVoters) {
		this.kalpiAddress = kalpiAddress;
		this.kalpiId = id++;

		this.currentNumOfKalpiVoters = kalpiVoters.length;

		this.kalpiVoters = new ArrayList<Citizen>(this.capacityOfKalpiVoters);

		this.votesResult = new ArrayList<String>(this.capacityOfKalpiVoters);

	}

	public boolean equals(Object obj) {

		boolean equal = false;

		if (this.getClass().equals(obj.getClass())) {

			Kalpi tmp = (Kalpi) obj;
			if (tmp.kalpiId == this.kalpiId && tmp.kalpiAddress == this.kalpiAddress
					&& tmp.currentNumOfKalpiVoters == this.currentNumOfKalpiVoters
					&& tmp.capacityOfKalpiVoters == this.capacityOfKalpiVoters) {

				for (int i = 0; i < capacityOfKalpiVoters; i++) {
					if (!(this.kalpiVoters.get(i).equals(tmp.kalpiVoters.get(i)))) {
						return false;
					}
				}
				equal = true;

			}

		}
		return equal;
	}

	public void addSingleVote(String vote) {

		votesResult.add(vote);
		this.numOfVotes++;
		this.setKalpiVotingPercent(this.numOfVotes);

	}

	public int sumOfVotesForParty(String partyName) {

		// gives the total votes for an political party out of the specific kalpi

		int votesCounter = 0;

		for (int i = 0; i < this.numOfVotes; i++) {
			if (votesResult.get(i).equalsIgnoreCase(partyName)) {
				votesCounter++;
			}
		}

		return votesCounter;
	}

	public boolean canVote(Citizen citizen) {

		// checks if the citizen can vote

		Calendar currentDate = new GregorianCalendar();
		int citizenAge = currentDate.get(Calendar.YEAR) - citizen.getBirthYear();
		if (citizen instanceof CitizenWithCoronaVirus && citizenAge <= 21) {

			return false;

		}

		return true;

	}

	public void addCitizenToKalpi(Citizen citizen) {

		if (isLegalAge(citizen)) {
			this.kalpiVoters.add(citizen);
			this.currentNumOfKalpiVoters++;
		} else {
			System.out.println("cant add citizen to kalpi");
		}

	}

	public ArrayList<String> getVotesResult() {
		return votesResult;
	}

	public ArrayList<Citizen> getKalpiVoters() {

		return kalpiVoters;
	}

	public boolean setKalpiVoters(Citizen[] kalpiVoters) {

		for (int i = 0; i < this.currentNumOfKalpiVoters; i++) {
			if (isLegalAge(kalpiVoters[i])) {
				this.kalpiVoters.add(kalpiVoters[i]);

			}

		}

		return true;
	}

	public boolean isLegalAge(Citizen citizen) {

		Calendar currentDate = new GregorianCalendar();
		int citizenAge = currentDate.get(Calendar.YEAR) - citizen.getBirthYear();

		if (citizenAge < 18) {
			throw new IllegalArgumentException("This citizen cant vote yet");
		}
		return true;
	}

	public int getCurrentNumOfKalpiVoters() {
		return currentNumOfKalpiVoters;
	}

	public boolean setCurrentNumOfKalpiVoters(int currentNumOfKalpiVoters) {
		this.currentNumOfKalpiVoters = currentNumOfKalpiVoters;
		return true;
	}

	public int getCapacityOfKalpiVoters() {
		return capacityOfKalpiVoters;
	}

	public boolean setCapacityOfKalpiVoters(int capacityOfKalpiVoters) {
		this.capacityOfKalpiVoters = capacityOfKalpiVoters;
		return true;
	}

	public double getKalpiVotingPercent() {
		return kalpiVotingPercent;
	}

	public boolean setKalpiVotingPercent(int numOfVotes) {

		// the kalpi voting percent is changing only if the total number of votes and
		// the total number of citizens who can vote there is not 0

		if (this.numOfVotes != 0 && this.currentNumOfKalpiVoters != 0) {
			this.kalpiVotingPercent = (double) ((this.numOfVotes * 100) / (this.currentNumOfKalpiVoters));
			return true;
		}
		return false;
	}

	public String getKalpiAddress() {
		return kalpiAddress;
	}

	public boolean setKalpiAddress(String kalpiAddress) {
		this.kalpiAddress = kalpiAddress;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("").append(this.getClass().getSimpleName()).append("|").append("")
				.append(this.kalpiId).append("-").append("Address: ").append(" ").append(this.kalpiAddress).append(",")
				.append("Percent Of Voters : ").append(" ").append(this.kalpiVotingPercent).append(" ").append("%")
				.append(",").append("number of votes : ").append(this.numOfVotes);
		sb.append("\n");
		sb.append("The citizen who can vote there: ");
		sb.append("\n");
		for (int i = 0; i < this.currentNumOfKalpiVoters; i++) {
			String msg = kalpiVoters.get(i).toString();
			sb.append(msg);
		}
		sb.append("\n");

		return sb.toString();
	}

}
