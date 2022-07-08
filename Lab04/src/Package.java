/**
 * Creates a Package as a sub-class of Delivery class
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Package extends Delivery
{
    //Properties
    Item packageItem;

    /**
     * Constructs a package with given item, sender, receiver and package number
     * @param packageItem
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public Package( Item packageItem, Customer sender, Customer receiver, int packageNo)
    {
        super( sender, receiver, packageNo);
        this.packageItem = packageItem;
    }

    /**
     * @return the weight of the package
     */
    public double getWeight()
    {
        return packageItem.getWeight();
    }

    /**
     * @return String representation of the package
     */
    @Override
    public String toString()
    {
        return "Sender: " + sender.getName() + ", Receiver: " + receiver.getName() + ", PackageNo: " + packageNo + ", Item: " + packageItem;
    }
}
