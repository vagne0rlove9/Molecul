import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class WorkPanel extends JPanel implements MouseListener, MouseMotionListener {
	private Atom H;
	private Atom N;
	private ArrayList<Atom> atoms;
	private ArrayList<Line> lines;
	private Point p1,p2;
	private boolean click=false;
	private int prevX;
	private int prevY;
	private int point;
	private int prevLineX;
	private int prevLineY;
	private boolean flag1=false,flag2=false;
	private int index;
	private int indexLine;
	private boolean flag=true;
	private JButton but;
	private int startX=0;
	private int startY=0;
	private int c;
	private int id = -1;
	private int linkId1,linkId2;
	public WorkPanel(LayoutManager layout) 
	{
		super(layout);
		atoms = new ArrayList<Atom>();
		lines = new ArrayList<Line>();
		//H = new Atom("H.png");
		
	//	atoms.add(H);
		//this.setSize(new Dimension(300, 400));
		//this.setLocation(150, 10);
		//this.setBackground(Color.white);
		addMouseMotionListener(this);
	    addMouseListener(this);
	}
	
	public void addH(int x, int y)
	{
		Atom a=new Atom("H.png");
		a.setLocation(x,y);
		//startX+=10;
		//startY+=10;
		atoms.add(a);
		//atoms.add(new Atom("H.png"));
		repaint();
	}
	
	public void addN(int x, int y) 
	{
		Atom a=new Atom("N.png");
		a.setLocation(x,y);
		//startX+=10;
		//startY+=10;
		atoms.add(a);
		//atoms.add(new Atom("N.png"));
		repaint();
	}
	
	public void addR(int x, int y)
	{
		Atom a=new Atom("R.png");
		a.setLocation(x,y);
		//startX+=10;
		//startY+=10;
		atoms.add(a);
		//atoms.add(new Atom("R.png"));
		repaint();
	}
	
	public void addC(int x, int y)
	{
		Atom a=new Atom("C.png");
		a.setLocation(x,y);
		//startX+=10;
		//startY+=10;
		atoms.add(a);
		//atoms.add(new Atom("C.png"));
		repaint();
	}
	
	public void addO(int x, int y) 
	{
		Atom a=new Atom("O.png");
		a.setLocation(x,y);
		//startX+=10;
		//startY+=10;
		atoms.add(a);
		//atoms.add(new Atom("O.png"));
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i=0;i<lines.size();i++)
			g.drawLine(lines.get(i).getX1(),lines.get(i).getY1(),lines.get(i).getX2(), lines.get(i).getY2());
		for(int i=0;i<atoms.size();i++)
			g.drawImage(atoms.get(i).getImage(),atoms.get(i).getX(),atoms.get(i).getY(), this);
	}
	
	 @Override
	 public void mouseClicked(MouseEvent e) 
	 {
		 //System.out.print(c);
		 
		 if (SampleImage.clicked) {
	            c++;
	            if (c == 1){
//	                myLine.setX1(e.getX());
//	                myLine.setY1(e.getY());
	            	for (int i = atoms.size() - 1; i >= 0; i--) {
                        if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
                                (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)&&(c==1)) {
                        	p1=e.getPoint();
                        	flag1=false;
                        	id=i;
                        	linkId1=i;
                            break;
                        }
                        else flag1=true;
                    }
	            	if(atoms.size()==0)
	            		flag1=true;
	            } else {
//	                myLine.setX2(e.getX());
//	                myLine.setY2(e.getY());
	                SampleImage.clicked = false;
	            }
	            if (c == 2) {
	            	for (int i = atoms.size() - 1; i >= 0; i--) {
                        if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
                                (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)&&(c==2)) {
                        	p2=e.getPoint();
                        	flag1=false;
                        	linkId2=i;
                        	if(id==i)
                        		flag1=true;
                            break;
                        }
                        else flag1=true;
                    }
	            	if(atoms.size()==0)
	            		flag1=true;
	            	if(flag1==true)
	            	{
	            		p2=e.getPoint();
		            	p2.x=0;
		            	p2.y=0;
		            	p1=e.getPoint();
		            	p1.x=0;
		            	p1.y=0;
	            	}
	            	//atoms.get(linkId1).addLink(linkId2);
	            	//atoms.get(linkId2).addLink(linkId1);
	            	
	                Line ln = new Line(p1,p2);
	                //elements.add(ln);
	                ln.addAtoms(linkId1, linkId2);
	                lines.add(ln);
	                atoms.get(linkId1).addLink(lines.size()-1);
	                atoms.get(linkId2).addLink(lines.size()-1);
	                
	                c = 0;
	                repaint();
	            }
	        }
		 if (SampleImage.deleted) {
			 SampleImage.deleted = false;
	            if (atoms.size() != 0) {
	                for (int i = atoms.size() - 1; i >= 0; i--) {
	                        if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
	                                (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)) {
	                            atoms.remove(i);
	                            break;
	                        }
	                    }
	                }
	            if (lines.size() != 0) {
	            	int sizeX,sizeY;
	                for (int i = lines.size() - 1; i >= 0; i--) {
	                	sizeX=Math.abs(lines.get(i).getX1()-lines.get(i).getX2());
	                	sizeY=Math.abs(lines.get(i).getY1()-lines.get(i).getY2());
	                	if(sizeX<=5)
	                		sizeX+=10;
	                	if(sizeY<=5)
	                		sizeY+=10;
	                	if((lines.get(i).getX1()<=lines.get(i).getX2())&&(lines.get(i).getY1()<=lines.get(i).getY2()))
	                        if ((e.getX() >= lines.get(i).getX1()) && (e.getX() <= lines.get(i).getX1() + sizeX) &&
	                                (e.getY() >= lines.get(i).getY1()) && (e.getY() <= lines.get(i).getY1() + sizeY)) {
	                            lines.remove(i);
	                            break;
	                        }
	                	if((lines.get(i).getX1()>=lines.get(i).getX2())&&(lines.get(i).getY1()<=lines.get(i).getY2()))
	                        if ((e.getX() >= lines.get(i).getX2()) && (e.getX() <= lines.get(i).getX2()+sizeX) &&
	                                (e.getY() >= lines.get(i).getY1()) && (e.getY() <= lines.get(i).getY1()+sizeY)) {
	                            lines.remove(i);
	                            break;
	                        }
	                	if((lines.get(i).getX1()<=lines.get(i).getX2())&&(lines.get(i).getY1()>=lines.get(i).getY2()))
	                        if ((e.getX() >= lines.get(i).getX1()) && (e.getX() <= lines.get(i).getX1()+sizeX) &&
	                                (e.getY() >= lines.get(i).getY2()) && (e.getY() <= lines.get(i).getY2()+sizeY)) {
	                            lines.remove(i);
	                            break;
	                        }
	                	if((lines.get(i).getX1()>=lines.get(i).getX2())&&(lines.get(i).getY1()>=lines.get(i).getY2()))
	                        if ((e.getX() >= lines.get(i).getX2()) && (e.getX() <= lines.get(i).getX2()+sizeX) &&
	                                (e.getY() >= lines.get(i).getY2()) && (e.getY() <= lines.get(i).getY2()+sizeY)) {
	                            lines.remove(i);
	                            break;
	                        }
	                    }
	                }
	                repaint();
	            }
	 }
	 
	 public String check()
	 {
		 if(atoms.size()>3)
			 return "Удалите лишние атомы";
		 if(atoms.size()<3)
			 return "Добавьте атомы";
		 if((lines.size()<2))
			 return "Добавьте связи";
		 if((lines.size()>2))
			 return "Удалите лишние связи";
		 int countO=0,countH=0,idO = 0;
		 int []idH= {0,0};
		 for (int i = atoms.size() - 1; i >= 0; i--) 
		 {
             if(atoms.get(i).getPath().equals("H.png"))
             {
            	 idH[countH]=i;
            	 countH++;        
             }
             if(atoms.get(i).getPath().equals("O.png"))
             {
            	 countO++;
            	 idO=i;            	 
             }
             if((countO==1)&&(countH==2))
             {
            	 String []s=atoms.get(idO).getLink().split(" ");
            	 String []s1=atoms.get(idH[0]).getLink().split(" ");
            	 String []s2=atoms.get(idH[1]).getLink().split(" ");
            	 if((s.length==2)&&(!s[0].equals(s[1]))&&(Integer.valueOf(s1[0])==idO)&&(Integer.valueOf(s2[0])==idO)&&(s1.length==1)
            			 &&(s2.length==1))
            		 return "Это вода!";
            	 else return"Ошибка!";
             }
         }
		 return "0";
	 }
	 
	 public String save(String name) 
	 {
		 Date date=new Date();
		 try
	        {
			 	File folder=new File("save");
			 	if(!folder.exists())
				 	folder.mkdir();
			 	if(name==null)
			 		return "Введите имя файла!";
			 	if(name.equals(""))
			 		return "Введите имя файла!";
			 	File file = new File(folder.getName()+"/"+name+".txt");
			 	FileWriter writer;
			 	
			 	if(file.exists())
			 		return "Такой файл уже существует, введите другое имя!";
			 	else writer = new FileWriter(folder.getName()+"/"+name+".txt", false);
	           // запись всей строки
	            String text = "atoms\r\n";
	            //for(int i=0;i<lines.size();i++)
	    			
	    		for(int i=0;i<atoms.size();i++)
	    		{
	    			text+=atoms.get(i).getPath()+" ";
	    			text+=atoms.get(i).getX()+" ";
	    			text+=atoms.get(i).getY()+" ";
	    			text+="\r\n";
	    		}
	    		text+="lines\r\n";
	    		for(int i=0;i<lines.size();i++)
	    		{
	    			text+=lines.get(i).getX1()+" ";
	    			text+=lines.get(i).getY1()+" ";
	    			text+=lines.get(i).getX2()+" ";
	    			text+=lines.get(i).getY2()+" ";
	    			text+="\r\n";
	    		}
	            writer.write(text);
	            writer.flush();
	            writer.close();
	        }
	        catch(IOException ex){
	        	System.out.println(ex.getMessage());
	        	return ex.getMessage();
	        } 
		 
		 return "Молекула сохранена!";
	 }

	 public String load(String name) 
	 {
		 try {
			 File folder=new File("save");
			 	if(!folder.exists())
			 		return "Сохранений нет!";
			 	
			 	if(name==null)
			 		return "Введите имя файла!";
			 	if(name.equals(""))
			 		return "Введите имя файла!";
			 	File file = new File(folder.getName()+"/"+name+".txt");
	            
	            //создаем объект FileReader для объекта File
	            FileReader fr = new FileReader(file);
	            //создаем BufferedReader с существующего FileReader для построчного считывания
	            BufferedReader reader = new BufferedReader(fr);
	            // считаем сначала первую строку
	            String line = reader.readLine();
	            line = reader.readLine();
	            String []buf;
	            boolean flag=true;
	            while (line != null) {
	                //System.out.println(line);
	                // считываем остальные строки в цикле
	            	if((!line.equals("lines"))&&(flag)) 
	            	{
	            		buf=line.split(" ");
	            		//System.out.print(buf[1]);
	            		switch(buf[0])
	            		{
	            		case ("H.png"):
	            			addH(Integer.valueOf(buf[1]),Integer.valueOf(buf[2]));
	            			break;
	            		case ("N.png"):
	            			addN(Integer.valueOf(buf[1]),Integer.valueOf(buf[2]));
	            			break;
	            		case ("C.png"):
	            			addC(Integer.valueOf(buf[1]),Integer.valueOf(buf[2]));
	            			break;
	            		case ("O.png"):
	            			addO(Integer.valueOf(buf[1]),Integer.valueOf(buf[2]));
	            			break;
	            		case ("R.png"):
	            			addR(Integer.valueOf(buf[1]),Integer.valueOf(buf[2]));
	            			break;
	            		}
	            		//System.out.print(line.toCharArray()[i]);
	            	}
	            	else 
	            	{
	            		flag=false;
	            		if(line.equals("lines"))
	            			line = reader.readLine();
	            		//System.out.print(line);
	            		if(line!=null)
	            		{
	            			buf=line.split(" ");
	            			//System.out.print(buf[1]);
		            		Line ln = new Line(Integer.valueOf(buf[0]),Integer.valueOf(buf[1]),Integer.valueOf(buf[2]),Integer.valueOf(buf[3]));
			                //elements.add(ln);
			                lines.add(ln);
		                }
	            	}
	                	
	                line = reader.readLine();
	                
	            }
	            reader.close();
	            fr.close();
	        } catch (FileNotFoundException e) {
	            //e.printStackTrace();
	            return e.getMessage();
	        } catch (IOException e) {
	            //e.printStackTrace();
	            return e.getMessage();
	        }
		 return "Молекула загружена!";
	 }
	 
	    @Override
	    public void mousePressed(MouseEvent e) {
	    	for (int i = atoms.size() - 1; i >= 0; i--) {
	             if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
	                     (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)) {
	             	click=true;
	                break;
	             }
	             else click=false;
	         }
	        for (int i = atoms.size() - 1; i >= 0; i--) {
	            if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
	                    (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)) {
	                prevX = atoms.get(i).getX() - e.getX();
	                prevY = atoms.get(i).getY() - e.getY();
	                if((atoms.get(i).getX()!=prevX)&&(atoms.get(i).getY()!=prevY))
		                if(atoms.get(i).getLines().size()!=0)
		                {
			                ArrayList<Integer> l=atoms.get(i).getLines();
			                if(lines.size()!=0)
			                {
			                	int point1=lines.get(l.get(0)).checkPoint(i);
			                	point=point1;
				                if(point1==0)
				                {
				                	prevLineX = lines.get(l.get(0)).getX1() - e.getX();
					                prevLineY = lines.get(l.get(0)).getY1() - e.getY();
				                }
				                if(point1==1)
				                {
				                	prevLineX = lines.get(l.get(0)).getX2() - e.getX();
					                prevLineY = lines.get(l.get(0)).getY2() - e.getY();
				                }
				                indexLine = l.get(0);
			                }
			                if(lines.size()!=0)
		                    	updateLocationLine(e,point);
		                }
	                index = i;
	                //Component c = e.getComponent();
	                //if (c instanceof Atom) {
	                    updateLocation(e);
	                //}
	                    
	                break;
	            }
	        }
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	        for (int i = atoms.size() - 1; i >= 0; i--) {
	            if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
	                    (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)) {
	            	//Component c = e.getComponent();
	                //if (c instanceof Atom) {
	                    updateLocation(e);
	               // }
	                    if(atoms.get(i).getLines().size()!=0)
		                    if(lines.size()!=0)
		                    	updateLocationLine(e,point);
	                break;
	            }
	        }
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {

	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
	        for (int i = atoms.size() - 1; i >= 0; i--) {
	            if ((e.getX() > atoms.get(i).getX()) && (e.getX() < atoms.get(i).getX() + 50) &&
	                    (e.getY() > atoms.get(i).getY()) && (e.getY() < atoms.get(i).getY() + 50)) {
	            	//if(click)
	            		updateLocation(e);
	                //ArrayList<Integer> l=atoms.get(i).getLines();
	                if(atoms.get(i).getLines().size()!=0)
	                    if(lines.size()!=0)
	                    	updateLocationLine(e,point);
	                break;
	            }
	        }

//	        if(isLine){
//	            points.add(new Point(e.getX(), e.getY()));
//	            repaint();
//	        }
	    }

	    @Override
	    public void mouseMoved(MouseEvent e) {

	    }

	    private void updateLocation(MouseEvent e) {
	        atoms.get(index).setLocation(prevX + e.getX(), prevY + e.getY());
	        repaint();
	    }
	    private void updateLocationLine(MouseEvent e,int flag) {
	        //lines.get(indexLine).setLocation(prevLineX + e.getX(), prevLineY + e.getY());
	    	if(flag==0)
	    	{
	    		lines.get(indexLine).setX1(prevLineX + e.getX());
	    		lines.get(indexLine).setY1(prevLineY + e.getY());
	    	}
	    	if(flag==1)
	    	{
	    		lines.get(indexLine).setX2(prevLineX + e.getX());
	    		lines.get(indexLine).setY2(prevLineY + e.getY());
	    	}
	        repaint();
	    }
	
}
