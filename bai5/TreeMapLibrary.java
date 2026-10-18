package bai5;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapLibrary implements LibraryManager {
    // TreeMap (cay do-den) luon giu key theo thu tu tang dan
    private final Map<String, Book> books = new TreeMap<>();

    // O(log n)
    @Override
    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) return false;
        books.put(book.getId(), book);
        return true;
    }

    // O(log n)
    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    // O(log n)
    @Override
    public boolean removeById(String id) {
        return books.remove(id) != null;
    }

    // O(n): in theo thu tu id tang dan
    @Override
    public void printAll() {
        for (Book b : books.values()) System.out.println("  " + b);
    }

    @Override
    public int size() { return books.size(); }
}