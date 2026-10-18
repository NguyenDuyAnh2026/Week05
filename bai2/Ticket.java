package bai2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

    private final int id;
    private final String content;
    private final LocalDateTime timestamp;
    private final Customer customer;   // khach gui yeu cau

    public Ticket(int id, String content, Customer customer) {
        this.id = id;
        this.content = content;
        this.customer = customer;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Customer getCustomer() { return customer; }

    @Override
    public String toString() {
        return "Ticket #" + id + " [" + timestamp.format(FMT) + "] "
                + customer.getName() + ": " + content;
    }
}