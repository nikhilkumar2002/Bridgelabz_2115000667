import java.util.ArrayList;

// University class (Composition with Departments, Aggregation with Faculty)
class University {
    String name;
    ArrayList<Department> departments; // Composition: University owns Departments
    ArrayList<Faculty> facultyMembers; // Aggregation: University has Faculty members

    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    // Add a Department to the University (Composition)
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Add a Faculty member to the University (Aggregation)
    void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    // Display all Departments
    void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department d : departments) {
            System.out.println(d.name);
        }
    }

    // Display all Faculty members
    void displayFaculty() {
        System.out.println("Faculty members in " + name + ":");
        for (Faculty f : facultyMembers) {
            System.out.println(f.name);
        }
    }

    // Delete University: All Departments are deleted (Composition)
    void deleteUniversity() {
        departments.clear();
        System.out.println("University deleted. All Departments have been removed.");
    }
}

// Department class (Composition: Exists only within a University)
class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

// Faculty class (Aggregation: Exists independently of a University)
class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

// Main class to demonstrate the relationships
public class UniversityMain {
    public static void main(String[] args) {
        // Create a University
        University university = new University("Tech University");

        // Add Departments (Composition)
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Create Faculty members
        Faculty profAlice = new Faculty("Prof. Nikhil");
        Faculty profBob = new Faculty("Prof. Mudit");

        // Add Faculty members to the University (Aggregation)
        university.addFaculty(profAlice);
        university.addFaculty(profBob);

        // Display University details
        university.displayDepartments();
        university.displayFaculty();

        // Delete the University (removes all Departments but Faculty members exist)
        university.deleteUniversity();
    }
}
