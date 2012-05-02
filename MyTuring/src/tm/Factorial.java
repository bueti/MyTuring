package tm;

import java.util.Observable;

public class Factorial extends Observable {
	// "Unendliches" Turingband
	private Tape tape;
	private Machine machine;

	public Factorial(Tape tape, Machine machine) {
		this.tape = tape;
		this.machine = machine;
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
		if (nextState.equals("q10"))
			q10();
		if (nextState.equals("q11"))
			q11();
		if (nextState.equals("q12"))
			q12();
		if (nextState.equals("q13"))
			q13();
		if (nextState.equals("q14"))
			q14();
		if (nextState.equals("q15"))
			q15();
		if (nextState.equals("q16"))
			q16();
		if (nextState.equals("q17"))
			q17();
		if (nextState.equals("q18"))
			q18();
		if (nextState.equals("q19"))
			q19();
		if (nextState.equals("q99")) {
			return false;
		}
		notifyObservers();

		return true;
	}

	private void q19() {
		machine.incCounter();
		machine.setState("q19");
		if (tape.getValue().equals("!") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q17");
		} else if (tape.getValue().equals("1")) {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			machine.setState("q15");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			machine.setState("q99");
		}
	}

	private void q18() {
		machine.incCounter();
		machine.setState("q18");
		if (tape.getValue().equals("X")) {
			tape.setValue("Y");
			tape.stepRight();
			machine.setState("q7");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			machine.setState("q16");
		}
	}

	private void q17() {
		machine.incCounter();
		machine.setState("q17");
		if (tape.getValue().equals("1") || tape.getValue().equals("=") || tape.getValue().equals("!") || tape.getValue().equals("X")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			machine.setState("q17");
		} else if (tape.getValue().equals("Y")) {
			tape.setValue("Y");
			tape.stepRight();
			machine.setState("q18");
		}
	}

	private void q16() {
		machine.incCounter();
		machine.setState("q16");
		if (tape.getValue().equals("1") || tape.getValue().equals("=") || tape.getValue().equals("!") || tape.getValue().equals("X")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q16");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("*");
			tape.setValue(tape.stepLeft());
			machine.setState("q17");
		} else if (tape.getValue().equals("*")) {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			machine.setState("q99");
		}
	}

	private void q15() {
		machine.incCounter();
		machine.setState("q15");
		if (tape.getValue().equals("1") || tape.getValue().equals("=") || tape.getValue().equals("!")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			machine.setState("q15");
		} else if (tape.getValue().equals("Z")) {
			tape.setValue("X");
			tape.setValue(tape.stepLeft());
			machine.setState("q15");
		} else if (tape.getValue().equals("Y")) {
			tape.setValue("Y");
			tape.stepRight();
			machine.setState("q16");
		}
	}

	private void q14() {
		machine.incCounter();
		machine.setState("q14");
		if (tape.getValue().equals("*")) {
			tape.setValue("1");
			tape.stepRight();
			machine.setState("q14");
		} else if (tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q14");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("$");
			tape.setValue(tape.stepLeft());
			machine.setState("q19");
		}
	}

	private void q13() {
		machine.incCounter();
		machine.setState("q13");
		if (tape.getValue().equals("X")) {
			tape.setValue("Y");
			tape.stepRight();
			machine.setState("q7");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			machine.setState("q16");
		}
	}

	private void q12() {
		machine.incCounter();
		machine.setState("q12");
		if (tape.getValue().equals("X")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			machine.setState("q12");
		} else if (tape.getValue().equals("=")) {
			tape.setValue("=");
			tape.setValue(tape.stepLeft());
			machine.setState("q5");
		}
	}

	private void q11() {
		machine.incCounter();
		machine.setState("q11");
		if (tape.getValue().equals("*") || tape.getValue().equals("1")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			machine.setState("q11");
		} else if (tape.getValue().equals("X")) {
			tape.setValue("X");
			tape.stepRight();
			machine.setState("q9");
		}
	}

	private void q10() {
		machine.incCounter();
		machine.setState("q10");
		if (tape.getValue().equals("*") || tape.getValue().equals("1")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q10");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			machine.setState("q11");
		}
	}
	
	private void q9() {
		machine.incCounter();
		machine.setState("q9");
		if (tape.getValue().equals("=")) {
			tape.setValue("=");
			tape.stepRight();
			machine.setState("q9");
		} else if (tape.getValue().equals("*")) {
			tape.setValue("*");
			tape.setValue(tape.stepLeft());
			machine.setState("q12");
		} else if (tape.getValue().equals("1")) {
			tape.setValue("X");
			tape.stepRight();
			machine.setState("q10");
		}
	}

	private void q8() {
		machine.incCounter();
		machine.setState("q8");
		if (tape.getValue().equals("1") || tape.getValue().equals("X")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q8");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			machine.setState("q9");
		}
	}

	private void q7() {
		machine.incCounter();
		machine.setState("q7");
		if (tape.getValue().equals("X")) {
			tape.setValue("Z");
			tape.stepRight();
			machine.setState("q8");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			machine.setState("q14");
		}
	}

	private void q6() {
		machine.incCounter();
		machine.setState("q6");
		if (tape.getValue().equals("X") ) {
			tape.setValue("Y");
			tape.stepRight();
			machine.setState("q13");
		}
	}

	private void q5() {
		machine.incCounter();
		machine.setState("q5");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=") || tape.getValue().equals("X")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			machine.setState("q5");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("$");
			tape.stepRight();
			machine.setState("q6");
		} else if (tape.getValue().equals("Z")) {
			tape.setValue("Z");
			tape.stepRight();
			machine.setState("q7");
		}
	}

	private void q4() {
		machine.incCounter();
		machine.setState("q4");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q4");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("*");
			tape.setValue(tape.stepLeft());
			machine.setState("q5");
		}
	}

	private void q3() {
		machine.incCounter();
		machine.setState("q3");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.setValue(tape.stepLeft());
			machine.setState("q3");
		} else if (tape.getValue().equals("X")) {
			tape.setValue("X");
			tape.stepRight();
			machine.setState("q1");
		}
	}

	private void q2() {
		machine.incCounter();
		machine.setState("q2");
		if (tape.getValue().equals("!") || tape.getValue().equals("1") || tape.getValue().equals("=")) {
			tape.setValue(tape.getValue());
			tape.stepRight();
			machine.setState("q2");
		} else if (tape.getValue().equals("$")) {
			tape.setValue("1");
			tape.setValue(tape.stepLeft());
			machine.setState("q3");
		}
	}

	private void q1() {
		machine.incCounter();
		machine.setState("q1");
		if (tape.getValue().equals("1")) {
			tape.setValue("X");
			tape.stepRight();
			machine.setState("q2");
		} else if (tape.getValue().equals("!")) {
			tape.setValue("!");
			tape.stepRight();
			machine.setState("q4");
		} else if (tape.getValue().equals("0")) {
			tape.setValue("0");
			tape.stepRight();
			machine.setState("q19");
		}
	}

}
