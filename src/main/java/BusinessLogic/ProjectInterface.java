package BusinessLogic;


import javafx.collections.ObservableList;

public interface ProjectInterface {
    String projectInformation(String st);
    ObservableList<String> getProjects();
    ObservableList<String> getAllProjects();
}
