// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare based on distance
    public abstract double calculateFare(double distance);

    // Concrete method to get vehicle details
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + "\nDriver Name: " + driverName + "\nRate per Km: " + ratePerKm;
    }

    // Getters and setters for encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Subclasses for Different Vehicle Types
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// GPS Implementation for Vehicle
class VehicleGPS implements GPS {
    private String currentLocation;

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Main Class to Demonstrate Polymorphism
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR123", "John Doe", 15.0);
        Vehicle bike = new Bike("BIKE123", "Jane Smith", 10.0);
        Vehicle auto = new Auto("AUTO123", "David Brown", 12.0);

        // Display vehicle details
        System.out.println("Car Details:\n" + car.getVehicleDetails());
        System.out.println("Bike Details:\n" + bike.getVehicleDetails());
        System.out.println("Auto Details:\n" + auto.getVehicleDetails());

        // Calculate and display fares
        System.out.println("Car Fare for 10 Km: " + car.calculateFare(10));
        System.out.println("Bike Fare for 10 Km: " + bike.calculateFare(10));
        System.out.println("Auto Fare for 10 Km: " + auto.calculateFare(10));

        // Demonstrate GPS functionality
        VehicleGPS gps = new VehicleGPS();
        gps.updateLocation("Central Park");
        System.out.println("Current Location: " + gps.getCurrentLocation());
    }
}
