package Bai9;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVesionUID = 1L;
    private String id;
    private String name;
    private double gpa;

    Student(String id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    @Override
    public String toString(){
        return id + " | " + name + " | " + gpa;
    }

}
