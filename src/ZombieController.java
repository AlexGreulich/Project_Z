import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;


public class ZombieController implements Runnable{

	Spielfenster fenster;
	Spielfeld kartenausschnitt;
	ArrayList<Zombie> zombies;
	Point pkt;
	HashMap<Point,Zombie> neuemap;
	
	int random;
	int MAX_GAME_SPEED = 4;
	
	public ZombieController(Spielfenster f){
		fenster =f;
		kartenausschnitt = fenster.spielfeld;
		pkt = fenster.ofView;
		zombies = kartenausschnitt.zombies;
		neuemap = fenster.aktZomb;
	}
	
	@Override
	public void run() {
	
		while(true){
			float START = System.currentTimeMillis();
			kartenausschnitt.zombieradius.setLocation(pkt.x, pkt.y);
			
			for(Zombie z: zombies){
				if(kartenausschnitt.zombieradius.contains(z.pos_x,z.pos_y)){
					z.istSichtbar=true;
				}else{
					z.istSichtbar=false;
				}
				
				if(z.istSichtbar){
					//fenster.aktZomb.remove(new Point(z.pos_x,z.pos_y));
					int r = (int)Math.random()*4;
					if(r==0){
						z.pos_x++;
						z.letzteRichtung=2;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
						
					}else if (r==2){
						z.pos_x--;
						z.letzteRichtung=1;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(r==2){
						z.pos_y++;
						z.letzteRichtung=0;
						neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}else if(r==3){
						z.pos_y--;
							z.letzteRichtung=3;
							neuemap.put(new Point(z.pos_x,z.pos_y),z);
					}
//						case 0:
//							
//							break;
//						case 1:
//							
//							break;
//						case 2:
//							
//							break;
//						case 3:
//							
//							break;
					
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
