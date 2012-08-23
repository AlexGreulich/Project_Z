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
			tileset = ImageIO.read(getClass().getResource("Tileset_neu_32.gif"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
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
					map_mit_tiles.put(pt,tiles.get(300).getImage());
				}
				if(c.getRed()==255){
					if(c.getGreen()==255){
						
						//sand
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(21).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(20).getImage());//oben
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(22).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(1).getImage());//links
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(41).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(0).getImage());//lioben
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(2).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(40).getImage());//reoben
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(42).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(24).getImage());//gras_lioben
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(23).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(4).getImage());//gras_reoben
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(3).getImage());
						}
					}
				}else if(c.getRed()==0){
					if(c.getGreen()==200){
						
						//busch
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(201).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(200).getImage());//oben
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(202).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(181).getImage());//links
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(221).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(180).getImage());//lioben
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(182).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(220).getImage());//reoben
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(222).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(144).getImage());//gras_lioben
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(143).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(124).getImage());//gras_reoben
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(123).getImage());
						}
						
					}
					if(c.getGreen()==255){
						
						//wasser
						
						if(c.getBlue()==255)		 {map_mit_tiles.put(pt,tiles.get(141).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(140).getImage());//oben
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(142).getImage());//unten
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(121).getImage());//links
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(161).getImage());//rechts
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(120).getImage());//lioben
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(122).getImage());//liunten
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(160).getImage());//reoben
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(162).getImage());//reunten
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(104).getImage());//gras_lioben
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(103).getImage());//liunten
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(84).getImage());//gras_reoben
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(83).getImage());//reunten
						}
					}
				}else if(c.getRed()==100){
					if(c.getGreen()==100){
						
						//stein
						
						if(c.getBlue()==0)		 {map_mit_tiles.put(pt,tiles.get(81).getImage());
						}else if(c.getBlue()==10){map_mit_tiles.put(pt,tiles.get(80).getImage());//oben
						}else if(c.getBlue()==20){map_mit_tiles.put(pt,tiles.get(82).getImage());
						}else if(c.getBlue()==30){map_mit_tiles.put(pt,tiles.get(61).getImage());//links
						}else if(c.getBlue()==40){map_mit_tiles.put(pt,tiles.get(101).getImage());
						}else if(c.getBlue()==50){map_mit_tiles.put(pt,tiles.get(60).getImage());//lioben
						}else if(c.getBlue()==60){map_mit_tiles.put(pt,tiles.get(62).getImage());
						}else if(c.getBlue()==70){map_mit_tiles.put(pt,tiles.get(100).getImage());//reoben
						}else if(c.getBlue()==80){map_mit_tiles.put(pt,tiles.get(102).getImage());
						}else if(c.getBlue()==90){map_mit_tiles.put(pt,tiles.get(64).getImage());//gras_lioben
						}else if(c.getBlue()==100){map_mit_tiles.put(pt,tiles.get(63).getImage());
						}else if(c.getBlue()==110){map_mit_tiles.put(pt,tiles.get(44).getImage());//gras_reoben
						}else if(c.getBlue()==120){map_mit_tiles.put(pt,tiles.get(43).getImage());
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
