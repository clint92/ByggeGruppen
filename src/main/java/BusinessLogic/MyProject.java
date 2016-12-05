package BusinessLogic;


public class MyProject {
    private int projectID;
    private String projectName;

    public MyProject(int pID, String pName) {
        this.projectID = pID;
        this.projectName = pName;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectID() {
        return projectID;
    }

    public String toString(){
        return "" + projectID + projectName;
    }
}
