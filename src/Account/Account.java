package Account;
import User.User;

public class Account {
    private String nameTag;
    private String currency;
    private double balance;
    private Plan plan;
    private User user;

    public Account(String nameTag, String currency, double balance, Plan plan, User user) {
        this.nameTag = nameTag;
        this.currency = currency;
        this.balance = balance;
        this.plan = plan;
        this.user = user;
    }

    public String getNameTag() {
        return nameTag;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public Plan getPlan() {
        return plan;
    }

    public User getUser() {
        return user;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addBalance(double amount){
        this.balance += amount;
    }

    public void withdrawBalance(double amount){
        this.balance -= amount;
    }

    public void changePlan(Plan plan){
        this.plan = plan;
    }

    public void changeCurrency(String currency){
        this.currency = currency;
    }

    public void changeNameTag(String nameTag){
        this.nameTag = nameTag;
    }

    public void changeUser(User user){
        this.user = user;
    }

    public void printAccount(){
        System.out.println("Account name: " + this.nameTag);
        System.out.println("Account currency: " + this.currency);
        System.out.println("Account balance: " + this.balance);
        System.out.println("Account plan: " + this.plan.getName());
        System.out.println("Account user: " + this.user.getNameTag());
    }
}
