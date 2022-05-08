import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class PuzzleModel {

	private int dimensiune; // dimensiunea matricii
	private String[] but; // vectorul de etichete

	PuzzleModel() {

	}

	void setDimensiune(int dim) {
		dimensiune = dim * dim;
		but = new String[dimensiune * dimensiune];
	}

	void interschimbare(int i, int j) {
		String aux;
		aux = but[i];
		but[i] = but[j];
		but[j] = aux;
	}

	void randMat() { // generarea aleatorie a matricii

		int[] v = new int[dimensiune]; // vector de frecventa
		Random rand = new Random();

		/*
		 * int x = rand.nextInt(dimensiune); but[x]=" "; v[x]=1;
		 * 
		 * int i=0; int z;
		 * 
		 * while(i<dimensiune) {
		 * 
		 * do { z = rand.nextInt(dimensiune-1)+1; }while(v[z]==1);
		 * 
		 * if(i!=x) {
		 * 
		 * but[i]=new Integer(z).toString(); v[z]=1;
		 * 
		 * }
		 * 
		 * i++; }
		 * 
		 * 
		 * //but[x]=" "; //v[x]=1;
		 * 
		 */

		int i = 0;
		int z;

		while (i < dimensiune - 1) {

			do {
				z = rand.nextInt(dimensiune - 1) + 1;
			} while (v[z - 1] == 1);

			but[i] = new Integer(z).toString();
			v[z - 1] = 1;
			i++;
		}

		but[dimensiune - 1] = " ";
	}

	Boolean verif() { // functie de verificare

		Integer j;
		for (int i = 0; i < dimensiune - 1; i++) {
			j = new Integer(i + 1);
			if (but[i].compareToIgnoreCase(j.toString()) != 0) {
				return false;
			}
		}

		return true;
	}

	String getElem(int i) { // getter
		return but[i];
	}

	boolean isSolvable() {

		int count = 0;
		for (int i = 0; i < dimensiune - 1; i++)// pana la poz 23
			for (int j = i + 1; j < dimensiune; j++) {

				if (but[i] != " " && but[j] != " " && Integer.parseInt(but[i]) > Integer.parseInt(but[j]))// but[i].compareTo(but[j])>0
					count++;

			}

		return (count % 2 == 0);
	}

}
