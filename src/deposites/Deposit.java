package deposites;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit>{
    public final BigDecimal amount;
    public final int period;


    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public Deposit(BigDecimal depositAmount, int depositPeriod) {
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public abstract BigDecimal income();
}
