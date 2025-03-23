import java.util.ArrayList;
import java.util.HashMap;

public class WalletManager {

    public static WalletManager instance = null;
    private HashMap<Integer,User> users;
    private HashMap<Integer,Transaction> transactions;



    public WalletManager() {
        users = new HashMap<>();
        transactions = new HashMap<>();
    }

    // making this class singleton

    public static WalletManager getInstance() {
        if (instance == null) {
            synchronized(WalletManager.class){
                if(instance == null) {
                    instance = new WalletManager();
                    return instance;
                }
            }
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addTransaction(Transaction transaction) {

        //checks if sender has enough bal
        if(checkSenderBalance(transaction)) {
            transactions.put(transaction.getId(), transaction);

            //adding transaction to user's transaction list
            users.get(transaction.getSenderId()).addTransaction(transaction);
            users.get(transaction.getReceiverId()).addTransaction(transaction);
        }
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

    private boolean checkSenderBalance(Transaction transaction) {

        //check sender has enough balance to do payment
        if( users.get(transaction.getSenderId()).getCurrentBalance() >= transaction.getAmount() )  return true;

        else
        {
            System.out.println("Sender doesn't have enough balance. Transaction cannot be processed! ");
            return false;
        }
    }
}
