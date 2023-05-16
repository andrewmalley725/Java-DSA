package leetcode.hashtables;

public class SubarraySum {

    public static int[] subarraySum(int[] nums, int target) {
        int currentSum = 0;
        int start = 0;
        int stop = 0;
        if (nums.length == 0 || nums.length == 1) return new int[]{};
        for (int i = 0; i < nums.length - 1; i++) {
            start = i;
            stop = i + 1;
            currentSum = nums[start];
            if (currentSum != target) {
                while (stop < nums.length) {
                    currentSum += nums[stop];
                    if (currentSum == target) return new int[] {start, stop};
                    stop += 1;
                }
            }
            else if (currentSum == target) {
                return new int[] {start, start};
            }
        }
        return new int[]{};
    } 


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");
        
        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []
    
        */
        
    }

}
