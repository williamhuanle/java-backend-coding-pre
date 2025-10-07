package BasicCoding;

public class PalindromeCheck {

    /**
     * Palindrome Number (LeetCode #9)
     *
     * Given an integer x, return true if x is a palindrome, and false otherwise.
     *
     * An integer is a palindrome when it reads the same backward as forward.
     *
     *
     *
     * | Input  | Output  | Giải thích                   |
     * | ------ | ------- | ---------------------------- |
     * | `121`  | `true`  | Đọc xuôi và ngược đều là 121 |
     * | `-121` | `false` | Dấu âm khiến không đối xứng  |
     * | `10`   | `false` | Đọc ngược là 01              |
     */

    public boolean isPalindrome(int x) {
// Số âm hoặc kết thúc bằng 0 (trừ số 0) không thể là palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Đảo ngược một nửa của số
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // So sánh phần đầu và phần đảo ngược
        // Trường hợp lẻ chữ số: bỏ chữ số giữa (reversedHalf / 10)
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }

    public static void main(String[] args) {
        PalindromeCheck sol = new PalindromeCheck();
        System.out.println(sol.isPalindrome(121));   // true
        System.out.println(sol.isPalindrome(-121));  // false
        System.out.println(sol.isPalindrome(10));    // false
        System.out.println(sol.isPalindrome(1221));  // true
    }
}
