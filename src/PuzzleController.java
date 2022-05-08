import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzleController {

	// ... The Controller needs to interact with both the Model and View.

	private PuzzleView v;
	private PuzzleModel model;
	private int mutari=0;
	// ==========================================================
	// constructor
	/** Constructor */
	PuzzleController(PuzzleView m_view, PuzzleModel m_model) {
		model = m_model;
		v = m_view;

		// ... Add listeners to the view.
		v.addDimensiune(new DimensiuneListener());
		v.addBack(new backListener());
	}

	// Cand ii apasat butonul confirm, se va afisa matricea de dimensiunea
	// corespunzatoare

	class backListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String userInput = "";

			v.setContentPane(v.getComplet());
			v.revalidate();
			v.repaint();

		}
	}

	class DimensiuneListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// v.setPanelm(new JPanel()); //resetare matrice

			v.getPanelm().removeAll();
			
			mutari=0;
			v.getCounter().setText("Numar mutari: " +Integer.toString(mutari));
			
			int userInput = v.getDimensiune(); // dimensiunea din combobox
			// v.panelm.add(v.back)
			model.setDimensiune(userInput);

			do {
				model.randMat();
			} while (model.isSolvable() == false);

			v.initMat(userInput * userInput);
			// view.mat[userInput].setText(" ");
			for (int i = 0; i < userInput * userInput; i++) {
				v.getButtons(i).setText(model.getElem(i));
			}

			// setam layout de tip grid inpanel ul pentru matrice cu dimensiunea aleasa
			v.getPanelm().setLayout(new GridLayout(userInput, userInput));
			for (int i = 0; i < userInput * userInput; i++) {
				v.getPanelm().add(v.getButtons(i)); // adaugam butoanele in panel
			}

			v.setJoc();

			v.setContentPane(v.getPanelm3());
			v.revalidate();
			v.repaint();

			for (int i = 0; i < userInput * userInput; i++) {
				v.addButtonsListener(new Buttons(i, userInput), i);
			}

		}
	}

	class Buttons implements ActionListener {

		private int i;
		private int input;

		Buttons(int i, int input) {
			this.i = i;
			this.input = input;
		}

		public void actionPerformed(ActionEvent e) {
			int ok = 0;
			String s= new String("C:\\Users\\ioana\\OneDrive - Technical University of Cluj-Napoca\\Politehnica\\02-An2\\proiecte\\ProiectSortedTilesPuzzle");
			if (i - 1 >= 0 && i - 1 < input * input && (i % input != 0)) {
				if (v.getButtons(i - 1).getText().equals(" ") && ok == 0) {
					v.getButtons(i - 1).setText(v.getButtons(i).getText());
					v.getButtons(i).setText(" ");
					// String aux;
					model.interschimbare(i - 1, i);
					mutari++;
					v.getCounter().setText("Numar mutari: " +Integer.toString(mutari));
					// model.but[i] = " ";

					if (model.verif() == true) {
						for (int i = 0; i < input * input; i++)
							v.getButtons(i).setBackground(new Color(211, 235, 192));

						JLabel label = new JLabel("Ai castigat! Miscari realizate: "+mutari);
						label.setFont(new Font("Arial", Font.ITALIC, 18));

						
						ImageIcon icon = new ImageIcon(s+
								"\\b2.png");

						JOptionPane.showMessageDialog(v, label, "Ecran victorie", JOptionPane.INFORMATION_MESSAGE,
								icon);

						// v.setContentPane(v.complet);
						// v.revalidate();
						// v.dispose();
						v.setContentPane(v.getComplet());
						v.revalidate();
						v.repaint();
					}
					ok = 1;
				}
			}
			if (i + 1 >= 0 && i + 1 < input * input && (i % input != (input - 1))) {
				if (v.getButtons(i + 1).getText().equals(" ") && ok == 0) {
					v.getButtons(i + 1).setText(v.getButtons(i).getText());
					v.getButtons(i).setText(" ");
					mutari++;
					model.interschimbare(i + 1, i);
					v.getCounter().setText("Numar mutari: " +Integer.toString(mutari));
					// model.but[i] = " ";

					if (model.verif() == true) {
						for (int i = 0; i < input * input; i++)
							v.getButtons(i).setBackground(new Color(211, 235, 192));

						JLabel label = new JLabel("Ai castigat! Miscari realizate: "+mutari);
						label.setFont(new Font("Arial", Font.ITALIC, 18));

						
						ImageIcon icon = new ImageIcon(s+
								"\\b2.png");

						JOptionPane.showMessageDialog(v, label, "Ecran victorie", JOptionPane.INFORMATION_MESSAGE,
								icon);
						v.setContentPane(v.getComplet());
						v.revalidate();
						v.repaint();
					}
					ok = 1;
				}
			}
			if (i - input >= 0 && i - input < input * input) {
				if (v.getButtons(i - input).getText().equals(" ") && ok == 0) {
					v.getButtons(i - input).setText(v.getButtons(i).getText());
					v.getButtons(i).setText(" ");
					mutari++;
					model.interschimbare(i - input, i);
					v.getCounter().setText("Numar mutari: " +Integer.toString(mutari));
					// model.but[i] = " ";
					if (model.verif() == true) {
						for (int i = 0; i < input * input; i++)
							v.getButtons(i).setBackground(new Color(211, 235, 192));

							ImageIcon icon = new ImageIcon(
								s+"\\b2.png");

						JLabel label = new JLabel("Ai castigat! Miscari realizate: "+mutari);
						label.setFont(new Font("Arial", Font.ITALIC, 18));

						JOptionPane.showMessageDialog(v, label, "Ecran victorie", JOptionPane.INFORMATION_MESSAGE,
								icon);
						v.setContentPane(v.getComplet());
						v.revalidate();
						v.repaint();
					}
					ok = 1;
				}
			}
			if (i + input >= 0 && i + input < input * input) {
				if (v.getButtons(i + input).getText().equals(" ") && ok == 0) {
					v.getButtons(i + input).setText(v.getButtons(i).getText());
					v.getButtons(i).setText(" ");
					mutari++;
					model.interschimbare(i + input, i);
					v.getCounter().setText("Numar mutari: " +Integer.toString(mutari));
					// model.but[i] = " ";

					if (model.verif() == true) {
						for (int i = 0; i < input * input; i++)
							v.getButtons(i).setBackground(new Color(211, 235, 192));

						JLabel label = new JLabel("Ai castigat! Miscari realizare: "+mutari);
						label.setFont(new Font("Arial", Font.ITALIC, 18));

						ImageIcon icon = new ImageIcon(
								s+"\\b2.png");

						JOptionPane.showMessageDialog(v, label, "Ecran victorie", JOptionPane.INFORMATION_MESSAGE,
								icon);
						v.setContentPane(v.getComplet());
						v.revalidate();
						v.repaint();
					}
					ok = 1;
				}
			}
		}
	}
}
