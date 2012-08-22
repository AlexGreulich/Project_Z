import java.awt.Point;


public class Entity {

	int energy, pos_x, pos_y;
	
	public Entity(){
		
	}
	public Point getPosition(){
		return new Point(pos_x,pos_y);
		
	}
}
