import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Entity {

	int energy, pos_x, pos_y;
	BufferedImage charset;
	
	public int getPosx(){
		return pos_x;
	}
	
	public int getPosy(){
		return pos_y;
	}
	
	public void setCharset(String filename){
		try{
			charset = ImageIO.read(getClass().getResource("charsets/" + filename));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
