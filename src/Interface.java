import Account.*;
import User.*;

import java.util.Date;
public interface Interface {
    void createUser(String name, String email, String password, Date birthDate);
    void updateUser(User user);

    void createPlan(String name, String description, int price, int duration);
    void updatePlan(User user, Plan plan);

    void createAccount(User user, Plan plan);

    void createCard(User user);
    void deleteCard(User user);

    void transfer(User user, Plan plan);

    void createLoan(User user, Plan plan);
    void updateLoan(User user, Plan plan);
    void deleteLoan(User user, Plan plan);

    void createVault(User user);
    void updateVault(User user);
    void deleteVault(User user);
}
