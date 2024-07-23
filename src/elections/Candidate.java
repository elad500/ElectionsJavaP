package elections;

import java.io.Serializable;

public class Candidate extends Citizen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String candidateParty;

	public Candidate(String citizenName, int citizenId, int birthYear, Kalpi homeKalpi,
			String candidateParty) {
		super(citizenName, citizenId, birthYear, homeKalpi);
		this.candidateParty = candidateParty;
	}

	public String getCandidateParty() {
		return candidateParty;
	}

	public boolean setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && this.candidateParty.equalsIgnoreCase(((Candidate) obj).candidateParty);
	}

	@Override
	public String toString() {
		return super.toString() + "\t  and is candidate party is" + this.candidateParty;
	}
	

}
