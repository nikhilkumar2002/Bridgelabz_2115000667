class Vehicle {
    int maxSpeed;
    String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Speed of Vehicle: " + maxSpeed);
        System.out.println("Fuel Type of Vehicle: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Speed of Car: " + maxSpeed);
        System.out.println("Fuel Type of Car: " + fuelType);
        System.out.println("Seat Capacity of Car: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int seatCapacity;

    public Truck(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Speed of Truck: " + maxSpeed);
        System.out.println("Fuel Type of Truck: " + fuelType);
        System.out.println("Seat Capacity of Truck: " + seatCapacity);
    }
}

class MotorCycle extends Vehicle {
    int seatCapacity;

    public MotorCycle(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Speed of MotorCycle: " + maxSpeed);
        System.out.println("Fuel Type of MotorCycle: " + fuelType);
        System.out.println("Seat Capacity of MotorCycle: " + seatCapacity);
    }
}

class VehicleTransport {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(100, "Diesel", 4),
                new MotorCycle(200, "Petrol", 2)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println(); // Print a new line for clarity
        }
    }
}
