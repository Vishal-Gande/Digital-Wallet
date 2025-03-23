import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private double currentBalance;
    private ArrayList<Transaction> transactions;

    public User(int id, String name, String email, String password, double currentBalance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.currentBalance = currentBalance;
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }

    public void addAmount(double topUp) {
        currentBalance += topUp;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.updateBalance(transaction);

    }
    private void updateBalance(Transaction transaction) {
        if(transaction.getSenderId() == this.id) this.currentBalance += transaction.getAmount();
        else this.currentBalance -= transaction.getAmount();
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        this.rollBackBalance(transaction);
    }

    private void rollBackBalance(Transaction transaction) {
        if(transaction.getSenderId() == this.id) this.currentBalance -= transaction.getAmount();
        else this.currentBalance += transaction.getAmount();
    }

    public void displayTransactions() {
        System.out.println(name +"'s Transactions: ");
        for(Transaction transaction : transactions) {
            System.out.println(" -  Date: " + transaction.getDate() +"- Sender: " + transaction.getSenderId() +
                    " Amount: " + transaction.getAmount() + " to receiver: " + transaction.getReceiverId() + " for " + transaction.getDescription());
        }
    }

    public void displayCurrentBalance() {
        System.out.println("Current Balance of " + this.name + " : " + this.currentBalance);
    }
}
