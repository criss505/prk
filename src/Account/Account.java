package Account;
import User.User;

public class Account {
    private String nameTag;
    private String currency;
    private double balance;
    private User user;

    public Account(String nameTag, String currency, double balance, User user) {
        this.nameTag = nameTag;
        this.currency = currency;
        this.balance = balance;
        this.user = user;
    }

    public String getNameTag() {
        return nameTag;
    }
    public String getCurrency() {
        return currency;
    }
    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }
    public void addBalance(double amount){
        this.balance += amount;
    }
    public void withdrawBalance(double amount){
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Details\n" +
                "currency: " + currency + '\n' +
                "balance: " + balance + '\n';
    }
}
