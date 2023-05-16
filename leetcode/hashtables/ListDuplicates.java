package leetcode.hashtables;
import java.util.*;


public class ListDuplicates {

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Boolean> myHash = new HashMap<>();
        List<Integer> returnList = new ArrayList<>();
        for (int i:nums) {
            if (myHash.get(i) != null) {
                returnList.add(i);
            }
            else {
                myHash.put(i, true);
            }
        }
        return returnList;
    }
      

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates); 
        
        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
        
    }

}

