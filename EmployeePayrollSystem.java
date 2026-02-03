import java.util.Scanner;


abstract class Employee {

    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be positive.");
        }
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    
    public void displayDetails(String role) {
        System.out.println("\nPayroll Details:");
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Final Salary: " + calculateSalary());
    }
}


class Developer extends Employee {

    private static final double PROJECT_BONUS_RATE = 0.10;

    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (baseSalary * PROJECT_BONUS_RATE);
    }
}


class Manager extends Employee {

    private static final double PERFORMANCE_BONUS_RATE = 0.20; 
    private double teamAllowance;

    public Manager(String name, double baseSalary, double teamAllowance) {
        super(name, baseSalary);
        this.teamAllowance = teamAllowance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (baseSalary * PERFORMANCE_BONUS_RATE) + teamAllowance;
    }
}


public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Employee emp; 
        System.out.println("Select Employee Type:");
        System.out.println("1. Developer");
        System.out.println("2. Manager");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Base Salary: ");
        double baseSalary = sc.nextDouble();

        if (choice == 1) {
            emp = new Developer(name, baseSalary);
            emp.displayDetails("Developer");

        } else if (choice == 2) {
            System.out.print("Enter Team Allowance: ");
            double allowance = sc.nextDouble();

            emp = new Manager(name, baseSalary, allowance);
            emp.displayDetails("Manager");

        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
