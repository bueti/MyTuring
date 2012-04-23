package tm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Operation {

	private List<String> tape1;
	private List<String> tape2;

	public Operation() {

	}

	public void initTape(List<String> tape) {
		for (int i = 1; i <= 15; i++) {
			tape.add("#");
		}
	}

	// Nur als Gedankenstütze, ist in der Aufgabe nicht gefragt
	public void addition(int a, int b) {
		tape1 = new LinkedList<String>();
		tape2 = new LinkedList<String>();

		// Tape beschreiben
		for (int i = 1; i <= a; i++) {
			tape1.add("0");
		}
		tape1.add("1");
		for (int i = 1; i <= b; i++) {
			tape1.add("0");
		}

		// Calculate
		Iterator<String> itr = tape1.iterator();

		while (itr.hasNext()) {
			if (itr.next().equals("0")) {
				tape2.add("0");
			}
		}

		// Print
		// TODO: Return List
		System.out.println("Addition:");
		System.out.print("Tape1: ");
		for (String item : tape1) {

			System.out.print(item);
		}
		System.out.print("\nTape2: ");
		for (String item : tape2) {
			System.out.print(item);
		}
	}

	public void multiply(int a, int b) {
		tape1 = new LinkedList<String>();
		tape2 = new LinkedList<String>();

		// Convert input to unary and fill tape
		for (int i = 1; i <= a; i++) {
			tape1.add("0");
		}
		tape1.add("1");
		for (int i = 1; i <= b; i++) {
			tape1.add("0");
		}

		// Now multiply that shit...
		q0();

	}

	private void stepLeft(List<String> tape12) {
		// TODO Auto-generated method stub

	}

	private void stepRight(List<String> tape12) {
		// TODO Auto-generated method stub

	}

	private void setCurrentValue(List<String> tape12, String string) {
		// TODO Auto-generated method stub

	}

	private String getCurrentValue(List<String> tape12) {
		// TODO Auto-generated method stub
		return null;
	}

	private void q0() {
		if (getCurrentValue(tape1) == "0") {
			setCurrentValue(tape1, "1");
			stepRight(tape1);
			q1();
		}
		if (getCurrentValue(tape1) == "1") {
			stepLeft(tape1);
			q9();
		}
	}

	private void q1() {
		if (getCurrentValue(tape1) == "0") {
			stepRight(tape1);
			q1();
		}
		if (getCurrentValue(tape1) == "1") {
			stepRight(tape1);
			q2();
		}
	}

	private void q2() {
		if (getCurrentValue(tape1) == "0") {
			setCurrentValue(tape1, "1");
			stepRight(tape1);
			q3();
		}
		if (getCurrentValue(tape1) == "1") {
			stepLeft(tape1);
			q7();
		}
	}

	private void q3() {
		if (getCurrentValue(tape1) == "1") {
			stepRight(tape1);
			q4();
		}
		if (getCurrentValue(tape1) == "0") {
			stepRight(tape1);
			q3();
		}
	}

	private void q4() {
		if (getCurrentValue(tape1) == "0") {
			stepRight(tape1);
			q4();
		}
		if (getCurrentValue(tape1) == "1") {
			setCurrentValue(tape1, "0");
			stepLeft(tape1);
			q5();
		}
	}

	private void q5() {
		if (getCurrentValue(tape1) == "0") {
			stepLeft(tape1);
			q5();
		}
		if (getCurrentValue(tape1) == "1") {
			stepLeft(tape1);
			q6();
		}
	}

	private void q6() {
		if (getCurrentValue(tape1) == "0") {
			stepLeft(tape1);
			q6();
		}
		if (getCurrentValue(tape1) == "1") {
			setCurrentValue(tape1, "0");
			stepRight(tape1);
			q2();
		}
	}

	private void q7() {
		if (getCurrentValue(tape1) == "0") {
			stepLeft(tape1);
			q7();
		}
		if (getCurrentValue(tape1) == "1") {
			stepLeft(tape1);
			q8();
		}
	}

	private void q8() {
		if (getCurrentValue(tape1) == "0") {
			stepLeft(tape1);
			q8();
		}
		if (getCurrentValue(tape1) == "1") {
			setCurrentValue(tape1, "0");
			stepRight(tape1);
			q0();
		}
	}

	private void q9() {
		if (getCurrentValue(tape1) == "0") {
			stepLeft(tape1);
			q9();
		}
		if (getCurrentValue(tape1) == "1") {
			stepRight(tape1);
			e();
		}
	}

	private void e() {
		System.out.println("Fertig... Mach Ausgabe!");
		// Output
		System.out.println("Multiplikation:");
		System.out.print("Tape1: ");
		for (String item : tape1) {

			System.out.print(item);
		}
		System.out.print("\nTape2: ");
		for (String item : tape2) {
			System.out.print(item);
		}
	}

}
