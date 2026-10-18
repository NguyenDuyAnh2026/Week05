package bai2;

public class Main {
    public static void main(String[] args) {
        CustomerQueue queue = new CustomerQueue();
        SupportAgent agent = new SupportAgent("Nhân viên Lan", queue);

        // 1. Khách A đến, khách B đến
        Customer a = new Customer(1, "Khách A");
        Customer b = new Customer(2, "Khách B");
        queue.addTicket(new Ticket(101, "Đơn hàng chưa giao", a));
        queue.addTicket(new Ticket(102, "Muốn đổi trả sản phẩm", b));

        // 2. Xử lý A: gõ 3 dòng, undo 1 dòng
        Ticket ticketA = agent.takeNextCustomer();
        if (ticketA != null) {
            MessageHistory historyA = agent.newConversation();
            historyA.type("Chào bạn, shop xin lỗi vì sự bất tiện.");
            historyA.type("Shop sẽ kiểm tra đơn hàng giúp bạn ngay.");
            historyA.type("Đơn của bạn sẽ giao trong 2 ngày nhé!!");  // gõ sai
            historyA.viewLast();    // xem lại câu vừa gõ
            historyA.undo();        // xóa câu gõ sai
            historyA.viewLast();    // giờ câu gần nhất là câu thứ 2
            historyA.printAll();
        }

        // 3. Xử lý B
        Ticket ticketB = agent.takeNextCustomer();
        if (ticketB != null) {
            MessageHistory historyB = agent.newConversation();
            historyB.type("Chào bạn, bạn vui lòng gửi ảnh sản phẩm giúp shop.");
            historyB.viewLast();
            historyB.printAll();
        }

        // 4. Bấm xử lý khi hàng đợi đã rỗng
        agent.takeNextCustomer();
    }
}