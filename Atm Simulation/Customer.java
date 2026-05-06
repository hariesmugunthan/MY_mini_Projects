class Customer {
    private String name;
    private String accno;
    private int pincode;
    private double balance;

    public Customer(String name, double v, String l, int p) {
        this.name = name;
        balance = v;
        accno = l;
        pincode = p;
    }

    public void display() {
        System.out.println("\n----- CUSTOMER DETAILS -----");
        System.out.println("Name          : " + this.name);
        System.out.println("Account Number: " + this.accno);
    }

    public String getAccno() {
        return this.accno;
    }

    public double getBalance() {
        return balance;
    }

    public int getPincode() {
        return pincode;
    }

    public void withdraw(double v) {
        balance -= v;
    }

    public void deposit(double v) {
        balance += v;
    }

    public void changePincode(int p) {
        pincode = p;
    }
}