package BasicCoding;

public class ReverseKString {
    /**
     * Cho chuỗi s và số nguyên k:
     *
     * Mỗi đoạn 2k ký tự, bạn cần:
     *
     * Đảo ngược k ký tự đầu tiên.
     *
     * Giữ nguyên k ký tự còn lại.
     *
     * Nếu còn ít hơn k ký tự, đảo hết.
     *
     * Nếu từ k đến dưới 2k, đảo k đầu, giữ phần còn lại.
     */

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) { // Bước nhảy 2k, Dùng vòng lặp for với bước nhảy 2k (mỗi vòng xử lý 1 block 2k).
            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1); // Xác định vị trí right là i + k - 1 hoặc cuối chuỗi nếu còn ít hơn k ký tự.

            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp; // Hoán đổi ký tự tại vị trí left và right.
                left++;
                right--;
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseKString sol = new ReverseKString();

        System.out.println(sol.reverseStr("abcdefg", 2)); // Output: "bacdfeg"
        System.out.println(sol.reverseStr("abcd", 2));    // Output: "bacd"
    }
}
