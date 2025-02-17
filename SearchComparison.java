import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Different dataset sizes
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            // Fill array with random numbers
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }
            Arrays.sort(data); // Sorting for Binary Search

            int target = data[random.nextInt(size)]; // Pick a random target

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            // Measure Binary Search time (manual implementation)
            startTime = System.nanoTime();
            binarySearch(data,target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime / 1_000_000.0) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }
    //Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    //Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }
}
