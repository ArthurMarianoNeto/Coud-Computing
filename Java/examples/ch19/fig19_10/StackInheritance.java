// Fig. 19.10: StackInheritance.java
// Derived from class List
package com.deitel.jhtp4.ch19;

public class StackInheritance extends List {

   // construct stack
   public StackInheritance() 
   { 
      super( "stack" ); 
   }

   // add object to stack
   public synchronized void push( Object object )
   { 
      insertAtFront( object ); 
   }

   // remove object from stack
   public synchronized Object pop() throws EmptyListException
   { 
      return removeFromFront(); 
   }

}  // end class StackInheritance


/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
