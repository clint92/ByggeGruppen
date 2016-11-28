package BusinessLogic;

/**
 * Created by Jennes on 25-11-2016.
 */
public class Security implements SecutiryInterface {
    @Override
    public String hashpw(String pass) {
        int hash = 7;
        for (int i = 0; i < pass.length(); i++) {
            hash = hash*31 + pass.charAt(i);
        }
        return new String(hash + "");
        //http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
    }
}
