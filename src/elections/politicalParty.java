package elections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

enum Faction {
	LEFT, CENTER, RIGHT
};

public class politicalParty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameOfParty;
	private Date creationDate;
	private ArrayList<Candidate> candidates;
	private int candidatesCapacity = 10;
	private int numOfCandidates;
	private int numOfVotes;
	private Faction faction;

	public politicalParty(String nameOfParty, Date creationDate, Faction faction, Candidate[] candidates) {
		this.nameOfParty = nameOfParty;
		this.creationDate = creationDate;
		this.faction = faction;
		this.numOfCandidates = candidates.length;

		this.candidates = new ArrayList<Candidate>(this.candidatesCapacity);
		this.setCandidates(candidates);

	}

	public boolean equals(Object obj) {

		boolean equal = false;

		if (this.getClass().equals(obj.getClass())) {

			politicalParty tmp = (politicalParty) obj;
			if (tmp.nameOfParty == this.nameOfParty && tmp.creationDate == this.creationDate
					&& tmp.candidatesCapacity == this.candidatesCapacity && tmp.numOfCandidates == this.numOfCandidates
					&& tmp.numOfVotes == this.numOfVotes) {

				for (int i = 0; i < numOfCandidates; i++) {
					if (!(this.candidates.get(i).equals(tmp.candidates.get(i)))) {
						return false;
					}
				}
				equal = true;

			}

		}
		return equal;
	}

	public void addCandidate(Candidate candidate) {

		this.candidates.add(candidate);
		this.numOfCandidates++;

		System.out.println("Candidate has been added successfully");

	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public boolean setNameOfParty(String nameOfParty) {
		this.nameOfParty = nameOfParty;
		return true;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public boolean setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		return true;
	}

	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}

	public boolean setCandidates(Candidate[] candidates) {
		for (int i = 0; i < this.numOfCandidates; i++) {
			this.candidates.add(candidates[i]);

		}

		return true;
	}

	public int getCandidatesCapacity() {
		return candidatesCapacity;
	}

	public boolean setCandidatesCapacity(int candidatesCapacity) {
		this.candidatesCapacity = candidatesCapacity;
		return true;
	}

	public int getNumOfCandidates() {
		return numOfCandidates;
	}

	public boolean setNumOfCandidates(int numOfCandidates) {
		this.numOfCandidates = numOfCandidates;
		return true;
	}

	public int getNumOfVotes() {
		return numOfVotes;
	}

	public boolean setNumOfVotes(int numOfVotes) {
		this.numOfVotes = numOfVotes;
		return true;
	}

	public Faction getFactions() {
		return faction;
	}

	public boolean setFactions(Faction factions) {
		this.faction = factions;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("name : ").append(" ").append(this.nameOfParty).append(",").append("Date of creation: ").append(" ")
				.append(this.creationDate);
		sb.append(",").append("Number of Candidates: ").append(" ").append(this.numOfCandidates).append(",")
				.append("number of votes : ").append(" ").append(this.numOfVotes).append(",").append("The faction: ")
				.append(" ").append(this.faction);
		sb.append("\n");
		sb.append("The candidates : ");
		sb.append("\n");
		for (int i = 0; i < this.numOfCandidates; i++) {
			sb.append(candidates.get(i).toString());

		}
		sb.append("\n");

		return sb.toString();
	}

}
