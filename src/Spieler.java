import java.awt.image.BufferedImage;

public class Spieler extends Entity {
	
	boolean isMoving;
	//boolean amRandoben=false,amRandunten=false,amRandlinks=false, amRandrechts =false, amrand=false;
	Spielfenster fenster;
	Steuerung steuerung;
	float animation = 0.0f;
	//int hoehe, breite;
	
	public Spieler(Spielfenster f){
		fenster = f;
		steuerung = fenster.steuerung;
		pos_x = 13;
		pos_y = 13;
		energy = 100;
		isMoving = false;
		setCharset("newcharset2_32.gif");
	}
	
	public BufferedImage getImage(){
		//hoehe = fenster.spielfeld.level.kartenbild.getWidth();
		//breite = fenster.spielfeld.level.kartenbild.getHeight();
		
		if(steuerung.bewegtSich){
			animation+=0.33;
	
		}
		else {animation=0.0f;}
 
		if((int)animation ==4 ) {
			animation=0.0f;
		}
		return charset.getSubimage(((int)animation)*32, steuerung.letzteRichtung*48,32, 48);		//64,96
	}
}
