import java.util.Scanner;

public class FourInARowGraphicsTest {
  
  private static int[][] grid = 
    {
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
     {0,0,0,0,0}, 
    };
    
  public static void main (String[] args) throws InterruptedException{
    
    Scanner scan = new Scanner(System.in);
    
    Game game = new Game();
    
    int shade = 0;
    int count = 0;
    
    
    for(int y = 0; y<5; y++){    
      System.out.println("y is "+y);
      for(int x = 0; x<5; x++){
        Thread.sleep(250);
        count++;
        shade = count%2 + 1;
        System.out.println(" " + count + " " + shade);
        grid[x][y] = shade;
        game.setGrid(grid);
      }
    }
    
    
  }
    
}
