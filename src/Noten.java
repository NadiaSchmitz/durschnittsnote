import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;

import java.text.DecimalFormat;

public class Noten extends JFrame {
	
	int i, check;
	double[] noten = new double[10];
	double summe, dunrschnitsnote;
	JLabel header, linie;
	JTextField note_1, note_2, note_3;
	JButton button_rechnen;
	JLabel[] labels = new JLabel[10];
	JTextField[] text_fields = new JTextField[10]; 
	
	DecimalFormat df = new DecimalFormat("###.#");
	
	public Noten() {
		
		super("Durschnitsnote");
		super.setBounds(200, 200, 300, 600);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = super.getContentPane();
		container.setLayout(new GridLayout(20, 1, 1, 5));
		getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 20));
		
		header = new JLabel("Geben Sie Ihre Noten ein:");
		container.add(header);
		linie = new JLabel();
		container.add(linie);
		
		for (i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("Lernfeld " + (i + 1));
			container.add(labels[i]);
			text_fields[i] = new JTextField();
			container.add(text_fields[i]);
		}
		
		button_rechnen = new JButton("Berechnen");
		
		container.add(button_rechnen);
		
		button_rechnen.addActionListener(new SendEvent());
	}
	
	class SendEvent implements ActionListener {
		DecimalFormat df = new DecimalFormat("###.#");
		
		public void actionPerformed(ActionEvent e) {
			
			for (i = 0; i < 10; i++) {
				noten[i] = Integer.parseInt(text_fields[i].getText());
				System.out.println(noten[i]);
				summe = summe + noten[i];
			}
			
			dunrschnitsnote = summe / noten.length;
			
			System.out.println("Summe: " + summe);
			System.out.println("Anzahl: " + noten.length);
			System.out.println("Mittel: " + df.format(dunrschnitsnote));
			
			JOptionPane.showMessageDialog(null, "" + df.format(dunrschnitsnote), "Ihre Dunrschnitsnote", JOptionPane.PLAIN_MESSAGE);
			summe = 0;

		}
		
	}
	
}
