package tm;

import java.util.Observable;

public class Multiplication extends Observable {

	// "Unendliches" Turingband
	private Tape tape;
	private Machine tm;

	public Multiplication(Tape tape, Machine machine) {
		this.tape = tape;
		this.tm = machine;
	}

	public boolean step(String nextState) {
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
			if(nextState.equals("e")) {
				return false;
			}
			notifyObservers();
		
		return true;
	}

	/**
	 * States for multiplying with tm
	 */
	private void q0() {
		tm.incCounter();;
		tm.setState("q0");
		if (tape.getValue().equals("1")) {
			tape.setValue("$");
			tape.stepRight();
			tm.setState("q1");
		} else {

			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			tm.setState("q9");
		}
	}

	private void q1() {
		tm.incCounter();;
		tm.setState("q1");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			tm.setState("q1");
		} else {
			tape.setValue("$");
			tape.stepRight();
			tm.setState("q2");
		}
	}

	private void q2() {
		tm.incCounter();;
		tm.setState("q2");
		if (tape.getValue().equals("1")) {
			tape.setValue("$");
			tape.stepRight();
			tm.setState("q3");
		} else {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			tm.setState("q7");
		}
	}

	private void q3() {
		tm.incCounter();;
		tm.setState("q3");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			tm.setState("q3");
		} else {
			tape.setValue("$");
			tape.stepRight();
			tm.setState("q4");
		}
	}

	private void q4() {
		tm.incCounter();;
		tm.setState("q4");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			tm.setState("q4");
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q5");
		}
	}

	private void q5() {
		tm.incCounter();;
		tm.setState("q5");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q5");
		} else {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			tm.setState("q6");
		}
	}

	private void q6() {
		tm.incCounter();;
		tm.setState("q6");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q6");
		} else {
			tape.setValue("1");
			tape.stepRight();
			tm.setState("q2");
		}
	}

	private void q7() {
		tm.incCounter();;
		tm.setState("q7");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q7");
		} else {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			tm.setState("q8");
		}
	}

	private void q8() {
		tm.incCounter();;
		tm.setState("q8");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q8");
		} else {
			tape.setValue("1");
			tape.stepRight();
			tm.setState("q0");
		}
	}

	private void q9() {
		tm.incCounter();;
		tm.setState("q9");
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			tm.setState("q9");
		} else {
			tape.setValue("$");
			tape.stepRight();
			// Fertig :-)
			tm.setState("e");
		}
	}
}
