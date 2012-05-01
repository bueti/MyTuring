package tm;

import java.util.Observable;

public class Factorial extends Observable {
	// "Unendliches" Turingband
	private Tape tape;
	private int counter;
	private String state;

	public Factorial(Tape tape) {
		this.tape = tape;
		if (state == null) {
			state = "q1";
		}
	}

	public boolean step(String nextState) {
		setChanged();
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
		if (nextState.equals("q9"))
			q10();
		if (nextState.equals("q9"))
			q11();
		if (nextState.equals("q9"))
			q12();
		if (nextState.equals("q9"))
			q13();
		if (nextState.equals("q9"))
			q14();
		if (nextState.equals("q9"))
			q15();
		if (nextState.equals("q9"))
			q16();
		if (nextState.equals("q9"))
			q17();
		if (nextState.equals("q9"))
			q18();
		if (nextState.equals("q9"))
			q19();
		if (nextState.equals("e")) {
			return false;
		}
		notifyObservers(tape.getStack());

		return true;
	}

	private void q19() {
		// TODO Auto-generated method stub

	}

	private void q18() {
		// TODO Auto-generated method stub

	}

	private void q17() {
		// TODO Auto-generated method stub

	}

	private void q16() {
		// TODO Auto-generated method stub

	}

	private void q15() {
		// TODO Auto-generated method stub

	}

	private void q14() {
		// TODO Auto-generated method stub

	}

	private void q13() {
		// TODO Auto-generated method stub

	}

	private void q12() {
		// TODO Auto-generated method stub

	}

	private void q11() {
		// TODO Auto-generated method stub

	}

	private void q9() {
		// TODO Auto-generated method stub

	}

	private void q10() {
		// TODO Auto-generated method stub

	}

	private void q8() {
		// TODO Auto-generated method stub

	}

	private void q7() {
		// TODO Auto-generated method stub

	}

	private void q6() {
		// TODO Auto-generated method stub

	}

	private void q5() {
		// TODO Auto-generated method stub

	}

	private void q4() {
		// TODO Auto-generated method stub

	}

	private void q3() {
		counter++;
		setState("q3");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			setState("q3");
		} else if (tape.getValue().equals("X")) {
			tape.setValue("X");
			tape.stepRight();
			setState("q1");
		}
	}

	private void q2() {
		counter++;
		setState("q2");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			setState("q2");
		} else if (tape.getValue().equals("_")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			setState("q3");
		}
	}

	private void q1() {
		counter++;
		setState("q1");
		if (tape.getValue().equals("1")) {
			tape.setValue("X");
			tape.stepRight();
			setState("q2");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			setState("q4");
		} else if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			setState("q19");
		}
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

}
