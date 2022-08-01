package deposites;

import deposites.Deposit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod){super(depositAmount, depositPeriod);}

    @Override
    public BigDecimal income(){
        BigDecimal result = super.getAmount();
        BigDecimal n = BigDecimal.valueOf(1.01);
        for(int i = 1; i < super.getPeriod()+1; i++){
            result = result.multiply(n);
            n = n.add(BigDecimal.valueOf(0.01));
        }
        result = result.subtract(amount);
        return result.setScale(2,RoundingMode.HALF_EVEN);
    }

    @Override
    public boolean canToProlong() {
        int result = super.getAmount().compareTo(BigDecimal.valueOf(1000));
        return result > 0;
    }

    @Override
    public int compareTo(Deposit deposit) {
        return getAmount().add(income()).compareTo(deposit.income().add(deposit.amount));
    }
}
