package labb2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    private static List<Employee> allEmployees = new ArrayList<>();

    static void addEmployee(Employee newEmployee) {
        allEmployees.add(newEmployee);
        //return true;
    }

    public static void ifEmptyPopulate() {

        if (allEmployees.isEmpty()) {
            Employee e1 = new Manager("Anna", "Öhman", "1987-10-22", 1, 60000, Positions.MANAGER);
            Employee e2 = new Programmer("Bengt", "Älmgren", "1987-10-22", 2, 45000, Positions.PROGRAMMER);
            Employee e3 = new Programmer("Cecilia", "Åbeck", "1987-10-22", 3, 50000, Positions.PROGRAMMER);
            Employee e4 = new Programmer("David", "Zachan", "1987-10-22", 4, 65000, Positions.PROGRAMMER);
            Employee e5 = new Programmer("Evelina", "Yoo", "1987-10-22", 5, 55000, Positions.PROGRAMMER);
            Employee e6 = new Secretary("Fredrik", "Xavier", "1987-10-22", 6, 27000, Positions.SECRETARY);
            Employee e7 = new Technician("Gunilla", "Wikström", "1987-10-22", 7, 30000, Positions.TECHNICIAN);
            Employee e8 = new Technician("Harald", "Valin ", "1987-10-22", 8, 35000, Positions.TECHNICIAN);
            Employee e9 = new Technician("Anna", "Ullrich ", "1987-10-22", 9, 23000, Positions.TECHNICIAN);
            Employee e10 = new Economist("Josef", "Thor", "1987-10-22", 10, 80000, Positions.ECONOMIST);
            allEmployees.add(e1);
            allEmployees.add(e2);
            allEmployees.add(e3);
            allEmployees.add(e4);
            allEmployees.add(e5);
            allEmployees.add(e6);
            allEmployees.add(e7);
            allEmployees.add(e8);
            allEmployees.add(e9);
            allEmployees.add(e10);
        }
    }
    

    public static List<Employee> getAllEmployees() {
        return allEmployees;
    }
}


