interface Refuelable {
    void refuel();
}

class Vehicle {
    int maxSpeed;
    String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Electric vehicle charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Petrol vehicle refueling.");
    }
}

class VehicleSystem {
    public static void main(String[] args) {
        Refuelable petrolCar = new PetrolVehicle(180, "SUV");
        petrolCar.refuel();
    }
}