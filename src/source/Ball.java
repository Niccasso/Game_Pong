package source;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject{

	Handler handler;
	
	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velY = 6;
		velX = 15;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 64, 64);
	}

	public void tick() {
		
		x += velX;
		y += velY;
		
		if(x >= 1856){
			velX = -velX;
			HUD.p1score++;
			this.x = 928;
			this.y = 572;
		}
		if(x <= 0){
			velX = -velX; 
		    HUD.p2score++;
			this.x = 928;
			this.y = 572;
		}
		if(y >= 960){velY = -velY;}
		if(y <= 0){velY = -velY;}
		
		collision();
	}
	
	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player1){
				if(getBounds().intersects(tempObject.getBounds())){
					if(tempObject.getVelY() >= 0 && velY <= 0){
						velY = -velY;
					}else if(tempObject.getVelY() < 0 && velY > 0){
						velY = -velY;
					}
					velX = -velX;
				}
			}
			if(tempObject.getId() == ID.Player2){
				if(getBounds().intersects(tempObject.getBounds())){
					if(tempObject.getVelY() >= 0 && velY <= 0){
						velY = -velY;
					}else if(tempObject.getVelY() < 0 && velY > 0){
						velY = -velY;
					}
					velX = -velX;
			    }
			}	
		}	
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 64, 64);
		
	}

}
