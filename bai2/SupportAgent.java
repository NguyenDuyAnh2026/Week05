package bai2;

public class SupportAgent {
    private final String name;
    private final CustomerQueue customerQueue;

    public SupportAgent(String name, CustomerQueue customerQueue) {
        this.name = name;
        this.customerQueue = customerQueue;
    }


    public Ticket takeNextCustomer() {
        System.out.println("\n===== " + name + " bấm XỬ LÝ =====");
        return customerQueue.processNext();
    }

    // Mỗi khách có một MessageHistory riêng
    public MessageHistory newConversation() {
        return new MessageHistory();
    }
}