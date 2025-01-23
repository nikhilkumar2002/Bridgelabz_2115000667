import java.util.Scanner;

class BMI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter weight in kilograms:");
        double weight=sc.nextDouble();
        System.out.println("Enter height in centimeters:");
        double height=sc.nextDouble()/100;// Convert height to meters
        double bmi=weight/(height * height);
        System.out.println("BMI: "+bmi);
        if (bmi<=18.4){
            System.out.println("Underweight");
        }
        else if(bmi<=24.9){
            System.out.println("Normal");
        }
        else if(bmi<=39.9){
            System.out.println("Overweight");
        }
        else {
            System.out.println("Obese");
        }
    }
}
