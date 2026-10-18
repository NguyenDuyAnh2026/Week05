package bai2;

import java.util.Stack;

public class MessageHistory {
    private final Stack<Message> stack = new Stack<>();
    private int nextId = 1;

    public void type(String content) {
        Message m = new Message(nextId++, content);
        stack.push(m);
        System.out.println("[History] Đã gõ: " + m.getContent());
    }

    public void undo() {
        if (stack.isEmpty()) {
            System.out.println("[History] Không có gì để undo");
            return;
        }
        Message removed = stack.pop();
        System.out.println("[History] Undo, đã xóa: " + removed.getContent());
    }


    public void viewLast() {
        if (stack.isEmpty()) {
            System.out.println("[History] Chưa có tin nhắn nào");
            return;
        }
        System.out.println("[History] Câu gần nhất: " + stack.peek().getContent());
    }


    public void printAll() {
        System.out.println("[History] Nội dung gửi đi (" + stack.size() + " câu):");
        for (Message m : stack) {   // Stack duyệt từ đáy lên đỉnh
            System.out.println("   " + m.getId() + ". " + m.getContent());
        }
    }

    public boolean isEmpty() { return stack.isEmpty(); }
}