package deposites;

import deposites.Deposit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {

    public LongDeposit(BigDecimal depositAmount, int depositPeriod){
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        if(super.getPeriod() > 6) {
            BigDecimal sum = super.getAmount().multiply(BigDecimal.valueOf(Math.pow(1.15,(double) super.getPeriod()-6)));
            BigDecimal result = sum.subtract(super.getAmount());
            return result.setScale(2, RoundingMode.HALF_EVEN);
        }else{
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public boolean canToProlong() {
        return super.getPeriod() < 36;
    }

    @Override
    public int compareTo(Deposit deposit) {
        return getAmount().add(income()).compareTo(deposit.income().add(deposit.amount));
    }
}
