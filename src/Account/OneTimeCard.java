package Account;
import User.User;

import java.time.LocalDate;

public class OneTimeCard extends Card {
    private boolean used = false;
    public OneTimeCard(User owner, int PIN) {
        super(owner, PIN);
    }

    public boolean getUsed() {
        return used;
    }
    public void isUsed() {
        used = true;
    }

    @Override
    public String toString() {
        String ts = "One-Time Use Card" +
                "\nOwner: " + owner.getNameTag() +
                "\nIBAN: " + IBAN +
                "\nCVV: " + CVV +
                "\nPIN: " + PIN;
        if (LocalDate.now().isAfter(expiryDate)) {
            ts += "\nExpired";
        } else {
            ts += "\nValid until: " + expiryDate;
        }
        if (used) {
            ts += "\nThis card has been used!";
        } else {
            ts += "\nUnused";
        }
        return ts;
    }
}
