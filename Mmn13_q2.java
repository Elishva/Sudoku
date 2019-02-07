/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmn13_q2;

import javax.swing.JFrame;

/**
 *
 * @author alisheva
 */
public class Mmn13_q2 {

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
