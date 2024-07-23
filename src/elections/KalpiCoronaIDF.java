package elections;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KalpiCoronaIDF extends Kalpi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KalpiCoronaIDF(String kalpiAddress, Citizen[] kalpiVoters) {
		super(kalpiAddress, kalpiVoters);
	}

	@Override
	public boolean canVote(Citizen citizen) {

		if (citizen instanceof CitizenWithCoronaVirus) {
			Calendar currentDate = new GregorianCalendar();
			int citizenAge = currentDate.get(Calendar.YEAR) - citizen.getBirthYear();
			if (citizenAge <= 21) {
				return true;
			}
		}

		return false;

	}

}
