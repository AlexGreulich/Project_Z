import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;


public class Monitor extends JWindow implements Runnable{
	
	Spielfenster fenster;
	Spieler sp;
	Spielfeld feld;
	Level lvl;
	Tileset tiles;
	Stats stats;
	JTextField text ;
	JScrollPane scroll;
	int MAX_GAME_SPEED = 8;
	ArrayList<JLabel> zz;
	
	public Monitor(Spielfenster f){
		
		setLayout(new BorderLayout());
		fenster = f;
		feld = fenster.spielfeld;
		sp = feld.spieler;
		lvl = feld.level;

		stats = new Stats();
		
		text = new JTextField();
		//text.set
		zz = new ArrayList<JLabel>();
		JScrollPane scroll = new JScrollPane();
		scroll.add(text);
//		for(Zombie z: feld.zombies){
//			String  str = "Zombie "+z.id+": "+z.pos_x+", "+z.pos_y;
//			JLabel l = new JLabel(str);
//			zombies.add(l);
//		}
		
		//zombies.setSize(250,200);
		getContentPane().add(stats, BorderLayout.NORTH);
		JPanel panel2 = new JPanel();
		panel2.setSize(400,250);
		panel2.add(scroll);
		getContentPane().add(panel2, BorderLayout.CENTER);
		for(Zombie z: feld.zombies){
			JLabel str = new JLabel("Zombie "+z.id+": "+z.pos_x+", "+z.pos_y+"\n");
			panel2.add(str);
		}
		scroll.setVisible(true);
		panel2.setVisible(true);
		//getContentPane().add(zombies, BorderLayout.CENTER);
	
		setSize(500,500);
		setLocation(100,100);
		//pack();
		//this.setFocusable(true);
		
		//this.setAlwaysOnTop(true);
		setVisible(true);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		stats.repaint();
		
		//panel2.repaint();
		scroll.repaint();
	}
	private class Stats extends JPanel{
		JLabel position;
		JLabel koord;
		public Stats(){
			
			setSize(400,150);
			FlowLayout l = new FlowLayout();
			setLayout(l);
			position = new JLabel("Spielerposition: "+ sp.pos_x+", "+sp.pos_y);
			koord = new JLabel("Ausschnitt- Koordinaten");
			
			add(position,BorderLayout.NORTH );
			add(koord, BorderLayout.NORTH);
			
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			position.setText("Spielerposition: "+ sp.pos_x+", "+sp.pos_y);
			koord.setText("Ausschnitt- Koordinaten: "+fenster.ofView.x+" , "+fenster.ofView.y);
			
		}
	}
	@Override
	public void run() {
		while(true){
			float START = System.currentTimeMillis();
			//validate();
			stats.repaint();
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
