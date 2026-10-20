package Bai8;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GhiDuLieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap te du lieu tu ban phim :
        System.out.println("Nhap ten file can ghi : ");
        String tenFile = sc.nextLine().trim();

        try{
            System.out.println("Nhap so nguyen n:");
            int n = sc.nextInt();
            if(n < 0){
                System.out.println("n phai >= 0");
                return;
            }
            try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream((new FileOutputStream(tenFile))))){
                for(int i=1; i<=n; i++){
                    System.out.println("Nhap so thu " + i + ": ");
                    int x = sc.nextInt();
                    dos.writeInt(x); // ghi 4byte cho moi so nguyen
                }
                System.out.println("Da ghi " + n + " so vao file " + tenFile);
            } catch (IOException e){
                System.out.println("Loi khi ghi tep : " + e.getMessage());
            }
        }
        catch (InputMismatchException e){
            System.out.println("Du lieu nhap vao khong phai so nguyen...!");
        }
        finally {
            sc.close();
        }
    }
}
