package tm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Operation {

	private List<String> tape1;
	private List<String> tape2;

	public Operation() {
		tape1 = new LinkedList<String>();
		tape2 = new LinkedList<String>();

//		addition(2,3);
//		multiply(2, 4);
	}

	public void initTape(List<String> tape) {
		for (int i=1; i<=15; i++) {
			tape.add("#");
		}
	}
	
	public void addition(int a, int b) {
		// Nur als Gedankenstütze, ist in der Aufgabe nicht gefragt
		// Liste befüllen TODO: Tape übernehmen
		// 3 + 2
		initTape(tape1);
		for (int i=1; i<=a; i++) {
			tape1.add("0");
		}
		tape1.add("1");
		for (int i=1; i<=b; i++) {
			tape1.add("0");
		}
		initTape(tape1);
		
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
		// Convert input to unary and fill tape
		initTape(tape1);
		for (int i=1; i<=a; i++) {
			tape1.add("0");
		}
		tape1.add("1");
		for (int i=1; i<=b; i++) {
			tape1.add("0");
		}
		initTape(tape1);
		
		// Now multiply that shit...
		// TODO: DEA für die Multiplikation erstellen und hier implementieren
		
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
