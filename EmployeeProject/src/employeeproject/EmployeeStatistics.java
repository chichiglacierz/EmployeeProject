package labb2;

import java.util.Scanner;


public class EmployeeStatistics {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    
    static Scanner sc = new Scanner(System.in);

    
    public static void statisticsMenu() {

        boolean loop = true;
        while (loop) {

            System.out.println();
            System.out.println(ANSI_GREEN + "You are now in the" + ANSI_RESET
                    + ANSI_YELLOW + " Employee Statistics " + ANSI_RESET + ANSI_GREEN + "section." + ANSI_RESET);
            System.out.println(ANSI_GREEN + "***********************************************" + ANSI_RESET);
            System.out.println("Make a choice to continue: \n");
            System.out.println("1. Number of employees");
            System.out.println("2. Average wage at the company");
            System.out.println("3. Highest salary at the company");
            System.out.println("4. Lowest salary at the company");
            System.out.println("5. Total bonus");
            System.out.println("0. Back to main menu");
            
            int choice = 0;
            while (true) {
                choice = 0;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println(ANSI_RED + "Invalid input. Please try again.." + ANSI_RESET);
                    continue;
                }
                if (choice < 0 || choice > 10) {
                    System.out.println(ANSI_RED + "Invalid input. Please try again.." + ANSI_RESET);
                    continue;
                }
                break;
            }
            switch (choice) {
                case 1:
                    numberOfEmployees();
                    break;
                case 2:
                    calcAverageSalary();
                    break;
                case 3:
                    calcHighestSalary();
                    break;
                case 4:
                    calcLowestSalary();
                    break;
                case 5:
                    totalBonus();
                    break;
                case 0:
                    loop = false;
                    break;
            }

        }
    }
    
    public static void numberOfEmployees() {
        
        System.out.println("There are " + EmployeeList.allEmployees.size() + " employees in the company");
        }

    public static void calcAverageSalary() {
        double allSalary = 0;
        double totalEmployees = 0;

        for (Employee employee : EmployeeList.allEmployees) {
            allSalary = allSalary + employee.getSalary();
            totalEmployees++;

        }
        double averageSalary = allSalary / totalEmployees;
        System.out.println("The average salary is: " + averageSalary);
    }

    public static void calcLowestSalary() {

        try {
            double lowestSalaryFound = EmployeeList.allEmployees.get(0).getSalary();

            for (Employee employee : EmployeeList.allEmployees) {
                double salary = employee.getSalary();
                if (salary < lowestSalaryFound) {
                    lowestSalaryFound = employee.getSalary();
                }
            }
            System.out.println("Lowest Salary in the company is: " + lowestSalaryFound);
        } catch (Exception e) {
            System.out.println("Problem when reading in a double");

        }
    }

    public static void calcHighestSalary() {

        double highestSalaryFound = 0;

        for (Employee employee : EmployeeList.allEmployees) {
            double salary = employee.getSalary();
            if (salary > highestSalaryFound) {
                highestSalaryFound = employee.getSalary();
            }
        }
        System.out.println("Highest Salary in the company is: " + highestSalaryFound);

    }

    public static void totalBonus() {
        double totalBonus = 0;
        for (Employee employee : EmployeeList.allEmployees) {

            totalBonus += employee.calcBonus();

        }
        System.out.println("Total bonus in the company: " + totalBonus);
    }
    
}
