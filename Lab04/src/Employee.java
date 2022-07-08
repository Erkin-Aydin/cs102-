/**
 * An employee class as an extention of Person class
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Employee extends Person
{
    //Constants
    final int MAX_JOBS = 5;

    //Properties
    int currentJob;
    Delivery[] deliveries;
    double salary;
    int employeeNo;
    boolean available;

    /**
     * Constructs an Employee with given name and employee number
     * @param employeeNo
     * @param name
     */
    public Employee( int employeeNo, String name)
    {
        super( name);
        this.employeeNo = employeeNo;
        deliveries = new Delivery[MAX_JOBS];
    }

    /**
     * Construts an Employee via copying another one
     * This constructor is an addition to the assignment made by Erkin Aydın
     * @param copyEmployee
     */
    public Employee( Employee copyEmployee)
    {
        super( copyEmployee.getName());
        this.employeeNo = copyEmployee.employeeNo;
        deliveries = new Delivery[MAX_JOBS];
    }

    /**
     * Sets employees salary
     * @param value
     */
    public void adjustSalary( double value)
    {
        this.salary = value;
    }

    /**
     * @return true if the employee is available, false otherwise
     */
    public boolean isAvailable()
    {
        return currentJob < MAX_JOBS;
    }

    /**
     * Adds a job to the employee if s/he is available
     * @param sendItem
     * @param sender
     * @param receiver
     * @param packageNo
     */
    public void addJob( Delivery sendItem, Customer sender, Customer receiver, int packageNo)
    {
        if( isAvailable())
        {
            // Type of the item matters. Here we determine it
            if( sendItem.getWeight() <= 0.1)
            {
                deliveries[currentJob] = ( Mail)sendItem;
            }
            else
            {
                deliveries[currentJob] = ( Package)sendItem;
            }
            currentJob++;
        }
        else
        {
            System.out.println( "S/he is not available.");
        }
    }
}
