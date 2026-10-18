package bai4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Phan 1: chay voi du lieu cua de bai
        String text = "Hello world. This is a java program. Hello java, hello world.";

        WordCounter counter = new WordCounter();
        counter.analyze(text);
        counter.displayResult();
        System.out.println();
        counter.displayMostFrequent();

        // Phan 2: so sanh hieu nang ArrayList vs HashMap
        System.out.println("\n--- So sanh hieu nang ---");
        String big = generateText(100_000, 5_000);

        long t1 = System.currentTimeMillis();
        ListWordCounter listCounter = new ListWordCounter();
        listCounter.analyze(big);
        long t2 = System.currentTimeMillis();

        WordCounter mapCounter = new WordCounter();
        mapCounter.analyze(big);
        long t3 = System.currentTimeMillis();

        System.out.println("ArrayList: " + (t2 - t1) + " ms");
        System.out.println("HashMap:   " + (t3 - t2) + " ms");
    }

    // Sinh van ban gom totalWords tu, lay ngau nhien tu distinct tu khac nhau
    private static String generateText(int totalWords, int distinct) {
        Random rnd = new Random(42);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalWords; i++) {
            sb.append("word").append(rnd.nextInt(distinct)).append(' ');
        }
        return sb.toString();
    }
}