package deposites;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal income = new BigDecimal(0);
        BigDecimal amount = getAmount();

        for(int i = 0; i < period; i++){
            income = income.add(amount.multiply(BigDecimal.valueOf(0.05)));
            amount = getAmount();
            amount = amount.add(income);
        }
        return income.setScale(2, RoundingMode.HALF_EVEN);
    }


    @Override
    public int compareTo(Deposit deposit) {
        return getAmount().add(income()).compareTo(deposit.income().add(deposit.amount));
    }
}
