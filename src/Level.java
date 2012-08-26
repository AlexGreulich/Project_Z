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
	Tile[][] tileArray;
	Color grass = new Color(100,200,100);
	Tileset tileset;
	
	
	public Level(){
		try{
			kartenbild = ImageIO.read(getClass().getResource("karten/grossekarte.gif"));
		}catch(IOException e){
			e.printStackTrace();
		}
		tileset = new Tileset();
		tileArray = new Tile[kartenbild.getWidth()][kartenbild.getHeight()];
		karteAuslesen();
	}
	
	
	public void karteAuslesen(){
		for(int x = 0; x < kartenbild.getWidth(); x++){
			for(int y = 0; y < kartenbild.getHeight(); y++){
				
				Color c = new Color(kartenbild.getRGB(x,y));
			
				if(c.equals(grass)){
					tileArray[x][y] = new Tile(tileset.getTileImage(120));
				}
				if(c.getRed() == 255){
					if(c.getGreen() == 255){
						
						//sand
						
						if(c.getBlue()==0)		 {tileArray[x][y] = new Tile(tileset.getTileImage(11));
						}else if(c.getBlue()==10){tileArray[x][y] = new Tile(tileset.getTileImage(10));//oben
						}else if(c.getBlue()==20){tileArray[x][y] = new Tile(tileset.getTileImage(12));
						}else if(c.getBlue()==30){tileArray[x][y] = new Tile(tileset.getTileImage(1));//links
						}else if(c.getBlue()==40){tileArray[x][y] = new Tile(tileset.getTileImage(21));
						}else if(c.getBlue()==50){tileArray[x][y] = new Tile(tileset.getTileImage(0));//lioben
						}else if(c.getBlue()==60){tileArray[x][y] = new Tile(tileset.getTileImage(2));
						}else if(c.getBlue()==70){tileArray[x][y] = new Tile(tileset.getTileImage(20));//reoben
						}else if(c.getBlue()==80){tileArray[x][y] = new Tile(tileset.getTileImage(22));
						}else if(c.getBlue()==90){tileArray[x][y] = new Tile(tileset.getTileImage(14));//gras_lioben
						}else if(c.getBlue()==100){tileArray[x][y] = new Tile(tileset.getTileImage(13));
						}else if(c.getBlue()==110){tileArray[x][y] = new Tile(tileset.getTileImage(4));//gras_reoben
						}else if(c.getBlue()==120){tileArray[x][y] = new Tile(tileset.getTileImage(3));
						}
					}
				}else if(c.getRed()==0){
					if(c.getGreen()==200){
						
						//busch
						
						if(c.getBlue()==0)		 {tileArray[x][y] = new Tile(tileset.getTileImage(101));
						}else if(c.getBlue()==10){tileArray[x][y] = new Tile(tileset.getTileImage(100));
						}else if(c.getBlue()==20){tileArray[x][y] = new Tile(tileset.getTileImage(102));
						}else if(c.getBlue()==30){tileArray[x][y] = new Tile(tileset.getTileImage(91));
						}else if(c.getBlue()==40){tileArray[x][y] = new Tile(tileset.getTileImage(111));
						}else if(c.getBlue()==50){tileArray[x][y] = new Tile(tileset.getTileImage(90));
						}else if(c.getBlue()==60){tileArray[x][y] = new Tile(tileset.getTileImage(92));
						}else if(c.getBlue()==70){tileArray[x][y] = new Tile(tileset.getTileImage(110));
						}else if(c.getBlue()==80){tileArray[x][y] = new Tile(tileset.getTileImage(112));
						}else if(c.getBlue()==90){tileArray[x][y] = new Tile(tileset.getTileImage(74));
						}else if(c.getBlue()==100){tileArray[x][y] = new Tile(tileset.getTileImage(73));
						}else if(c.getBlue()==110){tileArray[x][y] = new Tile(tileset.getTileImage(64));
						}else if(c.getBlue()==120){tileArray[x][y] = new Tile(tileset.getTileImage(63));
						}
					}
					
					if(c.getGreen()==255){
						
						//wasser
						
						if(c.getBlue()==255)	 {tileArray[x][y] = new Tile(tileset.getTileImage(71));
						}else if(c.getBlue()==10){tileArray[x][y] = new Tile(tileset.getTileImage(70));
						}else if(c.getBlue()==20){tileArray[x][y] = new Tile(tileset.getTileImage(72));
						}else if(c.getBlue()==30){tileArray[x][y] = new Tile(tileset.getTileImage(61));
						}else if(c.getBlue()==40){tileArray[x][y] = new Tile(tileset.getTileImage(81));
						}else if(c.getBlue()==50){tileArray[x][y] = new Tile(tileset.getTileImage(60));
						}else if(c.getBlue()==60){tileArray[x][y] = new Tile(tileset.getTileImage(62));
						}else if(c.getBlue()==70){tileArray[x][y] = new Tile(tileset.getTileImage(80));
						}else if(c.getBlue()==80){tileArray[x][y] = new Tile(tileset.getTileImage(82));
						}else if(c.getBlue()==90){tileArray[x][y] = new Tile(tileset.getTileImage(54));
						}else if(c.getBlue()==100){tileArray[x][y] = new Tile(tileset.getTileImage(53));
						}else if(c.getBlue()==110){tileArray[x][y] = new Tile(tileset.getTileImage(44));
						}else if(c.getBlue()==120){tileArray[x][y] = new Tile(tileset.getTileImage(43));
						}
					}
					
				}else if(c.getRed()==100){
					if(c.getGreen()==100){
						
						//stein
						
						if(c.getBlue()==0)		 {tileArray[x][y] = new Tile(tileset.getTileImage(41));
						}else if(c.getBlue()==10){tileArray[x][y] = new Tile(tileset.getTileImage(40));
						}else if(c.getBlue()==20){tileArray[x][y] = new Tile(tileset.getTileImage(42));
						}else if(c.getBlue()==30){tileArray[x][y] = new Tile(tileset.getTileImage(31));
						}else if(c.getBlue()==40){tileArray[x][y] = new Tile(tileset.getTileImage(51));
						}else if(c.getBlue()==50){tileArray[x][y] = new Tile(tileset.getTileImage(30));
						}else if(c.getBlue()==60){tileArray[x][y] = new Tile(tileset.getTileImage(32));
						}else if(c.getBlue()==70){tileArray[x][y] = new Tile(tileset.getTileImage(50));
						}else if(c.getBlue()==80){tileArray[x][y] = new Tile(tileset.getTileImage(52));
						}else if(c.getBlue()==90){tileArray[x][y] = new Tile(tileset.getTileImage(34));
						}else if(c.getBlue()==100){tileArray[x][y] = new Tile(tileset.getTileImage(33));
						}else if(c.getBlue()==110){tileArray[x][y] = new Tile(tileset.getTileImage(24));
						}else if(c.getBlue()==120){tileArray[x][y] = new Tile(tileset.getTileImage(23));
						}
					}
				}
			}
		}
	}
}
