import java.util.Scanner;

/**
 * An implementation of all classes.
 * @author Erkin Aydın
 * @version v/1.1
 */

public class CompanyTester
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);

        //Constant
        final String DIVIDER = "<===============================================>";

        // Variables
        Item item1 = new Item( 0.1, "AAAAAAA");
        Item item2 = new Item( 0.1, "BBBBBBB");
        Item item3 = new Item( 1, "CCCCCCC");       
        Item item4 = new Item( 2, "DDDDDDD");

        Customer customer1 = new Customer( "Erkin");
        Customer customer2 = new Customer( "Onur");

        Employee employee = new Employee( 1, "Eren");

        Company company = new Company( 10, 10);
        int theChoice = 0;
        do
        {
            theChoice = 0;
            System.out.println("Customers==> " + customer1 + " | " + customer2);
            System.out.println("Company Employees==> " + company.employees[0]);
            System.out.println("Menu:");
            System.out.println("1: Add mail to Erkin");
            System.out.println("2: Add mail to Onur");
            System.out.println("3: Add package to Erkin");
            System.out.println("4: Add package to Onur");
            System.out.println("5: Erkin sends item to Onur");
            System.out.println("6: Onur sends item to Erkin");
            System.out.println("7: Add employee");
            System.out.println("8: Fire employee");
            System.out.println("9: Deliver them all!");
            System.out.println("0: Out");
            System.out.print("Choose: ");
            theChoice = scan.nextInt();
 
            switch(theChoice)
            {
                case 1:
                    customer1.setCurrentItem( item1);
                    break;

                case 2:
                    customer2.setCurrentItem( item2);
                    break;

                case 3:
                    customer1.setCurrentItem( item3);
                    break;

                case 4:
                    customer2.setCurrentItem( item4);
                    break;

                case 5:
                    customer1.sendItem(company, item3, customer2);
                    break;

                case 6:
                    customer2.sendItem(company, item4, customer1);
                    break;

                case 7:
                    Employee newEmployee = new Employee( employee);
                    company.addEmployee( newEmployee);
                    break;

                case 8:
                    company.terminateContract( company.numOfEmployees - 1);
                    break;

                case 9:
                    company.deliverPackages();
                    break;
            }
            System.out.println(DIVIDER);

        } while(0 < theChoice);

        scan.close();
    }
}
