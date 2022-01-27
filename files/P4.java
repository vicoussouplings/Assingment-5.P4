/* CSCI 1105 - Assingment 5
Olumayowa Oluwasanmi - B00785929
Brief description of program: Implement the full rolodex with methods as functionalities.
*/

import java.util.Scanner;

/*
* Final problem of A5!
* You only have to alter the parts where the comments tell you to do so
* Remove the comments and add the appropriate method calls
* 
* COPY ALL OF YOUR METHODS FROM THE PREVIOUS PROBLEM INTO THIS FILE AFTER THE MAIN METHOD
*/

public class P4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        //(Starter)Q4
        final int ADD_OP = 1;
        final int SEARCH_OP = 2;
        final int REMOVE_INDEX_OP = 3;
        final int REMOVE_NAME_OP = 4;
        final int PRINT_OP = 5;

        String[] nameList = new String[30];
        int entryCount = 0;
        System.out.print("Welcome!\nPlease Select an option: ");
        int selectedOption =  kb.nextInt();

        while (selectedOption != 0){
            
            if(selectedOption == ADD_OP){
                //We just read an int, therefore we need to get rid of the \n that is left there
                kb.nextLine();

                if(entryCount == 30){
                    System.out.println("The list is full!");
                }
                
                else {
                    System.out.println("What's the name? ");
                    String name = kb.nextLine();
                    /* 
                    *  Handle adding here
                    *  No duplicates allowed, if the name is already in the list
                    *    you should print: Name already on the list
                    */
                   addItem(name, nameList, entryCount);
                  
                   for (int i = 0; i < nameList.length; i++){
                       if (nameList[i].equals(name)){
                           System.out.println("Name already on list");
                           break;
                       }
                   }
            }
            /////////
            if(selectedOption == SEARCH_OP){
                kb.nextLine();

                System.out.println("What is the name you are looking for (exact match): ");
                String name = kb.nextLine();
                /* 
                *  Handle searching here
                */
                int containsResult = containsElement(name,nameList);
                System.out.println(containsResult);
            }
            //////////////
            
            else if(selectedOption == REMOVE_INDEX_OP){
                System.out.println("What is the index? ");
                int index = kb.nextInt();
                /* 
                *  Handle removing by index here
                *  remember to update entryCound as needed
                */
                removeItem (2, nameList);
            }
            
            /////////
            
            else if(selectedOption == REMOVE_NAME_OP) {
                kb.nextLine();
                System.out.println("Name to remove (exact match): ");
                String name = kb.nextLine();
                /* 
                *  Handle removing by name here
                *  remember to update entryCound as needed
                */
                removeName (name, nameList);
            }
            
            ////////
            
            else if(selectedOption == PRINT_OP){
                /* 
                *  Handle Printing with the $ separator here
                */
             System.out.println(toStringWithSeparator(nameList, '$' ));
             
            }

            System.out.println("Please Select an option: ");
            selectedOption = kb.nextInt();
        }
        
    }
}
        
       /** Add item into an array of Strings
     * @param str a srting to be addedd into an ordered, partially filled array
     * @param array array of Strings 
     * @param currentCapacity a variable to store the current count of elements in the array at 
     * each iteration
     * @return array without given the element at given index present
     */
     
     public static boolean addItem(String str, String [] array, int currentCapacity){
      String [] copy = new String [array.length];

      if (currentCapacity == array.length){
        return false;
         }
         

     else if (currentCapacity != array.length){
        
      for (int i = 0; i < array.length; i++){
          if (array[i] == null){
                array[i] = str;
                break;
             }
    
            else if(array[i] != null && array[i].compareTo(str) > 0){
                for (int j = i; j < array.length; j++){
                   copy[j] = array[j];  
                      }
              
                array[i] = str;
                
                 for (int k = i + 1; k < array.length; k++){
                    array[k] = copy[k - 1];
                    }
               break;
               
               }
      
             }
         }
      
      return true;
    }  
    
   
     /**
     * Method that searches for a particular String in a 1D array of Strings and returns the index if found, 
     * and -1 if not found.
     * @param name the particular String we are looking for.
     * @param array the 1d array of Strings.
     * @return the index of the String in the Array, or -1 if not found.
     */
     
     public static int containsElement(String name, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(name)){
                return i;
            }
        }
        return -1;

    }
    
        /** Remove item at given index from an array of Strings
     * @param index integer value that represents the index
     * @param array array of Strings to be read 
     * @return array without given the element at given index present
     */
    
  public static boolean removeItem (int index, String [] array){
      
         if (index < 0 || index >= array.length){
            return false;
            }
            
         int currentCapacity = array.length;

        for (int i = index; i < currentCapacity - 1 ; i++) {
             array[i] = array[i + 1];
          }
        
      return true;
        
    }
    
     
        /** Remove name at given index from an array of Strings
     * @param name the string value we want to remove 
     * @param array array of Strings to be read 
     * @return array without given the element at given index present
     */
     
    public static boolean removeName (String name, String [] array){
        
        for(int i = 0; i < array.length; i++){
            if(name != array[i]){
                return false;
            }
        }
            
        int currentCapacity = array.length;

        for (int i = 0; i <= currentCapacity - 1 ; i++) {
             if ( array[i].equals(name)){
                array[i] = null;
                currentCapacity++;
                break;
          }
        }
        
      return true;
        
    }
    
       /** Print array with each element seperated with a (*) character
     * after it
     * @param array the array of Strings to print
     * @param ch given character to print between each element
     * @return String holding all the elements of the array with character after each element
     */
    
    public static String toStringWithSeparator (String [] array, char ch){
        
        String result = "";
        
        int count = 0;
        
        for (int i = 0; i < array.length; i++){
            if (array[i] != null){
             count++;
            }
        } 
        
        for (int i = 0; i < count; i++) {
            if ( i != 0 && i < count - 1){
              result += array[i] + ch;
            } 
          else if (i == count - 1){
                result += array[i];
            }
                 
        }
        
        return result; 
    }
       
}
    
    
    
    
    
    
   
   
