package hybrid.car.gui;
import hybrid.car.system.Environment;
import hybrid.car.system.Map;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*public class pointTest {
  public static void main(String[] args) {
    JFrame frame = new BounceThreadFrame(E);
    frame.show();
  }
}*/

class BounceThreadFrame extends JFrame {
  
  public BounceThreadFrame(Environment env) {
    setSize(430, 500);
    setTitle("Bounce");

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Container contentPane = getContentPane();
    canvas = new JPanel();
    contentPane.add(canvas, "Center");
    JPanel p = new JPanel();
    addButton(p, "Start", new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Ball b = new Ball(canvas);
        b.start();
      }
    });

    addButton(p, "Close", new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        canvas.setVisible(false);
        System.exit(0);
      }
    });
    contentPane.add(p, "South");
  }

  public void addButton(Container c, String title, ActionListener a) {
    JButton b = new JButton(title);
    c.add(b);
    b.addActionListener(a);
  }

  private JPanel canvas;
}


class Ball extends Thread {
	  private JPanel box;
	  
	  private static final int XSIZE = 10;

	  private static final int YSIZE = 10;

	  private int x = 0;

	  private int y = 0;
	  
	  private int path_loop = 0;
	  
	  private int roads_loop= 0;
	  
	  private double x_i = 0;

	  private double y_i = 0;
	  
	  private boolean rest;
	  
	  private Point currentStartPoint;
	  
	  private Point currentEndPoint;
	  
	  private List<Point> graphPoints;
	  
	  private int car_speed;
	  
	  private boolean finished;
	  
	  private Map mapData;
	  
	  
  public Ball(JPanel b) {
    box = b;
    graphPoints = new ArrayList<Point>();
    /*
    for(int i = 0; i < mapData.get_number_of_roads(); i++)
    {
    	graphPoints.add(mapData.getRoadInfo(i).getStartPoint());
    	graphPoints.add(mapData.getRoadInfo(i).getEndPoint());
    }
    */
    graphPoints.add(new Point(20, 20));
    graphPoints.add(new Point(150, 180));
    graphPoints.add(new Point(190, 140));
    graphPoints.add(new Point(240, 290));
    graphPoints.add(new Point(40, 200));
    graphPoints.add(new Point(200, 30));
    graphPoints.add(new Point(400, 400));
    this.x = graphPoints.get(0).x;
    this.y = graphPoints.get(0).y;
    currentStartPoint = graphPoints.get(0);
    currentEndPoint = graphPoints.get(1);
    car_speed = 1;
    finished = false;
  }
  
  public void run() {
	    try {
	      draw();
	      while (!(finished)) {
	        move();
	        sleep(75);
	      }
	    } catch (InterruptedException e) {
	    }
	  }

  public void draw() {
    Graphics g = box.getGraphics();
    this.rest = false;
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
  }

  public void move() {
    if (!box.isVisible())
      return;
    
    Graphics2D g2D = (Graphics2D)box.getGraphics();
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    try {
		Image img = ImageIO.read(new File("TXSatellite.png"));
		g2D.drawImage(img, 0, 0, null);
	} catch (IOException e) {
		e.printStackTrace();
	}
    
    g2D.setColor(Color.blue);
    for (int i = 0; i < graphPoints.size() - 1; i++) {
        int x1 = graphPoints.get(i).x;
        int y1 = graphPoints.get(i).y;
        int x2 = graphPoints.get(i + 1).x;
        int y2 = graphPoints.get(i + 1).y;
        //g2D.setStroke(new BasicStroke(1));
        g2D.drawLine(x1, y1, x2, y2);         
     }
    
    g2D.setColor(Color.red);
    for (int i = 0; i < graphPoints.size(); i++) {
        int x = graphPoints.get(i).x - 5;
        int y = graphPoints.get(i).y - 5;
        int ovalW = 8;
        int ovalH = 8;
        g2D.fillOval(x, y, ovalW, ovalH);
     }
    
    
    g2D.setColor(Color.black);
    g2D.setXORMode(box.getBackground());
    g2D.fillOval(x, y, XSIZE, YSIZE);
    
    if (this.path_loop <= 0)
    {
    	Point.Double nextPoint = getVelocity(currentStartPoint, currentEndPoint, car_speed);
    	this.x_i =  Math.abs(nextPoint.x - currentStartPoint.x);
    	this.y_i = Math.abs(nextPoint.y - currentStartPoint.y);
    	this.path_loop++;
    }
    else
    {
    	if(currentStartPoint.x >= currentEndPoint.x){
    		this.x =  currentStartPoint.x - (int)(x_i * (path_loop + 1));
    	}
    	else
    	{
    		this.x =  currentStartPoint.x + (int)(x_i * (path_loop + 1));
    	}
    	
    	if (currentStartPoint.y >= currentEndPoint.y)
    	{
    		this.y =  currentStartPoint.y - (int)(y_i * (path_loop + 1));
    	}
    	else
    	{
    		this.y =  currentStartPoint.y + (int)(y_i * (path_loop + 1));
    	}
    	
    	this.path_loop++;
    }
    
    //System.out.println("Next X is " + this.x);
    //System.out.println("Next y is " + this.y);
    g2D.fillOval(this.x, this.y, XSIZE, YSIZE);
    g2D.dispose();
    
    boolean xInRange = isNumberOnRange(currentStartPoint.x,currentEndPoint.x,this.x);
    boolean yInRange = isNumberOnRange(currentStartPoint.y,currentEndPoint.y,this.y);
    if(!(xInRange) || !(yInRange) || (x == currentEndPoint.x && y == currentEndPoint.y  ))
    {
    	roads_loop++;
    	
    	if(roads_loop ==  graphPoints.size() - 1)
    	{
    		finished = true;
    	}
    	else
    	{
    		currentStartPoint = graphPoints.get(roads_loop);
    		currentEndPoint = graphPoints.get((roads_loop + 1));
    	    this.x = currentStartPoint.x;
    	    this.y = currentStartPoint.y;
    	    this.path_loop = 0;
    	}	
    }
  }
  
  
  private Point.Double getVelocity(Point currentPosition, Point destinationPosition, double speed){
	  Point.Double nextPosition = new Point.Double();
      double angle = calcAngleBetweenPoints(currentPosition, destinationPosition);
      double distance = speed;
      Point.Double velocityPoint = getVelocity(angle, distance);
      nextPosition.x = currentPosition.x + velocityPoint.x;
      nextPosition.y = currentPosition.y + velocityPoint.y;
      return nextPosition;
  }
  
  private Point.Double getVelocity(double angle, double distance)
  {
	  Point.Double nextPosition = new Point.Double();
	  nextPosition.x=  (Math.cos(Math.toRadians(angle)) * distance);
	  nextPosition.y=  (Math.sin(Math.toRadians(angle)) * distance);
	  return nextPosition;
  }

  private double calcAngleBetweenPoints(Point p1, Point p2)
  {
      return Math.toDegrees( Math.atan2( p2.getY()-p1.getY(), p2.getX()-p1.getX() ) );
  }
  
  private boolean isNumberOnRange(int x, int y, int num)
  {
	  int max;
	  int min;
	  if(x >= y)
	  {
		  max = x;
		  min = y;
	  }
	  else
	  {
		  max = y;
		  min = x;  
	  }
	  
	  if(num >= min && num <= max)
		  return true;
	  
	  return false;
  }



}
