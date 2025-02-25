package ATM;

public class Card {

    String cardNumber;
    int cvv;
    String expDate;
    BankAccount bankAccount;
    String cardType;
    int pinNumber;

    public Card(String cardNumber, int cvv, String expDate, BankAccount bankAccount, String cardType, int pinNumber) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expDate = expDate;
        this.bankAccount = bankAccount;
        this.cardType = cardType;
        this.pinNumber = pinNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
