package leetcode.hashtables;

import java.util.*;

public class NonRepeatingChar {
    
    public static Character firstNonRepeatingChar(String input) {
        HashMap<Character, Integer> myHash = new HashMap<>();
        char[] chars = input.toCharArray();
        for (char i : chars) {
            if (myHash.get(i) == null) {
                myHash.put(i, 1);
            }
            else {
                int val = myHash.get(i);
                val += 1;
                myHash.put(i,val);
            }
        }

        for (char j : chars) {
            if (myHash.get(j) == 1) {
                return j;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));
        
        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */
        
    }
    
}
