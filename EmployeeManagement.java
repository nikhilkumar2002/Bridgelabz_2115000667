class Employee{
    String name;
    int id;
    double salary;

    public Employee(int id,String name,double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Salary: "+salary);
    }
}

class Manager extends Employee{
    int teamSize;

    public Manager(int id,String name,double salary,int teamSize){
        super(id,name,salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("Id of Manager: "+id);
        System.out.println("Name of Manager: "+name);
        System.out.println("Salary of Manager: "+salary);
        System.out.println("Team Size of Manager: "+teamSize);
    }
}

class Developer extends Employee{
    int teamSize;

    public Developer(int id,String name,double salary,int teamSize){
        super(id,name,salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails() {
        System.out.println("Id of Developer: "+id);
        System.out.println("Name of Developer: "+name);
        System.out.println("Salary of Developer: "+salary);
        System.out.println("Team Size of Developer: "+teamSize);
    }
}
class Intern extends Employee{
    int teamSize;
    public Intern(int id,String name,double salary,int teamSize){
        super(id,name,salary);
        this.teamSize = teamSize;
    }

    public void displayDetails() {
        System.out.println("Id of Intern: "+id);
        System.out.println("Name of Intern: "+name);
        System.out.println("Salary of Intern: "+salary);
        System.out.println("Team Size of Intern: "+teamSize);
    }
}
class EmployeeManagement{
    public static void main(String[] args){
        Employee manager = new Manager(1,"Prashant",2500000.00,6);
        Employee developer = new Developer(23,"Shivangi",5000000.00,10);
        Employee intern = new Intern(56,"Aditi",1500000.00,3);
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
} 