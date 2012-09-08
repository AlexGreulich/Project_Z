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

	final int gamespeed = 130; 
	
	public Spielfeld(Spielfenster window){

		fenster = window;
		spieler = fenster.spieler;
		tileset = new Tileset();
		level = new Level();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Graphics2D g2d = (Graphics2D)g;
		zeichneKartenAusschnitt(g);
		zeichneSpieler(g);
		//...und sonstiges
	}
	
	
	public void zeichneKartenAusschnitt(Graphics g){
		//Graphics2D g2d = (Graphics2D) g;
		
		int ausschnitt_x = fenster.ofView.x;
		int ausschnitt_y = fenster.ofView.y;
		int ausschnitt_ende_x = ausschnitt_x+25,ausschnitt_ende_y = ausschnitt_y+25;
		
		for(int x = ausschnitt_x, rx =0;x < ausschnitt_ende_x;x++,rx++){					
			for(int y = ausschnitt_y, ry =0;y < ausschnitt_ende_y;y++,ry++){					
				BufferedImage t =  tileset.tiles.get(level.tileArray[x][y]).image;
				g.drawImage(t,rx*32,ry*32,null );				//64
			}
		}
	}
	
	
	public void zeichneSpieler(Graphics g){
		//Graphics2D g2d = (Graphics2D) g;
		g.drawImage(spieler.getImage(),spieler.pos_x*32,spieler.pos_y*32-16,this);			//64
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
