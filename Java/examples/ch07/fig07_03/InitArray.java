// Fig. 7.3: InitArray.java
// Creating an array.

// Java extension packages
import javax.swing.*;

public class InitArray {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int array[];            // declare reference to an array

      array = new int[ 10 ];  // dynamically allocate array

      String output = "Subscript\tValue\n";
   
      // append each array element's value to String output
      for ( int counter = 0; counter < array.length; counter++ )
         output += counter + "\t" + array[ counter ] + "\n";

      JTextArea outputArea = new JTextArea();
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Initializing an Array of int Values",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

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

