package leetcode.hashtables;

import java.util.*;

//List<List<String>>
public class GroupAnagrams {
    
    public static List<List<String>> groupAnagrams(String[] array) {
        HashMap<String, Integer> myHashMap = new HashMap<>();
        List<List<String>> returnList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            char[] temp = array[i].toCharArray();
            Arrays.sort(temp);
            String sortedString = new String(temp);
            if (!myHashMap.containsKey(sortedString)) {
                myHashMap.put(sortedString, index);
                index++;
            }
        }

        for(int i = 0; i < myHashMap.size(); i++) {
            returnList.add(new ArrayList<>());
        }

        for (String i : array) {
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            String sortedString = new String(temp);
            returnList.get(myHashMap.get(sortedString)).add(i);
        }
        return returnList;
    }
    
    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */
        
    }
    
}
