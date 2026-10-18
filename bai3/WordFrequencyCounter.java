package bai3;

import java.util.*;

public class WordFrequencyCounter {
    private final Map<String, Integer> freq = new HashMap<>();

    // 1. Chuan hoa: chu thuong, bo dau cau
    public static String normalize(String text) {
        String lower = text.toLowerCase();
        lower = lower.replaceAll("[^a-z0-9'\\s]", " ");
        lower = lower.replaceAll("(^|\\s)'+|'+(?=\\s|$)", " ");
        return lower;
    }

    // 2. Dem tu bang HashMap
    public void count(String text) {
        freq.clear();
        String normalized = normalize(text);
        String[] words = normalized.trim().split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (!freq.containsKey(word)) {
                freq.put(word, 1);                  // chua co -> put(word, 1)
            } else {
                freq.put(word, freq.get(word) + 1); // da co -> cong them 1
            }
        }
    }

    // 3a. Tu xuat hien nhieu nhat (neu hoa thi tra ve tat ca)
    public List<String> mostFrequentWords() {
        int max = 0;
        for (int v : freq.values()) {
            if (v > max) max = v;
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() == max) result.add(e.getKey());
        }
        Collections.sort(result);
        return result;
    }

    public int maxCount() {
        return freq.isEmpty() ? 0 : Collections.max(freq.values());
    }

    // 3b. Cac tu chi xuat hien dung 1 lan (unique words)
    public List<String> uniqueWords() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) result.add(e.getKey());
        }
        Collections.sort(result);
        return result;
    }

    // Sap xep toan bo tu theo tan suat giam dan (bang nhau thi theo alphabet)
    public List<Map.Entry<String, Integer>> sortedByFrequency() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());
        });
        return list;
    }

    public void printTop(int n) {
        List<Map.Entry<String, Integer>> sorted = sortedByFrequency();
        System.out.println("Top " + n + " tu pho bien nhat:");
        for (int i = 0; i < Math.min(n, sorted.size()); i++) {
            Map.Entry<String, Integer> e = sorted.get(i);
            System.out.printf("  %2d. %-12s %d%n", i + 1, e.getKey(), e.getValue());
        }
    }

    public int totalWords() {
        int total = 0;
        for (int v : freq.values()) total += v;
        return total;
    }

    public int distinctWords() { return freq.size(); }
}
