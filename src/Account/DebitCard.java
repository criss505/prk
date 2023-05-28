package Account;
import User.User;
import java.time.LocalDate;

public class DebitCard extends Card {
    private LocalDate orderDate, estimatedArrivalDate;
    public DebitCard(User owner, int PIN) {
        super(owner, PIN);
        orderDate = LocalDate.now();
        estimatedArrivalDate = orderDate.plusDays(7);
    }

    @Override
    public String toString() {
        String ts = "Debit Card" +
            "\nOwner: " + owner.getNameTag() +
            "\nIBAN: " + IBAN +
            "\nCVV: " + CVV +
            "\nPIN: " + PIN;
        if (LocalDate.now().isAfter(expiryDate)) {
            ts += "\nExpired";
        } else {
            ts += "\nValid until: " + expiryDate;
        }
        return ts;
    }

}
