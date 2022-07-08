/**
 * A sub-class of Shape2D. It represents a square.
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Square extends Shape2D
{
    // Constants
    final int FOUR = 4;

    // Properties
    int sideLength;

    /**
     * It constructs a square with given side length and coordinates
     * @param sideLength
     * @param x
     * @param y
     */
    public Square( int sideLength, int x, int y)
    {
        super( x, y);
        this.sideLength = sideLength;
    }

    /**
     * @return the perimeter of the square
     */
    @Override
    public double calculatePerimeter()
    {
        return FOUR * sideLength;
    }

    /**
     * @return the area of the square
     */
    @Override
    public double calculateArea()
    {
        return Math.pow( sideLength, 2);
    }

    /**
     * @return String representation of square's coordinates and it's side length
     */
    @Override
    public String toString()
    {
        return "Type: Square, " + super.toString() + ", side length: " + this.sideLength;
    }

    /**
     * @return whether the given object is the same square or not
     */
    @Override
    public boolean equals( Object anyShape)
    {
        if( anyShape instanceof Square)
        {
            return super.equals( anyShape) && this.sideLength == ( ( Square) anyShape).sideLength;
        }
        else if( anyShape instanceof Rectangle)
        {
            return super.equals( anyShape) && this.sideLength == ( ( Rectangle) anyShape).width 
            && this.sideLength == ( ( Rectangle) anyShape).height;
        }
        return false;
    }
}
