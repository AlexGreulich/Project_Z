import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JWindow;


public class Introscreen extends JWindow {

	
		JButton neu,quit;
		Font f;
		
	public Introscreen(){
		
		setLayout(new GridLayout(2,1));
		setBackground(Color.BLACK);
		
		ImageIcon end = new ImageIcon(getClass().getResource("gui/quitbutton.gif"));
		ImageIcon start =new ImageIcon(getClass().getResource("gui/startbutton.gif"));
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		neu = new JButton();
		neu.setIcon(start);
		neu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				onNeustart();
			}
		});
		
		add(neu, BorderLayout.NORTH);
		
		quit = new JButton();
		quit.setIcon(end);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		add(quit, BorderLayout.CENTER);
		
		
		this.setLocation(screensize.width/2-100, screensize.height/2-75);
		setSize(150,100);
		setVisible(true);
	}
	public void onNeustart(){
		dispose();
		new Spielfenster();
	}

}
