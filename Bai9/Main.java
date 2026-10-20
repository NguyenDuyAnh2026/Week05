package Bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> ds = new ArrayList<>();
        // nhap cho den khi gap end:
        while(true){
            System.out.println("MSV : <go end de dung> : ");
            String id = sc.nextLine().trim();
            if(id.equals("end")){
                break;
            }
            System.out.print("Ho ten :");
            String name = sc.nextLine().trim();
            System.out.print("GPA : ");
            double gpa = Double.parseDouble(sc.nextLine().trim());
            ds.add(new Student(id, name, gpa));
        }
        System.out.println("Ten file : ");
        String tenFile = sc.nextLine().trim();
        //ghi tep
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))){
            for(Student s : ds){
                oos.writeObject(s);
            }
        }catch (IOException e){
            System.out.println("Loi ghi file: " + e.getMessage());
        }
        // doc tep:
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))){
            while(true){
                System.out.println((Student) ois.readObject());
            }
        }catch (EOFException e){
            System.out.println("da doc het file...!");
        }catch (ClassNotFoundException e){
            System.out.println("Khong tim thay lop..!");
        }catch (FileNotFoundException e){
            System.out.println("Khong tim thay file: " + e.getMessage());
        }catch (IOException e){
            System.out.println("Loi doc tep: " + e.getMessage());
        }
    }
}
