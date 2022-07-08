import java.util.Arrays;
import java.util.Scanner;

/**
 * This file creates a polynomial function by using coefficients. If the coefficient is 0,
 * that term is not displayed. If the degree of the variable is 0, only the coefficient is displayed.
 * @author Erkin Aydın
 * @version 07/02/2021 v/1.4
 * Updates in v/1.2:
 * -Added "private" modifier to each instance variable.
 * -Added "this" statement to instance variables
 * -public Polynomial( double[] anArray) --> public Polynomial( double[] coefficients)
 * -public double eval( double x) --> public double eval( double variableValue)
 * -public double eval12( double x) --> public double eval12( double variableValue)
 * -Couple of changes in comments
 * Updates in v/1.3:
 * -public eval12( double variableValue) --> public eval2( double variableValue)
 * -public double getCoefficient( int a) --> public double getCoefficient( int theDegree)
 * -In public double eval2, polynomialValue = coefficients[this.polynomialLength - 1] --> polynomialValue[this.lastIndex]
 * -In public double eval2, in the for loop, this.polynomial - 2 --> this.lastIndex - 1
 * -private int lastIndex added
 * -In toString, double a --> double coefficientValue
 * -Some syntax fixes: eg. [a] --> [ a]
 * -A new way added as a comment for eval method
 * -Couple of new comments added
 * Updates in v/1.4:
 * -In the getCoefficient, we make sure that the parameter degree is
 * -Added couple of comments
 */

public class Polynomial
{
    // Properties

    Scanner scan = new Scanner( System.in); 
    private double[] coefficients;
    private int polynomialLength;
    private int lastIndex;
    
    // Constructors

    /**
     * It construct a polynomial function which is always equals to 0.
     */
    public Polynomial()
    {
        this.coefficients = new double[ 1];
        this.coefficients[ 0] = 0;
        this.polynomialLength = coefficients.length;
        this.lastIndex = this.polynomialLength - 1;
    }

    /**
     * It constructs a polynomial that has only 1 term with the given coefficient value and degree.
     * @param coefficientValue
     * @param degree
     */
    public Polynomial( double coefficientValue, int degree)
    {
        this.coefficients = new double[ degree + 1];
        /*
        for( int a = 0; a < degree; a++) // This loop is unneccessary
        {
            this.coefficients[ a] = 0;
        }
        */
        this.coefficients[ degree] = coefficientValue;
        this.polynomialLength = this.coefficients.length;
        this.lastIndex = this.polynomialLength - 1;
    }

    /**
     * It constructs a polynomial with the parameter given.
     * @param anArray an array of doubles. They will be used as coefficients.
     */
    public Polynomial( double[] coefficients)
    {
        this.coefficients = Arrays.copyOf( coefficients, coefficients.length);
        this.polynomialLength = this.coefficients.length;
        this.lastIndex = this.polynomialLength - 1;
    }

    // Methods

    /**
     * Gets coefficient of the polynomial term with the given degree.
     * @param a degree of the term.
     * @return coefficient of the polynomial term with the given degree.
     */
    public double getCoefficient( int theDegree)
    {
        int returnDegree;

        while( theDegree < 0)
        {
            System.out.print( "A polynomial's degree can only be non-negative(and integer). Enter again:");
            theDegree = scan.nextInt();
        }
        while( theDegree > lastIndex)
        {
            System.out.print( "Unfortunately, polynomial's degree is lower. Enter again: ");
            theDegree = scan.nextInt();

        }
        returnDegree = theDegree;
        return coefficients[ returnDegree];
    }

    /**
     * Returns the degree of the polynomial.
     * @return degree of the polynomial.
     */
    public int getDegree()
    {
        int degree;

        degree = 0;
        for( int a = 0; a < polynomialLength; a++)
        {
            if( coefficients[ a] != 0)
            {
                degree = a;
            }
        }
        return degree;
    }

    /**
     * Returns the value of the polynomial with the given variable by calculating each term one by one
     * @param variableValue value of the variable of the polynomial.
     * @return the value of the polynomial with the given variable.
     */
    public double eval( double variableValue)
    {
        double polynomialValue;
        int indexCounter;

        polynomialValue = 0;
        indexCounter = 0;
        for( double a : coefficients) // for( int a = 0; a < polynomialLength; a++ )
        {
            polynomialValue += a * Math.pow( variableValue, indexCounter);
            indexCounter++;
        }

        return polynomialValue;
    }
    /*
    public double eval( double variableValue)
    {
        double polynomialValue;

        polynomialValue = 0;
        for( int a = 0; a <= this.lastIndex; a++)
        {
            polynomialValue += coefficients[ a] * Math.pow( variableValue, a);
        }

        return polynomialValue;
    }
    */

    /**
     * Returns the value of the polynomial with the given value using Horner's method
     * @param variableValue value of the variable of the polynomial.
     * @return the value of the polynomial with the given variable.
     */
    public double eval2( double variableValue)
    {
        double polynomialValue;

        polynomialValue = coefficients[ this.lastIndex];
        for ( int a = this.lastIndex - 1; 0 <= a; a--)
        {
            polynomialValue = polynomialValue * variableValue + coefficients[ a];
        }

        return polynomialValue;
    }

    /**
     * Returns the String representation of the polynomial
     * @return the String representation of the polynomial
     */
    public String toString()
    {
        String stringRepresentation;
        int indexCounter;

        stringRepresentation = "";
        indexCounter = 0;

        /* This for loop exsixts to make stringRepresentation looking better. For example, as
        shown in the assignment, there is always a space between the coefficient and its operator.
        As another example, there is no need for (+) operator if the term's variable's degree is 0... */
        for( double coefficientValue : this.coefficients)
        {
            if( polynomialLength == 1) // polynomialLength == 1 if and only if p(x) = 0
            {
                stringRepresentation += coefficientValue;
            }
            
            else if( coefficientValue == 0) // If coefficientValue == 0, we do not add that term
            {
            }

            else if( coefficientValue < 0) // If coefficientValue < 0, we use sign operator "-"
            {
                if( indexCounter == 0)
                {
                    stringRepresentation += " - " + ( -1 * coefficientValue);
                }
                else
                {
                    stringRepresentation += " - " + ( -1 * coefficientValue) + "x^" + indexCounter;
                }
            }

            else if( coefficientValue > 0) // If coefficientValue > 0, we use sing operator "+"
            {
                if( indexCounter == 0)
                {
                    stringRepresentation += coefficientValue;
                }
                else
                {
                    stringRepresentation += " + " + coefficientValue + "x^" + indexCounter;
                }
            }
            indexCounter++;
        }
        return stringRepresentation;
    }
}
// Just like in the eval methoc, we can use traditional for loop here as well