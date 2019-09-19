package source;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player1){
				if(key == e.VK_W) {tempObject.setVelY(-10);}
				if(key == e.VK_S) {tempObject.setVelY(10);}
			}
			if(tempObject.getId() == ID.Player2){
				if(key == e.VK_UP) {tempObject.setVelY(-10);}
				if(key == e.VK_DOWN) {tempObject.setVelY(10);}
			}
			
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player1){
				if(key == e.VK_W) {tempObject.setVelY(0);}
				if(key == e.VK_S) {tempObject.setVelY(0);}
			}
			if(tempObject.getId() == ID.Player2){
				if(key == e.VK_UP) {tempObject.setVelY(0);}
				if(key == e.VK_DOWN) {tempObject.setVelY(0);}
			}
			
		}
	}
	
}
