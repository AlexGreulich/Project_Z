import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Spielfenster extends JFrame {

	Steuerung steuerung;
	Spieler spieler;
	
	Point ofView = new Point(10,10);
	
	//Gameloop gameloop;
	
	Spielfeld spielfeld;
	
	Thread gameloopthread, zeichenloopthread;
	
	public Spielfenster(){
		super("Project Z");
		
		steuerung = new Steuerung();
		
		addKeyListener(steuerung);
		
		spieler = new Spieler("F:\\DerWorkspace\\Zombie\\src\\newcharset2_32.gif",this);
		spielfeld = new Spielfeld(this);
		
		add(spielfeld);
		//gameloop = new Gameloop(this);
		//gameloopthread = new Thread(gameloop);
		zeichenloopthread = new Thread(spielfeld);
		//gameloopthread.start();
		zeichenloopthread.start();
		
		setSize(new Dimension(800,800));
		
		
		//setUndecorated(true);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
