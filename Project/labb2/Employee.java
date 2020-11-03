
package labb2;


public class Employee {
    public String firstName;
    public String lastName;
    public String dateOfBirth;
    public Gender gender;
    
    int ID;
    double salary;
    Positions position;
    
    //static int idGenerator = 1;


    public Employee(String firstName, String lastName, String dateOfBirth, double salary, Positions position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        //this.ID = idGenerator;
        this.salary = salary;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", ID=" + ID +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }

    public double calcBonus() {
        double bonus = salary * 0;
        return bonus;
        //System.out.println("By default no bonus guaranteed. Current Bonus: " + bonus);

    }
    
}

