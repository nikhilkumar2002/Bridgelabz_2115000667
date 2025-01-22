import java.util.Scanner;
public class Total_Price {
    public static void main(String[] args) {
        double unitPrice, quantity;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the unit price of the item: ");
        unitPrice=input.nextDouble();
        System.out.print("Enter the quantity to be bought: ");
        quantity=input.nextDouble();
        double totalPrice=unitPrice*quantity;
        System.out.println("The total purchase price is INR "+totalPrice+" if the quantity "+quantity + " and unit price is INR " + unitPrice);
    }
}