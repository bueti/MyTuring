package tm;

import java.util.LinkedList;

public class Tape {

	// Instance Vars
	private LinkedList<String> leftStack;
	private LinkedList<String> rightStack;
	private String value;

	// Constructor
	public Tape(int input1, int input2) {
		// Create left and right side of Tape
		leftStack = new LinkedList<String>();
		rightStack = new LinkedList<String>();

		// Initialize Tape
		initializeTape(input1, input2);
	}

	// Methods
	private void initializeTape(int input1, int input2) {
		// Convert input to unary and fill tape
		setValue("0");
		for (int i = 1; i < input1; i++) {
			rightStack.add("0");
		}
		rightStack.add("1");
		for (int i = 1; i <= input2; i++) {
			rightStack.add("0");
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Aktuellen Wert (value) auf den linken Stack schreiben
	 * Falls der rechte Stack nun leer ist, ein Trennzeichen hinzufügen
	 * Neuen aktuellen Wert schreiben
	 * Den letzten Wert löschen
	 */
	public void stepRight() {
		leftStack.add(getValue());
		if (rightStack.isEmpty()) {
			rightStack.add("1");
		}
		setValue(rightStack.getFirst());
		
		rightStack.pop();
		
	}
	
	/**
	 * Aktuellen Wert (value) auf den rechten Stack schreiben
	 * Den aktuellen Wert mit dem vom linken Stack überschreiben
	 * @return den neuen aktuellen Wert zurück geben.
	 */
	public String stepLeft() {
		rightStack.push(getValue());
		if (leftStack.isEmpty()) {
			leftStack.add("1");
		}
		setValue(leftStack.pollLast());
		
		return getValue();
	}

	public void printStacks() {
		for (String item : leftStack) {
			System.out.print(item);
		}
		System.out.print(value);
		for (String item : rightStack) {
			System.out.print(item);
		}
		System.out.println("");
	}
	
	public LinkedList<String> getStack() {
		LinkedList<String> tmp = new LinkedList<String>();
		for (String item : leftStack) {
			tmp.add(item);
		}
		tmp.add(value);
		for (String item : rightStack) {
			tmp.add(item);
		}
		tmp.add("1");
		
		return tmp;
	}
}
