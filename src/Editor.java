import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RepaintManager;


public class Editor extends JFrame{
	
	public Karte aktuellekarte;
	Palette palette;	
	KartenAnsicht ansicht;
	
	// Konstruktor
	public Editor(){
		super("Der Editor");
		
		//setSize(1200,1000);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu menu = new JMenu("Karte");
		menubar.add(menu);
		JMenuItem neu = new JMenuItem("neu");
		JMenuItem laden = new JMenuItem("laden");
		JMenuItem speichern = new JMenuItem("Stream speichern");
		JMenuItem streamladen = new JMenuItem("Stream öffnen");
		menu.add(speichern);
		menu.add(laden);
		menu.add(streamladen);
		
		int karte[][] = new int[4000][4000];
		
		speichern.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onSpeichern();
			}
		});
		laden.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onLaden();
			}
		});
		streamladen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				streamLaden();
			}
		});
		
		aktuellekarte = new Karte(karte);
	
		palette = new Palette(this);  //das Tile-Panel
		ansicht = new KartenAnsicht(this);	//das Karten-Panel
		add(palette, BorderLayout.WEST);
		add(ansicht.scroll, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	
	// Menubutton stream laden
	public void streamLaden(){
		try {
			JFileChooser openDialog = new JFileChooser();
			openDialog.showOpenDialog(this);
			FileInputStream datei = new FileInputStream(openDialog.getSelectedFile());
			BufferedInputStream buf = new BufferedInputStream(datei);
			ObjectInputStream lese = new ObjectInputStream(buf);
 
			int[][]karte = (int[][]) lese.readObject();
			//String name=(String) lese.readObject();
			//String dateiname=(String) lese.readObject();
			this.aktuellekarte = new Karte(karte);
			lese.close();
			this.ansicht.changeKarte();
			this.palette.repaint();
			this.ansicht.repaint();
			this.ansicht.scroll.repaint();
			this.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	// Menubutton laden
	public void onLaden(){
		JFileChooser fc=new JFileChooser();
		fc.showOpenDialog(this);
		File f = fc.getSelectedFile();
		/*try {
			Scanner sc = new Scanner(f);
			int [][] ids = new int [4000][4000];
			String 
			while (sc.hasNextInt()){
				
			}
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
		*/
		BufferedImage k;
		int [][] ids = new int [4000][4000];
		try {
			k = ImageIO.read(f);
			for(int x=0; x<k.getWidth();x++){
				for(int y=0; y<k.getHeight();y++){
					Color color = new Color(k.getRGB(x, y));
					
					if((color.getRed()) == 100){
						if(color.getGreen() == 200){
							if(color.getBlue() == 100){
								//gras
								ids[x][y]= 300;
							}
						}
						else if(color.getGreen() == 100){
							/*stein
							 * 0.255.0		81
							 * 0.255.10		80
							 * 0.255.20		82
							 * 0.255.30		61
							 * 0.255.40		101
							 * 0.255.50		60
							 * 0.255.60		62
							 * 0.255.70		100
							 * 0.255.80		102
							 * 0.255.90		64
							 * 0.255.100	63
							 * 0.255.110	44
							 * 0.255.120	43
							 */
									if(color.getBlue() == 0){ids[x][y]= 81;}
									if(color.getBlue() == 10){ids[x][y]= 80;}
									if(color.getBlue() == 20){ids[x][y]= 82;}
									if(color.getBlue() == 30){ids[x][y]= 61;}
									if(color.getBlue() == 40){ids[x][y]= 101;}
									if(color.getBlue() == 50){ids[x][y]= 60;}
									if(color.getBlue() == 60){ids[x][y]= 62;}
									if(color.getBlue() == 70){ids[x][y]= 100;}
									if(color.getBlue() == 80){ids[x][y]= 102;}
									if(color.getBlue() == 90){ids[x][y]= 64;}
									if(color.getBlue() == 100){ids[x][y]= 63;}
									if(color.getBlue() == 110){ids[x][y]= 44;}
									if(color.getBlue() == 120){ids[x][y]= 43;}
						}
					}
					else if(color.getRed() == 255){
						if(color.getGreen() == 255){
							/* sand
					 * 255.255.0	21
					 * 255.255.10	20
					 * 255.255.20	22
					 * 255.255.30	1
					 * 255.255.40	41
					 * 255.255.50	0
					 * 255.255.60	2
					 * 255.255.70	40
					 * 255.255.80	42
					 * 255.255.90	24
					 * 255.255.100	23
					 * 255.255.110	4
					 * 255.255.120	3
					 */ 
							if(color.getBlue() == 0){ids[x][y]= 21;}
							if(color.getBlue() == 10){ids[x][y]= 20;}
							if(color.getBlue() == 20){ids[x][y]= 22;}
							if(color.getBlue() == 30){ids[x][y]= 1;}
							if(color.getBlue() == 40){ids[x][y]= 41;}
							if(color.getBlue() == 50){ids[x][y]= 0;}
							if(color.getBlue() == 60){ids[x][y]= 2;}
							if(color.getBlue() == 70){ids[x][y]= 40;}
							if(color.getBlue() == 80){ids[x][y]= 42;}
							if(color.getBlue() == 90){ids[x][y]= 24;}
							if(color.getBlue() == 100){ids[x][y]= 23;}
							if(color.getBlue() == 110){ids[x][y]= 4;}
							if(color.getBlue() == 120){ids[x][y]= 3;}
						}
	
					}
					else if(color.getRed() == 0){
						if(color.getGreen() == 200){
							 /*  busch
					  * 0.200.0		201
					 * 0.200.10		200
					 * 0.200.20		202
					 * 0.200.30		181
					 * 0.200.40		221
					 * 0.200.50		180
					 * 0.200.60		182
					 * 0.200.70		220
					 * 0.200.80		222
					 * 0.200.90		144
					 * 0.200.100	143	
					 * 0.200.110	124
					 * 0.200.120	123
					 */
							if(color.getBlue() == 0){ids[x][y]= 201;}
							if(color.getBlue() == 10){ids[x][y]= 200;}
							if(color.getBlue() == 20){ids[x][y]= 202;}
							if(color.getBlue() == 30){ids[x][y]= 181;}
							if(color.getBlue() == 40){ids[x][y]= 221;}
							if(color.getBlue() == 50){ids[x][y]= 180;}
							if(color.getBlue() == 60){ids[x][y]= 182;}
							if(color.getBlue() == 70){ids[x][y]= 220;}
							if(color.getBlue() == 80){ids[x][y]= 222;}
							if(color.getBlue() == 90){ids[x][y]= 144;}
							if(color.getBlue() == 100){ids[x][y]= 143;}
							if(color.getBlue() == 110){ids[x][y]= 124;}
							if(color.getBlue() == 120){ids[x][y]= 123;}
						}
						else if(color.getGreen() ==255){
							/*wasser
							 * 100.100.0	141
							 * 100.100.10	140	
							 * 100.100.20	142
							 * 100.100.30	121
							 * 100.100.40	161
							 * 100.100.50	120
							 * 100.100.60	122
							 * 100.100.70	160
							 * 100.100.80	162
							 * 100.100.90	104
							 * 100.100.100	103
							 * 100.100.110	84
							 * 100.100.120	83
							 * */
									if(color.getBlue() == 255){ids[x][y]= 141;}
									if(color.getBlue() == 10){ids[x][y]= 140;}
									if(color.getBlue() == 20){ids[x][y]= 142;}
									if(color.getBlue() == 30){ids[x][y]= 121;}
									if(color.getBlue() == 40){ids[x][y]= 161;}
									if(color.getBlue() == 50){ids[x][y]= 120;}
									if(color.getBlue() == 60){ids[x][y]= 122;}
									if(color.getBlue() == 70){ids[x][y]= 160;}
									if(color.getBlue() == 80){ids[x][y]= 162;}
									if(color.getBlue() == 90){ids[x][y]= 104;}
									if(color.getBlue() == 100){ids[x][y]= 103;}
									if(color.getBlue() == 110){ids[x][y]= 84;}
									if(color.getBlue() == 120){ids[x][y]= 83;}
						}
					}
					/* gras
					 * 100.200.100	300
					 */ 
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 aktuellekarte= new Karte(ids);
		repaint();
	}
	
	
	// Menubutton speichern
	public void onSpeichern(){
		try {
			JFileChooser speicherDialog=new JFileChooser();
			speicherDialog.showSaveDialog(this);
			FileOutputStream datei = new FileOutputStream(speicherDialog.getSelectedFile());
			BufferedOutputStream buf = new BufferedOutputStream(datei);
			ObjectOutputStream schreibe = new ObjectOutputStream(buf);
			schreibe.writeObject(this.aktuellekarte.karte); //schreibt array in textdatei
			//schreibe.writeObject(this.aktuellekarte.kartenName);
			//schreibe.writeObject(this.aktuellekarte.tilesetDateiname);
			schreibe.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*BufferedImage img;
		JFileChooser fc=new JFileChooser();
		fc.showSaveDialog(this);
		File f = fc.getSelectedFile();
		try {
			PrintWriter pw = new PrintWriter(f);
			 
			for(int[] sub: this.aktuellekarte.karte){
				for(int a:sub){
					pw.print(a+",");
				}
				
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	
	// groesse des JFrames
	public Dimension getPreferredSize(){
		return new Dimension(1280,1000);
	}

	
	// Innere Klasse JPanel Tileset
	public class Palette extends JPanel{
		
		Editor edit;
		int aktuellesTile = 0;
		
		public Palette(Editor editor){
			edit = editor;
			setPreferredSize(new Dimension(640,640));
			setDoubleBuffered(true);
			
			this.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					setTileID(e.getX(), e.getY());
				}
			});
		}
		
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			int anzahl = edit.aktuellekarte.images.size();
			int x=0;
			int y=0;
			for(int index =0; index <anzahl;index++){
				BufferedImage bi=edit.aktuellekarte.images.get(index);
				g2d.drawImage(bi, x*32,y*32,this);
				if(index%20==19){
					y++;
					x=0;
				}
				else{
					x++;
				}
			}
		}
		
		public void setTileID(int x, int y){
			int zeile = y/32;
			int spalte = x/32;
			int tileID = zeile*20+spalte;
			if(tileID < edit.aktuellekarte.images.size()){
				aktuellesTile=tileID;
			}
		}
	}
	
	
	// Innere Klasse Karte
	public class Karte{
		int[][] karte;
	 
		ArrayList<BufferedImage> images;
		
		public Karte(int[][]karte){
			this.karte = karte;
			images = new ArrayList<BufferedImage>();
			try{
				BufferedImage tileset = ImageIO.read(getClass().getResource("Tileset_neu_32.gif"));
				for(int x = 0; x < (tileset.getWidth()/32) ;x++){
					for(int y = 0; y < (tileset.getHeight()/32) ;y++){
						BufferedImage bi = tileset.getSubimage(x*32, y*32, 32, 32);
						images.add(bi);
					}
				}
			}catch(IOException e){e.printStackTrace();}
		}
		
		public BufferedImage getTileImage(int x, int y){
			int tile = karte[x][y];
			return images.get(tile);
		}
	 
		public void setTile(int x, int y, int tileID){
			karte[x][y] = tileID;
		}
	}
	
	
	// Innere Klasse Karten-Panel
	public class KartenAnsicht extends JPanel{
		 
		Editor ed;
		JScrollPane scroll = new JScrollPane();
		RepaintManager m;
	 
		public KartenAnsicht(Editor e){
			scroll.setViewportView(this);
			ed = e;
			//verhindert Flackern
			setDoubleBuffered(true);
			changeKarte();
			m = RepaintManager.currentManager(ed);
			
			addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e) {
					zeichneTile(e.getX(), e.getY());
				}			
			});
			addMouseMotionListener(new MouseMotionAdapter(){
				@Override
				public void mouseDragged(MouseEvent e) {
					zeichneTile(e.getX(), e.getY());
				}
			});
		}
	 
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			Rectangle r = g2d.getClipBounds();
			int startx = r.x;
			int starty = r.y;
			int endx = startx+r.width;
			int endy = starty+r.height;
	 
			startx = startx/32;
			starty = starty/32;
			endx = endx/32;
			endy = endy/32;
			
			if(endx < ed.aktuellekarte.karte.length){
				endx++;
			}
	 
			if(endy < ed.aktuellekarte.karte[0].length){
				endy++;
			}
	 
			for(int x=startx;x < endx;x++){
				for(int y=starty;y < endy;y++){
					BufferedImage tile = ed.aktuellekarte.getTileImage(x, y);
					g.drawImage(tile, x*32-1, y*32-24, this);
				}
			}
		}
	 
		public void changeKarte(){
			//Hier wird nun eine Feste größe des JPanel gesetzt.
			int dx = ed.aktuellekarte.karte.length;
			int dy = ed.aktuellekarte.karte[0].length;
			setPreferredSize(new Dimension(dx*32,dy*32));
			scroll.setViewportView(this);
		}
		
		public void zeichneTile(int x, int y){
			x = x/32;
			y = y/32;
			ed.aktuellekarte.karte[x][y] = ed.palette.aktuellesTile;
			Rectangle r=scroll.getViewport().getViewRect();
			int dx=this.scroll.getLocation().x+ed.getInsets().left-r.x;
			int dy=this.scroll.getLocation().y+ed.getInsets().top-r.y;
			m.addDirtyRegion(ed , dx+x*32, dy+y*32, 32, 32);
		}
	}
	
	
	// MAIN
	public static void main(String[] args){
		new Editor();
	}
}
