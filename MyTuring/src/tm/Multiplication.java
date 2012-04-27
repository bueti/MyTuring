package tm;

import java.util.Observable;

public class Multiplication extends Observable {

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
				// Obs
				setChanged(); 
				q0();
				 notifyObservers( tape.getStack() );
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
		setChanged(); 
		counter++;
		setCurrentState("q0");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q1();
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q9();
		}
	}

	private void q1() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q1");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q1();
		} else {
			tape.setValue("1");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q2();
		}
	}

	private void q2() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q2");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("1");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q3();
		} else {

			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q7();
		}
	}

	private void q3() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q3");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q3();
		} else {
			tape.setValue("1");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q4();
		}
	}

	private void q4() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q4");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q4();
		} else {

			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q5();
		}
	}

	private void q5() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q5");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q5();
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q6();
		}
	}

	private void q6() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q6");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q6();
		} else {
			tape.setValue("0");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q2();
		}
	}

	private void q7() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q7");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q7();
		} else {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q8();
		}
	}

	private void q8() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q8");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q8();
		} else {
			tape.setValue("0");
			tape.stepRight();
			notifyObservers( tape.getStack() );
			q0();
		}
	}

	private void q9() throws InterruptedException {
		setChanged();
		counter++;
		setCurrentState("q9");
		Thread.sleep(sleep);
		if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.setValue(tape.stepLeft());
			notifyObservers( tape.getStack() );
			q9();
		} else {
			tape.setValue("1");
			tape.stepRight();
			// Fertig :-)
			setCurrentState("e");
			notifyObservers( tape.getStack() );
		}
	}
}
