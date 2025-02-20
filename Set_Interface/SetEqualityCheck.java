import java.util.*;
public class SetEqualityCheck {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2){
        return set1.equals(set2);
    }
    public static void main(String []x){
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(1);

        System.out.println((areSetsEqual(set1, set2)));
    }
}