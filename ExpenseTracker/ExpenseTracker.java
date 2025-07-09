/*
 * ExpenseTracker.java
 * Author: Vishal Thakur <vishalthakurx@gmail.com>
 * GitHub: @vishalthakurx
 * Description: Simple expense tracker with file persistence.
 */
import java.io.*;
import java.util.*;

class Expense implements Serializable {
    String desc; double amount;
    Expense(String desc, double amount) { this.desc = desc; this.amount = amount; }
    public String toString() { return desc + ": $" + amount; }
}

public class ExpenseTracker {
    static List<Expense> expenses = new ArrayList<>();
    static final String FILE = "expenses.ser";
    public static void main(String[] args) throws Exception {
        load();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add 2. List 3. Save & Exit");
            int ch = sc.nextInt(); sc.nextLine();
            if (ch == 1) {
                System.out.print("Desc: "); String d = sc.nextLine();
                System.out.print("Amount: "); double a = sc.nextDouble(); sc.nextLine();
                expenses.add(new Expense(d, a));
            } else if (ch == 2) {
                expenses.forEach(System.out::println);
            } else if (ch == 3) {
                save(); break;
            }
        }
        sc.close();
    }
    static void save() throws IOException {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE))) {
            o.writeObject(expenses);
        }
    }
    static void load() {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(FILE))) {
            expenses = (List<Expense>) o.readObject();
        } catch (Exception e) {}
    }
}
