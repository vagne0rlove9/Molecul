import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

class Atom extends Component
{
	private String path;
	private Image img;
	private int count;
	private String elements;
	private ArrayList<Integer> lines; 
	public Atom(String s)
	{
		count=0;
		lines=new ArrayList<Integer>();
		elements="";
		path = s;
		img = new ImageIcon(s).getImage();
	}
	public Image getImage() 
	{
		return img;
	}		
	public String getPath()
	{
		return path;
	}
	public void addLink(int el)
	{
		count++;
		//elements+=el+" ";
		lines.add(el);
	}
	public ArrayList<Integer> getLines()
	{
		return lines;
	}
	public String getLink()
	{
		return elements;
	}
}