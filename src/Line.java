import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Line extends Component 
{
	private int x1,y1,x2,y2;
	private ArrayList<Integer> atoms;
       
        public Line(Point p1,Point p2)
        {
        	atoms = new ArrayList<Integer>();
        	x1=p1.x;
        	x2=p2.x;
        	y1=p1.y;
        	y2=p2.y;
        }  
        public Line(int x1, int y1, int x2, int y2)
        {
        	atoms = new ArrayList<Integer>();
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
        public void setX1(int x)
        {
        	x1=x;
        }
        public void setX2(int x)
        {
        	x2=x;
        }
        public void setY1(int y)
        {
        	y1=y;
        }
        public void setY2(int y)
        {
        	y2=y;
        }
        public void addAtoms(int id1,int id2)
        {
        	atoms.add(id1);
        	atoms.add(id2);
        }
        public int checkPoint(int idAtom)
        {
        	if(atoms.get(0)==idAtom)
        		return 0;
        	if(atoms.get(1)==idAtom)
        		return 1;
        	return -1;
        }
}