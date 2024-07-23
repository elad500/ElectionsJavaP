package elections;

import java.io.Serializable;
import java.util.ArrayList;

public class Set<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<T> setList;

	public Set(int votersCapacity) {

		setList = new ArrayList<>(votersCapacity);

	}

	public void add(T t) {

		if (!(this.setList.contains(t))) {
			this.setList.add(t);
		}

	}

	public T get(int index) {

		return this.getSetList().get(index);

	}

	public ArrayList<T> getSetList() {
		return setList;
	}
	
	

}
