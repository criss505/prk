import Account.Account;
import Account.Card;
import Account.OneTimeCard;
import User.User;

import java.util.Random;
import java.util.Scanner;

public class POS {
    private Random random;
    private Scanner scanner;
    private String currency = "usd";


    public static void main(String[] args) {
        POS pos = new POS();
        pos.makePayment();
    }
    public POS() {
        random = new Random();
        scanner = new Scanner(System.in);
    }


    public void makePayment() {
        double amount = generateRandomAmount(20, 100);
        System.out.println("Payment amount: $" + amount);

        System.out.print("Enter your card number: ");
        String cardNumber = scanner.nextLine();

        Main main = ServiceUser.main;
        Card the_card = main.getCard(cardNumber);

        // if card does not exist
        if (the_card == null) {
            System.out.println("Payment failed. Invalid card number.");
            return;
        }

        System.out.print("Enter the cardholder's nameTag: ");
        String cardHolderName = scanner.nextLine();

        System.out.print("Enter the CVV: ");
        String cvv = scanner.nextLine();

        System.out.println("Enter the expiration date (MM-YY): ");
        String expirationDate = scanner.nextLine();

        // check if information matches card information - are  mici probleme
        if (the_card.getOwnerName().equals(cardHolderName) || the_card.getExpiryDate().equals(expirationDate) || the_card.getCVV() != Integer.parseInt(cvv)) {
            System.out.println("Payment failed. Invalid card details.");
            if (the_card.getOwnerName() != cardHolderName) {
                System.out.println("NameTag does not match.");
            }
            if (the_card.getExpiryDate() != expirationDate) {
                System.out.println("Expiration date does not match.");
            }
            if (the_card.getCVV() != Integer.parseInt(cvv)) {
                System.out.println("CVV does not match.");
            }
            return;
        }

        boolean paymentSuccessful = processPayment(the_card.getOwner(), amount);
        if (the_card instanceof OneTimeCard) {
            ((OneTimeCard) the_card).isUsed();
            the_card.getOwner().removeCard(the_card);
        }

        if (paymentSuccessful) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed. Insufficient funds or invalid card details.");
        }
    }
    private double generateRandomAmount(double minAmount, double maxAmount) {
        return minAmount + (maxAmount - minAmount) * random.nextDouble();
    }
    private boolean processPayment(User user, double amount) {
        Account the_account = user.getAccount(currency);
        if (the_account == null) {
            return false;
        }
        the_account.withdrawBalance(amount);
        return true;
    }

}
