package BusinessLogic;

/**
 * Created by Jennes on 25-11-2016.
 */
public class Admin extends User {
    private int userid = 1;

    public void setUserid(int id){
        this.userid = id;
    }

    public int getUserid(){
        return this.userid;
    }
}
