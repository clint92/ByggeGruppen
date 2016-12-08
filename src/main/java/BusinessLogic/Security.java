package BusinessLogic;

public class Security implements SecutiryInterface {
    public static String hashpw(String pass) {
        int hash = 7;
        for (int i = 0; i < pass.length(); i++) {
            hash = hash*31 + pass.charAt(i);
        }
        return hash + "";
        //http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
    }
}
