import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class FourInARowGraphics extends JPanel {
  
  //Constants used for the spacing and size of the gamespace components
  private final int  BUFFER = 30;    //buffer around all edges
  private final int  SEPARATION =100; //px from center to center of gamepiece
  private final int  DIAMETER = 60;  //diameter of games circles
  
  //define the CCSU logo color with RGB values
  final Color CCSU_BLUE = new Color(26, 71, 132);
  
  // instance variable: grid for the game.
  // 0:black  (player)1:blue  (player)2:red
  private static int[][] grid = 
    {
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
    };

  public Game() throws InterruptedException {
    JFrame frame = new JFrame("CS-151 Four In A Row");
    frame.add(this);
    frame.setSize(550, 550);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }  
    
  //sets the specified element of the grid array to
  //the given value, which will in turn change the color
  public void setSpot(int x, int y, int value){
    grid[x][y] = value;  
    this.repaint();
  }
  
  //sets the entire grid[][] to the pass parameter
  public void setGrid(int[][] newGrid){
    this.grid = newGrid.clone();
    this.repaint();
  }
    
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
    
    //set up a canvas to paint on
    Graphics2D g2 = (Graphics2D) g;  
    
    //add the yellow background
    g2.setColor(Color.yellow);
    Rectangle rect1 = new Rectangle(0,0,520,520); //x,y,width,height
    g2.fill(rect1);
    
    //fill in the game positions with circles
    //of the appropriate color
    for (int col=0; col<5; col++){
      for (int row=0; row<5; row++){
        //assign color per grid
        if (grid[col][row]==0) {
          g2.setColor(Color.lightGray);
        }else if (grid[col][row]==1) {
          g2.setColor(Color.blue);
        }else if (grid[col][row]==2) {
          g2.setColor(Color.red);
        }else {
          //should never get here
          System.out.println("Error in grid value.  0,1,2 are acceptable.");
        }
        //calculate the position 
        int xPosit = BUFFER + col * SEPARATION;
        int yPosit = BUFFER + row * SEPARATION;
        
        //construct the circle
        Ellipse2D.Double ellipse = new Ellipse2D.Double(xPosit,yPosit,DIAMETER,DIAMETER);
        g2.fill(ellipse);
      } //for (int row=0
    }//for (int col=0
  }
  
  public static void redraw(Game game){
    game.repaint(); 
  }
  
  
}