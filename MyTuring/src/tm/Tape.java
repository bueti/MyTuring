package tm;

import java.util.LinkedList;

public class Tape {

	// Instance Vars
	private LinkedList<String> leftStack;
	private LinkedList<String> rightStack;
	private String value;

	/**
	 * Erstellt ein neues Tape Objekt und befüllt es mit den zwei Params
	 * @param Erste Zahl
	 * @param Zweite Zahl
	 */
	public Tape(int input1, int input2) {
		// Create left and right side of Tape
		leftStack = new LinkedList<String>();
		rightStack = new LinkedList<String>();

		// Initialize Tape
		initializeTape(input1, input2);
	}

	public Tape(int input1) {
		// TODO Auto-generated constructor stub
		leftStack = new LinkedList<String>();
		rightStack = new LinkedList<String>();
		
		initializeTape(input1);
	}

	private void initializeTape(int input1) {
		// Convert input to unary and fill tape
		setValue("1");
		for (int i = 1; i < input1; i++) {
			rightStack.add("1");
		}
		rightStack.add("!");
		rightStack.add("=");
	}

	/**
	 * Konvertiert den Input zu unär und füllt das Band
	 * @param input1
	 * @param input2
	 */
	private void initializeTape(int input1, int input2) {

		// Convert input to unary and fill tape
		setValue("1");
		for (int i = 1; i < input1; i++) {
			rightStack.add("1");
		}
		rightStack.add("$");
		for (int i = 1; i <= input2; i++) {
			rightStack.add("1");
		}
	}

	/**
	 * @return the leftStack
	 */
	public LinkedList<String> getLeftStack() {
		return leftStack;
	}

	/**
	 * @return the rightStack
	 */
	public LinkedList<String> getRightStack() {
		return rightStack;
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
			rightStack.add("$");
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
			leftStack.add("$");
		}
		setValue(leftStack.pollLast());
		
		return getValue();
	}

	/**
	 * Gibt ein komplettes Band zurück
	 * @return Band mit allem drum und dran
	 */
	public LinkedList<String> getStack() {
		LinkedList<String> tmp = new LinkedList<String>();
		for (String item : leftStack) {
			tmp.add(item);
		}
		tmp.add(value);
		for (String item : rightStack) {
			tmp.add(item);
		}
		tmp.add("$");
		
		return tmp;
	}
}
