import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Steuerung implements KeyListener{
	boolean hoch =false;
	boolean runter =false;
	boolean links =false;
	boolean rechts=false;
	boolean bewegtSich;
	int letzteRichtung=0;
	boolean wechsel=false;
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				letzteRichtung = 3;
				bewegtSich=true;
				hoch=true;
				break;
			case KeyEvent.VK_DOWN:
				letzteRichtung=0;
				bewegtSich=true;
				runter=true;
				break;
			case KeyEvent.VK_LEFT:
				letzteRichtung=1;
				bewegtSich=true;
				links=true;
				break;
			case KeyEvent.VK_RIGHT:
				letzteRichtung=2;
				bewegtSich=true;
				rechts=true;
				break;
		}
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				bewegtSich=false;
				 hoch=false;
				 break;
			case KeyEvent.VK_DOWN:
				bewegtSich=false;
				runter=false;
				break;
			case KeyEvent.VK_LEFT:
				bewegtSich=false;
				links=false;
				break;
			case KeyEvent.VK_RIGHT:
				bewegtSich=false;
				rechts=false;
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		//für einmaliges drücken zb inventar
	}

	
}
