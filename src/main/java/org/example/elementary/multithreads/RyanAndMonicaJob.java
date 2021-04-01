package org.example.elementary.multithreads;

/**
 * Created by ankouichi on 1/24/21
 */

public class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] agrs) {

    }

    private void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }

    class BankAccount {
        private int balance = 100;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }
    }
}
