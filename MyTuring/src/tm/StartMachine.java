package tm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextPane;

public class StartMachine {
	private JFrame frame;
	private JButton loadButton;
	private JButton nextStepButton;
	private JButton autoButton;
	private JButton resetButton;
	private JTextArea band1Area;
	private JTextPane rulePane;
	private JTextPane outputPane;
	
	public StartMachine() {
		initGui();
		frame.setSize(555, 450);
		frame.setVisible(true);
	}
	
	public void initGui() {
		frame = new JFrame("Turing Machine");
		
		Container contentPane = frame.getContentPane();
		Container southPane = new Container(); 
		Container centerPane = new Container();
		Container northPane = new Container();
		
		contentPane.setLayout(new BorderLayout());
		
		northPane.setLayout(new FlowLayout());
		southPane.setLayout(new FlowLayout());
		
		// Komponenten
		band1Area = new JTextArea("Band 1");
		
		loadButton = new JButton("Load");
		nextStepButton = new JButton("Next Step");
		autoButton = new JButton("Auto");
		resetButton = new JButton("Reset");
		
		// Norden
		northPane.add(band1Area);
		
		// Süden
		southPane.add(loadButton);
		southPane.add(nextStepButton);
		southPane.add(autoButton);
		southPane.add(resetButton);
		
		contentPane.add(northPane, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		rulePane = new JTextPane();
		centerPane.add(rulePane);
		
		outputPane = new JTextPane();
		centerPane.add(outputPane);
		
		contentPane.add(southPane, BorderLayout.SOUTH);
		
	}
}
