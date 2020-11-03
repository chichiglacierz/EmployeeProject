package labb2;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    EmployeeList list = new EmployeeList();
    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;

    public static void main(String[] args) {
        //EmployeeManager.mainMenu();
        while (loop) {
            int choice = menu();
            if (choice > 3) {
                break;

            }
            switch (choice) {

                case 1:

                    while (true) {
                        int secondChoice = menu2();
                        if(secondChoice == 11){
                            break;
                        }
                        switchList(secondChoice);
                    }

                    break;
                case 2:
                    EmployeeManager.statisticsMenu();
                    break;
                case 3:
                    System.out.println("Employee program");
                    break;
                default:
                    System.out.println("You are now exiting the program..");

            }

        }

    }
    
    public static int menu() {
        int userChoice = - 1;

        System.out.println(ANSI_GREEN + "Welcome to our Employee Management System (Proffs Edition).\n" + ANSI_RESET);
        System.out.println("What do you want to do?\n");
        System.out.println("1. Employee management\n"
                + "2. Employee statistics\n"
                + "0. Exit");
        while (userChoice < 0) {
            Scanner sc = new Scanner(System.in);

            try {

                userChoice = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Wrong input, try again");
            }
            if (userChoice < 1 || userChoice > 4) {
                System.out.println(ANSI_RED + "You made a wrong choice. Please try again.."+ ANSI_RESET);
                break;
            }

        }

        /*switch (userChoice) {
            case 1:
                menu2();
                break;
            case 2:
                EmployeeManager.statisticsMenu();
                break;
            case 3:
                System.out.println("Employee program");
                break;
            default:
                System.out.println("You are now exiting the program..");
               

        }*/
        return userChoice;

    }
     public static int menu2() {
        System.out.println(ANSI_GREEN + "You are now in the Employee Management section" + ANSI_RESET);
        System.out.println("");
        System.out.println(ANSI_GREEN + "******************************************" + ANSI_RESET);
         System.out.println("");
        System.out.println("What would you like to do?\n");
        System.out.println("\n1. Add employee");
        System.out.println("2. Fire employee");
        System.out.println("3. Update name of employee");
        System.out.println("4. Update age of employee");
        System.out.println("5. Update position of employee");
        System.out.println("6. Update salary of employee");
        System.out.println("7. Search by name");
        System.out.println("8. Search by id");
        System.out.println("9. Search by department");
        System.out.println("10. Show all employees");
        System.out.println("11. Go back to previous menu");
        

        System.out.println("\nMake a choice");
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    public static void switchList(int choice) {
        //EmployeeList.ifEmptyPopulate();
        switch (choice) {
            case 1:
                EmployeeManager.addEmployee();
                break;
            case 2:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.fireEmployee();
                break;
            case 3:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.updateName();
                break;
            case 4:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.updateAge();
                break;
            case 5:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.updatePosition();
                break;
            case 6:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.updateSalary();
                break;
            case 7:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.findEmployeeByName();
                break;
            case 8:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.findEmployeeById();
                break;
            case 9:
                EmployeeList.ifEmptyPopulate();
                EmployeeManager.findEmployeeByPosition();
                break;
            case 10:
                 EmployeeList.ifEmptyPopulate();
                EmployeeManager.showAllEmployees();
                break;
            case 11:
                break;
            default:
                System.out.println("Invalid option!");
                System.out.println("");
                System.out.println("");
        }

    }


   
}
