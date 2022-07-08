/**
 * A Delivery as an abstract class. It will have a number, receiver and sender 
 * @author Erkin Aydın
 * @version v/1.1
 */

public abstract class Delivery
{
    //Properties
    int packageNo;
    Customer sender;
    Customer receiver;

    /**
     * Constructs a delivery with given parameters
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public Delivery( Customer sender, Customer receiver, int packageNo)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
    }

    /**
     * @return the sender of this delivery
     */
    public Customer getSender()
    {
        return sender;
    }

    /**
     * @return the receiver of this delivery
     */
    public Customer getReceiver()
    {
        return receiver;
    }

    /**
     * @return the package number of this delivery
     */
    public int getPackageNo()
    {
        return packageNo;
    }

    abstract double getWeight();
}
