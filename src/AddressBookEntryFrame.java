// Fig. 8.37: AddressBookEntryFrame.java
// A subclass of JInternalFrame customized to display and
// an AddressBookEntry or set an AddressBookEntry's properties
// based on the current data in the UI.
// Patrick Shaughnessy

// Java core packages
import java.util.*;
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class AddressBookEntryFrame extends JInternalFrame {

    // HashMap to store JTextField references for quick access
    private HashMap fields;

    // current AddressBookEntry set by AddressBook application
    private AddressBookEntry person;

    // panels to organize GUI
    private JPanel leftPanel, rightPanel;

    // static integers used to determine new window positions
    // for cascading windows
    private static int xOffset = 0, yOffset = 0;

    // static Strings that represent name of each text field.
    // These are placed on JLabels and used as keys in
    // HashMap fields.
    private static final String FIRST_NAME = "First Name",
            LAST_NAME = "Last Name", ADDRESS1 = "Address 1",
            CITY = "City", EIRCODE = "Eircode",
            COUNTY = "County", PHONE = "Mobile Phone", EMAIL = "Email",
            ALTADDR1 = "Alt Address"
            ,ALTCITY = "Alt City"
            ,ALTEIRCODE = "Alt Ericode"
            ,ALTCOUNTY = "Alt county"
            ,HOMEPHONE = "Home Phone"
            ,ALTPHONE = "Alt Phone"
            ,ALTEMAIL = "Alt Email"
            ;



    // construct GUI
    public AddressBookEntryFrame()
    {
        super( "Address Book Entry", true, true );

        fields = new HashMap();
        JButton delete_address = new JButton("Delete_adr");
        JButton delete_phone = new JButton("Delete_phone");
        JButton delete_email = new JButton("Delete_adr");


        leftPanel = new JPanel();
        leftPanel.setLayout( new GridLayout( 17, 1, 0, 5 ) );
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(17, 1, 0, 5));

        createRow( FIRST_NAME );
        createRow( LAST_NAME );
        createRow( ADDRESS1 );
        createRow( CITY );
        createRow( EIRCODE );
        createRow( COUNTY );
        createRow(ALTADDR1);
        createRow(ALTCITY);
        createRow(ALTEIRCODE);
        createRow(ALTCOUNTY);
        createRow(HOMEPHONE);
        createRow( PHONE );
        createRow(ALTPHONE);
        createRow( EMAIL );
        createRow( ALTEMAIL );

        Container container = getContentPane();
        // container.add(delete_address,BorderLayout.EAST);
        // container.add(delete_email,BorderLayout.SOUTH);
        //container.add(delete_phone,BorderLayout.NORTH);

        container.add( leftPanel, BorderLayout.WEST );
        container.add( rightPanel, BorderLayout.CENTER );

        setBounds( xOffset, yOffset, 500, 500 );
        xOffset = ( xOffset + 30 ) % 300;
        yOffset = ( yOffset + 30 ) % 300;
    }

    // set AddressBookEntry then use its properties to
    // place data in each JTextField
    public void setAddressBookEntry( AddressBookEntry entry )
    {
        person = entry;

        setField( FIRST_NAME, person.getFirstName() );
        setField( LAST_NAME, person.getLastName() );
        setField( ADDRESS1, person.getAddress1() );
        setField( CITY, person.getCity() );
        setField( EIRCODE, person.getEircode() );
        setField( COUNTY, person.getCounty() );
        setField( PHONE, person.getPhoneNumber() );
        setField(HOMEPHONE, person.getHomephone());
        setField(ALTPHONE, person.getAltphone());

        setField( EMAIL, person.getEmailAddress() );
        setField( ALTEMAIL, person.getAltEmail() );

        setField( ALTADDR1, person.getAltaddress() );
        setField( ALTCITY, person.getAltcity() );
        setField( ALTEIRCODE, person.getAlteircode());
        setField( ALTCOUNTY, person.getAltcounty() );


        setField( HOMEPHONE, person.getHomephone());
        setField( ALTPHONE, person.getAltphone() );
    }

    // store AddressBookEntry data from GUI and return
    // AddressBookEntry
    public AddressBookEntry getAddressBookEntry()
    {
        person.setFirstName( getField( FIRST_NAME ) );
        person.setLastName( getField( LAST_NAME ) );
        person.setAddress1( getField( ADDRESS1 ) );
        //person.setAddress2( getField( ADDRESS2 ) );
        person.setCity( getField( CITY ) );
        person.setEircode( getField( EIRCODE ) );
        person.setCounty( getField( COUNTY ) );
        person.setPhoneNumber( getField( PHONE ) );
        person.setEmailAddress( getField( EMAIL ) );
        person.setAltamail( getField( ALTEMAIL) );

        person.setAltaddress( getField( ALTADDR1 ) );
        person.setAltcity( getField( ALTCITY ) );
        person.setAlteircode( getField( ALTEIRCODE ) );
        person.setAltcounty( getField( ALTCOUNTY ) );

        person.setHomephone( getField( HOMEPHONE) );
        person.setAltphone( getField( ALTPHONE) );


        return person;
    }

    // set text in JTextField by specifying field's
    // name and value
    private void setField( String fieldName, String value )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        field.setText( value );
    }

    // get text in JTextField by specifying field's name
    private String getField( String fieldName )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        return field.getText();
    }

    // utility method used by constructor to create one row in
    // GUI containing JLabel and JTextField
    private void createRow( String name )
    {
        JLabel label = new JLabel( name, SwingConstants.RIGHT );
        label.setBorder(
                BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        leftPanel.add( label );

        JTextField field = new JTextField( 30 );
        rightPanel.add( field );

        fields.put( name, field );
    }
}  // end class AddressBookEntryFrame


/**************************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and Prentice Hall.     *
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
