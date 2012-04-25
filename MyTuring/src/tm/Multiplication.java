package tm;


public class Multiplication {

	// "Unendliches" Turingband
	Tape tape;

	public Multiplication(int a, int b) {
		tape = new Tape(a, b);
	}


	public void multiply() {
		// Now multiply this shit...
		q0();

	}

	private void q0() {
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
		System.out.println("Resultat:");
		tape.printStacks();
	}

}
