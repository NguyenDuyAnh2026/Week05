package bai2;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private final Queue<Ticket> queue = new LinkedList<>();


    public void addTicket(Ticket ticket) {
        queue.offer(ticket);
        System.out.println("[Queue] Đã nhận: " + ticket);
    }


    public Ticket processNext() {
        Ticket ticket = queue.poll();
        if (ticket == null) {
            System.out.println("[Queue] Không còn khách đợi");
        } else {
            System.out.println("[Queue] Bắt đầu xử lý: " + ticket);
        }
        return ticket;
    }

    public int size() { return queue.size(); }
    public boolean isEmpty() { return queue.isEmpty(); }
}