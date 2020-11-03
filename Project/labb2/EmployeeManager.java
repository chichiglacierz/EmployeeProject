package labb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static labb2.Main.ANSI_GREEN;

public abstract class EmployeeManager extends Employee {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public EmployeeManager(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    static Scanner sc = new Scanner(System.in);
    static List<Employee> allEmployees = EmployeeList.getAllEmployees();

    static int userInput;

    public static void addEmployee() {

        System.out.println("First name:");
        String firstName = sc.nextLine();

        System.out.println("Last name");
        String lastName = sc.nextLine();

        System.out.println("Date of birth");
        String dateOfBirth = sc.nextLine();

        System.out.println("Enter " + firstName + "'s salary:");
        int employeeSalary = Integer.parseInt(sc.nextLine()); //FIX 

        System.out.println("Position");
        String empPosition = positionHandler();
        /*System.out.println(empPosition);
        System.out.println(Positions.valueOf(empPosition));*/

        Employee newEmployee = new Employee(firstName, lastName, dateOfBirth, employeeSalary, Positions.valueOf(empPosition)) {
        };
        EmployeeList.addEmployee(newEmployee);
        System.out.println(ANSI_YELLOW + empPosition + " " + firstName + " " + lastName + " has been created" + ANSI_RESET);
    }

    public static void fireEmployee() {

        System.out.println("Please enter the id of the employee that you want to remove:");
        int employeeId = sc.nextInt();
        sc.nextLine();

        for (int i = allEmployees.size() - 1; i > 0; i--) {
            if (allEmployees.get(i).getID() != employeeId) {
                continue;
            }
            String firstName = allEmployees.get(i).firstName;
            String lastName = allEmployees.get(i).lastName;
            Positions position = allEmployees.get(i).position;
            System.out.println("Id:" + employeeId + " " + position + " " + firstName + " " + lastName);
            System.out.println("Are you sure? y/n");
            String choice = sc.nextLine();
            if (choice.equals("y")) {
                allEmployees.remove(allEmployees.get(i));
                System.out.println(ANSI_RED + "Id:" + employeeId + " " + firstName + " " + lastName + " has been terminated." + ANSI_RESET);
                break;
            } else {
                System.out.println(ANSI_YELLOW + "Termination has been cancelled." + ANSI_RESET);
            }
        }
    }

    public static void updateName() {

        System.out.println("Please enter the id of the employee:");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getID() == id) {
                System.out.println("Current name: " + employee.firstName + " " + employee.lastName);
                System.out.println("Please enter the new name:");
                System.out.println("First name:");
                String newName = sc.nextLine();
                employee.setFirstName(newName);
                System.out.println("Last name:");
                String newLName = sc.nextLine();
                employee.setLastName(newLName);
                System.out.println(ANSI_YELLOW + "The new name has been set to: " + newName + " " + newLName + ANSI_RESET);
                break;
            }
        }
    }

    public static void updateAge() {

        System.out.println("Please enter the id of the employee:");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getID() == id) {
                System.out.println(employee.firstName + " " + employee.lastName);
                System.out.println("Current birthdate: " + employee.dateOfBirth);
                System.out.println("Please enter the new birthdate:");
                String newAge = sc.nextLine();
                employee.setDateOfBirth(newAge);
                System.out.println(employee.firstName + "'s new bithdate has been set to: " + newAge);
                break;
            }
        }
    }

    public static void updatePosition() {

        System.out.println("Please enter the id of the employee:");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getID() == id) {
                System.out.println(employee.firstName + " " + employee.lastName);
                System.out.println("Current position: " + employee.position);
                String newPos = positionHandler();
                Positions.valueOf(newPos);
                System.out.println(employee.firstName + "'s new position has been set to: " + newPos);
                break;
            }
        }
    }

    public static void updateSalary() {

        System.out.println("Please enter the id of the employee:");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getID() == id) {
                System.out.println("Employee: " + employee.firstName + " " + employee.lastName);
                System.out.println("Current salary: " + employee.salary);
                System.out.println("Please enter new salary:");
                double newSalary = Double.parseDouble(sc.nextLine());
                employee.setSalary(newSalary);
                System.out.println(employee.firstName + "'s new salary has been set to: " + newSalary);
                break;
            }
        }
    }

    public static void findEmployeeById() {

        System.out.println("Enter id to find employee: ");
        int employeeId = sc.nextInt();
        sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getID() == employeeId) {
                System.out.println(employee);
                break;
            }
            /* else*/

        }
    }

    public static void findEmployeeByName() {
        System.out.println("Enter employees first name: ");
        String employeeName = sc.nextLine();

        for (Employee employee : allEmployees) {

            if (employee.getFirstName().equalsIgnoreCase(employeeName)) {
                System.out.println(employee);
            }
        }
    }

    public static void findEmployeeByPosition() {
        boolean isFound = false;
        System.out.println("Enter employees position: ");
        String employeePosition = positionHandler();

        for (Employee employee : allEmployees) {

            if (employee.getPosition().equals(Positions.valueOf(employeePosition))) {
                System.out.println(employee);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println(ANSI_RED + "we could not process your request at this time. Please try again." + ANSI_RESET);
        }
    }

    public static void showAllEmployees() {

        for (int i = 0; i < allEmployees.size(); i++) {
            System.out.println("The list of employees is:" + allEmployees.get(i));
        }
    }

    public static void numberOfEmployees() {

        System.out.println("There are " + allEmployees.size() + " employees in the company");
    }

    public static String positionHandler() {

        String position = "test";
        System.out.println("Choose department:");
        System.out.println("1. Management");
        System.out.println("2. Development");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("1. Economist");
                System.out.println("2. Secretary");
                System.out.println("3. Manager");
                int choice2 = sc.nextInt();
                sc.nextLine();
                switch (choice2) {
                    case 1:
                        position = "ECONOMIST";
                        break;
                    case 2:
                        position = "SECRETARY";
                        break;
                    case 3:
                        position = "MANAGER";
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("1. Programmer");
                System.out.println("2. Technician");
                int choice3 = sc.nextInt();
                sc.nextLine();
                switch (choice3) {
                    case 1:
                        position = "PROGRAMMER";
                        break;
                    case 2:
                        position = "TECHNICIAN";
                        break;
                    default:
                        break;
                }
                break;
        }
        return position;
    }

    public static void removeEmployeeById() {
        boolean deleted = false;

        System.out.println("Please enter the id of the employee that you want to remove:");
        int employeeId = sc.nextInt();
        sc.nextLine();

        for (int i = allEmployees.size() - 1; i > 0; i--) {
            if (allEmployees.get(i).getID() == employeeId) {
                allEmployees.remove(allEmployees.get(i));
                System.out.println(ANSI_YELLOW + "Employee id: " + employeeId + " has been removed." + ANSI_RESET);
                deleted = true;
            }
        }
        if (!deleted) {
            System.out.println("Employee deletion has not gone through.\n"
                    + "Please try again.");
        }
    }

    public static void statisticsMenu() {
        EmployeeList.ifEmptyPopulate();  // call method to check stats). Fyller listan om den är tom

        boolean isInput = true;
        while (isInput) {

            System.out.println();
            System.out.println(ANSI_GREEN + "You are now in the" + ANSI_RESET
                    + ANSI_YELLOW + " Employee Statistics " + ANSI_RESET + ANSI_GREEN + "section." + ANSI_RESET);
            System.out.println(ANSI_GREEN + "***********************************************" + ANSI_RESET);
            System.out.println("Make a choice to continue: \n");
            System.out.println("1: Average wage at the company");
            System.out.println("2: Highest salary at the company");
            System.out.println("3: Lowest salary at the company");
            System.out.println("4: Total bonus");
            System.out.println("5: Women in percentage in the company");
            System.out.println("6: Men percentage of the various work role categories");
            System.out.println("0: Back to main menu");
            int userInput = sc.nextInt();
            sc.nextLine();

            switch (userInput) {
                case 1:
                    calcAverageSalary();
                    break;
                case 2:
                    calcHighestSalary();
                    break;
                case 3:
                    calcLowestSalary();
                    break;
                case 4:
                    totalBonus();
                    break;
                case 0:
                    isInput = false;
                    break;
            }

        }
    }

    public static void calcAverageSalary() {
        double allSalary = 0; //keep track of avg salary
        double totalEmployees = 0;

        EmployeeList.ifEmptyPopulate();

        for (Employee employee : allEmployees) {
            allSalary = allSalary + employee.getSalary();
            totalEmployees++; // each loop add current sal to total

        }
        double averageSalary = allSalary / totalEmployees;
        System.out.println("The average salary is: " + averageSalary);
        //return averageSalary;
    }

    public static void calcLowestSalary() {
        List<Employee> allEmployees = EmployeeList.getAllEmployees();
        EmployeeList.ifEmptyPopulate();

        //skapa variabel för att hålla hittad employee
        //EmployeeList lowestEmpSalary = null;
        try {
            double lowestSalaryFound = allEmployees.get(0).getSalary();

            for (Employee employee : allEmployees) {
                double salary = employee.getSalary();
                if (salary < lowestSalaryFound) {
                    //highestEmpSalary = employee;
                    lowestSalaryFound = employee.getSalary();
                }
            }
            System.out.println("Lowest Salary in the company is: " + lowestSalaryFound);
        } catch (Exception e) {
            System.out.println("Problem when reading in a double");

        }
        /*if (allEmployees == null || allEmployees.size() == 0) {
            double lowestSalary =  Double.MAX_VALUE;
            System.out.println("Lowest Salary : " + lowestSalary);
        }
         */
 /*for(Employee employee: allEmployees){
            
            
            /*if (i == 0 || employee. < minValue){
                minValue = employee.getSalary();
                minIndex = i;
            }
            System.out.println("The minimum salary is: " + minIndex);
         */
    }

    public static void calcHighestSalary() {
        List<Employee> allEmployees = EmployeeList.getAllEmployees();
        EmployeeList.ifEmptyPopulate();

        //skapa variabel för att hålla hittad employee
        EmployeeList highestEmpSalary = null;

        double highestSalaryFound = 0;

        for (Employee employee : allEmployees) {
            double salary = employee.getSalary();
            if (salary > highestSalaryFound) {
                //highestEmpSalary = employee;
                highestSalaryFound = employee.getSalary();
            }
        }
        System.out.println("Highest Salary in the company is: " + highestSalaryFound);

    }

    public static void totalBonus() {
        double totalBonus = 0;
        for (Employee employee : allEmployees) {

            totalBonus += employee.calcBonus();

        }
        System.out.println("Total bonus in the company: " + totalBonus);
    }

    /*double allSalary = 0;
        double totalEmployees = 0;*/
 /* EmployeeList.ifEmptyPopulate();
        
        double highestSalary = Double.MIN_VALUE;
        
        for (Employee employee : allEmployees){
           highestSalary =Math.max(highestSalary, )
        }
        
       
        
    }*/


 /*
    public static void removeEmployeeByName() {
        System.out.println("Please enter the last name of the employee that you want to remove:");
        String employeeName = sc.nextLine();

        for (int i = allEmployees.size() - 1; i > 0; i--) {
            if (allEmployees.get(i).getLastName().equals(employeeName)) {
                allEmployees.remove(allEmployees.get(i));
                System.out.println("Employee: " + employeeName + " has been removed.");
            }
        }

    }*/
 /*public static void mainMenu() {
        
        int userChoice = - 1;
        
        System.out.println("Welcome to our Employee Management System (Proffs Edition).\n");
        System.out.println("What do you want to do?\n");
        System.out.println("1. Employee management\n"
                + "2. Employee statistics\n"
                + "3. Employee program\n"
                + "4. Exit");

        while (userChoice < 0) {
            Scanner sc = new Scanner(System.in);

            //userChoice = Integer.parseInt(sc.nextLine());
            try {

                userChoice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong input, try again");
            }

            /*behöver error hantering (try sats)om användaren 
             1.trycker valen som ej finns
             2. mäter in bokstäver*/
 /*if (userChoice < 1 || userChoice > 4) {
                System.out.println("You made a wrong choice. Please try again..");
                break;
            }*/
 /*}
        
        
        /*
        switch (userChoice) {
            case 1:
                System.out.println("Choose from Employee Management Menu below:");
                //managementMenu();
                while (loop) {
                    switchList(managementMenu());
                }
                break;
            case 2:
                System.out.println("Employee statistics");
                break;
            case 3:
                System.out.println("Employee program");
                break;
            default:
                System.out.println("You are now exiting the program..");
                System.exit(0);
        }*/
    /*}*/
}
