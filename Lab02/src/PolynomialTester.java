/**
 * Application of Polynomial.java which is modified for Lab02.
 * It tests 3 constructors of Polynomial.java has, and also, it tests newly added
 * methods sub, add, mul, div, compose.
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
        final String THE_DIVIDER = "================================================>";

        // Variables
        Polynomial polynomialOperation;
        Polynomial polynomialAdd;
        Polynomial polynomialSub;
        Polynomial polynomialMul;
        Polynomial polynomialDiv;
        Polynomial polynomialCompose;
        double[] coefficientsOperation;
        double[] coefficientsAdd;
        double[] coefficientsSub;
        double[] coefficientsMul;
        double[] coefficientsDiv;
        double[] coefficientsCompose;

        coefficientsOperation = new double[ 4];
        for( int a = 3; 0 <= a; a--)
        {
            coefficientsOperation[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialOperation = new Polynomial( coefficientsOperation);

        coefficientsAdd = new double[ 8];
        for( int a = 7; 0 <= a; a--)
        {
            coefficientsAdd[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialAdd = new Polynomial( coefficientsAdd);

        coefficientsSub = new double[ 8];
        for( int a = 7; 0 <= a; a--)
        {
            coefficientsSub[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialSub = new Polynomial( coefficientsSub);

        coefficientsMul = new double[ 8];
        for( int a = 7; 0 <= a; a--)
        {
            coefficientsMul[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialMul = new Polynomial( coefficientsMul);

        coefficientsDiv = new double[ 8];
        for( int a = 7; 0 <= a; a--)
        {
            coefficientsDiv[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialDiv = new Polynomial( coefficientsMul);

        coefficientsCompose = new double[ 4];
        for( int a = 3; 0 <= a; a--)
        {
            coefficientsCompose[ a] = ( int)( Math.random() * 10 - 5);
        }
        polynomialCompose = new Polynomial( coefficientsCompose);

        System.out.println( "Test add:");
        System.out.println( "Polynomial 1==> " + polynomialAdd);
        System.out.println( "Polynomial 2==> " + polynomialOperation);
        System.out.println( "add==> " + polynomialAdd.add( polynomialOperation));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test sub:");
        System.out.println( "Polynomial 1==> " + polynomialSub);
        System.out.println( "Polynomial 2==> " + polynomialOperation);
        System.out.println( "sub==> " + polynomialSub.sub( polynomialOperation));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test mul:");
        System.out.println( "Polynomial 1==> " + polynomialMul);
        System.out.println( "Polynomial 2==> " + polynomialOperation);
        System.out.println( "mul==> " + polynomialMul.mul( polynomialOperation));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test div:");
        System.out.println( "Polynomial 1==> " + polynomialDiv);
        System.out.println( "Polynomial 2==> " + polynomialOperation);
        System.out.println( "div==> " + polynomialDiv.div( polynomialOperation));
        System.out.println( THE_DIVIDER);

        System.out.println( "Test compose:");
        System.out.println( "Polynomial 1==> " + polynomialCompose);
        System.out.println( "Polynomial 2==> " + polynomialOperation);
        System.out.println( "compose==> " + polynomialCompose.compose( polynomialOperation));
        System.out.println( THE_DIVIDER);

        System.out.println( "Lab02 done!");
    }
}