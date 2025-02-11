class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;
    public Student(int rollNumber,String name,int age,char grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}

class StudentLinkedList {
    private Student head;

    //Add student at beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    //Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    //Add Student at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position-1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    //Delete student by rollno
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Studen not found");
            return;
        }
        temp.next = temp.next.next;
    }

    //Search student by rollno
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not Found");
    }

    //Update student's grade
    public void updateGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated for " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    //Display all student records
    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + " | Name: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addAtBeginning(101, "Amit Kumar", 20, 'A');
        list.addAtEnd(102, "Riya Sharma", 21, 'B');
        list.addAtEnd(103, "Rajesh Gupta", 22, 'C');
        list.addAtPosition(2, 104, "Priya Singh", 19, 'A');

        System.out.println("All Student Records:");
        list.displayAll();

        System.out.println("\nSearching for Roll No 102:");
        list.searchByRollNumber(102);

        System.out.println("\nUpdating Grade for Roll No 103:");
        list.updateGrade(103, 'B');
        list.displayAll();

        System.out.println("\nDeleting Roll No 101:");
        list.deleteByRollNumber(102);
        list.displayAll();
    }
}