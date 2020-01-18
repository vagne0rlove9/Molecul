import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Line extends Component 
{
	private int x1,y1,x2,y2;
       
        public Line(Point p1,Point p2)
        {
        	x1=p1.x;
        	x2=p2.x;
        	y1=p1.y;
        	y2=p2.y;
        }  
        public Line(int x1, int y1, int x2, int y2)
        {
        	this.x1=x1;
        	this.y1=y1;
        	this.x2=x2;
        	this.y2=y2;
        }  
        public int getX1() 
        {
        	return x1;
        }
        public int getY1() 
        {
        	return y1;
        }
        public int getX2() 
        {
        	return x2;
        }
        public int getY2() 
        {
        	return y2;
        }
}