package bai4;

import java.util.ArrayList;
import java.util.List;

public class ListWordCounter {
    // Moi phan tu luu mot tu va so lan xuat hien
    private static class Entry {
        final String word;
        int count;
        Entry(String word) { this.word = word; this.count = 1; }
    }

    private final List<Entry> entries = new ArrayList<>();

    public void analyze(String text) {
        entries.clear();
        String normalized = text.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
        String[] words = normalized.trim().split("\\s+");

        for (String word : words) {
            if (word.isEmpty()) continue;

            Entry found = null;
            for (Entry e : entries) {          // duyet tuyen tinh: O(m)
                if (e.word.equals(word)) {
                    found = e;
                    break;
                }
            }
            if (found != null) found.count++;
            else entries.add(new Entry(word));
        }
    }

    public int distinctWords() { return entries.size(); }
}