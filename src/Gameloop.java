import java.awt.Point;


public class Gameloop implements Runnable{

	Spielfenster screen;
	Steuerung steuerung;
	Spielfeld karte;
	int hoehe,breite;
	Point pkt;
	
	public Gameloop(Spielfenster fenster){
		screen = fenster;
		steuerung = fenster.steuerung;	
		karte = screen.spielfeld;
		
		pkt = screen.ofView;
		hoehe = screen.spielfeld.level.kartenbild.getWidth();
		breite = screen.spielfeld.level.kartenbild.getHeight();
	}
	
	@Override
	public void run() {
		while(true){
			//if steuerung =.... dann tue ....
			
			
			
		//	if(steuerung.bewegtSich){			
//				if(screen.steuerung.hoch==true){
					pkt.y++;
					//screen.spieler.pos_y--;
//				}
				if(steuerung.runter==true){
					pkt.y++;
					//screen.spieler.pos_y++;
					System.out.println("pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				else if(steuerung.links==true){
					pkt.x--;
					//screen.spieler.pos_x--;
					System.out.println("pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				else if(steuerung.rechts==true){
					pkt.x++;
					//screen.spieler.pos_x++;
					System.out.println("pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				
				if(screen.ofView.x > breite-20){
					pkt.x--;
					System.out.println("111  pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				else if (screen.ofView.x < 0){
					pkt.x++;
					System.out.println("222 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				else if (screen.ofView.y > hoehe-15){
					pkt.y--;
					System.out.println("333 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
				else if (screen.ofView.y < 0){
					pkt.y++;
					System.out.println("4444 pkt.x :" + pkt.x + "pkt.y: "+ pkt.y);
				}
			}	
		}
	//}

}
