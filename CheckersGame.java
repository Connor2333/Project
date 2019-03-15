import java.awt.EventQueue;

import javax.swing.JFrame;

public class CheckersGame extends JFrame
{
   public CheckersGame(String title)
   {
      super(title);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      Board board = new Board();
      board.add(new Checker(CheckerType.RED_REGULAR), 1, 1);
      board.add(new Checker(CheckerType.RED_REGULAR), 1, 3);
      board.add(new Checker(CheckerType.RED_REGULAR), 1, 5);
      board.add(new Checker(CheckerType.RED_REGULAR), 1, 7);
      board.add(new Checker(CheckerType.RED_REGULAR), 2, 2);
      board.add(new Checker(CheckerType.RED_REGULAR), 2, 4);
      board.add(new Checker(CheckerType.RED_REGULAR), 2, 6);
      board.add(new Checker(CheckerType.RED_REGULAR), 2, 8);
      board.add(new Checker(CheckerType.RED_REGULAR), 3, 1);
      board.add(new Checker(CheckerType.RED_REGULAR), 3, 3);
      board.add(new Checker(CheckerType.RED_REGULAR), 3, 5);
      board.add(new Checker(CheckerType.RED_REGULAR), 3, 7);

      
      board.add(new Checker(CheckerType.BLACK_REGULAR), 6, 2);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 6, 4);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 6, 6);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 6, 8);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 7, 1);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 7, 3);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 7, 5);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 7, 7);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 8, 2);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 8, 4);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 8, 6);
      board.add(new Checker(CheckerType.BLACK_REGULAR), 8, 8);

      setContentPane(board);

      pack();
      setVisible(true);
   }

   public static void main(String[] args)
   {
      Runnable r = new Runnable()
                   {
                      @Override
                      public void run()
                      {
                         new CheckersGame("Checkers");
                      }
                   };
      EventQueue.invokeLater(r);
   }
}
