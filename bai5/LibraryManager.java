package bai5;

public interface LibraryManager {
    boolean addBook(Book book);      // false neu id bi trung
    Book findById(String id);        // null neu khong thay
    boolean removeById(String id);   // false neu khong co id
    void printAll();
    int size();
}