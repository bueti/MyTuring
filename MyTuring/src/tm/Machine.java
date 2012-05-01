package tm;

public class Machine {

	private String state;
	private int counter;

	public Machine(String state) {
		setState(state);
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCounter() {
		return counter;
	}
	
	public void incCounter() {
		counter++;
	}

	
}
