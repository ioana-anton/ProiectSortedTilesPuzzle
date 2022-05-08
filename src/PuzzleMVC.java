import java.awt.*;

import javax.swing.*;

public class PuzzleMVC {
	public static void main(String[] args) {

		PuzzleModel model = new PuzzleModel();
		PuzzleView view = new PuzzleView(model);
		PuzzleController controller = new PuzzleController(view, model);
		view.setVisible(true);

	}
}
