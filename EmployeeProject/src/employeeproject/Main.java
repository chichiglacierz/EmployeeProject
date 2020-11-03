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
    static int choice2;

    public static void main(String[] args) {
        EmployeeList.ifEmpty();

        while (loop) {
            switch (menu()) {

                case 1:
                    EmployeeManager.employeeManagerMenu();
                    break;
                case 2:
                    EmployeeStatistics.statisticsMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using Employee Management System (Proffs Edition)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!\n\n");
                    break;
            }
        }
    }

    public static int menu() {
        int userChoice;

        System.out.println("\n" + ANSI_GREEN + "Welcome to our Employee Management System (Proffs Edition).\n" + ANSI_RESET);
        System.out.println("What do you want to do?\n");
        System.out.println("1. Employee management\n"
                + "2. Employee statistics\n"
                + "0. Exit");
        while (true) {
            userChoice = 0;
            try {
                userChoice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Invalid input. Please try again.." + ANSI_RESET);
                continue;
            }
            if (userChoice < 0 || userChoice > 2) {
                System.out.println(ANSI_RED + "Invalid input. Please try again.." + ANSI_RESET);
                continue;
            }
            break;
        }

        return userChoice;

    }

}
