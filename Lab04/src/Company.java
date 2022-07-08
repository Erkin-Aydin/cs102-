import java.util.ArrayList;

/**
 * Creates a locatable company containing an Array of employees and an ArrayList of customers. The main job of this
 * class is to get sended deliveries from customers, store them and deliver them via responsable employees.
 * @author Erkin Aydın
 * @version v/1.1
 */

public class Company implements ILocatable
{
    //Constants
    final int EMPLOYEE_CAPACITY = 15;

    //Arrays and ArrayLists
    Employee[] employees;
    ArrayList<Customer> customers;

    //Properties
    int numOfEmployees;
    int employeeNo;
    int packageNo;
    int posX;
    int posY;

    /**
     * Constructs a company with given coordinates
     * @param x
     * @param y
     */
    public Company( int x, int y)
    {
        setPos( x, y);
        employees = new Employee[ EMPLOYEE_CAPACITY - 1];
    }

    /**
     * Relocates the company
     * @param x
     * @param y
     */
    @Override
    public void setPos( int x, int y)
    {
        posX = x;
        posY = y;
    }

    /**
     * @return posX = x coordinate of the company
     */
    @Override
    public int getX()
    {
        return posX;
    }

    /**
     * @return posY = y coordinate of the company
     */
    @Override
    public int getY()
    {
        return posY;
    }

    /**
     * This method adds a new employee to the company if there is a empty place in employees Array
     * @param candidate
     * @return true if a new employee is added, false if not
     */
    public boolean addEmployee( Employee candidate)
    {
        Employee employee = new Employee( candidate);
        if( numOfEmployees < EMPLOYEE_CAPACITY)
        {
            employees[ numOfEmployees] = employee;
            numOfEmployees++;
        }
        return numOfEmployees < EMPLOYEE_CAPACITY;
    }

    /**
     * Adds a customer to the company. Infinite customers can be added to this company
     * @param customer
     */
    public void addCustomer( Customer customer)
    {
        customers.add( customer);
    }

    /**
     * 
     * @param employeeIndex
     * @return true if such an employee exists, false otherwise
     */
    public boolean terminateContract( int employeeIndex)
    {
        if( employees[ employeeIndex] instanceof Employee)
        {
            employees[ employeeIndex] = null;
            numOfEmployees--;
            return true;
        }
        return false;
    }

    /**
     * Creates the suitable delivery with the given item, its sender and receiver
     * @param sendItem
     * @param sender
     * @param receiver
     * @return true if there is an available employee, false otherwise
     */
    public boolean createDeliverable( Item sendItem, Customer sender, Customer receiver)
    {
        boolean a = false;
        int i;
        for( i = 0; i < numOfEmployees; i++)
        {
            if( employees[i].isAvailable())
            {
                a = true;
                break;
            }
        }
        if( a)
        {   
            Delivery aDelivery;
            if( sendItem.getWeight() <= 0.1)
            {
                System.out.println("num : " + numOfEmployees);
                System.out.println("i : " + i);
                aDelivery = new Mail( sendItem.getContent(), sender, receiver, packageNo);
                System.out.println(aDelivery);
                employees[ i].addJob( aDelivery, sender, receiver, packageNo);
            }
            else
            {
                aDelivery = new Package( sendItem, sender, receiver, packageNo);
                System.out.println(aDelivery);
                employees[ i].addJob( aDelivery, sender, receiver, packageNo);
            }
            packageNo++;
        }
        return a;
    }

    /**
     * Devivers every package in the list of employees
     */
    public void deliverPackages()
    {
        for( int i = 0; i < numOfEmployees; i++)
        {
            int currentJob = employees[ i].currentJob;
            for( int a = 0; a < currentJob; a++)
            {
                if( employees[i].deliveries[a] instanceof Mail)
                {
                    employees[i].deliveries[a].receiver.setCurrentItem( new Item( employees[i].deliveries[a].getWeight(), ( ( Mail)employees[i].deliveries[a]).content));
                    employees[i].deliveries[a] = null;
                    employees[i].currentJob--;
                }
                else if( employees[i].deliveries[a] instanceof Package)
                {
                    employees[i].deliveries[a].receiver.setCurrentItem( ( ( Package)employees[i].deliveries[a]).packageItem);
                    employees[i].deliveries[a] = null;
                    employees[i].currentJob--;
                }
            }

        }
    }
}
