   import java.awt.*;
   import java.awt.event.*;
   import java.util.*;
   import java.io.*;
   import javax.swing.*;
    public class CheckerBoard 
   {
       public static void main (String args[])
      {
         JFrame checkerBoard = new JFrame();
         checkerBoard.setSize(400,400);
         checkerBoard.setTitle("CheckerBoard");
      checkerBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         String rows = JOptionPane.showInputDialog("Enter the Rows:");
         int row = Integer.parseInt(rows);
         
         String columns = JOptionPane.showInputDialog("Enter the Columns:");
         int col = Integer.parseInt(columns);
        
         JOptionPane.showConfirmDialog(null, "Are these the correct demensions: "
            +row+" x "+col+ "?", 
            "Yes or No", JOptionPane.YES_NO_OPTION);
         
         Container pane = checkerBoard.getContentPane();
         pane.setLayout(new GridLayout(row,col));
      	
         Color checker;
            
         for (int x = 1; x <=(row*col); x++)
         {
            int altr = 0;
            altr = (x-1) % col;
            altr += (x-1) / col;
            
            if (altr % 2 == 0)
            {
               checker = Color.black;
            }
            
            else
            {
               checker = Color.red;
            }
            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(400/row, 400/col));
            panel.setBackground(checker);
            pane.add(panel);
         }
         checkerBoard.setVisible(true);
      }
   }
