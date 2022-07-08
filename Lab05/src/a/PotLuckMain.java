package a;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * An Application of PotLuck
 * @author Erkin Aydın
 * @version v/1.1
 */

public class PotLuckMain {
    
    public static void main( String[] args) {

        JFrame frame = new JFrame();
        PotLuck potluck = new PotLuck();

        frame.setSize( 600, 500);
        frame.setResizable( false);
        frame.setVisible( true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        frame.add( potluck, BorderLayout.CENTER);
        frame.add( potluck.getConditionLabel(), BorderLayout.SOUTH);
    }
}
