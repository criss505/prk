package Account;

import java.util.Date;
import java.text.DateFormat;

public class Card {
    private String nameTag;
    private String IBAN, CVV, PIN;
    private Date expiryDate;
    private String currency;
    private double balance;
    private double interestRate;
    private double withdrawalFee, depositFee, transferFee;
    private double minBalance, maxBalance;
    private double minWithdrawal, maxWithdrawal;

    public Card(String nameTag, String IBAN, String CVV, String PIN, Date expiryDate, String currency, double balance, double interestRate, double withdrawalFee, double depositFee, double transferFee, double minBalance, double maxBalance, double minWithdrawal, double maxWithdrawal) {
        this.nameTag = nameTag;
        this.IBAN = IBAN;
        this.CVV = CVV;
        this.PIN = PIN;
        this.expiryDate = expiryDate;
        this.currency = currency;
        this.balance = balance;
        this.interestRate = interestRate;
        this.withdrawalFee = withdrawalFee;
        this.depositFee = depositFee;
        this.transferFee = transferFee;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.minWithdrawal = minWithdrawal;
        this.maxWithdrawal = maxWithdrawal;
    }


//    getters
    public String getNameTag() {
        return nameTag;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getCVV() {
        return CVV;
    }

    public String getPIN() {
        return PIN;
    }

    public Date getExpiryDate() {
        return expiryDate;
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

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public double getDepositFee() {
        return depositFee;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public double getMinWithdrawal() {
        return minWithdrawal;
    }

    public double getMaxWithdrawal() {
        return maxWithdrawal;
    }

//    setters

        public void setNameTag(String nameTag) {
            this.nameTag = nameTag;
        }

        public void setIBAN(String IBAN) {
            this.IBAN = IBAN;
        }

        public void setCVV(String CVV) {
            this.CVV = CVV;
        }

        public void setPIN(String PIN) {
            this.PIN = PIN;
        }

        public void setExpiryDate(Date expiryDate) {
            this.expiryDate = expiryDate;
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

        public void setWithdrawalFee(double withdrawalFee) {
            this.withdrawalFee = withdrawalFee;
        }

        public void setDepositFee(double depositFee) {
            this.depositFee = depositFee;
        }

        public void setTransferFee(double transferFee) {
            this.transferFee = transferFee;
        }

        public void setMinBalance(double minBalance) {
            this.minBalance = minBalance;
        }

        public void setMaxBalance(double maxBalance) {
            this.maxBalance = maxBalance;
        }

        public void setMinWithdrawal(double minWithdrawal) {
            this.minWithdrawal = minWithdrawal;
        }

        public void setMaxWithdrawal(double maxWithdrawal) {
            this.maxWithdrawal = maxWithdrawal;
        }

        public String toString() {
            return "Card [nameTag=" + nameTag + ", IBAN=" + IBAN + ", CVV=" + CVV + ", PIN=" + PIN + ", expiryDate=" + expiryDate + ", currency=" + currency + ", balance=" + balance + ", interestRate=" + interestRate + ", withdrawalFee=" + withdrawalFee + ", depositFee=" + depositFee + ", transferFee=" + transferFee + ", minBalance=" + minBalance + ", maxBalance=" + maxBalance + ", minWithdrawal=" + minWithdrawal + ", maxWithdrawal=" + maxWithdrawal + "]";
        }

}
