package hybrid.car.gui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class pointTest {
  public static void main(String[] args) {
    JFrame frame = new BounceThreadFrame();
    frame.show();
  }
}

class BounceThreadFrame extends JFrame {
  public BounceThreadFrame() {
    setSize(400, 400);
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
  public Ball(JPanel b) {
    box = b;
  }

  public void draw() {
    Graphics g = box.getGraphics();
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
  }

  public void move() {
    if (!box.isVisible())
      return;
    
    
    
    Graphics2D g2D = (Graphics2D)box.getGraphics();
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    List<Point> graphPoints = new ArrayList<Point>();
    graphPoints.add(new Point(20, 20));
    graphPoints.add(new Point(150, 180));
    graphPoints.add(new Point(190, 140));
    graphPoints.add(new Point(240, 390));
    
    g2D.setColor(Color.blue);
    for (int i = 0; i < graphPoints.size() - 1; i++) {
        int x1 = graphPoints.get(i).x;
        int y1 = graphPoints.get(i).y;
        int x2 = graphPoints.get(i + 1).x;
        int y2 = graphPoints.get(i + 1).y;
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
    
    
    
    g2D.setColor(Color.green);
    
    g2D.setXORMode(box.getBackground());
    g2D.fillOval(x, y, XSIZE, YSIZE);
    x += dx ;
    y += dy ;
    Dimension d = box.getSize();
    if (x < 0) {
      x = 0;
      dx = -dx;
    }
    if (x + XSIZE >= d.width) {
      x = d.width - XSIZE;
      dx = -dx;
    }
    if (y < 0) {
      y = 0;
      dy = -dy;
    }
    if (y + YSIZE >= d.height) {
      y = d.height - YSIZE;
      dy = -dy;
    }
    g2D.fillOval(x, y, XSIZE, YSIZE);
    g2D.dispose();
  }

  public void run() {
    try {
      draw();
      for (int i = 1; i <= 200; i++) {
        move();
        sleep(10);
      }
    } catch (InterruptedException e) {
    }
  }

  private JPanel box;
  
  private static final int XSIZE = 10;

  private static final int YSIZE = 10;

  private int x = 0;

  private int y = 0;

  private int dx = 1;

  private int dy = 1;
}
