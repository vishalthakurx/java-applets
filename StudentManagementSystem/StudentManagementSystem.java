/*
 * StudentManagementSystem.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: A simple console-based student management system demonstrating OOP, collections, and exception handling.
 */
import java.util.*;

class Student {
    private String id, name;
    private int age;
    public Student(String id, String name, int age) {
        this.id = id; this.name = name; this.age = age;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String toString() { return id + ": " + name + ", Age: " + age; }
}

public class StudentManagementSystem {
    private static Map<String, Student> students = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Student 2. View All 3. Remove 4. Exit");
            int ch = sc.nextInt(); sc.nextLine();
            try {
                if (ch == 1) {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    if (students.containsKey(id)) throw new Exception("ID exists");
                    students.put(id, new Student(id, name, age));
                } else if (ch == 2) {
                    students.values().forEach(System.out::println);
                } else if (ch == 3) {
                    System.out.print("ID to remove: "); String id = sc.nextLine();
                    if (students.remove(id) == null) System.out.println("Not found");
                } else if (ch == 4) break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
