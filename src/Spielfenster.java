import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

public static class Spielfenster extends JFrame {

	Steuerung steuerung;
	Spieler spieler;
	Point ofView = new Point(10,10);
	Gameloop gameloop;
	Spielfeld spielfeld;
	Thread gameloopthread, zeichenloopthread;
	
	public static Spielfenster(){
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
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
