import java.awt.image.BufferedImage;

public class Spieler extends Entity {
	
	boolean isMoving;
	
	Spielfenster fenster;
	Steuerung steuerung;
	float animation = 0.0f;
	int anim =0;
	BufferedImage start, img; 
	
	public Spieler(Spielfenster f){
		fenster = f;
		steuerung = fenster.steuerung;
		pos_x = 350;
		pos_y = 350;
		energy = 100;
		isMoving = false;
		charset_oben = new BufferedImage[8];
		charset_unten = new BufferedImage[8];
		charset_links = new BufferedImage[8];
		charset_rechts = new BufferedImage[8];
		charset_oben_links = new BufferedImage[8];
		charset_oben_rechts = new BufferedImage[8];
		charset_unten_links = new BufferedImage[8];
		charset_unten_rechts = new BufferedImage[8];
		setCharset("tileset3dkorrekt.gif");//newcharset2_32.gif
	}
	
	public BufferedImage getImage(){
		//hoehe = fenster.spielfeld.level.kartenbild.getWidth();
		//breite = fenster.spielfeld.level.kartenbild.getHeight();
		if(steuerung.bewegtSich){
			animation+=0.33;
	
		}
		else {animation = 0.0f;}
 
		if((int)animation == 8 ) {
			animation = 0.0f;
		}
		anim = (int)animation;
		switch(steuerung.letzteRichtung){
			case 0:	img = charset_unten[anim];
			break;
			case 1:	img = charset_links[anim];
			break;
			case 2:	img = charset_rechts[anim];
			break;
			case 3:	img = charset_oben[anim];
			break;
			case 4:	img = charset_unten_links[anim];
			break;
			case 5:	img = charset_unten_rechts[anim];
			break;
			case 6:	img = charset_oben_links[anim];
			break;
			case 7:	img = charset_oben_rechts[anim];
			break;
			
		
		}
		return img;
		//return charset.getSubimage(((int)animation), steuerung.letzteRichtung*48,32, 48);		//64,96
	}
}
