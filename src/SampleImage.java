import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class SampleImage extends JFrame {
	public static boolean clicked=false;
	public static boolean deleted=false;
	public static int id_line=0;
	public static int c=0;
	public static boolean dual=false;
    public static Point p1,p2;
	private int flag;
    //final private JPanel panel;
    //final private JPanel panel1;
	private Image img1;
	private Image img2;
	private WorkPanel workPanel;
	private JFrame f;
	JButton buttonH;
    JButton buttonN;
    JButton buttonR;
    JButton buttonC;
    JButton buttonO;
    JButton buttonDel;
    JButton buttonLine;
    JButton buttonSave;
    JButton buttonLoad;
    JButton buttonCheck;
    Box buttonBox;
    public SampleImage() {
    	//this.setLayout(null);
    	f = new JFrame("Molecular designer");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null); 
//        panel = new JPanel();
//        
//        //panel.setBackground(Color.BLUE);
//       
////        panel.setSize(new Dimension(60, 60));
////        panel.setLocation(10, 10);
////        panel.setOpaque(false);
////        try {
////			//panel.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\ ирилл\\Pictures\\descent\\H.png")))));
////        	panel.add(new JLabel(new ImageIcon(ImageIO.read(new File("H.png")))));
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////        MoveListener ml = new MoveListener(panel, this, 0);
////        panel.addMouseListener(ml);
////        panel.addMouseMotionListener(ml);
////        this.add(panel);
//        panel1 = new JPanel();
////        panel1.setSize(new Dimension(60, 60));
////        panel1.setLocation(10, 80);
////        panel1.setOpaque(false);
////        //panel1.setBackground(Color.RED);
////        try {
////			//panel1.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\ ирилл\\Pictures\\descent\\N.png")))));
////			panel1.add(new JLabel(new ImageIcon(ImageIO.read(new File("N.png")))));
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////        MoveListener ml1 = new MoveListener(panel1, this, 1);
////        panel1.addMouseListener(ml1);
////        panel1.addMouseMotionListener(ml1);
////        this.add(panel1);
////       
//        JPanel panel2 = new JPanel();
//        JButton createLine=new JButton("Create Line");
//        panel2.setLocation(10, 150);
//        panel2.setSize(new Dimension(110, 140));
//        panel2.add(createLine);
//        JButton deleteAtom=new JButton("Delete atom");
//        //panel2.setLocation(10, 190);
//        panel2.add(deleteAtom);
//       // this.add(panel2);
//        JButton deleteLine=new JButton("Delete line");
//        //panel2.setLocation(10, 220);
//        panel2.add(deleteLine);
//        //this.add(panel2);
//        
//        createLine.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//            	clicked=true;
//            }
//        });
//        deleteAtom.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//            	deleted=true;
//            }
//        });
////        Images im = new Images();
////        this.add(im);
////        MoveListener ml=new MoveListener(im, f, flag);
////        im.addMouseListener(ml);
////        im.addMouseMotionListener(ml);
//        //Image i=new ImageIcon("Line.png").getImage();
//        
////        i=createResizedCopy(i,50,50,false);
////        JLabel l1=new JLabel();
////        l1.setIcon((Icon) i);
////        JPanel i1=new JPanel();
////        i1.add(l1);
////        this.add(i1);
        
        
        BorderLayout layout = new BorderLayout();
        workPanel = new WorkPanel(layout);
        workPanel.setPreferredSize(new Dimension(500, 500));
        f.getContentPane().add(BorderLayout.CENTER,workPanel);
        f.setVisible(true);
        
        buttonH = new JButton(new ImageIcon("H.png"));
        buttonN = new JButton(new ImageIcon("N.png"));
        buttonR = new JButton(new ImageIcon("R.png"));
        buttonC = new JButton(new ImageIcon("C.png"));
        buttonO = new JButton(new ImageIcon("O.png"));
        buttonDel = new JButton("Delete");
        buttonLine = new JButton("Create Line");
        buttonSave = new JButton("Save");
        buttonLoad = new JButton("Load");
        buttonCheck = new JButton("Check");
        buttonH.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	workPanel.addH(200,200);
            }
        });
        buttonR.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	workPanel.addR(200,200);
            }
        });
        buttonC.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	workPanel.addC(200,200);
            }
        });
        buttonO.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	workPanel.addO(200,200);
            }
        });
        buttonN.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	workPanel.addN(200,200);
            }
        });
        buttonDel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	deleted=true;
            }
        });
        buttonSave.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	String res=JOptionPane.showInputDialog("¬ведите название файла");
            	String ans=workPanel.save(res);
            	JOptionPane.showMessageDialog(f,ans);
            	
            }
        });
        buttonLoad.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	String res=JOptionPane.showInputDialog("¬ведите название файла");
            	String ans=workPanel.load(res);
            	JOptionPane.showMessageDialog(f,ans);
            	
            }
        });
        buttonCheck.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	String ans=workPanel.check();
            	JOptionPane.showMessageDialog(f,ans);
            }
        });
        buttonLine.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
            	clicked=true;
            }
        });
        buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.add(buttonH);
        buttonBox.add(buttonN);
        buttonBox.add(buttonR);
        buttonBox.add(buttonC);
        buttonBox.add(buttonO);
        buttonBox.add(buttonDel);
        buttonBox.add(buttonLine);
        buttonBox.add(buttonSave);
        buttonBox.add(buttonLoad);
        //buttonBox.add(buttonCheck);
        f.add(BorderLayout.WEST, buttonBox);
        f.pack();
        //panel.setOpaque(false);
        //this.add(workPanel);
        
        
        
    }
    

}