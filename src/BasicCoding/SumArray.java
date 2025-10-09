package BasicCoding;

public class SumArray {

    public int sumArray(int[] nums) {
        if (nums == null) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumArray sol = new SumArray();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sol.sumArray(nums)); // Output: 15
    }
}
