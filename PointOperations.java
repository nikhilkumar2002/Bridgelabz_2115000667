public class PointOperations {
    public static double calculateDistance(double x1,double y1,double x2,double y2) {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

    public static double[] findLineEquation(double x1,double y1,double x2,double y2) {
        double slope=(y2-y1)/(x2-x1);
        double yIntercept=y1-(slope*x1);
        return new double[]{slope,yIntercept};
    }

    public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1=sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1=sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2=sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2=sc.nextDouble();

        double distance=calculateDistance(x1,y1,x2,y2);
        System.out.printf("The Euclidean distance between the points is: %.2f\n",distance);

        if(x1!=x2) {
            double[] lineEquation=findLineEquation(x1,y1,x2,y2);
            System.out.printf("The equation of the line is: y = %.2f*x + %.2f\n",lineEquation[0],lineEquation[1]);
        } else {
            System.out.println("The line is vertical, equation is: x = "+x1);
        }
    }
}
