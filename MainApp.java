/*This is the main driver of the project. 
 *The user is prompt for weights. The user data is validated. 
 *Inserts the data into an array, and sorts the array by selection Sort. 
 *The sorted array calls knapSackHelper()
 *Name: Josh Johnston
 *Date: 6/27/2015
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MainApp{
   
   public static void main(String[] args){
      
     
      String input;           //hold user input
      int x;
      HighArray1 arr = new HighArray1();                
     

      input =JOptionPane.showInputDialog("Enter weights: ");   //prompting the user for input
      
      if(input == null){     //if ok or cancel is pushed without input the program exits 
      
    	  return;
      }
     
         Scanner scan = new Scanner(input);   //created a new scanner object
	 scan.useDelimiter( "\\D+" );
	 
	 while(scan.hasNextInt()){     //if no more integers the loop will terminate
	  
		 x = scan.nextInt();       
		 arr.insert(x);           //inserting x into the array
		 
	  }
	  scan.close();               //closing the scanner object
	  arr.selectionSort();       //sorting the array from largest to smallest	  
	  arr.knapSackHelper();      
	
     
      }  // end main()
//-----------------------------------------------------------
   }  // end class MainApp
////////////////////////////////////////////////////////////////
