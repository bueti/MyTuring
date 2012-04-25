package tm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TmGui {
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
	private JTextField input1Field;
	private JTextField input2Field;
	private JTextField stepsField;
	private JComboBox operatorBox;
	private JTextArea band1Area;

	private Multiplication multi;
	private Faculty faculty;
	private Tape tape;

	public TmGui() {

		initGui();
		// frame.setSize(555, 450);
		frame.pack();
		frame.setVisible(true);

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
		stepsField = new JTextField();
		band1Area = new JTextArea();

		input1Label = new JLabel("Input1: ");
		input2Label = new JLabel("Input2: ");
		input1Field = new JTextField();
		input2Field = new JTextField();
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
		northPane.add(band1Area);
		northPane.add(stepsLabel);
		northPane.add(stepsField);

		// Zentrum
		centerPane.add(input1Label);
		centerPane.add(input1Field);
		centerPane.add(operatorBox);
		centerPane.add(input2Label);
		centerPane.add(input2Field);

		// Süden
		southPane.add(nextStepButton);
		southPane.add(autoButton);
		southPane.add(resetButton);

		contentPane.add(northPane, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new GridLayout(1, 0, 0, 0));

		contentPane.add(southPane, BorderLayout.SOUTH);

	}

	// Innere Klassen
	private class NextStepActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			band1Area.setText("");
			if (operatorBox.getSelectedItem().equals("*")) {
				System.out.println("Step * nicht implementiert.");

			}
			if (operatorBox.getSelectedItem().equals("!")) {
				System.out.println("Step ! nicht implementiert.");
			}

		}

	}

	private class AutoActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			band1Area.setText("");
			// Multiplikation
			if (operatorBox.getSelectedItem().equals("*")) {
				// Initialize Tape
				tape = new Tape(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
				// Neues Multiplikations Objekt
				multi = new Multiplication(tape, false);
				// Multiplikation ausgeben
				multi.multiply();
				
				for (String n : tape.getStack()) {
					band1Area.append(n.toString());
				}
				stepsField.setText("" + multi.getCounter());
			}
			
			// Fakultät
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
			band1Area.setText("");
		}

	}
}
