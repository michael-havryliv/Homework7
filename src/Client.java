import deposites.Deposit;
import deposites.LongDeposit;
import deposites.Prolongable;
import deposites.SpecialDeposit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Client implements Iterable<Deposit>{
    private Deposit[] deposits;

    public Client(){
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit){
        int pos = -1;
        for(int i = 0; i < 10; i++){
            if(deposits[i] == null){
                pos = i;
                break;
            }
        }
        if(pos != -1){
            deposits[pos] = deposit;
           return true;
        }else return false;
    }

    public BigDecimal totalIncome(){
        BigDecimal result = BigDecimal.valueOf(0);
        for (Deposit deposit : deposits) {
            if(deposit == null) break;
            result = result.add(deposit.income());
        }
        return result.setScale(2,RoundingMode.HALF_EVEN);
    }

    public BigDecimal maxIncome(){
        BigDecimal result = BigDecimal.valueOf(0);
        for(int i = 0; i < deposits.length; i++){
            if(deposits[i] == null) break;
            if(deposits[i].income().intValue() > result.intValue()){
                result = deposits[i].income();
            }
        }
        return result;
    }

    public BigDecimal getIncomeByNumber(int number){
        if(deposits[number] == null){
            return BigDecimal.valueOf(0);
        }else{
            return deposits[number].income();
        }
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new DepositIterator();
    }
    public class DepositIterator implements Iterator<Deposit>{
        int indexPosition = 0;

        @Override
        public boolean hasNext() {
            return deposits.length >= indexPosition + 1;
        }

        @Override
        public Deposit next() {
            if(indexPosition >= deposits.length){
                throw new NoSuchElementException();
            }
            Deposit val = deposits[indexPosition];
            indexPosition++;
            return val;
        }
    }

    public void sortDeposits(){
        Arrays.sort(deposits, Comparator.nullsFirst(Comparator.reverseOrder()));
    }

    public int countPossibleToProlongDeposit(){
        int count = 0;
        for (Deposit deposit : deposits){
            if (!(deposit instanceof LongDeposit) && !(deposit instanceof SpecialDeposit)) {
                continue;
            }
            if(((Prolongable) deposit).canToProlong()){
                count++;
            }
        }
        return count;
    }

}
