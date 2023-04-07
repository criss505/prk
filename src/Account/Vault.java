package Account;

public class Vault {
    public String nameTag;
    public String name;
    public String currency;
    public double balance;
    public double interestRate;

    public Vault(String nameTag, String name, String currency, double balance, double interestRate) {
        this.nameTag = nameTag;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getNameTag() {
        return nameTag;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addBalance(double amount){
        this.balance += amount;
    }


}
