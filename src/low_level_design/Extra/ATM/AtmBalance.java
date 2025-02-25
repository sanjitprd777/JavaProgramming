package ATM;

public class AtmBalance {
    int totalAmount;
    int hundreds;
    int fiveHundreds;
    int twoThousands;

    public AtmBalance(int hundreds, int fiveHundreds, int twoThousands) {
        this.hundreds = hundreds;
        this.fiveHundreds = fiveHundreds;
        this.twoThousands = twoThousands;
        this.totalAmount = calculateTotal();
    }

    int calculateTotal() {
        return (hundreds*100 + fiveHundreds*500 + twoThousands*2000);
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public int getFiveHundreds() {
        return fiveHundreds;
    }

    public void setFiveHundreds(int fiveHundreds) {
        this.fiveHundreds = fiveHundreds;
    }

    public int getTwoThousands() {
        return twoThousands;
    }

    public void setTwoThousands(int twoThousands) {
        this.twoThousands = twoThousands;
    }

    public void updateATMBalance(int hundreds, int fiveHundreds, int twoThousands) {
        this.hundreds = this.hundreds - hundreds;
        this.fiveHundreds = this.fiveHundreds - fiveHundreds;
        this.twoThousands = this.twoThousands - twoThousands;
        this.totalAmount = calculateTotal();
    }
}
