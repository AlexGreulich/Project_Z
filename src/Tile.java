import java.awt.image.BufferedImage;


public class Tile {
	
	BufferedImage image;
	boolean istBegehbar =true;
	
	public Tile(BufferedImage img){
		image = img;
	}
	public BufferedImage getImage(){
		return image;
	}
}
