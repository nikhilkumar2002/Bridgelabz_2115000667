import java.util.Scanner;
public class MultiDimensionalArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows=sc.nextInt();
        System.out.println("Enter the number of columns:");
        int columns=sc.nextInt();
        int[][] matrix=new int[rows][columns];
        System.out.println("Enter the elements of the matrix:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print("Element ["+i+"]["+j+"]: ");
                matrix[i][j]=sc.nextInt();
            }
        }
        int[] array=new int[rows*columns];
        int index=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                array[index++]=matrix[i][j];
            }
        }
        System.out.println("The 1D array is:");
        for(int element:array)System.out.print(element+" ");
    }
}