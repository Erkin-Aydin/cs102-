import java.util.Scanner;

/**
 * Modified version of PolynomialTester.java. In first 2 parts, it practices two basic constructors.
 * In the third part it lets user to choose the degree of the polynomial, the variable's degree 
 * which will be used to find the coefficient of that term, and whather they want to enter coefficients
 * manually or not.
 * @author Erkin Aydın
 * @version 07/02/2021 v/1.3
 * Updates in v/1.2:
 * -Some syntax fixes: eg. [a] --> [ a]
 * Updates in v/1.3:
 * -Due to the changes in Polynomial.java, a certain part of the code is deleted
 */

public class PolynomialTesterModified
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        // Constants

        // This constants exists to show the borders between parts of the Lab assignment
        final String THE_DIVIDER = "<=======================================================>";
        
        // Variables
        Polynomial polynomial1;
        Polynomial polynomial2;
        Polynomial polynomial3;
        double[] testArray3;
        int polynomialVariable;
        int polynomialVariableDegree;
        int polynomial2VariableDegree;
        double polynomial2Coefficient;
        int polynomial3Degree;
        int polynomial3Length;

        // This is the variable which will contain the user's request of whether entering coefficients manually or not.
        String theRequest;
        
        System.out.println( "Welcome to the first lab assignment of the course!");
        System.out.println( THE_DIVIDER);
        
        System.out.println( "Test 1:");

        polynomial1 = new Polynomial();
        System.out.println( "String representation--> " + polynomial1.toString());

        // There is only 1 term and it's variable's degree is 0, just like it's coefficient is.
        System.out.println( "getCoefficient--> " + polynomial1.getCoefficient( 0));

        System.out.println( "getDegree--> " + polynomial1.getDegree());
        System.out.println( "eval--> " + polynomial1.eval( 3));
        System.out.println( "eval2--> " + polynomial1.eval2( 3));
        System.out.println( THE_DIVIDER);
        
        System.out.println( "Test 2:");

        // I wanted to create these values randomly.
        polynomialVariable = ( int)( 10 * Math.random());
        polynomial2VariableDegree = ( int)( 10 * Math.random());
        polynomial2Coefficient = 20 * Math.random() - 10;

        System.out.println( polynomialVariable);
        System.out.println( polynomial2Coefficient);

        polynomial2 = new Polynomial( polynomial2Coefficient, polynomial2VariableDegree);
        System.out.println( "String representation--> " + polynomial2.toString());
        System.out.println( "getCoefficient--> " + polynomial2.getCoefficient( polynomial2VariableDegree));
        System.out.println( "getDegree--> " + polynomial2.getDegree());
        System.out.println( "eval--> " + polynomial2.eval( polynomialVariable));
        System.out.println( "eval2--> " + polynomial2.eval2( polynomialVariable));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test 3:");

        System.out.print( "What would you like the polynomial's degree to be: ");
        polynomial3Degree = scan.nextInt();
        polynomial3Length = polynomial3Degree + 1; // Since we start from the 0'th index...

        while( polynomial3Degree < 0) // The degree of the polynomial can't be negative
        {
            System.out.print( "Invalid degree. Please try again: ");
            polynomial3Degree = scan.nextInt();
        }

        if( polynomial3Degree == 0)
        {
            System.out.println( "Umm... I suppose it is legal!");
        }

        testArray3 = new double[ polynomial3Length];
        System.out.println( "If you choose 'Random', then random coefficients between -10 and 10 will be created" +
                            " If you choose 'Manual', you will enter coefficients manually.");
        System.out.print( "Would you like coefficients to be created randomly or entered manually: ");
        theRequest = scan.next();

        // We have to make sure the user enteres a valid 'request'
        while( !theRequest.equalsIgnoreCase( "Random") && !theRequest.equalsIgnoreCase( "Manual"))
        {
            System.out.print( "Invalid request. Please try again: ");
            theRequest = scan.next();
        }

        // It creates random values between -10 and 10, of course, if the user wants it
        if( theRequest.equalsIgnoreCase( "Random"))
        {
            for( int a = 0; a < testArray3.length; a++)
            {
                testArray3[ a] = ( 20 * Math.random()) - 10;
            }
        }

        else
        {
            for( int a = 0; a < testArray3.length; a++)
            {
                System.out.print( "Enter the " + ( a + 1) + "'th coefficient: ");
                testArray3[ a] = scan.nextDouble();

                while( a == polynomial3Degree && testArray3[ a] == 0)
                {
                    System.out.print( "Coefficient of this variable can't be 0 since" + 
                                    " it is the polynomial degree variable: Try again: ");
                    testArray3[ a] = scan.nextDouble();
                }
            }
        }

        // Lastly, we construct our polynomial and test it's methods.
        polynomial3 = new Polynomial( testArray3);
        System.out.println( "String representation--> " + polynomial3.toString());

        System.out.print( "Which degreed variable's coefficient would you like to get: ");
        polynomialVariableDegree = scan.nextInt();

        System.out.println( "getCoefficient--> " + polynomial3.getCoefficient( polynomialVariableDegree));
        System.out.println( "getDegree--> " + polynomial3.getDegree());

        System.out.print( "Last thing, enter the value of the variable: ");
        polynomialVariable = scan.nextInt();

        System.out.println( "eval----> " + polynomial3.eval( polynomialVariable));
        System.out.println( "eval2--> " + polynomial3.eval2( polynomialVariable));
        System.out.println( THE_DIVIDER);

        System.out.println( "Lab01 done!");

        scan.close();
    }
}