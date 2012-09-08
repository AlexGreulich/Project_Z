import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Spielfeld extends JPanel implements Runnable{
	
	Tileset tileset;
	Spieler spieler;
	Spielfenster fenster;
	Level level;
	ArrayList<Zombie> zombies;
	final int gamespeed = 75; 
	
	public Spielfeld(Spielfenster window){
		fenster = window;
		spieler = fenster.spieler;
		tileset = new Tileset();
		level = new Level();
		
		zombies = new ArrayList<Zombie>();
		Zombie a = new Zombie(20,20);
		Zombie b = new Zombie(18,18);
		zombies.add(a);	
		zombies.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		zeichneKartenAusschnitt(g);
		zeichneSpieler(g);
		zeichneZombies(g);
		//debug
		g.drawString("fenster.ofView.x: "+fenster.ofView.x, 500, 600);
		g.drawString("fenster.ofView.y: "+fenster.ofView.y, 500, 620);
		//...und sonstiges
	}
	
	
	public void zeichneKartenAusschnitt(Graphics g){
		int foVx = fenster.ofView.x;
		int foVy = fenster.ofView.y;
		int rx = 32-foVx, ry = 32-foVy;
		
		for(int x = foVx/32; x < foVx+25; x++){	
			for(int y = foVy/32; y < foVy+25; y++){
				BufferedImage t = tileset.tiles.get(level.tileArray[x][y][0]).image;
				g.drawImage(t, rx, ry, null );	//64
				ry+=32;
			}
			ry = 32-foVy;
			rx+=32;
		}
		
//		for(int x = foVx/32, rx = 32-foVx; x < foVx+25; x++, rx+=32){	
//			for(int y = foVy/32, ry = 32-foVy; y < foVy+25; y++, ry+=32){
//				BufferedImage t = tileset.tiles.get(level.tileArray[x][y]).image;
//				g.drawImage(t, rx, ry, null );	//64
//				if (foVy % 32 == 0){
//					ry +=32;
//				}
//			}
//		}
	}
	
	
	public void zeichneSpieler(Graphics g){
		g.drawImage(spieler.getImage(), spieler.pos_x, spieler.pos_y-16, this);
	}
	
	public void zeichneZombies(Graphics g){
		for(Zombie z: zombies){
			//z.bewegDich();
			g.drawImage(z.getImage(),z.pos_x*32,z.pos_y*32-16,this);
		}
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(700,700);		//?
	}
	
	
		@Override
	public void run() {
		while(true){
			float start = System.currentTimeMillis();
			repaint();
			float gezeichnet = System.currentTimeMillis()-start;
			if(gamespeed > gezeichnet){
				try{
					Thread.sleep(gamespeed - (int)gezeichnet);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			if(fenster.steuerung.wechsel){

			}
		}
	}
}
