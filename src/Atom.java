import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

class Atom extends Component
{
	private String path;
	private Image img;
	private int count;
	private String elements;
	public Atom(String s)
	{
		count=0;
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
		elements+=el+" ";
	}
	public String getLink()
	{
		return elements;
	}
}