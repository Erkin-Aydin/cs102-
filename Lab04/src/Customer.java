/**
 * Creates a customer as an extention of Person class
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Customer extends Person
{
    // Property
    Item currentItem;

    /**
     * Constructs a Customer with the given name
     * @param name
     */
    public Customer( String name)
    {
        super( name);
        currentItem = null;
    }

    /**
     * @return the current item that the customer has
     */
    public Item getCurrentItem()
    {
        return currentItem;
    }

    /**
     * Sets currentItem to the parameter
     * @param currentItem
     */
    public void setCurrentItem( Item currentItem)
    {
        this.currentItem = currentItem;
    }

    /**
     * Let's customer to send his/her current item
     * @param company
     * @param item
     * @param receiver
     * @return true if an employee is available, false otherwise
     */
    public boolean sendItem( Company company, Item item, Customer receiver)
    {
        boolean isAvailable = false;
        int a = 0;
        for( ;a < company.numOfEmployees && !isAvailable; a++)
        {
            if(company.employees[a].isAvailable())
            {
                isAvailable = true;
            }
        }
        if( isAvailable)
        {
            if( currentItem == null)
            {
                company.createDeliverable( item, new Customer( name), receiver);
            }
            else
            {
                company.createDeliverable( currentItem, new Customer( name), receiver);
                currentItem = null;
            }
        }
        return isAvailable;
    }

    /**
     * @return String representation of the customer
     */
    @Override
    public String toString()
    {
        return "Name: " + name + ", posX: " + posX + ", posY: " + posY + ", Current Item: " + currentItem;
    }
}
