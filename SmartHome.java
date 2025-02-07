class Device {
    int deviceId;
    String status;

    public Device(int deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device Id: " + deviceId);
        System.out.println("Status of the device: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    public Thermostat(int deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus(); // Calling the superclass method for consistency
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

class SmartHome {
    public static void main(String[] args) {
        Device thermo = new Thermostat(123, "Good", 26);
        thermo.displayStatus();
    }
}