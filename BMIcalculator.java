import java.util.Scanner;

public class BMIcalculator {

    public static void calculateBMI(double[][] data) {
        for(int i=0;i<10;i++){
            double heightInMeters = data[i][1]/100;
            data[i][2] = data[i][0]/(heightInMeters*heightInMeters);
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[10];
        for(int i=0;i<10;i++){
            double bmi = data[i][2];
            if(bmi<18.5){
                status[i] = "Underweight";
            }else if(bmi>=18.5&&bmi<24.9){
                status[i] = "Normal weight";
            }else if(bmi>=25&&bmi<29.9){
                status[i] = "Overweight";
            }else{
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];

        for(int i=0;i<10;i++){
            System.out.print("Enter weight (kg) of person "+(i+1)+": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person "+(i+1)+": ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);

        String[] status = determineBMIStatus(data);

        System.out.println("\nBMI Calculation Results:");
        for(int i=0;i<10;i++){
            System.out.println("Person "+(i+1)+":");
            System.out.println("Weight: "+data[i][0]+" kg");
            System.out.println("Height: "+data[i][1]+" cm");
            System.out.println("BMI: "+String.format("%.2f",data[i][2]));
            System.out.println("Status: "+status[i]);
            System.out.println();
        }
    }
}
