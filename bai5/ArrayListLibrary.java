package bai5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLibrary implements LibraryManager {
    private final List<Book> books = new ArrayList<>();

    // O(n): phai duyet de kiem tra trung id, roi them cuoi
    @Override
    public boolean addBook(Book book) {
        if (findById(book.getId()) != null) return false;
        books.add(book);
        return true;
    }

    // O(n): duyet tuan tu
    @Override
    public Book findById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    // O(n): tim vi tri O(n) + don cac phan tu phia sau O(n)
    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    // O(n): theo thu tu them vao
    @Override
    public void printAll() {
        for (Book b : books) System.out.println("  " + b);
    }

    @Override
    public int size() { return books.size(); }
}