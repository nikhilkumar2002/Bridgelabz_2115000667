import java.util.Random;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        int employees = 10;
        double[][] employeeData = new double[employees][2];
        double[][] newEmployeeData = new double[employees][2];

        generateEmployeeData(employeeData);
        calculateNewSalaryAndBonus(employeeData, newEmployeeData);
        displayResults(employeeData, newEmployeeData);
    }

    public static void generateEmployeeData(double[][] data) {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i][0] = 10000 + rand.nextInt(90000);
            data[i][1] = rand.nextInt(11);
        }
    }

    public static void calculateNewSalaryAndBonus(double[][] oldData, double[][] newData) {
        for (int i = 0; i < oldData.length; i++) {
            double salary = oldData[i][0];
            double years = oldData[i][1];
            double bonus = (years > 5) ? 0.05 * salary : 0.02 * salary;
            newData[i][0] = salary + bonus;
            newData[i][1] = bonus;
        }
    }

    public static void displayResults(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("ID Old Salary Years of Service Bonus New Salary Bonus %");
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            double years = oldData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];
            double bonusPercent = (years > 5) ? 5 : 2;

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.println((i + 1) + " " + oldSalary + " " + years + " " + bonus + " " + newSalary + " " + bonusPercent);
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Total " + totalOldSalary + " " + totalBonus + " " + totalNewSalary);
    }
}
