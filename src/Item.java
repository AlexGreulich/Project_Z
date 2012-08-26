import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Item {

	int id, pos_x, pos_y;
	BufferedImage pic;
		
	public void setImage(String filename){
		try{
			pic = ImageIO.read(getClass().getResource("items/" + filename));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void setPosition(int x, int y){
		pos_x = x;
		pos_y = y;
	}
}
