package Bai6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap a: ");
            int a = sc.nextInt();
            System.out.print("Nhap b: ");
            int b = sc.nextInt();

            int result = a / b;   // có thể ném ArithmeticException
            System.out.println("Ket qua: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Bro phai nhap so nguyen...");
        } catch (ArithmeticException e) {
            System.out.println("Khonng the chia cho 0...");
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
