package Day3_031321;

public class ai1 {
    public static void main(String[] args) {
        String grade = "A";
        switch (grade) {
            case "A":
                System.out.println("Excellent");
                break;
            case "B":
                System.out.println("Well Done");
                break;
            case "C":
                System.out.println("Satisfactory");
                break;
            case "D":
                System.out.println("Passed");
                break;
            case "F":
                System.out.println("Failed");
                break;
            default:
                System.out.println("Invalid Grade");
        }
    }
}
