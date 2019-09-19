package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int p1score = 0;
	public static int p2score = 0;
	Font scoreFont = new Font("Arial", Font.BOLD, 50);
	
	public void render(Graphics g){
		g.setFont(scoreFont);
		g.setColor(Color.magenta);
		g.drawString("" + p1score, 700, 50);
		g.setColor(Color.cyan);
		g.drawString("" + p2score, 1220, 50);
	}

}
