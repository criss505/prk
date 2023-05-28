import User.User;
import Account.Plan;
import User.Transaction;
import java.time.LocalDateTime;
import Account.Loan;
import Account.Card;
import Account.DebitCard;
import Account.OneTimeCard;
import Account.VirtualCard;
import java.io.IOException;

import java.util.Scanner;
public class ServiceUser {
    // what a user can do

    User userCurent;
    static Main main = new Main();
    Audit audit = new Audit();

    public static void main(String[] args) throws IOException {
        ServiceUser service = new ServiceUser();
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println("Starting e-bank...");
        while (true) {
            if(service.userCurent == null) {
                System.out.println("Please login or register");
                System.out.println("1. Login");
                System.out.println("2. Register");

                answer = scanner.nextLine();
                if (answer.equals("1")) {
                    service.login();
                    System.out.println("Welcome back, " + service.userCurent.getNameTag());
                    service.showMenu();
                }
                else if (answer.equals("2"))
                    main.createUser();
                else {
                    System.out.println("Invalid input");
//                    continue;
                }

            }
            else{

                System.out.println("Welcome back, " + service.userCurent.getNameTag());
                service.showMenu();
            }

        }

    }



    public void login(){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your nameTag");
            String nameTag0 = scanner.nextLine();

            userCurent = main.getUser(nameTag0);
            if (userCurent == null){
                System.out.println("NameTag does not exist");
            }
            else{
                System.out.println("Please enter your password");
                String password0 = scanner.nextLine();
                userCurent = main.getUser(nameTag0);

                if (password0.equals(userCurent.getPassword())) {
                    System.out.println("Succesfully logged in, " + userCurent.getFirstName());
                }
                else {
                    System.out.println("Wrong nameTag or password");
                }
            }
            audit.logAction("User "+userCurent.getNameTag()+": logged in");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void logout() throws IOException {
        audit.logAction("User "+userCurent.getNameTag()+": logged out");
        userCurent = null;
    }

    public void currentPlan(){
        System.out.println(userCurent.getCurrentPlan());
        if (userCurent.getCurrentPlan().equals(main.freePlan)){
            System.out.println("\nYou can upgrade to our other plans!");
            System.out.println("Basic Plan: " + main.basicPlan.getMonthlyFee() + " USD per month");
            System.out.println("Premium Plan: " + main.premiumPlan.getMonthlyFee() + " USD per month");
        }
        else if (userCurent.getCurrentPlan().equals(main.basicPlan)){
            System.out.println("You can upgrade to premium plan with only " + main.premiumPlan.getMonthlyFee() + " USD");
        }
        else{
            System.out.println("You can't upgrade your plan, you are using the premium plan");
        }
    }

    public void userDetails(){
        System.out.println("Showing user details...");
        System.out.println("NameTag: " + userCurent.getNameTag());
        System.out.println("Name: " + userCurent.getFirstName() + " " + userCurent.getLastName());
        System.out.println("Birth date: " + userCurent.getBirthDate());
        System.out.println("Email: " + userCurent.getEmail());
        System.out.println("Phone: " + userCurent.getPhone());
        System.out.println("Address: " + userCurent.getAddress());
        System.out.print("Password: ");
        for (int i = 0; i < userCurent.getPassword().length() - 2; i++){
            System.out.print("*");
        }
        System.out.print(userCurent.getPassword().substring(userCurent.getPassword().length() - 2));
        System.out.println("\n");
    }

    public void viewAccounts(){
        System.out.println("Showing accounts...");
        userCurent.showAccounts();
        if (userCurent.numberOfAccounts() == 0){
            System.out.println("You don't have any accounts");
        }
    }

    public void viewTransactions(){
        System.out.println("Showing the last 10 transactions...");
        int nrTransactions = Math.min(10, userCurent.getTransactions().size());
        for (int i = userCurent.getTransactions().size() - 1; i >= userCurent.getTransactions().size() - nrTransactions; i--){
            System.out.println(userCurent.getTransactions().get(i)+"\n\n");
        }
        if (userCurent.getTransactions().size() == 0){
            System.out.println("You haven't made any transactions yet");
        }

    }

    public void viewCards(){
        System.out.println("Showing cards...");
        userCurent.showCards();
        if (userCurent.getCards().size() == 0){
            System.out.println("You don't have any cards");
        }
    }

    public void viewLoans(){
        System.out.println("Showing loans...");
        for (Loan loan : userCurent.getLoans()){
            System.out.println(loan+"\n");
        }
        if (userCurent.getLoans().size() == 0){
            System.out.println("You don't have any loans");
        }
    }

    public void createCard() throws IOException {
        System.out.println("Creating card...");
        System.out.println("What type of card do you want to create?");
        System.out.println("1. Simple - normal debit card");
        System.out.println("2. Virtual - can be used only for online transactions");
        System.out.println("3. Safety - can be used only once and will be destroyed after the first transaction; recommended for untrustworthy sites");
        Scanner scanner = new Scanner(System.in);
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter PIN: ");
        int pin = Integer.parseInt(scanner.nextLine());

        if (type == 1){
            DebitCard card = new DebitCard(userCurent, pin);
            userCurent.addCard(card);
            main.addCard(card);
            System.out.println("Card created successfully! It will be sent to your address in 3-5 business days");
        }
        else if (type == 2){
            VirtualCard card = new VirtualCard(userCurent, pin);
            userCurent.addCard(card);
            main.addCard(card);
            System.out.println("Card created successfully! You can start using it for online shopping");
        }
        else if (type == 3){
            OneTimeCard card = new OneTimeCard(userCurent, pin);
            userCurent.addCard(card);
            main.addCard(card);
            System.out.println("Card created successfully! You can already use it for an online transaction");
        }
        else{
            System.out.println("Invalid card type");
            return;
        }
        audit.logAction("User "+userCurent.getNameTag()+": created a card");
        System.out.println("Current number of cards: " + userCurent.getCards().size());

    }

    public void createAccount() throws IOException {
        System.out.println("Please enter the currency you want to use");
        Scanner scanner = new Scanner(System.in);
        String currency = scanner.nextLine();
        userCurent.createAccount(currency);
        System.out.println("How much money do you want to deposit?");
        double amount = Double.parseDouble(scanner.nextLine());
        userCurent.getAccount(currency).addBalance(amount);
        System.out.println("Account created successfully");

        audit.logAction("User "+userCurent.getNameTag()+": created an account");
    }


    public void createLoan() throws IOException {
            System.out.println("Creating loan...");
            System.out.println("Enter currency: ");
            Scanner scanner = new Scanner(System.in);
            String currency = scanner.nextLine();


            if (userCurent.getAccount(currency) == null) {
                System.out.println("You don't have an account with this currency. Creating one...");
                userCurent.createAccount(currency);
            }

            // get user's current plan maximum balance
            double maxBalance = userCurent.getCurrentPlan().getMaxBalance();


            System.out.println("Enter loan amount: ");
            double loanAmount = Double.parseDouble(scanner.nextLine());

            // check if loan amount is valid
            if (loanAmount > maxBalance) {
                System.out.println("Loan amount exceeds maximum balance. Please try again.");
                return;
            }

            System.out.println("Enter loan term (months): ");
            int loanTerm = Integer.parseInt(scanner.nextLine());


            Plan loanPlan = userCurent.getCurrentPlan();
            double loanInterestRate = loanPlan.getInterestRate();
            Double monthlyPayment = loanAmount * (loanInterestRate / 100) / (1 - Math.pow(1 + loanInterestRate / 100, -loanTerm));

            userCurent.addLoan(loanAmount, monthlyPayment, loanInterestRate, loanTerm, loanAmount, 0);
            userCurent.getAccount(currency).addBalance(loanAmount);
            System.out.println("Loan created successfully!");
            audit.logAction("User "+userCurent.getNameTag()+": created a loan");
        }


    public void createTransaction() throws IOException {
        System.out.println("Please enter the name of the user you want to send money to");
        Scanner scanner = new Scanner(System.in);
        String nameTag = scanner.nextLine();
        User user0 = main.getUser(nameTag);
        if (user0 == null){
            System.out.println("User not found");
            return;
        }
        System.out.println("Please enter the currency you want to use");
        String currency = scanner.nextLine();
        if (userCurent.getAccount(currency) == null){
            System.out.println("You don't have an account with this currency");
            return;
        }

        System.out.println("Please enter the amount you want to send (or -1 for canceling the transaction)");
        double amount = 0;
        boolean valid_amount = false;
        while (!valid_amount){
            amount = Double.parseDouble(scanner.nextLine());
            if (amount == -1)
                return;
            else if (amount < 0)
                System.out.println("Invalid amount");
            else if (userCurent.getCurrencyBalance(currency) < amount + userCurent.getCurrentPlan().getTransferFee())
                System.out.println("Insufficient funds, enter another value");
            else
                valid_amount = true;
        }
        System.out.println("Please enter the subject of the transaction");
        scanner.nextLine();
        String subject = scanner.nextLine();
        LocalDateTime time = LocalDateTime.now();


        userCurent.getAccount(currency).withdrawBalance(amount + userCurent.getCurrentPlan().getTransferFee());
        // if user doesn't have an account with the currency of the transaction, create one
        if (user0.getAccount(currency) == null)
            user0.createAccount(currency);
        user0.getAccount(currency).addBalance(amount);
        Transaction transaction = new Transaction(userCurent, user0, currency, amount, subject, time);
        userCurent.addTransaction(transaction);
        user0.addTransaction(transaction);
        System.out.println("Transaction completed successfully");

        audit.logAction("New transaction: "+userCurent.getNameTag()+" -> "+user0.getNameTag());
    }


    public void changePassword(){
        System.out.println("Please enter your current password");
        Scanner scanner = new Scanner(System.in);
        String password0 = scanner.nextLine();
        if (password0.equals(userCurent.getPassword())) {
            System.out.println("Please enter your new password");
            String password1 = scanner.nextLine();
            userCurent.changePassword(password1);
            System.out.println("Password changed successfully");
        }
        else{
            System.out.println("Wrong password");
        }
    }

    public void changePlan() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the plan you want to use: free/basic/premium");
        String planName = scanner.nextLine();
        Plan currentPlan = userCurent.getCurrentPlan();
        if (currentPlan.getName().equals(planName)){
            System.out.println("You are already using this plan");
            return;
        }
        else
        if (planName.equals("free")){
            userCurent.setCurrentPlan(main.freePlan);
        }
        else if (planName.equals("basic")){
            double cost = main.basicPlan.getMonthlyFee();
            if (userCurent.getAccount("usd").getBalance() < cost){
                System.out.println("Insufficient funds");
            }
            else{
                userCurent.getAccount("usd").withdrawBalance(cost);
                userCurent.setCurrentPlan(main.basicPlan);
            }
        }
        else if (planName.equals("premium")){
            double cost = main.premiumPlan.getMonthlyFee();
            if (userCurent.getAccount("usd").getBalance() < cost){
                System.out.println("Insufficient funds");
            }
            else{
                userCurent.getAccount("usd").withdrawBalance(cost);
                userCurent.setCurrentPlan(main.premiumPlan);
            }
        }
        else{
            System.out.println("Invalid plan name");
            return;
        }
        System.out.println("Plan changed successfully");
        audit.logAction("User "+userCurent.getNameTag()+": changed plan to "+planName);
    }
    public void exchangeCurrency() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String currency0 = "", currency1 = "";
        boolean currency0_valid = false;
        boolean currency1_valid = false;
        System.out.println("Please enter the currency you want to exchange from");
        // check if currency0 is valid
        while (!currency0_valid){
            currency0 = scanner.nextLine();
            if (userCurent.getCurrencyBalance(currency0) == -1)
                System.out.println("Invalid currency");
            else
                currency0_valid = true;
        }

