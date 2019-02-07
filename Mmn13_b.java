/*
 
 */
package mmn13_b;

import javax.swing.JFrame;

/**
 *
 * @author Elisheva Shmuel
 * 209320761
 */
public class Mmn13_b {  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        JFrame frame =new JFrame ("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        Sudoku s=new  Sudoku();
        frame.add(s);
        frame.setVisible(true);
        
    }
    
}
