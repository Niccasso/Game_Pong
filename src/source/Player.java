package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 10, 256);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 5){y = 5;}
		if(y >= 758){y = 758;}
	}

	public void render(Graphics g) {
		if(getId() == ID.Player1){g.setColor(Color.magenta);}
		else if(getId() == ID.Player2){g.setColor(Color.cyan);}
		g.fillRect(x, y, 10, 256);
		
	}

}
