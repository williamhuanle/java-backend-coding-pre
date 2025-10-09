package BasicCoding;

public class PalindromeString {

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

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeString sol = new PalindromeString();
        System.out.println(sol.isPalindrome("abcdcba"));   // true
        System.out.println(sol.isPalindrome("-abcdcba"));  // false
        System.out.println(sol.isPalindrome("abcdcb"));    // false
        System.out.println(sol.isPalindrome("abccba"));  // true
    }
}
