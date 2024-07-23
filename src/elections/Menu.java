package elections;

interface Menu {

	public void addKalpi(Elections electionRound);

	public void addCitizen(Elections electionRound);

	public void addPoliticalParty(Elections electionRound);

	public void addCandidate(Elections electionRound);

	public void showAllKalpis(Elections electionRound);

	public void showAllCitizen(Elections electionRound);

	public void showAllPoliticalParties(Elections electionRound);

	public void makeElections(Elections electionRound);

	public void showElectionsResult(Elections electionRound);

	public boolean exit(Elections electionRound);

}
