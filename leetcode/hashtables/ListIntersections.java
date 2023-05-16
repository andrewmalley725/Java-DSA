package leetcode.hashtables;

import java.util.HashMap;

public class ListIntersections {

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHash = new HashMap<>();
        for (int i : array1) {
            myHash.put(i, true);
        }

        for (int j : array2) {
            if (myHash.get(j) != null) return true;
        }
        return false;
    }
    

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));
        
        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */
        
    }

}
