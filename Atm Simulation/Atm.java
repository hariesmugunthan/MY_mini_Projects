class Atm {
    private String name;
    private double totalAmount;

    Atm(String n, double v) {
        name = n;
        totalAmount = v;
    }

    public void uploadAmount(double v) {
        totalAmount += v;
    }

    public void withdrawAmount(double v) {
        totalAmount -= v;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getName() {
        return name;
    }
}
