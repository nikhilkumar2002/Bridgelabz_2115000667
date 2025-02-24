import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

// Step 2: Create a class with a computationally expensive method
class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for: " + n);
            return cache.get(n);
        }

        System.out.println("Computing factorial for: " + n);
        int result = (n <= 1) ? 1 : n * computeFactorial(n - 1);
        cache.put(n, result);
        return result;
    }
}

// Step 3: Test caching mechanism
public class CacheResultExample {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println(computation.computeFactorial(5)); // Computation
        System.out.println(computation.computeFactorial(5)); // Cached result
        System.out.println(computation.computeFactorial(6)); // Partial computation, 5! is cached
    }
}