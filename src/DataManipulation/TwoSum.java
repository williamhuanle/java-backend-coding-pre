package DataManipulation;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Cho một mảng số nguyên nums và một số nguyên target.
     * Hãy tìm hai phần tử trong mảng sao cho tổng của chúng bằng target,
     * và trả về chỉ số (index) của hai phần tử đó.
     *
     * Giả sử mỗi input có đúng một cặp lời giải,
     * và bạn không được sử dụng cùng một phần tử hai lần.
     *
     * | Input                              | Output  | Giải thích                      |
     * | ---------------------------------- | ------- | ------------------------------- |
     * | `nums = [2,7,11,15]`, `target = 9` | `[0,1]` | `nums[0] + nums[1] = 2 + 7 = 9` |
     * | `nums = [3,2,4]`, `target = 6`     | `[1,2]` | `2 + 4 = 6`                     |
     * | `nums = [3,3]`, `target = 6`       | `[0,1]` | `3 + 3 = 6`                     |
     *
     */

    public int[] twoSum(int[] nums, int target) {
        // Sử dụng một bảng băm (hash map) để lưu trữ các phần tử đã duyệt
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Tính phần bù cần tìm

            // Kiểm tra nếu phần bù đã có trong bảng băm
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i}; // Trả về chỉ số của hai phần tử
            }

            // Nếu chưa tìm thấy, thêm phần tử hiện tại vào bảng băm
            numToIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution"); // Ném ngoại lệ nếu không tìm thấy lời giải
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum sol = new TwoSum();
        int[] result = sol.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]"); // Output: Indices: [0, 1]
    }
}
