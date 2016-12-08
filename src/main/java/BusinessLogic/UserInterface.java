package BusinessLogic;

/**
 * Created by Julius on 08-12-2016.
 */
public interface UserInterface {
    void addToTimeline(Message message);
    void changeLogin(String userN, String pass1, String pass2);
}
