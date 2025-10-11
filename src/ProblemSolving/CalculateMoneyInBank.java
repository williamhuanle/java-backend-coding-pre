package ProblemSolving;

public class CalculateMoneyInBank {

    /**
     * Diễn giải đề bài
     * Bài toán yêu cầu bạn tính tổng số tiền mà Hercy tiết kiệm được sau n ngày theo một quy tắc gửi tiền đặc biệt:
     *
     * Ngày đầu tiên (Thứ Hai): Anh ấy bắt đầu bằng cách gửi $1.
     *
     * Trong tuần (Thứ Ba - Chủ Nhật): Mỗi ngày, anh ấy gửi nhiều hơn ngày hôm trước $1.
     *
     * Các tuần tiếp theo: Vào mỗi ngày Thứ Hai, anh ấy sẽ gửi nhiều hơn $1 so với ngày Thứ Hai của tuần trước đó.
     *
     * Nói một cách đơn giản, quy luật gửi tiền theo tuần sẽ như sau:
     *
     * Tuần 1: $1, $2, $3, $4, $5, $6, $7
     *
     * Tuần 2: $2, $3, $4, $5, $6, $7, $8
     *
     * Tuần 3: $3, $4, $5, $6, $7, $8, $9
     *
     * ... và cứ thế tiếp tục.
     *
     * Mục tiêu: Tính tổng số tiền có trong ngân hàng sau n ngày.
     */

    public int totalMoney(int n) {
        // Biến để lưu tổng số tiền
        int total = 0;

        // Số tiền gửi vào ngày Thứ Hai của tuần hiện tại, bắt đầu là $1
        int mondayStartWithDeposit = 1;

        // Bắt đầu duyệt qua từng ngày từ ngày 1 đến ngày n
        for (int day = 1; day <= n; day++) {

            // Tính số ngày đã trôi qua trong tuần hiện tại (0 cho Thứ Hai, 1 cho Thứ Ba, ...)
            // (day - 1) % 7 sẽ cho kết quả từ 0 đến 6.
            int dayOfWeekOffset = (day - 1) % 7;

            // Số tiền gửi trong ngày = (tiền gửi ngày Thứ Hai của tuần) + (số ngày đã qua trong tuần)
            int dailyDeposit = mondayStartWithDeposit + dayOfWeekOffset * 1;
            //dailyDeposit = mondayStartWithDeposit + (dayOfWeekOffset * 5);

            // Cộng vào tổng số tiền
            total += dailyDeposit;

            // Nếu hôm nay là Chủ Nhật (kết thúc một tuần),
            // thì tăng số tiền gửi cho ngày Thứ Hai của tuần kế tiếp lên 1.
            if (day % 7 == 0) {
                mondayStartWithDeposit++;
            }
        }

        return total;
    }

    // --- Ví dụ kiểm thử ---
    public static void main(String[] args) {
        CalculateMoneyInBank sol = new CalculateMoneyInBank();
        System.out.println("n = 4 -> Total: " + sol.totalMoney(4));   // Output: 10
        System.out.println("n = 10 -> Total: " + sol.totalMoney(10)); // Output: 37
        System.out.println("n = 20 -> Total: " + sol.totalMoney(20)); // Output: 96
    }
}
