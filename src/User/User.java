package User;
import Account.Plan;
import Account.Account;
import Account.Loan;
import Account.Card;
//users of the banking application
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class User {
    private String nameTag;
    private String firstName, lastName;
    private String password;
    private LocalDate birthDate;
    private String email, phone;
    private String address;
    private Plan currentPlan;
    private List<Transaction> transactions = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public User(String nameTag,String firstName, String lastName, String password, LocalDate birthDate, String email, String phone, String address) {
        this.nameTag = nameTag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address = address;

    }



//    getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNameTag() {
        return nameTag;
    }
    public String getPassword() {
        return password;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public Plan getCurrentPlan() {
        if (currentPlan == null){
            System.out.println("User does not have a plan");
        }
        return currentPlan;
    }

    public List<Card> getCards() {
        return cards;
    }

    //    setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }
    public void changePassword(String password) {
        this.password = password;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCurrentPlan(Plan plan) {
        this.currentPlan = plan;
    }

    public String toString() {
        return "Name: " + firstName + " "
                + lastName + " (" + nameTag + ")"
                + " Password: " + password
                + " Email: " + email
                + " Phone: " + phone
                + " Address: " + address;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    // create an account
    public void createAccount(String currency){
        // check if account with that currency already exists
        for (Account account: accounts){
            if (account.getCurrency().equals(currency)){
                System.out.println("Account with that currency already exists");
                return;
            }
        }
        Account account = new Account(nameTag, currency, 0, this);
        accounts.add(account);
    }

    public double getCurrencyBalance(String currency){
        for (Account account: accounts){
            if (account.getCurrency().equals(currency)){
                System.out.println("Balance: " + account.getBalance());
                return account.getBalance();
            }
        }
        System.out.println("Account with that currency does not exist");
        return -1;
    }
    public void getTotalBalance(){
        double totalBalance = 0;
        for (Account account: accounts){
            totalBalance += account.getBalance();
        }
        System.out.println("Total Balance: " + totalBalance);
    }


    public void showAccounts(){
        for (Account account: accounts){
            System.out.println(account);
        }
    }
    public Account getAccount(String currency){
        for (Account account: accounts){
            if (account.getCurrency().equals(currency)){
                return account;
            }
        }
        System.out.println("Account with that currency does not exist");
        return null;
    }
    public int numberOfAccounts(){
        return accounts.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
    public void showCards(){
        for (Card card: cards){
            System.out.println(card+"\n");
        }
    }


    public void addLoan(double amount, double monthlyPayment, double interestRate, int months, double totalAmount, double totalPayment){
        Loan loan = new Loan(amount, monthlyPayment, interestRate, months, totalAmount, totalPayment);
        loans.add(loan);
    }

    public void exchangeCurrency(String fromCurrency, String toCurrency, double amount){
        for (Account account: accounts){
            if (account.getCurrency().equals(fromCurrency)){
                account.withdrawBalance(amount);
            }
            if (account.getCurrency().equals(toCurrency)){
                account.addBalance(amount);
            }
        }
    }
}
