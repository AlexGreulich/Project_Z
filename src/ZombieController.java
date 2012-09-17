import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ZombieController implements Runnable{

	Spielfenster fenster;
	Spielfeld spielfeld;
	ArrayList<Zombie> zombies;
	Point pkt;
	HashMap<Point,Zombie> neuemap;
	
	Random random;
	int rnd;
	int MAX_GAME_SPEED = 16;
	
	public ZombieController(Spielfenster f){
		fenster =f;
		spielfeld = fenster.spielfeld;
		pkt = fenster.ofView;
		zombies = spielfeld.zombies;
		neuemap = fenster.aktZomb;
		random = new Random();
	}
	
	@Override
	public void run() {
	
		while(true){
			float START = System.currentTimeMillis();
			spielfeld.zombieradius.setLocation(pkt.x, pkt.y);
			
			for(Zombie z: zombies){
				if(spielfeld.zombieradius.contains(z.pos_x,z.pos_y)){
					z.istSichtbar=true;
				}else{
					z.istSichtbar=false;
				}
				
				if(z.istSichtbar){
					//fenster.aktZomb.remove(new Point(z.pos_x,z.pos_y));
					rnd = random.nextInt(8);
					if(rnd == 0){
						z.pos_x++;
						z.letzteRichtung=2;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
						
					}else if (rnd == 1){
						z.pos_x--;
						z.letzteRichtung=1;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 2){
						z.pos_y++;
						z.letzteRichtung=0;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 3){
						z.pos_y--;
						z.letzteRichtung=3;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 4){
						z.pos_x--;
						z.pos_y++;
						z.letzteRichtung=4;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 5){
						z.pos_x++;
						z.pos_y++;
						z.letzteRichtung=5;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 6){
						z.pos_x--;
						z.pos_y--;
						z.letzteRichtung=6;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(rnd == 7){
						z.pos_x--;
						z.pos_y++;
						z.letzteRichtung=7;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}
					
				}else{
					fenster.aktZomb.remove(new Point(z.pos_x,z.pos_y));
				}
				
			}
			fenster.aktZomb= neuemap;
			
			float AUSFUEHR = System.currentTimeMillis()-START;
			if(MAX_GAME_SPEED>AUSFUEHR){
				try {
					Thread.sleep(MAX_GAME_SPEED-(int)AUSFUEHR);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
