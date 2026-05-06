import java.util.*;
public class Bank {

    static Scanner o = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Customer> cs = new ArrayList<>();

        cs.add(new Customer("Haries", 100000, "2123434321", 1234));
        cs.add(new Customer("Batman", 200000, "1234567890", 4321));
        cs.add(new Customer("Bruce", 50000, "8535434343444", 4567));

        Atm a = new Atm("KPM ATM", 10000000);

        Bank b = new Bank();

        int c = 1;

        while (c == 1) {

            System.out.println("\n=================================");
            System.out.println("      WELCOME TO " + a.getName());
            System.out.println("=================================");

            System.out.print("Enter Account Number: ");
            String ac = o.next();

            Customer cus = null;

            for (Customer e : cs) {
                if (ac.equals(e.getAccno())) {
                    cus = e;
                    break;
                }
            }

            if (cus == null) {
                System.out.println("\nInvalid Account Number!");
            } else {

                System.out.print("Enter 4-Digit PIN: ");
                int pin = o.nextInt();

                if (pin != cus.getPincode()) {
                    System.out.println("\nIncorrect PIN!");
                } else {

                    cus.display();

                    System.out.println("\n========== ATM MENU ==========");
                    System.out.println("1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Change PIN");
                    System.out.println("5. ATM Balance");
                    System.out.println("==============================");

                    System.out.print("Enter Your Choice: ");
                    int x = o.nextInt();

                    switch (x) {

                        case 1:
                            b.withdraw(cus, a);
                            break;

                        case 2:
                            b.deposit(cus, a);
                            break;

                        case 3:
                            b.checkBalance(cus);
                            break;

                        case 4:
                            b.changePin(cus);
                            break;

                        case 5:
                            System.out.println("\nATM Total Balance: ₹" + a.getTotalAmount());
                            break;

                        default:
                            System.out.println("\nInvalid Choice!");
                    }
                }
            }

            System.out.println("\nDo You Want To Continue?");
            System.out.println("Press 1 -> Yes");
            System.out.println("Press 0 -> No");
            System.out.print("Enter Choice: ");

            c = o.nextInt();
        }

        System.out.println("\nThank You For Using KPM ATM");
    }

    public void withdraw(Customer c, Atm a) {

        System.out.println("\n========== WITHDRAW ==========");

        System.out.print("Enter Amount: ₹");
        double amt = o.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid Amount!");
        }

        else if (c.getBalance() >= amt && a.getTotalAmount() >= amt) {

            c.withdraw(amt);
            a.withdrawAmount(amt);

            System.out.println("\nAmount Withdrawn Successfully!");
            System.out.println("Remaining Balance: ₹" + c.getBalance());
        }

        else {
            System.out.println("\nInsufficient Balance!");
        }
    }

    public void deposit(Customer c, Atm a) {

        System.out.println("\n========== DEPOSIT ==========");

        System.out.print("Enter Amount: ₹");
        double amt = o.nextDouble();

        if (amt <= 0) {
            System.out.println("Invalid Amount!");
        } else {

            c.deposit(amt);
            a.uploadAmount(amt);

            System.out.println("\nAmount Deposited Successfully!");
            System.out.println("Updated Balance: ₹" + c.getBalance());
        }
    }

    public void checkBalance(Customer c) {

        System.out.println("\n========== ACCOUNT BALANCE ==========");
        System.out.println("Available Balance: ₹" + c.getBalance());
    }

    public void changePin(Customer c) {

        System.out.println("\n========== CHANGE PIN ==========");

        System.out.print("Enter New 4-Digit PIN: ");
        int np = o.nextInt();

        c.changePincode(np);

        System.out.println("\nPIN Changed Successfully!");
    }
}