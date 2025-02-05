import java.util.ArrayList;

// School class representing a school that aggregates Student objects
class School {
    String schoolName;
    ArrayList<Student> students; // Aggregation: School has Students

    School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Method to add a student to the school
    void addStudent(Student student) {
        students.add(student);
    }

    // Method to display all students in the school
    void displayStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

// Student class representing a student who can enroll in multiple courses
class Student {
    String name;
    ArrayList<Course> courses; // Association: Student enrolls in Courses

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Enroll in a course and add the student to the course's list of enrolled students
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    // Method to view the courses the student is enrolled in
    void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println(c.courseName);
        }
    }
}

// Course class representing a course that can have multiple students enrolled
class Course {
    String courseName;
    ArrayList<Student> students; // Association: Course has many Students

    Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Add a student to the course's list of enrolled students
    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Method to view the students enrolled in this course
    void viewStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

// Main class to demonstrate the association and aggregation relationships
public class SchoolAssociationAggregation {
    public static void main(String[] args) {
        // Create a School object (Aggregation with Students)
        School school = new School("Central High School");

        // Create Student objects
        Student Nikhil = new Student("Nikhil");
        Student Raj = new Student("Raj");

        // Add students to the school
        school.addStudent(Nikhil);
        school.addStudent(Raj);

        // Create Course objects
        Course math = new Course("Mathematics");
        Course english = new Course("English");
        Course science = new Course("Science");

        // Students enroll in courses (Association between Student and Course)
        Nikhil.enrollCourse(math);
        Nikhil.enrollCourse(english);
        Raj.enrollCourse(english);
        Raj.enrollCourse(science);

        // Demonstrate that a student can view the courses they are enrolled in
        Nikhil.viewCourses();
        Raj.viewCourses();

        // Demonstrate that a course can show its enrolled students
        math.viewStudents();
        english.viewStudents();
        science.viewStudents();
    }
}
