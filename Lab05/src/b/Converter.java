package b;

import java.lang.Integer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A base converter. It will basically display the decimal, binary and hexadecimal representations of entered numbers
 * It is a subclass of JFrame
 * @author Erkin Aydın
 * @version v/1.1
 */
public class Converter extends JFrame {

    private static final long serialVersionUID = -4900076210304223222L;

    private JPanel panelLabel;
    private JPanel panelField;
    private JLabel decimal;
    private JLabel hex;
    private JLabel binary;
    private JTextField decimalTextField;
    private JTextField hexTextField;
    private JTextField binaryTextField;

    private static final int FRAME_WIDTH = 350;
    private static final int FRAME_HEIGHT = 200;

    /** 
     * It constructs the converter with createComponents and addComponents methods and sets the size of
    */
    public Converter() {

        createComponents();
        addComponents();
        setSize( FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * It creates components; binary, decimal and hexadecimal labels and textfields and panels to add them
     */
    private void createComponents() {

        panelLabel = new JPanel();
        panelField = new JPanel();
        decimal = new JLabel( "Decimal");
        hex = new JLabel( "\nHex");
        binary = new JLabel( "\nBinary");
        decimalTextField = new JTextField("0");
        decimalTextField.setEditable( true);
        decimalTextField.setSize( 300, 200);
        decimalTextField.addActionListener( new DecimalListener());
        hexTextField = new JTextField( "0");
        hexTextField.setEditable( true);
        hexTextField.setSize( 300, 200);
        hexTextField.addActionListener( new HexListener());
        binaryTextField = new JTextField( "0");
        binaryTextField.setEditable( true);
        binaryTextField.setSize( 3000, 200);
        binaryTextField.addActionListener( new BinaryListener());
    }

    /**
     * It adds every previously created component to necessary panels and adds these panels to the Converter
     */
    private void addComponents() {

        panelLabel.setLayout( new GridLayout( 3, 1));
        panelField.setLayout( new GridLayout( 3, 1));
        panelLabel.add( decimal);
        panelField.add( decimalTextField);
        panelLabel.add( hex);
        panelField.add( hexTextField);
        panelLabel.add( binary);
        panelField.add( binaryTextField);
        add( panelLabel, BorderLayout.WEST);
        add( panelField, BorderLayout.CENTER);
    }

    /**
     * An implementtion of ActionListener. It will simply call conversion methods for hexadecimal and binary numbers
     * to convert the entered decimal number.
     */
    class DecimalListener implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {

            String decimalValue = decimalTextField.getText();
            hexTextField.setText( decimalToHex( decimalValue));
            binaryTextField.setText( decimalToBinary( decimalValue));
        }
    }

    /**
     * An implementtion of ActionListener. It will simply call conversion methods for decimal and binary numbers
     * to convert the entered hexadecimal number.
     */
    class HexListener implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {

            String hexValue = hexTextField.getText();
            decimalTextField.setText( hexToDecimal( hexValue));
            binaryTextField.setText( hexToBinary( hexValue));
        }
    }

    /**
     * An implementtion of ActionListener. It will simply call conversion methods for hexadecimal and decimal numbers
     * to convert the entered binary number.
     */
    class BinaryListener implements ActionListener {

        @Override
        public void actionPerformed( ActionEvent e) {

            String binaryValue = binaryTextField.getText();
            hexTextField.setText( binaryToHex( binaryValue));
            decimalTextField.setText( binaryToDecimal( binaryValue));
        }
    }

    /**
     * It will convert given decimal number to binary and return its String representation
     * @param d
     * @return binary and String representation of the converted number
     */
    private String decimalToBinary( String d) {

        int decimal = Integer.parseInt( d);
        String binary = "";

        while( decimal > 0) {

            binary = ( decimal % 2) + binary;
            decimal = ( decimal - ( decimal % 2)) / 2;
        }

        return "" + binary;
    }

    /**
     * It will convert given binary number to decimal and return its String representation
     * @param d
     * @return decimal and String representation of the converted number
     */
    private String binaryToDecimal( String b) {

        return "" + Integer.parseInt( b, 2);
    }

    /**
     * It will convert given decimal number to hexadecimal and return its String representation
     * @param d
     * @return hexadecimal and String representation of the converted number
     */
    private String decimalToHex( String d) {

        int decimal = Integer.parseInt( d);
        String hex = "";
    
        while( decimal > 0) {

            if( decimal % 16 < 10) {

                hex = ( decimal % 16) + hex;
            }
            else if( decimal % 16 > 10) {

                if( decimal % 16 == 10) {

                    hex = "A" + hex;
                }
                else if( decimal % 16 == 11) {

                    hex = "B" + hex;
                }
                else if( decimal % 16 == 12) {

                    hex = "C" + hex;
                }
                else if( decimal % 16 == 13) {

                    hex = "D" + hex;
                }
                else if( decimal % 16 == 14) {

                    hex = "E" + hex;
                }
                else if( decimal % 16 == 15) {

                    hex = "F" + hex;
                }
            }
            decimal = ( decimal - ( decimal % 16)) / 16;
        }
        return hex;
    }

    /**
     * It will convert given hexadecimal number to decimal and return its String representation
     * @param d
     * @return decimal and String representation of the converted number
     */
    private String hexToDecimal( String h) {

        return "" + Integer.parseInt( h, 16);
    }

    /**
     * It will convert given binary number to hexadecimal and return its String representation
     * @param d
     * @return hexadecimal and String representation of the converted number
     */
    private String binaryToHex( String b) {

        return decimalToHex( binaryToDecimal( b));
    }

    /**
     * It will convert given hexadecimal number to binary and return its String representation
     * @param d
     * @return binary and String representation of the converted number
     */
    private String hexToBinary( String h) {

        return decimalToBinary( "" + Integer.parseInt( h, 16));
    }
}