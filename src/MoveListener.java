import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

  class MoveListener extends MouseAdapter {
 
	  	private int id;
        private Point old;
        private JPanel pan;
        private JFrame f;
        private int startX, startY;
        private Color bg;
        private int flag;
        //private JPanel line;

        private WorkPanel im1;
        public MoveListener(JPanel p, JFrame f, int flag)
        {
        	//im1=p;
        	//id=SampleImage.id_atom;
        	SampleImage.id_line++;
        	pan=p;
        	this.f=f;
        	startX=p.getX();
        	startY=p.getY();
        	bg=p.getBackground();
        	this.flag=flag;
        	//JOptionPane.showMessageDialog(f, "Error: enter velocity again!");
        }
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            old = e.getPoint();
           
        }
        
        @Override 
        public void mouseClicked(MouseEvent e) 
        {
        	
        }
        
        
        
        
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            if((startX==pan.getX())&&(startY==pan.getY()))
            {
            	//JPanel panel11 = new JPanel();
//                panel11.setSize(new Dimension(60, 60));
//                panel11.setLocation(startX, startY);
//                panel11.setOpaque(false);
                //panel1.setBackground(Color.RED);
//                if(flag==0)
//                	 try {
// 	        			//panel1.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Кирилл\\Pictures\\descent\\N.png")))));
// 	                	//panel11.add(new JLabel(new ImageIcon(ImageIO.read(new File("H.png")))));
// 	        		} catch (IOException exc) {
// 	        			// TODO Auto-generated catch block
// 	        			exc.printStackTrace();
// 	        		}
//                if(flag==1)
//	                try {
//	        			//panel1.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Кирилл\\Pictures\\descent\\N.png")))));
//	                	//panel11.add(new JLabel(new ImageIcon(ImageIO.read(new File("N.png")))));
//	        		} catch (IOException exc) {
//	        			// TODO Auto-generated catch block
//	        			exc.printStackTrace();
//	        		}
//                MoveListener ml1 = new MoveListener(panel11, f, flag);
//                panel11.addMouseListener(ml1);
//                panel11.addMouseMotionListener(ml1);
//         
//                f.add(panel11);
                f.setVisible(true);
            }
            pan.setLocation(pan.getX() + e.getX() - (int)old.getX(), pan.getY() + e.getY() - (int)old.getY());
            //old = e.getPoint();
        }
	
        
        private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT){
        	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        	Graphics2D g = resizedImage.createGraphics();
        	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        	g.dispose();

        	return resizedImage;
        	}
    }