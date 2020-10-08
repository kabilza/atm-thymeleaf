package th.ac.ku.atm.model;

public class Money {
    private double money;

    public Money(double money) {
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}