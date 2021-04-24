package Day2_030721;

public class DynamicLoop {
    public static void main(String[] args) {
        String[] zipCode, streetNumber;

        zipCode = new String[4];
        zipCode[0] = "11356";
        zipCode[1] = "11357";
        zipCode[2] = "11358";
        zipCode[3] = "11359";

        streetNumber = new String[4];
        streetNumber[0] = "115";
        streetNumber[1] = "117";
        streetNumber[2] = "119";
        streetNumber[3] = "120";

        for(int i = 0;i < zipCode.length;i++)

        System.out.println("My zip code is" + zipCode[i] + "My street number is" + streetNumber[i]);
    }
}
