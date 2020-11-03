package labb2;


public class Technician extends Employee {

    public Technician(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public double calcBonus() {
        double bonus = salary * 0.12;
        return bonus;
        //System.out.println("Tecnicians get " + bonus + " SEK bonus.");
    }

}


