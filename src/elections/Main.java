package elections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Main implements Menu {

	public static void main(String[] args) throws IllegalObjectException {
		Scanner s = new Scanner(System.in);

		int choise;
		boolean fContinue = true;

		Citizen[] votersForKalpi5 = new Citizen[0];
		// empty fictitious array of voters for kalpi in order to make a new citizen
		// because i make the array of kalpis later only in the main and i needed to now
		// later the real kalpis for the citizens and for the candidates are updated

		Kalpi kalpi1 = new Kalpi("Matnas Havayot Tzafon,Rehovot", votersForKalpi5);
		Kalpi kalpi2 = new Kalpi("Matnas Havayot Darom,Rehovot", votersForKalpi5);

		Citizen citizen1 = new Citizen("Roei", 208461185, 1996, kalpi1);
		Citizen citizen2 = new Citizen("Elad", 208461186, 1996, kalpi2);
		Citizen citizen3 = new Citizen("Almog", 208461187, 1996, kalpi1);
		Citizen citizen4 = new Citizen("Eyal", 208461188, 1996, kalpi2);
		Citizen citizen5 = new Citizen("Adam", 208461189, 1996, kalpi1);
		Citizen citizen6 = new Citizen("Itay", 208461190, 1996, kalpi2);

		Citizen[] citizens = new Citizen[6]; // used for the switch cases
		citizens[0] = citizen1;
		citizens[1] = citizen2;
		citizens[2] = citizen3;
		citizens[3] = citizen4;
		citizens[4] = citizen5;
		citizens[5] = citizen6;

		Candidate candidate1 = new Candidate(citizen1.getCitizenName(), citizen1.getId(), citizen1.getBirthYear(),
				citizen1.getHomeKalpi(), "Likud");
		Candidate candidate2 = new Candidate(citizen2.getCitizenName(), citizen2.getId(), citizen2.getBirthYear(),
				citizen1.getHomeKalpi(), "Likud");
		Candidate candidate3 = new Candidate(citizen3.getCitizenName(), citizen3.getId(), citizen3.getBirthYear(),
				citizen1.getHomeKalpi(), "KaholLavan");
		Candidate candidate4 = new Candidate(citizen4.getCitizenName(), citizen4.getId(), citizen4.getBirthYear(),
				citizen1.getHomeKalpi(), "KaholLavan");
		Candidate candidate5 = new Candidate(citizen5.getCitizenName(), citizen5.getId(), citizen5.getBirthYear(),
				citizen1.getHomeKalpi(), "YeshAtid");
		Candidate candidate6 = new Candidate(citizen6.getCitizenName(), citizen6.getId(), citizen6.getBirthYear(),
				citizen1.getHomeKalpi(), "YeshAtid");

		Candidate[] likudCandidates = new Candidate[2];
		likudCandidates[0] = candidate1;
		likudCandidates[1] = candidate2;

		Candidate[] kaholLavanCandidates = new Candidate[2];
		kaholLavanCandidates[0] = candidate3;
		kaholLavanCandidates[1] = candidate4;

		Candidate[] yeshAtidCandidates = new Candidate[2];
		yeshAtidCandidates[0] = candidate5;
		yeshAtidCandidates[1] = candidate6;

		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();

		politicalParty party1 = new politicalParty("Likud", d1, Faction.CENTER, likudCandidates);
		politicalParty party2 = new politicalParty("KaholLavan", d2, Faction.RIGHT, kaholLavanCandidates);
		politicalParty party3 = new politicalParty("YeshAtid", d3, Faction.LEFT, yeshAtidCandidates);

		politicalParty[] parties = new politicalParty[3];
		parties[0] = party1;
		parties[1] = party2;
		parties[2] = party3;

		Citizen[] votersForKalpi1 = new Citizen[3];

		votersForKalpi1[0] = citizen1;
		votersForKalpi1[1] = citizen2;
		votersForKalpi1[2] = citizen3;

		Citizen[] votersForKalpi2 = new Citizen[3];

		votersForKalpi2[0] = citizen4;
		votersForKalpi2[1] = citizen5;
		votersForKalpi2[2] = citizen6;

		Kalpi[] kalpiot = new Kalpi[2];
		kalpiot[0] = kalpi1;
		kalpiot[1] = kalpi2;

		Citizen[] voters = new Citizen[6];
		voters[0] = citizen1;
		voters[1] = citizen2;
		voters[2] = citizen3;
		voters[3] = citizen4;
		voters[4] = citizen5;
		voters[5] = citizen6;

		Elections electionRound = new Elections(04, 2021, voters, parties, kalpiot);

		// an update of the citizen's kalpi
		for (int i = 0; i < electionRound.getNumOfVoters(); i++) {
			electionRound.assignCitizenToKalpi(electionRound.getVoters().get(i));
		}

		// an update of the candidates's kalpi
		for (int i = 0; i < electionRound.getNumOfParties(); i++) {
			for (int j = 0; j < electionRound.getParties().get(i).getNumOfCandidates(); j++) {
				electionRound.assignCitizenToKalpi(electionRound.getParties().get(i).getCandidates().get(j));
			}

		}

		try {

			System.out.println("Do you want to start reading the file saved? (Y/N)");
			char c = s.next().charAt(0);
			if (c == 'Y' || c == 'y')
				electionRound = readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		do {
			Main main = new Main();
			System.out.println();
			System.out.println("Please enter an option (1-10)");
			System.out.println("1 - add Kalpi");
			System.out.println("2 - add Citizen");
			System.out.println("3 - add political Party");
			System.out.println("4 - add Candidate to some party");
			System.out.println("5 - show all kalpis");
			System.out.println("6 - show all citizens");
			System.out.println("7 - show all political parties");
			System.out.println("8 - make Elections");
			System.out.println("9 - show elections's results");
			System.out.println("10 - Exit");
			System.out.println();

			System.out.print("Enter your choise --> : ");
			choise = s.nextInt();

			switch (choise) {

			case 1: {
				main.addKalpi(electionRound);
				break;

			}

			case 2: {

				main.addCitizen(electionRound);
				break;

			}

			case 3: {
				main.addPoliticalParty(electionRound);

				break;
			}
			case 4: {
				main.addCandidate(electionRound);

				break;

			}

			case 5: {

				main.showAllKalpis(electionRound);
				break;
			}

			case 6: {
				main.showAllCitizen(electionRound);
				break;
			}
			case 7: {
				main.showAllPoliticalParties(electionRound);
				break;
			}
			case 8: {
				main.makeElections(electionRound);
				break;

			}
			case 9: {
				main.showElectionsResult(electionRound);
				break;

			}

			case 10: {

				fContinue = main.exit(electionRound);

				break;

			}

			default: {

				System.out.println("Invalid option , please enter again (1-10) ");

			}

			}

		} while (fContinue);

		System.out.println("Goodbye");
		s.close();

	}

	@Override
	public void addKalpi(Elections electionRound) {
		String address;
		int num;

		Citizen[] votersForKalpi4 = new Citizen[1];

		Scanner s = new Scanner(System.in);

		System.out.println("Please type adress for the kalpi : ");
		address = s.next();

		System.out.println("Please choose the type of kalpi: 1- Regular 2-Corona idf Kalpi");
		num = s.nextInt();

		if (num == 1) {

			Kalpi kalpi = new Kalpi(address, votersForKalpi4);
			electionRound.addKalpi(kalpi);

		}
		if (num == 2) {

			KalpiCoronaIDF kalpi = new KalpiCoronaIDF(address, votersForKalpi4);
			electionRound.addKalpi(kalpi);

		}

	}

	@Override
	public void addCitizen(Elections electionRound) {
		String name;
		int id;
		int yearOfBirth;

		Scanner s = new Scanner(System.in);
		System.out.println("Please type the name of the citizen you would like to create : ");
		name = s.next();
		System.out.println("Please type the id of the citizen you would like to create(9 digits):");
		id = s.nextInt();
		System.out.println("Please Type the birth year of the citizen you would like to create :");
		yearOfBirth = s.nextInt();

		Citizen citizen8 = new Citizen(name, id, yearOfBirth, null);

		electionRound.addCitizen(citizen8);
	}

	@Override
	public void addPoliticalParty(Elections electionRound) {
		String name;
		String factionSide;
		Faction factionOfTheParty;
		Date d5 = new Date();

		Scanner s = new Scanner(System.in);
		System.out.println("please type name of the political Party you would like to add : ");
		name = s.next();

		System.out.println("Please write the faction of the party you would like to add: (CENTER,LEFT,RIGHT");
		factionSide = s.next();

		Candidate[] candidates = new Candidate[1];

		// check which faction Side as a String has been written and convert it to
		// Faction type
		Faction[] factions = Faction.values();
		for (int i = 0; i < factions.length; i++) {
			if (factions[i].toString().equalsIgnoreCase(factionSide)) {
				factionOfTheParty = Faction.values()[i];
				politicalParty party5 = new politicalParty(name, d5, factionOfTheParty, candidates);
				electionRound.addPoliticalParty(party5);
				break;
			}
		}
	}

	@Override
	public void addCandidate(Elections electionRound) {
		int choosenNumOfCitizen;
		String nameOfParty;
		Scanner s = new Scanner(System.in);
		System.out.println("Choose one of the citizens spots to use the citizen to add candidate from : (0-5)");
		choosenNumOfCitizen = s.nextInt();

		System.out.println(
				"Enter the name of the Party you would like to add the candidate to :(Likud,KaholLavan,YeshAtid) ");
		nameOfParty = s.next();

		for (int i = 0; i < electionRound.getNumOfVoters(); i++) {
			if (choosenNumOfCitizen == i) {
				Candidate candidate = new Candidate(electionRound.getVoters().get(i).getCitizenName(),
						electionRound.getVoters().get(i).getId(), electionRound.getVoters().get(i).getBirthYear(),
						electionRound.getVoters().get(i).getHomeKalpi(), nameOfParty);
				for (int j = 0; j < electionRound.getNumOfParties(); j++) {
					if (electionRound.getParties().get(j).getNameOfParty().equalsIgnoreCase(nameOfParty)) {
						electionRound.getParties().get(j).addCandidate(candidate);
						break;
					}
				}
			}
		}
	}

	@Override
	public void showAllKalpis(Elections electionRound) {
		electionRound.displayAllKalpis();

	}

	@Override
	public void showAllCitizen(Elections electionRound) {
		electionRound.displayAllCitizens();

	}

	@Override
	public void showAllPoliticalParties(Elections electionRound) {
		electionRound.displayAllPoliticalParties();

	}

	@Override
	public void makeElections(Elections electionRound) {
		boolean answer;
		String vote;
		boolean wearMask;
		Scanner s = new Scanner(System.in);

		for (int i = 0; i < electionRound.getNumOfVoters(); i++) {
			if (!(electionRound.getVoters().get(i).getIsVotedAlready())) {
				System.out.println("Would you like to vote? (False/True): ");
				answer = s.nextBoolean();

				if (answer == true) {
					if (electionRound.getVoters().get(i) instanceof CitizenWithCoronaVirus) {

						System.out.println("Do you wearing to wear a  mask (must in order to vote)");
						wearMask = s.nextBoolean();
						if (wearMask) {
							System.out.println("Please type the name of party you would like to vote to : ");
							vote = s.next();
							electionRound.getVoters().get(i).vote(vote);
						} else {
							break;
						}
					} else {
						System.out.println("Please type the name of party you would like to vote to : ");
						vote = s.next();
						electionRound.getVoters().get(i).vote(vote);
					}

				}

			}

		}

	}

	@Override
	public void showElectionsResult(Elections electionRound) {
		electionRound.displayResultInEachKalpi();
		System.out.println();
		electionRound.displayTotalVotes();

	}

	@Override
	public boolean exit(Elections electionRound) {

		try {
			saveToFile(electionRound);
			System.out.println("File saved successfully!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static void saveToFile(Elections electionRound) throws FileNotFoundException, IOException {
		String F_NAME = "binarySave.txt";

		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(F_NAME));

		o.writeObject(electionRound);
		o.close();

	}

	public static Elections readFile() throws FileNotFoundException, IOException, ClassNotFoundException {

		String F_NAME = "binarySave.txt";
		ObjectInputStream i = new ObjectInputStream(new FileInputStream(F_NAME));

		Elections electionRound = (Elections) i.readObject();
		i.close();
		return electionRound;
	}

}
