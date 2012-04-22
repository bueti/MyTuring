package tm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartMachine {
	private JFrame frame;
	private JButton loadButton;
	private JButton nextStepButton;
	private JButton autoButton;
	private JButton resetButton;
	private JLabel input1Label;
	private JLabel input2Label;
	private JTextField input1Field;
	private JTextField input2Field;
	private JComboBox operatorBox;
	private JTextArea band1Area;

	private Operation oper;
	
	public StartMachine() {
		
		initGui();
		// frame.setSize(555, 450);
		frame.pack();
		frame.setVisible(true);
		oper = new Operation();
	}

	public void initGui() {
		frame = new JFrame("Turing Machine");

		Container contentPane = frame.getContentPane();
		Container southPane = new Container();
		Container centerPane = new Container();
		Container northPane = new Container();

		contentPane.setLayout(new BorderLayout());

		northPane.setLayout(new FlowLayout());
		centerPane.setLayout(new FlowLayout());
		southPane.setLayout(new FlowLayout());

		// Komponenten
		band1Area = new JTextArea("Band 1");

		input1Label = new JLabel("Input1: ");
		input2Label = new JLabel("Input2: ");
		input1Field = new JTextField();
		input2Field = new JTextField();
		operatorBox = new JComboBox();
		operatorBox.setModel(new DefaultComboBoxModel(new String[] { "+", "*", "!" }));

		loadButton = new JButton("Load");
		nextStepButton = new JButton("Next Step");
		autoButton = new JButton("Auto");
		resetButton = new JButton("Reset");
		
		// ActionHandlers
		loadButton.addActionListener(new LoadActionListener());
		nextStepButton.addActionListener(new NextStepActionListener());
		resetButton.addActionListener(new ResetActionListener());
		autoButton.addActionListener(new AutoActionListener());

		// Norden
		northPane.add(band1Area);

		// Zentrum
		centerPane.add(input1Label);
		centerPane.add(input1Field);
		centerPane.add(operatorBox);
		centerPane.add(input2Label);
		centerPane.add(input2Field);

		// Süden
		southPane.add(loadButton);
		southPane.add(nextStepButton);
		southPane.add(autoButton);
		southPane.add(resetButton);

		contentPane.add(northPane, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new GridLayout(1, 0, 0, 0));

		contentPane.add(southPane, BorderLayout.SOUTH);

	}
	
	// Innere Klassen
	private class LoadActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class NextStepActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class ResetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	private class AutoActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(operatorBox.getSelectedItem().equals("+") ) {
				oper.addition(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
			}
			if(operatorBox.getSelectedItem().equals("*") ) {
				oper.multiply(Integer.parseInt(input1Field.getText()), Integer.parseInt(input2Field.getText()));
			}
			if(operatorBox.getSelectedItem().equals("!") ) {
				System.out.println("! nicht implementiert.");
			}
		}
		
	}
}
