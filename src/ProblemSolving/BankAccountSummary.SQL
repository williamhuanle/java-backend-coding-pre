--Write a solution to report the name and balance of users with a balance higher than 10000.
--The balance of an account is equal to the sum of the amounts of all transactions involving that account.

-- Table: Users
--   +--------------+---------+
--   | Column Name  | Type    |
--   +--------------+---------+
--   | account      | int     |
--   | name         | varchar |
--   +--------------+---------+
--   account is the primary key (column with unique values) for this table.
--   Each row of this table contains the account number of each user in the bank.
--   There will be no two users having the same name in the table.
--
--
--   Table: Transactions
--
--   +---------------+---------+
--   | Column Name   | Type    |
--   +---------------+---------+
--   | trans_id      | int     |
--   | account       | int     |
--   | amount        | int     |
--   | transacted_on | date    |
--   +---------------+---------+
--   trans_id is the primary key (column with unique values) for this table.
--   Each row of this table contains all changes made to all accounts.
--   amount is positive if the user received money and negative if they transferred money.
--   All accounts start with a balance of 0.

-- 1. Tính tổng số dư từng account
SELECT account, SUM(amount) AS balance
FROM Transactions
GROUP BY account;

-- 2. Kết nối (JOIN) kết quả với bảng Users để lấy tên người dùng
SELECT U.name, T.balance
FROM Users U
JOIN (
    SELECT account, SUM(amount) AS balance
    FROM Transactions
    GROUP BY account
) T
ON U.account = T.account

-- 3. Lọc những người có balance > 10000

WHERE T.balance > 10000;

-- Full SQL Solution
SELECT
    U.name,
    SUM(T.amount) AS balance
FROM
    Users U
JOIN
    Transactions T
ON
    U.account = T.account
GROUP BY
    U.account, U.name
HAVING
    balance > 10000;


