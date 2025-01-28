public class RandomNumberStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int)(Math.random()*9000)+1000;
        }
        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        double average = sum/numbers.length;

        return new double[] {average,min,max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);

        double[] results = findAverageMinMax(randomNumbers);

        System.out.println("Generated Random 4-digit Numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }

        System.out.println("\nAverage: "+results[0]);
        System.out.println("Minimum: "+results[1]);
        System.out.println("Maximum: "+results[2]);
    }
}
