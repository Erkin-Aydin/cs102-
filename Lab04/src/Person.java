/**
 * An abstract Person class as an implementation of ILocatable interface.
 * In addition to ILocatable, it will also have a name property
 * @author Erkin Aydın
 * @version v/1.1
 */

public abstract class Person implements ILocatable
{
    //Properties
    String name;
    int posX;
    int posY;

    /**
     * Constructs a Person with given name and coordinates
     * @param name
     * @param x
     * @param y
     */
    public Person( String name, int x, int y)
    {
        setPos( x, y);
        this.name = name;
    }

    /**
     * Constructs a person with given name. Coordinates = (0,0)
     * @param name
     */
    public Person( String name)
    {
        setPos( 0, 0);
        this.name = name;
    }

    /**
     * @return the name of the Person
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the person
     * @param name
     */
    public void setName( String name)
    {
        this.name = name;
    }

    /**
     * Sets new coordinates to the person
     */
    @Override
    public void setPos( int x, int y)
    {
        posX = x;
        posY = y;
    }

    /**
     * @return x value of coordinates
     */
    @Override
    public int getX()
    {
        return posX;
    }

    /**
     * @return y value of coordinates
     */
    @Override
    public int getY()
    {
        return posY;
    }

    
}
