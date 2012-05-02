package tm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TmGui implements Observer {

	private JFrame frame;

	private Container contentPane;
	private Container northPane;
	private Container centerPane;
	private Container southPane;

	private JButton nextStepButton;
	private JButton autoButton;
	private JButton resetButton;
	private JLabel band1Label;
	private JLabel stepsLabel;
	private JLabel sleepLabel;
	private JLabel stateLabel;
	private JLabel resultatLabel;
	private JTextField resultatField;
	private JTextField input1Field;
	private JTextField input2Field;
	private JTextField stepsField;
	private JTextField sleepField;
	private JTextField stateField;
	private JComboBox operatorBox;
	private JTextArea leftArea;
	private JTextArea valueArea;
	private JTextArea rightArea;
	private BufferedImage stateImage;
	private JLabel stateImageLabel;

	private Multiplication multi;
	private Factorial fact;
	private Tape tape;
	private TmGui me;
	private Machine machine;
	private String type;

	private Container southNorthPane;
	private Container southSouthPane;

	public TmGui() {
		me = this;
		initGui();
		frame.pack();
		frame.setVisible(true);

	}

	public void updateGui() {
		String steps = "" + machine.getCounter();
		String state = "" + machine.getState();

		// Left
		leftArea.setText("$$$$$");
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
		rightArea.append("$$$$$");

		// Rest
		stepsField.setText(steps);
		stateField.setText(state);
		
		// Bild
		try {
			stateImage = ImageIO.read(new File("./images/" + type + "/" + machine.getState() +".png"));
			stateImageLabel.setIcon(new ImageIcon( stateImage ));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.pack();
	}
	
	public void printResultat() {
		int resultat = 0;
		for (String n : tape.getStack()) {
			if(n.equals("1"))
				resultat++;
		}
		// Ugly Hack
		if(type.equals("multi")) {
			resultat = resultat - Integer.parseInt(input1Field.getText()) - Integer.parseInt(input2Field.getText());
			resultatField.setText("" + resultat);
		} else {
			resultatField.setText("" + resultat);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	    try {
//	    	SwingUtilities.invokeLater(new Runnable() {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    updateGui();	            
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public void startMultiAuto() {
		new Thread(new Runnable() {
			public void run() {
				// Initialize Tape
				machine = new Machine("q0");
				tape = new Tape(Integer.parseInt(input1Field.getText()),
						Integer.parseInt(input2Field.getText()));
				// Neues Multiplikations Objekt
				multi = new Multiplication(tape, machine);
				multi.addObserver(me);
				// Multiplikation ausgeben
				try {
					while (multi.step(machine.getState())) {
						Thread.sleep(Integer.parseInt(sleepField.getText()
								.trim()));
					}
					resetButton.setEnabled(true);
					autoButton.setEnabled(true);
					nextStepButton.setEnabled(true);
					printResultat();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}).start();
	}

	public void startMultiSingle() {
		new Thread(new Runnable() {
			public void run() {
				multi.addObserver(me);
				// Multiplikation ausgeben
				multi.step(machine.getState());
				resetButton.setEnabled(true);
				autoButton.setEnabled(true);
				nextStepButton.setEnabled(true);
			};
		}).start();
	}

	public void startFactorialAuto() {
		new Thread(new Runnable() {
			public void run() {
				machine = new Machine("q1");
				// Initialize Tape
				tape = new Tape(Integer.parseInt(input1Field.getText()));
				// Neues Multiplikations Objekt
				fact = new Factorial(tape, machine);
				fact.addObserver(me);
				// Multiplikation ausgeben
				try {
					while (fact.step(machine.getState())) {
						Thread.sleep(Integer.parseInt(sleepField.getText()
								.trim()));
					}
					resetButton.setEnabled(true);
					autoButton.setEnabled(true);
					nextStepButton.setEnabled(true);
					printResultat();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}).start();
	}
	
	public void startFactorialSingle() {
		new Thread(new Runnable() {
			public void run() {
				fact.addObserver(me);
				// Multiplikation ausgeben
				fact.step(machine.getState());
				resetButton.setEnabled(true);
				autoButton.setEnabled(true);
				nextStepButton.setEnabled(true);
			};
		}).start();
	}

	public void initGui() {
		frame = new JFrame("Turing Machine");

		contentPane = frame.getContentPane();
		northPane = new Container();
		centerPane = new Container();
		southPane = new Container();
		southNorthPane = new Container();
		southSouthPane = new Container();

		contentPane.setLayout(new BorderLayout());

		northPane.setLayout(new FlowLayout());
		centerPane.setLayout(new FlowLayout());
		southPane.setLayout(new BorderLayout());
		southNorthPane.setLayout(new FlowLayout());

		// Komponenten
		band1Label = new JLabel("Tape 1:");
		stepsLabel = new JLabel("Steps:");
		stepsField = new JTextField("-");
		leftArea = new JTextArea();
		valueArea = new JTextArea("-");
		rightArea = new JTextArea();
		stateLabel = new JLabel("State:");
		stateField = new JTextField("-");
		resultatLabel = new JLabel("Resultat:");
		resultatField = new JTextField("-");

		sleepLabel = new JLabel("Speed (ms):");
		input1Field = new JTextField();
		input2Field = new JTextField();
		sleepField = new JTextField("250");
		operatorBox = new JComboBox();
		operatorBox.setModel(new DefaultComboBoxModel(new String[] { "*", "!" }));

		nextStepButton = new JButton("Next Step");
		autoButton = new JButton("Auto");
		resetButton = new JButton("Reset");
		
		
		stateImageLabel = new JLabel(new ImageIcon("./images/turingMachine.gif"));

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
		northPane.add(resultatLabel);
		northPane.add(resultatField);

		// Zentrum
		centerPane.add(input1Field);
		centerPane.add(operatorBox);
		centerPane.add(input2Field);
		centerPane.setLayout(new GridLayout(1, 0, 0, 0));

		// Süden
		southNorthPane.add(nextStepButton);
		southNorthPane.add(autoButton);
		southNorthPane.add(resetButton);
		southNorthPane.add(sleepLabel);
		southNorthPane.add(sleepField);
		southPane.add(southNorthPane, BorderLayout.NORTH);
		southSouthPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		southSouthPane.add(stateImageLabel);
		southPane.add(southSouthPane, BorderLayout.SOUTH);

		contentPane.add(northPane, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		contentPane.add(southPane, BorderLayout.SOUTH);

	}

	// Innere Klassen
	private class NextStepActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			autoButton.setEnabled(false);
			resetButton.setEnabled(false);
			// Multiplikation
			if (operatorBox.getSelectedItem().equals("*")) {
				type = "multi";
				// Initialize Machine, Tape and Multiplication if not already done
				if (machine == null)
					machine = new Machine("q0");
				if (tape == null)
					tape = new Tape(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
				if (multi == null)
					multi = new Multiplication(tape, machine);

				// Bild laden
				try {
					stateImage = ImageIO.read(new File("./images/" + type + "/q0.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Start Multiplication	
				startMultiSingle();
				printResultat();
			}

			// Fakultät
			if (operatorBox.getSelectedItem().equals("!")) {
				type = "fact";
				input2Field.setVisible(false);
				if (machine == null)
					machine = new Machine("q1");
				if (tape == null) {
					tape = new Tape(Integer.parseInt(input1Field.getText()));
				}
				if (fact == null)
					fact = new Factorial(tape, machine);
			
				// Bild laden
				try {
					stateImage = ImageIO.read(new File("./images/" + type + "/q1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Start Factorial	
				startFactorialSingle();
			}
		}

	}

	private class AutoActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			autoButton.setEnabled(false);
			resetButton.setEnabled(false);
			nextStepButton.setEnabled(false);
			// Multiplikation
			if (operatorBox.getSelectedItem().equals("*")) {
				type = "multi";
				// Bild laden
				try {
					stateImage = ImageIO.read(new File("./images/" + type + "/q0.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stateImageLabel.setVisible(true);
				// Multiplikation starten
				startMultiAuto();
			}

			// Fakultät
			if (operatorBox.getSelectedItem().equals("!")) {
				type = "fact";
				input2Field.setVisible(false);
				// Bild laden
				try {
					stateImage = ImageIO.read(new File("./images/" + type + "/q1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stateImageLabel.setVisible(true);
				// Fakultät starten
				startFactorialAuto();
				printResultat();
			}
		}

	}

	private class ResetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			input1Field.setText("");
			input2Field.setText("");
			stepsField.setText("");
			stateField.setText("");
			leftArea.setText("");
			valueArea.setText("");
			rightArea.setText("");
			resultatField.setText("");
			sleepField.setText("250");
			stateImageLabel.setIcon(new ImageIcon("./images/turingMachine.gif"));
			frame.pack();
			input2Field.setVisible(true);
			autoButton.setEnabled(true);
			nextStepButton.setEnabled(true);
	
		}

	}
}
