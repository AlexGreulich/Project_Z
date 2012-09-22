package editor;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseExplorer extends JFrame{
	private JLabel label;
	private JPanel panel;
	
	public MouseExplorer(JPanel p){
		panel = p;
		
		label = new JLabel();
		add(label, BorderLayout.SOUTH);
		
		panel.addMouseListener(new MouseHandler());
		panel.addMouseMotionListener(new MouseMotionHandler());
		
		setSize(200, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MouseMotionHandler implements MouseMotionListener{
		@Override
		public void mouseMoved(MouseEvent e){
			label.setText("mouse moved at (" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseDragged(MouseEvent e){
			label.setText("mouse dragged at (" + e.getX() + ", " + e.getY() + ")");
		}
	}
	
	private class MouseHandler implements MouseListener{
		@Override
		public void mousePressed(MouseEvent e){
			label.setText("mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
		}
		
		@Override
		public void mouseClicked(MouseEvent e){
			label.setText("mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
		}
		
		@Override
		public void mouseEntered(MouseEvent e){
			label.setText("mouse entered at (" + e.getX() + ", " + e.getY() + ")");
		}
		
		@Override
		public void mouseExited(MouseEvent e){
			label.setText("mouse exited at (" + e.getX() + ", " + e.getY() + ")");
		}
		
		@Override
		public void mouseReleased(MouseEvent e){
			label.setText("mouse released at (" + e.getX() + ", " + e.getY() + ")");
		}
	}
}