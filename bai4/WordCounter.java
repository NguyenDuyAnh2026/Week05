package bai4;

import java.util.*;

public class WordCounter {
    private final Map<String, Integer> freq = new HashMap<>();

    // B1 + B2 + B3
    public void analyze(String text) {
        freq.clear();

        // B1: chuan hoa - chu thuong, bo dau cham, dau phay (va cac dau cau khac)
        String normalized = text.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");

        // B2: tach thanh mang cac tu
        String[] words = normalized.trim().split("\\s+");

        // B3: duyet mang va dem
        for (String word : words) {
            if (word.isEmpty()) continue;

            if (freq.containsKey(word)) {
                freq.put(word, freq.get(word) + 1); // da co -> lay gia tri cu + 1
            } else {
                freq.put(word, 1);                  // chua co -> put voi gia tri 1
            }
        }
    }

    // In danh sach tu va so luong (sap theo so lan giam dan cho de nhin)
    public void displayResult() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());
        });

        System.out.println("Ket qua dem tu:");
        for (Map.Entry<String, Integer> e : list) {
            System.out.printf("  %-10s : %d%n", e.getKey(), e.getValue());
        }
    }

    // Tim tu xuat hien nhieu nhat (tra ve null neu chua co du lieu)
    public Map.Entry<String, Integer> findMostFrequent() {
        Map.Entry<String, Integer> best = null;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (best == null || e.getValue() > best.getValue()) {
                best = e;
            }
        }
        return best;
    }

    public void displayMostFrequent() {
        Map.Entry<String, Integer> best = findMostFrequent();
        if (best == null) {
            System.out.println("Chua co du lieu");
        } else {
            System.out.println("Tu khoa chinh: \"" + best.getKey()
                    + "\" (" + best.getValue() + " lan)");
        }
    }
}