import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Level {
	
	BufferedImage kartenbild, spawnkarte;
	int [][][] tileArray;
	
	/*[x][y][z]
	 * z=0 -> grundebene
	 * z=1 -> begehbar (0), nichtbegehbar(1)
	 * z=2 -> 
	 * 
	 * z=3 -> zombie spawnen lassen
	 */
	Color grass = new Color(100,200,100);
	ArrayList<Zombie> zombies;
	
	
	public Level(){
		try{
			kartenbild = ImageIO.read(getClass().getResource("karten/grossekarte.gif"));
			spawnkarte = ImageIO.read(getClass().getResource("karten/zombiespawnkarte.gif"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
		tileArray = new int[kartenbild.getWidth()][kartenbild.getHeight()][4];	//Tile[][]
		karteAuslesen();
		zombies = new ArrayList<Zombie>();
		zombiesErstellen();
	}
	public void zombiesErstellen(){
		for(int x = 0; x < spawnkarte.getWidth();x++){
			for(int y = 0; y < spawnkarte.getHeight();y++){
				Color c = new Color(spawnkarte.getRGB(x, y));
				if( c.equals(Color.BLACK)){
					tileArray[x][y][3]=1;
					Zombie z = new Zombie(x,y);
					zombies.add(z);
				}
			}
		}	
	}

	public void karteAuslesen(){
		for(int x = 0; x < kartenbild.getWidth(); x++){
			for(int y = 0; y < kartenbild.getHeight(); y++){
				
				
				Color c = new Color(kartenbild.getRGB(x,y));
			
				if(c.equals(grass)){
					tileArray[x][y][0] = 300;
					tileArray[x][y][1] = 0;
				}
							
				if(c.getRed() == 255){
					if(c.getGreen() == 255){
						
						//sand
						
						tileArray[x][y][1] = 0;	//da sand, sind alle felder begehbar
						
						if(c.getBlue()==0)		 {tileArray[x][y][0] = 21;			//vorher :  {tileArray[x][y] = new Tile(tileset.getTileImage(201));
												
						}else if(c.getBlue()==10){tileArray[x][y][0] = 20;//oben
						}else if(c.getBlue()==20){tileArray[x][y][0]= 22;
						}else if(c.getBlue()==30){tileArray[x][y][0] = 1;//links
						}else if(c.getBlue()==40){tileArray[x][y][0] = 41;
						}else if(c.getBlue()==50){tileArray[x][y][0] = 0;//lioben
						}else if(c.getBlue()==60){tileArray[x][y][0] = 2;
						}else if(c.getBlue()==70){tileArray[x][y][0] = 40;//reoben
						}else if(c.getBlue()==80){tileArray[x][y][0] = 42;
						}else if(c.getBlue()==90){tileArray[x][y][0] = 24;//gras_lioben
						}else if(c.getBlue()==100){tileArray[x][y][0] = 23;
						}else if(c.getBlue()==110){tileArray[x][y][0] = 4;//gras_reoben
						}else if(c.getBlue()==120){tileArray[x][y][0] = 3;
						}
					}
					
				}else if(c.getRed()==0){
					if(c.getGreen()==200){
						
						//busch
						tileArray[x][y][1] = 0; //zunächst alle felder begehbar
						
						if(c.getBlue()==0)		 {tileArray[x][y][0] = 201;
													tileArray[x][y][1] = 1; //busch mittig, nicht begehbar
						}else if(c.getBlue()==10){tileArray[x][y][0] = 200;
													tileArray[x][y][1] = 1;	//busch unten, nicht begehbar
						}else if(c.getBlue()==20){tileArray[x][y][0] = 202;
						}else if(c.getBlue()==30){tileArray[x][y][0] = 181;
						}else if(c.getBlue()==40){tileArray[x][y][0] = 221;
						}else if(c.getBlue()==50){tileArray[x][y][0] = 180;
						}else if(c.getBlue()==60){tileArray[x][y][0] = 182;
						}else if(c.getBlue()==70){tileArray[x][y][0] = 220;
						}else if(c.getBlue()==80){tileArray[x][y][0] = 222;
						}else if(c.getBlue()==90){tileArray[x][y][0] = 144;
						}else if(c.getBlue()==100){tileArray[x][y][0] = 143;
						}else if(c.getBlue()==110){tileArray[x][y][0] = 124;
						}else if(c.getBlue()==120){tileArray[x][y][0] = 123;
						}
					}
					
					if(c.getGreen()==255){
						
						//wasser
						tileArray[x][y][1] = 1;	//kein feld begehbar
						
						if(c.getBlue()==255)	 {tileArray[x][y][0] = 141;
						}else if(c.getBlue()==10){tileArray[x][y][0] = 140;
						}else if(c.getBlue()==20){tileArray[x][y][0] = 142;
						}else if(c.getBlue()==30){tileArray[x][y][0] = 121;
						}else if(c.getBlue()==40){tileArray[x][y][0] = 161;
						}else if(c.getBlue()==50){tileArray[x][y][0] = 120;
						}else if(c.getBlue()==60){tileArray[x][y][0] = 122;
						}else if(c.getBlue()==70){tileArray[x][y][0] = 160;
						}else if(c.getBlue()==80){tileArray[x][y][0] = 162;
						}else if(c.getBlue()==90){tileArray[x][y][0] = 104;
						}else if(c.getBlue()==100){tileArray[x][y][0] = 103;
						}else if(c.getBlue()==110){tileArray[x][y][0] = 84;
						}else if(c.getBlue()==120){tileArray[x][y][0] = 83;
						}
					}
					
				}else if(c.getRed()==100){
					if(c.getGreen()==100){
						
						//stein
						tileArray[x][y][1] = 1;
						
						if(c.getBlue()==0)		 {tileArray[x][y][0] = 81;
						}else if(c.getBlue()==10){tileArray[x][y][0] = 80;
						}else if(c.getBlue()==20){tileArray[x][y][0] = 82;
						}else if(c.getBlue()==30){tileArray[x][y][0] = 61;
						}else if(c.getBlue()==40){tileArray[x][y][0] = 101;
						}else if(c.getBlue()==50){tileArray[x][y][0] = 60;
						}else if(c.getBlue()==60){tileArray[x][y][0] = 62;
						}else if(c.getBlue()==70){tileArray[x][y][0] = 100;
						}else if(c.getBlue()==80){tileArray[x][y][0] = 102;
						}else if(c.getBlue()==90){tileArray[x][y][0] = 64;
						}else if(c.getBlue()==100){tileArray[x][y][0] = 63;
						}else if(c.getBlue()==110){tileArray[x][y][0] = 44;
						}else if(c.getBlue()==120){tileArray[x][y][0] = 43;
						}
					}
					
				}
			}
		}
		tileArray[25][5][3]=1;
		tileArray[52][10][3]=1;
		tileArray[52][20][3]=1;
		tileArray[25][8][3]=1;
		tileArray[25][50][3]=1;
		tileArray[25][100][3]=1;
		
	}
}
