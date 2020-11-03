
package labb2;


public class Programmer extends Employee{
       public Programmer(String firstName, String lastName, String dateOfBirth, int ID, double salary, Positions position) {
        super(firstName, lastName, dateOfBirth, salary, position);
    }

    @Override
    public void calcBonus() {
        double bonus = salary * 0.15;
        System.out.println("Programmers get " + bonus + " SEK bonus.");    
        }
    public void calcSalary(){
        
    }
    
}
