package User;

import java.time.LocalDateTime;

public class Transaction {
//    save details of a transaction a user makes
    private User userSending, userReceiving;
    private LocalDateTime transactionDate;
    private double amount;
    private String currency;
    private String message;

    public Transaction(User userSending, User userReceiving, String currency, double amount, String message, LocalDateTime transactionDate) {
        this.userSending = userSending;
        this.userReceiving = userReceiving;
        this.currency = currency;
        this.amount = amount;
        this.message = message;
        this.transactionDate = transactionDate;
    }

//    getters
    public User getUserSending() {
        return userSending;
    }
    public User getUserReceiving() {
        return userReceiving;
    }
    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
    public double getAmount() {
        return amount;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Transaction\n" +
                "User Sending: " + userSending +
                "\nUser Receiving: " + userReceiving +
                "\nAmount: " + amount +
                "\nCurrency: " + currency +
                "\nMessage: " + message +
                "\nTransaction Date: " + transactionDate;
    }
}
