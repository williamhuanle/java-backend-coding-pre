package BasicCoding;

public class ReverseString {

    /**
     *
     *Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     *
     * Tóm tắt yêu cầu
     * Viết hàm đảo ngược chuỗi (reverse string) được cho dưới dạng mảng ký tự char[], thực hiện in-place (nghĩa là không được tạo mảng phụ).
     *
     * Input: s = ['h','e','l','l','o']
     * Output: ['o','l','l','e','h']
     * Chỉ được dùng O(1) bộ nhớ phụ → nghĩa là chỉ dùng vài biến tạm, không mảng mới.
     *
     * Chiến lược giải
     * Dùng two-pointer technique:
     *
     * Khởi tạo left = 0 và right = s.length - 1.
     * Khi left < right, hoán đổi s[left] và s[right].
     * Di chuyển left++, right--.
     *
     * Kết thúc khi hai con trỏ gặp nhau hoặc vượt nhau.
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // swap characters
            char temp = s[left];
            s[left] = s[right]; // gán s[left] = s[right] trước để tránh mất giá trị
            s[right] = temp;    // gán s[right] = temp sau = s[left] ban đầu

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString sol = new ReverseString();
        char[] s1 = {'h','e','l','l','o'};
        sol.reverseString(s1);
        System.out.println(java.util.Arrays.toString(s1)); // [o, l, l, e, h]

        char[] s2 = {'H','a','n','n','a','h'};
        sol.reverseString(s2);
        System.out.println(java.util.Arrays.toString(s2)); // [h, a, n, n, a, H]
    }
}
