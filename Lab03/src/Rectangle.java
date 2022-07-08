/**
 * A sub-class of Shape2D. It represents a rectangle( which has the potential to be a square)
 * @author Erkin Aydın
 * @version v/1.1
 */
public class Rectangle extends Shape2D
{
    // Constants
    final int TWO = 2;

    // Properties
    int height;
    int width;

    /**
     * Constructs a rectangle with given coordinates, height and width
     * @param x
     * @param y
     * @param height
     * @param width
     */
    public Rectangle( int x, int y, int height, int width)
    {
        super( x, y);
        this.height = height;
        this.width = width;
    }

    /**
     * @return perimeter of the rectangle.
     */
    @Override
    public double calculatePerimeter()
    {
        return TWO * ( height + width);
    }

    /**
     * @return area of the rectangle.
     */
    @Override
    public double calculateArea()
    {
        return height * width;
    }

    /**
     * @return String representation of rectangle's center coordinates, height and width
     */
    @Override
    public String toString()
    {
        return "Type: Rectangle, " + super.toString() + ", height: " + this.height + ", width: " + this.width;
    }

    /**
     * @return whether the parameter Object is the same with the rectangle
     */
    @Override
    public boolean equals( Object anyShape)
    {
        if( anyShape instanceof Rectangle)
        {
            return super.equals( anyShape) && this.height == ( ( Rectangle) anyShape).height && this.width == ( ( Rectangle) anyShape).width;
        }
        else if( anyShape instanceof Square)
        {
            return super.equals( anyShape) && this.width == this.height && this.width == ( ( Square) anyShape).sideLength;
        }
        return false;
    }
}
