package implement;
import java.util.*;

public class MapImplement {

    public static void main(String[] args) {
        // HashMap
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Steve");
        hm.put(2, "Peter");
        hm.put(3, "Gates");

        System.out.println("\nThe elements of HashMap are: ");
        for (Map.Entry<Integer, String> m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        // HashTable
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

        ht.put(4, "Jr.");
        ht.put(5, "Downey");
        ht.put(6, "Robert");

        System.out.println("\nThe elements of HashTable are: ");
        for (Map.Entry<Integer, String> n : ht.entrySet()) {
            System.out.println(n.getKey() + " " + n.getValue());
        }

        // TreeMap
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(7, "Annie");
        map.put(8, "Carlotte");
        map.put(9, "Catie");
        map.put(10, "Paul");

        System.out.println("\nThe elements of TreeMap are: ");
        for (Map.Entry<Integer, String> l : map.entrySet()) {
            System.out.println(l.getKey() + " " + l.getValue());
        }
    }
}
