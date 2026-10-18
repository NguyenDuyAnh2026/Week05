package bai3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = """
            "Java is a high-level, class-based, object-oriented programming language."
            It is designed to have as few implementation dependencies as possible.
            It is a general-purpose programming language intended to let programmers
            write once, run anywhere, meaning that compiled Java code can run on all
            platforms that support Java without the need to recompile. Java applications
            are typically compiled to bytecode that can run on any Java virtual machine
            (JVM), regardless of the underlying computer architecture. The syntax of Java
            is similar to C and C++, but it has fewer low-level facilities than either of
            them. Programmers love Java because it's simple, portable, and secure; don't
            you think so? In the OOP course, students learn classes, objects, inheritance,
            and polymorphism. "Practice makes perfect," they say, and the best way to
            learn is to write code every day!
            """;

        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.count(text);

        System.out.println("Tong so tu: " + counter.totalWords());
        System.out.println("So tu khac nhau: " + counter.distinctWords());
        System.out.println();

        // Tu xuat hien nhieu nhat
        List<String> top = counter.mostFrequentWords();
        System.out.println("Tu xuat hien nhieu nhat (" + counter.maxCount() + " lan): " + top);
        System.out.println();

        counter.printTop(5);
        System.out.println();

        // Tu chi xuat hien 1 lan
        List<String> unique = counter.uniqueWords();
        System.out.println("Cac tu chi xuat hien dung 1 lan (" + unique.size() + " tu):");
        System.out.println(unique);
    }
}