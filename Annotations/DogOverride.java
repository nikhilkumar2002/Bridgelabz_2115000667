class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class DogOverride {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}
