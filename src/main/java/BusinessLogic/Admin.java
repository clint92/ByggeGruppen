package BusinessLogic;

import javafx.scene.control.Alert;

public class Admin extends User {

    public void finishProject() {

    }

    public void createProject(String pName, String pAdress, int pZip, String pDescription, String pStartDate, String pEndDate, double pPrice) {
        db.updateDB("INSERT INTO Projects values('"+ pName +"','"+pAdress+"',"+pZip+",'"+pDescription+"','"+pStartDate+"','"+pEndDate+"',"+pPrice+")");
    }

    public void changeProject() {

    }
    public void deleteProject() {

    }
    public void sendToArchive() {

    }

    public void addToCalender() {

    }

    public void addProfile(String username, String password, int level, String firstName, String lastName, String address, int zip, String email, int number ) throws EmptyFieldException {

                db.updateDB("INSERT INTO Users(user_ID, userName, password, level)" + "values(user_ID,'" + username + "'," + "'" + sc.hashpw(password) + "'," + level + ");");
                db.updateDB("INSERT INTO UserInformation(UsersUserID, Name, LastName, Address, Zip, Email, MobilNr)" +
                        "values( LAST_INSERT_ID() " + ",'" + firstName + "','" + lastName + "','" + address + "'," + zip + ",'" + email + "'," + number + ");");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("System message");
                alert.setHeaderText("Succes!");
                alert.setContentText("Profile added");
                alert.showAndWait();
            }



    public void getProjectFromArchive() {

    }


}
