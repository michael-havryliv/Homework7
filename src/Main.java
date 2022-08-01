import deposites.BaseDeposit;
import deposites.LongDeposit;
import deposites.SpecialDeposit;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        BaseDeposit bd1 = new BaseDeposit(BigDecimal.valueOf(1000),5);
        BaseDeposit bd2 = new BaseDeposit(BigDecimal.valueOf(1000),4);
        SpecialDeposit sd1 = new SpecialDeposit(BigDecimal.valueOf(1001), 4);
        LongDeposit ld1 = new LongDeposit(BigDecimal.valueOf(100), 36);


        Client client = new Client();
        client.addDeposit(bd1);
        client.addDeposit(bd2);
        client.addDeposit(sd1);
        client.addDeposit(ld1);


    }
}
