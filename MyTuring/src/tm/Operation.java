package tm;

import java.util.LinkedList;
import java.util.List;

public class Operation {

	private LinkedList<String> leftStack;
	private LinkedList<String> rightStack;

	public Operation() {

	}

	public void initTape(List<String> tape) {
		for (int i = 1; i <= 15; i++) {
			tape.add("#");
		}
	}

	public void multiply(int a, int b) {
		leftStack = new LinkedList<String>();
		rightStack = new LinkedList<String>();

		// Convert input to unary and fill tape
		for (int i = 1; i <= a; i++) {
			leftStack.add("0");
		}
		leftStack.add("1");
		for (int i = 1; i <= b; i++) {
			leftStack.add("0");
		}
		leftStack.add("1");

		// Debugging Ausgabe
		System.out.println("Hallo");
		for (String value : leftStack) {
			System.out.println(value);
		}
		// Now multiply this shit...
		q0();

	}

	private void q0() {
		if (leftStack.pop() == "0") {
			rightStack.push("1");
			q1();
		} else {
			leftStack.set(0, "0");
			q9();
		}
	}

	private void q1() {
		if (leftStack.pop() == "0") {
			rightStack.push("0");
			q1();
		} else {
			rightStack.push("1");
			q2();
		}
	}

	private void q2() {
		if (leftStack.pop() == "0") {
			rightStack.push("1");
			q3();
		} else {
			leftStack.push("1");
			q7();
		}
	}

	private void q3() {
		if (leftStack.pop() == "0") {
			rightStack.push("0");
			q4();
		} else {
			rightStack.push("1");
			q3();
		}
	}

	private void q4() {
		if (leftStack.pop() == "0") {
			rightStack.push("0");
			q4();
		} else {
			leftStack.push("0");
			q5();
		}
	}

	private void q5() {
		if (leftStack.pop() == "0") {
			leftStack.push("0");
			q5();
		} else {
			leftStack.push("1");
			q6();
		}
	}

	private void q6() {
		if (leftStack.pop() == "0") {
			leftStack.push("0");
			q6();
		} else {
			rightStack.push("0");
			q2();
		}
	}

	private void q7() {
		if (leftStack.pop() == "0") {
			leftStack.push("0");
			q7();
		} else {
			leftStack.push("1");
			q8();
		}
	}

	private void q8() {
		if (leftStack.pop() == "0") {
			leftStack.push("0");
			q8();
		} else {
			rightStack.push("0");
			q0();
		}
	}

	private void q9() {
		if (leftStack.pop() == "0") {
			leftStack.push("0");
			q9();
		} else {
			rightStack.push("1");
			e();
		}
	}

	private void e() {
		// Output
		System.out.println("Multiplikation:");
		System.out.print("links: ");
		for (String item : leftStack) {

			System.out.print(item);
		}

		System.out.print("rechts: ");
		for (String item : rightStack) {
			System.out.print(item);
		}
	}

}
