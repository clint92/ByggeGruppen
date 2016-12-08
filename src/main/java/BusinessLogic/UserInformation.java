package BusinessLogic;

/**
 * Created by Julius on 08-12-2016.
 */
public class UserInformation {
    //UserInfomation
    private String name;
    private String lName;
    private String address;
    private int zip;
    private String email;
    private int mobil;

    public UserInformation(String name, String lName, String address, int zip, String email, int mobil) {
        this.name = name;
        this.lName = lName;
        this.address = address;
        this.zip = zip;
        this.email = email;
        this.mobil = mobil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getMobil() {
        return mobil;
    }

    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    public String toString(){
            return "LAST_INSERT_ID(), '" + name + "', '"+ lName + "', '"+ address+"', " + zip+ ", '"+ email +"', " + mobil;
    }
}
