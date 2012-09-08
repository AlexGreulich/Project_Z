import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Spielfenster extends JFrame {

	Steuerung steuerung;
	Spieler spieler;
	Point ofView = new Point(10,10);
	Spielfeld spielfeld;
	Gameloop gameloop;
	Thread gameloopthread, zeichenloopthread;
		
	public Spielfenster(){
		super("Project Z");
		
		steuerung = new Steuerung();
		addKeyListener(steuerung);
		
		spieler = new Spieler(this);
		
		spielfeld = new Spielfeld(this);
		add(spielfeld);
		
		gameloop = new Gameloop(this);
		
		gameloopthread = new Thread(gameloop);
		zeichenloopthread = new Thread(spielfeld);
	
		zeichenloopthread.start();
		gameloopthread.start();		
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int scrx = (int) (screen.getWidth()/2)-350;
		int scry = (int) (screen.getHeight()/2)-370;
		setLocation(scrx, scry);
		
		setResizable(false);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
