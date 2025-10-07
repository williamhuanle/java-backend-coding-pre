package BasicCoding;

public class ReverseInteger {

    /**
     * Given a signed 32-bit integer x, return its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range
     * [-2³¹, 2³¹ - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     * | Input        | Output | Giải thích                                     |
     * | ------------ | ------ | ---------------------------------------------- |
     * | `123`        | `321`  | Số đảo ngược của 123 là 321                    |
     * | `-123`       | `-321` | Dấu âm giữ nguyên                              |
     * | `120`        | `21`   | Bỏ số 0 ở đầu                                  |
     * | `1534236469` | `0`    | Vượt quá giới hạn 32-bit integer, nên trả về 0 |
     */

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int lastDigit = x % 10; // Lấy chữ số cuối (chia lấy dư)
            x /= 10; // Bỏ chữ số cuối

            // Kiểm tra tràn số dương
            /**
             *
             * | Tên hằng            | Giá trị        |
             * | ------------------- | -------------- |
             * | `Integer.MAX_VALUE` | 2,147,483,647  |
             * | `Integer.MIN_VALUE` | -2,147,483,648 |
             *
             * Tức là rev > 214748364
             * Nếu rev lớn hơn giá trị này, thì rev * 10 chắc chắn vượt quá 2,147,483,647, dù lastDigit = 0.
             *
             * Trường hợp rev đang bằng 214748364.
             * Nếu thêm lastDigit lớn hơn 7, ví dụ 8 hoặc 9, thì
             * rev * 10 + lastDigit > 2147483647 → tràn.
             * Số 7 ở đây là chữ số cuối của Integer.MAX_VALUE (2147483647).
             */
            if (rev > Integer.MAX_VALUE / 10 ||
                    (rev == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }

            // Kiểm tra tràn số âm
            /**
             * Integer.MIN_VALUE = -2147483648 → chữ số cuối là -8.
             * Nếu thêm lastDigit nhỏ hơn -8 (tức -9), sẽ vượt quá giới hạn âm.
             */
            if (rev < Integer.MIN_VALUE / 10 ||
                    (rev == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            rev = rev * 10 + lastDigit;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        System.out.println(sol.reverse(123));       // 321
        System.out.println(sol.reverse(-123));      // -321
        System.out.println(sol.reverse(120));       // 21
        System.out.println(sol.reverse(1534236469)); // 0 (overflow)
        System.out.println(sol.reverse(Integer.MAX_VALUE)); // 0 (overflow)
        System.out.println(sol.reverse(Integer.MIN_VALUE)); // 0 (overflow)
    }
}
