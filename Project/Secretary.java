
package labb2;

public class Secretary extends Employee {
    

    public Secretary(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public void calcBonus() {
        double bonus = salary * 0.05;
        System.out.println("Secretaries get " + bonus + " SEK bonus.");
    }

}
