package game.ai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class A_Visualization {

	public static A_ a_;
	BufferedImage map;
	private Field[][] f;
	
	public A_Visualization(BufferedImage map) {
		this.map=map;
		a_ = new A_(map);
		f = a_.getMap();
		
//		try {
//			a_.start();
//		} catch (Exception e) {
//		}
	}
	
	public void render(Graphics g) {
		
		
		for (int xx = 0; xx < f.length; xx++) {
			for (int yy = 0; yy < f[xx].length; yy++) {
				switch(f[xx][yy].getFt()) {
				case start: g.setColor(Color.BLUE);
					break;
				case end: g.setColor(Color.RED);
					break;
				case obstacle: g.setColor(Color.DARK_GRAY);
					break;
				case path: g.setColor(Color.CYAN);
					break;
				default: g.setColor(Color.LIGHT_GRAY);
				}
				
				g.fillRect(xx*20, yy*20, 20, 20);
				
			}
		}

		g.setColor(Color.BLACK);
		for(int x = 0; x<map.getWidth(); x++) {
			g.drawLine(x * 20, 0, x * 20, 720);
		}
		
		for(int y = 0; y<map.getHeight(); y++) {
			g.drawLine(0, y * 20, 1280, y*20);
		}
		
		
	}
	
	public void tick() {
		f = a_.getMap();
		a_.tick();
	}
	
	
}