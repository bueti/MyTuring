package tm;


public class Multiplication {

	// "Unendliches" Turingband
	Tape tape;

	public Multiplication(int a, int b) {
		tape = new Tape(a, b);
	}


	public void multiply() {
		// Now multiply this shit...
		System.out.println("\nStart: ");
		tape.printStacks();
		q0();

	}

	private void q0() {
		if(tape.stepRight().equals("1")) {
			tape.setValue("$");
			q1();
		} else {
			tape.stepLeft();
			tape.setValue("$");
			q9();
		}
	}

	private void q1() {
		if (tape.stepRight().equals("1")) {
			tape.setValue("1");
			q1();
		} else {
			tape.setValue("$");
			tape.stepRight();
			q2();
		}
	}
//
	private void q2() {
		if(tape.stepRight().equals("1")) {
			tape.setValue("$");
			q3();
		} else {
			tape.stepLeft();
			tape.setValue("$");
			q7();
		}
	}
//
	private void q3() {
		if(tape.stepRight().equals("1")) {
			tape.setValue("1");
			q3();
		} else {
			tape.stepLeft();
			tape.setValue("$");
			q4();
		}
	}
//
	private void q4() {
		if(tape.stepRight().equals("1")) {
			tape.setValue("1");
			q4();
		}  else {
			tape.stepLeft();
			tape.setValue("1");
			q5();
		}
	}
//
	private void q5() {
		if(tape.stepLeft().equals("1")) {
			tape.setValue("1");
			q5();
		} else {
			tape.setValue("$");
			q6();
		}
	}
//
	private void q6() {
		if(tape.stepLeft().equals("1")) {
			tape.setValue("1");
			q6();
		} else {
			tape.stepRight();
			tape.setValue("1");
			q2();
		}
	}
//
	private void q7() {
		if(tape.stepLeft().equals("1")) {
			tape.setValue("1");
			q7();
		} else {
			tape.setValue("$");
			q8();
		}
	}
//
	private void q8() {
		if(tape.stepLeft().equals("1")) {
			tape.setValue("1");
			q8();
		} else {
			tape.stepRight();
			tape.setValue("1");
			q0();
		}
	}
//
	private void q9() {
		if (tape.stepLeft() == "1") {
			tape.setValue("1");
			q9();
		} else {
			tape.stepRight();
			tape.setValue("$");
			e();
		}
	}

	private void e() {
		// Output
		System.out.println("Resultat:");
		tape.printStacks();
	}

}
