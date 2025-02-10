import java.util.ArrayList;
import java.util.List;
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private static final double DAILY_CHARGE = 5000;
    private int daysAdmitted;
    private String medicalHistory = "";

    public InPatient(int patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    public double calculateBill() {
        return daysAdmitted * DAILY_CHARGE;
    }

    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    public String viewRecords() {
        return medicalHistory;
    }
}

class OutPatient extends Patient {
    private static final double CONSULTATION_FEE = 1000;

    public OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    public double calculateBill() {
        return CONSULTATION_FEE;
    }
}


public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient(101, "Arnav", 45, 3);
        ip.addRecord("Admitted for surgery");
        ip.addRecord("Recovery in progress");

        patients.add(ip);
        patients.add(new OutPatient(102, "Nikhil", 30));

        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
            System.out.println("Total Bill: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                System.out.println("Medical Records:\n" + ((MedicalRecord) patient).viewRecords());
            }
            System.out.println("--------------------");
        }
    }
}
