/**
 * Creates a mail as a sub-class of Delivery class. It's weight is always 0.1
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Mail extends Delivery
{
    //Properties
    String content;

    /**
     * Constructs a mail with given content, sender, receiver and package(mail) number
     * @param content
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public Mail( String content, Customer sender, Customer receiver, int packageNo)
    {
        super( sender, receiver, packageNo);
        this.content = content;
    }

    /**
     * @return the weight of a mail = 0.1
     */
    public double getWeight()
    {
        return 0.1;
    }

    /**
     * @return String representation of the mail
     */
    @Override
    public String toString()
    {
        return "Content: " + content + ", Sender: " + sender + ", Receiver: " + receiver + ", packageNo: " + packageNo;
    }
}
