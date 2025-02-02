class PersonDetails{
    private String name;
    private int age;
    public PersonDetails(String name,int age){
        this.name=name;
        this.age=age;
    }
    PersonDetails(PersonDetails P){
        System.out.println("Copy Constructor");
        this.name=P.name;
        this.age=P.age;
    }
    public void display(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
}
public class Person{
    public static void main(String[] args) {
        PersonDetails P1=new PersonDetails("Lali",22);
        PersonDetails P2=new PersonDetails(P1);//Cloning P1 to P2
        System.out.println("\nPerson Details");
        P1.display();
        System.out.println("\nCopied Details");
        P2.display();
    }
}
