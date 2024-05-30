// Fig. 13.7: OvalPanel.java
// A customized JPanel class.

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class OvalPanel extends JPanel {
   private int diameter = 10;

   // draw an oval of the specified diameter
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      g.fillOval( 10, 10, diameter, diameter );
   }

   // validate and set diameter, then repaint 
   public void setDiameter( int newDiameter )
   {
      // if diameter invalid, default to 10
      diameter = ( newDiameter >= 0 ? newDiameter : 10 );
 
      repaint();
   }

   // used by layout manager to determine preferred size
   public Dimension getPreferredSize()
   {
      return new Dimension( 200, 200 );
   }

   // used by layout manager to determine minimum size
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   }

}  // end class OvalPanel

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
