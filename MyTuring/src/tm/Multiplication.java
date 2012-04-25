package tm;

public class Multiplication {

	// "Unendliches" Turingband
	private Tape tape;
	private boolean interactive;
	private int counter;
	private String state;
	private int sleep;

	public Multiplication(Tape tape, boolean steps, int sleep) {
		this.tape = tape;
		this.sleep = sleep;
		setInteractive(steps);
		setCounter(0);
	}

	public void multiply() {
		// Now multiply this shit...
		if (!interactive) {
			try {
				q0();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			// Implement step-by-step method...
			System.out.println("Interactive mode");
			
		}
	}
	
	public String getCurrentState() {
		return state;
	}
	
	private void setCurrentState(String state) {
		this.state = state;
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
	
	/**
	 * States for multiplying with tm
	 * @throws InterruptedException 
	 */
	private void q0() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q1() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q2() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q3() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q4() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q5() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q6() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q7() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q8() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
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

	private void q9() throws InterruptedException {
		counter++;
		setCurrentState(Thread.currentThread().getStackTrace()[2].getMethodName());
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			q9();
		} else {
			tape.setValue("1");
			tape.stepRight();
			// Fertig :-)
			setCurrentState("e");
		}
	}
}
