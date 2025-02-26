package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarJsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Tesla", "Model S", 2023);
        String jsonString = objectMapper.writeValueAsString(car);
        System.out.println(jsonString);
    }
}
