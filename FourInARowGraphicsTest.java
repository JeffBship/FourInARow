/**
 * This program provides a demonstration of how to use the methods in
 * Game.java.
 * Game.setGrid colors the entire game grid according to the contents
 * of a 5x5 array
 * Game.setSpot colors one specific spot
 * 
 * @author Jeff Blankenship
 * @version 12/5/2022
 */

package cs152_four_in_a_row;

import java.util.Scanner;

public class FourInARowGraphicsTest {

  private static int[][] grid =
      {
          {0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0},
          {0, 0, 0, 0, 0},
      };

  public static void main(String[] args) throws InterruptedException {

    Scanner scan = new Scanner(System.in);

    Game game = new Game();

    int player = 1;

    for (int row = 0; row < 5; row++) {
      System.out.println("row is " + row);
      for (int col = 0; col < 5; col++) {
        Thread.sleep(250);
        // this causes player to alternate between 1 and 2
        player = player % 2 + 1;
        grid[col][row] = player;
        game.setGrid(grid);
      }
    }

    for (int row = 0; row < 5; row++) {
      for (int col = 0; col < 5; col++) {
        Thread.sleep(250);
        game.setSpot(col, row, 0);
      }
    }

  }
}
