import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the modified version of the Polynomial.java in Lab01.
 * New Things:
 * -You can sum, substract, multiply, divide and compose polynomials.
 * @author Erkin Aydın
 * @version 14/02/2021 v/1
 */

public class Polynomial
{
    // Properties

    Scanner scan = new Scanner( System.in); 
    private double[] coefficients;
    private int polynomialLength;
    private int lastIndex;
    private int degree;
    
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
        this.degree = 0;
        for( int a = 0; a < polynomialLength; a++)
        {
            if( coefficients[ a] != 0)
            {
                this.degree = a;
            }
        }
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
        this.degree = 0;
        for( int a = 0; a < polynomialLength; a++)
        {
            if( coefficients[ a] != 0)
            {
                this.degree = a;
            }
        }
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
        this.degree = 0;
        for( int a = 0; a < polynomialLength; a++)
        {
            if( coefficients[ a] != 0)
            {
                this.degree = a;
            }
        }
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
        return this.degree;
    }

    /**
     * Returns the value of the polynomial with the given variable by calculating each term one by one
     * @param variableValue value of the variable of the polynomial.
     * @return the value of the polynomial with the given variable.
     */
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
     * Returns the sum of two polynomials
     * @param p2, the polynomial that is going to be summed.
     * @return the sum of two polynomials.
     */

    public Polynomial add( Polynomial p2)
    {
        double[] returnCoefficients;

        returnCoefficients = new double[ Math.max( this.polynomialLength, p2.polynomialLength)];
        for( int a = 0; a < p2.polynomialLength; a++)
        {
            returnCoefficients[ a] = p2.coefficients[ a];
        }
        for( int a = 0; a < this.polynomialLength; a++)
        {
            returnCoefficients[ a] += coefficients[ a];
        }
        
        return new Polynomial( returnCoefficients);
    }

    /**
     * Returns the substraction of two polynomials(difference).
     * @param p2, the polynomial that is going to be substracted.
     * @return substraction of two polynomials(difference).
     */
    public Polynomial sub( Polynomial p2)
    {
        Polynomial aPolynomial = new Polynomial( -1, 0);

        return add( p2.mul( aPolynomial));
    }

    /**
     * Returns the product of two polynomials.
     * @param p2, the polynomial that is going to be multiplied.
     * @return the product of two polynomials.
     */
    public Polynomial mul( Polynomial p2)
    {
        double[] returnCoefficients;

        returnCoefficients = new double[ p2.getDegree() + coefficients.length];
        for( int a = p2.getDegree(); 0 <= a; a--)
        {
            for( int b = coefficients.length - 1; 0 <= b; b--)
            {
                returnCoefficients[ a + b] += p2.getCoefficient( a) * coefficients[ b];
            }
        }
        return new Polynomial( returnCoefficients);
    }

    /**
     * Returns the quotinent of two polynomials.
     * @param p2, the polynomial that will divide our main polynomial.
     * @return the quotinent of two polynomials.
     */
    public Polynomial div( Polynomial p2)
    {
        Polynomial copyPolynomial = new Polynomial( this.coefficients );
        Polynomial division = new Polynomial();
        
        while( copyPolynomial.getDegree() >= p2.getDegree())
        {
            int degree = copyPolynomial.getDegree() - p2.getDegree();
            double coefficient = copyPolynomial.coefficients[ copyPolynomial.getDegree()] / p2.coefficients[ p2.getDegree()];
            Polynomial divisionAdd = new Polynomial( coefficient, degree);
            division = division.add( divisionAdd);
            copyPolynomial = copyPolynomial.sub( p2.mul( divisionAdd));
        }
        
        return division;
    }

    /**
     * Retuns the composition of two polynomials
     * @param p2, the polynomial that is going to be used instead of 'x'--> leads to composition
     * @return the composition of two polynomials
     */
    public Polynomial compose( Polynomial p2)
    {
        Polynomial composition = new Polynomial();
        for( int i = 0; i <= getDegree(); i++)
        {
            Polynomial extraPolynomial = new Polynomial( 1, 0);
            for( int j =i; j >= 1; j-- )
            {
                extraPolynomial = extraPolynomial.mul( p2);
            }
            Polynomial term = new Polynomial( coefficients[ i], 0);
            composition = composition.add( term.mul( extraPolynomial));
        }
        return composition;
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