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
	public Atom(String s)
	{
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
}