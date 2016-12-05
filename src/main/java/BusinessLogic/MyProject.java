package BusinessLogic;


public class MyProject {
    private static String projectName;
    private static MyProject mp;


    private MyProject(String pName) {
        projectName = pName;
    }

    public static synchronized MyProject projectInstance(){
        if (mp == null) {
            mp = new MyProject(projectName);
        }
        return mp;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String pName){
        projectName = pName;
    }
    public String toString(){
        return projectName;
    }
}
