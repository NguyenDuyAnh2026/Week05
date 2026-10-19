package Bai7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyTextFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap duong dan tep nguon: ");
        String srcPath = sc.nextLine().trim();
        System.out.print("Nhap duong dan tep dich: ");
        String destPath = sc.nextLine().trim();

        // khai bao ngoai try de finally nhin thay va dong duoc
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(srcPath));
            writer = new PrintWriter(new FileWriter(destPath));

            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                count++;
            }
            System.out.println("Da sao chep " + count + " dong.");
        } catch (FileNotFoundException e) {
            // reader con null => loi o buoc mo tep nguon
            if (reader == null) {
                System.out.println("Source file not found.");
            } else {
                System.out.println("Cannot create destination file.");
            }
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            // kiem tra != null vi co the loi xay ra truoc khi tao doi tuong
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (writer != null) writer.close();   // PrintWriter.close() khong nem IOException
            sc.close();
        }
    }
}