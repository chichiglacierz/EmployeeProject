
package labb2;

public class Manager extends Employee {

    public Manager(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public void calcBonus() {
        double bonus = salary * 0.25;
        System.out.println("Managers get " + bonus + " SEK bonus.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}