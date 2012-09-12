import java.awt.Point;


public class Gameloop implements Runnable{

	Spielfenster screen;
	Steuerung steuerung;
	Spielfeld karte;
	Spieler sp;
	int hoehe,breite;
	Point pkt;
	
	int MAX_GAME_SPEED = 30;
	
	public Gameloop(Spielfenster fenster){
		screen = fenster;
		steuerung = fenster.steuerung;	
		karte = screen.spielfeld;
		sp = screen.spieler;
		pkt = screen.ofView;
		hoehe = screen.spielfeld.level.kartenbild.getWidth();
		breite = screen.spielfeld.level.kartenbild.getHeight();
	}
	
	@Override
	public void run() {
		while(true){
			//if steuerung =.... dann tue ....
			
			float START = System.currentTimeMillis();
			
		//	if(steuerung.bewegtSich){			
				if((steuerung.hoch) && (steuerung.links)){
					
					if(karte.level.tileArray[pkt.x+12][pkt.y+12][1] != 1){
						pkt.x--;
						pkt.y--;
						steuerung.letzteRichtung=6;
					}
				}	
				else if((steuerung.hoch) && (steuerung.rechts)){
					
					if(karte.level.tileArray[pkt.x+14][pkt.y+12][1] !=1){
						pkt.x++;
						pkt.y--;
						steuerung.letzteRichtung=7;
					}
				}
				else if(steuerung.hoch){
					
					if(karte.level.tileArray[pkt.x+13][pkt.y+12][1] != 1 ){
						pkt.y--;
						steuerung.letzteRichtung=3;
					}		
				}
				else if((steuerung.runter) && (steuerung.links)){
					
					if(karte.level.tileArray[pkt.x+12][pkt.y+14][1] !=1){
						pkt.y++;
						pkt.x--;
						steuerung.letzteRichtung=4;
					}
					
				}
				else if((steuerung.runter) && (steuerung.rechts)){
					
					if(karte.level.tileArray[pkt.x+14][pkt.y+14][1] != 1){
						pkt.y++;
						pkt.x++;
						steuerung.letzteRichtung=5;
					}
					
				}
				else if (steuerung.runter){
					
					if(karte.level.tileArray[pkt.x+13][pkt.y+14][1] !=1){
						pkt.y++;
						steuerung.letzteRichtung=0;
					}
				
				}
				else if(steuerung.links==true){
					
					if(karte.level.tileArray[pkt.x+12][pkt.y+13][1] != 1){
						pkt.x--;
						steuerung.letzteRichtung=1;
					}
					
				}
				else if(steuerung.rechts==true){
					
					if(karte.level.tileArray[pkt.x+14][pkt.y+13][1] !=1){
						pkt.x++;
						steuerung.letzteRichtung=2;
					}
					
				}
				
				
				
				if(screen.ofView.x > breite-25){
					pkt.x = breite-25;
//					System.out.println("111  pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
					if(screen.ofView.y > hoehe-25){
						pkt.y = hoehe-25;
					}
					if(screen.ofView.y < 0){
						pkt.y = 0;
					}
				}
				else if (screen.ofView.x < 0){
					pkt.x = 0;
//					System.out.println("222 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
					if(screen.ofView.y > hoehe-25){
						pkt.y = hoehe-25;
					}
					if(screen.ofView.y < 0){
						pkt.y = 0;
					}
				}
				else if (screen.ofView.y > hoehe-25){
					pkt.y = hoehe-25;
//					System.out.println("333 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
					if(screen.ofView.x > breite-25){
						pkt.x = breite-25;
					}
					if(screen.ofView.x < 0){
						pkt.x = 0;
					}
				}
				else if (screen.ofView.y < 0){
					pkt.y = 0;
//					System.out.println("4444 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
					if(screen.ofView.x > breite-25){
						pkt.x = breite-25;
					}
					if(screen.ofView.x < 0){
						pkt.x = 0;
					}
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
	//}

}
