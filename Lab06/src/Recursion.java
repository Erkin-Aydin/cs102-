import java.util.ArrayList;

/**
 * Implementation of Lab06, particularly focusing on the topic of recursion.
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Recursion
{
    // Part a)
    /**
     * Removes the specified char
     * @param str
     * @return a string with a removed char
     */
    public static String removeChar( String str)
    {
        if( str.length() == 0)
        {
            return str; // If its length is 0, then it certainly does not contain any 'r's.
        }
        else
        {
            if( str.charAt(0) == 'r')
            {
                // As the first letter is 'r', the method will be called for the rest of the string and it will be returned. 
                return removeChar( str.substring( 1));
            }
            else
            {
                 // As the first letter is not 'r' it will be returned and same process will be aplied to rest of the string.
                return str.charAt( 0) + removeChar(str.substring( 1));
            }
        }
    }

    // Part b)
    /**
     * Converts decimal numbers to hexadecimal numbers
     * @param number
     * @return hexadecimal representation of a decimal number
     */
    private static String hexadecimal( int number)
    {
        StringBuilder builder = new StringBuilder();

        if( number == 0)
        {
            return "" + 0; // Decimal '0' == Hexadecimal '0'
        }

        else if ( number > 0)
        {
            String hexNumber = hexadecimal( number / 16); // 
            String hexCode = "0123456789ABCDEF"; // Index number of these chars represent its hexadecimal values.
            int hexDigit = number % 16;
            builder.append( hexNumber + hexCode.charAt( hexDigit));
        }

        // Deleting the "0" in the beginning of the hexadecimal String if it exists.
        if( builder.charAt( 0) == '0') {
            builder.deleteCharAt( 0);
        }

        return builder.toString();
    }

    // Part c)
    /**
     * Sorts the given parameter ArrayList
     * @param list
     * @return sorted version of the ArrayList
     */
    public static Boolean isSorted( ArrayList<String> list)
    {
        int i = list.size(); // We start checking the list from the end of it.
        if( i <= 1) // If it is size is 1 or 0, then it definitely is sorted.
        {
            return true;
        }

        /* Comparing unicode values of the last and one previous member of the list.
        If last ones unicode number is les then the previous one the list is not sorted. */
        else if( list.get( i - 1).compareTo( list.get( i - 2)) < 0)
        {
            return false;
        }

        // We do not need the last member of the list anymore.
        list.remove( i - 1);
        i--;

        // Repearing the same idea with the rest of the list...
        return isSorted( list);
    }

    // Part d)
    /**
     * Reverses the given parameter String
     * @param str
     */
    public static void reverse( String str)
    {
        // There is no need to make any reversion if any of the given conditions is satisfied
        if ((str == null)||( str.length() <= 1))
        {
            System.out.println( str);
        }

        // If string length is bigger than 1, we will print the last characters of its substrings until substrings length is 1
        else
        {
            System.out.print( str.charAt( str.length() - 1));
            reverse( str.substring( 0, str.length() - 1));
        }
    }

    // Part e)
    /**
     * Prints every number that has increasing numbers in each order
     * @param int1
     * @param str1
     * @param n
     */
    public static void increasingNum( int int1, String str1, int n)
    {
        if ( n == 0)
        {
            int number;
            number = Integer.valueOf( str1);

            // If number is even, it is printed
            if( number % 2 == 0)
            {
                System.out.print( number + " ");
            }
        }

        for ( int i = int1; i <= 9; i++)
        {
            String str2 = str1 + i;
            increasingNum( i + 1, str2, n - 1);
        }
    }

    public static void main( String[] args)
    {
        // A
        System.out.println( "Part A: removeChar method");
        System.out.println( "Removing 'r's from 'ArRabaRarA': " + removeChar("ArRabaRarA"));

        // B
        System.out.println( "Part B: hexadecimal method");
        System.out.println( hexadecimal(1249));

        // C
        System.out.println( "Part C: isSorted method");
        ArrayList<String> test1 = new ArrayList<String>();
        ArrayList<String> test2 = new ArrayList<String>();

        // Adding Strings to ArrayLists to check isSorted method.
        test1.add("a");
        test1.add("b");
        test1.add("c");
        test1.add("d");
        test2.add("a");
        test2.add("z");
        test2.add("y");
        test2.add("g");

        System.out.println( "abcd: " + isSorted(test1)); // Will print true because 'abcd' is sorted
        System.out.println( "axfg: " + isSorted(test2)); // Will print false because 'axfg' is not sorted

        // D
        System.out.println( "Part D: Reverse method");
        System.out.print( "Reverse of 'Rammstein': ");
        reverse( "Rammstein");

        // E
        System.out.println( "Part E: increasingNum method");
        increasingNum( 1, "", 3);

    }
}