import java.awt.image.BufferedImage;

public class Spieler extends Entity {
	
	boolean isMoving;
	boolean amRandoben=false,amRandunten=false,amRandlinks=false, amRandrechts =false, amrand=false;
	Spielfenster fenster;
	Steuerung steuerung;
	float animation = 0.0f;
	int hoehe, breite;
	
	public Spieler(Spielfenster f){
		fenster = f;
		steuerung = fenster.steuerung;
		pos_x = 13;
		pos_y = 13;
		energy = 100;
		isMoving = false;
		setCharset("newcharset2_32.gif");
	}
	
	public void vomRandweg(){
		pos_x = 13;
		pos_y = 13;
		
	}
	
	public BufferedImage getImage(){
		hoehe = fenster.spielfeld.level.kartenbild.getWidth();
		breite = fenster.spielfeld.level.kartenbild.getHeight();
		
		int offsetX = fenster.ofView.x;
		int offsetY = fenster.ofView.y;
		if(steuerung.bewegtSich){
			animation+=0.33;
			
			//amRandoben = false;
		//amRandunten= false;
		//amRandlinks= false;
		//amRandrechts= false;
			if(!amRandoben){
				if(!amRandunten){
					if(!amRandlinks){
						if(!amRandrechts){
							vomRandweg();
						}
					}
				}
			}
			
			if(fenster.ofView.x <=0){
				amRandlinks = true;
				fenster.ofView.x=0;
				System.out.println("amRandlinks: "+ amRandlinks+ " an Position " + pos_x+", " +pos_y + "Ausschnitt an Pos.: "+ fenster.ofView.x+", "+ fenster.ofView.y);
				System.out.println("wechsel: "+ fenster.steuerung.wechsel);
			}else{
				amRandlinks=false;
				//vomRandweg();
			}
			if(fenster.ofView.x >=breite-25){
				amRandrechts=true;
				fenster.ofView.x=breite-25;
				System.out.println("amRandrechts: "+ amRandrechts+ " an Position " + pos_x+", " +pos_y + "Ausschnitt an Pos.: "+ fenster.ofView.x+", "+ fenster.ofView.y);
				System.out.println("wechsel: "+ fenster.steuerung.wechsel);
			}else{
				amRandrechts=false;
				//vomRandweg();
			}
			if(fenster.ofView.y <=0){
				amRandoben= true;
				fenster.ofView.y=0;
				System.out.println("amRandoben: "+ amRandoben+ " an Position " + pos_x+", " +pos_y + "Ausschnitt an Pos.: "+ fenster.ofView.x+", "+ fenster.ofView.y);
				System.out.println("wechsel: "+ fenster.steuerung.wechsel);
			}else{
				amRandoben=false;
				//vomRandweg();
			}
			if(fenster.ofView.y >=hoehe-25){
				amRandunten=true;
				fenster.ofView.y=hoehe-25;
				System.out.println("amRandunten: "+ amRandunten+ " an Position " + pos_x+", " +pos_y + "Ausschnitt an Pos.: "+ fenster.ofView.x+", "+ fenster.ofView.y);
				System.out.println("wechsel: "+ fenster.steuerung.wechsel);
			}else{
				amRandunten=false;
				//vomRandweg();
			}
			
			
			if(steuerung.hoch){				
				if(!amRandoben){						//wenn nicht am rand
					fenster.ofView.y--;					//bewege den ausschnitt
				}	
				else {									//wenn am rand
					//if(steuerung.hoch){				//und man hoch will
						if(pos_y<=1){					//wenn man schon am ende ist gehts nicht weiter
							pos_y =1;					
						}else{							//sonst kann man bis zum rand gehen
							pos_y--;					//der spieler wird bewegt
						}
					//}
					if(steuerung.runter){				//wenn man dann runter will
						if(pos_y >=12){					//und weit genug vom rand weg ist
							amRandoben=false;			//ist man vom rand weg^^
							fenster.ofView.y++;			//und der ausschnitt bewegt sich wieder
							vomRandweg();
						}else{
							pos_y++;					//bis dahin nur die figur
						}
					}
				}
				
			}else if(steuerung.runter){
				if(!amRandunten){
					fenster.ofView.y++;
				}	
				else{
					if(steuerung.runter){
						if(pos_y >= 24){		//&& (pos_y>4)
							pos_y =24;
						}else{
							pos_y++;
						}
					}
					else if(steuerung.hoch){
						if(pos_y <= 14){
							amRandunten=false;
							//pos_y = 4;
							fenster.ofView.y--;
							vomRandweg();
						}else{
							pos_y--;
						}
					}
				}
				
			}else if(steuerung.links){
				if(!amRandlinks){
					fenster.ofView.x--;
				}
					else{
					//if(steuerung.links){
						if(pos_x <= 0){
							pos_x=0;
						}else{
							pos_x--;
						}
					//}
					 if(steuerung.rechts){
						if(pos_x >= 12){
							amRandlinks =false;
							//pos_x=6;
							fenster.ofView.x++;
							vomRandweg();
						}else{
							pos_x++;
						}
					}
				}
			}
			else if(steuerung.rechts){
				if(!amRandrechts){
					fenster.ofView.x++;
				}
				else{
					if(steuerung.rechts){
						if(pos_x >= 24){
							pos_x = 24;
						}
						else{
							pos_x++;
						}
					}
					else if (steuerung.links){
						if(pos_x<=14){
							amRandrechts = false;
							//pos_x=6;
							fenster.ofView.x--;
							vomRandweg();
						}else{
							pos_x--;
						}
					}
				}
			}
		}
		else {animation=0.0f;}
 
		if((int)animation ==4 ) {
			animation=0.0f;
		}
		return charset.getSubimage(((int)animation)*32, steuerung.letzteRichtung*48,32, 48);		//64,96
	}
}
