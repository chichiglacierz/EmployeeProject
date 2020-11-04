
package labb2;


public class Programmer extends Employee implements EmployeeInterface{
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
    
    @Override
    public void paidBusinessVisits(){
        System.out.println("Programmers gets 3 paid businesstrips paid for by the company.");
    }
}
