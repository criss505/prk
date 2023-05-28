package Account;
import User.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Card {
    protected User owner;
    protected final String IBAN;
    protected final int CVV;
    protected int PIN;
    protected LocalDate creationDate, expiryDate;

    public Card(User owner, int PIN) {
        this.owner = owner;
        this.PIN = PIN;


        Random random = new Random();
        StringBuilder ibanBuilder = new StringBuilder("BA");
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(10);
            ibanBuilder.append(randomNumber);
        }
        this.IBAN = ibanBuilder.toString();

        random = new Random();
        int randomCVV = random.nextInt(900) + 100; // random number [100,999]
        this.CVV = (randomCVV);

        this.creationDate = LocalDate.now();
        this.expiryDate = creationDate.plusYears(5);
    }


//    getters
    public User getOwner() {
        return owner;
    }
    public String getOwnerName() {
        return owner.getNameTag();
    }
    public String getIBAN() {
        return IBAN;
    }
    public int getCVV() {
        return CVV;
    }
    public int getPIN() {
        return PIN;
    }
    public String getExpiryDate() {
        //get the date as MM-YY

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-YY");
        String formattedExpiryDate = expiryDate.format(formatter);

        return formattedExpiryDate;
    }

//    setters
    public void changePIN(int PIN) {
        this.PIN = PIN;
    }
    public String toString() {
            String ts = "Card"
                    + "\nOwner: " + owner.getNameTag() + "\n"
                    + "\nIBAN: " + IBAN
                    + "\nCVV: " + CVV
                    + "\nPIN: " + PIN;
            if (LocalDate.now().isAfter(expiryDate)) {
                ts += "\nExpired";
            } else {
                ts += "\nValid until: " + expiryDate;
            }
            return ts;
        }


    public void processPayment(String currency, double amount) {
        System.out.println("Payment of " + amount + " processed.");
    }

}
