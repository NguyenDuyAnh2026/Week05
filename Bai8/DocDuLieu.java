package Bai8;

import java.io.*;
import java.util.Scanner;

public class DocDuLieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten file can doc: ");
        String tenFile = sc.nextLine().trim();

        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(tenFile)))){
            System.out.println("ca so doc duoc tu tep: ");
            int dem = 0;

            try{
                while(true){
                    int x = dis.readInt();
                    System.out.println(x);
                    dem++;
                }
            } catch (EOFException e){
                System.out.println("Da doc het file. Tong cong: " + dem + " so");
            }
        } catch (IOException e){
            System.out.println("Loi khi doc file" + e.getMessage());
        }finally {
            sc.close();
        }
    }
}
