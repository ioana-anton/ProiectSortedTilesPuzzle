import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PuzzleView extends JFrame {

	private PuzzleModel model = new PuzzleModel();

	private JPanel panelm = new JPanel();
	private JPanel panelm3 = new JPanel();
	private JPanel complet = new JPanel();

	private JButton back = new JButton("Back");
	private JButton[] mat;
	private JButton ok = new JButton("Confirm");

	private JLabel counter=new JLabel();
	
	private String[] dim = { "3", "5", "7" };
	private JComboBox dimensiune = new JComboBox(dim);

	private JTextField dim1 = new JTextField("Choose puzzle size: ");

	PuzzleView(PuzzleModel m) {

		model = m;

		JPanel butoane = new JPanel();
		JPanel empty1 = new JPanel();
		JPanel empty2 = new JPanel();

		complet.setPreferredSize(new Dimension(400, 300));
		empty1.setPreferredSize(new Dimension(100, 300));
		empty2.setPreferredSize(new Dimension(100, 300));
		dimensiune.setPreferredSize(new Dimension(100, 50));
		dim1.setEditable(false);
		ok.setPreferredSize(new Dimension(100, 20));

		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));

		butoane.add(dim1);
		butoane.add(dimensiune);
		butoane.add(ok);

		// Imagini
		String s= new String("C:\\Users\\ioana\\OneDrive - Technical University of Cluj-Napoca\\Politehnica\\02-An2\\proiecte\\ProiectSortedTilesPuzzle");
		JLabel img4 = new JLabel(
				new ImageIcon(s+"\\p61.png"));
		JLabel img5 = new JLabel(
				new ImageIcon(s+"\\p21.png"));
		JLabel img6 = new JLabel(
				new ImageIcon(s+"\\p31.png"));
		JLabel img7 = new JLabel(
				new ImageIcon(s+"\\p51.png"));

		empty1.add(img4);
		empty2.add(img5);
		empty1.add(Box.createRigidArea(new Dimension(100, 145)));
		empty2.add(Box.createRigidArea(new Dimension(100, 80)));
		empty1.add(img6);
		empty2.add(img7);
		empty2.add(Box.createRigidArea(new Dimension(100, 10)));

		complet.setBackground(new Color(250, 242, 135));
		empty1.setBackground(new Color(250, 242, 135));
		empty2.setBackground(new Color(250, 242, 135));
		butoane.setBackground(new Color(250, 242, 135));
		dim1.setBackground(new Color(224, 159, 252));

		complet.add(empty1, BorderLayout.EAST);
		complet.add(butoane, BorderLayout.CENTER);
		complet.add(empty2, BorderLayout.WEST);

		// finalizare
		this.setContentPane(complet);
		this.pack();

		this.setTitle("Sorted Tiles Puzzle");
		// The window closing event should probably be passed to the
		// Controller in a real program, but this is a short example.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// metoda de initializare a matricii de butoane
	void initMat(int dim) {
		mat = new JButton[dim];
		for (int i = 0; i < dim; i++) {
			mat[i] = new JButton(" ");
			mat[i].setForeground(new Color(112, 112, 112));
			mat[i].setBackground(new Color(255, 239, 69));
		}
	}

	// metoda de resetare a JPanel-urilor
	void setJoc() {

		// panelm3 = new JPanel(); //panel pentru matricea de joc + butonul de inapoi
		panelm3.removeAll();
		JPanel pback = new JPanel(); // panel pentru butonul de inapoi
		
		
		back.setForeground(new Color(77, 75, 70));
		counter.setForeground(Color.white);
		pback.setLayout(new FlowLayout());

		pback.setPreferredSize(new Dimension(20, 50));
		panelm.setPreferredSize(new Dimension(100, 500));
		panelm3.setPreferredSize(new Dimension(500, 800));
		pback.add(Box.createRigidArea(new Dimension(180, 0)));
		pback.add(counter);
		pback.add(back);

		panelm3.setLayout(new BoxLayout(panelm3, BoxLayout.Y_AXIS));

		panelm3.add(Box.createRigidArea(new Dimension(0, 10)));
		panelm3.add(pback);
		panelm3.add(panelm);

		panelm3.setBackground(new Color(98, 204, 252));
		pback.setBackground(new Color(98, 204, 252));
		// v.panelm3.setBackground(Color.cyan);
	}

	// Setter & Getter
	public JPanel getPanelm() {// panelul cu matricea de butoane
		return panelm;
	}

	public void setPanelm(JPanel panelm) {
		this.panelm = panelm;
	}

	int getDimensiune() {
		return Integer.parseInt(String.valueOf(dimensiune.getSelectedItem())); // optiunea selectata din combobox
	}

	JButton getButtons(int i) { // unul dintre butoanele matricii
		return mat[i];
	}

	public JPanel getPanelm3() { // panel pentru matricea de butoane + butonul inapoi
		return panelm3;
	}

	public JPanel getComplet() { // panel principal
		return complet;
	}
	
	public JLabel getCounter() {
		return counter;
	}

	// addActionListeners
	void addDimensiune(ActionListener mal) {
		ok.addActionListener(mal);
	}

	void addButtonsListener(ActionListener e, int i) {
		this.mat[i].addActionListener(e);
	}

	void addBack(ActionListener e) {
		back.addActionListener(e);
	}

}
