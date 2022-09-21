class Account {
    // instance variables
    private String accName;
    private double balance;
    private double intRate;

    // constructor
    public Account (String accName, double intRate) {
        this.accName = accName;
        this.intRate = intRate;
    }

    // instance methods

    // deposit instance method
    public boolean deposit(double funds) {
        if(funds>0) {
            balance += funds;
            return true;
        } return false;
    }

    // withdraw instance method
    public boolean withdraw(double funds) {
        balance -= funds;
        if((funds <= 0) || (balance <= 0)) {
            return false;
        } return true;
    }

    // getBalance instance method
    public double getBalance() {
        return this.balance;
    }

    // getName instance method
    public String getName() {
        return this.accName;
    }

    // calcInterest instance method
    public void calcInterest(int months) {
        double interest = 0, interestPeriod = 0;
        interestPeriod = intRate*(months/12.00)/balance;
        interest = balance * (1 + interestPeriod);
    }
}
