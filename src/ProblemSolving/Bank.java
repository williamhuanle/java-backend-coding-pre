package ProblemSolving;

public class Bank {

    // Mảng để lưu trữ số dư của các tài khoản.
    // Dùng long vì số dư có thể rất lớn.
    private long[] accountBalances;

    // Tổng số lượng tài khoản
    private int numberOfAccounts;

    /**
     * Yêu cầu
     *
     * Viết class Bank mô phỏng các giao dịch ngân hàng cơ bản với ba chức năng chính:
     *
     * withdraw(account, money) — rút tiền
     * deposit(account, money) — nạp tiền
     * transfer(account1, account2, money) — chuyển tiền giữa hai tài khoản
     *
     * Mỗi tài khoản được lưu trong một mảng balance[], trong đó:
     * balance[i] là số dư của tài khoản i+1
     * n = balance.length là tổng số tài khoản
     */

    public Bank(long[] balance) {
        this.accountBalances = balance;
        this.numberOfAccounts = balance.length;
    }

    /**
     * Hàm tiện ích để kiểm tra một số tài khoản có hợp lệ hay không.
     * @param account Số tài khoản = index cua balance + 1.
     * @return true nếu hợp lệ, false nếu không.
     */
    private boolean isValidAccount(int account) {
        return account >= 1 && account <= this.numberOfAccounts;
    }

    //Chuyển tiền từ account1 đến account2
    public boolean transfer(int account1, int account2, long money) {
        //Kiểm tra tài khoản tồn tại
        if(!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }

        //Kiểm tra đủ tiền
        int balanceIndexAcc1 = account1 - 1; // Chuyển sang index của mảng (bắt đầu từ 0)
        if(accountBalances[balanceIndexAcc1] < money) {
            return false;
        }
        //Trừ tiền từ account1
        accountBalances[balanceIndexAcc1] = accountBalances[balanceIndexAcc1] - money;
        //Cộng tiền vào account2
        int balanceIndexAcc2 = account2 - 1; // Chuyển sang index của mảng (bắt đầu từ 0)
        accountBalances[balanceIndexAcc2] = accountBalances[balanceIndexAcc2] + money;
        return true;
    }

    //Gửi tiền vào account
    public boolean deposit(int account, long money) {
        //Kiểm tra tài khoản tồn tại
        if(!isValidAccount(account)) {
            return false;
        }
        //Cộng thêm vào balance
        int balanceIndex = account - 1; // Chuyển sang index của mảng (bắt đầu từ 0)
        accountBalances[balanceIndex] += money;

        return true;
    }

    //Rút tiền từ account
    public boolean withdraw(int account, long money) {
        //Kiểm tra tài khoản tồn tại
        if(!isValidAccount(account)) {
            return false;
        }
        //Kiểm tra đủ tiền
        int balanceIndex = account - 1; // Chuyển sang index của mảng (bắt đầu từ 0)
        if(accountBalances[balanceIndex] < money) {
            return false;
        }
        //Trừ số tiền tương ứng
        accountBalances[balanceIndex] -= money;

        return true;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});

        System.out.println(bank.withdraw(3, 10));  // ✅ true
        System.out.println(bank.transfer(5, 1, 20)); // ✅ true
        System.out.println(bank.deposit(5, 20));     // ✅ true
        System.out.println(bank.transfer(3, 4, 15)); // ❌ false
        System.out.println(bank.withdraw(10, 50));   // ❌ false
    }
}
