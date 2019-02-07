/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmn13_q2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisheva Shmuel
 */
public class Sudoku extends JPanel  {
   
     JTextField [] [] sudoku= new JTextField [9][9]; 
  
     private final JTextField[] labels;
     private JButton butset, butclear;
     int cnt=0;
    public Sudoku()
    {
      labels=new JTextField[9]; 
      
     setLayout(new BorderLayout());
      add(new SudokuDraw(),BorderLayout.CENTER );
       add(new Button(),BorderLayout.SOUTH);
      
     
     }
    
//A handy method for creating a Sudoku board 
    private class MySudoku extends JPanel
    {
        
        public MySudoku(int x)
        {
            JTextField txt;
           setLayout(new GridLayout(3,3));
           int row=(x/3) * 3;
           int col=x%3 *3;
            for(int i=row;i<row+3;i++)
              for(int j=col;j<col+3;j++)
              {
                txt=new JTextField();
                add(txt);
                txt.addActionListener(new  Handler());
                sudoku[i][j]=txt; 
              }
            
            
        }
    }
    // create board sudoku
        private class SudokuDraw extends JPanel
        {
          public  SudokuDraw()
          {
              setLayout(new GridLayout(3,3,3,3));
              for(int i=0;i<9;i++)
              {
                   add(new MySudoku(i) );
                
              }
          }
        
        }
        
      //crate button set and button clear  
      private class Button extends JPanel
      {
         public Button()
         {
             butset=new  JButton("SET");
            butclear=new JButton("CLEAR");  
            add(butset);
            add(butclear); 
            butset.addActionListener(new ButtonAction());
            butclear.addActionListener(new ButtonAction());
         }
       }
      
      
      
      private class Handler implements ActionListener
      {
         
        public void actionPerformed(ActionEvent e)
        {
            int i,j=0;
            boolean flag=true;
            JOptionPane pane = new JOptionPane();
            for(i=0;i<9&&flag;i++)
                for( j=0;j<9&&flag==true;j++ )
                  if (sudoku[i][j]==e.getSource())
                        flag=false;
               
             i--;j--;   
            
            flag=false;
            //check if number is in range 
            if(!check(e))
            {
                flag=true;
                JOptionPane.showMessageDialog(null, "Bad number,number has to be in range of 1-9","Error",JOptionPane.ERROR_MESSAGE);
            }
           
            // check if the value is legal.
            for(int a=0;a<9;a++) 
                if(sudoku[i][j].getText().equals(sudoku[i][a].getText())&& a!=j)
                {
                  pane.showMessageDialog(null, "Bad number, multiply number in row","Error",JOptionPane.ERROR_MESSAGE);
                  flag=true;
                 
                }
         
              // check if the value is legal.    
            for(int b=0;b<9 ;b++)
                if(sudoku[i][j].getText().equals(sudoku[b][j].getText())&&b!=i)
                {
                    pane.showMessageDialog(null, "Bad Input, multiply number in colum","Error",JOptionPane.ERROR_MESSAGE);
                    flag=true;
                }
               // check if the value is legal.           
            int row=(i/3)*3;
            int col=j/3 *3;
            for(int k=row;k<row+3;k++)  
                for(int d=col;d<col+3;d++)
                    if(sudoku[i][j].getText().equals(sudoku[k][d].getText())&&k!=i && d!=j)
                    {
                        JOptionPane.showMessageDialog(null, "Bad Input, multiply number in square","Error",JOptionPane.ERROR_MESSAGE);
                        flag=true;               
                    }
            
            if (flag)
                sudoku[i][j].setText("");  
                              
                                        
        }
      }

      
      //  //this method Taking care of the event of set and clear. 
       private class ButtonAction implements ActionListener
       {
            public void actionPerformed(ActionEvent ae)
            {
                Object e=ae.getSource();
               if(e==butclear)
                    clearSudoku();
               if(e==butset)
                     setSudoku();
               
            }   
        }
       
       
       /**
        * This method check if the value is ilegal. 
        * @param e- point of event-text 
        * @return  true if the value is num between 1-9
        */
       public boolean check(ActionEvent e)
       {
           int n;
           String st=e.getActionCommand();
           n=Integer.parseInt(st);
        
          if(n>=1 && n<10) 
              return true;
          return false;
       }
       
       
       /**
        * This method set the sudoku- set Text- number that choose .
        */
       public void setSudoku()
       {
           String t;
           for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
           {
                t=sudoku[i][j].getText();
               System.out.print(sudoku[i][j].getText());
               if(!(t.equals("") ))
                    sudoku[i][j].setEditable(false);
           }
       }
       
       
       /**
        * This method clear the sudoku
        */
        public void clearSudoku()
       {
          for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
               {
                 sudoku[i][j].setText("");
                 sudoku[i][j].setEditable(true) ;
               }
       }
        
       
       
    
}
      

      
      
      
   
    
    
    
   

    

    
    
    
   
