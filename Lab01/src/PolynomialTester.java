/**
 * Application of Polynomial.java. It tests 3 constructors of Polynomial.java has.
 * @author Erkin Aydın
 * @version 07/02/2021 v/1.2
 * Updates in v/1.2:
 * -Some syntax fixes: eg. [a] --> [ a]
 */

public class PolynomialTester
{
    public static void main( String[] args)
    {
        // Constants

        // This constants exists to show the borders between parts of the Lab assignment
        final String THE_DIVIDER = "<======================================>";

        // Variables

        Polynomial polynomial1;
        Polynomial polynomial2;
        Polynomial polynomial3;
        double[] testArray3;

        // Code

        System.out.println( "Welcome to the first lab assignment of this course!");
        System.out.println( THE_DIVIDER);

        System.out.println( "Test 1:");

        polynomial1 = new Polynomial();

        System.out.println( "String representation--> " + polynomial1.toString());

        // There is only 1 term and it's variable's degree is 0, just like it's coefficient is.
        System.out.println( "getCoefficient--> " + polynomial1.getCoefficient( 0));
        System.out.println( "getDegree--> " + polynomial1.getDegree());

        // It does not matter what we put as variable, since this constructor automatically makes the result 0.
        System.out.println( "eval--> " + polynomial1.eval( 2));
        System.out.println( "eval12--> " + polynomial1.eval2( 2));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test 2:");

        polynomial2 = new Polynomial( 3.4, 5);

        System.out.println( "String representation--> " + polynomial2.toString());
        
        // There is only 1 term and it's variable's degree is 5
        System.out.println( "getCoefficient--> " + polynomial2.getCoefficient( 5));
        System.out.println( "getDegree--> " + polynomial2.getDegree());
        System.out.println( "eval--> " + polynomial2.eval( 3));
        System.out.println( "eval12--> " + polynomial2.eval2( 3));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test 3:");

        /* Here, I created an array with the length of 5 and filled it with random 
        double numbers between -5 and 5 */
        testArray3 = new double[ 5];
        for( int a = 0; a < 5; a++)
        {
            testArray3[ a] = 10 * Math.random() - 5;
        }
        polynomial3 = new Polynomial( testArray3);

        System.out.println( "String representation--> " + polynomial3.toString());
        System.out.println( "getCoefficient--> " + polynomial3.getCoefficient( 2));
        System.out.println( "getDegree--> " + polynomial3.getDegree());
        System.out.println( "eval--> " + polynomial3.eval( 3));
        System.out.println( "eval12--> " + polynomial3.eval2( 3));
        System.out.println( THE_DIVIDER);

        System.out.println( "Lab01 done!");
    }
}
