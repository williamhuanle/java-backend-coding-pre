package BasicCoding;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        String[][] apartmentBuilding = {
                {"Apt 101", "Apt 102", "Apt 103"},
                {"Apt 201", "Apt 202", "Apt 203"},
                {"Apt 301", "Apt 302", "Apt 303"}
        };
        apartmentBuilding[1][1] = "Renovated Apt 202";
        for (int floor = 0; floor < apartmentBuilding.length; floor++) {
            for (int room = 0; room < apartmentBuilding[floor].length; room++) {
                System.out.print(apartmentBuilding[floor][room] + ", ");
            }
            System.out.println();  // Move to the next floor
        }
    }
}
