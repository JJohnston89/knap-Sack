/*highArray.java
 *Name: Josh Johnston
 *Date: 6/27/2015
 */

class HighArray{
   
   private int[] a = new int[25];            // ref to array a
   private int[] sack = new int[25];
   private int nElems;               // number of data items
   private int index = 0;
   //-----------------------------------------------------------
   public HighArray(){         // constructor
      
                     
      nElems = 0;              // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(int searchKey){
                                    // find specified value
      int j;
      for(j = 0; j < nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(int value){    // put element into array
      
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(int value){
      
      int j;
      for(j = 0; j <n Elems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j == nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k = j; k < nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display(){             // displays array contents
                                     // for each element
      for(int j = 0; j < sack.length; j++){       
         if(sack[j] != 0)                    //not printing zeros
    	      System.out.print(sack[j] + ",");   	  
      }
    	  System.out.println("");      
      }
   //-----------------------------------------------------------
   public int getSize(){
   
	   return nElems;      	//returns the number of elements in the array
   }
   //-----------------------------------------------------------
   public void selectionSort(){
   
   int out, in, max;

   for(out = 0; out < nElems-1; out++){   // outer loop
      
      max = out;                     // max
      for(in = out + 1; in <nElems; in++) // inner loop
         if(a[in] > a[max] )         // if in greater,
             max = in;               // we have a new max
      swap(out, max);                // swap them
      }  // end for(out)
   }  // end selectionSort()
 //-----------------------------------------------------------
   private void swap(int one, int two){
   
   int temp = a[one];     //swapping two numbers
   a[one] = a[two];
   a[two] = temp;
   }
 //-----------------------------------------------------------
   public void knapSackHelper(){
   
	   int targetSum = a[0];
	   delete(targetSum);
		
      for(int i = 0; i < getSize(); i++){
        
          if(knapSack(targetSum, i)){       //if knapSack found a solution it will print				
              display();
              sack = new int[25];
            }	
        }
	 
   } //-----------------------------------------------------------
   private boolean knapSack(int sum, int choose){
   
       if(choose == getSize()){ 	//if choose equals the number of elements in a array return false
         
    	   return false;
       }
       if(a[choose] < sum){                        //if the number is less then sum
                                                 //call knapSack with a new sum and the next number
    	   boolean r = knapSack(sum - a[choose], choose + 1);           
           if(!r){ 
           
              return knapSack(sum, choose + 1);    //if knapSack return false call again with the same sum
           }                                       //and new number
           else{ 
           
               sack[index++] = a[choose];         //insert the number into the sack
               return true;
           }                   
       } 
       else if (a[choose] > sum){                     //if number is greater then sum call knapSack 
                                                    //with the same sum and new number
          return knapSack(sum, choose + 1);    
       } 
       else{ 
       
           sack[index++] = a[choose];
           return true;
       }
   } //end of knapSack()
//-----------------------------------------------------------
   }  // end class HighArray
////////////////////////////////////////////////////////////////
