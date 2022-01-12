import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;

import java.text.DecimalFormat;

public class Noten extends JFrame {
	
	int i, anzahl;
	double[] noten = new double[20];
	double summe, dunrschnitsnote;
	JLabel header, linie;
	JButton button_rechnen;
	JLabel[] labels = new JLabel[20];
	JTextField[] text_fields = new JTextField[20]; 
	
	DecimalFormat df = new DecimalFormat("###.#");
	
	public Noten() {
		
		super("Durschnitsnote");
		super.setBounds(200, 200, 350, 600);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = super.getContentPane();
		container.setLayout(new GridLayout(22, 1, 1, 5));
		getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 20, 40, 20));
		
		header = new JLabel("Geben Sie Ihre Noten ein:");
		container.add(header);
		linie = new JLabel(" ");
		container.add(linie);
		
		for (i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("Lernfeld " + (i + 1) + "     1-5");
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
			
			summe = 0;
			
			for (i = 0; i < 20; i++) {
				
				if (text_fields[i].getText().equals("")) {
					noten[i] = 0;
				} else {
					noten[i] = Integer.parseInt(text_fields[i].getText());
				}
				System.out.println(noten[i]);
				summe = summe + noten[i];
				
				if (noten[i] > 0) {
					anzahl = anzahl + 1;
				}
			}
			
			dunrschnitsnote = summe / anzahl;
			
			System.out.println("Summe: " + summe);
			System.out.println("Anzahl: " + anzahl);
			System.out.println("Mittel: " + df.format(dunrschnitsnote));
			
			JOptionPane.showMessageDialog(null, "" + df.format(dunrschnitsnote), "Ihre Dunrschnitsnote", JOptionPane.PLAIN_MESSAGE);
			summe = 0;
			anzahl = 0;

		}
		
	}
	
}
