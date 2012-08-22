import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;


public class Level {
	
	BufferedImage kartenbild;
	int[][] tileIDs;
	
	ArrayList<Tile> tiles;
	BufferedImage tileset;
	
	Map<Point,BufferedImage> map_mit_tiles;
	
	Color grass = new Color(100,200,100);
	
	
	
	public Level(Karte karte){
		kartenbild = karte.img;
		
		try {
			tileset = ImageIO.read(new File("F:\\DerWorkspace\\Zombie\\src\\Tileset2_32px.gif"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * karte = karten.get(i);
		 * 
		
			String path = ("F:\\DerWorkspace\\Zombie\\src\\karten\\001.gif");
			File file = new File(path);
			//tileset = ImageIO.read(new File("C:\\Users\\jennifer\\Dropbox\\eclipse\\ZombieGame\\images\\Tileset.png"));
			//tileset = ImageIO.read(new File("F:\\DerWorkspace\\Zombie\\src\\Tileset2.gif"));
			
			karte = ImageIO.read(file);
			//karte = ImageIO.read(new File("C:\\Users\\jennifer\\Dropbox\\eclipse\\ZombieGame\\images\\dieerstekarte.png");
			
		} */
		//karte = 
		tilesetLaden(tileset);
		karteAuslesen();
	}
	public void tilesetLaden(BufferedImage set){
		this.tiles = new ArrayList<Tile>();
		int Anzahl_x = set.getWidth()/32;		//64
		int Anzahl_y = set.getHeight()/32;		//64
		
		for(int x=0;x<Anzahl_x;x++){
			for(int y=0;y<Anzahl_y;y++){
				
				Tile t = new Tile((set.getSubimage(x*32, y*32, 32, 32)));		//64
				
				tiles.add(t);
			}
		}
	}
	public int getID(int x, int y){
		return tileIDs[x][y];
	}
	
	public void karteAuslesen(){
		map_mit_tiles = new HashMap<Point,BufferedImage>(); 
				
		for(int x = 0;x<kartenbild.getWidth();x++){
			for(int y = 0;y<kartenbild.getHeight();y++){
				
				Point pt = new Point(x,y);
				Color c = new Color(kartenbild.getRGB(x,y));
			
				if(c.equals(grass)){
					map_mit_tiles.put(pt,tiles.get(120).getImage());
				}
				if(c.getRed()==255){
					if(c.getGreen()==255){
						
						//sand
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(11).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(10).getImage());//oben
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(12).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(1).getImage());//links
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(21).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(0).getImage());//lioben
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(2).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(20).getImage());//reoben
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(22).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(14).getImage());//gras_lioben
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(13).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(4).getImage());//gras_reoben
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(3).getImage());
						}
					}
				}else if(c.getRed()==0){
					if(c.getGreen()==200){
						
						//busch
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(101).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(100).getImage());
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(102).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(91).getImage());
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(111).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(90).getImage());
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(92).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(110).getImage());
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(112).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(74).getImage());
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(73).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(64).getImage());
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(63).getImage());
						}
						
					}
					if(c.getGreen()==255){
						
						//wasser
						
						if(c.getBlue()==255)		 {map_mit_tiles.put(pt,tiles.get(71).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(70).getImage());
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(72).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(61).getImage());
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(81).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(60).getImage());
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(62).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(80).getImage());
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(82).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(54).getImage());
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(53).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(44).getImage());
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(43).getImage());
						}
					}
				}else if(c.getRed()==100){
					if(c.getGreen()==100){
						
						//stein
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(41).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(40).getImage());
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(42).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(31).getImage());
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(51).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(30).getImage());
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(32).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(50).getImage());
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(52).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(34).getImage());
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(33).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(24).getImage());
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(23).getImage());
						}
					}
					
				}else if(c.getRed()==0){
					
				}
			}
		}
	}
	public void karteLaden(File file) {
		tileIDs = new int[kartenbild.getWidth()][kartenbild.getHeight()];
	}
}