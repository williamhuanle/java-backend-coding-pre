package BasicCoding;

public class TraverseMultidimensionalArrays {
    public static void main(String[] args) {
        String[][] building = {
                {"101 true", "102 false", "103 false"},
                {"201 true", "202 true", "203 false"}
        };

        // Traverse the building
        for (String[] floor : building) {
            for (String apt : floor) {
                String[] parts = apt.split(" ");
                String number = parts[0];
                boolean occupied = Boolean.parseBoolean(parts[1]);

                if (!occupied) {
                    System.out.println("Apartment " + number + " is not occupied.");
                    //break;
                }
            }
        }
    }
}
