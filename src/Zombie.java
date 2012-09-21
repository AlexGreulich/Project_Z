import java.awt.image.BufferedImage;


public class Zombie extends Entity{

	
	float animation;
	int letzteRichtung;
	int rnd;
	boolean bewegtSich, istSichtbar, istTot;
	int id;
	BufferedImage img;
	
	public Zombie(int x, int y){
		pos_x = x;	//remind, 0,3 gezeichnet an 0,96; 
		pos_y = y;
		
		energy =100;
		
		charset_oben = new BufferedImage[8];
		charset_unten = new BufferedImage[8];
		charset_links = new BufferedImage[8];
		charset_rechts = new BufferedImage[8];
		charset_oben_links = new BufferedImage[8];
		charset_oben_rechts = new BufferedImage[8];
		charset_unten_links = new BufferedImage[8];
		charset_unten_rechts = new BufferedImage[8];
		
		setCharset("tileset3dkorrekt.gif");// alt: newcharset2_32.gif
		animation = 0.0f;
		istSichtbar=true;
	}
	
	public BufferedImage getImage(){
		//hoehe = fenster.spielfeld.level.kartenbild.getWidth();
		//breite = fenster.spielfeld.level.kartenbild.getHeight();
		if(bewegtSich){
			animation+=0.33f;
		}else {animation=0.0f;}
 
		if((int)animation == 8 ) {
			animation=0.0f;
		}
		switch(letzteRichtung){
		case 0:	img = charset_unten[(int)animation];
		break;
		case 1:	img = charset_links[(int)animation];
		break;
		case 2:	img = charset_rechts[(int)animation];
		break;
		case 3:	img = charset_oben[(int)animation];
		break;
		case 4:	img = charset_unten_links[(int)animation];
		break;
		case 5:	img = charset_unten_rechts[(int)animation];
		break;
		case 6:	img = charset_oben_links[(int)animation];
		break;
		case 7:	img = charset_oben_rechts[(int)animation];
		break;
		
	
	}
	return img;
		//return charset.getSubimage(((int)animation)*32, this.letzteRichtung*48,32, 48);		//64,96
	}	
	
}
