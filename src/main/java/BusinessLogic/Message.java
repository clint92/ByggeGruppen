package BusinessLogic;

import Database.MyDatabase;

/**
 * Created by Julius on 07-12-2016.
 */
public class Message {
    private String timelineID;
    private String dateAndTime;
    private String description;
    private String picture = "null";
    private String firstName;
    MyDatabase db = MyDatabase.dbInstance();

    public Message(String tID, String dAT, String desc, String fN){
        this.timelineID = tID;
        this.dateAndTime = dAT;
        this.description = desc;
        this.picture = null;
        this.firstName = fN;
    }

    public void send(){
        String msg = description;
        int count = 0;
        if (msg.length() > 50) {
            msg = "";
            for (int i = 0; i < description.length(); i++) {
                if (count != 50) {
                    msg += description.substring(i, i + 1);
                } else {
                    msg += "\n";
                    count = 0;
                }
                count++;
            }
        }
        db.updateDB("INSERT INTO Timeline values('" + timelineID + "','" + dateAndTime + "', '" + msg + "',"+ picture +",'" + firstName + "');");
        InfoBox.info("Sendt!");
    }
}
