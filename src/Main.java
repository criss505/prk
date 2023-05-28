//import user package
import User.User;
//import account package
import Account.Plan;
import Account.Card;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    private HashMap<String, User> usersMap = new HashMap<>(); // nameTag is the key
    private HashMap<String, Card> cardsMap = new HashMap<>(); // IBAN is the key
    private Audit audit = new Audit();


    public static void main(String[] args) {
        Main main = new Main();

    }

    // create users
    public void createUser() throws IOException {
        System.out.println("Creating user...");

        System.out.println("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter nameTag: ");
        String nameTag = scanner.nextLine();
        User existingUser = usersMap.get(nameTag);
        while (existingUser != null) {
            System.out.println("NameTag already exists. Please enter a different nameTag: ");
            nameTag = scanner.nextLine();
            existingUser = usersMap.get(nameTag);
        }

        System.out.println("Enter password: ");
        String password = scanner.nextLine();


        System.out.println("Enter birth date (YYYY-MM-DD): ");
        LocalDate birthDate = null;
        boolean isValidDate = false;

        while (!isValidDate) {
            String dateString = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
                isValidDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD:");
            }
        }

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.println("Enter address: ");
        String address = scanner.nextLine();

        User user = new User(nameTag, firstName, lastName, password, birthDate, email, phone, address);
        user.setCurrentPlan(freePlan);
        System.out.println("User created successfully!");

        //add user to hashmap, nameTag is the unique identifier
        usersMap.put(nameTag, user);

        audit.logAction("createUser: " + nameTag);
    }
    public User getUser(String username) {
        return usersMap.get(username);
    }


    public Card getCard(String IBAN) {
        return cardsMap.get(IBAN);
    }

    public void addCard(Card card){
        cardsMap.put(card.getIBAN(), card);
    }

    public void removeCard(String IBAN) {
        cardsMap.remove(IBAN);
    }



//    public void removeUser(String username) {
//        usersMap.remove(username);
//    }
    public int getMapLength() {
        return usersMap.size();
    }


    // types of plans: Free, Basic, Premium
    Plan freePlan = new Plan("Free", 0, 2, 2, 1, 1, 0, 2000, 10, 1000);
    Plan basicPlan = new Plan("Basic", 20, 1, 0.5, 0, 0, 0, 5000, 0, 3000);
    Plan premiumPlan = new Plan("Premium", 50, 0, 0, 0, 0, 0, 10000, 0, 10000);

}