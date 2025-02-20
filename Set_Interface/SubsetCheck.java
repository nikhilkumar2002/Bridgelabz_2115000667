import java.util.*;
public class SubsetCheck {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> superset){
        return superset.containsAll(subset);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println(isSubset(set1, set2));
    }
}
