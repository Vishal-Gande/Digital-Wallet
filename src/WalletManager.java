import java.util.ArrayList;
import java.util.HashMap;

public class WalletManager {

    private HashMap<Integer,User> users;
    private HashMap<Integer,Transaction> transactions;


    public WalletManager() {
        users = new HashMap<>();
        transactions = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addTransaction(Transaction transaction) {
        transactions.put(transaction.getId(), transaction);

        //adding transaction to user's transaction list
        users.get(transaction.getSenderId()).addTransaction(transaction);
        users.get(transaction.getReceiverId()).addTransaction(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction.getId());

        //removing transaction
        users.get(transaction.getSenderId()).removeTransaction(transaction);
        users.get(transaction.getReceiverId()).removeTransaction(transaction);
    }

    public void topUpWallet(User user, double amount) {
        user.addAmount(amount);
    }


}
