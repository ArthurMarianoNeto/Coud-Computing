// Fig. 17.4: Server.java
// Set up a Server that will receive a connection
// from a client, send a string to the client,
// and close the connection.

// Java core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Server extends JFrame {
   private JTextField enterField;
   private JTextArea displayArea;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private ServerSocket server;
   private Socket connection;
   private int counter = 1;

   // set up GUI
   public Server()
   {
      super( "Server" );

      Container container = getContentPane();

      // create enterField and register listener
      enterField = new JTextField();
      enterField.setEnabled( false );

      enterField.addActionListener(

         new ActionListener() {

            // send message to client
            public void actionPerformed( ActionEvent event )
            {
               sendData( event.getActionCommand() );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( enterField, BorderLayout.NORTH );

      // create displayArea
      displayArea = new JTextArea();
      container.add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );

      setSize( 300, 150 );
      setVisible( true );
   }

   // set up and run server 
   public void runServer()
   {
      // set up server to receive connections; 
      // process connections
      try {

         // Step 1: Create a ServerSocket.
         server = new ServerSocket( 5000, 100 );

         while ( true ) {

            // Step 2: Wait for a connection.
            waitForConnection();

            // Step 3: Get input and output streams.
            getStreams();
 
            // Step 4: Process connection.
            processConnection();

            // Step 5: Close connection.
            closeConnection();

            ++counter;
         }
      }

      // process EOFException when client closes connection 
      catch ( EOFException eofException ) {
         System.out.println( "Client terminated connection" );
      }

      // process problems with I/O
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }
   }

   // wait for connection to arrive, then display connection info
   private void waitForConnection() throws IOException
   {
      displayArea.setText( "Waiting for connection\n" );

      // allow server to accept a connection
      connection = server.accept();
            
      displayArea.append( "Connection " + counter +
         " received from: " +
         connection.getInetAddress().getHostName() );
   }

   // get streams to send and receive data
   private void getStreams() throws IOException
   {
      // set up output stream for objects
      output = new ObjectOutputStream(
         connection.getOutputStream() );

      // flush output buffer to send header information
      output.flush();

      // set up input stream for objects
      input = new ObjectInputStream(
         connection.getInputStream() );

      displayArea.append( "\nGot I/O streams\n" );
   }

   // process connection with client
   private void processConnection() throws IOException
   {
      // send connection successful message to client
      String message = "SERVER>>> Connection successful";
      output.writeObject( message );
      output.flush();

      // enable enterField so server user can send messages
      enterField.setEnabled( true );

      // process messages sent from client
      do {

         // read message and display it
         try {
            message = ( String ) input.readObject();
            displayArea.append( "\n" + message );
            displayArea.setCaretPosition(
               displayArea.getText().length() );
         }

         // catch problems reading from client
         catch ( ClassNotFoundException classNotFoundException ) {
            displayArea.append( "\nUnknown object type received" );
         }

      } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
   }

   // close streams and socket
   private void closeConnection() throws IOException
   {
      displayArea.append( "\nUser terminated connection" );
      enterField.setEnabled( false );
      output.close();
      input.close();
      connection.close();
   }

   // send message to client
   private void sendData( String message )
   {
      // send object to client
      try {
         output.writeObject( "SERVER>>> " + message );
         output.flush();
         displayArea.append( "\nSERVER>>>" + message );
      }

      // process problems sending object
      catch ( IOException ioException ) {
         displayArea.append( "\nError writing object" );
      }
   }

   // execute application
   public static void main( String args[] )
   {
      Server application = new Server();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );

      application.runServer();
   }

}  // end class Server

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
