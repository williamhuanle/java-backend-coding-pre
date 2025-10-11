package ProblemSolving;

public class BestTimeToBuySellStock {

    /**
     * Bài toán yêu cầu bạn tìm ra lợi nhuận tối đa có thể kiếm được từ việc mua và bán cổ phiếu một lần duy nhất.
     *
     * Đầu vào: Một mảng prices, trong đó prices[i] là giá cổ phiếu vào ngày thứ i.
     *
     * Quy tắc:
     *
     * Bạn chỉ được thực hiện một giao dịch duy nhất (tức là mua 1 lần và bán 1 lần).
     *
     * Bạn phải mua trước khi bán. Điều này có nghĩa là ngày bán phải ở sau ngày mua.
     *
     * Đầu ra: Lợi nhuận lớn nhất có thể. Nếu không thể tạo ra lợi nhuận (giá chỉ toàn giảm), hãy trả về 0.
     *
     * Ví dụ: Với prices = [7, 1, 5, 3, 6, 4]:
     *
     * Mua ở mức giá thấp nhất là 1 (ngày 2).
     *
     * Bán ở mức giá cao nhất sau đó là 6 (ngày 5).
     *
     * Lợi nhuận tối đa = 6 - 1 = 5.
     *
     *
     * Cách tiếp cận tối ưu (O(n)):
     *
     * Duyệt qua từng giá price[i]
     *
     * Luôn lưu giá thấp nhất từng thấy (minPrice)
     *
     * Với mỗi ngày, tính profit = price[i] - minPrice
     *
     * Cập nhật maxProfit nếu profit > maxProfit
     *
     * Tư duy như “tối ưu hóa động” (dynamic tracking):
     *
     * Mua ở giá thấp nhất đến thời điểm hiện tại
     *
     * Bán ở giá hiện tại nếu có lời cao hơn
     *
     */

    public static int maxProfit(int[] prices) {
        // Khởi tạo giá mua thấp nhất là một giá trị vô cùng lớn
        int minPrice = Integer.MAX_VALUE;

        // Khởi tạo lợi nhuận tối đa là 0
        int maxProfit = 0;

        // Duyệt qua mảng giá
        for (int price : prices) {
            // 1. Kiểm tra xem hôm nay có phải là ngày có giá mua tốt hơn không
            if (price < minPrice) {
                // Nếu đúng, cập nhật giá mua thấp nhất
                minPrice = price;
            }
            // 2. Ngược lại giá hôm nay cao hơn giá thấp nhất
            else {
                // tinh thử lợi nhuận nếu bán vào hôm nay
                int profit = price - minPrice;
                // Nếu lợi nhuận cao hơn trước đó thì cập nhật
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};

        System.out.println(maxProfit(prices1)); // ✅ Output: 5
        System.out.println(maxProfit(prices2)); // ✅ Output: 0
    }
}
