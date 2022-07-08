/**
 * Creates an item that has a weight and a content
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Item 
{
    //Properties
    double weight;
    String content;

    /**
     * Constructs an item with given weight and content
     * @param weight
     * @param content
     */
    public Item( double weight, String content)
    {
        this.weight = weight;
        this.content = content;
    }

    /**
     * @return the weight of the item
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * @return the content of the item
     */
    public String getContent()
    {
        return content;
    }

    /**
     * @return String representation of the item
     */
    @Override
    public String toString()
    {
        return "Weight: " + weight + " | Content: " + content;
    }
}
