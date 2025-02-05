import java.util.ArrayList;

// Company class that contains multiple Department objects (Composition)
class Company {
    ArrayList<Department> departments;

    Company() {
        departments = new ArrayList<>();
    }

    // Adds a Department to the Company
    void addDepartment(Department department) {
        departments.add(department);
    }

    // Displays the Company structure including Departments and Employees
    void displayCompanyStructure() {
        System.out.println("Company Structure:");
        for (Department dept : departments) {
            System.out.println("\nDepartment: " + dept.name);
            dept.displayEmployees();
        }
    }

    // Simulates deletion of the Company, which in turn removes all Departments and Employees
    void deleteCompany() {
        // In composition, deleting the Company results in the deletion of its Departments and Employees.
        departments.clear();
        System.out.println("Company deleted. All Departments and Employees have been removed.");
    }
}

// Department class that contains Employee objects (Composition)
 class Department {
    String name;
    ArrayList<Employee> employees;

    Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    // Adds an Employee to the Department
    void addEmployee(String employeeName) {
        Employee employee = new Employee(employeeName);
        employees.add(employee);
    }

    // Displays all Employees in the Department
    void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println("  Employee: " + emp.name);
        }
    }

    // Employee class defined within Department
    class Employee {
        String name;

        Employee(String name) {
            this.name = name;
        }
    }
}

// Main class to demonstrate the composition relationship
public class CompanyComposition {
    public static void main(String[] args) {
        // Create a Company
        Company company = new Company();

        // Create Departments and add Employees to them
        Department hr = new Department("Human Resources");
        hr.addEmployee("Ram");
        hr.addEmployee("Raj");

        Department it = new Department("IT");
        it.addEmployee("Arnav");
        it.addEmployee("Nikhil");

        // Add Departments to the Company
        company.addDepartment(hr);
        company.addDepartment(it);

        // Display the Company's structure
        company.displayCompanyStructure();

        // Delete the Company and all its associated Departments and Employees
        company.deleteCompany();
    }
}
