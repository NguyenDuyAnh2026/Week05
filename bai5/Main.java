package bai5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        runDemo("ArrayList", new ArrayListLibrary());
        runDemo("HashMap", new HashMapLibrary());
        runDemo("TreeMap", new TreeMapLibrary());

        benchmark();
    }

    // Chay cung mot kich ban cho moi cach luu tru
    private static void runDemo(String name, LibraryManager lib) {
        System.out.println("========== " + name + " ==========");

        // Them 6 cuon sach (them khong theo thu tu id de thay su khac biet khi in)
        lib.addBook(new Book("B005", "Clean Code", "Robert C. Martin", 2008));
        lib.addBook(new Book("B002", "Effective Java", "Joshua Bloch", 2018));
        lib.addBook(new Book("B004", "Introduction to Algorithms", "Cormen", 2009));
        lib.addBook(new Book("B001", "Head First Java", "Kathy Sierra", 2005));
        lib.addBook(new Book("B003", "Design Patterns", "Gang of Four", 1994));
        lib.addBook(new Book("B006", "Digital Design", "Morris Mano", 2012));

        // Thu them id bi trung
        boolean ok = lib.addBook(new Book("B002", "Sach trung id", "Unknown", 2000));
        System.out.println("Them sach trung id B002: " + (ok ? "thanh cong" : "that bai (id da ton tai)"));

        System.out.println("\nDanh sach ban dau (" + lib.size() + " sach):");
        lib.printAll();

        // Tim kiem
        System.out.println("\nTim B003: " + lib.findById("B003"));
        System.out.println("Tim B999: " + lib.findById("B999"));

        // Xoa
        System.out.println("\nXoa B004: " + (lib.removeById("B004") ? "thanh cong" : "that bai"));
        System.out.println("Xoa B999: " + (lib.removeById("B999") ? "thanh cong" : "that bai"));

        System.out.println("\nDanh sach sau khi xoa (" + lib.size() + " sach):");
        lib.printAll();
        System.out.println();
    }

    // So sanh hieu nang tim kiem voi so luong sach lon
    private static void benchmark() {
        System.out.println("========== SO SANH HIEU NANG TIM KIEM ==========");
        int n = 50_000;     // so sach
        int queries = 20_000; // so lan tim

        LibraryManager[] libs = {
                new ArrayListLibrary(), new HashMapLibrary(), new TreeMapLibrary()
        };
        String[] names = {"ArrayList", "HashMap", "TreeMap"};

        for (int k = 0; k < libs.length; k++) {
            LibraryManager lib = libs[k];

            // Them n sach. Voi ArrayList buoc nay cung la O(n^2) vi kiem tra trung id
            long a = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                String id = String.format("B%06d", i);
                lib.addBook(new Book(id, "Title " + i, "Author " + i, 2000 + i % 25));
            }
            long b = System.currentTimeMillis();

            // Tim ngau nhien (seed co dinh de 3 cach tim cung day id)
            Random rnd = new Random(1);
            int found = 0;
            for (int i = 0; i < queries; i++) {
                String id = String.format("B%06d", rnd.nextInt(n));
                if (lib.findById(id) != null) found++;
            }
            long c = System.currentTimeMillis();

            System.out.printf("%-10s them %d sach: %5d ms | tim %d lan: %5d ms (thay %d)%n",
                    names[k], n, (b - a), queries, (c - b), found);
        }
    }
}
