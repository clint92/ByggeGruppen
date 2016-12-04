package BusinessLogic;


import Database.MyDatabase;

public class Admin extends User {
    private int userid = 1;

    public int getUserid(){
        return this.userid;
    }

    public void setUserid(int id){
        this.userid = id;
    }

    public void finishProject() {
    }

    public void createProject() {

    }
    public void changeProject() {

    }
    public void deleteProject() {

    }
    public void sendToArchive() {

    }

    public void addToCalender() {

    }

    public void addProfile(String username, String password, int level) {


       // MyDatabase.dbInstance().updateDB("INSERT INTO Users = 'user_ID"+ username + sc.hashpw(password) + level);



    }
    public void getProjectFromArchive() {

    }


}
