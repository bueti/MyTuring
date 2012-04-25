package tm;


public class Multiplication {

	// "Unendliches" Turingband
	private Tape tape;
	private boolean stepByStep;
	private int counter;

	public Multiplication(int a, int b, boolean steps) {
		tape = new Tape(a, b);
		this.setStepByStep(steps);
		setCounter(0);
	}


	public void multiply() {
		// Now multiply this shit...
		q0();

	}

	private void q0() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("$");
			tape.stepRight();
			
			q1();
		} else {
			
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			q9();
		}
	}

	private void q1() {
		counter++;
		if (tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			
			q1();
		} else {
			tape.setValue("$");
			tape.stepRight();
			
			q2();
		}
	}

	private void q2() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("$");
			tape.stepRight();
			q3();
		} else {
			
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			q7();
		}
	}

	private void q3() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			q3();
		} else {
			tape.setValue("$");
			tape.stepRight();
			q4();
		}
	}

	private void q4() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.stepRight();
			q4();
		}  else {
			
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q5();
		}
	}

	private void q5() {
		counter++;
		if(tape.getValue().equals("1")) {
			
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q5();
		} else {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			q6();
		}
	}

	private void q6() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q6();
		} else {
			tape.setValue("1");
			tape.stepRight();
			q2();
		}
	}

	private void q7() {
		counter++;
		if(tape.getValue().equals("1")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q7();
		} else {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			q8();
		}
	}

	private void q8() {
		counter++;
		if(tape.getValue().equals("1")) {
			
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q8();
		} else {
			tape.setValue("1");
			tape.stepRight();
			q0();
		}
	}

	private void q9() {
		counter++;
		if (tape.getValue().equals("1")) {
			
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			q9();
		} else {
			tape.setValue("$");
			tape.stepRight();
			e();
		}
	}

	private void e() {
		// Output
		System.out.println("Anzahl Steps: " + getCounter());
		System.out.println("Resultat:");
		tape.printStacks();
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public boolean isStepByStep() {
		return stepByStep;
	}


	public void setStepByStep(boolean stepByStep) {
		this.stepByStep = stepByStep;
	}

}
