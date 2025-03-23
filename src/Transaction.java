import java.util.Date;

public class Transaction {
    private int id;
    private String description;
    private Date date;
    private double amount;
    private int senderId;
    private int receiverId;
    private TransactionStatus status;

    public Transaction(int id, String description, Date date, double amount, int senderId, int receiverId, TransactionStatus status) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Date getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public int getSenderId() {
        return senderId;
    }
    public int getReceiverId() {
        return receiverId;
    }
    public TransactionStatus getStatus() {
        return status;
    }
}
