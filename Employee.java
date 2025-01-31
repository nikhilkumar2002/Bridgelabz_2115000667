//Class Define
class EmployeeDetails {
    // Fields (Attributes)
    private String name;
    private long id;
    private double salary;
    // Constructor
    public EmployeeDetails(String name,long id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    // Method to display restaurant details
    public void displayDetails(){
        System.out.println("Employee Name: "+name);
        System.out.println("Id: "+id);
        System.out.println("Salary: "+salary);
    }
}
//Main Class to Test
public class Employee{
    public static void main(String[] args) {
        EmployeeDetails E1=new EmployeeDetails("Krishna",123456789,878162);
        EmployeeDetails E2=new EmployeeDetails("Mudit",123456781,87451);
        System.out.println("\n-----Employee 1-----");
        E1.displayDetails();
        System.out.println("\n-----Employee 2-----");
        E2.displayDetails();
    }
}