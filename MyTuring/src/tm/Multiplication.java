package tm;

import java.util.Observable;

public class Multiplication extends Observable {

	// "Unendliches" Turingband
	private Tape tape;
	private int counter;
	private String state;
	private int sleep;

	public Multiplication(Tape tape) {
		this.tape = tape;
		if (state == null) {
			state = "q0";
		}
	}

	public boolean step(String nextState) throws InterruptedException {
			setChanged();
			if (nextState.equals("q0"))
				q0();
			if (nextState.equals("q1"))
				q1();
			if (nextState.equals("q2"))
				q2();
			if (nextState.equals("q3"))
				q3();
			if (nextState.equals("q4"))
				q4();
			if (nextState.equals("q5"))
				q5();
			if (nextState.equals("q6"))
				q6();
			if (nextState.equals("q7"))
				q7();
			if (nextState.equals("q8"))
				q8();
			if (nextState.equals("q9"))
				q9();
			if(state.equals("e")) {
				return false;
			}
			notifyObservers(tape.getStack());
		
		return true;
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

	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * States for multiplying with tm
	 * 
	 * @throws InterruptedException
	 */
	private void q0() throws InterruptedException {
		counter++;
		setState("q0");
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();
			setState("q1");
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			setState("q9");
		}
	}

	private void q1() throws InterruptedException {
		counter++;
		setState("q1");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			setState("q1");
		} else {
			tape.setValue("1");
			tape.stepRight();
			setState("q2");
		}
	}

	private void q2() throws InterruptedException {
		counter++;
		setState("q2");
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();
			setState("q3");
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			setState("q7");
		}
	}

	private void q3() throws InterruptedException {
		counter++;
		setState("q3");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			setState("q3");
		} else {
			tape.setValue("1");
			tape.stepRight();
			setState("q4");
		}
	}

	private void q4() throws InterruptedException {
		counter++;
		setState("q4");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			setState("q4");
		} else {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q5");
		}
	}

	private void q5() throws InterruptedException {
		counter++;
		setState("q5");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q5");
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			setState("q6");
		}
	}

	private void q6() throws InterruptedException {
		counter++;
		setState("q6");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q6");
		} else {
			tape.setValue("0");
			tape.stepRight();
			setState("q2");
		}
	}

	private void q7() throws InterruptedException {
		counter++;
		setState("q7");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q7");
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			setState("q8");
		}
	}

	private void q8() throws InterruptedException {
		counter++;
		setState("q8");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q8");
		} else {
			tape.setValue("0");
			tape.stepRight();
			setState("q0");
		}
	}

	private void q9() throws InterruptedException {
		counter++;
		setState("q9");
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			setState("q9");
		} else {
			tape.setValue("1");
			tape.stepRight();
			// Fertig :-)
			setState("e");
		}
	}
}
