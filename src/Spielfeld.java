import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Spielfeld extends Canvas implements Runnable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5227608498854927105L;
	Tileset tileset;
	Spieler spieler;
	Spielfenster fenster;
	Level level;
	ArrayList<Zombie> zombies;
	
	Rectangle zombieradius;
	final int gamespeed = 16; 
	int ausschnittWidth = 650;
	int ausschnittHeight = 650;
	Point p;
	int x_entferntSich;
	int y_entferntSich;
	
	Graphics graphics;
	Graphics2D g2d ;
	BufferStrategy buffer;
	BufferedImage bi;
	
	public Spielfeld(Spielfenster window){
		fenster = window;
		
		//Hier der Tutorial- active-rendering -part
		
		this.setIgnoreRepaint(true);
		
			
			//die graphics- objekte werden auf null gesetzt,
			//später in run() bekommt graphics2d (wenn du es nicht kennst, das ist wie graphics nur aktueller,
			//benutzt doublebuffering und bietet noch mehr möglichkeiten)
			//dann alles was zu zeichnen ist und graphics zeichnet das dann.
			
		graphics =null;
		g2d = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		
		bi = gc.createCompatibleImage(700,700);
		
		
		
		spieler = fenster.spieler;
		tileset = new Tileset();
		level = new Level();
		zombies = level.zombies;//new ArrayList<Zombie>();
		x_entferntSich = 0;
		y_entferntSich = 0;

		zombieradius = new Rectangle(fenster.ofView.x,fenster.ofView.y, ausschnittWidth, ausschnittHeight);
		
		//this.setVisible(true);
		
		
	}
	
	public void zeichnezombies(Graphics g){
		int foVx = fenster.ofView.x ;
		int foVy = fenster.ofView.y;
		
		
		for(int x = foVx/32, rx =-foVx%32; x < foVx/32+25; x++, rx+=32){	
			for(int y = foVy/32, ry = -foVy%32; y < foVy/32+25; y++,ry+=32){
				p = new Point(x,y);
		
				if(fenster.aktZomb.containsKey(p)){
					Zombie z =fenster.aktZomb.get(p);
					BufferedImage zi = z.getImage(); 
					g.drawImage(zi,z.pos_x-rx/32, z.pos_y-ry/32,null); //rx,ry+ x_entferntSich+ y_entferntSich
					//g.drawString("zombie 1. "+ z.pos_x +" "+z.pos_y,500,640);
				}
			}
		}
	}
	
	public void zeichneKartenAusschnitt(Graphics g){
		int foVx = fenster.ofView.x;
		int foVy = fenster.ofView.y;
		
		for(int x = foVx/32, rx =-foVx%32; x < foVx/32+25; x++, rx+=32){	
			for(int y = foVy/32, ry = -foVy%32; y < foVy/32+25; y++,ry+=32){
				BufferedImage t = tileset.tiles.get(level.tileArray[x][y][0]).image;
				g.drawImage(t, rx, ry, null );	//64
			}
		}
	}
	public void zeichneSpieler(Graphics g){
		g.drawImage(spieler.getImage(), spieler.pos_x, spieler.pos_y-16, this);
	}

	
	public Dimension getPreferredSize(){
		return new Dimension(700,700);		//?
	}
	
	
		@Override
	public synchronized void run() {
		this.createBufferStrategy(2);	//Bufferstrategie setzen, 2= double buffer, 3=triple buffer
		buffer = this.getBufferStrategy();
		while(true){
			try{
				float start = System.currentTimeMillis();
				
				
				
				float gezeichnet = System.currentTimeMillis()-start;
				if(gamespeed > gezeichnet){
					try{
						Thread.sleep(gamespeed - (int)gezeichnet);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			
				//buffer leeren
				//hintergrund erstmal auf schwarz
				g2d = bi.createGraphics();
				g2d.setColor(Color.BLACK);
				g2d.fillRect(0,0,700,700);
				
				//alles reinzeichnen
				zeichneKartenAusschnitt(g2d);
				zeichneSpieler(g2d);
				zeichnezombies(g2d);
				
				//debug
				g2d.drawString("fenster.ofView.x: "+fenster.ofView.x, 500, 600);
				g2d.drawString("fenster.ofView.y: "+fenster.ofView.y, 500, 620);
				
				
				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi,0,0,null);
				//das ganze wird nur gezeichnet, wenn zwischendurch nix verloren gegangen ist
				//könnte anscheinend passieren wenn es komplexer wird
				if(!buffer.contentsLost()){
					buffer.show();
				}
				//das fand ich auch interessant bzw kannte ich nicht,
				//der thread wartet bis die anderen fertig sind
				Thread.yield();
				
			}finally {
				//... und alles wieder löschen
				if(graphics != null){
					graphics.dispose();
				}
				if(g2d != null){
					g2d.dispose();
				}
			}
			
			
		}
	}
}
