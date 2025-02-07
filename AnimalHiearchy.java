class Animal{
String name;
int age;
public Animal(String name,int age){
    this.name = name;
    this.age = age;
}

public void makeSound(){
    System.out.println("Animal make sound");
}
}

class Dog extends Animal{
    public Dog(String name,int age){
        super(name,age);
    }

    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

class Cat extends Animal{
    public Cat(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound() {
        System.out.println(name+" meows: Meow! Meow!");
    }
}
class Bird extends Animal{
    public Bird(String name,int age){
        super(name,age);
    }
    @Override
    public void makeSound() {
        System.out.println(name+" chirps: Chirp! Chirp!");
    }
}
class AnimalHiearchy{
    public static void main(String[] args){
        Animal dog = new Dog("Harry",2);
        Animal cat = new Cat("Sweety",3);
        Animal bird = new Bird("Isphery",1);
    }
} 