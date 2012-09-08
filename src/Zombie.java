import java.awt.image.BufferedImage;


public class Zombie extends Entity{

	float animation;
	int letzteRichtung;
	int rnd;
	boolean bewegtSich;
	
	public Zombie(int x, int y){
		pos_x = x;
		pos_y = y;
		
		energy =100;
		setCharset("newcharset2_32.gif");
		animation = 0.0f;
	}
	
	public BufferedImage getImage(){
		//hoehe = fenster.spielfeld.level.kartenbild.getWidth();
		//breite = fenster.spielfeld.level.kartenbild.getHeight();
		if(bewegtSich){
			animation+=0.33f;
		}else {animation=0.0f;}
 
		if((int)animation ==4 ) {
			animation=0.0f;
		}
		
		return charset.getSubimage(((int)animation)*32, this.letzteRichtung*48,32, 48);		//64,96
	}	
}
