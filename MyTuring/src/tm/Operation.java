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

//		addition();
		multiply(2, 4);
	}

	public void addition() {
		// Nur als Gedankenstütze, ist in der Aufgabe nicht gefragt
		// Liste befüllen TODO: Tape übernehmen
		// 3 + 2
		tape1.add("#");
		tape1.add("1");
		tape1.add("1");
		tape1.add("1");
		tape1.add("#");
		tape1.add("1");
		tape1.add("1");
		tape1.add("#");
		
		// Calculate
		Iterator<String> itr = tape1.iterator();

		while (itr.hasNext()) {
			if (itr.next().equals("#")) {
				// tu nichts
			}

			if (itr.next().equals("1")) {
				tape2.add("1");
			}

		}

		// Print
		// TODO: Return List
		for (String item : tape2) {
			System.out.print("Addition: " + item);
		}
	}

	public void multiply(int a, int b) {
		// Convert input to unary and fill tape
		tape1.add("#");
		for (int i=1; i<=a; i++) {
			tape1.add("1");
		}
		tape1.add("#");
		for (int i=1; i<=b; i++) {
			tape1.add("1");
		}
		tape1.add("#");
		
		// Now multiply that shit...
		// TODO: DEA für die Multiplikation erstellen und hier implementieren
		
		 // Output
		System.out.print("Multiplikation Tape1: ");
		for (String item : tape1) {
			
			System.out.print(item);
		}
	}
}
