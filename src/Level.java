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
	//Tile[][] tileArray;
	int [][] tileArray;
	Color grass = new Color(100,200,100);
	Tileset tileset;
	
	
	public Level(){
		try{
			kartenbild = ImageIO.read(getClass().getResource("karten/grossekarte.gif"));
		}catch(IOException e){
			e.printStackTrace();
		}
		tileset = new Tileset();
		tileArray = new int[kartenbild.getWidth()][kartenbild.getHeight()];	//Tile[][]
		karteAuslesen();
	}
	

	public void karteAuslesen(){
		for(int x = 0; x < kartenbild.getWidth(); x++){
			for(int y = 0; y < kartenbild.getHeight(); y++){
				
				Color c = new Color(kartenbild.getRGB(x,y));
			
				if(c.equals(grass)){
					tileArray[x][y] = 300;
				}
							
				if(c.getRed() == 255){
					if(c.getGreen() == 255){
						
						//sand
						
						if(c.getBlue()==0)		 {tileArray[x][y] = 21;			//vorher :  {tileArray[x][y] = new Tile(tileset.getTileImage(201));
						}else if(c.getBlue()==10){tileArray[x][y] = 20;//oben
						}else if(c.getBlue()==20){tileArray[x][y] = 22;
						}else if(c.getBlue()==30){tileArray[x][y] = 1;//links
						}else if(c.getBlue()==40){tileArray[x][y] = 41;
						}else if(c.getBlue()==50){tileArray[x][y] = 0;//lioben
						}else if(c.getBlue()==60){tileArray[x][y] = 2;
						}else if(c.getBlue()==70){tileArray[x][y] = 40;//reoben
						}else if(c.getBlue()==80){tileArray[x][y] = 42;
						}else if(c.getBlue()==90){tileArray[x][y] = 24;//gras_lioben
						}else if(c.getBlue()==100){tileArray[x][y] = 23;
						}else if(c.getBlue()==110){tileArray[x][y] = 4;//gras_reoben
						}else if(c.getBlue()==120){tileArray[x][y] = 3;
						}
					}
					
				}else if(c.getRed()==0){
					if(c.getGreen()==200){
						
						//busch
						
						if(c.getBlue()==0)		 {tileArray[x][y] = 201;
						}else if(c.getBlue()==10){tileArray[x][y] = 200;
						}else if(c.getBlue()==20){tileArray[x][y] = 202;
						}else if(c.getBlue()==30){tileArray[x][y] = 181;
						}else if(c.getBlue()==40){tileArray[x][y] = 221;
						}else if(c.getBlue()==50){tileArray[x][y] = 180;
						}else if(c.getBlue()==60){tileArray[x][y] = 182;
						}else if(c.getBlue()==70){tileArray[x][y] = 220;
						}else if(c.getBlue()==80){tileArray[x][y] = 222;
						}else if(c.getBlue()==90){tileArray[x][y] = 144;
						}else if(c.getBlue()==100){tileArray[x][y] = 143;
						}else if(c.getBlue()==110){tileArray[x][y] = 124;
						}else if(c.getBlue()==120){tileArray[x][y] = 123;
						}
					}
					
					if(c.getGreen()==255){
						
						//wasser
						
						if(c.getBlue()==255)	 {tileArray[x][y] = 141;
						}else if(c.getBlue()==10){tileArray[x][y] = 140;
						}else if(c.getBlue()==20){tileArray[x][y] = 142;
						}else if(c.getBlue()==30){tileArray[x][y] = 121;
						}else if(c.getBlue()==40){tileArray[x][y] = 161;
						}else if(c.getBlue()==50){tileArray[x][y] = 120;
						}else if(c.getBlue()==60){tileArray[x][y] = 122;
						}else if(c.getBlue()==70){tileArray[x][y] = 160;
						}else if(c.getBlue()==80){tileArray[x][y] = 162;
						}else if(c.getBlue()==90){tileArray[x][y] = 104;
						}else if(c.getBlue()==100){tileArray[x][y] = 103;
						}else if(c.getBlue()==110){tileArray[x][y] = 84;
						}else if(c.getBlue()==120){tileArray[x][y] = 83;
						}
					}
					
				}else if(c.getRed()==100){
					if(c.getGreen()==100){
						
						//stein
						
						if(c.getBlue()==0)		 {tileArray[x][y] = 81;
						}else if(c.getBlue()==10){tileArray[x][y] = 80;
						}else if(c.getBlue()==20){tileArray[x][y] = 82;
						}else if(c.getBlue()==30){tileArray[x][y] = 61;
						}else if(c.getBlue()==40){tileArray[x][y] = 101;
						}else if(c.getBlue()==50){tileArray[x][y] = 60;
						}else if(c.getBlue()==60){tileArray[x][y] = 62;
						}else if(c.getBlue()==70){tileArray[x][y] = 100;
						}else if(c.getBlue()==80){tileArray[x][y] = 102;
						}else if(c.getBlue()==90){tileArray[x][y] = 64;
						}else if(c.getBlue()==100){tileArray[x][y] = 63;
						}else if(c.getBlue()==110){tileArray[x][y] = 44;
						}else if(c.getBlue()==120){tileArray[x][y] = 43;
						}
					}
					
				}
			}
		}
	}
}
