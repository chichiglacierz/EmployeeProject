package labb2;

import java.util.Scanner;

public abstract class EmployeeManager extends Employee{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

public EmployeeManager(String firstName, String lastName, String dateOfBirth, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
}

    static Scanner sc = new Scanner(System.in);
    static int userInput;

    public static void employeeManagerMenu () {
        boolean loop = true;
        while (loop) {
            System.out.println("\n" + ANSI_GREEN + "You are now in the Employee Management section" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "***********************************************" + ANSI_RESET + "\n");
            System.out.println("What would you like to do?\n");
            System.out.println("1. Add employee");
            System.out.println("2. Fire employee");
            System.out.println("3. Update name of employee");
            System.out.println("4. Update age of employee");
            System.out.println("5. Update position of employee");
            System.out.println("6. Update salary of employee");
            System.out.println("7. Search by name");
            System.out.println("8. Search by id");
            System.out.println("9. Search by department");
            System.out.println("10. Show all employees");
            System.out.println("0. Go back to previous menu");

            System.out.println("\nMake a choice");

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
                    addEmployee();
                    break;
                case 2:
                    fireEmployee();
                    break;
                case 3:
                    updateName();
                    break;
                case 4:
                    updateAge();
                    break;
                case 5:
                    updatePosition();
                    break;
                case 6:
                    updateSalary();
                    break;
                case 7:
                    findEmployeeByName();
                    break;
                case 8:
                    findEmployeeById();
                    break;
                case 9:
                    findEmployeeByPosition();
                    break;
                case 10:
                    showAllEmployees();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option!\n\n");
            }
        }
    }

    public static void addEmployee() {

        System.out.println("First name:");
        String firstName = sc.nextLine();

        System.out.println("Last name");
        String lastName = sc.nextLine();

        System.out.println("Date of birth");
        String dateOfBirth = sc.nextLine();

        System.out.println("Enter " + firstName + "'s salary:");
        int employeeSalary = Integer.parseInt(sc.nextLine());

        System.out.println("Position");
        String empPosition = positionHandler();

        Employee newEmployee = new Employee(firstName, lastName, dateOfBirth, employeeSalary, Positions.valueOf(empPosition)) {@Override
            double calcBonus() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        EmployeeList.addEmployee(newEmployee);
        System.out.println(ANSI_YELLOW + empPosition + " " + firstName + " " + lastName + " has been created" + ANSI_RESET);
    }

    public static void fireEmployee() {

        System.out.println("Please enter the id of the employee that you want to remove:");
        int employeeId = sc.nextInt();
        sc.nextLine();

        for (int i = EmployeeList.allEmployees.size() - 1; i > 0; i--) {
            if (EmployeeList.allEmployees.get(i).getID() != employeeId) {
                continue;
            }
            String firstName = EmployeeList.allEmployees.get(i).firstName;
            String lastName = EmployeeList.allEmployees.get(i).lastName;
            Positions position = EmployeeList.allEmployees.get(i).position;
            System.out.println("Id:" + employeeId + " " + position + " " + firstName + " " + lastName);
            System.out.println("Are you sure? y/n");
            String choice = sc.nextLine();
            if (choice.equals("y")) {
                EmployeeList.allEmployees.remove(EmployeeList.allEmployees.get(i));
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

        for (Employee employee : EmployeeList.allEmployees) {

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

        for (Employee employee : EmployeeList.allEmployees) {

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

        for (Employee employee : EmployeeList.allEmployees) {

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

        for (Employee employee : EmployeeList.allEmployees) {

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

        for (Employee employee : EmployeeList.allEmployees) {

            if (employee.getID() == employeeId) {
                System.out.println(employee);
                break;
            }
        }
    }

    public static void findEmployeeByName() {
        System.out.println("Enter employees first name: ");
        String employeeName = sc.nextLine();

        for (Employee employee : EmployeeList.allEmployees) {

            if (employee.getFirstName().equalsIgnoreCase(employeeName)) {
                System.out.println(employee);
            }
        }
    }

    public static void findEmployeeByPosition() {

        System.out.println("Enter employees position: ");
        String employeePosition = positionHandler();

        for (Employee employee : EmployeeList.allEmployees) {

            if (employee.getPosition().equals(Positions.valueOf(employeePosition))) {
                System.out.println(employee);
            }
        }
    }

    public static void showAllEmployees() {
        System.out.println("\nCurrent employees:");
        for (int i = 0; i < EmployeeList.allEmployees.size(); i++) {
            System.out.println(EmployeeList.allEmployees.get(i));
        }
    }

    public static void removeEmployeeById() {
        boolean deleted = false;

        System.out.println("Please enter the id of the employee that you want to remove:");
        int employeeId = sc.nextInt();
        sc.nextLine();

        for (int i = EmployeeList.allEmployees.size() - 1; i > 0; i--) {
            if (EmployeeList.allEmployees.get(i).getID() == employeeId) {
                EmployeeList.allEmployees.remove(EmployeeList.allEmployees.get(i));
                System.out.println(ANSI_YELLOW + "Employee id: " + employeeId + " has been removed." + ANSI_RESET);
                deleted = true;
            }
        }
        if (!deleted) {
            System.out.println("Employee deletion has not gone through.\n"
                    + "Please try again.");
        }
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
}
