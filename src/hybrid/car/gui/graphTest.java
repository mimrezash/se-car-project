package hybrid.car.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class graphTest extends JPanel {
   private static final int MAX_SCORE = 20;
   private static final int PREF_W =400;
   private static final int PREF_H = 400;
   private static final int BORDER_GAP = 4;
   private static final Color GRAPH_COLOR = Color.green;
   private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
   private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
   private static final int GRAPH_POINT_WIDTH = 12;
   private static final int Y_HATCH_CNT = 10;
   private List<Integer> scores;

   public graphTest(List<Integer> scores) {
      this.scores = scores;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      List<Point> graphPoints = new ArrayList<Point>();
      for (int i = 0; i < scores.size(); i++) {
         int x1 = (int) 2*(i+ 1)* 10;
         int y1 = (int) (70*(i + 1));
         graphPoints.add(new Point(x1, y1));
      }

      // create x and y axes 
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
      g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

      /*
      // create hatch marks for y axis. 
      for (int i = 0; i < Y_HATCH_CNT; i++) {
         int x0 = BORDER_GAP;
         int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
         int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
         int y1 = y0;
         g2.drawLine(x0, y0, x1, y1);
      }
*/
      /*
      // and for x axis
      for (int i = 0; i < scores.size() - 1; i++) {
         int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (scores.size() - 1) + BORDER_GAP;
         int x1 = x0;
         int y0 = getHeight() - BORDER_GAP;
         int y1 = y0 - GRAPH_POINT_WIDTH;
         g2.drawLine(x0, y0, x1, y1);
      }
*/
      Stroke oldStroke = g2.getStroke();
      g2.setColor(GRAPH_COLOR);
      g2.setStroke(GRAPH_STROKE);
      for (int i = 0; i < graphPoints.size() - 1; i++) {
         int x1 = graphPoints.get(i).x;
         int y1 = graphPoints.get(i).y;
         int x2 = graphPoints.get(i + 1).x;
         int y2 = graphPoints.get(i + 1).y;
         g2.drawLine(x1, y1, x2, y2);         
      }

      g2.setStroke(oldStroke);      
      g2.setColor(GRAPH_POINT_COLOR);
      for (int i = 0; i < graphPoints.size(); i++) {
         int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
         int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
         int ovalW = GRAPH_POINT_WIDTH;
         int ovalH = GRAPH_POINT_WIDTH;
         g2.fillOval(x, y, ovalW, ovalH);
      }
      
      
      NextBall move = new NextBall(g);
      move.run();
      move.stop();
      
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      List<Integer> scores = new ArrayList<Integer>();
      Random random = new Random();
      int maxDataPoints = 5;
      int maxScore = 20;
      for (int i = 0; i < maxDataPoints ; i++) {
         scores.add(random.nextInt(maxScore));
      }
      graphTest mainPanel = new graphTest(scores);

      JFrame frame = new JFrame("DrawGraph");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);

      
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}


class NextBall extends Thread {
	
	  private JPanel box;

	  private static final int XSIZE = 5;

	  private static final int YSIZE = 5;

	  private int x = 0;

	  private int y = 0;

	  private int dx = 10;

	  private int dy = 10;
	  
	  Graphics g;
	  
  public NextBall(Graphics g1) {
    this.g = g1;
  }


  public void draw() {
    //g.fillOval(x, y, XSIZE, YSIZE);
    this.g.dispose();
  }

  public void move() {
	  /*
    if (!box.isVisible())
      return;
*/
    //this.g.paintComponent(g);
    //g.setXORMode(box.getBackground());
    //g.fillOval(x, y, XSIZE, YSIZE);
    x += dx;
    y += dy;
    Dimension d = new Dimension(400,400);
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
    g.fillOval(x, y, XSIZE, YSIZE);
    g.dispose();
  }

  public void run() {
    try {
      draw();
      for (int i = 1; i <= 100; i++) {
        move();
        sleep(30);
      }
    } catch (InterruptedException e) {
    }
  }
}
