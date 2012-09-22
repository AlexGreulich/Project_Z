package editor;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class TileMonitorPanel extends JPanel{
	
	Editor ed;
	
	public TileMonitorPanel(Editor ed){
		this.ed = ed;
		setPreferredSize(new Dimension(500,500));
		setBounds(660, 20, 42, 70);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 42, 70);
		g.setColor(Color.white);
		g.drawString("Tile: ", 5, 13);
		g.drawString("" + ed.palette.aktuellesTile, 5, 25);
		BufferedImage tile = ed.aktuellekarte.images.get(ed.palette.aktuellesTile);
		g.drawImage(tile, 5, 32, this);	
	}

}
