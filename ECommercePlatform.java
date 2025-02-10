import java.util.ArrayList;
import java.util.List;
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private static final double TAX_RATE = 0.18;
    private static final double DISCOUNT_RATE = 0.10;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    public String getTaxDetails() {
        return "Electronics Tax: " + calculateTax();
    }
}

class Clothing extends Product implements Taxable {
    private static final double TAX_RATE = 0.05;
    private static final double DISCOUNT_RATE = 0.15;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    public String getTaxDetails() {
        return "Clothing Tax: " + calculateTax();
    }
}

class Groceries extends Product {
    private static final double DISCOUNT_RATE = 0.05;

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 50000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 1000));

        for (Product product : products) {
            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount: " + product.calculateDiscount());
            double finalPrice = product.getPrice() - product.calculateDiscount();
            if (product instanceof Taxable) {
                finalPrice += ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------");
        }
    }
}
