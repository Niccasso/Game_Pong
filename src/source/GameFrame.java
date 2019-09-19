package source;

import java.awt.Canvas;

import javax.swing.JFrame;

public class GameFrame extends Canvas {

	private static final long serialVersionUID = -1661678213589291744L;

	public GameFrame(int w, int h, String title, Game game){
		
		//Frame Properties
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(w, h);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setVisible(true);
		
		//Start Game Thread
		game.start();
		
	}
	
}
