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
	BufferedImage map;
	Map<Point,BufferedImage> tileMap;
	final int gamespeed =10; 
	ArrayList<Karte> karten;
	BufferedImage grosseKarte;
	int kartenID;
	
	public Spielfeld(Spielfenster window){
		grossekarteladen();
		tileset = new Tileset();
		fenster = window;
		spieler = fenster.spieler;
		
		kartenID=19;
		level = new Level(karten.get(kartenID));
		
		level.karteAuslesen();
		
		tileMap = level.map_mit_tiles;
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
				Point p = new Point(x,y);
				BufferedImage t =  tileMap.get(p);
				g.drawImage(t,rx*32,ry*32,null );				//64
			}
			
		}
		
	}
	public void zeichneSpieler(Graphics g){
		//Graphics2D g2d = (Graphics2D) g;
		g.drawImage(spieler.getImage(),spieler.pos_x*32,spieler.pos_y*32-16,this);			//64
	}
	public Dimension getPreferredSize(){
		return new Dimension(800,800);		//?
	}

	public void levelWechsel(){
		
		if(spieler.amRandlinks){
			if(karten.get(kartenID).links !=null){
				Level neu = new Level(karten.get(kartenID-20));
				level = neu;
				level.karteAuslesen();
				
				tileMap = level.map_mit_tiles;
			}
		}
		if(spieler.amRandrechts){
			if(karten.get(kartenID).rechts !=null){
				Level neu = new Level(karten.get(kartenID+20));
				level = neu;
				level.karteAuslesen();
				
				tileMap = level.map_mit_tiles;
			}
		}
		if(spieler.amRandoben){
			if(karten.get(kartenID).oben !=null){
				Level neu = new Level(karten.get(kartenID-1));
				level = neu;
				level.karteAuslesen();
				
				tileMap = level.map_mit_tiles;
			}
		}
		if(spieler.amRandunten){
			if(karten.get(kartenID).unten !=null){
				
				Level neu = new Level(karten.get(kartenID+1));
				level = neu;
				level.karteAuslesen();
				
				tileMap = level.map_mit_tiles;
			}
		}
		
		
		
	}
	
	public void grossekarteladen(){
		
		this.karten = new ArrayList<Karte>();
		int id=0;
		try{
			grosseKarte = ImageIO.read(getClass().getResource("grossekarte.gif"));
		}catch(IOException e){
			e.printStackTrace();
		}
		for(int x=0;x<20;x++){
			for(int y=0;y<20;y++){
				
				Karte k = new Karte();
				k.ID = id;
				k.img = grosseKarte.getSubimage(x*200, y*200, 200, 200);
				
				
				if(x*200<=0){
					k.links = null;
				}
				if(x*200 >= grosseKarte.getWidth()){
					k.rechts =null;
				}
				if(y*200 <= 0){
					k.oben = null;
				}
				if(y*200 >= grosseKarte.getHeight()){
					k.unten =null;
				}
				karten.add(k);
				id++;
			}
		}
		
		for (Karte k : karten){
			if(k.oben != null){
				k.oben = karten.get(k.ID-1);
			}
			if(k.unten != null){
				k.unten = karten.get(k.ID+1);
			}
			if(k.rechts != null){
				k.rechts = karten.get(k.ID+20);
			}
			if(k.links != null){
				k.links = karten.get(k.ID-20);
			}
		}
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
				levelWechsel();
			}
		}
	}
}
