public class QuadraticEquationSolver {

    public static double[] findRoots(double a,double b,double c) {
        double delta = b*b-4*a*c;

        if(delta<0){
            return new double[0];
        }

        if(delta==0){
            double root = -b/(2*a);
            return new double[]{root};
        }

        double root1 = (-b+Math.sqrt(delta))/(2*a);
        double root2 = (-b-Math.sqrt(delta))/(2*a);
        return new double[]{root1,root2};
    }

    public static void main(String[] args) {
        double a = 1;
        double b = -3;
        double c = 2;

        double[] roots = findRoots(a,b,c);

        if(roots.length==0){
            System.out.println("No real roots.");
        }else if(roots.length==1){
            System.out.println("The root is: "+roots[0]);
        }else{
            System.out.println("The roots are: "+roots[0]+" and "+roots[1]);
        }
    }
}
