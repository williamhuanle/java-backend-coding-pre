package BasicCoding;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Problem:
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * Example:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum sol = new TwoSum();
        int[] result = sol.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
