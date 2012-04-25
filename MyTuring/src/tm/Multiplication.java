package tm;

public class Multiplication {

	// "Unendliches" Turingband
	private Tape tape;
	private boolean interactive;
	private int counter;

	public Multiplication(Tape tape, boolean steps) {
		this.tape = tape;
		setInteractive(steps);
		setCounter(0);
	}

	public void multiply() {
		// Now multiply this shit...
		if (!interactive) {
			q0();
		} else {
			// Implement step-by-step method...
			System.out.println("Interactive mode");
			
		}
	}

	private void q0() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();

			q1();
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q9();
		}
	}

	private void q1() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();

			q1();
		} else {
			tape.setValue("1");
			tape.stepRight();

			q2();
		}
	}

	private void q2() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();
			q3();
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q7();
		}
	}

	private void q3() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			q3();
		} else {
			tape.setValue("1");
			tape.stepRight();
			q4();
		}
	}

	private void q4() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			q4();
		} else {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q5();
		}
	}

	private void q5() {
		counter++;
		if (tape.getValue().equals("0")) {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q5();
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q6();
		}
	}

	private void q6() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q6();
		} else {
			tape.setValue("0");
			tape.stepRight();
			q2();
		}
	}

	private void q7() {
		counter++;
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q7();
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q8();
		}
	}

	private void q8() {
		counter++;
		if (tape.getValue().equals("0")) {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q8();
		} else {
			tape.setValue("0");
			tape.stepRight();
			q0();
		}
	}

	private void q9() {
		counter++;
		if (tape.getValue().equals("0")) {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q9();
		} else {
			tape.setValue("1");
			tape.stepRight();
			// Fertig :-)
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isInteractive() {
		return interactive;
	}

	public void setInteractive(boolean stepByStep) {
		this.interactive = stepByStep;
	}

}