        System.out.println("Please enter the currency you want to exchange to");
        // check if currency1 is valid
        while (!currency1_valid){
            currency1 = scanner.nextLine();
            if (userCurent.getCurrencyBalance(currency1) == -1)
                System.out.println("Invalid currency");
            else
                currency1_valid = true;
        }

        System.out.println("Please enter the amount you want to exchange (or -1 for canceling the exchange)");
        double amount = 0;
        boolean valid_amount = false;
        while (!valid_amount){
            amount = Double.parseDouble(scanner.nextLine());
            if (amount == -1)
                return;
            else if (amount < 0)
                System.out.println("Invalid amount");
            else if (userCurent.getCurrencyBalance(currency0) < amount)
                System.out.println("Insufficient funds, taste another value");
            else
                valid_amount = true;
        }
        userCurent.exchangeCurrency(currency0, currency1, amount);
        audit.logAction("User "+userCurent.getNameTag()+": exchanged" + currency0 + " to " + currency1);
    }

    public void removeCard(Card card){
        main.removeCard(card.getIBAN());
        userCurent.removeCard(card);
    }


    public void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Please choose an option");
            System.out.println("1. View account balance");
            System.out.println("2. View transactions");
            System.out.println("3. View loans");
            System.out.println("4. View current plan");
            System.out.println("5. View account details");
            System.out.println("6. View user details");
            System.out.println("7. Create a new account");
            System.out.println("8. Create a new loan");
            System.out.println("9. Change current plan");
            System.out.println("10. Change password");
            System.out.println("11. Create a transaction");
            System.out.println("12. Exchange currency");
            System.out.println("13. Create a card");
            System.out.println("14. View cards");
            System.out.println("15. Make a payment");
            System.out.println("16. Logout");
            System.out.println("17. Exit");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    System.out.println("View account balance");
                    userCurent.getTotalBalance();
                    break;
                case 2:
                    System.out.println("View transactions");
                    viewTransactions();
                    break;
                case 3:
                    System.out.println("View loans");
                    viewLoans();
                    break;
                case 4:
                    System.out.println("View current plan");
                    currentPlan();
                    break;
                case 5:
                    System.out.println("View current accounts");
                    viewAccounts();
                    break;
                case 6:
                    System.out.println("View user details");
                    userDetails();
                    break;
                case 7:
                    System.out.println("Create a new account");
                    createAccount();
                    break;
                case 8:
                    System.out.println("Create a new loan");
                    createLoan();
                    break;
                case 9:
                    System.out.println("Change current plan");
                    changePlan();
                    break;
                case 10:
                    System.out.println("Change password");
                    changePassword();
                    break;
                case 11:
                    System.out.println("Create a transaction");
                    createTransaction();
                    break;
                case 12:
                    System.out.println("Exchange currency");
                    exchangeCurrency();
                    break;
                case 13:
                    System.out.println("Create a new card");
                    createCard();
                    break;
                case 14:
                    System.out.println("View existing cards");
                    viewCards();
                    break;
                case 15:
                    System.out.println("Make a payment");
                    POS pos = new POS();
                    pos.makePayment();
                    break;
                case 16:
                    System.out.println("Logout");
                    logout();
                    shouldContinue = false;
                    break;
                case 17:
                    System.out.println("Exit");
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            // next command
            if (shouldContinue) {
                System.out.println("Press enter to continue...");
                scanner.nextLine();
            }
        }
    }


}
