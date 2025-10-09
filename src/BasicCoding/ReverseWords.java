package BasicCoding;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {
    /***
     * Cho chuỗi s có thể có nhiều khoảng trắng thừa (ở đầu, giữa, cuối).
     * Mỗi từ là dãy ký tự không chứa khoảng trắng.
     * Mục tiêu: đảo ngược thứ tự các từ (không phải ký tự), và đảm bảo chỉ còn một khoảng trắng giữa các từ, không có khoảng trắng đầu/cuối.
     */

    public String reverseWords(String s) {
        // Step 1: Trim and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        // Step 2: Reverse the array
        Collections.reverse(Arrays.asList(words));
        // Step 3: Join with a single space
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();

        System.out.println(sol.reverseWords("the sky is blue"));       // "blue is sky the"
        System.out.println(sol.reverseWords("  hello world  "));       // "world hello"
        System.out.println(sol.reverseWords("a good   example"));      // "example good a"
    }
}
