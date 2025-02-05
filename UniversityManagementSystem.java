import java.util.ArrayList;

// Student class representing a student who enrolls in courses
class Student {
    String name;
    ArrayList<Course> courses; // Association: Student enrolls in multiple Courses

    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Method to enroll in a course
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.courseName);
    }

    // View enrolled courses
    void viewCourses() {
        System.out.println(name + "'s Courses:");
        for (Course course : courses) {
            System.out.println(course.courseName);
        }
    }
}

// Professor class representing a professor who teaches courses
class Professor {
    String name;
    ArrayList<Course> courses; // Association: Professor teaches multiple Courses

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Method to assign a professor to a course
    void assignProfessor(Course course) {
        courses.add(course);
        course.setProfessor(this);
        System.out.println("Professor " + name + " is assigned to " + course.courseName);
    }

    // View courses taught by the professor
    void viewCourses() {
        System.out.println("Courses taught by Professor " + name + ":");
        for (Course course : courses) {
            System.out.println(course.courseName);
        }
    }
}

// Course class representing a course that students enroll in and professors teach
class Course {
    String courseName;
    Professor professor;
    ArrayList<Student> students; // Aggregation: Course contains multiple Students

    Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Method to set a professor for the course
    void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Method to add a student to the course
    void addStudent(Student student) {
        students.add(student);
    }

    // View students enrolled in the course
    void viewStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

// Main class to demonstrate the relationships
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create Students
        Student rahul = new Student("Rahul Verma");
        Student sneha = new Student("Sneha Iyer");

        // Create Professors
        Professor drSharma = new Professor("Dr. Amit Sharma");
        Professor drPatel = new Professor("Dr. Nisha Patel");

        // Create Courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        // Assign Professors to Courses
        drSharma.assignProfessor(math);
        drPatel.assignProfessor(cs);

        // Students enroll in Courses
        rahul.enrollCourse(math);
        rahul.enrollCourse(cs);
        sneha.enrollCourse(cs);

        // View professor courses
        drSharma.viewCourses();
        drPatel.viewCourses();

        // View student courses
        rahul.viewCourses();
        sneha.viewCourses();

        // View students enrolled in courses
        math.viewStudents();
        cs.viewStudents();
    }
}
