package a;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A subclass of JPanel which will create a bomb game containing two bombs and a prize.
 * @author Erkin Aydın
 * @version v/1.1
 */

public class PotLuck extends JPanel {
    
    private static final long serialVersionUID = -1477894684888457342L;

    // Properties
    private JLabel conditionLabel;
    private int bomb1;
    private int bomb2;
    private int prize;
    private int stepCounter;
    private boolean gameOver;

    /**
     * Constructor of Potluck. It constructs 25 buttons and adds them to PotLuck. 2 of these buttons are
     * bombs and one of them is a prize. Bombs and prizes are not shown in the beginning, only their texts are
     * shown. When one of them is clicked, the game will over and bomb and, for the prize, star images will be displayed
     */
    public PotLuck() {

        super( new GridLayout( 5, 5));
        // We have to make sure that none of our special buttons have the same number.
        bomb1 = (int)( Math.random() * 25 + 1);
        bomb2 = (int)( Math.random() * 25 + 1);
        while( bomb2 == bomb1) {
            bomb2 = (int)( Math.random() * 25 + 1);
        }

        prize = (int)( Math.random() * 25 + 1);
        while( prize == bomb1 || prize == bomb2) {

            prize = (int)( Math.random() * 25 + 1);
        }

        int counter = 1;
        // For rows...
        for( int i = 0; i < 5; i++) {

            // For columns...
            for( int j = 0; j < 5; j++) {

                JButton aButton;
                if( counter == bomb1 || counter == bomb2) {

                    aButton = new BombButton( "" + counter);
                }
                else if( counter == prize) {

                    aButton = new PrizeButton( "" + counter);
                }
                else {

                    aButton = new JButton( "" + counter);
                }
                aButton.addActionListener( new Listener());
                aButton.setFocusable( false);
                add( aButton);
                counter++;
            }
        }
        stepCounter = 0;
        gameOver = false; //This is not necessary since it is automatically set to false
        conditionLabel = new JLabel( "You can start with clicking one of the buttons...");
        conditionLabel.setFont( new Font("Serif", Font.BOLD, 15));
    }

    /**
     * It returns the conditionLabel
     * @return conditionLabel
     */
    protected JLabel getConditionLabel() {

        return conditionLabel;
    }

    /**
     * An implementation of ActionListener. It overrides the actionPerformed method for necessary use
     */
    private class Listener implements ActionListener {

        /**
         * Overrided version of actionPerformed. When a prize or bomb button is clicked, it will
         * simply end the game and display bomb and star images
         */
        @Override
        public void actionPerformed( ActionEvent e) {

            JButton button = ( JButton)e.getSource();
            stepCounter++;

            //Checking whether the game is over or not
            if( e.getSource() instanceof BombButton || e.getSource() instanceof PrizeButton){

                gameOver = true;

                //Constructing the star and making it visible and yellow
                ( ( JButton)getComponents()[prize - 1]).setOpaque( true);
                ( ( JButton)getComponents()[prize - 1]).setText( "\u2605");
                ( ( JButton)getComponents()[prize - 1]).setForeground( Color.yellow);
                ( ( JButton)getComponents()[prize - 1]).setOpaque( true);
                ( ( JButton)getComponents()[prize - 1]).setFont( new Font( "Serif", Font.BOLD, 62 ));

                // Checking whether the clicked button is the PrizeButton
                if( e.getSource() instanceof PrizeButton) {

                    conditionLabel.setText( "You found the prize in the " + stepCounter + "'th time!");
                }
                else {

                    conditionLabel.setText( "Ufff... You lost the game in the " + stepCounter + "'th time!");
                }

                //Making every button unclickable
                for( int i = 0; i <= 24; i++) {
                    if( !( getComponents()[i] instanceof PrizeButton)) {
                        
                        getComponents()[i].setEnabled( false);
                    }
                }
            }
            
            //Making only the clicked button unclickable
            else {

                button.setEnabled( false);
                conditionLabel.setText( "Ok... You are still alive in the " + stepCounter + "'th try.");
            }
        }
    }

    /**
     * A subclass of JButton. It represents a prize button
     */
    private class PrizeButton extends JButton {

        private static final long serialVersionUID = 1150037327565678047L;

        /**
         * Constructs the PrizeButton with the given text
         * @param s
         */
        private PrizeButton( String s) {

            setText( s);
        }

    }

    /**
     * A subclass of JButton. It represents a bomb button and overrides de paintComponent method.
     * It will display a bomb shape when clicked or when the game is over
     */
    private class BombButton extends JButton {

        private static final long serialVersionUID = 9098260043419287755L;

        /**
         * Constructs a BombButton with the given text
         * @param s
         */
        private BombButton( String s) {

            setText( s);
            setVisible( true);
        }

        /**
         * An overrided version of paintComponent method. It will display a bomb shape when the button is clicked or game is over
         */
        @Override
        public void paintComponent( Graphics g) {

            Graphics2D graphics2d = (Graphics2D)g;
            super.paintComponent( g);
            if( gameOver) {

                int width = getWidth();
                int height = getHeight();

                //Fuse
                graphics2d.setColor(Color.RED);
                graphics2d.setStroke( new BasicStroke( 2));
                graphics2d.drawArc( width / 2, height / 9, width / 4, height * 2 / 9, 180, -100);
                
                //Head
                graphics2d.setColor( Color.BLACK);
                graphics2d.fillRect( width / 3, height / 4, width / 3, height / 5);
                
                //Body
                graphics2d.setColor( Color.BLACK);
                graphics2d.fillOval( width / 4, height / 3, width / 2, height / 2);
                
            }
        }
        
    }
}