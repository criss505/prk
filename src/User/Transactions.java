package User;
import Account.Plan;

import java.util.Date;
public class Transactions {
//    save details of all transactions users make
    private User userSending, userReceiving;
    private Date transactionDate;
    private double amount;
    private String message;

    public Transactions(User userSending, User userReceiving, Date transactionDate, double amount, String message) {
        this.userSending = userSending;
        this.userReceiving = userReceiving;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.message = message;
    }

//    getters
    public User getUserSending() {
        return userSending;
    }

    public User getUserReceiving() {
        return userReceiving;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }


}
