import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JFrame;

public class Spielfenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 655039867299016635L;
	Steuerung steuerung;
	Spieler spieler;
	Point ofView = new Point(0,0);
	Spielfeld spielfeld;
	Gameloop gameloop;
	ZombieController zcontrol;
	
	HashMap<Point,Zombie> aktZomb;
	Thread gameloopthread, zeichenloopthread,zombiethread;
	
	Monitor monitor;
	
	public Spielfenster(){
		super("Project Z");
		setVisible(true);				
		this.setIgnoreRepaint(true);	
		/*jframe und canvas werden nicht mehr über repaint aktualisiert
		 * dasselbe auch in spielfeld
		 * 
		 * setVisible muss aufgerufen werden, bevor die bufferstrategie gesetzt wird
		*/
		
		steuerung = new Steuerung();
		addKeyListener(steuerung);
		aktZomb = new HashMap<Point, Zombie>();
		spieler = new Spieler(this);

		spielfeld = new Spielfeld(this);
		
		add(spielfeld);
		spielfeld.setVisible(true);
		gameloop = new Gameloop(this);
		
		zcontrol = new ZombieController(this);
		
		gameloopthread = new Thread(gameloop);
		zeichenloopthread = new Thread(spielfeld);
		zombiethread = new Thread(zcontrol);
	
		zeichenloopthread.start();
		gameloopthread.start();		
		zombiethread.start();
		
//		monitor = new Monitor(this);
//		Thread monitorthread = new Thread(monitor);
//		monitorthread.start();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int scrx = (int) (screen.getWidth()/2)-350;
		int scry = (int) (screen.getHeight()/2)-370;
		setLocation(scrx, scry);
		
		setResizable(false);
		pack();
		
		//spielfeld.createBufferStrategy(2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
