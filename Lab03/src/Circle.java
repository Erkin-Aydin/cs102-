/**
 * A sub-class of Shape2D. It represents a circle.
 * @author Erkin Aydın
 * @version v/1.1
 */
public class Circle extends Shape2D
{
    // Constants
    final double PI = Math.PI;
    final int TWO = 2;

    // Properties
    int radius;

    /**
     * It constructs a circle with given coordinates and radius
     * @param radius
     * @param x
     * @param y
     */
    public Circle( int radius, int x, int y)
    {
        super( x, y);
        this.radius = radius;
    }

    /**
     * @return perimeter of the circle
     */
    @Override
    public double calculatePerimeter()
    {
        return TWO * PI * radius;
    }

    /**
     * @return area of the circle
     */
    @Override
    public double calculateArea()
    {
        return PI * Math.pow( radius, 2);
    }

    /**
     * @return String representation circle's center coordinates and it's radius
     */
    @Override
    public String toString()
    {
        return "Type: Circle, " + super.toString() + ", radius: " + this.radius;
    }

    /**
     * @return whether the parameter Object is the same with the circle
     */
    @Override
    public boolean equals( Object anyShape)
    {
        if( anyShape instanceof Circle)
        {
            return super.equals( anyShape) && this.radius == ( ( Circle) anyShape).radius;
        }
        return false;
    }
    
}
