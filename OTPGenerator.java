import java.util.Scanner;

public class OTPGenerator {
    public static int generateOTP() {
        return (int)(Math.random()*900000)+100000;
    }
    public static boolean areOTPsUnique(int[] otps) {
        for(int i=0;i<otps.length;i++) {
            for(int j=i+1;j<otps.length;j++) {
                if(otps[i]==otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] otpArray = new int[10];
        for(int i=0;i<otpArray.length;i++) {
            otpArray[i]=generateOTP();
            System.out.println("Generated OTP "+(i+1)+": "+otpArray[i]);
        }
        boolean isUnique = areOTPsUnique(otpArray);
        if(isUnique) {
            System.out.println("\nAll OTPs are unique.");
        } else {
            System.out.println("\nSome OTPs are not unique.");
        }
    }
}
