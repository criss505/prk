package Account;
import User.User;

import java.time.LocalDate;

public class VirtualCard extends Card{
    public VirtualCard(User owner, int PIN) {
        super(owner, PIN);
    }

    @Override
    public String toString() {
        String ts = "Virtual Card" +
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
