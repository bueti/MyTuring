package tm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Addition {

	private List<String> tape1;
	private List<String> tape2;
	
	public Addition() {
		tape1 = new LinkedList<String>();
		tape2 = new LinkedList<String>();
		calc();
	}
	
	public void calc() {
		
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
			if(itr.next().equals("#")) {
				// tu nichts
			}
			
			if (itr.next().equals("1")) {
				tape2.add("1");
			}

		} 
		
		// Print
		// TODO: Return List
		for (String item : tape2) {
			System.out.print(item);
		}
	}
}
