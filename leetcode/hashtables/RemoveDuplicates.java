package leetcode.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        HashSet<Integer> myHashSet = new HashSet<>(myList);
        return new ArrayList<>(myHashSet);

    }

    public static boolean hasUniqueChars(String string) {
        List<Character> charArr = new ArrayList<>();
        for (char c : string.toCharArray()) {
            charArr.add(c);
        }
        HashSet<Character> myHash = new HashSet<>(charArr);
        return (charArr.size() == myHash.size());
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> returnList = new ArrayList<>();
        HashSet<Integer> myHash = new HashSet<>();
        for (int i : arr1) {
            myHash.add(i);
        }
        
        for (int j : arr2) {
            int comp = target - j;
            if (myHash.contains(comp)) {
                returnList.add(new int[] {comp,j});
            }
        }
        return returnList;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> myHash = new HashSet<>();
        int consecutive = 0;

        for (int i : nums) {
            myHash.add(i);
        }

        for (int num : nums) {
            if (!myHash.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (myHash.contains(current + 1)) {
                    current += 1;
                    count += 1;
                }
                if (count > consecutive) {
                    consecutive = count;
                }
            }
        }

        return consecutive;
    }


    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]
            
        */
        
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longest = longestConsecutiveSequence(nums);
        System.out.println(longest);

        /*
            EXPECTED OUTPUT:
            ----------------
            4
            
        */
        
        
    }
    
}

