package source;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private boolean running = false;
	private Thread thread;
	private final int WIDTH = 1920, HEIGHT = 1080;
	private final String TITLE = "Pong";
	private Handler handler;
	private HUD hud;
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new GameFrame(WIDTH, HEIGHT, TITLE, this);
		
		hud = new HUD();
		
		setFocusable(true);
		requestFocus();
		
		handler.addObject(new Ball(928, 572, ID.Ball, handler));
		handler.addObject(new Player(100, 412, ID.Player1, handler));
		handler.addObject(new Player(1810, 412, ID.Player2, handler));
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
		
	public static void main(String[] args) {
		new Game();	
	}

}
