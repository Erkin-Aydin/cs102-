package b;

import javax.swing.JFrame;

/**
 * An application of Converter.
 * @author Erkin Aydın
 * @version v/1.1
 */
public class ConverterMain {

        public static void main( String[] args) {

            Converter converter = new Converter();
            converter.setVisible( true);
            converter.setResizable( false);
            converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
