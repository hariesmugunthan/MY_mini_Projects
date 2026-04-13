import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main extends DbConnection {
    private static LocalDate today = LocalDate.now();
   private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
   private static String Date = today.format(formatter);
   private  static String Role;
    static private int C_id;
    Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
       int run=1;
       while(run==1){
           System.out.println("Who the hell are you(Customer press 1 || Sales Person press 2):");

           int choice=o.nextInt();
           Role = (choice == 1) ? "Customer" : "Sales Person";
           switch (Role){
               case "Customer":
                   Customer();
                   break;
               case "Sales Person":
                   Products p=new Products();
                   System.out.println("do u want to add new item press 1 || else press 0");
                   int x=o.nextInt();
                   if(x==1) p.insertProduct();

                   break;
           }
           System.out.println("do u want to book products press 1 else press 0 ");
           int b=o.nextInt();
           if(b==1){
               Orders o1=new Orders();
               o1.selectItems(C_id,Date);

           }


           System.out.println("to continue press '1' else press anything");
           run=o.nextInt();
       }
        System.out.println("thank you!");

    }
    public static void Customer() throws SQLException {
        System.out.println("for new Customer press 1 || Existing Customer press 2");
        int choice=o.nextInt();

        Customer c=new Customer();
       // Products p=new Products();
        switch (choice){
            case 1:
                C_id=c.createCustomer();
                System.out.println("your Id is: "+C_id);
                break;
            case 2:
                System.out.println("Enter the C_id: ");
                C_id=o.nextInt();

                break;
        }

    }
}
