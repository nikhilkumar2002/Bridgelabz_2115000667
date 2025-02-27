package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Employee2 {
    public String name;
    public int age;

    public Employee2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee2> employees = Arrays.asList(
                new Employee2("Alice", 30),
                new Employee2("Bob", 28),
                new Employee2("Charlie", 35)
        );
        String jsonArray = objectMapper.writeValueAsString(employees);
        System.out.println(jsonArray);
    }
}
