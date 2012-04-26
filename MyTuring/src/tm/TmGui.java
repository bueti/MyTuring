package tm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TmGui implements Observer {
	
	private int step;
	
	private JFrame frame;

	private Container contentPane;
	private Container southPane;
	private Container centerPane;
	private Container northPane;

	private JButton nextStepButton;
	private JButton autoButton;
	private JButton resetButton;
	private JLabel band1Label;
	private JLabel stepsLabel;
	private JLabel input1Label;
	private JLabel input2Label;
	private JLabel sleepLabel;
	private JLabel stateLabel;
	private JTextField input1Field;
	private JTextField input2Field;
	private JTextField stepsField;
	private JTextField sleepField;
	private JTextField stateField;
	private JComboBox operatorBox;
	private JTextArea leftArea;
	private JTextArea valueArea;
	private JTextArea rightArea;

	private Multiplication multi;
	private Faculty faculty;
	private Tape tape;
	private TmGui me;

	public TmGui() {
		me = this;
		initGui();
		frame.pack();
		frame.setVisible(true);
		
		step = 0;

	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		String counter = "" + multi.getCounter();
		String state = "" + multi.getCurrentState();
		
		// Left
		leftArea.setText("");
		for (String n : tape.getLeftStack()) {
			leftArea.append(n.toString());
		}
		// Center
		valueArea.setText("[ ");
		valueArea.append(tape.getValue());
		valueArea.append(" ]");
		// Right
		rightArea.setText("");
		for (String n : tape.getRightStack()) {
			rightArea.append(n.toString());
		}
		rightArea.append("1");
		
		// Rest
		stepsField.setText(state);
		stateField.setText(counter);
		frame.pack();
	}
	

	public void initGui() {
		frame = new JFrame("Turing Machine");

		contentPane = frame.getContentPane();
		southPane = new Container();
		centerPane = new Container();
		northPane = new Container();

		contentPane.setLayout(new BorderLayout());

		northPane.setLayout(new FlowLayout());
		centerPane.setLayout(new FlowLayout());
		southPane.setLayout(new FlowLayout());

		// Komponenten
		band1Label = new JLabel("Tape 1:");
		stepsLabel = new JLabel("Steps:");
		stepsField = new JTextField("-");
		leftArea = new JTextArea();
		valueArea = new JTextArea("-");
		rightArea = new JTextArea();
		stateLabel = new JLabel("State:");
		stateField = new JTextField("-");

		input1Label = new JLabel("Input1:");
		input2Label = new JLabel("Input2:");
		sleepLabel = new JLabel("Speed (ms):");
		input1Field = new JTextField();
		input2Field = new JTextField();
		sleepField = new JTextField("250");
		operatorBox = new JComboBox();
		operatorBox.setModel(new DefaultComboBoxModel(new String[] { "*", "!" }));
		
		nextStepButton = new JButton("Next Step");
		autoButton = new JButton("Auto");
		resetButton = new JButton("Reset");

		// ActionHandlers
		nextStepButton.addActionListener(new NextStepActionListener());
		resetButton.addActionListener(new ResetActionListener());
		autoButton.addActionListener(new AutoActionListener());

		// Norden
		northPane.add(band1Label);
		northPane.add(leftArea);
		northPane.add(valueArea);
		northPane.add(rightArea);
		northPane.add(stepsLabel);
		northPane.add(stepsField);
		northPane.add(stateLabel);
		northPane.add(stateField);

		// Zentrum
		centerPane.add(input1Label);
		centerPane.add(input1Field);
		centerPane.add(operatorBox);
		centerPane.add(input2Label);
		centerPane.add(input2Field);

		// S√ºden
		southPane.add(nextStepButton);
		southPane.add(autoButton);
		southPane.add(resetButton);
		southPane.add(sleepLabel);
		southPane.add(sleepField);

		contentPane.add(northPane, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new GridLayout(1, 0, 0, 0));

		contentPane.add(southPane, BorderLayout.SOUTH);

	}

	// Innere Klassen
	private class NextStepActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (step == 0) {
				if (operatorBox.getSelectedItem().equals("*")) {
					step++;
					
					// Initialize Tape
					tape = new Tape(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
					// Neues Multiplikations Objekt
					multi = new Multiplication(tape, true, Integer.parseInt(sleepField.getText().trim()));
					// Multiplikation ausgeben
					multi.multiply();
					
				}
				if (operatorBox.getSelectedItem().equals("!")) {
					System.out.println("Step ! nicht implementiert.");
				}
			} else {
				// goto next step....
			}
		}
	}

	private class AutoActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Multiplikation
			if (operatorBox.getSelectedItem().equals("*")) {
			    new Thread(new Runnable() {
			        public void run() {
        				// Initialize Tape
        				tape = new Tape(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
        				// Neues Multiplikations Objekt
        				multi = new Multiplication(tape, false, Integer.parseInt(sleepField.getText().trim()));
        				multi.addObserver(me);
        				// Multiplikation ausgeben
        				multi.multiply();
			        };
			    }).start();
			}
			
			// Fakult√§t
			if (operatorBox.getSelectedItem().equals("!")) {
				System.out.println("! nicht implementiert.");
			}
		}

	}

	private class ResetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			input1Field.setText("");
			input2Field.setText("");
			stepsField.setText("");
			leftArea.setText("");
			valueArea.setText("");
			rightArea.setText("");
			sleepField.setText("250");
		}

	}


}
