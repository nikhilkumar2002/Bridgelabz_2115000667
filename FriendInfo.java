import java.util.Scanner;

public class FriendInfo {

    public static String findYoungest(int[] ages) {
        int youngestAge = ages[0];
        String youngestFriend = "Amar";

        if(ages[1]<youngestAge){
            youngestAge = ages[1];
            youngestFriend = "Akbar";
        }
        if(ages[2]<youngestAge){
            youngestAge = ages[2];
            youngestFriend = "Anthony";
        }

        return youngestFriend;
    }

    public static String findTallest(double[] heights) {
        double tallestHeight = heights[0];
        String tallestFriend = "Amar";

        if(heights[1]>tallestHeight){
            tallestHeight = heights[1];
            tallestFriend = "Akbar";
        }
        if(heights[2]>tallestHeight){
            tallestHeight = heights[2];
            tallestFriend = "Anthony";
        }

        return tallestFriend;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.print("Enter age of Amar: ");
        ages[0] = sc.nextInt();
        System.out.print("Enter height of Amar (in meters): ");
        heights[0] = sc.nextDouble();

        System.out.print("Enter age of Akbar: ");
        ages[1] = sc.nextInt();
        System.out.print("Enter height of Akbar (in meters): ");
        heights[1] = sc.nextDouble();

        System.out.print("Enter age of Anthony: ");
        ages[2] = sc.nextInt();
        System.out.print("Enter height of Anthony (in meters): ");
        heights[2] = sc.nextDouble();

        String youngest = findYoungest(ages);
        System.out.println("The youngest friend is: " + youngest);

        String tallest = findTallest(heights);
        System.out.println("The tallest friend is: " + tallest);
    }
}
