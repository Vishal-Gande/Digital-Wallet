import java.util.Date;

public class DemoWalletManager {


    public static void main(String[] args) {
        WalletManager wm = new WalletManager();

        User u1 = new User(1,"vish","vish@gmail","asdf",0);
        User u2 = new User(2,"prav","prav@gmail","asdf",0);
        User u3 = new User(3,"neet","neet@gmail","asdf",0);

        wm.addUser(u1);
        wm.addUser(u2);
        wm.addUser(u3);

        Transaction t1 = new Transaction(1, "Dinner bill split", new Date(), 1200.50, 1, 2, TransactionStatus.COMPLETED);
        Transaction t2 = new Transaction(2, "Movie tickets", new Date(), 800.00, 1, 2, TransactionStatus.PROGRESS);
        Transaction t3 = new Transaction(3, "Rent payment", new Date(), 15000.00, 2, 3, TransactionStatus.COMPLETED);
        Transaction t4 = new Transaction(4, "Electricity bill", new Date(), 2300.75, 3, 1, TransactionStatus.FAILED);
        Transaction t5 = new Transaction(5, "Grocery payment", new Date(), 3200.00, 2, 1, TransactionStatus.COMPLETED);

        wm.addTransaction(t1);
        wm.addTransaction(t2);
        wm.addTransaction(t3);
        wm.addTransaction(t4);
        wm.addTransaction(t5);

        u1.displayTransactions();
        u2.displayTransactions();
        u3.displayTransactions();

        u1.displayCurrentBalance();
        u2.displayCurrentBalance();

    }
}
