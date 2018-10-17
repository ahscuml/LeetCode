package Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ahscuml
 * @date 2018/10/16
 * @time 10:19
 */
public class BankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE= 1000;
    public static final double MAX_AMOUNT= 1000;
    public static final int DELAY= 10;
    public static void main(String[] args) {

        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int formAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(formAccount,toAccount,amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                }catch (InterruptedException e) {
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
