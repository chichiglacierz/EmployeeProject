
package labb2;


public class Programmer extends Employee{
       public Programmer(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public double calcBonus() {
        double bonus = salary * 0.15;
        return bonus;
        }
    public void calcSalary(){
        
    }
    public void paidBusinessVisits(){
        System.out.println("Programmers get 3 business trips paid for by the company.");
    }
}
