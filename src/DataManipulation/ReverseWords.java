package DataManipulation;

public class ReverseWords {

    /**
     * trim() loại bỏ khoảng trắng thừa ở đầu/cuối.
     *
     * split("\\s+") tách chuỗi theo một hoặc nhiều khoảng trắng liên tiếp.
     * (regex \\s+ = 1 hoặc nhiều ký tự khoảng trắng).
     *
     */
    public static String reverseWords(String s) {
        // Bước 1: Xóa khoảng trắng đầu/cuối và tách chuỗi thành các từ
        String[] words = s.trim().split("\\s+");

        // Bước 2: Đảo ngược thứ tự các từ
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" ");
        }

        // Bước 3: Trả về chuỗi đã đảo ngược
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.println(reverseWords(input)); // Output: blue is sky the
    }
}
