package bai5;

import java.util.HashMap;
import java.util.Map;

public class HashMapLibrary implements LibraryManager {
    private final Map<String, Book> books = new HashMap<>();

    // O(1) trung binh
    @Override
    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) return false;
        books.put(book.getId(), book);
        return true;
    }

    // O(1) trung binh
    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    // O(1) trung binh
    @Override
    public boolean removeById(String id) {
        return books.remove(id) != null;
    }

    // O(n): thu tu in KHONG dam bao (HashMap khong co thu tu)
    @Override
    public void printAll() {
        for (Book b : books.values()) System.out.println("  " + b);
    }

    @Override
    public int size() { return books.size(); }
}