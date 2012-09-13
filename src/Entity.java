import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Entity {

	int energy, pos_x, pos_y;
	BufferedImage charset;
	BufferedImage[] charset_oben;
	BufferedImage[] charset_unten;
	BufferedImage[] charset_links;
	BufferedImage[] charset_rechts;
	BufferedImage[] charset_oben_links;
	BufferedImage[] charset_oben_rechts;
	BufferedImage[] charset_unten_links;
	BufferedImage[] charset_unten_rechts;
	
	public int getPosx(){
		return pos_x;
	}
	
	public int getPosy(){
		return pos_y;
	}
	
	public void setCharset(String filename){
		try{
			charset = ImageIO.read(getClass().getResource("charsets/" + filename));
			
			for(int y = 0;y < 8;y++){
				for(int x = 0; x < 8; x++){
					switch(y){
					case 0:
						charset_unten[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 1:
						charset_links[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 2:
						charset_rechts[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 3:
						charset_oben[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 4:
						charset_unten_links[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 5:
						charset_unten_rechts[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 6:
						charset_oben_links[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					case 7:
						charset_oben_rechts[x] = charset.getSubimage(x*32, y*48, 32, 48);
						break;
					}
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
