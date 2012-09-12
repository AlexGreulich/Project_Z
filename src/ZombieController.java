import java.util.ArrayList;


public class ZombieController implements Runnable{

	Spielfenster fenster;
	ArrayList<Zombie> zombies;
	
	int random;
	int MAX_GAME_SPEED = 75;
	
	public ZombieController(Spielfenster f){
		fenster = f;
		zombies = f.spielfeld.zombies;
	}
	
	@Override
	public void run() {
	
		while(true){
			float START = System.currentTimeMillis();
			
			for(Zombie z: zombies){
				random = (int) Math.random()*3;
				
				if(random == 3){	//nur bei 3 bewegt er sich...
					
					random = (int) Math.random()*4;
					
					if(random == 0){		//links
						z.bewegtSich= true;
						z.pos_x--;
						z.letzteRichtung = 1;
					}else if(random == 1){	//rechts
						z.bewegtSich= true;
						z.pos_x++;
						z.letzteRichtung = 2;
					}else if(random == 2){	//hoch
						z.bewegtSich= true;
						z.pos_y--;
						z.letzteRichtung = 3;
					}else if(random ==3){	//runter
						z.bewegtSich= true;
						z.pos_y++;
						z.letzteRichtung = 0;
					}
					
				}
				z.bewegtSich = false;
			}
			
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
