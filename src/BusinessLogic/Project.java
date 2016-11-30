package BusinessLogic;


public interface Project {
    int getProjectID();

    String getName();

    String getAddress();

    int getZip();

    String getJobDescription();

    int getStartDate();

    int getEndDate();

    double getPrice();

    int getTimelineID();

    void setProjectName();

    void setAddress();

    void setZip();

    void setJobDescription();

    void setEndDate();

    void setPrice();

}
