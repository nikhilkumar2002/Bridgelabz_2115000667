import java.util.*;
class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 12, 15};
        int target = 19;
        System.out.println("Pair with given sum exists: " + hasPairWithSum(nums, target));
    }
}
