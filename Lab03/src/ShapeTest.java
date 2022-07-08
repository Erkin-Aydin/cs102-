/**
 * The application of Shape2D and it's sub-classes. We will simply ause every method existing in these files
 * @author Erkin Aydın
 * @version v/1.1
 */
public class ShapeTest
{
    /**
     * Returns the Shape2D which has the largest area in a Shape2D array
     * @param aShape2DArray
     * @return null if such computation can't happen, the Shape2D with the largest area if it can
     */
    public static Shape2D findLargestArea( Shape2D[] aShape2DArray)
    {
        for( int a = 0; a < aShape2DArray.length; a++)
        {
            if( aShape2DArray[ a].calculateArea() == Math.max( aShape2DArray[ 2].calculateArea(), 
                Math.max( aShape2DArray[ 0].calculateArea(), aShape2DArray[ 1].calculateArea())))
            {
                return aShape2DArray[ a];
            }
        }
        return null;
    }

    /**
     * Returns the Shape2D which has the largest area in a Shape2D array
     * @param aShape2DArray
     * @return null if such computation can't happen, the Shape2D with the largest perimeter if it can
     */
    public static Shape2D findLargestPerimeter( Shape2D[] aShape2DArray)
    {
        for( int a = 0; a < aShape2DArray.length; a++)
        {
            if( aShape2DArray[ a].calculatePerimeter() == Math.max( aShape2DArray[ 2].calculatePerimeter(), 
                Math.max( aShape2DArray[ 0].calculatePerimeter(), aShape2DArray[ 1].calculatePerimeter())))
            {
                return aShape2DArray[ a];
            }
        }
        return null;
    }

    public static void main( String[] args)
    {

        final String DIVIDER = "=====================================>";

        Circle aCircle = new Circle( 5, 12, 6);
        Rectangle aRectangle = new Rectangle( 3, 2, 5, 10);

        System.out.println( aCircle);
        System.out.println( aRectangle);
        System.out.println( DIVIDER);

        Square square1 = new Square( 4, 3, 3);
        Square square2 = new Square( 4, 3, 3);
        Square square3 = new Square( 2, 4, 7);

        System.out.println( "sq1: " + square1);
        System.out.println( "sq2: " + square2);
        System.out.println( "sq3: " + square3);
        System.out.println( DIVIDER);

        System.out.println( "sq1.equals( sq2): " + square1.equals( square2));
        System.out.println( "sq1.equals( sq3): " + square1.equals( square3));
        System.out.println( "sq2.equals( sq3): " + square2.equals( square3));
        System.out.println( "sq3.equals( aCircle): " + square3.equals( aCircle));
        System.out.println( "sq3.equals( aRectangle): " + square3.equals( aRectangle));
        System.out.println( "aCircle.equals( aRectangle): " + aCircle.equals( aRectangle));
        System.out.println( DIVIDER);

        Shape2D[] aShape2DArray = new Shape2D[ 3];

        aShape2DArray[ 0] = aCircle;
        aShape2DArray[ 1] = aRectangle;
        aShape2DArray[ 2] = square1;

        System.out.println( "The shape array: ");
        for( int a = 0; a < aShape2DArray.length; a++)
        {
            System.out.print( aShape2DArray[ a] + ", ");
        }
        System.out.println( DIVIDER);

        System.out.println( findLargestArea( aShape2DArray) + " has the largest area.");
        System.out.println( findLargestPerimeter( aShape2DArray) + " has the longest perimeter.");

        System.out.println( "Distance between the cicle and the rectangle is " + aShape2DArray[ 0].calculateDistance( aShape2DArray[ 1]));
        System.out.println( "Distance between the circle and the square is " + aShape2DArray[ 0].calculateDistance( aShape2DArray[ 2]));
        System.out.println( "Distance between the square and the rectangle is " + aShape2DArray[ 2].calculateDistance( aShape2DArray[ 1]));

    }
}
