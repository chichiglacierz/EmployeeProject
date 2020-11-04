
package labb2;

public class Economist extends Employee  {

    public Economist(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public double calcBonus() {
        double bonus = salary * 0.35;
        return bonus;
    }
}
