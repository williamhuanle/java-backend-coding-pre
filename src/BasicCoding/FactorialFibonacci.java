package BasicCoding;

import java.math.BigInteger;

public class FactorialFibonacci {

    // ---------------- Factorial ----------------
    /**
     * Tính n! dưới dạng long. Chỉ an toàn cho n <= 20.
     * @throws IllegalArgumentException nếu n < 0 hoặc n > 20 (overflow)
     */
    public static long factorialIterativeLong(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n > 20) throw new IllegalArgumentException("overflow for long: n must be <= 20");
        long res = 1L;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    /**
     * Factorial (n!)
     * Input: một số nguyên không âm n.
     * Output: n! (giai thừa).
     * Lưu ý: giai thừa tăng rất nhanh → long chỉ đủ tới 20!. Nếu cần giá trị lớn hơn, phải dùng BigInteger.
     */
    public static BigInteger factorialBigInteger(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Fibonacci (F(n))
     * Input: một số nguyên không âm n.
     *
     * Output: F(n) theo dãy Fibonacci (F(0)=0, F(1)=1).
     *
     * Lưu ý: long đủ tới F(92). Nếu cần n lớn hơn, phải dùng BigInteger.
     *
     * Triển khai cả:
     *
     * Cách đơn giản (iterative O(n))
     *
     * Cách nhanh (fast doubling O(log n)) để xử lý n rất lớn.
     */
    public static long fibonacci(int n) {
        if (n <= 1) return n;

        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // ---------------- Fibonacci ----------------

    /**
     * Fibonacci iterative trả long. Chỉ an toàn cho n <= 92.
     *
     * F(0)=0
     * F(1)=1
     * F(n)=F(n−1)+F(n−2) khi n>=2
     *
     * */
    public static long fibonacciIterativeLong(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0L; // F(0)
        if (n == 1) return 1L; // F(1)
        if (n > 92) throw new IllegalArgumentException("overflow for long: n must be <= 92");
        long a = 0L; // F(0)
        long b = 1L; // F(1)
        long c = 0L; // F(n)
        for (int i = 2; i <= n; i++) {
            c = b + a; // F(n) = F(n-1) + F(n-2)
            a = b; // F(n-2)
            b = c; // F(n-1)
        }
        return c;
    }

    /**
     * Fibonacci iterative dùng BigInteger: O(n).
     */
    public static BigInteger fibonacciIterativeBigInteger(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        FactorialFibonacci factorialFibonacci = new FactorialFibonacci();
        // Factorial tests
        System.out.println("Factorial (long): 5! = " + factorialFibonacci.factorialIterativeLong(2)); // 120
        System.out.println("Factorial (BigInteger): 50! = " + factorialFibonacci.factorialBigInteger(50));

        // Fibonacci tests (long)
        System.out.println("Fibonacci (long): F(10) = " + fibonacciIterativeLong(10)); // 55
        // Fibonacci tests (BigInteger)
        System.out.println("Fibonacci (BigInteger): F(100) = " + fibonacciIterativeBigInteger(100));
    }
}
