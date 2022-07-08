/**
 * Represents a 2D shape's center's coordinates.
 * @author Erkin Aydın
 * @version v/1.1
 */
public abstract class Shape2D
{
    int x;
    int y;

    /**
     * It constructs a shape with two attributes that determine it's center's coordinations, x and y.
     * @param x
     * @param y
     */
    public Shape2D( int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the perimeter of the Shape2D Object
     */
    public abstract double calculatePerimeter();

    /**
     * @return the area of the Shape2D Object
     */
    public abstract double calculateArea();

    /**
     * It will calculate the distance between two shapes' centers.
     * @param anyShape
     * @return the distance between two Shape2D's or -1 if the parameter is not a Shape2D
     */
    public double calculateDistance( Object anyShape) //Problematic
    {
        if( anyShape instanceof Shape2D )
        {
            return Math.sqrt( Math.pow( ( this.x - ( ( Shape2D)anyShape).x), 2) + Math.pow( ( this.y - ( ( Shape2D)anyShape).y), 2));
        }
            return -1;
    }

    /**
     * It will return the string representation of the Shape2D's center coordinates
     * @return the string representation of the Shape2D's center coordinates
     */
    @Override
    public String toString()
    {
        return "Coordinates==> x: " + this.x + " , y: " + this.y;
    }

    /**
     * @return whether the parameter object is the same with the Shape2D we are checking
     */
    @Override
    public boolean equals( Object anyShape)
    {
        if( anyShape instanceof Shape2D)
        {
            return this.x == ( ( Shape2D)anyShape).x && this.y == ( ( Shape2D)anyShape).y;
        }
        return false;
    }

}