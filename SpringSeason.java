public class SpringSeason {
    public static boolean isSpringSeason(int month,int day) {
        if (month==3&&day>=20&&day<=31) {
            return true;
        } else if (month==4&&day>=1&&day<=30) {
            return true;
        } else if (month==5&&day>=1&&day<=31) {
            return true;
        } else if (month==6&&day>=1&&day<=20) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length!=2) {
            System.out.println("Please provide the month and day as command-line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month,day)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }
}
