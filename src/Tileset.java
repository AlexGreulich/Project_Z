import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Tileset {
	ArrayList<Tile> tiles;
	BufferedImage tileset;
	
	public Tileset(){
		try {
			tileset = ImageIO.read(getClass().getResource("tilesets/Tileset_neu_32.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tilesetLaden(tileset);
	}
	
	
	public void tilesetLaden(BufferedImage set){
		tiles = new ArrayList<Tile>();
		int Anzahl_x = set.getWidth()/32;											//64
		int Anzahl_y = set.getHeight()/32;
		
		for(int x=0;x<Anzahl_x;x++){
			for(int y=0;y<Anzahl_y;y++){
				Tile t = new Tile((set.getSubimage(x*32, y*32, 32, 32)));		//64
				tiles.add(t);
			}
		}
	}
	
	public BufferedImage getTileImage(int id){
		return tiles.get(id).image;
	}
	
}
